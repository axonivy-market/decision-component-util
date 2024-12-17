package com.axonivy.utils.approvaldecision.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.axonivy.utils.approvaldecision.entities.BaseApprovalHistory;

import ch.ivyteam.ivy.environment.Ivy;

@Entity
@Table(name = "ApprovalHistory")
public class ApprovalHistory extends BaseApprovalHistory<Long> {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Override
	public String getSessionUsername() {
		return Ivy.session().getSessionUserName();
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
