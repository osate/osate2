package org.osate.ge.internal.query;

import org.osate.ge.query.FilterArguments;

/**
 * Simple implementation of ConditionArguments and FilterArguments
 * @param <A> is the type of the query argument
 */
public class ExpressionArguments<A> implements ConditionArguments<A>, FilterArguments<A> {
	private QueryExecutionState<A> state;
	private Queryable container;

	void update(final QueryExecutionState<A> state, final Queryable container) {
		this.state = state;
		this.container = container;
	}		
	
	@Override
	public Object getBusinessObject() {
		return container.getBusinessObject();
	}

	@Override
	public A getQueryArgument() {
		return state.arg;
	}	
}
