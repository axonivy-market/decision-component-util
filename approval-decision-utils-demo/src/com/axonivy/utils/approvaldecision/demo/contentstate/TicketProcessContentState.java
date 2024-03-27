package com.axonivy.utils.approvaldecision.demo.contentstate;

import com.axonivy.utils.approvaldecision.contentstate.AbstractContentState;

public class TicketProcessContentState extends AbstractContentState {

	// information
	private boolean isTicketTitleReadOnly;
	private boolean isTicketNumberReadOnly;
	private boolean isTicketTypeReadOnly;
	private boolean isTicketRaiserReadOnly;
	private boolean isTicketDescriptionReadOnly;

	private boolean isTicketTitleRequired;
	private boolean isTicketNumberRequired;
	private boolean isTicketTypeRequired;
	private boolean isTicketRaiserRequired;
	private boolean isTicketDescriptionRequired;

	private boolean isShowDropdownOfMails;

	public void initRequestTicketContentState() {
		this.isDecisionRendered = true;
		this.isDecisionRequired = true;
		this.isDecisionDisable = false;
		this.isConfirmationVisible = false;
		this.isConfirmationRequired = false;
		this.isCommentRendered = true;
		this.isCommentRequired = true;
		this.isApprovalHistoryRendered = true;

		// information state
		this.isTicketTitleRequired = true;
		this.isTicketNumberRequired = true;
		this.isTicketTypeRequired = true;
		this.isTicketRaiserRequired = true;
		this.isTicketDescriptionRequired = true;

		this.isTicketTitleReadOnly = false;
		this.isTicketNumberReadOnly = false;
		this.isTicketTypeReadOnly = false;
		this.isTicketRaiserReadOnly = false;
		this.isTicketDescriptionReadOnly = false;
	}

	public void initReviewTicketContentState() {
		this.isDecisionRendered = true;
		this.isDecisionRequired = true;
		this.isDecisionDisable = false;
		this.isConfirmationVisible = false;
		this.isConfirmationRequired = false;
		this.isCommentRendered = true;
		this.isCommentRequired = true;
		this.isApprovalHistoryRendered = true;

		// information state
		this.isTicketTitleReadOnly = true;
		this.isTicketNumberReadOnly = true;
		this.isTicketTypeReadOnly = true;
		this.isTicketRaiserReadOnly = true;
		this.isTicketDescriptionReadOnly = true;
	}

	public void initConfirmTicketContentState() {
		this.isDecisionRendered = false;
		this.isDecisionRequired = false;
		this.isDecisionDisable = true;
		this.isConfirmationVisible = true;
		this.isConfirmationRequired = true;
		this.isCommentRendered = true;
		this.isCommentRequired = true;
		this.isApprovalHistoryRendered = true;

		// information state
		this.isTicketTitleReadOnly = true;
		this.isTicketNumberReadOnly = true;
		this.isTicketTypeReadOnly = true;
		this.isTicketRaiserReadOnly = true;
		this.isTicketDescriptionReadOnly = true;
	}

	public void initResultTicketContentState() {
		this.isDecisionRendered = false;
		this.isCommentRendered = false;
		this.isApprovalHistoryRendered = true;

		// information state
		this.isTicketTitleReadOnly = true;
		this.isTicketNumberReadOnly = true;
		this.isTicketTypeReadOnly = true;
		this.isTicketRaiserReadOnly = true;
		this.isTicketDescriptionReadOnly = true;
	}

	public boolean isTicketTitleReadOnly() {
		return isTicketTitleReadOnly;
	}

	public void setTicketTitleReadOnly(boolean isTicketTitleReadOnly) {
		this.isTicketTitleReadOnly = isTicketTitleReadOnly;
	}

	public boolean isTicketNumberReadOnly() {
		return isTicketNumberReadOnly;
	}

	public void setTicketNumberReadOnly(boolean isTicketNumberReadOnly) {
		this.isTicketNumberReadOnly = isTicketNumberReadOnly;
	}

	public boolean isTicketTypeReadOnly() {
		return isTicketTypeReadOnly;
	}

	public void setTicketTypeReadOnly(boolean isTicketTypeReadOnly) {
		this.isTicketTypeReadOnly = isTicketTypeReadOnly;
	}

	public boolean isTicketRaiserReadOnly() {
		return isTicketRaiserReadOnly;
	}

	public void setTicketRaiserReadOnly(boolean isTicketRaiserReadOnly) {
		this.isTicketRaiserReadOnly = isTicketRaiserReadOnly;
	}

	public boolean isTicketDescriptionReadOnly() {
		return isTicketDescriptionReadOnly;
	}

	public void setTicketDescriptionReadOnly(boolean isTicketDescriptionReadOnly) {
		this.isTicketDescriptionReadOnly = isTicketDescriptionReadOnly;
	}

	public boolean isTicketTitleRequired() {
		return isTicketTitleRequired;
	}

	public void setTicketTitleRequired(boolean isTicketTitleRequired) {
		this.isTicketTitleRequired = isTicketTitleRequired;
	}

	public boolean isTicketNumberRequired() {
		return isTicketNumberRequired;
	}

	public void setTicketNumberRequired(boolean isTicketNumberRequired) {
		this.isTicketNumberRequired = isTicketNumberRequired;
	}

	public boolean isTicketTypeRequired() {
		return isTicketTypeRequired;
	}

	public void setTicketTypeRequired(boolean isTicketTypeRequired) {
		this.isTicketTypeRequired = isTicketTypeRequired;
	}

	public boolean isTicketRaiserRequired() {
		return isTicketRaiserRequired;
	}

	public void setTicketRaiserRequired(boolean isTicketRaiserRequired) {
		this.isTicketRaiserRequired = isTicketRaiserRequired;
	}

	public boolean isTicketDescriptionRequired() {
		return isTicketDescriptionRequired;
	}

	public void setTicketDescriptionRequired(boolean isTicketDescriptionRequired) {
		this.isTicketDescriptionRequired = isTicketDescriptionRequired;
	}

	public boolean isShowDropdownOfMails() {
		return isShowDropdownOfMails;
	}

	public void setShowDropdownOfMails(boolean isShowDropdownOfMails) {
		this.isShowDropdownOfMails = isShowDropdownOfMails;
	}

}
