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

import org.osate.ge.internal.graphics.Polygon;

public class PolygonBuilder {
	private Point2D.Double[] points;
	
	private PolygonBuilder() {}
	
	public static PolygonBuilder create() {
		return new PolygonBuilder();
	}
	
	public PolygonBuilder points(final Point2D.Double... points) {
		this.points = Objects.requireNonNull(points, "points must not be null").clone();
		return this;
	}
	
	public Graphic build() {
		return new Polygon(points);
	}
}
