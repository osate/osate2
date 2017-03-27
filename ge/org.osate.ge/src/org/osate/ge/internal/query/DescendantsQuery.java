package org.osate.ge.internal.query;

import java.util.Deque;
import org.osate.ge.internal.diagram.AgeDiagramElement;
import org.osate.ge.internal.diagram.DiagramNode;

class DescendantsQuery<A> extends AgeDiagramElementQuery<A> {
	public DescendantsQuery(final AgeDiagramElementQuery<A> prev) {
		super(prev);
	}
	
	@Override
	void run(final Deque<AgeDiagramElementQuery<A>> remainingQueries, final DiagramNode ctx, final QueryExecutionState<A> state, final QueryResult result) {
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
