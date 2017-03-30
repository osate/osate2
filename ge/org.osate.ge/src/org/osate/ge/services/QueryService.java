package org.osate.ge.services;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.query.StandaloneQuery;

// TODO: Make API once stabilized.
// TODO: Document
public interface QueryService {
	// TODO: Document. boc will be query argument
	BusinessObjectContext getFirstResult(StandaloneQuery query, BusinessObjectContext boc);
	
	// TODO: Document. boc will be query argument
	Object getFirstBusinessObject(StandaloneQuery query, BusinessObjectContext boc);
}
