package com.axonivy.utils.decisioncomponent.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import com.axonivy.utils.persistence.beans.AuditableEntity;

@MappedSuperclass
public abstract class BaseRequest extends AuditableEntity {

	private static final long serialVersionUID = 1L;
	
	@Column
	private String forwardToMail;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "TicketRequestApprovalHistory",
	  joinColumns = { @JoinColumn(name = "ticketRequestId", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ticketRequestApprovalHistory_ticketRequest")) },
	  inverseJoinColumns = @JoinColumn(name = "approvalHistoryId", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ticketRequestApprovalHistory_approvalHistory")))
	private List<BaseApprovalHistory> approvalHistories = new ArrayList<>();

	public String getForwardToMail() {
		return forwardToMail;
	}

	public void setForwardToMail(String forwardToMail) {
		this.forwardToMail = forwardToMail;
	}

	public List<BaseApprovalHistory> getApprovalHistories() {
		return approvalHistories;
	}

	public void setApprovalHistories(List<BaseApprovalHistory> approvalHistories) {
		this.approvalHistories = approvalHistories;
	}

}
