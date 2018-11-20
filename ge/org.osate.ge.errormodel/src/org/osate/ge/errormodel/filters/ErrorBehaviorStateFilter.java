package org.osate.ge.errormodel.filters;

import org.osate.ge.ContentFilter;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;

public class ErrorBehaviorStateFilter implements ContentFilter {
	public static final String ID = "emv2.errorBehaviorStates";

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Error Behavior States";
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof ErrorBehaviorStateMachine;
	}

	@Override
	public boolean test(Object bo) {
		return bo instanceof ErrorBehaviorState;
	}
}
