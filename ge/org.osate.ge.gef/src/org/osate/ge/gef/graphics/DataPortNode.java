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

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;

//n.setPrefWidth(20);
//n.setPrefHeight(16);

public class DataPortNode extends Parent implements GraphicNode {
	private final javafx.scene.shape.Polygon poly = new javafx.scene.shape.Polygon();

	// TODO; Move to shared location
	private final double width = 20.0;
	private final double height = 16.0;
	// TODO: Shouldn't be resizable? Should be fixed size. Could wrap in non-resizable object if desired. Other
	// TODO; If resizable.. should extend region

	public DataPortNode() {
		this.getChildren().addAll(poly);
		poly.getPoints().setAll(0.0, 0.0, width, height / 2.0, 0.0, height);
		poly.setStrokeType(StrokeType.INSIDE);
		setLineWidth(2);
		setBackgroundColor(Color.BLACK);
		setOutlineColor(Color.BLACK);
	}


	@Override
	public final void apply(final FxStyle style) {
		setBackgroundColor(style.getBackgroundColor());
		setOutlineColor(style.getOutlineColor());
		setLineWidth(style.getLineWidth());
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

	@Override
	public IGeometry getOutline() {
		return NodeUtils.getGeometricOutline(poly);
	}
}
