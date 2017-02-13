package org.osate.ge.internal.query;

import java.util.Deque;

import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

class DescendantsQuery<A> extends PictogramQuery<A> {
	public DescendantsQuery(final Query<A> prev) {
		super(prev);
	}
	
	@Override
	void run(final Deque<Query<A>> remainingQueries, final Object ctx, final QueryExecutionState<A> state, final QueryResult result) {
		if(ctx instanceof ContainerShape) {
			// Child Shapes
			final ContainerShape shape = (ContainerShape)ctx;
			for(final Shape childShape : shape.getChildren()) {
				// Don't process ghosts or their children
				if(!state.propertyService.isGhost(childShape)) {
					if(state.propertyService.isLogicalTreeNode(childShape)) {
						processResultValue(remainingQueries, childShape, state, result);
						if(result.done) {
							return;
						}
					}
					
					run(remainingQueries, childShape, state, result);
					
					if(result.done) {
						return;
					}
				}
			}
		}
			
		if(ctx instanceof ContainerShape || ctx instanceof Connection) {
			final PictogramElement pe = (PictogramElement)ctx;
			// Owned Connections
			for(final Connection c : state.connectionService.getConnections(pe)) {
				if(!state.propertyService.isGhost(c)) {
					if(state.propertyService.isLogicalTreeNode(c)) {
						processResultValue(remainingQueries, c, state, result);						
						if(result.done) {
							return;
						}
					}
					
					run(remainingQueries, c, state, result);
				}
			}
		}
	}
}
