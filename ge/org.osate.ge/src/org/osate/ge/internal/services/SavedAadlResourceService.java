/*******************************************************************************
 * Copyright (C) 2015 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092
 *******************************************************************************/
package org.osate.ge.internal.services;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.AadlPackage;

// Low level service for retrieving and working with AADL Packages that must be loaded by the editor rather than
// loaded by Xtext. Ensures that only one copy of the package is open at a time. That version is shared between all editors
// that need access to the package.
public interface SavedAadlResourceService {
	public interface AadlPackageReference {
		AadlPackage getAadlPackage();
	}
	
	/**
	 * Returns a reference to an AadlPackage based on the package URI. The reference itself should be help as long as the package is needed.
	 * The package will return the latest version of the package which has been saved. 
	 * @param packageUri
	 * @return
	 */
	AadlPackageReference getPackageReference(URI packageUri);
	
	/**
	 * Notified the service that the resource is being saved. Useful to prevent reloading resource when the file change was due to a save
	 * by the editor.
	 * @param resource
	 * @param value
	 */
	void setSaveInProgress(final Resource resource, boolean value);
}
