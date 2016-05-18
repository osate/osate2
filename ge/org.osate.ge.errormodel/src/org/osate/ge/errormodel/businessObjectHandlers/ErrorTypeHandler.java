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
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetCreateOwner;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.SetName;
import org.osate.ge.di.ValidateName;
import org.osate.ge.errormodel.ErrorModelCategories;
import org.osate.ge.errormodel.model.ErrorTypeLibrary;
import org.osate.ge.errormodel.util.ErrorModelNamingHelper;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.di.Names;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

public class ErrorTypeHandler {
	private static final Graphic graphic = RectangleBuilder.create().build();
	
	@IsApplicable
	@CanDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ErrorType errorType) {
		return true;
	}
	
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) ErrorTypeLibrary typeLib) {
		return new PaletteEntry[] { 
			PaletteEntryBuilder.create().label("Error Type").category(ErrorModelCategories.ERROR_MODEL).build()
		};
	}
	
	@CanCreate
	public boolean canCreate(final @Named(Names.PARENT_BO) ErrorTypeLibrary errorTypeLib) {
		return true;
	}

	@GetCreateOwner
	public Object getOwnerBusinessObject(final @Named(Names.PARENT_BO) ErrorTypeLibrary typeLib) {
		return typeLib.getErrorModelLibrary();
	}
	
	@Create
	public Object createBusinessObject(@Named(Names.OWNER_BO) final ErrorModelLibrary errorModelLibrary) {				
		// Create the ErrorType
		final ErrorType newErrorType = (ErrorType)EcoreUtil.create(ErrorModelPackage.eINSTANCE.getErrorType());
		final String newErrorTypeName = ErrorModelNamingHelper.buildUniqueIdentifier(errorModelLibrary, "NewErrorType");
		newErrorType.setName(newErrorTypeName);
		
		// Add the new type to the error model library
		errorModelLibrary.getTypes().add(newErrorType);
		
		return newErrorType;
	}

	@GetGraphic
	public Graphic getGraphicalRepresentation() {
		return graphic;
	}
	
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ErrorType bo) {
		return bo.getName();
	}
	
	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) ErrorType errorType, final @Named(Names.NAME) String value) {
		final ErrorModelLibrary errorModelLibrary = (ErrorModelLibrary)errorType.eContainer();
		return ErrorModelNamingHelper.validateName(errorModelLibrary, errorType.getName(), value);
	}
	
	@SetName
	public void setName(final @Named(Names.BUSINESS_OBJECT) ErrorType bo, final @Named(Names.NAME) String value) {
		bo.setName(value);
	}
}
