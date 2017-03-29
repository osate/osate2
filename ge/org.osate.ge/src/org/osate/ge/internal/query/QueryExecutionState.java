package org.osate.ge.internal.query;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.InternalReferenceBuilderService;

public class QueryExecutionState<A> {
	final QueryRunner queryRunner;
	final PropertyService propertyService;
	final BusinessObjectResolutionService bor;
	final InternalReferenceBuilderService refBuilder;
	final A arg;
	final Map<DiagramNodeQuery<A>, Object> cache = new HashMap<>(); // Generic cache to allow queries to store data between run() calls
	
	public QueryExecutionState(final QueryRunner queryRunner, final PropertyService propertyService, final BusinessObjectResolutionService bor, final InternalReferenceBuilderService refBuilder, final A arg) {
		this.queryRunner = Objects.requireNonNull(queryRunner, "queryRunner must not be null");
		this.propertyService = Objects.requireNonNull(propertyService, "propertyService must not be null");
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
		this.refBuilder = Objects.requireNonNull(refBuilder, "refBuilder must not be null");
		this.arg = arg;
	}
}
