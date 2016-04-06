package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.function.Predicate;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;

// TODO: Repurpose to implement filtering
public class BoFilterPictogramQuery<A> extends PictogramQuery<A> {
	private final Predicate<Object> filter;
	
	public BoFilterPictogramQuery(final Query<A> prev, final Predicate<Object> filter) {
		super(prev);
		this.filter = filter;
	}
	
	@Override
	void run(final Deque<Query<A>> remainingQueries, final Object ctx, final QueryArguments<A> args, final QueryResult result) {
		if(ctx instanceof PictogramElement) {
			final Object bo = args.bor.getBusinessObjectForPictogramElement((PictogramElement)ctx);
			if(bo != null && filter.test(bo)) {
				processResultValue(remainingQueries, ctx, args, result);
			}
		}
	}
}
