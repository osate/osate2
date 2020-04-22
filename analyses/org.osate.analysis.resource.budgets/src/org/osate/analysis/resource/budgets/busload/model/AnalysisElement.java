package org.osate.analysis.resource.budgets.busload.model;

/**
 * @since 3.0
 */
abstract class AnalysisElement extends ModelElement {
	private String label;

	/** Actual data requirements in KB/s. */
	private double actual;

	/** Budgeted data requirements in KB/s. */
	private double budget;

	AnalysisElement(final String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public final double getActual() {
		return actual;
	}

	public final void setActual(final double actual) {
		this.actual = actual;
	}

	public final double getBudget() {
		return budget;
	}

	public final void setBudget(final double budget) {
		this.budget = budget;
	}
}
