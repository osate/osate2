package org.osate.ge.errormodel.filters;

import org.osate.ge.FundamentalContentFilter;
import org.osate.ge.errormodel.model.BehaviorTransitionTrunk;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;

public class FundamentalErrorBusinessObjectFilter implements FundamentalContentFilter {
	@Override
	public boolean test(Object bo) {
		return bo instanceof TransitionBranch || bo instanceof BehaviorTransitionTrunk;
	}
}
