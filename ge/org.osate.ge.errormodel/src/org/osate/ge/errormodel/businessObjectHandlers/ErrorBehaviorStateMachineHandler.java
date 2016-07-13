/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.errormodel.businessObjectHandlers;

import java.util.stream.Stream;

import javax.inject.Named;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetChildren;
import org.osate.ge.di.GetCreateOwner;
import org.osate.ge.di.GetDiagramName;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.HandleDoubleClick;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.SetName;
import org.osate.ge.di.ValidateName;
import org.osate.ge.errormodel.ErrorModelCategories;
import org.osate.ge.errormodel.util.ErrorModelBusinessObjectHelper;
import org.osate.ge.errormodel.util.ErrorModelNamingHelper;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.services.GraphicalEditorService;
import org.osate.ge.di.Names;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

public class ErrorBehaviorStateMachineHandler {
	private static final Graphic graphic = RectangleBuilder.create().rounded().build();
	
	@IsApplicable
	@CanDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorStateMachine bo) {
		return true;
	}
	
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) AadlPackage pkg) {
		return new PaletteEntry[] { 
			PaletteEntryBuilder.create().label("Error Behavior State Machine").category(ErrorModelCategories.ERROR_MODEL).build()
		};
	}
	
	@CanCreate
	public boolean canCreate(final @Named(Names.TARGET_BO) AadlPackage pkg) {
		return true;
	}

	@GetCreateOwner
	public Object getOwnerBusinessObject(final @Named(Names.TARGET_BO) AadlPackage pkg) {
		return ErrorModelBusinessObjectHelper.getOwnerBusinessObjectForErrorModelLibraryElement(pkg);
	}
	
	@Create
	public Object createBusinessObject(@Named(Names.OWNER_BO) Object ownerBo) {		
		final ErrorModelLibrary errorModelLibrary = ErrorModelBusinessObjectHelper.getOrCreateErrorModelLibrary(ownerBo);
		
		// Create the ErrorBehaviorStateMachine
		final ErrorBehaviorStateMachine newBehavior = (ErrorBehaviorStateMachine)EcoreUtil.create(ErrorModelPackage.eINSTANCE.getErrorBehaviorStateMachine());
		final String newName = ErrorModelNamingHelper.buildUniqueIdentifier(errorModelLibrary, "NewErrorBehaviorStateMachine");
		newBehavior.setName(newName);
		
		// Add the new type to the error model library
		errorModelLibrary.getBehaviors().add(newBehavior);
		
		return newBehavior;
	}	
	
	@GetGraphic
	public Graphic getGraphicalRepresentation() {
		return graphic;
	}
	
	@GetDiagramName
	public String getTitle(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorStateMachine stateMachine) {
		final NamedElement elementRoot = stateMachine.getElementRoot();
		final String packageName = elementRoot == null ? "" : elementRoot.getQualifiedName();
		return packageName + " : " + stateMachine.getName();
	}
	
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorStateMachine stateMachine) {
		return stateMachine.getName();
	}
	
	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorStateMachine stateMachine, final @Named(Names.NAME) String value) {
		final ErrorModelLibrary errorModelLibrary = (ErrorModelLibrary)stateMachine.eContainer();
		return ErrorModelNamingHelper.validateName(errorModelLibrary, stateMachine.getName(), value);
	}
	
	@SetName
	public void setName(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorStateMachine stateMachine, final @Named(Names.NAME) String value) {
		stateMachine.setName(value);
	}
	
	@GetChildren
	public Stream<?> getChildren(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorStateMachine stateMachine) {
		return Stream.concat(Stream.concat(stateMachine.getEvents().stream(), 
				stateMachine.getStates().stream()),
				stateMachine.getTransitions().stream());
	}
	
	@HandleDoubleClick
	public void onDoubleclick(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorStateMachine stateMachine, final GraphicalEditorService editorService) {
		editorService.openBusinessObject(stateMachine);
	}
}
