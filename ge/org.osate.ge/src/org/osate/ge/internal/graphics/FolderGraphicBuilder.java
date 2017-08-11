/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.graphics;

import org.osate.ge.graphics.Graphic;

/**
 * Builder for creating folder graphics.
 * @noextend
 * @see Graphic
 */
public class FolderGraphicBuilder {
	private int lineWidth = 1;
	
	private FolderGraphicBuilder() {}
	
	/**
	 * Creates a folder graphic builder.
	 * @return a folder graphic builder
	 */
	public static FolderGraphicBuilder create() {
		return new FolderGraphicBuilder();
	}
		
	/**
	 * Sets the line width to use to create the folder graphic.
	 * @param value the new value for the line width.
	 * @return this builder to allow method chaining.
	 */
	public FolderGraphicBuilder lineWidth(int value) {
		this.lineWidth = value;
		return this;
	}
		
	/**
	 * Creates a folder graphic based on the current state of the builder.
	 * @return the newly created graphic
	 */
	public Graphic build() {
		return new FolderGraphic(lineWidth);
	}
}
