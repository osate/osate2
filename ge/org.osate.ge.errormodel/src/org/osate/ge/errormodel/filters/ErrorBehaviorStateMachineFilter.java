package org.osate.ge.errormodel.filters;

import org.osate.aadl2.AadlPackage;
import org.osate.ge.ContentFilter;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;

public class ErrorBehaviorStateMachineFilter implements ContentFilter {
	public static final String ID = "emv2.stateMachines";

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Error Behavior State Machines";
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof AadlPackage;
	}

	@Override
	public boolean test(Object bo) {
		return bo instanceof ErrorBehaviorStateMachine;
	}
}
