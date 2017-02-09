/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.graphics;

import org.osate.ge.internal.graphics.AgeConnectionTerminator;
import org.osate.ge.internal.graphics.ConnectionTerminatorSize;
import org.osate.ge.internal.graphics.ConnectionTerminatorType;

/**
 * Builder for creating arrow connection terminators. 
 * @noextend
 * @see ConnectionTerminator
 */
public class ArrowBuilder {
	private ConnectionTerminatorType terminatorType = ConnectionTerminatorType.FILLED_ARROW;
	private ConnectionTerminatorSize terminatorSize = ConnectionTerminatorSize.REGULAR;
	
	private ArrowBuilder() {} 
	
	/**
	 * Creates an arrow builder.
	 * @return a arrow builder
	 */
	public static ArrowBuilder create() {
		return new ArrowBuilder();
	}
	
	/**
	 * Configures the arrow builder to create a filled polygon arrow.
	 * @return this builder to allow method chaining.
	 */
	public ArrowBuilder filled() {
		terminatorType = ConnectionTerminatorType.FILLED_ARROW;
		return this;
	}
	
	/**
	 * Configures the arrow builder to create an unfilled polygon arrow.
	 * @return the arrow builder on which the method was invoked to allow method chaining
	 */
	public ArrowBuilder open() {
		terminatorType = ConnectionTerminatorType.OPEN_ARROW;
		return this;
	}
	
	/**
	 * Configures the arrow builder to create a line arrow.
	 * @return the arrow builder on which the method was invoked to allow method chaining
	 */
	public ArrowBuilder line() {
		terminatorType = ConnectionTerminatorType.LINE_ARROW;
		return this;
	}
	
	/**
	 * Configures the arrow builder to create a small arrow.
	 * @return the arrow builder on which the method was invoked to allow method chaining
	 */
	public ArrowBuilder small() {
		terminatorSize = ConnectionTerminatorSize.SMALL;
		return this;
	}
	
	/**
	 * Creates a connection terminator based on the current state of the arrow builder.
	 * @return the newly created connection terminator
	 */
	public ConnectionTerminator build() {
		return new AgeConnectionTerminator(terminatorType, terminatorSize);
	}
}
