package com.axonivy.utils.decisioncomponent.demo.entities;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ApprovalHistory.class)
public abstract class ApprovalHistory_ extends com.axonivy.utils.persistence.beans.AuditableEntity_ {

	public static volatile SingularAttribute<ApprovalHistory, LocalDateTime> approvalDate;
	public static volatile SingularAttribute<ApprovalHistory, String> decision;
	public static volatile SingularAttribute<ApprovalHistory, Boolean> isEditing;
	public static volatile SingularAttribute<ApprovalHistory, String> comment;
	public static volatile SingularAttribute<ApprovalHistory, String> selectedConfirmations;

	public static final String APPROVAL_DATE = "approvalDate";
	public static final String DECISION = "decision";
	public static final String IS_EDITING = "isEditing";
	public static final String COMMENT = "comment";
	public static final String SELECTED_CONFIRMATIONS = "selectedConfirmations";

}

