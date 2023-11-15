package com.axonivy.utils.decisioncomponent.demo.managedbean;

import com.axonivy.utils.decisioncomponent.demo.entity.TicketRequest;


public class TicketProcessBean {
	
	private TicketRequest request;
	
	private RequestTicketBean requestTicketDecisionBean;
	
	private boolean decisionRendered;
	private boolean commentRendered;
	private boolean approvalHistoryRendered;

	public TicketProcessBean() {
		init();
	}
	
	private void init() {
		request = new TicketRequest();
		
		this.decisionRendered = true;
		this.commentRendered = true;
		this.approvalHistoryRendered = true;
		
		
		requestTicketDecisionBean = new RequestTicketBean(request);
	}
	
	
	
	public boolean getDecisionRendered() {
		return decisionRendered;
	}

	public void setDecisionRendered(boolean decisionRendered) {
		this.decisionRendered = decisionRendered;
	}

	public TicketRequest getRequest() {
		return request;
	}

	public void setRequest(TicketRequest request) {
		this.request = request;
	}

	public RequestTicketBean getRequestTicketDecisionBean() {
		return requestTicketDecisionBean;
	}

	public void setRequestTicketDecisionBean(RequestTicketBean requestTicketDecisionBean) {
		this.requestTicketDecisionBean = requestTicketDecisionBean;
	}

	public boolean isCommentRendered() {
		return commentRendered;
	}

	public void setCommentRendered(boolean commentRendered) {
		this.commentRendered = commentRendered;
	}

	public boolean isApprovalHistoryRendered() {
		return approvalHistoryRendered;
	}

	public void setApprovalHistoryRendered(boolean approvalHistoryRendered) {
		this.approvalHistoryRendered = approvalHistoryRendered;
	}

}
