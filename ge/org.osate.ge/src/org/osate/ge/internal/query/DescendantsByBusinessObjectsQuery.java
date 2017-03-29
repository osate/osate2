package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.Objects;
import org.osate.ge.internal.diagram.CanonicalBusinessObjectReference;
import org.osate.ge.internal.services.InternalReferenceBuilderService;
import org.osate.ge.query.Supplier;

public class DescendantsByBusinessObjectsQuery<A> extends Query<A> {
	private final static CanonicalBusinessObjectReference[] nullBoRefs = new CanonicalBusinessObjectReference[0];
	private final Supplier<A, Object[]> bosSupplier;
	
	public DescendantsByBusinessObjectsQuery(final Query<A> prev, final Supplier<A, Object[]> bosSupplier) {
		super(prev);
		this.bosSupplier = Objects.requireNonNull(bosSupplier, "bosSupplier must not be null");
	}
	
	@Override
	void run(final Deque<Query<A>> remainingQueries, final Queryable ctx, final QueryExecutionState<A> state, final QueryResult result) {
		// Look in the cache for the reference and build a new reference string if it is not found
		CanonicalBusinessObjectReference[] boRefs = (CanonicalBusinessObjectReference[])state.cache.get(this);
		if(boRefs == null) {
			final Object[] bos = bosSupplier.get(state.arg);
			boRefs = bos == null ? nullBoRefs : getReferences(bos, state.refBuilder);
			if(boRefs == null) {
				boRefs = nullBoRefs;
			}
			state.cache.put(this, boRefs);
		}
		
		if(boRefs == nullBoRefs) {
			return;
		}
		
		findMatchingDescendants(remainingQueries, ctx, state, result, boRefs, 0);		
	}
	
	void findMatchingDescendants(final Deque<Query<A>> remainingQueries, Queryable container, final QueryExecutionState<A> state, final QueryResult result, final CanonicalBusinessObjectReference[] boRefs, int currentDepth) {
		if(currentDepth >= boRefs.length) {
			processResultValue(remainingQueries, container, state, result);
		} else {		
			final CanonicalBusinessObjectReference boRef = boRefs[currentDepth];
			for(final Queryable child : container.getChildren()) {
				// Check the business object reference
				final CanonicalBusinessObjectReference childRef = state.refBuilder.getCanonicalReference(child.getBusinessObject());
				if(boRef.equals(childRef)) {
					findMatchingDescendants(remainingQueries, child, state, result, boRefs, currentDepth+1);
				}	

				if(result.done) {
					return;
				}
			}
		}
	}
	
	/**
	 * Returns an array of references for an array of business objects.
	 * @param bos
	 * @param refBuilder
	 * @return an array of references. null if any of the business objects or their references are null.
	 */
	private static CanonicalBusinessObjectReference[] getReferences(final Object[] bos, final InternalReferenceBuilderService refBuilder) {
		if(bos == null) {
			return null;
		}
		
		final CanonicalBusinessObjectReference[] references = new CanonicalBusinessObjectReference[bos.length];
		for(int i = 0; i < bos.length; i++) {
			final Object bo = bos[i];
			if(bo == null) {
				return null;
			}
			
			final CanonicalBusinessObjectReference ref = refBuilder.getCanonicalReference(bo);
			if(ref == null) {
				return null;
			}
			
			references[i] = ref;			
		}
		
		return references;
	}
}
