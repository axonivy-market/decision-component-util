package com.axonivy.utils.decisioncomponent.demo.managedbean;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import com.axonivy.utils.decisioncomponent.demo.contentstate.TicketProcessContentState;
import com.axonivy.utils.decisioncomponent.demo.dao.TicketRequestDAO;
import com.axonivy.utils.decisioncomponent.demo.entities.TicketRequest;
import com.axonivy.utils.decisioncomponent.demo.enums.Department;
import com.axonivy.utils.decisioncomponent.demo.enums.ProcessStep;
import com.axonivy.utils.decisioncomponent.demo.enums.RequestApprovalDecision;
import com.axonivy.utils.decisioncomponent.demo.utils.TicketProcessUtils;

import ch.ivyteam.ivy.environment.Ivy;







/*
 * 
 * this class will be move
 * 
 */


public class TicketProcessBean {
	
	private TicketRequest request;
	private AbstractApprovalDecisionBean approvalDecisionBean;
	private boolean decisionRendered;
	private boolean commentRendered;
	private boolean approvalHistoryRendered;
	
	private TicketProcessContentState contentState;
	
	
	private Map<Department, String> departmentMails;
	private Boolean showDropdownOfMails = false;
	

	public TicketProcessBean(ProcessStep processStep) {
		init(processStep);
	}
	
	private void init(ProcessStep processStep) {
		Long caseId = Ivy.wfCase().getId();
		request = TicketRequestDAO.getInstance().findByCaseId(caseId);
		
		if(request == null) {
			request = new TicketRequest();
			request.setCaseId(caseId);
		}
		
		this.decisionRendered = true;
		this.commentRendered = true;
		this.approvalHistoryRendered = true;
		
		if(processStep == ProcessStep.REQUEST_TICKET) {
			approvalDecisionBean = new RequestTicketBean(request);
			initForwardEmail();
		}else {
			approvalDecisionBean = new ReviewTicketBean(request);
		}
	}
	
	private void initForwardEmail() {
		this.departmentMails = new HashMap<>();
		for(Department department : Department.values()) {
			departmentMails.put(department, department.getEmail());
			
		}
	}
	
	public void submit() {
		approvalDecisionBean.handleApprovalHistoryBeforeSubmit(this.request.getApprovalHistories());
		TicketRequestDAO.getInstance().save(request);
	}
	
	public void save() {
		approvalDecisionBean.handleApprovalHistoryBeforeSave(this.request.getApprovalHistories());
		this.request = TicketRequestDAO.getInstance().save(request);
		TicketProcessUtils.showInfo();
	}
	
	public void cancel() throws MalformedURLException {
		TicketProcessUtils.navigateToHomePage();
	}
	
	
	
	public void onChangeDecision(){
		this.showDropdownOfMails = false;
		if(RequestApprovalDecision.FORWARD_TO.name().equals(this.approvalDecisionBean.getApprovalHistory().getDecision())) {
			this.showDropdownOfMails = true;
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

	public TicketProcessContentState getContentState() {
		return contentState;
	}

	public void setContentState(TicketProcessContentState contentState) {
		this.contentState = contentState;
	}
	
	public Boolean getShowDropdownOfMails() {
		return showDropdownOfMails;
	}

	public void setShowDropdownOfMails(Boolean showDropdownOfMails) {
		this.showDropdownOfMails = showDropdownOfMails;
	}

	public Map<Department, String> getDepartmentMails() {
		return departmentMails;
	}

	public void setDepartmentMails(Map<Department, String> departmentMails) {
		this.departmentMails = departmentMails;
	}
	
	
}
