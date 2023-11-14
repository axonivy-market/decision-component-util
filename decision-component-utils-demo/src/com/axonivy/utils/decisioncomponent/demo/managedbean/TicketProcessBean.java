package com.axonivy.utils.decisioncomponent.demo.managedbean;

import com.axonivy.utils.decisioncomponent.demo.entity.ApprovalHistory;
import com.axonivy.utils.decisioncomponent.demo.entity.Request;


public class TicketProcessBean {
	
	private Request request;
	private ApprovalHistory approvalHistory;
	
	private boolean decisionRendered;

	public TicketProcessBean() {
		init();
	}
	
	private void init() {
		request = new Request();
		approvalHistory = new ApprovalHistory();
	}
	
	
	
	public boolean isDecisionRendered() {
		return decisionRendered;
	}

	public void setDecisionRendered(boolean decisionRendered) {
		this.decisionRendered = decisionRendered;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public ApprovalHistory getApprovalHistory() {
		return approvalHistory;
	}

	public void setApprovalHistory(ApprovalHistory approvalHistory) {
		this.approvalHistory = approvalHistory;
	}
}
