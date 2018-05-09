/*******************************************************************************
 * Copyright (C) 2017 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.osate.ge.graphics.internal;

import org.osate.ge.graphics.Graphic;

/**
 * Builder for creating label graphics
 * @noextend
 * @see Graphic
 */
public class LabelBuilder {
	private LabelBuilder() {}
	
	/**
	 * Creates a label graphic builder.
	 * @return a label graphic builder
	 */
	public static LabelBuilder create() {
		return new LabelBuilder();
	}
	/**
	 * Creates a label graphic based on the current state of the builder.
	 * @return the newly created graphic
	 */
	public Graphic build() {
		return new Label();
	}
}
