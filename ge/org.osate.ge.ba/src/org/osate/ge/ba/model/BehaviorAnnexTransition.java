package org.osate.ge.ba.model;

import org.eclipse.emf.ecore.EObject;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ge.EmfContainerProvider;

public class BehaviorAnnexTransition implements EmfContainerProvider {
	private final BehaviorTransition transition;
	private final BehaviorAnnexState srcState;
	private final BehaviorAnnexState dstState;

	public BehaviorAnnexTransition(final BehaviorTransition transition, final BehaviorAnnexState src,
			final BehaviorAnnexState dst) {
		this.transition = transition;
		this.srcState = src;
		this.dstState = dst;
	}

	public BehaviorTransition getTransition() {
		return transition;
	}

	public BehaviorAnnexState getSource() {
		return srcState;
	}

	public BehaviorAnnexState getDestination() {
		return dstState;
	}

	@Override
	public EObject getEmfContainer() {
		return transition;
	}
}
