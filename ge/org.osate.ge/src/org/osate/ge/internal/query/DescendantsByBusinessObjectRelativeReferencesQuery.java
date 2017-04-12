package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.Objects;
import org.osate.ge.internal.diagram.RelativeBusinessObjectReference;
import org.osate.ge.internal.services.InternalReferenceBuilderService;
import org.osate.ge.query.Supplier;

public class DescendantsByBusinessObjectRelativeReferencesQuery extends DefaultQuery {
	private final static RelativeBusinessObjectReference[] nullBoRefs = new RelativeBusinessObjectReference[0];
	private final Supplier<Object, Object[]> bosSupplier;
	
	@SuppressWarnings("unchecked")
	public DescendantsByBusinessObjectRelativeReferencesQuery(final DefaultQuery prev, final Supplier<?, Object[]> bosSupplier) {
		super(prev);
		this.bosSupplier = (Supplier<Object, Object[]>) Objects.requireNonNull(bosSupplier, "bosSupplier must not be null");
	}
	
	@Override
	void run(final Deque<DefaultQuery> remainingQueries, final Queryable ctx, final QueryExecutionState state, final QueryResult result) {
		// Look in the cache for the reference and build a new reference string if it is not found
		RelativeBusinessObjectReference[] boRefs = (RelativeBusinessObjectReference[])state.cache.get(this);
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
	
	void findMatchingDescendants(final Deque<DefaultQuery> remainingQueries, Queryable container, final QueryExecutionState state, final QueryResult result, final RelativeBusinessObjectReference[] boRefs, int currentDepth) {
		if(currentDepth >= boRefs.length) {
			processResultValue(remainingQueries, container, state, result);
		} else {		
			final RelativeBusinessObjectReference boRef = boRefs[currentDepth];
			for(final Queryable child : container.getChildren()) {
				// Check the business object reference
				final RelativeBusinessObjectReference childRef = state.refBuilder.getRelativeReference(child.getBusinessObject());
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
	private static RelativeBusinessObjectReference[] getReferences(final Object[] bos, final InternalReferenceBuilderService refBuilder) {
		if(bos == null) {
			return null;
		}
		
		final RelativeBusinessObjectReference[] references = new RelativeBusinessObjectReference[bos.length];
		for(int i = 0; i < bos.length; i++) {
			final Object bo = bos[i];
			if(bo == null) {
				return null;
			}
			
			final RelativeBusinessObjectReference ref = refBuilder.getRelativeReference(bo);
			if(ref == null) {
				return null;
			}
			
			references[i] = ref;			
		}
		
		return references;
	}
}
