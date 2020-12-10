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
		// TODO Auto-generated method stub

	}

	@Override
	void visitChildren(Visitor visitor) {
		// TODO Auto-generated method stub

	}

	@Override
	void visitSelfPostfix(Visitor visitor) {
		// TODO Auto-generated method stub

	}

}