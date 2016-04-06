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
	void run(final Deque<Query<Object>> remainingQueries, final Object ctx, final QueryArguments<Object> args, final QueryResult result) {		
		System.err.println("RUN: " + this);
		final Object suppliedObject = supplier.get();
		if(suppliedObject == null) {
			// TODO: Mark as done. null result
			return;
		}

		processResultValue(remainingQueries, suppliedObject, args, result);
	}
}
