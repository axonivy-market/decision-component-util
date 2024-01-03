package com.axonivy.utils.decisioncomponent.demo.enums;

import java.util.ArrayList;
import java.util.List;

import com.axonivy.utils.decisioncomponent.enums.HasCmsName;


public enum TicketProcessApprovalDecision implements HasCmsName {
	SEND_TO_REVIEWER,
	FORWARD_TO,
	CANCEL,
	
	RETURN_BACK_TO_REQUESTER,
	APPROVE,
	REJECT,
	
	COMPLETE;
	
	public static List<Enum<?>> getRequestApprovalDecision() {
		List<Enum<?>> approvalDecisions = new ArrayList<>();
		approvalDecisions.add(SEND_TO_REVIEWER);
		approvalDecisions.add(FORWARD_TO);
		approvalDecisions.add(CANCEL);

		return approvalDecisions;
	}
	
	public static List<Enum<?>> getReviewApprovalDecision() {
		List<Enum<?>> approvalDecisions = new ArrayList<>();
		approvalDecisions.add(RETURN_BACK_TO_REQUESTER);
		approvalDecisions.add(APPROVE);
		approvalDecisions.add(REJECT);
		return approvalDecisions;
	}
	
	public static List<Enum<?>> getConfirmApprovalDecision() {
		List<Enum<?>> approvalDecisions = new ArrayList<>();
		approvalDecisions.add(COMPLETE);
		return approvalDecisions;
	}
}
