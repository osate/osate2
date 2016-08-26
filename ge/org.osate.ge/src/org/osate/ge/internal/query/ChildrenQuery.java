package org.osate.ge.internal.query;

import java.util.Deque;

import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;

class ChildrenQuery<A> extends PictogramQuery<A> {
	public ChildrenQuery(final Query<A> prev) {
		super(prev);
	}
	
	@Override
	void run(final Deque<Query<A>> remainingQueries, final Object ctx, final QueryExecutionState<A> state, final QueryResult result) {
		if(ctx instanceof ContainerShape) {
			final ContainerShape shape = (ContainerShape)ctx;
			for(final Shape childShape : shape.getChildren()) {
				// Don't process ghosts
				if(!state.propertyService.isGhost(childShape)) {
					if(state.propertyService.isLogicalTreeNode(childShape)) {
						processResultValue(remainingQueries, childShape, state, result);
					} else {
						run(remainingQueries, childShape, state, result);
					}
					
					if(result.done) {
						return;
					}
				}
			}
			
			for(final Connection c : state.connectionService.getConnections(shape)) {
				if(!state.propertyService.isGhost(shape)) {
					if(state.propertyService.isLogicalTreeNode(c)) {
						processResultValue(remainingQueries, c, state, result);						
						if(result.done) {
							return;
						}
					}
				}
			}
		}
	}
}
