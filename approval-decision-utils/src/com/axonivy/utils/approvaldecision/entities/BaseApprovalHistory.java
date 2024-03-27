package com.axonivy.utils.approvaldecision.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.axonivy.utils.persistence.beans.AuditableEntity;

@MappedSuperclass
public abstract class BaseApprovalHistory extends AuditableEntity {

	private static final long serialVersionUID = 1L;

	@Column
	private LocalDateTime approvalDate;

	@Column
	private String comment;

	@Column
	private String decision;

	@Column
	private Boolean isEditing;

	@Column
	private String selectedConfirmations;

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
