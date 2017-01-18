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
 * Builder for creating memory graphics.
 * @noextend
 * @see Graphic
 */
public class MemoryGraphicBuilder {
	private int lineWidth = 1;
	
	private MemoryGraphicBuilder() {}
	
	/**
	 * Creates a memory graphic builder.
	 * @return a memory graphic builder
	 */
	public static MemoryGraphicBuilder create() {
		return new MemoryGraphicBuilder();
	}
		
	/**
	 * Sets the line width to use to create the memory graphic.
	 * @param value the new value for the line width.
	 * @return this builder to allow method chaining.
	 */
	public MemoryGraphicBuilder lineWidth(int value) {
		this.lineWidth = value;
		return this;
	}
		
	/**
	 * Creates a memory graphic based on the current state of the builder.
	 * @return the newly created graphic
	 */
	public Graphic build() {
		return new MemoryGraphic(lineWidth);
	}
}
