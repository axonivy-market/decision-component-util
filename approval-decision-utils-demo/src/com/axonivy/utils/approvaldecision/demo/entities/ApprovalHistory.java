package com.axonivy.utils.approvaldecision.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import com.axonivy.utils.approvaldecision.entities.BaseApprovalHistory;

import ch.ivyteam.ivy.environment.Ivy;


@Entity
@Table(name = "ApprovalHistory")
public class ApprovalHistory extends BaseApprovalHistory<String> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getSessionUsername() {
		return Ivy.session().getSessionUserName();
	}
}
