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
 * Builder for creating port graphics.
 * @noextend
 * @see Graphic
 */
public class FeatureGraphicBuilder {
	private Direction direction = Direction.IN_OUT;
	private FeatureType featureType = FeatureType.ABSTRACT;
	
	private FeatureGraphicBuilder() {}
	
	/**
	 * Creates a port graphic builder.
	 * @return a new port graphic builder
	 */
	public static FeatureGraphicBuilder create() {
		return new FeatureGraphicBuilder();
	}
	
	/**
	 * Sets the type of feature graphic to create.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder abstractFeature() {
		this.featureType = FeatureType.ABSTRACT;
		return this;
	}
	
	/**
	 * Sets the type of port graphic to create.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder eventPort() {
		this.featureType = FeatureType.EVENT_PORT;
		return this;
	}
	
	/**
	 * Sets the type of port graphic to create.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder dataPort() {
		this.featureType = FeatureType.DATA_PORT;
		return this;
	}
	
	/**
	 * Sets the type of port graphic to create.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder eventDataPort() {
		this.featureType = FeatureType.EVENT_DATA_PORT;
		return this;
	}
	
	/**
	 * Sets the type of feature graphic to create.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder subprogramAccess() {
		this.featureType = FeatureType.SUBPROGRAM_ACCESS;
		return this;
	}
		
	/**
	 * Sets the type of feature graphic to create.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder subprogramGroupAccess() {
		this.featureType = FeatureType.SUBPROGRAM_GROUP_ACCESS;
		return this;
	}
	
	/**
	 * Sets the type of feature graphic to create.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder dataAccess() {
		this.featureType = FeatureType.DATA_ACCESS;
		return this;
	}	
	/**
	 * Sets the type of feature graphic to create.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder busAccess() {
		this.featureType = FeatureType.BUS_ACCESS;
		return this;
	}
	
	/**
	 * Sets the builder to build an input port.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder input() {
		this.direction = Direction.IN;
		return this;
	}
	
	/**
	 * Sets the builder to build an output port.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder output() {
		this.direction = Direction.OUT;
		return this;
	}
	
	/**
	 * Sets the builder to build a bidirectional port.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder bidirectional() {
		this.direction = Direction.IN_OUT;
		return this;
	}
	
	/**
	 * Creates a port graphic based on the current state of the builder.
	 * @return the newly created graphic
	 */
	public Graphic build() {
		return new FeatureGraphic(direction, featureType);
	}
}
