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

import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.VLineTo;

public class DeviceNode extends Region implements GraphicNode {
	// TODO: Cleanup. Use collection? Can set property on nodes?
	private final Rectangle outline = new Rectangle();
	private final Path path = new Path(); // TODO: Rename
	private final Path lineSegments = new Path(); // TODO: Rename
	private final Path shadedPath = new Path();

	public DeviceNode() {
		lineSegments.setStrokeLineCap(StrokeLineCap.BUTT);
		this.getChildren().addAll(outline, shadedPath, path, lineSegments);

		setLineWidth(2);
		setBackgroundColor(Color.WHITE);
		setOutlineColor(Color.BLACK);

		// TODO: Set default style
	}

	@Override
	public void resize(double width, double height) {
		super.resize(width, height);

		final double padding = 14;

		outline.setWidth(width);
		outline.setHeight(height);

		path.getElements().setAll(new MoveTo(0, 0), new HLineTo(width), new VLineTo(height), new HLineTo(0),
				new VLineTo(0), new MoveTo(padding, padding), new HLineTo(width - padding),
				new VLineTo(height - padding), new HLineTo(padding), new VLineTo(padding));

		lineSegments.getElements().setAll(new MoveTo(0, 0), new LineTo(padding, padding), new MoveTo(width, 0),
				new LineTo(width - padding, padding), new MoveTo(0, height), new LineTo(padding, height - padding),
				new MoveTo(width - padding, height - padding), new LineTo(width, height));

		shadedPath.getElements().setAll(new MoveTo(width, 0), new LineTo(width - padding, padding),
				new VLineTo(height - padding), new LineTo(width, height), new MoveTo(0, height),
				new LineTo(padding, height - padding), new HLineTo(width - padding), new LineTo(width, height));
	}

	@Override
	public final void setBackgroundColor(final Color value) {
		outline.setFill(value);
		shadedPath.setFill(value.darker());
	}

	@Override
	public final void setOutlineColor(final Color value) {
		path.setStroke(value);
		lineSegments.setStroke(value);
	}

	@Override
	public final void setLineWidth(final double value) {
		path.setStrokeWidth(value);
		lineSegments.setStrokeWidth(value);
	}

	@Override
	public IGeometry getOutline() {
		// TODO
		return NodeUtils.getGeometricOutline(this);
	}
}
