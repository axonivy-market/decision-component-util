package com.axonivy.utils.approvaldecision.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import com.axonivy.utils.persistence.beans.AuditableEntity;

@MappedSuperclass
public abstract class BaseRequest<T extends BaseApprovalHistory<ID>, ID extends Serializable> extends AuditableEntity<ID> {

	private static final long serialVersionUID = 1L;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "RequestApprovalHistory", joinColumns = {
			@JoinColumn(name = "requestId", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_requestApprovalHistory_request")) }, inverseJoinColumns = @JoinColumn(name = "approvalHistoryId", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_requestApprovalHistory_approvalHistory")))
	private List<T> approvalHistories = new ArrayList<>();

	public List<T> getApprovalHistories() {
		return approvalHistories;
	}

	public void setApprovalHistories(List<T> approvalHistories) {
		this.approvalHistories = approvalHistories;
	}

}
