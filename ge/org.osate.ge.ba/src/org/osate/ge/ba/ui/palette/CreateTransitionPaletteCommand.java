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
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.CanStartConnectionContext;
import org.osate.ge.palette.CreateConnectionPaletteCommand;
import org.osate.ge.palette.GetCreateConnectionOperationContext;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

/**
 * Palette command for create {@link BehaviorTransition}.
 */
public class CreateTransitionPaletteCommand extends BasePaletteCommand implements CreateConnectionPaletteCommand {
	private static final StandaloneQuery containerQuery = StandaloneQuery
			.create((root) -> root.ancestors().filter((fa) -> fa.getBusinessObject() instanceof BehaviorAnnex).first());

	public CreateTransitionPaletteCommand() {
		super("Behavior Transition", BehaviorAnnexPaletteContributor.BEHAVIOR_ANNEX, null);
	}

	@Override
	public boolean canStartConnection(final CanStartConnectionContext ctx) {
		return ctx.getSource().getBusinessObject(BehaviorState.class).isPresent();
	}

	@Override
	public Optional<Operation> getOperation(final GetCreateConnectionOperationContext ctx) {
		if (!ctx.getDestination().getBusinessObject(BehaviorState.class).isPresent()) {
			return Optional.empty();
		}

		final BusinessObjectContext srcContainer = getOwnerBoc(ctx.getSource(), ctx.getQueryService());
		if (srcContainer == null) {
			return Optional.empty();
		}

		final BusinessObjectContext dstContainer = getOwnerBoc(ctx.getDestination(), ctx.getQueryService());
		if (dstContainer != srcContainer) {
			return Optional.empty();
		}

		final BehaviorState srcState = ctx.getSource().getBusinessObject(BehaviorState.class).get();
		final BehaviorState dstState = ctx.getDestination().getBusinessObject(BehaviorState.class).get();
		if (srcState == dstState) {
			return Optional.empty();
		}

		return srcContainer.getBusinessObject(BehaviorAnnex.class)
				.map(ba -> Operation.createSimple(srcContainer, BehaviorAnnex.class, boToModify -> {
					final BehaviorTransition baTransition = (BehaviorTransition) EcoreUtil
							.create(AadlBaPackage.eINSTANCE.getBehaviorTransition());

					final String srcName = srcState.getName();
					final String dstName = dstState.getName();
					if (srcName == null || dstName == null) {
						return StepResultBuilder.create().abort().build();
					}

					// Set source and destination for transition
					for (final BehaviorState behaviorState : boToModify.getStates()) {
						final String name = behaviorState.getName();
						if (srcName.equalsIgnoreCase(name)) { // Source
							baTransition.setSourceState(behaviorState);
						} else if (dstName.equalsIgnoreCase(name)) { // Destination
							baTransition.setDestinationState(behaviorState);
						}
					}

					// Add new transition
					boToModify.getTransitions().add(baTransition);

					// Show
					return StepResultBuilder.create().showNewBusinessObject(srcContainer, baTransition).build();
				})).orElse(Optional.empty());
	}

	private static BusinessObjectContext getOwnerBoc(final BusinessObjectContext modeBoc,
			final QueryService queryService) {
		return queryService.getFirstBusinessObjectContextOrNull(containerQuery, modeBoc);
	}
}
