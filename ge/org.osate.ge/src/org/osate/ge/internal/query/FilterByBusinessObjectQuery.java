package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.Objects;
import org.osate.ge.internal.diagram.AgeDiagramElement;
import org.osate.ge.internal.diagram.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.DiagramNode;
import org.osate.ge.query.Supplier;

class FilterByBusinessObjectQuery<A> extends AgeDiagramElementQuery<A> {
	private final Supplier<A, Object> boSupplier;
	private CanonicalBusinessObjectReference nullBoRef = new CanonicalBusinessObjectReference("<null>");
	
	public FilterByBusinessObjectQuery(final AgeDiagramElementQuery<A> prev, final Supplier<A, Object> boSupplier) {
		super(prev);
		this.boSupplier = Objects.requireNonNull(boSupplier, "boSupplier must not be null");
	}
	
	@Override
	void run(final Deque<AgeDiagramElementQuery<A>> remainingQueries, final DiagramNode ctx, final QueryExecutionState<A> state, final QueryResult result) {
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
		if(ctx instanceof AgeDiagramElement) {
			if(((AgeDiagramElement) ctx).getCanonicalReference().equals(boRef)) {
				processResultValue(remainingQueries, ctx, state, result);
			}
		}
	}
}
