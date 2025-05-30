/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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

import javafx.scene.layout.Region;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.StrokeLineCap;

/**
 * Node for processor graphics
 */
public class ProcessorNode extends Region implements ChopBoxGeometryProvider, Stylable {
	private static final double HORIZONTAL_OFFSET = 10.0;
	private static final double DEPTH = 12.0;

	private final Path outlineFill = new Path();
	private final Path shadedArea = new Path();
	private final Path outline = new Path();
	private final Path lineSegments = new Path();

	/**
	 * Creates a new instance
	 */
	public ProcessorNode() {
		this.getChildren().addAll(outlineFill, shadedArea, outline, lineSegments);

		outlineFill.setStroke(null);
		shadedArea.setStroke(null);
		outline.setStrokeLineCap(StrokeLineCap.BUTT);
		lineSegments.setStrokeLineCap(StrokeLineCap.BUTT);

		// Apply initial style
		apply(FxStyle.DEFAULT);
	}

	@Override
	public void resize(double width, double height) {
		super.resize(width, height);

		final PathElement[] outlinePathElements = new PathElement[] { new MoveTo(0, height), new LineTo(0, DEPTH),
				new LineTo(HORIZONTAL_OFFSET, 0), new LineTo(width, 0), new LineTo(width, height - DEPTH),
				new LineTo(width - HORIZONTAL_OFFSET, height), new LineTo(0, height) };
		outlineFill.getElements().setAll(outlinePathElements);
		shadedArea.getElements().setAll(new MoveTo(width - HORIZONTAL_OFFSET, DEPTH), new LineTo(width, 0),
				new LineTo(width, height - DEPTH), new LineTo(width - HORIZONTAL_OFFSET, height));
		outline.getElements().setAll(outlinePathElements);
		lineSegments.getElements().setAll(new MoveTo(0, DEPTH), new LineTo(width - HORIZONTAL_OFFSET, DEPTH),
				new LineTo(width, 0), new MoveTo(width - HORIZONTAL_OFFSET, DEPTH),
				new LineTo(width - HORIZONTAL_OFFSET, height));
	}

	@Override
	public final void apply(final FxStyle style) {
		outlineFill.setFill(style.getBackgroundColor());
		shadedArea.setFill(style.getBackgroundColor().darker());
		outline.setStroke(style.getOutlineColor());
		lineSegments.setStroke(style.getOutlineColor());
		outline.setStrokeWidth(style.getLineWidth());
		lineSegments.setStrokeWidth(style.getLineWidth());
		outline.getStrokeDashArray().setAll(style.getStrokeDashArray());
		lineSegments.getStrokeDashArray().setAll(style.getStrokeDashArray());
	}

	@Override
	public IGeometry getChopBoxGeometry() {
		return NodeUtils.getGeometricOutline(outline);
	}
}
