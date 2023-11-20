package com.axonivy.utils.decisioncomponent.demo.entities;

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
@Table(name="TicketRequest")
public class TicketRequest extends AuditableEntity {

	private static final long serialVersionUID = 1L;
	
	private Long caseId;
	private String ticketTitle;
	private String ticketNumber;
	private String ticketType;
	private String ticketRaiser;
	private String ticketDescription;
	
	private String forwardToMail;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "TicketRequestApprovalHistory",
	  joinColumns = { @JoinColumn(name = "ticketRequestId", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ticketRequestApprovalHistory_ticketRequest")) },
	  inverseJoinColumns = @JoinColumn(name = "approvalHistoryId", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ticketRequestApprovalHistory_approvalHistory")))
	private List<ApprovalHistory> approvalHistories = new ArrayList<>();
	
	
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
	public List<ApprovalHistory> getApprovalHistories() {
		return approvalHistories;
	}
	public void setApprovalHistories(List<ApprovalHistory> approvalHistories) {
		this.approvalHistories = approvalHistories;
	}
	public String getForwardToMail() {
		return forwardToMail;
	}
	public void setForwardToMail(String forwardToMail) {
		this.forwardToMail = forwardToMail;
	}
	
}
