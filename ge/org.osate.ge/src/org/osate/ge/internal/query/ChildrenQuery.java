package org.osate.ge.internal.query;

import java.util.Deque;
import org.osate.ge.internal.diagram.AgeDiagramElement;
import org.osate.ge.internal.diagram.DiagramNode;

class ChildrenQuery<A> extends AgeDiagramElementQuery<A> {
	public ChildrenQuery(final AgeDiagramElementQuery<A> prev) {
		super(prev);
	}
	
	@Override
	void run(final Deque<AgeDiagramElementQuery<A>> remainingQueries, final DiagramNode ctx, final QueryExecutionState<A> state, final QueryResult result) {
		for(final AgeDiagramElement child : ctx.getDiagramElements()) {
			processResultValue(remainingQueries, child, state, result);
			
			if(result.done) {
				return;
			}
		}
	}
}
