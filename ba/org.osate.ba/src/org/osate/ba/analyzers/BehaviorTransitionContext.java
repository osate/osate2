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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.osate.ba.aadlba.BehaviorState;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ba.declarative.DeclarativeBehaviorTransition;
import org.osate.ba.declarative.DeclarativeFactory;
import org.osate.ba.declarative.Identifier;

/**
 * Provides transition state access for both the legacy declarative transition and a detached strict transition.
 */
final class BehaviorTransitionContext {
	private BehaviorTransitionContext() {
	}

	static List<Identifier> getSourceIdentifiers(BehaviorTransition transition) {
		if (transition instanceof DeclarativeBehaviorTransition) {
			return ((DeclarativeBehaviorTransition) transition).getSrcStates();
		}

		BehaviorState source = transition.getSourceState();
		if (source == null) {
			return Collections.emptyList();
		}

		Identifier identifier = DeclarativeFactory.eINSTANCE.createIdentifier();
		identifier.setId(source.getName());
		identifier.setBaRef(source);
		identifier.setLocationReference(source.getLocationReference());
		return Collections.singletonList(identifier);
	}

	static List<BehaviorState> getSourceStates(BehaviorTransition transition) {
		List<BehaviorState> result = new ArrayList<>();
		for (Identifier identifier : getSourceIdentifiers(transition)) {
			if (identifier.getBaRef() instanceof BehaviorState) {
				result.add((BehaviorState) identifier.getBaRef());
			}
		}
		return result;
	}

	static BehaviorState getDestinationState(BehaviorTransition transition) {
		if (transition instanceof DeclarativeBehaviorTransition) {
			Identifier destination = ((DeclarativeBehaviorTransition) transition).getDestState();
			return destination != null && destination.getBaRef() instanceof BehaviorState
					? (BehaviorState) destination.getBaRef()
					: null;
		}
		return transition.getDestinationState();
	}
}
