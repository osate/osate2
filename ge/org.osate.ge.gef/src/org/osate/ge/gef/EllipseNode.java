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

import javafx.geometry.Dimension2D;
import javafx.scene.layout.Region;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;

/**
 * Node for ellipse graphics
 */
public class EllipseNode extends Region implements ChopBoxGeometryProvider, Stylable {
	private final boolean resizable;
	private final javafx.scene.shape.Ellipse ellipse = new Ellipse();

	/**
	 * Creates a new instance
	 */
	public EllipseNode() {
		this(null);
	}

	/**
	 * Creates a new instance with a fixed size
	 * @param fixedSize the size of the node. Min/Max/Pref will be set to this size.
	 * If null, the ellipse will not have a fixed size.
	 */
	public EllipseNode(final Dimension2D fixedSize) {
		this.resizable = fixedSize == null;
		this.getChildren().addAll(ellipse);

		// For fixed sized nodes, set the min=pref=max=fixed size
		if (fixedSize != null) {
			setPrefWidth(fixedSize.getWidth());
			setPrefHeight(fixedSize.getHeight());
			setMinWidth(fixedSize.getWidth());
			setMinHeight(fixedSize.getHeight());
			setMaxWidth(fixedSize.getWidth());
			setMaxHeight(fixedSize.getHeight());
			resize(fixedSize.getWidth(), fixedSize.getHeight());
		} else {
			// An exception can be thrown by GEF if an ellipse doesn't have an initial size.
			resize(4, 4);
		}

		ellipse.setStrokeType(StrokeType.INSIDE);
		ellipse.setStrokeLineCap(StrokeLineCap.BUTT);

		// Apply initial style
		apply(FxStyle.DEFAULT);
	}

	@Override
	public boolean isResizable() {
		return resizable;
	}

	@Override
	public void resize(final double width, final double height) {
		super.resize(width, height);
		ellipse.setCenterX(width / 2.0);
		ellipse.setCenterY(height / 2.0);
		ellipse.setRadiusX(width / 2.0);
		ellipse.setRadiusY(height / 2.0);
	}

	@Override
	public final void apply(final FxStyle style) {
		ellipse.setFill(style.getBackgroundColor());
		ellipse.setStroke(style.getOutlineColor());
		ellipse.setStrokeWidth(style.getLineWidth());
		ellipse.getStrokeDashArray().setAll(style.getStrokeDashArray());
	}

	@Override
	public IGeometry getChopBoxGeometry() {
		return NodeUtils.getGeometricOutline(ellipse);
	}
}
