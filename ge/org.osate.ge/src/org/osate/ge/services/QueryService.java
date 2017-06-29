package org.osate.ge.services;

import java.util.List;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.query.StandaloneQuery;

public interface QueryService {
	// boc's BO will be query argument
	default BusinessObjectContext getFirstResult(final StandaloneQuery query, final BusinessObjectContext boc) {
		return getFirstResult(query, boc, boc.getBusinessObject());
	}
	
	BusinessObjectContext getFirstResult(StandaloneQuery query, BusinessObjectContext boc, final Object arg);
	
	// boc's BO will be query argument
	default Object getFirstBusinessObject(final StandaloneQuery query, final BusinessObjectContext boc) {
		return getFirstBusinessObject(query, boc, boc.getBusinessObject());
	}
	
	Object getFirstBusinessObject(StandaloneQuery query, BusinessObjectContext boc, final Object arg);
	
	// boc's BO will be query argument	
	default List<BusinessObjectContext> getResults(final StandaloneQuery query, final BusinessObjectContext boc) {
		return getResults(query, boc, boc.getBusinessObject());
	}
	
	List<BusinessObjectContext> getResults(StandaloneQuery query, BusinessObjectContext boc, final Object arg);
}
