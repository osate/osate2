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
import org.osate.ge.internal.graphics.LineStyle;

/**
 * Builder for creating parallelogram graphics.
 * @noextend
 * @see Graphic
 */
public class ParallelogramBuilder {
	private int lineWidth = 1;
	private LineStyle lineStyle = LineStyle.SOLID;
	private int horizontalOffset = 0;
	
	private ParallelogramBuilder() {}
	
	/**
	 * Creates a parallelogram builder.
	 * @return a parallelogram builder
	 */
	public static ParallelogramBuilder create() {
		return new ParallelogramBuilder();
	}
		
	/**
	 * Sets the line width to use to create the parallelogram.
	 * @param value the new value for the line width.
	 * @return this builder to allow method chaining.
	 */
	public ParallelogramBuilder lineWidth(int value) {
		this.lineWidth = value;
		return this;
	}
	
	/**
	 * Configures the parallelogram builder to use dashed lines.
	 * @return this builder to allow method chaining.
	 */
	public ParallelogramBuilder dashed() {
		this.lineStyle = LineStyle.DASHED;
		return this;
	}
	
	/**
	 * Sets the horizontal offset to use to create the parallelogram.
	 * @param value the new value for the horizontal offset
	 * @return this builder to allow method chaining.
	 */
	public ParallelogramBuilder horizontalOffset(int value) {
		this.horizontalOffset = value;
		return this;
	}	
	
	/**
	 * Creates a parallelogram graphic based on the current state of the builder.
	 * @return the newly created graphic
	 */
	public Graphic build() {
		return new Parallelogram(lineWidth, lineStyle, horizontalOffset);
	}
}
