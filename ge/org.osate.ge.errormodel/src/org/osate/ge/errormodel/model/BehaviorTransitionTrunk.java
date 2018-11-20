package org.osate.ge.errormodel.model;

import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.osate.ge.EmfContainerProvider;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;

public class BehaviorTransitionTrunk implements EmfContainerProvider {
	private final ErrorBehaviorTransition transition;

	public BehaviorTransitionTrunk(final ErrorBehaviorTransition transition) {
		this.transition = Objects.requireNonNull(transition, "transition must not be null");
	}

	public final ErrorBehaviorTransition getTransition() {
		return transition;
	}

	@Override
	public EObject getEmfContainer() {
		return transition;
	}
}
