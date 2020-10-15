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
package org.osate.ge.aadl2.ui.internal.palette;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.aadl2.internal.AadlImages;
import org.osate.ge.aadl2.internal.AadlNamingUtil;
import org.osate.ge.aadl2.ui.internal.AadlUiUtil;
import org.osate.ge.aadl2.ui.internal.dialogs.ModeTransitionTriggerSelectionDialog;
import org.osate.ge.aadl2.ui.internal.dialogs.ModeTransitionTriggerSelectionDialog.ModeTransitionTriggerInfo;
import org.osate.ge.operations.BusinessObjectAndExtra;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.CanStartConnectionContext;
import org.osate.ge.palette.CreateConnectionPaletteCommand;
import org.osate.ge.palette.GetCreateConnectionOperationContext;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class CreateModeTransitionPaletteCommand extends BasePaletteCommand implements CreateConnectionPaletteCommand {
	private static final StandaloneQuery containerQuery = StandaloneQuery
			.create((root) -> root.ancestors().filter((fa) -> fa.getBusinessObject() instanceof ComponentClassifier
					|| fa.getBusinessObject() instanceof Subcomponent).first());

	public CreateModeTransitionPaletteCommand() {
		super("Mode Transition", AadlPaletteCategories.MODES,
				AadlImages.getImage(Aadl2Package.eINSTANCE.getModeTransition()));

	}

	@Override
	public boolean canStartConnection(final CanStartConnectionContext ctx) {
		return ctx.getSource().getBusinessObject(Mode.class).isPresent()
				&& getPotentialOwnersByMode(ctx.getSource(), ctx.getQueryService()).size() > 0;
	}

	@Override
	public Optional<Operation> getOperation(final GetCreateConnectionOperationContext ctx) {
		if (!ctx.getDestination().getBusinessObject(Mode.class).isPresent()) {
			return Optional.empty();
		}

		final List<ComponentClassifier> potentialOwners = getPotentialOwners(ctx.getSource(), ctx
				.getDestination(),
				ctx.getQueryService());
		if (potentialOwners.size() == 0) {
			return Optional.empty();
		}

		final BusinessObjectContext container = getOwnerBoc(ctx.getSource(), ctx.getQueryService());
		if (container == null) {
			return Optional.empty();
		}

		final Mode srcMode = ctx.getSource().getBusinessObject(Mode.class).get();
		final Mode dstMode = ctx.getDestination().getBusinessObject(Mode.class).get();

		return Optional.of(Operation.createPromptAndModifyWithExtra(() -> {
			// Determine which classifier should own the new element
			final ComponentClassifier selectedClassifier = AadlUiUtil.getBusinessObjectToModify(potentialOwners);
			if (selectedClassifier == null) {
				return Optional.empty();
			}

			// Prompt for transition triggers
			final ModeTransitionTriggerInfo[] selectedTriggers = ModeTransitionTriggerSelectionDialog
					.promptForTriggers(selectedClassifier, null);
			if (selectedTriggers == null) {
				return Optional.empty();
			}

			return Optional.of(new BusinessObjectAndExtra<>(selectedClassifier, selectedTriggers));
		}, args -> {
			final ComponentClassifier cc = args.getBusinessObject();

			// Determine the name for the new mode transition
			final String newElementName = AadlNamingUtil.buildUniqueIdentifier(cc, "new_transition");

			// Create the new mode transition
			final ModeTransition newModeTransition = cc.createOwnedModeTransition();

			// Clear the no modes flag
			cc.setNoModes(false);

			// Set the name
			newModeTransition.setName(newElementName);

			// Set the source and destination
			newModeTransition.setSource(srcMode);
			newModeTransition.setDestination(dstMode);

			// Create Triggers
			for (ModeTransitionTriggerInfo selectedPort : args.getExtra()) {
				final ModeTransitionTrigger mtt = newModeTransition.createOwnedTrigger();
				mtt.setTriggerPort(selectedPort.port);
				mtt.setContext(selectedPort.context);
			}

			return StepResultBuilder.create().showNewBusinessObject(container, newModeTransition).build();
		}));
	}

	private List<ComponentClassifier> getPotentialOwners(final BusinessObjectContext srcBoc,
			final BusinessObjectContext dstBoc, final QueryService queryService) {
		final List<ComponentClassifier> potentialOwners = getPotentialOwnersByMode(srcBoc, queryService);
		potentialOwners.retainAll(getPotentialOwnersByMode(dstBoc, queryService));
		return potentialOwners;
	}

	private static BusinessObjectContext getOwnerBoc(final BusinessObjectContext modeBoc,
			final QueryService queryService) {
		return queryService.getFirstBusinessObjectContextOrNull(containerQuery, modeBoc);
	}

	private static List<ComponentClassifier> getPotentialOwnersByMode(final BusinessObjectContext modeBoc,
			final QueryService queryService) {

		final Mode mode = (Mode) modeBoc.getBusinessObject();
		final String modeName = mode.getName();
		if (modeName == null) {
			return Collections.emptyList();
		}

		final BusinessObjectContext containerBoc = getOwnerBoc(modeBoc, queryService);
		if (containerBoc == null) {
			return Collections.emptyList();
		}

		final Element bo = (Element) containerBoc.getBusinessObject();

		return AadlUiUtil.getPotentialComponentClassifiers(bo)
				.stream()
				.filter(tmpBo -> tmpBo instanceof ComponentClassifier && !(tmpBo.isDerivedModes()))
				.filter(cc -> hasModeWithName(cc, modeName)).collect(Collectors.toList());
	}

	private static boolean hasModeWithName(final ComponentClassifier cc, final String nameToCheck) {
		return cc.getAllModes().stream().map(m -> m.getName()).anyMatch(n -> nameToCheck.equalsIgnoreCase(n));
	}
}
