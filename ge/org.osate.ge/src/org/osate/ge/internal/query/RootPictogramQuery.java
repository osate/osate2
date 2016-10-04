package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.Objects;
import java.util.function.Supplier;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public class RootPictogramQuery extends PictogramQuery<Object> {
	private final Supplier<PictogramElement> supplier;
	
	public RootPictogramQuery(final Supplier<PictogramElement> supplier) {
		super(null);
		this.supplier = Objects.requireNonNull(supplier, "supplier must not be null");
	}

	@Override
	void run(final Deque<Query<Object>> remainingQueries, final Object ctx, final QueryExecutionState<Object> state, final QueryResult result) {		
		final Object suppliedObject = supplier.get();
		if(suppliedObject == null) {
			result.done = true;
			return;
		}

		processResultValue(remainingQueries, suppliedObject, state, result);
	}
}
