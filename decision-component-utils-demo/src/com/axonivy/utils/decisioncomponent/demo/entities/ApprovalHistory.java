package com.axonivy.utils.decisioncomponent.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.axonivy.utils.persistence.beans.AuditableEntity;

import java.time.LocalDateTime;

@Entity
@Table(name="ApprovalHistory")
public class ApprovalHistory extends AuditableEntity {

	private static final long serialVersionUID = 1L;
	
	private LocalDateTime approvalDate;
	private String comment;
	private String decision;
	private Boolean isEditing;
	private String selectedConfirmations;
	
	
	// custom field
	@Transient
	private String displayUserName;
	
	@Transient
	private String displayApprovalDate;
	
	@Transient
	private String sortableApprovalDate;
	
	
	
	
	
	public LocalDateTime getApprovalDate() {
		return approvalDate;
	}
	
	public void setApprovalDate(LocalDateTime approvalDate) {
		this.approvalDate = approvalDate;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getDecision() {
		return decision;
	}
	
	public void setDecision(String decision) {
		this.decision = decision;
	}
	
	public Boolean getIsEditing() {
		return isEditing;
	}
	
	public void setIsEditing(Boolean isEditing) {
		this.isEditing = isEditing;
	}
	
	public String getSelectedConfirmations() {
		return selectedConfirmations;
	}
	
	public void setSelectedConfirmations(String selectedConfirmations) {
		this.selectedConfirmations = selectedConfirmations;
	}
	
	public String getDisplayUserName() {
		return displayUserName;
	}
	
	public void setDisplayUserName(String displayUserName) {
		this.displayUserName = displayUserName;
	}

	public String getDisplayApprovalDate() {
		return displayApprovalDate;
	}

	public void setDisplayApprovalDate(String displayApprovalDate) {
		this.displayApprovalDate = displayApprovalDate;
	}

	public String getSortableApprovalDate() {
		return sortableApprovalDate;
	}

	public void setSortableApprovalDate(String sortableApprovalDate) {
		this.sortableApprovalDate = sortableApprovalDate;
	}
	
	
}
