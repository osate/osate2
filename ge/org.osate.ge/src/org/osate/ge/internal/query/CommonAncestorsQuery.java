package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.List;
import java.util.Objects;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

class CommonAncestorsQuery<A> extends PictogramQuery<A> {
	private final PictogramQuery<A> q1;
	private final PictogramQuery<A> q2;
	
	public CommonAncestorsQuery(final PictogramQuery<A> q1, final PictogramQuery<A> q2) {
		super(null);
		this.q1 = Objects.requireNonNull(q1, "q1 must not be null");
		this.q2 = Objects.requireNonNull(q2, "q2 must not be null");
	}

	@Override
	void run(final Deque<Query<A>> remainingQueries, final Object ctx, final QueryExecutionState<A> state, final QueryResult result) {
		final List<? extends PictogramElement> q1Result = state.queryRunner.getPictogramElements(q1, state.arg);		
		final List<? extends PictogramElement> q2Result = state.queryRunner.getPictogramElements(q2, state.arg);
		
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
		
		final PictogramElement pe1 = AncestorUtil.getParent(q1Result.get(0), state);
		final PictogramElement pe2 = AncestorUtil.getParent(q2Result.get(0), state);

		// Get all common ancestors common ancestor
		PictogramElement temp1 = pe1;
		while(temp1 != null) {
			PictogramElement temp2 = pe2;
			while(temp2 != null) {
				if(temp1 == temp2) {
					processResultValue(remainingQueries, temp1, state, result);

					// Return all other ancestors
					while(!result.done) {
						temp1 = AncestorUtil.getParent(temp1, state);

						if(temp1 == null) {
							break;
						} else {							
							processResultValue(remainingQueries, temp1, state, result);
						}
					}
					return;
				}
				temp2 = AncestorUtil.getParent(temp2, state);
			}
			
			temp1 = AncestorUtil.getParent(temp1, state);
		}		
	}
}
