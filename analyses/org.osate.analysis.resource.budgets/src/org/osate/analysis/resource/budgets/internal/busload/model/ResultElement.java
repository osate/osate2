package org.osate.analysis.resource.budgets.internal.busload.model;

import org.osate.result.Result;

public abstract class ResultElement extends ModelElement {
	// Returns myResult for convenience
	protected static Result addResultToParent(final Result parentResult, final Result myResult) {
		parentResult.getSubResults().add(myResult);
		return myResult;
	}

	public abstract Result makeResult(Result parentResult);
}
