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
package org.osate.ge.ba.ui.palette;

import java.util.Optional;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Subprogram;
import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ge.aadl2.GraphicalAnnexUtil;
import org.osate.ge.ba.BehaviorAnnexReferenceUtil;
import org.osate.ge.ba.util.BehaviorAnnexNamingUtil;
import org.osate.ge.ba.util.BehaviorAnnexUtil;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.GetTargetedOperationContext;
import org.osate.ge.palette.TargetedPaletteCommand;

/**
 * Palette command for creating {@link BehaviorAnnex}.
 */
public class CreateSpecificationPaletteCommand extends BasePaletteCommand implements TargetedPaletteCommand {
	public CreateSpecificationPaletteCommand() {
		super("Behavior Specification", BehaviorAnnexPaletteContributor.BEHAVIOR_ANNEX, null);
	}

	@Override
	public Optional<Operation> getOperation(final GetTargetedOperationContext ctx) {
		return ctx.getTarget().getBusinessObject(ComponentClassifier.class)
				.map(c -> Operation.createSimple(ctx.getTarget(), Classifier.class, modifyBo -> {
					// Create behavior annex
					final BehaviorAnnex ba = createBehaviorAnnex(modifyBo);

					// Builder for state if needed
					final StateBuilder stateBuilder = new StateBuilder(ba);

					// Determine if behavior annex must have initial state
					if (BehaviorAnnexUtil.requireSingleInitialState(modifyBo)) {
						// Set state to initial
						stateBuilder.setInitial();
					}

					// Determine if behavior annex must have a final state
					if (modifyBo instanceof Subprogram) {
						stateBuilder.setFinal();
					}

					// Determine if behavior annex must have a complete state
					if (BehaviorAnnexUtil.requiresCompleteState(modifyBo)) {
						stateBuilder.setComplete();
					}

					// Create state if required
					if (stateBuilder.isStateRequired()) {
						// Add the new state to the behavior annex
						ba.getStates().add(stateBuilder.build());
					}

					// Show new specification
					return StepResultBuilder.create().showNewBusinessObject(ctx.getTarget(), ba.getOwner()).build();
				})).orElse(Optional.empty());
	}

	private static BehaviorAnnex createBehaviorAnnex(final Classifier c) {
		return GraphicalAnnexUtil.createParsedAnnexSubclause(c, BehaviorAnnexReferenceUtil.ANNEX_NAME,
				AadlBaPackage.eINSTANCE.getBehaviorAnnex(), BehaviorAnnex.class);
	}

	/**
	 * Builder to create a state for behavior annexes with the required properties
	 */
	private class StateBuilder {
		private final BehaviorAnnex ba;
		boolean isInitial = false;
		boolean isFinal = false;
		boolean isComplete = false;

		public StateBuilder(final BehaviorAnnex ba) {
			this.ba = ba;
		}

		public boolean isStateRequired() {
			return isInitial || isFinal || isComplete;
		}

		public void setInitial() {
			isInitial = true;
		}

		public void setFinal() {
			isFinal = true;
		}

		public void setComplete() {
			isComplete = true;
		}

		public BehaviorState build() {
			// Create behavior state
			final BehaviorState behaviorState = (BehaviorState) EcoreUtil
					.create(AadlBaPackage.eINSTANCE.getBehaviorState());

			// Set properties required
			behaviorState.setInitial(isInitial);
			behaviorState.setFinal(isFinal);
			behaviorState.setComplete(isComplete);

			// Set state name
			final String newName = BehaviorAnnexNamingUtil.buildUniqueIdentifier(ba, "new_behavior_state");
			behaviorState.setName(newName);

			return behaviorState;
		}
	}
}
