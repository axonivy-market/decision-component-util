package com.axonivy.utils.decisioncomponent.demo.managedbean;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.axonivy.utils.decisioncomponent.demo.entities.TicketRequest;
import com.axonivy.utils.decisioncomponent.demo.enums.TicketProcessApprovalConfirmation;
import com.axonivy.utils.decisioncomponent.demo.enums.TicketProcessApprovalDecision;


public class TicketApprovalDecisionBean extends AbstractApprovalDecisionBean {

	private static final long serialVersionUID = 1L;

	private String validatorId;
	
	
	//private TicketRequest request;
	
	

	public TicketApprovalDecisionBean(TicketRequest request, List<Enum<?>> decisions, List<Enum<?>> confirmations) {
		//this.request = request;
		init(request, decisions, confirmations);
	}

	private void init(TicketRequest request, List<Enum<?>> decisions, List<Enum<?>> confirmations) {
		this.validatorId = "decisionComponentValidator";
		initializeApprovalDecisionComponent(request.getApprovalHistories(), decisions, confirmations);
	}

	@Override
	public String getDecisionLabel(String decisionName) {
		if (StringUtils.isBlank(decisionName)) {
			return "";
		}
		return TicketProcessApprovalDecision.valueOf(decisionName).getCmsName();
	}
	
	@Override
	public String getConfirmationLabel(String confirmationName) {
		if (StringUtils.isBlank(confirmationName)) {
			return "";
		}
		return TicketProcessApprovalConfirmation.valueOf(confirmationName).getCmsName();
	}

	public String getValidatorId() {
		return validatorId;
	}

	public void setValidatorId(String validatorId) {
		this.validatorId = validatorId;
	}
	
	
//	public void saveApprovalHistories() {
//		handleApprovalHistoryBeforeSave(this.request.getApprovalHistories());
//	}
//
//	public void submitApprovalHistories() {
//		handleApprovalHistoryBeforeSubmit(this.request.getApprovalHistories());
//	}
	
//	@Override
//	protected void handleBeforeSave(List<ApprovalHistory> histories) {	
//		ApprovalHistory approvalHistory = getApprovalHistory();
//		List<Enum<?>> confirmations = getConfirmations();
//		if (CollectionUtils.isNotEmpty(confirmations)) {
//			handleConfirmation();
//		}
//		histories.clear();
//		histories.addAll(getApprovalHistories());
//		approvalHistory.setApprovalDate(LocalDateTime.now());
//		histories.add(approvalHistory);
//	}
	
}
