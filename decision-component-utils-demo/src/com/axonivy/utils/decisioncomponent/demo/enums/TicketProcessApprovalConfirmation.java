package com.axonivy.utils.decisioncomponent.demo.enums;

import java.util.ArrayList;
import java.util.List;

public enum TicketProcessApprovalConfirmation implements HasCmsName {
	PAYROLL,
	MANAGER;
	
	public static List<Enum<?>> getConfirmApprovalConfirmations() {
		List<Enum<?>> approvalConfirmations = new ArrayList<>();
		approvalConfirmations.add(PAYROLL);
		approvalConfirmations.add(MANAGER);
		return approvalConfirmations;
	}
}
