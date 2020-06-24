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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Mode;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.aadl2.internal.AadlImages;
import org.osate.ge.aadl2.internal.AadlNamingUtil;
import org.osate.ge.aadl2.ui.internal.AadlUiUtil;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.GetTargetedOperationContext;
import org.osate.ge.palette.TargetedPaletteCommand;

public class CreateModePaletteCommand extends BasePaletteCommand implements TargetedPaletteCommand {

	public CreateModePaletteCommand() {
		super("Mode", AadlPaletteCategories.MODES,
				AadlImages.getImage(Aadl2Package.eINSTANCE.getMode()));

	}

	@Override
	public Optional<Operation> getOperation(final GetTargetedOperationContext ctx) {
		final Object targetBo = ctx.getTarget().getBusinessObject();
		if (!(targetBo instanceof ComponentImplementation || targetBo instanceof ComponentClassifier
				|| targetBo instanceof Subcomponent)) {
			return Optional.empty();
		}

		return Optional.of(Operation.createPromptAndModify(() -> {
			if (AadlUiUtil.showMessageIfSubcomponentOrFeatureGroupWithoutClassifier(
					targetBo,
					"Set a classifier before creating a mode.")) {
				return Optional.empty();
			}

			final List<ComponentClassifier> potentialOwners = getPotentialOwners((EObject) targetBo);

			// Force the user to select a classifier if the only potential owner is not the exact classifier of the component implementation/subcomponent.
			final boolean forcePrompt = (targetBo instanceof ComponentImplementation
					|| (targetBo instanceof Subcomponent
							&& ((Subcomponent) targetBo).getClassifier() instanceof ComponentImplementation))
					&& potentialOwners.size() > 0 && !(potentialOwners.get(0) instanceof ComponentImplementation);

					final ComponentClassifier selectedClassifier = AadlUiUtil
							.getBusinessObjectToModify(potentialOwners,
									forcePrompt);
					if (selectedClassifier == null) {
						return Optional.empty();
					}

					return Optional.of(selectedClassifier);
		}, cc -> {
			final String newModeName = AadlNamingUtil.buildUniqueIdentifier(cc, "new_mode");

			final Mode newMode = cc.createOwnedMode();
			newMode.setInitial(false);
			newMode.setName(newModeName);

			// Clear the no modes flag
			cc.setNoModes(false);

			return StepResultBuilder.create().showNewBusinessObject(ctx.getTarget(), newMode).build();
		}));
	}

	private static List<ComponentClassifier> getPotentialOwners(final EObject target) {
		final List<Classifier> potentialOwners = new ArrayList<>();
		if (target instanceof ComponentImplementation) {
			final ComponentImplementation ci = (ComponentImplementation) target;
			if (ci.getType() != null && !ci.getType().getAllModes().isEmpty()) {
				addSelfPlusAllExtended(ci.getType(), potentialOwners);
			} else {
				potentialOwners.add(ci);
			}
		} else if (target instanceof ComponentType) {
			potentialOwners.add((ComponentType) target);
		} else if (target instanceof Subcomponent) {
			final ComponentClassifier cc = ((Subcomponent) target).getClassifier();
			if (cc instanceof ComponentImplementation) {
				// Include component implementations if the component type(s) do not have any modes
				final ComponentImplementation ci = (ComponentImplementation) cc;
				final boolean includeComponentImplementations = ci.getType() != null
						&& ci.getType().getAllModes().isEmpty();
				if (includeComponentImplementations) {
					addSelfPlusAllExtended(ci, potentialOwners);
				}

				// Include component types if the component implementation does not have any modes
				boolean includeComponentTypes = true;
				for (final Classifier tmpCi : ci.getSelfPlusAllExtended()) {
					if (tmpCi instanceof ComponentImplementation
							&& ((ComponentImplementation) tmpCi).getOwnedModes().size() > 0) {
						includeComponentTypes = false;
						break;
					}
				}

				if (includeComponentTypes) {
					addSelfPlusAllExtended(((ComponentImplementation) cc).getType(), potentialOwners);
				}
			} else if (cc instanceof ComponentType) {
				addSelfPlusAllExtended(cc, potentialOwners);
			}
		} else {
			throw new RuntimeException("Unexpected target: " + target);
		}

		return potentialOwners.stream().filter(c -> c instanceof ComponentClassifier)
				.map(ComponentClassifier.class::cast).collect(Collectors.toList());
	}

	private static void addSelfPlusAllExtended(final Classifier c, final List<Classifier> results) {
		if (c != null) {
			for (final Classifier tmpClassifier : c.getSelfPlusAllExtended()) {
				results.add(tmpClassifier);
			}
		}
	}
}
