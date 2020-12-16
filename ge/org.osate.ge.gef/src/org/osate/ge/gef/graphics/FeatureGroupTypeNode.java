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
package org.osate.ge.gef.graphics;

import org.eclipse.gef.fx.utils.NodeUtils;
import org.eclipse.gef.geometry.planar.IGeometry;
import org.osate.ge.gef.FxStyle;

import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;

public class FeatureGroupTypeNode extends Region implements GraphicNode {
	private final Path path = new Path();

	public FeatureGroupTypeNode() {
		this.getChildren().addAll(path);

		setLineWidth(2);
		setBackgroundColor(Color.WHITE);
		setOutlineColor(Color.BLACK);
	}

	@Override
	public void resize(double width, double height) {
		super.resize(width, height);

		final double halfEllipseOuterWidth = 2.0 * width / 3.0;
		final double halfEllipseOuterRadiusY = height / 2.0;
		final double halfEllipseInnerWidth = (halfEllipseOuterWidth + halfEllipseOuterWidth * 0.2) / 2.0;
		final double halfEllipseInnerRadiusY = (halfEllipseOuterRadiusY + halfEllipseOuterRadiusY * 0.2) / 2.0;
		final double halfEllipseYOffset = (height - 2 * halfEllipseInnerRadiusY) / 2.0;

		final double innerEllipseCenterX = halfEllipseOuterWidth;
		final double innerEllipseRadiusX = width / 3.0;
		final double innerEllipseRadiusY = height / 4.0;
		final double innerEllipseTopY = (height / 2.0) - innerEllipseRadiusY;

		path.getElements().setAll(
				// Outer Half Ellipse
				new MoveTo(halfEllipseOuterWidth, 0.0),
				new ArcTo(halfEllipseOuterWidth, height / 2.0, 0.0, halfEllipseOuterWidth, height, false, false),
				new VLineTo(height - halfEllipseYOffset),
				new ArcTo(halfEllipseInnerWidth, halfEllipseInnerRadiusY, 0.0, halfEllipseOuterWidth,
						halfEllipseYOffset, false, true),
				new VLineTo(0.0),
				// Inner Ellipse
				new MoveTo(innerEllipseCenterX + 1, innerEllipseTopY), new ArcTo(innerEllipseRadiusX,
						innerEllipseRadiusY, 0.0, innerEllipseCenterX, innerEllipseTopY, true, true),
				new ClosePath());
	}

	@Override
	public final void apply(final FxStyle style) {
		setBackgroundColor(style.getBackgroundColor());
		setOutlineColor(style.getOutlineColor());
		setLineWidth(style.getLineWidth());
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

	@Override
	public IGeometry getOutline() {
		return NodeUtils.getGeometricOutline(path);
	}
}
