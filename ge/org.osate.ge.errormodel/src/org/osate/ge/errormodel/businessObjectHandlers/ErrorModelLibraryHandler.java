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
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.di.Names;
import org.osate.ge.errormodel.ErrorModelCategories;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

// ErrorModelLibraries should not be graphically represented? It's children should belong to the parent?
public class ErrorModelLibraryHandler {	
	private static final Graphic graphic = RectangleBuilder.create().build();
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ErrorModelLibrary lib) {
		return true;
	}
	
	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration() {
		return GraphicalConfigurationBuilder.create().
			graphic(graphic).
			build();
	}
	
	@GetName
	public String getName() {
		return "Error Model Library";
	}
	
	// Creation
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries() {
		return new PaletteEntry[] { 
			PaletteEntryBuilder.create().label("Error Model Library").category(ErrorModelCategories.ERROR_MODEL).build()
		};
	}
	
	@CanCreate
	public boolean canCreate(final @Named(Names.TARGET_BO) AadlPackage pkg) {
		return !hasErrorModelLibrary(pkg);
	}
	
	@Create
	public Object createBusinessObject(@Named(Names.OWNER_BO) AadlPackage pkg) {				
		// Must create new annex
		final DefaultAnnexLibrary defaultLib = (DefaultAnnexLibrary) pkg.getPublicSection().createOwnedAnnexLibrary(Aadl2Package.eINSTANCE.getDefaultAnnexLibrary());
		defaultLib.setName(EMV2Util.ErrorModelAnnexName);
		defaultLib.setSourceText("{** **}");
		
		// Create the ErrorModelLibrary
		final ErrorModelLibrary errorModelLibrary = (ErrorModelLibrary)defaultLib.createParsedAnnexLibrary(ErrorModelPackage.eINSTANCE.getErrorModelLibrary());
		errorModelLibrary.setName(EMV2Util.ErrorModelAnnexName);
		
		return errorModelLibrary;
	}
	
	private static boolean hasErrorModelLibrary(final AadlPackage pkg) {
		if(pkg.getPublicSection() == null) {
			return false;
		}
		
		for(final AnnexLibrary lib : pkg.getPublicSection().getOwnedAnnexLibraries()) {
			if(lib.getName().equals(EMV2Util.ErrorModelAnnexName)) {
				return true;
			}
		}
		
		return false;
	}
}
