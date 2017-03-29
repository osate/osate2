package org.osate.ge.internal.query;

import java.util.Deque;
import org.osate.ge.internal.diagram.AgeDiagramElement;
import org.osate.ge.internal.diagram.DiagramNode;

class DescendantsQuery<A> extends DiagramNodeQuery<A> {
	public DescendantsQuery(final DiagramNodeQuery<A> prev) {
		super(prev);
	}
	
	@Override
	void run(final Deque<DiagramNodeQuery<A>> remainingQueries, final DiagramNode ctx, final QueryExecutionState<A> state, final QueryResult result) {
		final DiagramNode container = ctx;
		for(final AgeDiagramElement child : container.getDiagramElements()) {
			processResultValue(remainingQueries, child, state, result);
			if(result.done) {
				return;
			}
			
			run(remainingQueries, child, state, result);			
			if(result.done) {
				return;
			}
		}
	}
}
