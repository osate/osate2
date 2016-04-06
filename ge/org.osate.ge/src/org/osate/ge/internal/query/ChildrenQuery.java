package org.osate.ge.internal.query;

import java.util.Deque;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;

public class ChildrenQuery<A> extends PictogramQuery<A> {
	public ChildrenQuery(final Query<A> prev) {
		super(prev);
	}
	
	@Override
	void run(final Deque<Query<A>> remainingQueries, final Object ctx, final QueryArguments<A> args, final QueryResult result) {
		if(ctx instanceof ContainerShape) {
			final ContainerShape shape = (ContainerShape)ctx;
			for(final Shape childShape : shape.getChildren()) {
				// Don't process ghosts
				if(!args.propertyService.isGhost(childShape)) {
					if(args.propertyService.isLogicalTreeNode(childShape)) {
						processResultValue(remainingQueries, childShape, args, result);
					} else {
						run(remainingQueries, childShape, args, result);
					}
					
					if(result.done) {
						break;
					}
				}
			}
		}
	}
}
