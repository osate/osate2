package org.osate.ge.internal.query;

import java.util.Deque;
import org.osate.ge.internal.diagram.DiagramNode;

class ChildrenQuery<A> extends DiagramNodeQuery<A> {
	public ChildrenQuery(final DiagramNodeQuery<A> prev) {
		super(prev);
	}
	
	@Override
	void run(final Deque<DiagramNodeQuery<A>> remainingQueries, final DiagramNode ctx, final QueryExecutionState<A> state, final QueryResult result) {
		for(final DiagramNode child : ctx.getDiagramElements()) {
			processResultValue(remainingQueries, child, state, result);
			
			if(result.done) {
				return;
			}
		}
	}
}
