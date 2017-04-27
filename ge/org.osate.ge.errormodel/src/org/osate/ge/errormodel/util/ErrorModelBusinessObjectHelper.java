/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.errormodel.util;

import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

public class ErrorModelBusinessObjectHelper {
	/**
	 * Returns the business object to be used as an owner for a error model library element. 
	 * Attempts to return one of the following based on availability:
	 * ErrorModelLibrary (Parsed Annex)
	 * DefaultAnnexLibrary (Unparsed Annex)
	 * @return
	 */
	public static Object getOwnerBusinessObjectForErrorModelLibraryElement(final AadlPackage pkg) {
		if(pkg.getPublicSection() == null) {
			return null;
		}
		
		for(final AnnexLibrary lib : pkg.getPublicSection().getOwnedAnnexLibraries()) {
			if(lib instanceof DefaultAnnexLibrary) {
				final DefaultAnnexLibrary defaultLib = (DefaultAnnexLibrary)lib;
				final AnnexLibrary parsedLib = defaultLib.getParsedAnnexLibrary();
				if(parsedLib instanceof ErrorModelLibrary) {
					final ErrorModelLibrary errorModelLibrary = (ErrorModelLibrary)defaultLib.getParsedAnnexLibrary();
					return errorModelLibrary;
				} else if(parsedLib == null && EMV2Util.ErrorModelAnnexName.equalsIgnoreCase(defaultLib.getName())) {
					return defaultLib;
				}
			}
		}
		
		return pkg;
	}

	/**
	 * Gets the existing error model library from the owner business object. If one does not exist, one is created.
	 * Designed for use in CreateBusinessObject methods
	 * @param ownerBo must be an AadlPackage, DefeaultAnnexLibrary or ErrorModelLibrary
	 * @return
	 */
	public static ErrorModelLibrary getOrCreateErrorModelLibrary(Object ownerBo) {
		// Create default annex library as necessary
		if(ownerBo instanceof AadlPackage) {
			final AadlPackage pkg = (AadlPackage)ownerBo;
			if(pkg.getPublicSection() == null) {
				return null;
			}
			
			// Must create new annex
			final DefaultAnnexLibrary defaultLib = (DefaultAnnexLibrary) pkg.getPublicSection().createOwnedAnnexLibrary(Aadl2Package.eINSTANCE.getDefaultAnnexLibrary());
			defaultLib.setName(EMV2Util.ErrorModelAnnexName);
			defaultLib.setSourceText("");
			ownerBo = defaultLib;
		} 
		
		// Get/Create the ErrorModelLibrary
		final ErrorModelLibrary errorModelLibrary;
		if(ownerBo instanceof DefaultAnnexLibrary) {
			// Create the ErrorModelLibrary
			final DefaultAnnexLibrary defaultLib = (DefaultAnnexLibrary)ownerBo;
			errorModelLibrary = (ErrorModelLibrary) defaultLib.createParsedAnnexLibrary(ErrorModelPackage.eINSTANCE.getErrorModelLibrary());
			errorModelLibrary.setName(EMV2Util.ErrorModelAnnexName);
		} else if(ownerBo instanceof ErrorModelLibrary) {
			errorModelLibrary = (ErrorModelLibrary)ownerBo;
		}  else {
			throw new RuntimeException("Unsupported ownerBo type: " + ownerBo);
		}
		
		return errorModelLibrary;
	}
}
