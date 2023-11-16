package com.axonivy.utils.decisioncomponent.demo.managedbean;

import org.apache.commons.lang3.StringUtils;

import com.axonivy.utils.decisioncomponent.demo.entities.TicketRequest;
import com.axonivy.utils.decisioncomponent.demo.enums.RequestApprovalDecision;

public class RequestTicketBean extends AbstractApprovalDecisionBean {

	private static final long serialVersionUID = 1L;

	private String validatorId;

	public RequestTicketBean(TicketRequest request) {
		init(request);
	}

	public void init(TicketRequest request) {
		this.validatorId = "decisionComponentValidator";

		initializeApprovalDecisionComponent(request.getApprovalHistories(),
				RequestApprovalDecision.getRequestApprovalDecision(), null);
	}

	@Override
	public String getDecisionLabel(String decisionName) {
		if (StringUtils.isBlank(decisionName)) {
			return "";
		}
		return RequestApprovalDecision.valueOf(decisionName).getCmsName();
	}

	public String getValidatorId() {
		return validatorId;
	}

	public void setValidatorId(String validatorId) {
		this.validatorId = validatorId;
	}
}
