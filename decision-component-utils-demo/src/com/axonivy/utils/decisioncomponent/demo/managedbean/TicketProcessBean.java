package com.axonivy.utils.decisioncomponent.demo.managedbean;

import com.axonivy.utils.decisioncomponent.demo.entities.TicketRequest;
import com.axonivy.utils.decisioncomponent.demo.enums.ProcessStep;


public class TicketProcessBean {
	
	private TicketRequest request;
	
	//private RequestTicketBean requestTicketDecisionBean;
	
	
	private AbstractApprovalDecisionBean approvalDecisionBean;
	
	private boolean decisionRendered;
	private boolean commentRendered;
	private boolean approvalHistoryRendered;

	public TicketProcessBean(ProcessStep processStep) {
		init(processStep);
	}
	
	private void init(ProcessStep processStep) {
		request = new TicketRequest();
		
		this.decisionRendered = true;
		this.commentRendered = true;
		this.approvalHistoryRendered = true;
		
		if(processStep == ProcessStep.REQUEST_TICKET) {
			approvalDecisionBean = new RequestTicketBean(request);
		}else {
			approvalDecisionBean = new ReviewTicketBean(request);
		}
		
		
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

//	public RequestTicketBean getRequestTicketDecisionBean() {
//		return requestTicketDecisionBean;
//	}
//
//	public void setRequestTicketDecisionBean(RequestTicketBean requestTicketDecisionBean) {
//		this.requestTicketDecisionBean = requestTicketDecisionBean;
//	}
	
	

	public boolean isCommentRendered() {
		return commentRendered;
	}

	public AbstractApprovalDecisionBean getApprovalDecisionBean() {
		return approvalDecisionBean;
	}

	public void setApprovalDecisionBean(AbstractApprovalDecisionBean approvalDecisionBean) {
		this.approvalDecisionBean = approvalDecisionBean;
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
