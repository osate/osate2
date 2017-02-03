package org.osate.ge.internal.query;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.query.FilterArguments;

/**
 * Simple implementation of ConditionArguments and FilterArguments
 * @param <A> is the type of the query argument
 */
public class ExpressionArguments<A> implements ConditionArguments<A>, FilterArguments<A> {
	private QueryExecutionState<A> state;
	private PictogramElement pe;

	void update(final QueryExecutionState<A> state, final PictogramElement pe) {
		this.state = state;
		this.pe = pe;			
	}		
	
	@Override
	public Object getBusinessObject() {
		return state.bor.getBusinessObjectForPictogramElement(pe);
	}

	@Override
	public A getQueryArgument() {
		return state.arg;
	}	
}
