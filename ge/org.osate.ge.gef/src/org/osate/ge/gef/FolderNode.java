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
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;

/**
 * Node for folder graphics
 */
public class FolderNode extends Region implements ChopBoxGeometryProvider, Stylable {
	private final static double TAB_HEIGHT = 9;
	private final static double TAB_OFFSET_ANGLE = 30.0;
	private final static double MAX_TAB_WIDTH = 100;

	/**
	 * Percentage of width. Limited to {@link FolderNode#MAX_TAB_WIDTH}
	 */
	private final static double TOP_OF_TAB_OFFSET = 0.3;

	private final javafx.scene.shape.Polygon poly = new javafx.scene.shape.Polygon();

	public FolderNode() {
		this.getChildren().addAll(poly);

		poly.setStrokeType(StrokeType.INSIDE);
		poly.setStrokeLineCap(StrokeLineCap.BUTT);

		setLineWidth(2.0);
		setBackgroundColor(Color.WHITE);
		setOutlineColor(Color.BLACK);
	}

	@Override
	public void resize(double width, double height) {
		super.resize(width, height);

		// Width of tab
		final double widthOfTab = Math.min(MAX_TAB_WIDTH, (int) (width * TOP_OF_TAB_OFFSET));
		// The tab start and end slope
		final double tabOffset = (int) (Math.ceil(Math.tan(Math.toRadians(TAB_OFFSET_ANGLE)) * TAB_HEIGHT));

		poly.getPoints().setAll(0.0, height, 0.0, TAB_HEIGHT, tabOffset, 0.0, widthOfTab, 0.0,
				widthOfTab + tabOffset, TAB_HEIGHT, width, TAB_HEIGHT, width, height);
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
