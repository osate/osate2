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
import org.osate.ge.internal.diagram.runtime.DiagramElement;

import java.awt.Color;

/**
 * Contains methods to handle highlighting objects based on editor state
 *
 */
public interface ColoringService {
	// TODO: Should have a way to batch these changes before making API. Implementation currently creates a Graphiti command for each update.
	interface Coloring {
		void dispose();
		
		/**
		 * 
		 * @param de
		 * @param color setting color to null returns the element to its default color.
		 */
		void setForeground(DiagramElement de, Color color);
		
		void clear();
	}
	
	/**
	 * Allows the caller to configure the colors of specific pictograms. The returned Coloring object is used to configure colors.
	 * The Colorings object must be disposed() when coloring is no longer desired. Overrides default highlighting.
	 * @return
	 */
	Coloring adjustColors();
	
	/**
	 * Returns the override foreground color for the element. 
	 * @param de
	 * @return the overridden color or null if the default color should be used.
	 */
	Color getForegroundColor(DiagramElement de);
	
	// TODO: Rework. Should be split out from the service.
	void setHighlightedMode(NamedElement ne);
	void setHighlightedFlow(NamedElement ne);
}