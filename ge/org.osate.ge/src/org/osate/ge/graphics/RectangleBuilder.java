/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.graphics;

import org.osate.ge.internal.graphics.LineStyle;
import org.osate.ge.internal.graphics.Rectangle;

/**
 * Builder for creating rectangle graphics.
 * @noextend
 * @see Graphic
 */
public class RectangleBuilder {
	private boolean rounded = false;
	private int lineWidth = 1;
	private LineStyle lineStyle = LineStyle.SOLID;
	
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
	 * Sets the line width to use to create the rectangle.
	 * @param value the new value for the line width.
	 * @return this builder to allow method chaining.
	 */
	public RectangleBuilder lineWidth(int value) {
		this.lineWidth = value;
		return this;
	}
	
	/**
	 * Configures the rectangle builder to use dashed lines.
	 * @return this builder to allow method chaining.
	 */
	public RectangleBuilder dashed() {
		this.lineStyle = LineStyle.DASHED;
		return this;
	}
	
	/**
	 * Configures the rectangle builder to use dotted lines.
	 * @return this builder to allow method chaining.
	 */
	public RectangleBuilder dotted() {
		this.lineStyle = LineStyle.DASHED;
		return this;
	}
	
	/**
	 * Creates a rectangle graphic based on the current state of the builder.
	 * @return the newly created graphic
	 */
	public Graphic build() {
		return new Rectangle(lineWidth, lineStyle, rounded);
	}
}
