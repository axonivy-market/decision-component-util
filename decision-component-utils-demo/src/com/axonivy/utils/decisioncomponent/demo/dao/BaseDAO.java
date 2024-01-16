package com.axonivy.utils.decisioncomponent.demo.dao;

public interface BaseDAO extends com.axonivy.utils.persistence.dao.BaseDAO {
	@Override
	default public String getPersistenceUnitName() {
		return "decision-component-utils-demo";
	}
}
