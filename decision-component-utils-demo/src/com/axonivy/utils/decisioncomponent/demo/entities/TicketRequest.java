package com.axonivy.utils.decisioncomponent.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.axonivy.utils.decisioncomponent.entities.BaseRequest;

@Entity
@Table(name="TicketRequest")
public class TicketRequest extends BaseRequest  {

	private static final long serialVersionUID = 1L;
	
	@Column
	private Long caseId;
	
	@Column
	private String ticketTitle;
	
	@Column
	private String ticketNumber;
	
	@Column
	private String ticketType;
	
	@Column
	private String ticketRaiser;
	
	@Column
	private String ticketDescription;
	
	public Long getCaseId() {
		return caseId;
	}
	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}
	public String getTicketTitle() {
		return ticketTitle;
	}
	public void setTicketTitle(String ticketTitle) {
		this.ticketTitle = ticketTitle;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	public String getTicketRaiser() {
		return ticketRaiser;
	}
	public void setTicketRaiser(String ticketRaiser) {
		this.ticketRaiser = ticketRaiser;
	}
	public String getTicketDescription() {
		return ticketDescription;
	}
	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}

}
