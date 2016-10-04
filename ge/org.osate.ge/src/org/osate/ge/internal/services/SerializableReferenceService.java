/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.services;

import org.osate.aadl2.AadlPackage;

/**
 * Service for referencing business objects using a string value.
 *
 */
public interface SerializableReferenceService {
	String getReference(final Object bo);
	
	/**
	 * AADL elements will be wrapped with an AadlElementWrapper object
	 * @param reference
	 * @return
	 */
	Object getReferencedObject(final String reference);
	
	AadlPackage getAadlPackage(final String qualifiedName);
}
