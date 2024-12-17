package com.axonivy.utils.approvaldecision.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.axonivy.utils.approvaldecision.entities.BaseRequest;

import ch.ivyteam.ivy.environment.Ivy;

@Entity
@Table(name = "TicketRequest")
public class TicketRequest extends BaseRequest<ApprovalHistory, Long> {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column
	private String forwardToMail;

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

	public String getForwardToMail() {
		return forwardToMail;
	}

	public void setForwardToMail(String forwardToMail) {
		this.forwardToMail = forwardToMail;
	}

	@Override
	public String getSessionUsername() {
		return Ivy.session().getSessionUserName();
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
