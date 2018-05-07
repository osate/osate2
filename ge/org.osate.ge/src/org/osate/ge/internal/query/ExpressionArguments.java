package org.osate.ge.internal.query;

import org.osate.ge.query.FilterArguments;

/**
 * Simple implementation of ConditionArguments and FilterArguments
 * @param  is the type of the query argument
 */
public class ExpressionArguments implements ConditionArguments, FilterArguments {
	private QueryExecutionState state;
	private Queryable container;

	void update(final QueryExecutionState state, final Queryable container) {
		this.state = state;
		this.container = container;
	}		
	
	@Override
	public Object getBusinessObject() {
		return container.getBusinessObject();
	}

	@Override
	public Object getQueryArgument() {
		return state.arg;
	}	
}
