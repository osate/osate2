/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.graphics.internal;

import org.osate.ge.graphics.Graphic;

/**
 * Builder for creating mode graphics.
 * @noextend
 * @see Graphic
 */
public class ModeGraphicBuilder {
	private boolean isInitialMode;

	private ModeGraphicBuilder() {}

	/**
	 * Creates a mode graphic builder.
	 * @return a mode graphic builder
	 */
	public static ModeGraphicBuilder create() {
		return new ModeGraphicBuilder();
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
		return new ModeGraphic(isInitialMode);
	}
}
