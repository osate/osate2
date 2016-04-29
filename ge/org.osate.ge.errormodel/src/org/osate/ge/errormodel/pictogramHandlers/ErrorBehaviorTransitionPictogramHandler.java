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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.osate.ge.ConnectionTerminator;
import org.osate.ge.Graphic;
import org.osate.ge.GraphicFactory;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryFactory;
import org.osate.ge.di.AllowDelete;
import org.osate.ge.di.CanCreateConnection;
import org.osate.ge.di.CanStartConnection;
import org.osate.ge.di.CreateBusinessObject;
import org.osate.ge.di.CreateDestinationQuery;
import org.osate.ge.di.CreateOwnerDiagramElementQuery;
import org.osate.ge.di.CreateSourceQuery;
import org.osate.ge.di.GetGraphicalRepresentation;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.SetName;
import org.osate.ge.di.ValidateName;
import org.osate.ge.errormodel.ErrorModelCategories;
import org.osate.ge.errormodel.util.ErrorModelNamingHelper;
import org.osate.ge.query.DiagramElementQuery;
import org.osate.ge.di.Names;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;

public class ErrorBehaviorTransitionPictogramHandler {
	private static final Graphic graphic = GraphicFactory.createSolidFreeFormConnection(ConnectionTerminator.OPEN_ARROW, ConnectionTerminator.FILLED_ARROW); // TODO
	
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) ErrorBehaviorStateMachine stateMachine) {
		return new PaletteEntry[] { 
			PaletteEntryFactory.makeCreateConnectionEntry(ErrorModelCategories.ERROR_MODEL, "Transition", null, null)
		};
	}
	
	@IsApplicable
	@AllowDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorTransition transition) {
		return true;
	}
	
	@GetGraphicalRepresentation
	public Graphic getGraphicalRepresentation() {
		return graphic;
	}
	
	@CreateOwnerDiagramElementQuery
	public DiagramElementQuery<?> createOwnerDiagramElementQuery(final @Named(Names.SRC_ROOT_QUERY) DiagramElementQuery<?> srcRootQuery) {
		return srcRootQuery.ancestor(1);
	}
	
	@CreateSourceQuery
	public DiagramElementQuery<?> createSourceQuery(final @Named(Names.ROOT_QUERY) DiagramElementQuery<?> rootQuery) {
		return rootQuery.children().filterByBusinessObject(ebt->((ErrorBehaviorTransition)ebt).getSource());
	}
	
	@CreateDestinationQuery
	public DiagramElementQuery<?> createDestination(final @Named(Names.ROOT_QUERY) DiagramElementQuery<?> rootQuery) {
		return rootQuery.children().filterByBusinessObject(ebt->((ErrorBehaviorTransition)ebt).getTarget());
	}
	
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorTransition bo) {
		return bo.getName();
	}
	
	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorTransition transition, final @Named(Names.NAME) String value) {
		final ErrorBehaviorStateMachine stateMachine = (ErrorBehaviorStateMachine)transition.eContainer();
		return ErrorModelNamingHelper.validateName(stateMachine, transition.getName(), value);
	}
	
	@SetName
	public void setName(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorTransition bo, final @Named(Names.NAME) String value) {
		bo.setName(value);
	}
		
	// TODO
	//@GetCreateConnectionOwner - RENAME - Returns a business object not the owning pictogram element? May not have a pictogram element
	public ContainerShape getCreateConnectionOwner() {
		return null;
	}
	
	@CanStartConnection
	public boolean canStartConnection(@Named(Names.SOURCE_BO) final ErrorBehaviorState state) {
		return true;
	}
	
	@CanCreateConnection
	public boolean canCreateConnection() {
		// TODO
		return true;
	}
	
	@CreateBusinessObject
	public Object createConnectionBusinessObject() {
		// TODO
		return null;
	}
}
