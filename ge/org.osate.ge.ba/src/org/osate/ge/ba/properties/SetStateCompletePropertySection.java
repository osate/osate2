/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.ba.properties;

import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.swt.widgets.Button;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Subprogram;
import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ba.aadlba.DispatchCondition;
import org.osate.ge.ba.util.BehaviorAnnexHandlerUtil;
import org.osate.ge.ui.PropertySectionUtil;

public class SetStateCompletePropertySection extends StatePropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> {
//				if (bo instanceof BehaviorState) {
//					final BehaviorState behaviorState = (BehaviorState) bo;
//					final Classifier classifier = behaviorState.getContainingClassifier();
//					// Subprograms cannot have complete states
//					return !(classifier instanceof Subprogram);
//				}

				return bo instanceof BehaviorState;
			});
		}
	}

	public SetStateCompletePropertySection() {
		super("Complete:", "Set Complete State", (e) -> {
			final Button btn = (Button) e.widget;
			final boolean isComplete = btn.getSelection();
			return (behaviorState, boc) -> {
				final Consumer<BehaviorTransition> modifyTransitionForCompleteSourceStates = getModificationForTransition(
						isComplete);
				BehaviorAnnexHandlerUtil.getTransitionsForSourceState(behaviorState).forEach(behaviorTransition -> {
					modifyTransitionForCompleteSourceStates.accept(behaviorTransition);
				});

				// Set initial state
				behaviorState.setComplete(isComplete);
			};
		});
	}

	private static Consumer<BehaviorTransition> getModificationForTransition(final boolean isComplete) {
		final Consumer<BehaviorTransition> modifyTransitionForCompleteSourceStates;
		if (isComplete) {
			modifyTransitionForCompleteSourceStates = (behaviorTransition) -> {
				// Source states that are complete require dispatch conditions
				final DispatchCondition dispatchCondition = (DispatchCondition) EcoreUtil
						.create(AadlBaPackage.eINSTANCE.getDispatchCondition());
				behaviorTransition.setCondition(dispatchCondition);
			};
		} else {
			modifyTransitionForCompleteSourceStates = (behaviorTransition) -> {
				// Remove dispatch condition for transitions
				behaviorTransition.setCondition(null);
			};
		}

		return modifyTransitionForCompleteSourceStates;
	}

	@Override
	public void refresh() {
		final Set<BehaviorState> behaviorStates = getSelectedBos().boStream(BehaviorState.class)
				.collect(Collectors.toSet());
		// Only allow editing 1 element
		final boolean isSingleSelection = behaviorStates.size() == 1;
		final BehaviorState selectedState = behaviorStates.iterator().next();
		// Set button enabled and selection state
		final boolean isCompleteState = selectedState.isComplete();
		final Button setCompleteStateBtn = getStateButton();

		// Set selection based on selected state(s)
		setCompleteStateBtn.setSelection(isCompleteState);

		if (isSingleSelection) {
			final Classifier classifier = selectedState.getContainingClassifier();
			if (classifier instanceof Subprogram) {
				// Subprograms do not allow complete states
				setCompleteStateBtn.setEnabled(false);
			} else if (isCompleteState) {
				// Removing complete state
				// If classifier requires complete state, check if this complete state can be removed.
				boolean allowRemovingCompleteness = true;
				if (BehaviorAnnexHandlerUtil.requiresCompleteState(classifier)) {
					// Check if completeness can be removed
					allowRemovingCompleteness = allowRemoveCompleteness(classifier, selectedState);
				}

				setCompleteStateBtn.setEnabled(allowRemovingCompleteness);
			} else {
				// Check if state is a source, if dispatch is not allowed, cannot make state complete
				// If already a source, cannot make complete if dispatch is not allowed
				final Optional<BehaviorTransition> transition = BehaviorAnnexHandlerUtil
						.getTransitionsForSourceState(selectedState).findAny();
				boolean allowAddingCompleteness = true;
				if (transition.isPresent()) {
					allowAddingCompleteness = BehaviorAnnexHandlerUtil.allowsOnDispatchConditions(classifier);
				}

				setCompleteStateBtn.setEnabled(allowAddingCompleteness);
			}
		} else {
			// Set selection state for first selection
			// Always disabled for multiple selection
			setCompleteStateBtn.setEnabled(false);
		}
	}

	// Check if completeness can be removed from behavior state
	private static boolean allowRemoveCompleteness(final Classifier classifier, final BehaviorState behaviorState) {
		// Check if another complete state exists
		final BehaviorAnnex behaviorAnnex = (BehaviorAnnex) behaviorState.getOwner();
		return behaviorAnnex.getStates().stream().filter(BehaviorState::isComplete).count() > 1;
	}
}
