package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.List;
import java.util.Objects;
import org.osate.ge.internal.diagram.DiagramNode;

class CommonAncestorsQuery<A> extends AgeDiagramElementQuery<A> {
	private final AgeDiagramElementQuery<A> q1;
	private final AgeDiagramElementQuery<A> q2;
	
	public CommonAncestorsQuery(final AgeDiagramElementQuery<A> q1, final AgeDiagramElementQuery<A> q2) {
		super(null);
		this.q1 = Objects.requireNonNull(q1, "q1 must not be null");
		this.q2 = Objects.requireNonNull(q2, "q2 must not be null");
	}

	@Override
	void run(final Deque<AgeDiagramElementQuery<A>> remainingQueries, final DiagramNode ctx, final QueryExecutionState<A> state, final QueryResult result) {
		final List<DiagramNode> q1Result = state.queryRunner.getResults(q1, state.arg);		
		final List<DiagramNode> q2Result = state.queryRunner.getResults(q2, state.arg);
		
		// Check sizes
		if(q1Result.size() == 0 || q2Result.size() == 0) {
			return;
		}
		
		if(q1Result.size() > 1) {
			throw new RuntimeException("q1 returns more than one element");
		}
		
		if(q2Result.size() > 1) {
			throw new RuntimeException("q2 returns more than one element");
		}
		
		final DiagramNode de1 = AncestorUtil.getContainer(q1Result.get(0));
		final DiagramNode de2 = AncestorUtil.getContainer(q2Result.get(0));

		// Get all common ancestors common ancestor
		DiagramNode temp1 = de1;
		while(temp1 != null) {
			DiagramNode temp2 = de2;
			while(temp2 != null) {
				if(temp1 == temp2) {
					processResultValue(remainingQueries, temp1, state, result);

					// Return all other ancestors
					while(!result.done) {
						temp1 = AncestorUtil.getContainer(temp1);

						if(temp1 == null) {
							break;
						} else {							
							processResultValue(remainingQueries, temp1, state, result);
						}
					}
					return;
				}
				temp2 = AncestorUtil.getContainer(temp2);
			}
			
			temp1 = AncestorUtil.getContainer(temp1);
		}		
	}
}
