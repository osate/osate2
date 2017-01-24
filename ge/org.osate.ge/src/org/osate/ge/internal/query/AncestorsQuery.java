package org.osate.ge.internal.query;

import java.util.Deque;

import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

class AncestorsQuery<A> extends PictogramQuery<A> {
	public AncestorsQuery(final Query<A> prev) {
		super(prev);
	}
	
	@Override
	void run(final Deque<Query<A>> remainingQueries, final Object ctx, final QueryExecutionState<A> state, final QueryResult result) {
		PictogramElement pe;
		if(ctx instanceof Shape || ctx instanceof Connection) {
			pe = (PictogramElement)ctx;
		} else {
			throw new RuntimeException("Unsupported context: " + ctx);
		}

		while(pe != null && !result.done) {		
			pe = AncestorUtil.getParent(pe, state);
			if(pe != null) {
				processResultValue(remainingQueries, pe, state, result);
			}
		}
	}
}
