package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.Objects;

import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.ge.internal.services.InternalReferenceBuilderService;
import org.osate.ge.query.Supplier;

public class DescendantsByBusinessObjectsQuery<A> extends PictogramQuery<A> {
	private final static String[] nullBoRefs = new String[] {"<null>"};
	private final Supplier<A, Object[]> bosSupplier;
	
	public DescendantsByBusinessObjectsQuery(final Query<A> prev, final Supplier<A, Object[]> bosSupplier) {
		super(prev);
		this.bosSupplier = Objects.requireNonNull(bosSupplier, "bosSupplier must not be null");
	}
	
	@Override
	void run(final Deque<Query<A>> remainingQueries, final Object ctx, final QueryExecutionState<A> state, final QueryResult result) {
		if(!(ctx instanceof PictogramElement)) {
			throw new RuntimeException("Unsupported context: " + ctx);
		}

		// Look in the cache for the reference and build a new reference string if it is not found
		String[] boRefs = (String[])state.cache.get(this);
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
		
		findMatchingDescendants(remainingQueries, (PictogramElement)ctx, state, result, boRefs, 0);		
	}
	
	void findMatchingDescendants(final Deque<Query<A>> remainingQueries, final PictogramElement pe, final QueryExecutionState<A> state, final QueryResult result, final String[] boRefs, int currentDepth) {
		if(currentDepth >= boRefs.length) {
			processResultValue(remainingQueries, pe, state, result);
		} else {		
			final String boRef = boRefs[currentDepth];
			if(pe instanceof ContainerShape) {
				final ContainerShape shape = (ContainerShape)pe;
				for(final Shape childShape : shape.getChildren()) {
					// Don't process ghosts
					if(!state.propertyService.isGhost(childShape)) {
						if(state.propertyService.isLogicalTreeNode(childShape)) {
							// Check the business object reference
							final Object childBo = state.bor.getBusinessObjectForPictogramElement(childShape);
							if(boRef.equals(state.refBuilder.getReference(childBo))) {
								findMatchingDescendants(remainingQueries, childShape, state, result, boRefs, currentDepth+1);
							}					
						} else {
							// Check children
							findMatchingDescendants(remainingQueries, childShape, state, result, boRefs, currentDepth);
						}
						
						if(result.done) {
							return;
						}
					}
				}
			}
			
			for(final Connection c : state.connectionService.getConnections(pe)) {
				if(!state.propertyService.isGhost(c)) {
					if(state.propertyService.isLogicalTreeNode(c)) {
						// Check the business object reference
						final Object childBo = state.bor.getBusinessObjectForPictogramElement(c);
						if(boRef.equals(state.refBuilder.getReference(childBo))) {
							findMatchingDescendants(remainingQueries, c, state, result, boRefs, currentDepth+1);
						}
					
						if(result.done) {
							return;
						}
					}
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
	private static String[] getReferences(final Object[] bos, final InternalReferenceBuilderService refBuilder) {
		if(bos == null) {
			return null;
		}
		
		final String[] references = new String[bos.length];
		for(int i = 0; i < bos.length; i++) {
			final Object bo = bos[i];
			if(bo == null) {
				return null;
			}
			
			final String ref = refBuilder.getReference(bo);
			if(ref == null) {
				return null;
			}
			
			references[i] = ref;			
		}
		
		return references;
	}
}
