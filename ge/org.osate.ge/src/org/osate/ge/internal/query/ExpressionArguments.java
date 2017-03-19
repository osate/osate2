package org.osate.ge.internal.query;

import org.osate.ge.internal.diagram.AgeDiagramElement;
import org.osate.ge.internal.diagram.DiagramElementContainer;
import org.osate.ge.query.FilterArguments;

/**
 * Simple implementation of ConditionArguments and FilterArguments
 * @param <A> is the type of the query argument
 */
public class ExpressionArguments<A> implements ConditionArguments<A>, FilterArguments<A> {
	private QueryExecutionState<A> state;
	private DiagramElementContainer diagramElementContainer;

	void update(final QueryExecutionState<A> state, final DiagramElementContainer diagramElementContainer) {
		this.state = state;
		this.diagramElementContainer = diagramElementContainer;
	}		
	
	@Override
	public Object getBusinessObject() {
		return diagramElementContainer instanceof AgeDiagramElement ? ((AgeDiagramElement)diagramElementContainer).getBusinessObject() : null;
	}

	@Override
	public A getQueryArgument() {
		return state.arg;
	}	
}
