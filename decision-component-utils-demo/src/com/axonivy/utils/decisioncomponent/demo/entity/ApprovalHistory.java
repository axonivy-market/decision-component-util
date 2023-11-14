package com.axonivy.utils.decisioncomponent.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.axonivy.utils.persistence.beans.AuditableEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "approval_history")
public class ApprovalHistory extends AuditableEntity {

	private static final long serialVersionUID = 1L;
	
	private LocalDateTime approvalDate;
	private String comment;
	private String decision;
	private Boolean isEditing;
	private String selectedConfirmations;
	
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
}
