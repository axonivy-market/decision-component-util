package com.axonivy.utils.approvaldecision.contentstate;

public abstract class AbstractContentState {

	protected boolean isDecisionRendered;
	protected boolean isDecisionRequired;
	protected boolean isDecisionDisable;
	protected boolean isConfirmationRequired;
	protected boolean isConfirmationVisible;
	protected boolean isCommentRendered;
	protected boolean isCommentRequired;
	protected boolean isApprovalHistoryRendered;

	public boolean isDecisionRendered() {
		return isDecisionRendered;
	}

	public void setDecisionRendered(boolean isDecisionRendered) {
		this.isDecisionRendered = isDecisionRendered;
	}

	public boolean isDecisionRequired() {
		return isDecisionRequired;
	}

	public void setDecisionRequired(boolean isDecisionRequired) {
		this.isDecisionRequired = isDecisionRequired;
	}

	public boolean isDecisionDisable() {
		return isDecisionDisable;
	}

	public void setDecisionDisable(boolean isDecisionDisable) {
		this.isDecisionDisable = isDecisionDisable;
	}

	public boolean isConfirmationRequired() {
		return isConfirmationRequired;
	}

	public void setConfirmationRequired(boolean isConfirmationRequired) {
		this.isConfirmationRequired = isConfirmationRequired;
	}

	public boolean isConfirmationVisible() {
		return isConfirmationVisible;
	}

	public void setConfirmationVisible(boolean isConfirmationVisible) {
		this.isConfirmationVisible = isConfirmationVisible;
	}

	public boolean isCommentRendered() {
		return isCommentRendered;
	}

	public void setCommentRendered(boolean isCommentRendered) {
		this.isCommentRendered = isCommentRendered;
	}

	public boolean isCommentRequired() {
		return isCommentRequired;
	}

	public void setCommentRequired(boolean isCommentRequired) {
		this.isCommentRequired = isCommentRequired;
	}

	public boolean isApprovalHistoryRendered() {
		return isApprovalHistoryRendered;
	}

	public void setApprovalHistoryRendered(boolean isApprovalHistoryRendered) {
		this.isApprovalHistoryRendered = isApprovalHistoryRendered;
	}

}