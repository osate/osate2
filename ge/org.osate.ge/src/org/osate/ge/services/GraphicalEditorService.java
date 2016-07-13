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
	 * @see org.osate.ge.di.GetDiagramName
	 */
	GraphicalEditor openBusinessObject(Object bo);
}
