/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.gef;

import java.util.Objects;

import org.eclipse.gef.fx.utils.NodeUtils;
import org.eclipse.gef.geometry.planar.IGeometry;

import com.google.common.collect.ImmutableList;

import javafx.geometry.Dimension2D;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;

/**
 * Node for polygon graphics
 */
public class PolygonNode extends Region implements ChopBoxGeometryProvider, Stylable {
	private final Polygon poly = new Polygon();
	private double[] points;

	/**
	 * Create a new instance
	 * @param fixedSize may be null. If non-null, then the minimum, preferred, and max size will match this value.
	 * @param points the points for the polygon. Series of x, y coordinates.
	 * Must contain an even number of values be within the range of [0.0, 1.0] Will be scaled based on the size of the node.
	 */
	public PolygonNode(final Dimension2D fixedSize, final double... points) {
		this.points = Objects.requireNonNull(points, "points must not be null").clone();
		this.getChildren().addAll(poly);

		if ((this.points.length % 2) != 0) {
			throw new RuntimeException("points must be contain an even number of values");
		}

		// For fixed sized nodes, set the min=pref=max=fixed size
		if (fixedSize != null) {
			setPrefWidth(fixedSize.getWidth());
			setPrefHeight(fixedSize.getHeight());
			setMinWidth(fixedSize.getWidth());
			setMinHeight(fixedSize.getHeight());
			setMaxWidth(fixedSize.getWidth());
			setMaxHeight(fixedSize.getHeight());
			resize(fixedSize.getWidth(), fixedSize.getHeight());
		}

		poly.setStrokeType(StrokeType.INSIDE);
		poly.setStrokeLineCap(StrokeLineCap.BUTT);

		setLineWidth(2.0);
		setBackgroundColor(Color.WHITE);
		setOutlineColor(Color.BLACK);
	}

	@Override
	public void resize(double width, double height) {
		super.resize(width, height);

		// Transform the points based on the specified size
		final Double[] sizedPoints = new Double[points.length];
		for (int i = 0; i < sizedPoints.length; i += 2) {
			sizedPoints[i] = points[i] * width;
			sizedPoints[i + 1] = points[i + 1] * height;
		}

		poly.getPoints().setAll(sizedPoints);
	}

	@Override
	public final void apply(final FxStyle style) {
		setBackgroundColor(style.getBackgroundColor());
		setOutlineColor(style.getOutlineColor());
		setLineWidth(style.getLineWidth());
		setStrokeDashArray(style.getStrokeDashArray());
	}

	public final void setBackgroundColor(final Color value) {
		poly.setFill(value);
	}

	public final void setOutlineColor(final Color value) {
		poly.setStroke(value);
	}

	public final void setLineWidth(final double value) {
		poly.setStrokeWidth(value);
	}

	public final void setStrokeDashArray(final ImmutableList<Double> value) {
		poly.getStrokeDashArray().setAll(value);
	}

	@Override
	public IGeometry getChopBoxGeometry() {
		return NodeUtils.getGeometricOutline(poly);
	}
}
