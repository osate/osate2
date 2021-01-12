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
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;

/**
 * Node for bus graphics
 */
public class BusNode extends Region implements ChopBoxGeometryProvider, Stylable {
	private Path path = new Path();

	/**
	 * Creates a new instance
	 */
	public BusNode() {
		this.getChildren().add(path);

		path.setStrokeType(StrokeType.INSIDE);
		path.setStrokeLineCap(StrokeLineCap.BUTT);

		setLineWidth(2.0);
		setBackgroundColor(Color.WHITE);
		setOutlineColor(Color.BLACK);
	}

	@Override
	public void resize(final double width, final double height) {
		super.resize(width, height);

		// Arrow width when width >= height
		final double arrowHeadPrimarySize = Math.max(Math.min(width, height) / 4.0, 20.0);

		// Arrow height when width >= height
		final double arrowHeadSecondarySize = Math.min(width, height) / 4.0;

		// Adjust appearance based on the largest direction
		if (width >= height) {
			path.getElements().setAll(new MoveTo(0.0, height / 2.0), new LineTo(arrowHeadPrimarySize, 0.0),
					new LineTo(arrowHeadPrimarySize, arrowHeadSecondarySize),
					new LineTo(width - arrowHeadPrimarySize, arrowHeadSecondarySize),
					new LineTo(width - arrowHeadPrimarySize, 0.0), new LineTo(width, height / 2.0),
					new LineTo(width - arrowHeadPrimarySize, height),
					new LineTo(width - arrowHeadPrimarySize, height - arrowHeadSecondarySize),
					new LineTo(arrowHeadPrimarySize, height - arrowHeadSecondarySize),
					new LineTo(arrowHeadPrimarySize, height), new ClosePath());
		} else {
			path.getElements().setAll(new MoveTo(width / 2.0, 0.0), new LineTo(0.0, arrowHeadPrimarySize),
					new LineTo(arrowHeadSecondarySize, arrowHeadPrimarySize),
					new LineTo(arrowHeadSecondarySize, height - arrowHeadPrimarySize),
					new LineTo(0.0, height - arrowHeadPrimarySize), new LineTo(width / 2.0, height),
					new LineTo(width, height - arrowHeadPrimarySize),
					new LineTo(width - arrowHeadSecondarySize, height - arrowHeadPrimarySize),
					new LineTo(width - arrowHeadSecondarySize, arrowHeadPrimarySize),
					new LineTo(width, arrowHeadPrimarySize), new ClosePath());
		}
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
	public IGeometry getChopBoxGeometry() {
		return NodeUtils.getGeometricOutline(path);
	}
}
