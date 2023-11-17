package com.axonivy.utils.decisioncomponent.demo.dao;


import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.axonivy.utils.decisioncomponent.demo.entities.TicketRequest;
import com.axonivy.utils.decisioncomponent.demo.entities.TicketRequest_;
import com.axonivy.utils.persistence.dao.AuditableDAO;
import com.axonivy.utils.persistence.dao.CriteriaQueryContext;

public class TicketRequestDAO extends AuditableDAO<TicketRequest_, TicketRequest> implements BaseDAO {

	private static final TicketRequestDAO INSTANCE = new TicketRequestDAO();

	public static TicketRequestDAO getInstance() {
		return INSTANCE;
	}

	@Override
	protected Class<TicketRequest> getType() {
		return TicketRequest.class;
	}
	
	public TicketRequest findByCaseId(Long caseId) {
		try (CriteriaQueryContext<TicketRequest> query = initializeQuery();) {
			query.whereEq(TicketRequest_.caseId, caseId);
			List<TicketRequest> results = findByCriteria(query);
			return CollectionUtils.isNotEmpty(results) ? results.get(0) : null;
		}
	}
	
}
