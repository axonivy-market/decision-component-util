package com.axonivy.utils.decisioncomponent.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.axonivy.utils.decisioncomponent.entities.BaseApprovalHistory;

@Entity
@Table(name="ApprovalHistory")
public class ApprovalHistory extends BaseApprovalHistory {

	private static final long serialVersionUID = 1L;
	
	private String testField;

	public String getTestField() {
		return testField;
	}

	public void setTestField(String testField) {
		this.testField = testField;
	}
	
	
	
	// custom field
//	@Transient
//	private String displayUserName;
//	
//	@Transient
//	private String displayApprovalDate;
//	
//	@Transient
//	private String sortableApprovalDate;
	
//	public String getDisplayUserName() {
//		return displayUserName;
//	}
//	
//	public void setDisplayUserName(String displayUserName) {
//		this.displayUserName = displayUserName;
//	}
//
//	public String getDisplayApprovalDate() {
//		return displayApprovalDate;
//	}
//
//	public void setDisplayApprovalDate(String displayApprovalDate) {
//		this.displayApprovalDate = displayApprovalDate;
//	}
//
//	public String getSortableApprovalDate() {
//		return sortableApprovalDate;
//	}
//
//	public void setSortableApprovalDate(String sortableApprovalDate) {
//		this.sortableApprovalDate = sortableApprovalDate;
//	}
	
}
