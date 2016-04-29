/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.errormodel.pictogramHandlers;

import javax.inject.Named;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.ge.Graphic;
import org.osate.ge.GraphicFactory;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryFactory;
import org.osate.ge.di.AllowDelete;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CreateBusinessObject;
import org.osate.ge.di.GetCreateOwningBusinessObject;
import org.osate.ge.di.GetGraphicalRepresentation;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.SetName;
import org.osate.ge.di.ValidateName;
import org.osate.ge.errormodel.ErrorModelCategories;
import org.osate.ge.errormodel.util.ErrorModelNamingHelper;
import org.osate.ge.di.Names;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

public class ErrorBehaviorEventPictogramHandler {
	private static final Graphic graphic = GraphicFactory.createEllipse(); // TODO
	
	@IsApplicable
	@AllowDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorEvent event) {
		return true;
	}
	
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) ErrorBehaviorStateMachine stateMachine) {
		return new PaletteEntry[] { 
			PaletteEntryFactory.makeCreateEntry(ErrorModelCategories.ERROR_MODEL, "Error Event", null, ErrorModelPackage.eINSTANCE.getErrorEvent()),
			PaletteEntryFactory.makeCreateEntry(ErrorModelCategories.ERROR_MODEL, "Repair Event", null, ErrorModelPackage.eINSTANCE.getRepairEvent()),
			PaletteEntryFactory.makeCreateEntry(ErrorModelCategories.ERROR_MODEL, "Recover Event", null, ErrorModelPackage.eINSTANCE.getRecoverEvent())
		};
	}
	
	@CanCreate
	public boolean canCreateShape(final @Named(Names.CONTAINER_BO) ErrorBehaviorStateMachine stateMachine) {
		return true;
	}

	@GetCreateOwningBusinessObject
	public Object getOwnerBusinessObject(final @Named(Names.CONTAINER_BO) ErrorBehaviorStateMachine stateMachine) {
		return stateMachine;
	}
	
	@CreateBusinessObject
	public Object createBusinessObject(@Named(Names.OWNER_BO) final ErrorBehaviorStateMachine stateMachine, @Named(Names.PALETTE_ENTRY_CONTEXT) final EClass classToCreate) {
		// Create the state
		final  ErrorBehaviorEvent newEvent = ( ErrorBehaviorEvent)EcoreUtil.create(classToCreate);
		final String newEventName = ErrorModelNamingHelper.buildUniqueIdentifier(stateMachine, "NewEvent");
		newEvent.setName(newEventName);
		
		// Add the new event to the state machine
		stateMachine.getEvents().add(newEvent);
		
		return newEvent;
	}

	@GetGraphicalRepresentation
	public Graphic getGraphicalRepresentation() {
		return graphic;
	}
	
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorEvent bo) {
		return bo.getName();
	}
	
	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorEvent event, final @Named(Names.NAME) String value) {
		final ErrorBehaviorStateMachine stateMachine = (ErrorBehaviorStateMachine)event.eContainer();
		return ErrorModelNamingHelper.validateName(stateMachine, event.getName(), value);
	}
	
	@SetName
	public void setName(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorEvent bo, final @Named(Names.NAME) String value) {
		bo.setName(value);
	}
}
