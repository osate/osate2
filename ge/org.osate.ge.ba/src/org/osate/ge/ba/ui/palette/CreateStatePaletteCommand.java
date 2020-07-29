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
import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ge.ba.model.BehaviorAnnexState;
import org.osate.ge.ba.util.BaNamingUtil;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.GetTargetedOperationContext;
import org.osate.ge.palette.TargetedPaletteCommand;

public class CreateStatePaletteCommand extends BasePaletteCommand implements TargetedPaletteCommand {
	public CreateStatePaletteCommand() {
		super("State", BaPaletteCategories.BEHAVIOR_ANNEX, null);
	}

	@Override
	public Optional<Operation> getOperation(final GetTargetedOperationContext ctx) {
		return ctx.getTarget().getBusinessObject(BehaviorAnnex.class)
				.map(ba -> Operation.createSimple(ctx.getTarget(), BehaviorAnnex.class, baToModify -> {
					// Create the state
					final BehaviorState newState = (BehaviorState) EcoreUtil
							.create(AadlBaPackage.eINSTANCE.getBehaviorState());
					final String newName = BaNamingUtil.buildUniqueIdentifier(baToModify, "new_state");
					newState.setName(newName);

					// Set as initial state if the behavior annex does not have an initial state.
					if (baToModify.getInitialState() == null) {
						newState.setInitial(true);
					}

					// TODO set final because if you don't, no other states are able to be added to it
					// Must have a final state or the error that is created does not let any more states be added
					if (!baToModify.getStates().stream().filter(BehaviorState::isFinal).findAny().isPresent()) {
						newState.setFinal(true);
					}

					// Add the new state to the behavior annex
					baToModify.getStates().add(newState);

					return StepResultBuilder.create()
							.showNewBusinessObject(ctx.getTarget(), new BehaviorAnnexState(newState)).build();
				})).orElse(Optional.empty());
	}
}
