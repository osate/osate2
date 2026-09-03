/**
 * AADL-BA-FrontEnd
 *
 * Copyright (c) 2011-2021 TELECOM ParisTech and CNRS
 *
 * TELECOM ParisTech/LTCI
 *
 * Authors: see AUTHORS
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 2.0 of the License, or (at your option) any later version.
 */
package org.osate.ba.analyzers;

import java.util.List;

import org.osate.ba.aadlba.BehaviorState;
import org.osate.ba.aadlba.BehaviorTransition;

/** Provides transition state access for the strict Behavior Annex model. */
final class BehaviorTransitionContext {
	private BehaviorTransitionContext() {
	}

	static List<BehaviorState> getSourceStates(BehaviorTransition transition) {
		return transition.getSourceState() == null ? List.of() : List.of(transition.getSourceState());
	}

	static BehaviorState getDestinationState(BehaviorTransition transition) {
		return transition.getDestinationState();
	}
}
