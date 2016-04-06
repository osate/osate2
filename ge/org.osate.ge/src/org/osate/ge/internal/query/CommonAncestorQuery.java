package org.osate.ge.internal.query;

import java.util.Deque;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.query.DiagramElementQuery;

public class CommonAncestorQuery<A> extends PictogramQuery<A> {
	private final DiagramElementQuery<A> q;
	
	public CommonAncestorQuery(final Query<A> prev, final DiagramElementQuery<A> q) {
		super(prev);
		this.q = q;
	}
	
	@Override
	void run(final Deque<Query<A>> remainingQueries, final Object ctx, final QueryArguments<A> args, final QueryResult result) {
		// TODO
		throw new RuntimeException("Unimplemented");
		
	}
}
