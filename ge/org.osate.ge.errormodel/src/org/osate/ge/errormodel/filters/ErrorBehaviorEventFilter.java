package org.osate.ge.errormodel.filters;

import org.osate.ge.ContentFilter;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;

public class ErrorBehaviorEventFilter implements ContentFilter {
	public static final String ID = "emv2.errorBehaviorEvents";

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Error Behavior Events";
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof ErrorBehaviorStateMachine;
	}

	@Override
	public boolean test(Object bo) {
		return bo instanceof ErrorBehaviorEvent;
	}
}
