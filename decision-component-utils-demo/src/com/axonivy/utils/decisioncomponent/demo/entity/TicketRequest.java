package com.axonivy.utils.decisioncomponent.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;

import com.axonivy.utils.persistence.beans.AuditableEntity;

@Entity
@Table(name = "ticket_request")
public class TicketRequest extends AuditableEntity{

	private static final long serialVersionUID = 1L;
	
	private String ticketTitle;
	private String ticketNumber;
	private String ticketType;
	private String ticketRaiser;
	private String ticketDescription;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "ticket_request_approval_history",
	  joinColumns = { @JoinColumn(name = "ticket_request_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ticket_request_approval_history_ticket_request")) },
	  inverseJoinColumns = @JoinColumn(name = "approval_history_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ticket_request_approval_history_approval_history")))
	private List<ApprovalHistory> approvalHistories = new ArrayList<>();
	
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
	public List<ApprovalHistory> getApprovalHistories() {
		return approvalHistories;
	}
	public void setApprovalHistories(List<ApprovalHistory> approvalHistories) {
		this.approvalHistories = approvalHistories;
	}
	
	

}
