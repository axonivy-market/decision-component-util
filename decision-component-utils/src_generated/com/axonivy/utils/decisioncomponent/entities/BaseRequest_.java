package com.axonivy.utils.decisioncomponent.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BaseRequest.class)
public abstract class BaseRequest_ extends com.axonivy.utils.persistence.beans.AuditableEntity_ {

	public static volatile SingularAttribute<BaseRequest, String> forwardToMail;
	public static volatile ListAttribute<BaseRequest, BaseApprovalHistory> approvalHistories;

	public static final String FORWARD_TO_MAIL = "forwardToMail";
	public static final String APPROVAL_HISTORIES = "approvalHistories";

}

