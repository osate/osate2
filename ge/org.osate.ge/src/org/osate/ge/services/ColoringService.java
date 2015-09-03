/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.services;

import java.awt.Color;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;

/**
 * Contains methods to handle highlighting objects based on editor state
 * @author philip.alldredge
 *
 */
public interface ColoringService {
	interface Coloring {
		void dispose();
		void setForeground(PictogramElement pe, Color color);
	}
	
	/**
	 * Allows the caller to configure the colors of specific pictograms. The returned Coloring object is used to configure colors.
	 * The Colorings object must be disposed() when coloring is no longer desired. Overrides default highlighting.
	 * @return
	 */
	Coloring adjustColors();
	
	/**
	 * Applies custom colors to a pictogram element based on the current state of the coloring service
	 * Coloring can be customized with the is coloring container and is coloring child properties.
	 * @param pe the pictogram to color. If it is a shape it should be the root shape for a business object. 
	 */
	void applyColoring(PictogramElement pe);
}