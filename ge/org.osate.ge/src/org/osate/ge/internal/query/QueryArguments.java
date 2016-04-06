package org.osate.ge.internal.query;

import java.util.Objects;

import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.PropertyService;

public class QueryArguments<A> {
	//final QueryArguments<A> parent;
	final PropertyService propertyService;
	final BusinessObjectResolutionService bor;
	final A arg;
	
	public QueryArguments(final PropertyService propertyService, final BusinessObjectResolutionService bor, final A arg) {
		this.propertyService = Objects.requireNonNull(propertyService, "propertyService must not be null");
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
		this.arg = arg;
	}
}
