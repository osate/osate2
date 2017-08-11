/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.services;

import org.eclipse.jface.action.IAction;

/**
 * Contains methods for interacting with the graphical editor's user interface components.
 * All methods must be called from the display thread
 *
 */
public interface UiService {
	/**
	 * Returns an IAction for activating the tool with the specified tool ID. Throws an exception if an action cannot be returned.
	 * @param toolId
	 * @return an action for activating for the specified tool ID.
	 */
	IAction getActivateToolAction(final String toolId);
	
	void deactivateActiveTool();
	
	void clearSelection();
}
