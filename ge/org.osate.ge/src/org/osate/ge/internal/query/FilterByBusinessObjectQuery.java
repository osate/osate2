package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.Objects;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.query.Supplier;

class FilterByBusinessObjectQuery<A> extends PictogramQuery<A> {
	private final Supplier<A, Object> boSupplier;
	private String nullBoRef = "<null>";
	
	public FilterByBusinessObjectQuery(final Query<A> prev, final Supplier<A, Object> boSupplier) {
		super(prev);
		this.boSupplier = Objects.requireNonNull(boSupplier, "boSupplier must not be null");
	}
	
	@Override
	void run(final Deque<Query<A>> remainingQueries, final Object ctx, final QueryExecutionState<A> state, final QueryResult result) {
		if(!(ctx instanceof PictogramElement)) {
			throw new RuntimeException("Unsupported context: " + ctx);
		}

		// Look in the cache for the reference and build a new reference string if it is not found
		String boRef = (String)state.cache.get(this);
		if(boRef == null) {
			final Object bo = boSupplier.get(state.arg);
			boRef = bo == null ? nullBoRef : state.refBuilder.getReference(bo);
			if(boRef == null) {
				boRef = nullBoRef;
			}
			state.cache.put(this, boRef);
		}
		
		if(boRef == nullBoRef) {
			return;
		}
		
		// Compare references
		final PictogramElement pe = (PictogramElement)ctx;
		final Object peBo = state.bor.getBusinessObjectForPictogramElement(pe);
		if(boRef.equals(state.refBuilder.getReference(peBo))) {
			processResultValue(remainingQueries, pe, state, result);
		}
	}
}
