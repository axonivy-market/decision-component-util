package com.axonivy.utils.decisioncomponent.demo.managedbean;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.axonivy.utils.decisioncomponent.demo.entities.ApprovalHistory;
import com.axonivy.utils.decisioncomponent.demo.entities.TicketRequest;
import com.axonivy.utils.decisioncomponent.demo.enums.TicketProcessApprovalConfirmation;
import com.axonivy.utils.decisioncomponent.demo.enums.TicketProcessApprovalDecision;

public class TicketApprovalDecisionBean extends AbstractApprovalDecisionBean {

	private static final long serialVersionUID = 1L;

	private String validatorId;

	public TicketApprovalDecisionBean(TicketRequest request, List<Enum<?>> approvalDecisions, List<Enum<?>> confirmations) {
		init(request, approvalDecisions, confirmations);
	}

	public void init(TicketRequest request, List<Enum<?>> approvalDecisions, List<Enum<?>> confirmations) {
		this.validatorId = "decisionComponentValidator";
		initializeApprovalDecisionComponent(request.getApprovalHistories(), approvalDecisions, confirmations);
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
	
	public void saveApprovalHistories(List<ApprovalHistory> approvalHistories) {
		handleApprovalHistoryBeforeSave(approvalHistories);
	}
	
	public void submitApprovalHistories(List<ApprovalHistory> approvalHistories) {
		handleApprovalHistoryBeforeSubmit(approvalHistories);
	}

	public String getValidatorId() {
		return validatorId;
	}

	public void setValidatorId(String validatorId) {
		this.validatorId = validatorId;
	}
}
