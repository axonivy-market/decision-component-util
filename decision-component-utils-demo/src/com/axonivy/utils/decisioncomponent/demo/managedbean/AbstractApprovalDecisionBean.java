package com.axonivy.utils.decisioncomponent.demo.managedbean;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.SortMeta;

import com.axonivy.utils.decisioncomponent.demo.entities.ApprovalHistory;
import com.axonivy.utils.decisioncomponent.demo.enums.ApprovalDecisionOption;
import com.axonivy.utils.decisioncomponent.managedbean.UserUtilBean;
import com.axonivy.utils.decisioncomponent.utils.DateUtils;
import com.axonivy.utils.decisioncomponent.utils.SortFieldUtils;

import ch.ivyteam.ivy.security.ISecurityContext;
import ch.ivyteam.ivy.security.IUser;

public class AbstractApprovalDecisionBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ApprovalHistory approvalHistory = new ApprovalHistory();
	private List<Enum<?>> decisions = new ArrayList<>();
	private List<Enum<?>> confirmations = new ArrayList<>();
	private List<Enum<?>> selectedConfirmations = new ArrayList<>();
	private List<ApprovalHistory> approvalHistories = new ArrayList<>();
	private SortMeta defaultSortField;

	private UserUtilBean userUtilBean;

	/**
	 * Get decision name from an enum. We use enum ApprovalDecisionOption by
	 * default. If you use other enum, override this method
	 *
	 * @param decisionName
	 * @return decision label
	 */
	public String getDecisionLabel(String decisionName) {
		if (StringUtils.isBlank(decisionName)) {
			return "";
		}
		return ApprovalDecisionOption.valueOf(decisionName).getCmsName();
	}

	/**
	 * Get confirmation text from an enum. If you don't implement confirmation part,
	 * return null.
	 *
	 * @param confirmationName
	 * @return confirmation text
	 */
	public String getConfirmationLabel(String confirmationName) {
		return null;
	}

	/**
	 * Handle confirmation before save. By default, we save name list of selected
	 * confirmation. Please modify it if needed.
	 *
	 */
	public void handleConfirmation() {
		approvalHistory.setSelectedConfirmations(
				String.join(",", selectedConfirmations.stream().map(Enum::name).toList()).trim());
	}

	/**
	 * Initialize editing approval history and show old approval histories.
	 *
	 */
	public void initializeApprovalDecisionComponent(List<ApprovalHistory> histories, List<Enum<?>> decisions,
			List<Enum<?>> confirmations) {
		setDecisions(decisions);
		setConfirmations(confirmations);
		initApprovalHistories(histories);
		initSelectedConfirmations();
	}
	
