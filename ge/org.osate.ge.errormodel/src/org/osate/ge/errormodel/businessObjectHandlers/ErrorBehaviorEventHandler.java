/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.errormodel.businessObjectHandlers;

import javax.inject.Named;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.BuildCreateOperation;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.ValidateName;
import org.osate.ge.errormodel.ErrorModelCategories;
import org.osate.ge.errormodel.util.ErrorModelNamingUtil;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Point;
import org.osate.ge.graphics.PolyBuilder;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResult;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

public class ErrorBehaviorEventHandler {
	private static final Graphic graphic = PolyBuilder.create()
			.points(new Point(0.0, 1.0), new Point(1.0, 1.0), new Point(0.5, 0.0)).build();

	@IsApplicable
	@CanDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorEvent event) {
		return true;
	}

	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries() {
		return new PaletteEntry[] {
				PaletteEntryBuilder.create().label("Error Event").category(ErrorModelCategories.ERROR_MODEL).context(ErrorModelPackage.eINSTANCE.getErrorEvent()).build(),
				PaletteEntryBuilder.create().label("Repair Event").category(ErrorModelCategories.ERROR_MODEL).context(ErrorModelPackage.eINSTANCE.getRepairEvent()).build(),
				PaletteEntryBuilder.create().label("Recover Event").category(ErrorModelCategories.ERROR_MODEL).context(ErrorModelPackage.eINSTANCE.getRecoverEvent()).build()
		};
	}

	@CanCreate
	public boolean canCreate(final @Named(Names.TARGET_BO) ErrorBehaviorStateMachine stateMachine) {
		return true;
	}

	@BuildCreateOperation
	public Operation buildCreateOperation(@Named(Names.TARGET_BO) final ErrorBehaviorStateMachine stateMachineReadOnly,
			final @Named(Names.TARGET_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext targetBoc,
			final @Named(Names.PALETTE_ENTRY_CONTEXT) EClass classToCreate) {
		return Operation.create(createOp -> {
			createOp.supply(() -> StepResult.forValue(stateMachineReadOnly)).modifyPreviousResult(stateMachine -> {
				// Create the state
				final ErrorBehaviorEvent newEvent = (ErrorBehaviorEvent) EcoreUtil.create(classToCreate);
				final String newEventName = ErrorModelNamingUtil.buildUniqueIdentifier(stateMachine, "new_event");
				newEvent.setName(newEventName);

				// Add the new event to the state machine
				stateMachine.getEvents().add(newEvent);

				return StepResultBuilder.create().showNewBusinessObject(targetBoc, newEvent).build();
			});
		});
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration() {
		// TODO: label placement
		return GraphicalConfigurationBuilder.create().
				graphic(graphic).
				build();
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorEvent bo) {
		return bo.getName();
	}

	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorEvent event, final @Named(Names.NAME) String value) {
		final ErrorBehaviorStateMachine stateMachine = (ErrorBehaviorStateMachine)event.eContainer();
		return ErrorModelNamingUtil.validateName(stateMachine, event.getName(), value);
	}
}
