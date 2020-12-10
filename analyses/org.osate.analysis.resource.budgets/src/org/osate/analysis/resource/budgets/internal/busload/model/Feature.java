package org.osate.analysis.resource.budgets.internal.busload.model;

import org.osate.aadl2.instance.FeatureInstance;

public class Feature extends AnalysisElement {
	private final FeatureInstance featureInstance;
	private final double budget;
	private final double supply;

	public Feature(final FeatureInstance featureInstance, double budget, double supply) {
		super("feature");
		this.featureInstance = featureInstance;
		this.budget = budget;
		this.supply = supply;
	}

	public final FeatureInstance getFeatureInstance() {
		return featureInstance;
	}

	@Override
	void visitSelfPrefix(Visitor visitor) {
		visitor.visitFeaturePrefix(this);
	}

	@Override
	void visitSelfPostfix(Visitor visitor) {
		visitor.visitFeaturePostfix(this);
	}

	public final double getSupply() {
		return supply;
	}

	@Override
	void visitChildren(Visitor visitor) {
		// TODO Auto-generated method stub

	}

}