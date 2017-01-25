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
 * Builder for creating mode graphics.
 * @noextend
 * @see Graphic
 */
public class ModeGraphicBuilder {
	private boolean isInitialMode;
	private int lineWidth = 1;
	private LineStyle lineStyle = LineStyle.SOLID;
	
	private ModeGraphicBuilder() {}
	
	/**
	 * Creates a mode graphic builder.
	 * @return a mode graphic builder
	 */
	public static ModeGraphicBuilder create() {
		return new ModeGraphicBuilder();
	}
		
	/**
	 * Sets the line width to use to create the mode graphic.
	 * @param value the new value for the line width.
	 * @return this builder to allow method chaining.
	 */
	public ModeGraphicBuilder lineWidth(int value) {
		this.lineWidth = value;
		return this;
	}
	
	/**
	 * Configures the mode graphic builder to use dashed lines.
	 * @return this builder to allow method chaining.
	 */
	public ModeGraphicBuilder dashed() {
		this.lineStyle = LineStyle.DASHED;
		return this;
	}

	/**
	 * Configures the mode graphic builder to create an initial mode graphic.
	 * @return this builder to allow method chaining.
	 */
	public ModeGraphicBuilder initialMode() {
		this.isInitialMode = true;
		return this;
	}
	
	/**
	 * Creates a mode graphic based on the current state of the builder.
	 * @return the newly created graphic
	 */
	public Graphic build() {
		return new ModeGraphic(isInitialMode, lineWidth, lineStyle);
	}
}
