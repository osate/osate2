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

import org.eclipse.gef.fx.utils.NodeUtils;
import org.eclipse.gef.geometry.planar.IGeometry;

import com.google.common.collect.ImmutableList;

import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;

/**
 * Node for memory graphics.
 */
public class MemoryNode extends Region implements ChopBoxGeometryProvider, Stylable {
	/**
	 * Height of the ellipse that is formed by the outline and the inner curve at the top of the node
	 */
	private static final double ELLIPSE_HEIGHT = 20.0;
	private static final double HALF_ELLIPSE_HEIGHT = ELLIPSE_HEIGHT / 2.0;

	private final Path outline = new Path();
	private final Path innerCurve = new Path();

	/**
	 * Create a new instance
	 */
	public MemoryNode() {
		this.getChildren().addAll(outline, innerCurve);

		outline.setStrokeType(StrokeType.INSIDE);
		outline.setStrokeLineCap(StrokeLineCap.BUTT);
		innerCurve.setStrokeType(StrokeType.INSIDE);
		innerCurve.setStrokeLineCap(StrokeLineCap.BUTT);

		setLineWidth(2.0);
		setBackgroundColor(Color.WHITE);
		setOutlineColor(Color.BLACK);
	}

	@Override
	public void resize(double width, double height) {
		super.resize(width, height);

		outline.getElements()
				.setAll(new MoveTo(width, HALF_ELLIPSE_HEIGHT),
						new CubicCurveTo(width, -HALF_ELLIPSE_HEIGHT / 3.0, 0.0, -HALF_ELLIPSE_HEIGHT / 3.0, 0.0,
								HALF_ELLIPSE_HEIGHT),
						new MoveTo(0, HALF_ELLIPSE_HEIGHT), new LineTo(0, height - HALF_ELLIPSE_HEIGHT),
						new CubicCurveTo(0.0, height + HALF_ELLIPSE_HEIGHT / 3.0, width,
								height + HALF_ELLIPSE_HEIGHT / 3.0, width, height - HALF_ELLIPSE_HEIGHT),
						new LineTo(width, ELLIPSE_HEIGHT / 2.0));
		innerCurve.getElements().setAll(new MoveTo(0, ELLIPSE_HEIGHT / 2.0), new CubicCurveTo(0.0,
				7.0 * HALF_ELLIPSE_HEIGHT / 3.0, width, 7.0 * HALF_ELLIPSE_HEIGHT / 3.0, width, HALF_ELLIPSE_HEIGHT));
	}

	@Override
	public final void apply(final FxStyle style) {
		setBackgroundColor(style.getBackgroundColor());
		setOutlineColor(style.getOutlineColor());
		setLineWidth(style.getLineWidth());
		setStrokeDashArray(style.getStrokeDashArray());
	}

	public final void setBackgroundColor(final Color value) {
		outline.setFill(value);
	}

	public final void setOutlineColor(final Color value) {
		outline.setStroke(value);
		innerCurve.setStroke(value);
	}

	public final void setLineWidth(final double value) {
		outline.setStrokeWidth(value);
		innerCurve.setStrokeWidth(value);
	}

	public final void setStrokeDashArray(final ImmutableList<Double> value) {
		outline.getStrokeDashArray().setAll(value);
		innerCurve.getStrokeDashArray().setAll(value);
	}

	@Override
	public IGeometry getChopBoxGeometry() {
		return NodeUtils.getGeometricOutline(outline);
	}
}
