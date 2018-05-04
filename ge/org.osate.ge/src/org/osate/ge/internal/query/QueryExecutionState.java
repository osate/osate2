package org.osate.ge.internal.query;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.osate.ge.internal.services.ReferenceService;

public class QueryExecutionState {
	final QueryRunner queryRunner;
	final ReferenceService refBuilder;
	final Object arg;
	final Map<DefaultQuery, Object> cache = new HashMap<>(); // Generic cache to allow queries to store data between run() calls
	
	public QueryExecutionState(final QueryRunner queryRunner, final ReferenceService refBuilder, final Object arg) {
		this.queryRunner = Objects.requireNonNull(queryRunner, "queryRunner must not be null");
		this.refBuilder = Objects.requireNonNull(refBuilder, "refBuilder must not be null");
		this.arg = arg;
	}
}
