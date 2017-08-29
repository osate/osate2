/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.graphics;

import java.awt.geom.Point2D;
import java.util.Objects;

import org.osate.ge.internal.graphics.Poly;
import org.osate.ge.internal.graphics.Poly.Type;

/**
 * Builder for creating polygon or polyline graphics. Builds polygon by default.
 * @noextend
 * @see Graphic
 */
public class PolyBuilder {
	private Point2D.Double[] points;
	private Type type = Type.POLYGON;

	private PolyBuilder() {}

	/**
	 * Creates a poly builder.
	 * @return a poly builder
	 */
	public static PolyBuilder create() {
		return new PolyBuilder();
	}

	/**
	 * Configures the poly builder to build a poly composed of the specified points.
	 * @param points the points to use when creating the poly. All coordinates must be in the range of [0.0, 1.0]. Polylines are scaled by the editor.
	 * @return this builder to allow method chaining.
	 */
	public PolyBuilder points(final Point2D.Double... points) {
		this.points = Objects.requireNonNull(points, "points must not be null").clone();
		return this;
	}

	/**
	 * Configures the poly builder to build a polygon
	 * @return this builder to allow method chaining.
	 */
	public PolyBuilder polygon() {
		this.type = Type.POLYGON;
		return this;
	}

	/**
	 * Configures the poly builder to build a polyline
	 * @return this builder to allow method chaining.
	 */
	public PolyBuilder polyline() {
		this.type = Type.POLYLINE;
		return this;
	}

	/**
	 * Creates a poly graphic based on the current state of the builder.
	 * @return the newly created graphic
	 */
	public Graphic build() {
		return new Poly(points, type);
	}
}
