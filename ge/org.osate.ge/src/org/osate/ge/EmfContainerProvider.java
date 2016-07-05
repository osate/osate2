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
 * Optional interface for providing the EMF object which contains a business object the graphical editor.
 * Should be implemented by business objects which are not EMF Objects
 */
public interface EmfContainerProvider {
	/**
	 * It will be used to allow deletion of the business object. When deleting a non-EMF object, the EMF container is considered the owner of the object.
	 * It is also used to support navigating to the package diagram and between graphical and textual representations when using non EMF Objects.
	 * @return the EMF objects which is considered the container for the non-EMF object which implements this interface. 
	 */
	EObject getEmfContainer();
}
