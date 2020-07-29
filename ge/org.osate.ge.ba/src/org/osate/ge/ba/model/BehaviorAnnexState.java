package org.osate.ge.ba.model;

import org.eclipse.emf.ecore.EObject;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ge.EmfContainerProvider;

public class BehaviorAnnexState implements EmfContainerProvider {
	private final BehaviorState state;

	public BehaviorAnnexState(final BehaviorState state) {
		this.state = state;
	}

	public BehaviorState getState() {
		return state;
	}

	@Override
	public EObject getEmfContainer() {
		return state.eContainer();
	}
}