//	private void initApprovalHistories(List<ApprovalHistory> histories) {
//		if (CollectionUtils.isEmpty(histories)) {
//			histories = new ArrayList<>();
//		}
//
//		setApprovalHistories(histories.stream().filter(p -> !p.getIsEditting())
//				.sorted(Comparator.comparing(ApprovalHistory::getApprovalDate).reversed())
//				.collect(Collectors.toList()));
//		setApprovalHistory(histories.stream().filter(p -> p.getIsEditting()).findFirst().orElse(new ApprovalHistory()));
//
//		if (userUtilBean == null) {
//			userUtilBean = FacesContexts.evaluateValueExpression("#{userUtilBean}", UserUtilBean.class);
//		}
//		getApprovalHistories().forEach(history -> {
//			history.setDisplayUserName(userUtilBean.getFullName(history.getHeader().getModifiedByUserName()));
//			history.setDisplayApprovalDate(DateUtils.getFormattedDateTime(history.getApprovalDate()));
//			history.setSortableApprovalDate(DateUtils.getSortableFormattedDateTime(history.getApprovalDate()));
//		});
//
//		initDefaultSortField();
//	}

	private void initApprovalHistories(List<ApprovalHistory> histories) {
		if (CollectionUtils.isEmpty(histories)) {
			histories = new ArrayList<>();
		}

		setApprovalHistories(histories.stream().filter(p -> !p.getIsEditing())
				.sorted(Comparator.comparing(ApprovalHistory::getApprovalDate).reversed())
				.collect(Collectors.toList()));
		setApprovalHistory(histories.stream().filter(p -> p.getIsEditing()).findFirst().orElse(new ApprovalHistory()));

//		if (userUtilBean == null) {
//			userUtilBean = FacesContexts.evaluateValueExpression("#{userUtilBean}", UserUtilBean.class);
//		}
//		
		getApprovalHistories().forEach(history -> {
			history.setDisplayUserName(history.getHeader().getModifiedByUserName());
			history.setDisplayApprovalDate(DateUtils.getFormattedDateTime(history.getApprovalDate()));
			//history.setSortableApprovalDate(DateUtils.getSortableFormattedDateTime(history.getApprovalDate()));
			
			
		});

		initDefaultSortField();
	}

	public boolean isApprovalHistoryTableSortDescending() {
		return true;
	}

	public String getApprovalHistoryTableSortField() {
		return "sortableApprovalDate";
	}

	public void initDefaultSortField() {
		setDefaultSortField(
				SortFieldUtils.buildSortMeta(getApprovalHistoryTableSortField(),
						isApprovalHistoryTableSortDescending()));
	}

	private void initSelectedConfirmations() {
		if (StringUtils.isNotBlank(approvalHistory.getSelectedConfirmations())
				&& CollectionUtils.isNotEmpty(confirmations)) {
			for (String selectedConfirmationName : approvalHistory.getSelectedConfirmations().split(",")) {
				Enum<?> confirmation = confirmations.stream()
						.filter(c -> c.name().contentEquals(selectedConfirmationName.trim())).findFirst().orElse(null);
				if (confirmation != null) {
					selectedConfirmations.add(confirmation);
				}
			}
		}
	}

	protected void handleBeforeSave(List<ApprovalHistory> histories) {
		if (CollectionUtils.isNotEmpty(confirmations)) {
			handleConfirmation();
		}

		histories.clear();
		histories.addAll(getApprovalHistories());
		if (StringUtils.isNotBlank(approvalHistory.getDecision())
				|| StringUtils.isNotBlank(approvalHistory.getComment())
				|| StringUtils.isNotBlank(approvalHistory.getSelectedConfirmations())) {
			approvalHistory.setApprovalDate(LocalDateTime.now());
			histories.add(approvalHistory);
		}
	}

	/**
	 * Handle decision and confirmation stuffs before save.
	 *
	 */
	public void handleApprovalHistoryBeforeSave(List<ApprovalHistory> histories) {
		approvalHistory.setIsEditing(true);
		handleBeforeSave(histories);
	}

	/**
	 * Handle decision and confirmation stuffs before submit.
	 *
	 */
	public void handleApprovalHistoryBeforeSubmit(List<ApprovalHistory> histories) {
		approvalHistory.setIsEditing(false);
		handleBeforeSave(histories);
	}

	/**
	 * Get display name of an Ivy user by username
	 *
	 * @param username
	 * @return display name of Ivy user
	 */
	public String getDisplayName(String username) {
		if (StringUtils.isBlank(username)) {
			return "";
		}
		return Optional.ofNullable(ISecurityContext.current().users().findById(username)).map(IUser::getDisplayName)
				.orElse(username);
	}

	public ApprovalHistory getApprovalHistory() {
		return approvalHistory;
	}

	public void setApprovalHistory(ApprovalHistory approvalHistory) {
		this.approvalHistory = approvalHistory;
	}

	public List<Enum<?>> getDecisions() {
		return decisions;
	}

	public void setDecisions(List<Enum<?>> decisions) {
		this.decisions = decisions;
	}

	public List<Enum<?>> getConfirmations() {
		return confirmations;
	}

	public void setConfirmations(List<Enum<?>> confirmations) {
		this.confirmations = confirmations;
	}

	public List<Enum<?>> getSelectedConfirmations() {
		return selectedConfirmations;
	}

	public void setSelectedConfirmations(List<Enum<?>> selectedConfirmations) {
		this.selectedConfirmations = selectedConfirmations;
	}

	public List<ApprovalHistory> getApprovalHistories() {
		return approvalHistories;
	}

	public void setApprovalHistories(List<ApprovalHistory> approvalHistories) {
		this.approvalHistories = approvalHistories;
	}

	public SortMeta getDefaultSortField() {
		return defaultSortField;
	}

	public void setDefaultSortField(SortMeta defaultSortField) {
		this.defaultSortField = defaultSortField;
	}

	public UserUtilBean getUserUtilBean() {
		return userUtilBean;
	}

	public void setUserUtilBean(UserUtilBean userUtilBean) {
		this.userUtilBean = userUtilBean;
	}
	

}