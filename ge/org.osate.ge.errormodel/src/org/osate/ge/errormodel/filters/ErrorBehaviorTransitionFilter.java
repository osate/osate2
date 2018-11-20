package org.osate.ge.errormodel.filters;

import org.osate.ge.ContentFilter;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;

public class ErrorBehaviorTransitionFilter implements ContentFilter {
	public static final String ID = "emv2.errorBehaviorTransitions";

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Error Behavior Transitions";
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof ErrorBehaviorStateMachine;
	}

	@Override
	public boolean test(Object bo) {
		return bo instanceof ErrorBehaviorTransition;
	}
}
