package com.axonivy.utils.approvaldecision.demo.managedbean;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import com.axonivy.utils.approvaldecision.demo.contentstate.TicketProcessContentState;
import com.axonivy.utils.approvaldecision.demo.dao.TicketRequestDAO;
import com.axonivy.utils.approvaldecision.demo.entities.ApprovalHistory;
import com.axonivy.utils.approvaldecision.demo.entities.TicketRequest;
import com.axonivy.utils.approvaldecision.demo.enums.Department;
import com.axonivy.utils.approvaldecision.demo.enums.ProcessStep;
import com.axonivy.utils.approvaldecision.demo.enums.TicketProcessApprovalConfirmation;
import com.axonivy.utils.approvaldecision.demo.enums.TicketProcessApprovalDecision;
import com.axonivy.utils.approvaldecision.demo.utils.TicketProcessUtils;

import ch.ivyteam.ivy.environment.Ivy;

public class TicketProcessBean {

	private TicketRequest request;
	private TicketApprovalDecisionBean approvalDecisionBean;
	private TicketProcessContentState contentState;
	private Map<String, String> departmentMails;

	private ProcessStep processStep;

	public TicketProcessBean(ProcessStep processStep) {
		this.processStep = processStep;
		init();
	}

	private void init() {
		Long caseId = Ivy.wfCase().getId();
		request = TicketRequestDAO.getInstance().findByCaseId(caseId);

		if (request == null) {
			request = new TicketRequest();
			request.setCaseId(caseId);
			initTestRequestData();
		}

		contentState = new TicketProcessContentState();

		if (processStep == ProcessStep.REQUEST_TICKET) {
			approvalDecisionBean = new TicketApprovalDecisionBean(request,
					TicketProcessApprovalDecision.getRequestApprovalDecision(), null);
			contentState.initRequestTicketContentState();
			initForwardEmail();
			onChangeDecision();
		} else if (processStep == ProcessStep.REVIEW_TICKET) {
			approvalDecisionBean = new TicketApprovalDecisionBean(request,
					TicketProcessApprovalDecision.getReviewApprovalDecision(), null);
			contentState.initReviewTicketContentState();
		} else if (processStep == ProcessStep.CONFIRM_TICKET) {
			approvalDecisionBean = new TicketApprovalDecisionBean(request,
					TicketProcessApprovalDecision.getConfirmApprovalDecision(),
					TicketProcessApprovalConfirmation.getConfirmApprovalConfirmation());
			contentState.initConfirmTicketContentState();
		} else {
			approvalDecisionBean = new TicketApprovalDecisionBean(request, null, null);
			contentState.initResultTicketContentState();
		}
	}

	private void initTestRequestData() {
		request.setTicketTitle("Cinema Ticket");
		request.setTicketNumber("0329767343");
		request.setTicketType("Diamond");
		request.setTicketRaiser("Hero");
		request.setTicketDescription("hello world");
	}

	private void initForwardEmail() {
		this.departmentMails = new HashMap<>();
		for (Department department : Department.values()) {
			departmentMails.put(department.getName(), department.getEmail());
		}
	}

	private void handleSaving() {
		TicketRequest saved = TicketRequestDAO.getInstance().save(this.request);
		setRequest(saved);
		this.approvalDecisionBean.setApprovalHistory(this.request.getApprovalHistories().stream()
				.filter(p -> p.getIsEditing()).findFirst().orElse(new ApprovalHistory()));
	}

	public void save() {
		approvalDecisionBean.handleApprovalHistoryBeforeSave(this.request.getApprovalHistories());
		handleSaving();
		TicketProcessUtils.showInfo();
	}

	public void submit() {
		if (processStep == ProcessStep.CONFIRM_TICKET) {
			approvalDecisionBean.getApprovalHistory().setDecision(TicketProcessApprovalDecision.COMPLETE.toString());
		}

		approvalDecisionBean.handleApprovalHistoryBeforeSubmit(this.request.getApprovalHistories());
		handleSaving();
	}

	public void cancel() throws MalformedURLException {
		Ivy.wfTask().reset();
		TicketProcessUtils.navigateToHomePage();
	}

	public void onChangeDecision() {
		this.contentState.setShowDropdownOfMails(false);
		if (TicketProcessApprovalDecision.FORWARD_TO.name()
				.equals(this.approvalDecisionBean.getApprovalHistory().getDecision())) {
			this.contentState.setShowDropdownOfMails(true);
		}
	}

	public void onChangeConfirmation() {
		// implement listener for confirmation action
	}

	public TicketRequest getRequest() {
		return request;
	}

	public void setRequest(TicketRequest request) {
		this.request = request;
	}

	public TicketApprovalDecisionBean getApprovalDecisionBean() {
		return approvalDecisionBean;
	}

	public void setApprovalDecisionBean(TicketApprovalDecisionBean approvalDecisionBean) {
		this.approvalDecisionBean = approvalDecisionBean;
	}

	public TicketProcessContentState getContentState() {
		return contentState;
	}

	public void setContentState(TicketProcessContentState contentState) {
		this.contentState = contentState;
	}

	public Map<String, String> getDepartmentMails() {
		return departmentMails;
	}

	public void setDepartmentMails(Map<String, String> departmentMails) {
		this.departmentMails = departmentMails;
	}

}
