/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.services;

/**
 * Service for retrieving a business object using a reference created using ReferenceBuilderService.
 * @noextend
 * @noimplement
 * @see ReferenceBuilderService
 * @see org.osate.ge.di.ResolveReference
 */
public interface ReferenceResolutionService {
	/**
	 * Retrieves the business object using a reference returned by #{ReferenceBuilderService#getReference(Object)}. 
	 * @param reference the reference
	 * @return the referenced business object or null if the business object could not be retrieved
	 * @see ReferenceBuilderService#getReference(Object)
	 */
	Object getReferencedObject(String reference);
}
