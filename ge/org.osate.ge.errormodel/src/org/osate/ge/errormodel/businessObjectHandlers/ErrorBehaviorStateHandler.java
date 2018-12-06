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
import org.osate.ge.errormodel.util.ErrorModelGeUtil;
import org.osate.ge.graphics.EllipseBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResult;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

public class ErrorBehaviorStateHandler {
	private static final Graphic graphic = EllipseBuilder.create().build();

	@IsApplicable
	@CanDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorState state) {
		return true;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorState state) {
		return GraphicalConfigurationBuilder.create().
				graphic(graphic).
				annotation(state.isIntial() ? "<Initial>" : null).
				style(ErrorModelGeUtil.centeredStyle).
				build();
	}

	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries() {
		return new PaletteEntry[] {
				PaletteEntryBuilder.create().label("Error Behavior State").category(ErrorModelCategories.ERROR_MODEL)
						.build()
		};
	}

	@CanCreate
	public boolean canCreate(final @Named(Names.TARGET_BO) ErrorBehaviorStateMachine stateMachine) {
		return true;
	}

	@BuildCreateOperation
	public Operation buildCreateOperation(@Named(Names.TARGET_BO) final ErrorBehaviorStateMachine stateMachineReadOnly,
			final @Named(Names.TARGET_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext targetBoc) {
		return Operation.create(createOp -> {
			createOp.supply(() -> StepResult.forValue(stateMachineReadOnly)).modifyPreviousResult(stateMachine -> {
				// Create the state
				final ErrorBehaviorState newState = (ErrorBehaviorState) EcoreUtil
						.create(ErrorModelPackage.eINSTANCE.getErrorBehaviorState());
				final String newErrorTypeName = ErrorModelNamingUtil.buildUniqueIdentifier(stateMachine, "new_state");
				newState.setName(newErrorTypeName);

				// Add the new state to the state machine
				stateMachine.getStates().add(newState);

				return StepResultBuilder.create().showNewBusinessObject(targetBoc, newState).build();
			});
		});
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorState bo) {
		return bo.getName();
	}

	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorState state, final @Named(Names.NAME) String value) {
		final ErrorBehaviorStateMachine stateMachine = (ErrorBehaviorStateMachine)state.eContainer();
		return ErrorModelNamingUtil.validateName(stateMachine, state.getName(), value);
	}
}
