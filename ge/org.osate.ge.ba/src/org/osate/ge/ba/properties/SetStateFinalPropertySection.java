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

import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.swt.widgets.Button;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Subprogram;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ge.ba.util.BehaviorAnnexUtil;

/**
 * Property section for setting {@link BehaviorState} to final.
 */
public class SetStateFinalPropertySection extends StatePropertySection {
	public SetStateFinalPropertySection() {
		super("Final:", "Set Final State", (e) -> {
			final Button btn = (Button) e.widget;
			final boolean isFinal = btn.getSelection();
			return (behaviorState, boc) -> {
				final BehaviorAnnex behaviorAnnex = (BehaviorAnnex) behaviorState.eContainer();
				final Classifier classifier = behaviorAnnex.getContainingClassifier();
				// Subprogram requires one and only one final state
				if (isFinal && classifier instanceof Subprogram) {
					// Remove final from other states
					behaviorAnnex.getStates().forEach(state -> state.setFinal(false));
				}

				// Set final state
				behaviorState.setFinal(isFinal);
			};
		});
	}

	@Override
	public void refresh() {
		final Set<BehaviorState> behaviorStates = getSelectedBos().boStream(BehaviorState.class)
				.collect(Collectors.toSet());
		// Only allow editing 1 element
		final boolean isSingleSelection = behaviorStates.size() == 1;
		final BehaviorState selectedState = behaviorStates.iterator().next();
		final boolean isFinalState = selectedState.isFinal();
		// Set button enabled and selection state
		final Button setFinalStateBtn = getStateButton();
		// Set selection state for first selection
		setFinalStateBtn.setSelection(isFinalState);
		if (isSingleSelection) {
			if (isFinalState) {
				// Determine if final can be removed from state
				final Classifier classifier = selectedState.getContainingClassifier();
				// Subprograms require single final state
				setFinalStateBtn.setEnabled(!(classifier instanceof Subprogram));
			} else {
				// Determine if final can be set for state
				// If behavior state is a source of a transition, it cannot be final
				final boolean isSourceState = BehaviorAnnexUtil.getTransitionsForSourceState(selectedState)
						.findAny().isPresent();
				setFinalStateBtn.setEnabled(!isSourceState);
			}
		} else {
			// Always disabled for multiple selection
			setFinalStateBtn.setEnabled(false);
		}
	}
}
