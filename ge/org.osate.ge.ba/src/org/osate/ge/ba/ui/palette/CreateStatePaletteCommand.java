/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
import org.osate.ge.ba.util.BehaviorAnnexNamingUtil;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.GetTargetedOperationContext;
import org.osate.ge.palette.TargetedPaletteCommand;

/**
 * Palette command for creating {@link BehaviorState}.
 */
public class CreateStatePaletteCommand extends BasePaletteCommand implements TargetedPaletteCommand {
	public CreateStatePaletteCommand() {
		super("Behavior State", BehaviorAnnexPaletteContributor.BEHAVIOR_ANNEX, null);
	}

	@Override
	public Optional<Operation> getOperation(final GetTargetedOperationContext ctx) {
		return ctx.getTarget().getBusinessObject(BehaviorAnnex.class)
				.map(ba -> Operation.createSimple(ctx.getTarget(), BehaviorAnnex.class, baToModify -> {
					// Create the state
					final BehaviorState newState = (BehaviorState) EcoreUtil
							.create(AadlBaPackage.eINSTANCE.getBehaviorState());
					final String newName = BehaviorAnnexNamingUtil.buildUniqueIdentifier(baToModify, "new_state");
					newState.setName(newName);

					// Add the new state to the behavior annex
					baToModify.getStates().add(newState);
					return StepResultBuilder.create()
							.showNewBusinessObject(ctx.getTarget(), newState).build();
				})).orElse(Optional.empty());
	}
}
