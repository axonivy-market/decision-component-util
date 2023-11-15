package com.axonivy.utils.decisioncomponent.demo.managedbean;

import org.apache.commons.lang3.StringUtils;

import com.axonivy.utils.decisioncomponent.demo.entities.TicketRequest;
//import com.axonivy.utils.decisioncomponent.demo.enums.ApprovalDecisionOption;
//import com.ricoh.hr.core.enums.HRTicketRequestApprovalDecision;
import com.axonivy.utils.decisioncomponent.demo.enums.RequestApprovalDecision;


//@ManagedBean(name = "requestTicketDecisionBean")
//@ViewScoped
public class RequestTicketBean extends AbstractApprovalDecisionBean {

	private static final long serialVersionUID = 1L;
	
	
	//private ApprovalHistory approvalHistory;
	
	
	private String validatorId;
	
	
	public RequestTicketBean(TicketRequest request){
		
		init(request);
	}
	
	public void init(TicketRequest request) {
		//this.approvalHistory = new ApprovalHistory();
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
	
	
	
//	public ApprovalHistory getApprovalHistory() {
//		return approvalHistory;
//	}
//
//	public void setApprovalHistory(ApprovalHistory approvalHistory) {
//		this.approvalHistory = approvalHistory;
//	}

	public String getValidatorId() {
		return validatorId;
	}

	public void setValidatorId(String validatorId) {
		this.validatorId = validatorId;
	}
	
}
