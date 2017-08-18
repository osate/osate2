// Based on OSATE Graphical Editor. Modifications are: 
/*
Copyright (c) 2016, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
*/
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

import org.osate.ge.internal.businessObjectHandlers.BusinessObjectHandlerProvider;

public interface ExtensionRegistryService extends BusinessObjectHandlerProvider {
	/**
	 * Business object handlers are extension which provide  
	 */
    Collection<Object> getBusinessObjectHandlers();

    @Override
	Object getApplicableBusinessObjectHandler(Object bo);
    
    /**
     * @return an ordered collection of tooltip contributors.
     * The following annotations are used with tooltip contributors:
     * Activate - Required
     */
    Collection<Object> getTooltipContributors();
    
	 /**
     * @return a collection of commands.
     * The following annotations are used with commands contributors:
     * GetLabel - Required
     * IsAvailable
     * CanActivate
     * Activate - Required
     * HasDoneChanges
     */
    Collection<Object> getCommands();

	/**
	 * Returns a list of registered categories for the palette.
	 */
	List<Category> getCategories();
	
	Collection<Object> getBusinessObjectProviders();
	
	/**
	 * Interface for palette categories
	 */
	public static interface Category {
		String getId();
		String getName();
	}
}