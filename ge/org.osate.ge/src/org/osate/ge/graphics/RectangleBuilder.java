/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.graphics;

import org.osate.ge.graphics.internal.Rectangle;

/**
 * Builder for creating rectangle graphics.
 * @noextend
 * @see Graphic
 */
public class RectangleBuilder {
	private boolean rounded = false;

	private RectangleBuilder() {}

	/**
	 * Creates a rectangle builder.
	 * @return a rectangle builder
	 */
	public static RectangleBuilder create() {
		return new RectangleBuilder();
	}

	/**
	 * Configures the rectangle builder to create a rounded rectangle.
	 * @return this builder to allow method chaining.
	 */
	public RectangleBuilder rounded() {
		this.rounded = true;
		return this;
	}

	/**
	 * Creates a rectangle graphic based on the current state of the builder.
	 * @return the newly created graphic
	 */
	public Graphic build() {
		return new Rectangle(rounded);
	}
}
