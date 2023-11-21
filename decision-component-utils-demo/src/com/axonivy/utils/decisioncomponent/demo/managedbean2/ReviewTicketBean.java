//package com.axonivy.utils.decisioncomponent.demo.managedbean2;
//
//import org.apache.commons.lang3.StringUtils;
//
//import com.axonivy.utils.decisioncomponent.demo.entities.TicketRequest;
//import com.axonivy.utils.decisioncomponent.demo.enums.RequestApprovalDecision;
//
//public class ReviewTicketBean extends AbstractTicketProcessBean {
//	
//	private static final long serialVersionUID = 1L;
//	
//	private String validatorId;
//	
//	public ReviewTicketBean(TicketRequest request) {
//		init(request);
//	}
//	
//	private void init(TicketRequest request) {
//		this.validatorId = "decisionComponentValidator";
//		initializeApprovalDecisionComponent(request.getApprovalHistories(),
//				RequestApprovalDecision.getReviewApprovalDecision(), null);
//	}
//	
//	@Override
//	public String getDecisionLabel(String decisionName) {
//		if (StringUtils.isBlank(decisionName)) {
//			return "";
//		}
//		return RequestApprovalDecision.valueOf(decisionName).getCmsName();
//	}
//	
//	public String getValidatorId() {
//		return validatorId;
//	}
//
//	public void setValidatorId(String validatorId) {
//		this.validatorId = validatorId;
//	}
//}
//
//// approval decision bean
//// RequestTicketApprovalDecisionBean extends AbstractApprovalDecisionBean
//// ReviewTicketApprovalDecisionBean extends AbstractApprovalDecisionBean
//
//// view/step bean
//// TicketProcessBean
//// - protected AbstractApprovalDecisionBean approvalDecisionBean
//// RequestTicketProcessBean extends TicketProcessBean
//// ReviewTicketProcessBean extends TicketProcessBean