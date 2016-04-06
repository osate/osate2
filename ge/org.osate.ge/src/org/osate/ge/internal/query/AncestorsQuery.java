package org.osate.ge.internal.query;

import java.util.Deque;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

public class AncestorsQuery<A> extends PictogramQuery<A> {
	public AncestorsQuery(final Query<A> prev) {
		super(prev);
	}
	
	@Override
	void run(final Deque<Query<A>> remainingQueries, final Object ctx, final QueryArguments<A> args, final QueryResult result) {
		PictogramElement pe;
		if(ctx instanceof Shape) {
			// TODO: Support connections
			pe = (PictogramElement)ctx;
		} else {
			throw new RuntimeException("Unsupported context: " + ctx);
		}

		while(pe != null && !result.done) {			
			if(pe instanceof Shape) {
				pe = ((Shape) pe).getContainer();
			} else {
				throw new RuntimeException("Unhandled pictoram element: " + pe);
			}
			// TODO: Handle connections. Connection owner, etc
			
			if(pe != null && args.propertyService.isLogicalTreeNode(pe)) {
				processResultValue(remainingQueries, pe, args, result);
			}
		}
	}
}
