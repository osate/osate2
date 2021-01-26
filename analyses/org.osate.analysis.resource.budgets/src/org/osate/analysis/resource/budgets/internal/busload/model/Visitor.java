package org.osate.analysis.resource.budgets.internal.busload.model;

public interface Visitor<S> {
	default S updateStateForChild(S state) {
		return state;
	}
}
