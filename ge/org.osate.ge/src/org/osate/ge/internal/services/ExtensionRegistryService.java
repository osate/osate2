/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.services;

import java.util.Collection;
import java.util.List;

public interface ExtensionRegistryService {
	/**
	 * Tools are objects that allow the user to perform a specific action using the editor. Only a single tool may be active at a time and tools should have their own 
	 * user interface to provide feedback to the user. 
	 * The following annotations are used with tools:
	 * Activate - Required
	 * CanActivate - Optional
	 * Deactivate - Required
	 * Description - Required
	 * Icon - Required
	 * Id - Required
	 * SelectionChanged - Optional
	 */
    Collection<Object> getTools();

	/**
	 * Business object handlers are extension which provide  
	 */
    Collection<Object> getBusinessObjectHandlers();

    Object getApplicableBusinessObjectHandler(Object bo);
    
	/**
	 * Returns a list of registered categories for the palette.
	 */
	List<Category> getCategories();
	
	/**
	 * Interface for palette categories
	 */
	public static interface Category {
		String getId();
		String getName();
	}
}