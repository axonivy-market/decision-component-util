package com.axonivy.utils.approvaldecision.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.axonivy.utils.approvaldecision.entities.BaseApprovalHistory;

@Entity
@Table(name = "ApprovalHistory")
public class ApprovalHistory extends BaseApprovalHistory {
	private static final long serialVersionUID = 1L;
}
