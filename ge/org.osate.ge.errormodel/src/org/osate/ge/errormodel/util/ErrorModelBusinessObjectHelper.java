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
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

public class ErrorModelBusinessObjectHelper {
	private static final StandaloneQuery childErrorModelLibraryQuery = StandaloneQuery.create((root) -> root.children().filter((fa) -> fa.getBusinessObject() instanceof ErrorModelLibrary));
	
	/**
	 * Returns the business object to be used as an owner for a error model library element. 
	 * Attempts to return a business object context for one of the following based on availability:
	 * ErrorModelLibrary (Parsed Annex)
	 * AadlPackage
	 * @return
	 */
	public static BusinessObjectContext getOwnerBusinessObjectForErrorModelLibraryElement(final BusinessObjectContext boc,
			final QueryService queryService) {
		final Object bo = boc.getBusinessObject();
		if(bo instanceof ErrorModelLibrary) {
			return boc;
		} else if(bo instanceof AadlPackage) {
			final AadlPackage pkg = (AadlPackage)bo;
			if(pkg.getPublicSection() == null) {
				return null;
			}
			
			final BusinessObjectContext libBoc = queryService.getFirstResult(childErrorModelLibraryQuery, boc);
			return libBoc == null ? boc : libBoc;
		}
		
		return null;
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
