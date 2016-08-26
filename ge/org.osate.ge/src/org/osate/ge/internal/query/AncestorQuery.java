package org.osate.ge.internal.query;

import java.util.Deque;

import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

class AncestorQuery<A> extends PictogramQuery<A> {
	private final int depth;
	
	public AncestorQuery(final Query<A> prev, final int depth) {
		super(prev);
		this.depth = depth;
		
		if(depth <= 0) {
			throw new RuntimeException("Invalid depth: " + depth);
		}
	}
	
	@Override
	void run(final Deque<Query<A>> remainingQueries, final Object ctx, final QueryExecutionState<A> state, final QueryResult result) {
		PictogramElement pe;
		if(ctx instanceof Shape || ctx instanceof Connection) {
			pe = (PictogramElement)ctx;
		} else {
			throw new RuntimeException("Unsupported context: " + ctx);
		}
		
		for(int i = 0; i < depth && pe != null; i++) {
			pe = AncestorUtil.getAncestor(pe, state);
		}
		
		// Process the value. If any
		if(pe != null) {
			processResultValue(remainingQueries, pe, state, result);
		}
	}
}
