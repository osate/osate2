package org.osate.ge.internal.query;

import java.util.Deque;
import org.osate.ge.internal.diagram.DiagramElementContainer;

class AncestorQuery<A> extends AgeDiagramElementQuery<A> {
	private final int depth;
	
	public AncestorQuery(final AgeDiagramElementQuery<A> prev, final int depth) {
		super(prev);
		this.depth = depth;
		
		if(depth <= 0) {
			throw new RuntimeException("Invalid depth: " + depth);
		}
	}
	
	@Override
	void run(final Deque<AgeDiagramElementQuery<A>> remainingQueries, final DiagramElementContainer ctx, final QueryExecutionState<A> state, final QueryResult result) {
		DiagramElementContainer e = ctx;
		for(int i = 0; i < depth && ctx != null; i++) {
			e = AncestorUtil.getContainer(e);
		}
		
		// Process the value. If any
		if(e != null) {
			processResultValue(remainingQueries, e, state, result);
		}
	}
}
