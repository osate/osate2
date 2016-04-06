package org.osate.ge.internal.query;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.PropertyService;

// TODO: Should be service?
public class QueryRunner {
	private final PropertyService propertyService;
	private final BusinessObjectResolutionService bor;
	
	public QueryRunner(final PropertyService propertyService, final BusinessObjectResolutionService bor) {
		this.propertyService = Objects.requireNonNull(propertyService, "propertyService must not be null");
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
	}
	
	// TODO: Fix type. Type safe?
	@SuppressWarnings("unchecked")
	public <A> List<? extends PictogramElement> run(final PictogramQuery<A> query, final A arg) {
		return (List<? extends PictogramElement>)runQuery(query, arg);
	}
	
	private <A> List<?> runQuery(final Query<A> query, final A arg) {
		final Deque<Query<A>> queryStack = new ArrayDeque<>();
		for(Query<A> q = query; q != null; q = q.getPrev()) {
			queryStack.push(q);
		}
		
		if(queryStack.isEmpty()) {
			// TODO: Throw exception
		}
		
		final Query<A> initialQuery = queryStack.pop();
		final QueryArguments<A> args = new QueryArguments<>(propertyService, bor, arg);
		final QueryResult result = new QueryResult();
		initialQuery.run(queryStack, null, args, result);
		
		return (List<?>)result.result;
	}
}
