package org.osate.ge.internal.query;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.InternalReferenceBuilderService;

public class QueryRunner {
	private final PropertyService propertyService;
	private final ConnectionService connectionService;
	private final BusinessObjectResolutionService bor;
	private final InternalReferenceBuilderService refBuilder;
	
	public QueryRunner(final PropertyService propertyService, final ConnectionService connectionService, final BusinessObjectResolutionService bor, final InternalReferenceBuilderService refBuilder) {
		this.propertyService = Objects.requireNonNull(propertyService, "propertyService must not be null");
		this.connectionService = Objects.requireNonNull(connectionService, "connectionService must not null");
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
		this.refBuilder = Objects.requireNonNull(refBuilder, "refBuilder must not be null");
	}
	
	/**
	 * same as run() but returns the first result. Returns null if there are no results.
	 * @param query
	 * @param arg
	 * @return
	 */
	public final <A> Object getFirstResult(final Query<A> query, final A arg) {
		final List<?> results = getResults(query, arg);
		if(results.size() == 0) {
			return null;
		}
		
		return results.get(0);
	}
	
	public final <A> List<?> getResults(final Query<A> query, final A arg) {
		Objects.requireNonNull(query, "query must not be null");
		
		final Deque<Query<A>> queryStack = new ArrayDeque<>();
		for(Query<A> q = query; q != null; q = q.getPrev()) {
			queryStack.push(q);
		}

		final Query<A> initialQuery = queryStack.pop();
		final QueryExecutionState<A> state = new QueryExecutionState<>(this, propertyService, connectionService, bor, refBuilder, arg);
		final QueryResult result = new QueryResult();
		initialQuery.run(queryStack, null, state, result);
		
		return (List<?>)result.result;
	}
	
	// Convenience Methods for Queries that return PictogramElement(s). A cast error will occur if an object which is not a PictogramElement is returned from the query
	@SuppressWarnings("unchecked")
	public final <A> List<? extends PictogramElement> getPictogramElements(final Query<A> query, final A arg) {
		return (List<? extends PictogramElement>) getResults(query, arg);
	}
	
	public final <A> PictogramElement getFirstPictogramElement(final Query<A> query, final A arg) {
		return (PictogramElement)getFirstResult(query, arg);
	}
}
