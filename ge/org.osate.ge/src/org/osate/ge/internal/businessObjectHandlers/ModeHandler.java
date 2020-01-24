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
package org.osate.ge.internal.businessObjectHandlers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Mode;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.Categories;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.BuildCreateOperation;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.CanRename;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.ValidateName;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.graphics.AadlGraphics;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.util.AadlInheritanceUtil;
import org.osate.ge.internal.util.EditingUtil;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResult;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.services.QueryService;

public class ModeHandler {
	@IsApplicable
	@CanRename
	@CanDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) Mode mode) {
		return true;
	}

	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) Object diagramBo) {
		final boolean applicable = diagramBo == null || diagramBo instanceof AadlPackage
				|| diagramBo instanceof ComponentClassifier;
		if (!applicable) {
			return null;
		}

		return new PaletteEntry[] { PaletteEntryBuilder.create().label("Mode")
				.icon(ImageHelper.getImage(Aadl2Factory.eINSTANCE.getAadl2Package().getMode()))
				.category(Categories.MODES).build() };
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT) Mode mode,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc) {
		return GraphicalConfigurationBuilder.create().graphic(AadlGraphics.getModeGraphic(mode))
				.style(StyleBuilder
						.create(AadlInheritanceUtil.isInherited(boc) ? Styles.INHERITED_ELEMENT : Style.EMPTY)
						.labelsCenter().build())
				.build();
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) Mode mode) {
		return mode.getName();
	}

	@CanCreate
	public boolean canCreate(final @Named(Names.TARGET_BO) EObject target) {
		return target instanceof ComponentImplementation || target instanceof ComponentClassifier
				|| target instanceof Subcomponent;
	}

	@BuildCreateOperation
	public Operation buildCreateOperation(final @Named(Names.TARGET_BO) EObject target,
			final @Named(Names.TARGET_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext targetBoc,
			final QueryService queryService, final NamingService namingService) {
		if (EditingUtil.showMessageIfSubcomponentOrFeatureGroupWithoutClassifier(target,
				"Set a classifier before creating a mode.")) {
			return null;
		}

		final List<ComponentClassifier> potentialOwners = getPotentialOwners(target);

		// Force the user to select a classifier if the only potential owner is not the exact classifier of the component implementation/subcomponent.
		final boolean forcePrompt = (target instanceof ComponentImplementation || (target instanceof Subcomponent
				&& ((Subcomponent) target).getClassifier() instanceof ComponentImplementation))
				&& potentialOwners.size() > 0 && !(potentialOwners.get(0) instanceof ComponentImplementation);

				final ComponentClassifier selectedClassifier = (ComponentClassifier) EditingUtil
						.getBusinessObjectToModify(potentialOwners, forcePrompt);
				if (selectedClassifier == null) {
					return null;
				}

				return Operation.create(createOp -> {
					createOp.supply(() -> StepResult.forValue(selectedClassifier)).modifyPreviousResult(boToModify -> {
						final String newModeName = namingService.buildUniqueIdentifier(boToModify, "new_mode");

						final Mode newMode = boToModify.createOwnedMode();
						newMode.setInitial(false);
						newMode.setName(newModeName);

						// Clear the no modes flag
						boToModify.setNoModes(false);

						return StepResultBuilder.create().showNewBusinessObject(targetBoc, newMode).build();
					});
				});
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
				addSelfPlusAllExtended((ComponentType) cc, potentialOwners);
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

	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) Mode mode, final @Named(Names.NAME) String value,
			final NamingService namingService) {
		return namingService.checkNameValidity(mode, value);
	}
}
