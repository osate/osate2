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

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Named;

import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
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
import org.osate.ge.di.CanStartConnection;
import org.osate.ge.di.GetCreateOwner;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.ValidateName;
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.graphics.AadlGraphics;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.ui.dialogs.ModeTransitionTriggerSelectionDialog;
import org.osate.ge.internal.ui.dialogs.ModeTransitionTriggerSelectionDialog.ModeTransitionTriggerInfo;
import org.osate.ge.internal.util.AadlInheritanceUtil;
import org.osate.ge.internal.util.EditingUtil;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResult;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class ModeTransitionHandler {
	private static final StandaloneQuery containerQuery = StandaloneQuery
			.create((root) -> root.ancestors().filter((fa) -> fa.getBusinessObject() instanceof ComponentClassifier
					|| fa.getBusinessObject() instanceof Subcomponent).first());
	private static StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().children().filterByBusinessObjectRelativeReference((ModeTransition mt) -> mt.getSource()));
	private static StandaloneQuery dstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().children().filterByBusinessObjectRelativeReference((ModeTransition mt) -> mt.getDestination()));

	@IsApplicable
	@CanRename
	@CanDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ModeTransition mt) {
		return true;
	}

	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) Object diagramBo) {
		final boolean applicable = diagramBo == null || diagramBo instanceof AadlPackage || diagramBo instanceof ComponentClassifier;
		if(!applicable) {
			return null;
		}

		return new PaletteEntry[] {
				PaletteEntryBuilder.create().connectionCreation().label("Mode Transition").icon(ImageHelper.getImage(Aadl2Factory.eINSTANCE.getAadl2Package().getModeTransition())).category(Categories.MODES).build()
		};
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final QueryService queryService) {
		return GraphicalConfigurationBuilder.create().
				graphic(AadlGraphics.getModeTransitionGraphic()).
				source(getSource(boc, queryService)).
				destination(getDestination(boc, queryService)).
				style(StyleBuilder.create(
						AadlInheritanceUtil.isInherited(boc) ? Styles.INHERITED_ELEMENT : Style.EMPTY)
						.backgroundColor(Color.BLACK)
						.build())
				.build();
	}

	private BusinessObjectContext getSource(final BusinessObjectContext boc,
			final QueryService queryService) {
		return queryService.getFirstResult(srcQuery, boc);
	}

	private BusinessObjectContext getDestination(final BusinessObjectContext boc,
			final QueryService queryService) {
		return queryService.getFirstResult(dstQuery, boc);
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ModeTransition mt) {
		return mt.getName() == null ? "" : mt.getName();
	}

	@GetCreateOwner
	public BusinessObjectContext getCreateConnectionOwner(@Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext srcBoc,
			final QueryService queryService) {
		return queryService.getFirstResult(containerQuery, srcBoc);
	}

	@CanStartConnection
	public boolean canStartConnection(@Named(Names.SOURCE_BO) final Mode mode,
			@Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext modeBoc,
			final QueryService queryService) {
		return getPotentialOwnersByMode(modeBoc, queryService).size() > 0;
	}

	@CanCreate
	public boolean canCreate(@Named(Names.SOURCE_BO) final Mode srcMode,
			@Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext srcBoc,
			@Named(Names.DESTINATION_BO) final Mode dstMode,
			@Named(Names.DESTINATION_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext dstBoc,
			final QueryService queryService) {
		return getPotentialOwners(srcBoc, dstBoc, queryService).size() > 0;
	}

	@BuildCreateOperation
	public Operation buildCreateOperation(
			@Named(Names.SOURCE_BO) final Mode srcMode,
			final @Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext srcBoc,
			@Named(Names.DESTINATION_BO) final Mode dstMode,
			final @Named(Names.DESTINATION_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext dstBoc,
			final QueryService queryService, final NamingService namingService) {

		final BusinessObjectContext container = getOwnerBoc(srcBoc, queryService);
		if (container == null) {
			return null;
		}

		// Determine which classifier should own the new element
		final ComponentClassifier selectedClassifier = (ComponentClassifier) EditingUtil
				.getBusinessObjectToModify(getPotentialOwners(srcBoc, dstBoc, queryService));
		if (selectedClassifier == null) {
			return null;
		}

		// Prompt for transition triggers
		final ModeTransitionTriggerInfo[] selectedTriggers = ModeTransitionTriggerSelectionDialog
				.promptForTriggers(selectedClassifier,
						null);
		if (selectedTriggers == null) {
			return null;
		}

		return Operation.create(createOp -> {
			createOp.supply(() -> StepResult.forValue(selectedClassifier)).modifyPreviousResult(cc -> {
				// Determine the name for the new mode transition
				final String newElementName = namingService.buildUniqueIdentifier(cc, "new_transition");

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
				for (ModeTransitionTriggerInfo selectedPort : selectedTriggers) {
					final ModeTransitionTrigger mtt = newModeTransition.createOwnedTrigger();
					mtt.setTriggerPort(selectedPort.port);
					mtt.setContext(selectedPort.context);
				}

				return StepResultBuilder.create().showNewBusinessObject(container, newModeTransition).build();
			});
		});
	}

	private List<ComponentClassifier> getPotentialOwners(final BusinessObjectContext srcBoc,
			final BusinessObjectContext dstBoc, final QueryService queryService) {
		final List<ComponentClassifier> potentialOwners = getPotentialOwnersByMode(srcBoc, queryService);
		potentialOwners.retainAll(getPotentialOwnersByMode(dstBoc, queryService));
		return potentialOwners;
	}

	private static BusinessObjectContext getOwnerBoc(final BusinessObjectContext modeBoc,
			final QueryService queryService) {
		return queryService.getFirstResult(containerQuery, modeBoc);
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

		return EditingUtil.getPotentialComponentClassifiers(bo).stream()
				.filter(tmpBo -> tmpBo instanceof ComponentClassifier
						&& !(((ComponentClassifier) tmpBo).isDerivedModes()))
				.filter(cc -> hasModeWithName(cc, modeName)).collect(Collectors.toList());
	}

	private static boolean hasModeWithName(final ComponentClassifier cc, final String nameToCheck) {
		return cc.getAllModes().stream().map(m -> m.getName()).anyMatch(n -> nameToCheck.equalsIgnoreCase(n));
	}

	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) ModeTransition mt, final @Named(Names.NAME) String value, final NamingService namingService) {
		return namingService.checkNameValidity(mt, value);
	}
}
