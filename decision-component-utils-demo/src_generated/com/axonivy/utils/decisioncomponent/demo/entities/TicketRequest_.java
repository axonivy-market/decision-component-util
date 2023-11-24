package com.axonivy.utils.decisioncomponent.demo.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TicketRequest.class)
public abstract class TicketRequest_ extends com.axonivy.utils.decisioncomponent.entities.BaseRequest_ {

	public static volatile SingularAttribute<TicketRequest, String> ticketTitle;
	public static volatile SingularAttribute<TicketRequest, String> ticketNumber;
	public static volatile SingularAttribute<TicketRequest, Long> caseId;
	public static volatile SingularAttribute<TicketRequest, String> ticketDescription;
	public static volatile SingularAttribute<TicketRequest, String> ticketType;
	public static volatile SingularAttribute<TicketRequest, String> ticketRaiser;

	public static final String TICKET_TITLE = "ticketTitle";
	public static final String TICKET_NUMBER = "ticketNumber";
	public static final String CASE_ID = "caseId";
	public static final String TICKET_DESCRIPTION = "ticketDescription";
	public static final String TICKET_TYPE = "ticketType";
	public static final String TICKET_RAISER = "ticketRaiser";

}

