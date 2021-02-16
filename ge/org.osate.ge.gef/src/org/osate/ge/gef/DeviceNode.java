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
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;

/**
 * Node for device graphics
 */
public class DeviceNode extends Region implements ChopBoxGeometryProvider, Stylable {
	private static final double SHADED_AREA_PADDING = 4.0;

	private final Rectangle fillRect = new Rectangle();
	private final Path shadedArea = new Path();
	private final Path lineSegments = new Path();

	/**
	 * Creates a new instance
	 */
	public DeviceNode() {
		this.getChildren().addAll(fillRect, shadedArea, lineSegments);

		shadedArea.setStrokeWidth(0.0);
		lineSegments.setStrokeLineCap(StrokeLineCap.BUTT);

		setLineWidth(2.0);
		setBackgroundColor(Color.WHITE);
		setOutlineColor(Color.BLACK);
	}

	@Override
	public void resize(double width, double height) {
		super.resize(width, height);

		fillRect.setWidth(width);
		fillRect.setHeight(height);

		shadedArea.getElements().setAll(new MoveTo(width, 0),
				new LineTo(width - SHADED_AREA_PADDING, SHADED_AREA_PADDING),
				new LineTo(width - SHADED_AREA_PADDING, height - SHADED_AREA_PADDING), new LineTo(width, height),
				new MoveTo(0, height), new LineTo(SHADED_AREA_PADDING, height - SHADED_AREA_PADDING),
				new LineTo(width - SHADED_AREA_PADDING, height - SHADED_AREA_PADDING), new LineTo(width, height));

		lineSegments.getElements().setAll(new MoveTo(0, 0), new LineTo(SHADED_AREA_PADDING, SHADED_AREA_PADDING),
				new MoveTo(width, 0), new LineTo(width - SHADED_AREA_PADDING, SHADED_AREA_PADDING),
				new MoveTo(0, height), new LineTo(SHADED_AREA_PADDING, height - SHADED_AREA_PADDING),
				new MoveTo(width - SHADED_AREA_PADDING, height - SHADED_AREA_PADDING), new LineTo(width, height),
				new MoveTo(0, 0), new LineTo(width, 0), new LineTo(width, height), new LineTo(0, height),
				new LineTo(0, 0), new MoveTo(SHADED_AREA_PADDING, SHADED_AREA_PADDING),
				new LineTo(width - SHADED_AREA_PADDING, SHADED_AREA_PADDING),
				new LineTo(width - SHADED_AREA_PADDING, height - SHADED_AREA_PADDING),
				new LineTo(SHADED_AREA_PADDING, height - SHADED_AREA_PADDING),
				new LineTo(SHADED_AREA_PADDING, SHADED_AREA_PADDING));
	}

	@Override
	public final void apply(final FxStyle style) {
		setBackgroundColor(style.getBackgroundColor());
		setOutlineColor(style.getOutlineColor());
		setLineWidth(style.getLineWidth());
		setStrokeDashArray(style.getStrokeDashArray());
	}

	public final void setBackgroundColor(final Color value) {
		shadedArea.setFill(value.darker());
		fillRect.setFill(value);
	}

	public final void setOutlineColor(final Color value) {
		lineSegments.setStroke(value);
	}

	public final void setLineWidth(final double value) {
		lineSegments.setStrokeWidth(value);
	}

	public final void setStrokeDashArray(final ImmutableList<Double> value) {
		lineSegments.getStrokeDashArray().setAll(value);
	}

	@Override
	public IGeometry getChopBoxGeometry() {
		return NodeUtils.getGeometricOutline(fillRect);
	}
}
