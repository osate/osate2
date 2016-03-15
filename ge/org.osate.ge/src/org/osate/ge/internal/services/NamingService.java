/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;

public interface NamingService {
	/**
	 * Builds an identifier using the specified base that doesn't conflict with identifiers in the specified namespace
	 * @param namespace
	 * @param baseIdentifier
	 * @return an identifier that is unique in the specified namespace
	 */
	String buildUniqueIdentifier(Namespace namespace, String baseIdentifier);
	
	/**
	 * Determines whether a specified string is a valid AADL identifier
	 * @param value
	 * @return
	 */
	boolean isValidIdentifier(String value);
	
	/**
	 * Returns whether an element with a specified name exists
	 * @param namespace
	 * @param name
	 * @return
	 */
	boolean isNameInUse(Namespace namespace, String name);
	
	/**
	 * Helper function for checking if a name is valid for a specified named element. Essentially a generic implementation of checkValueValid.
	 * @param ne
	 * @param name
	 * @return null is the name is valid. Otherwise a text string explaining why it is not.
	 */
	String checkNameValidity(NamedElement ne, String name);
}
