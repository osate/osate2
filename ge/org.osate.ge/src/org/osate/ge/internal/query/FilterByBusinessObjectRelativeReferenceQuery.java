package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.Objects;

import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.query.Supplier;

class FilterByBusinessObjectRelativeReferenceQuery extends DefaultQuery {
	private final Supplier<Object, Object> boSupplier;
	private RelativeBusinessObjectReference nullBoRef = new RelativeBusinessObjectReference("<null>");

	@SuppressWarnings("unchecked")
	public FilterByBusinessObjectRelativeReferenceQuery(final DefaultQuery prev, final Supplier<?, Object> boSupplier) {
		super(prev);
		this.boSupplier = (Supplier<Object, Object>) Objects.requireNonNull(boSupplier, "boSupplier must not be null");
	}

	@Override
	void run(final Deque<DefaultQuery> remainingQueries, final Queryable ctx, final QueryExecutionState state, final QueryResult result) {
		// Look in the cache for the reference and build a new reference string if it is not found
		RelativeBusinessObjectReference boRef = (RelativeBusinessObjectReference)state.cache.get(this);
		if(boRef == null) {
			final Object bo = boSupplier.get(state.arg);
			boRef = bo == null ? nullBoRef : state.refBuilder.getRelativeReference(bo);
			if(boRef == null) {
				boRef = nullBoRef;
			}
			state.cache.put(this, boRef);
		}

		if(boRef == nullBoRef) {
			return;
		}

		// Compare references
		if(ctx.getBusinessObject() != null) {
			final RelativeBusinessObjectReference ctxRelativeReference = InternalQueryUtil.getRelativeReference(ctx,
					state.refBuilder);
			if(ctxRelativeReference != null && ctxRelativeReference.equals(boRef)) {
				processResultValue(remainingQueries, ctx, state, result);
			}
		}
	}
}
