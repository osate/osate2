/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge;

import org.eclipse.emf.ecore.EObject;

/**
 * Optional interface for providing the EObject which contains a business object. 
 * Should be implemented by business objects which are not EMF Objects
 * When this interface is implemented by a business object, it will be used to allow deletion of the business object. 
 * It is also used for navigation purposes.
 */
public interface EmfContainerProvider {
	EObject getEmfContainer();
}
