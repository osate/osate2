package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.Objects;

import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.query.Supplier;

class FilterByBusinessObjectCanonicalReferenceQuery extends DefaultQuery {
	private final Supplier<Object, Object> boSupplier;
	private CanonicalBusinessObjectReference nullBoRef = new CanonicalBusinessObjectReference("<null>");
	
	@SuppressWarnings("unchecked")
	public FilterByBusinessObjectCanonicalReferenceQuery(final DefaultQuery prev, final Supplier<?, Object> boSupplier) {
		super(prev);
		this.boSupplier = (Supplier<Object, Object>) Objects.requireNonNull(boSupplier, "boSupplier must not be null");
	}
	
	@Override
	void run(final Deque<DefaultQuery> remainingQueries, final Queryable ctx, final QueryExecutionState state, final QueryResult result) {
		// Look in the cache for the reference and build a new reference string if it is not found
		CanonicalBusinessObjectReference boRef = (CanonicalBusinessObjectReference)state.cache.get(this);
		if(boRef == null) {
			final Object bo = boSupplier.get(state.arg);
			boRef = bo == null ? nullBoRef : state.refBuilder.getCanonicalReference(bo);
			if(boRef == null) {
				boRef = nullBoRef;
			}
			state.cache.put(this, boRef);
		}
		
		if(boRef == nullBoRef) {
			return;
		}
		
		// Compare references
		final CanonicalBusinessObjectReference ctxCanonicalReference = state.refBuilder.getCanonicalReference(ctx.getBusinessObject());
		if(ctxCanonicalReference != null && ctxCanonicalReference.equals(boRef)) {
			processResultValue(remainingQueries, ctx, state, result);
		}
	}
}
