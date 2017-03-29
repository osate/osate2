package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.Objects;
import java.util.function.Supplier;
import org.osate.ge.internal.diagram.DiagramNode;

public class RootAgeDiagramNodeQuery extends DiagramNodeQuery<Object> {
	private final Supplier<DiagramNode> supplier;
	
	public RootAgeDiagramNodeQuery(final Supplier<DiagramNode> supplier) {
		super(null);
		this.supplier = Objects.requireNonNull(supplier, "supplier must not be null");
	}

	@Override
	void run(final Deque<DiagramNodeQuery<Object>> remainingQueries, final DiagramNode ctx, final QueryExecutionState<Object> state, final QueryResult result) {		
		final DiagramNode suppliedObject = supplier.get();
		if(suppliedObject == null) {
			result.done = true;
			return;
		}

		processResultValue(remainingQueries, suppliedObject, state, result);
	}
}
