package com.axonivy.utils.decisioncomponent.demo.contentstate;


public class TicketProcessContentState extends AbstractContentState {
	
	// information
	private boolean ticketTitleReadOnly;
	private boolean	ticketNumberReadOnly;
	private boolean	ticketTypeReadOnly;
	private boolean	ticketRaiserReadOnly;
	private boolean	ticketDescriptionReadOnly;
	
	private boolean ticketTitleRequired;
	private boolean	ticketNumberRequired;
	private boolean	ticketTypeRequired;
	private boolean	ticketRaiserRequired;
	private boolean	ticketDescriptionRequired;
	
	private boolean showDropdownOfMails;
	
	
	public void initRequestTicketContentState(){
		this.decisionRendered = true;
		this.decisionRequired = true;
		this.decisionDisable = false;
		this.confirmationVisible = false;
		this.confirmationRequired = false;
		this.commentRendered = true;
		this.commentRequired = true;
		this.approvalHistoryRendered = true;
		
		// information state
		this.ticketTitleRequired = true;
		this.ticketNumberRequired = true;
		this.ticketTypeRequired = true;
		this.ticketRaiserRequired = true;
		this.ticketDescriptionRequired = true;
		
		this.ticketTitleReadOnly = false;
		this.ticketNumberReadOnly = false;
		this.ticketTypeReadOnly = false;
		this.ticketRaiserReadOnly = false;
		this.ticketDescriptionReadOnly = false;
	}
	
	public void initReviewTicketContentState(){
		this.decisionRendered = true;
		this.decisionRequired = true;
		this.decisionDisable = false;
		this.confirmationVisible = false;
		this.confirmationRequired = false;
		this.commentRendered = true;
		this.commentRequired = true;
		this.approvalHistoryRendered = true;
		
		// information state
		this.ticketTitleReadOnly = true;
		this.ticketNumberReadOnly = true;
		this.ticketTypeReadOnly = true;
		this.ticketRaiserReadOnly = true;
		this.ticketDescriptionReadOnly = true;
	}

	public void initConfirmTicketContentState(){
		this.decisionRendered = false;
		this.decisionRequired = false;
		this.decisionDisable = true;
		this.confirmationVisible = true;
		this.confirmationRequired = true;
		this.commentRendered = true;
		this.commentRequired = true;
		this.approvalHistoryRendered = true;
		
		// information state
		this.ticketTitleReadOnly = true;
		this.ticketNumberReadOnly = true;
		this.ticketTypeReadOnly = true;
		this.ticketRaiserReadOnly = true;
		this.ticketDescriptionReadOnly = true;
	}
	
	
	public void initResultTicketContentState() {
		this.decisionRendered = false;
		this.commentRendered = false;
		this.approvalHistoryRendered = true;
		
		// information state
		this.ticketTitleReadOnly = true;
		this.ticketNumberReadOnly = true;
		this.ticketTypeReadOnly = true;
		this.ticketRaiserReadOnly = true;
		this.ticketDescriptionReadOnly = true;
	}
	
	public boolean isShowDropdownOfMails() {
		return showDropdownOfMails;
	}

	public void setShowDropdownOfMails(boolean showDropdownOfMails) {
		this.showDropdownOfMails = showDropdownOfMails;
	}

	public boolean isTicketTitleReadOnly() {
		return ticketTitleReadOnly;
	}

	public void setTicketTitleReadOnly(boolean ticketTitleReadOnly) {
		this.ticketTitleReadOnly = ticketTitleReadOnly;
	}

	public boolean isTicketNumberReadOnly() {
		return ticketNumberReadOnly;
	}

	public void setTicketNumberReadOnly(boolean ticketNumberReadOnly) {
		this.ticketNumberReadOnly = ticketNumberReadOnly;
	}

	public boolean isTicketTypeReadOnly() {
		return ticketTypeReadOnly;
	}

	public void setTicketTypeReadOnly(boolean ticketTypeReadOnly) {
		this.ticketTypeReadOnly = ticketTypeReadOnly;
	}

	public boolean isTicketRaiserReadOnly() {
		return ticketRaiserReadOnly;
	}

	public void setTicketRaiserReadOnly(boolean ticketRaiserReadOnly) {
		this.ticketRaiserReadOnly = ticketRaiserReadOnly;
	}

	public boolean isTicketDescriptionReadOnly() {
		return ticketDescriptionReadOnly;
	}

	public void setTicketDescriptionReadOnly(boolean ticketDescriptionReadOnly) {
		this.ticketDescriptionReadOnly = ticketDescriptionReadOnly;
	}

	public boolean isTicketTitleRequired() {
		return ticketTitleRequired;
	}

	public void setTicketTitleRequired(boolean ticketTitleRequired) {
		this.ticketTitleRequired = ticketTitleRequired;
	}

	public boolean isTicketNumberRequired() {
		return ticketNumberRequired;
	}

	public void setTicketNumberRequired(boolean ticketNumberRequired) {
		this.ticketNumberRequired = ticketNumberRequired;
	}

	public boolean isTicketTypeRequired() {
		return ticketTypeRequired;
	}

	public void setTicketTypeRequired(boolean ticketTypeRequired) {
		this.ticketTypeRequired = ticketTypeRequired;
	}

	public boolean isTicketRaiserRequired() {
		return ticketRaiserRequired;
	}

	public void setTicketRaiserRequired(boolean ticketRaiserRequired) {
		this.ticketRaiserRequired = ticketRaiserRequired;
	}

	public boolean isTicketDescriptionRequired() {
		return ticketDescriptionRequired;
	}

	public void setTicketDescriptionRequired(boolean ticketDescriptionRequired) {
		this.ticketDescriptionRequired = ticketDescriptionRequired;
	}

}
