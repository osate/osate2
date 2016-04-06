package org.osate.ge.internal.query;

import java.util.Deque;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

public class AncestorQuery<A> extends PictogramQuery<A> {
	private final int depth;
	
	public AncestorQuery(final Query<A> prev, final int depth) {
		super(prev);
		this.depth = depth;
		
		// TODO: Decide whether to allow depth == 0
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
		
		// TODO: Cleanup		
		for(int i = 0; i < depth && pe != null; i++) {
			do {
				// TODO: Make more efficient.. Shouldn't have to check type after first shape..
				if(pe instanceof Shape) {
					pe = ((Shape) pe).getContainer();
				} else {
					pe = null;
					break;
				}
												
				// TODO: Handle connections
			} while(pe != null && !args.propertyService.isLogicalTreeNode(pe));
		}
		
		// Process the value. If any
		if(pe != null) {
			processResultValue(remainingQueries, pe, args, result);
		}
	}
}
