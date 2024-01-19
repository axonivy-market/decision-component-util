package com.axonivy.utils.approvaldecision.demo.dao;

public interface BaseDAO extends com.axonivy.utils.persistence.dao.BaseDAO {
	@Override
	default public String getPersistenceUnitName() {
		return "approval-decision-utils-demo";
	}
}
