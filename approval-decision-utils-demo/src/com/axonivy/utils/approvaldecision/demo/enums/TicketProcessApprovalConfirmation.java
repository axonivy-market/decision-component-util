package com.axonivy.utils.approvaldecision.demo.enums;

import java.util.ArrayList;
import java.util.List;

import com.axonivy.utils.approvaldecision.enums.HasCmsName;

public enum TicketProcessApprovalConfirmation implements HasCmsName {
	PAYROLL, MANAGER;

	public static List<Enum<?>> getConfirmApprovalConfirmation() {
		List<Enum<?>> approvalConfirmations = new ArrayList<>();
		approvalConfirmations.add(PAYROLL);
		approvalConfirmations.add(MANAGER);
		return approvalConfirmations;
	}
}
