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

import javafx.geometry.Point2D;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

public class EventDataPortNode extends Region implements GraphicNode {
	private static final Point2D dataSymbolInOutPadding = new Point2D(10, 4);
	private static final Point2D dataSymbolDirectionalPadding = new Point2D(8, 4);

	private final EventPortNode eventPort = new EventPortNode();
	private final DataPortNode dataPort = new DataPortNode();

	public EventDataPortNode() {
		this.getChildren().addAll(eventPort, dataPort);

		setLineWidth(2);
		setBackgroundColor(Color.BLACK);
		setOutlineColor(Color.BLACK);
	}

	@Override
	public void layoutChildren() {
		final double width = this.getWidth();
		final double height = this.getHeight();

		// TODO: Directions
		final Point2D dataSymbolPadding = dataSymbolDirectionalPadding; // TODO: Choose base on direction or flag.

		dataPort.resize(width - dataSymbolPadding.getX(), height - 2 * dataSymbolPadding.getY());
		eventPort.resize(width, height);
		dataPort.setLayoutX(0);
		dataPort.setLayoutY(dataSymbolPadding.getY());
	}

	@Override
	public final void setBackgroundColor(final Color value) {
		dataPort.setBackgroundColor(value);
	}

	@Override
	public final void setOutlineColor(final Color value) {
		dataPort.setOutlineColor(value);
		eventPort.setOutlineColor(value);
	}

	@Override
	public final void setLineWidth(final double value) {
		dataPort.setLineWidth(value);
		eventPort.setLineWidth(value);
	}

	@Override
	public IGeometry getOutline() {
		// TODO
		return NodeUtils.getGeometricOutline(this);
	}
}
