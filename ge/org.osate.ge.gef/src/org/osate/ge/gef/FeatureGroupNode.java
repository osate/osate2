/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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

import org.eclipse.gef.fx.utils.NodeUtils;
import org.eclipse.gef.geometry.planar.IGeometry;

import com.google.common.collect.ImmutableList;

import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;

/**
 * Node for feature group graphics. This node has a fixed width with a resizable height.
 */
public class FeatureGroupNode extends Region implements ChopBoxGeometryProvider, Stylable {
	private static final double WIDTH = 30;
	private static final double CIRCLE_RADIUS = WIDTH / 3.0;
	private static final double CIRCLE_DIAMETER = 2.0 * CIRCLE_RADIUS;

	private Path path = new Path();

	/**
	 * Creates a new instance
	 */
	public FeatureGroupNode() {
		this.getChildren().addAll(path);

		path.setStrokeType(StrokeType.INSIDE);
		path.setStrokeLineCap(StrokeLineCap.BUTT);

		setLineWidth(2.0);
		setBackgroundColor(Color.BLACK);
		setOutlineColor(Color.BLACK);
	}

	@Override
	public void resize(final double width, final double height) {
		super.resize(width, height);

		// Resize symbol to specified size
		double cy = height / 2.0;
		path.getElements().setAll(new MoveTo(0.0, cy), new ArcTo(CIRCLE_RADIUS, CIRCLE_RADIUS, 0,
				CIRCLE_DIAMETER, cy, true,
				false), new ArcTo(CIRCLE_RADIUS, CIRCLE_RADIUS, 0, 0.0, cy, true,
						false),
				new MoveTo(CIRCLE_DIAMETER, 0.0), new LineTo(width, 0.0), new LineTo(width, height),
				new LineTo(CIRCLE_DIAMETER, height), new ClosePath());
	}

	@Override
	public final void apply(final FxStyle style) {
		setBackgroundColor(style.getBackgroundColor());
		setOutlineColor(style.getOutlineColor());
		setLineWidth(style.getLineWidth());
		setStrokeDashArray(style.getStrokeDashArray());
	}

	public final void setBackgroundColor(final Color value) {
		path.setFill(value);
	}

	public final void setOutlineColor(final Color value) {
		path.setStroke(value);
	}

	public final void setLineWidth(final double value) {
		path.setStrokeWidth(value);
	}

	public final void setStrokeDashArray(final ImmutableList<Double> value) {
		path.getStrokeDashArray().setAll(value);
	}

	@Override
	public double computeMinWidth(double height) {
		return WIDTH;
	}

	@Override
	public double computePrefWidth(double height) {
		return WIDTH;
	}

	@Override
	public double computeMaxWidth(double height) {
		return WIDTH;
	}

	@Override
	public double computeMinHeight(double height) {
		return CIRCLE_DIAMETER;
	}

	@Override
	public double computePrefHeight(double height) {
		return CIRCLE_DIAMETER;
	}

	@Override
	public IGeometry getChopBoxGeometry() {
		return NodeUtils.getGeometricOutline(path);
	}
}
