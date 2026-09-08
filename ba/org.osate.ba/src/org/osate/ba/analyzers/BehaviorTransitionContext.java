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

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.ba.aadlba.BehaviorCondition;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ba.aadlba.BehaviorTransition;

/** Provides transition state and shared condition context for the strict Behavior Annex model. */
public final class BehaviorTransitionContext {
	private BehaviorTransitionContext() {
	}

	/**
	 * Records that a condition copy belongs to the same declarative transition as the original. Conditions are
	 * contained by strict transitions, so expansion needs separate objects even though their syntax is shared.
	 */
	public static void registerConditionCopy(BehaviorCondition copy, BehaviorCondition original) {
		copy.eAdapters().add(new ConditionOrigin(original));
	}

	static BehaviorCondition getOriginalCondition(BehaviorCondition condition) {
		var origin = (ConditionOrigin) EcoreUtil.getExistingAdapter(condition, ConditionOrigin.class);
		return origin == null ? condition : origin.original;
	}

	private static final class ConditionOrigin extends AdapterImpl {
		private final BehaviorCondition original;

		private ConditionOrigin(BehaviorCondition original) {
			this.original = original;
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return type == ConditionOrigin.class;
		}
	}

	static List<BehaviorState> getSourceStates(BehaviorTransition transition) {
		return transition.getSourceState() == null ? List.of() : List.of(transition.getSourceState());
	}

	static BehaviorState getDestinationState(BehaviorTransition transition) {
		return transition.getDestinationState();
	}
}
