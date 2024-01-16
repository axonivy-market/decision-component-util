package com.axonivy.utils.decisioncomponent.contentstate;

public abstract class AbstractContentState {

	protected boolean decisionRendered;
	protected boolean decisionRequired;
	protected boolean decisionDisable;
	protected boolean confirmationRequired;
	protected boolean confirmationVisible;
	protected boolean commentRendered;
	protected boolean commentRequired;
	protected boolean approvalHistoryRendered;

	public boolean isDecisionRendered() {
		return decisionRendered;
	}

	public void setDecisionRendered(boolean decisionRendered) {
		this.decisionRendered = decisionRendered;
	}

	public boolean isDecisionRequired() {
		return decisionRequired;
	}

	public void setDecisionRequired(boolean decisionRequired) {
		this.decisionRequired = decisionRequired;
	}

	public boolean isDecisionDisable() {
		return decisionDisable;
	}

	public void setDecisionDisable(boolean decisionDisable) {
		this.decisionDisable = decisionDisable;
	}

	public boolean isConfirmationRequired() {
		return confirmationRequired;
	}

	public void setConfirmationRequired(boolean confirmationRequired) {
		this.confirmationRequired = confirmationRequired;
	}

	public boolean isConfirmationVisible() {
		return confirmationVisible;
	}

	public void setConfirmationVisible(boolean confirmationVisible) {
		this.confirmationVisible = confirmationVisible;
	}

	public boolean isCommentRendered() {
		return commentRendered;
	}

	public void setCommentRendered(boolean commentRendered) {
		this.commentRendered = commentRendered;
	}

	public boolean isCommentRequired() {
		return commentRequired;
	}

	public void setCommentRequired(boolean commentRequired) {
		this.commentRequired = commentRequired;
	}

	public boolean isApprovalHistoryRendered() {
		return approvalHistoryRendered;
	}

	public void setApprovalHistoryRendered(boolean approvalHistoryRendered) {
		this.approvalHistoryRendered = approvalHistoryRendered;
	}

}