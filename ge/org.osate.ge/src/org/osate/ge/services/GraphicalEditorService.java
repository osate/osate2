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
package org.osate.ge.services;

import org.osate.ge.GraphicalEditor;

/**
 * Service for interacting with the graphical editor.
 * @noextend
 * @noimplement
 * @see org.osate.ge.GraphicalEditor
 */
public interface GraphicalEditorService {
	/**
	 * Opens a diagram with the specified root business object in a graphical editor. If a diagram is not found, one is created. 
	 * The root business object should support retrieving its title.  
	 * @param bo is the business object which is the root business object of the diagram that diagram to be opened.
	 * @return the editor in which the diagram was open. Throws an exception if the editor could not be opened.
	 */
	GraphicalEditor openBusinessObject(Object bo);
	
	/**
	 * Returns whether the specified object is such that the service may perform and operation on it. 
	 * For example, an implementation may support performing operations on GEF EditPart objects.
	 * @param potentialOperand the object on which to check if the service may operate.
	 * @return whether the service may operate on the object.
	 * @see #operateOn(Object, Object)
	 */
	boolean canOperateOn(Object potentialOperand);
	
	/**
	 * Activates a specified operation and returns the result of that operation. 
	 * @param operand is the object on which to activate the operation.
	 * @param operation is the operation to be performed. The operation must have a method annotated with the Activate annotation. 
	 * @return the result of the operation. Returns null if the object could not be operated on.
	 * The operation's activation method is a called with the standard set of objects available for injection. 
	 * The following named values are supported:
	 * Names.DIAGRAM_BO - The business object of the diagram in which the operand is contained. May be null.
	 * Names.BUSINESS_OBJECT - The business object represented by the operand.
	 * @see #canOperateOn(Object) 
	 */
	Object operateOn(Object operand, Object operation);
}
