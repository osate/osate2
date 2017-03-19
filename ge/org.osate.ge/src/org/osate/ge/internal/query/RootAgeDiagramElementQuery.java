package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.Objects;
import java.util.function.Supplier;
import org.osate.ge.internal.diagram.DiagramElementContainer;

public class RootAgeDiagramElementQuery extends AgeDiagramElementQuery<Object> {
	private final Supplier<DiagramElementContainer> supplier;
	
	public RootAgeDiagramElementQuery(final Supplier<DiagramElementContainer> supplier) {
		super(null);
		this.supplier = Objects.requireNonNull(supplier, "supplier must not be null");
	}

	@Override
	void run(final Deque<AgeDiagramElementQuery<Object>> remainingQueries, final DiagramElementContainer ctx, final QueryExecutionState<Object> state, final QueryResult result) {		
		final DiagramElementContainer suppliedObject = supplier.get();
		if(suppliedObject == null) {
			result.done = true;
			return;
		}

		processResultValue(remainingQueries, suppliedObject, state, result);
	}
}
