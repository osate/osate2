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
import javafx.scene.shape.Polygon;

// TODO: Rename
public class ParallelogramNode extends Region implements GraphicNode {
	private final javafx.scene.shape.Polygon poly = new Polygon();
	private final double horizontalOffset;

	public ParallelogramNode(final double horizontalOffset) {
		this.horizontalOffset = horizontalOffset;
		this.getChildren().addAll(poly);

		setLineWidth(2);
		setBackgroundColor(Color.WHITE);
		setOutlineColor(Color.BLACK);
	}

	@Override
	public void resize(double width, double height) {
		super.resize(width, height);

		poly.getPoints().setAll(horizontalOffset, 0.0, width, 0.0, width - horizontalOffset, height, 0.0, height);

	}

	@Override
	public final void setBackgroundColor(final Color value) {
		poly.setFill(value);
	}

	@Override
	public final void setOutlineColor(final Color value) {
		poly.setStroke(value);
	}

	@Override
	public final void setLineWidth(final double value) {
		poly.setStrokeWidth(value);
	}

	@Override
	public IGeometry getOutline() {
		return NodeUtils.getGeometricOutline(poly);
	}
}
