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

import com.google.common.collect.ImmutableList;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;

/**
 * Node for event, data, and event data port graphics
 */
public class PortNode extends Parent implements Stylable {
	private final javafx.scene.shape.Polyline eventNode = new javafx.scene.shape.Polyline();
	private final javafx.scene.shape.Polygon dataNode = new javafx.scene.shape.Polygon();

	/**
	 * Creates a new instance
	 * @param event whether the port is an event port
	 * @param data whether the port is a data port
	 * @param direction the direction of the port
	 */
	public PortNode(final boolean event, final boolean data, final FeatureDirection direction) {
		this.getChildren().addAll(eventNode, dataNode);

		final double dataSymbolXPadding;
		final double dataSymbolYPadding;

		if (event) {
			if (direction == FeatureDirection.IN_OUT) {
				dataSymbolXPadding = 10.0;
				dataSymbolYPadding = 4.0;
			} else {
				dataSymbolXPadding = 8.0;
				dataSymbolYPadding = 4.0;
			}
		} else {
			dataSymbolXPadding = 0;
			dataSymbolYPadding = 0;
		}

		// Set points based on direction
		switch (direction) {
		case IN:
			if (event) {
				eventNode.getPoints().setAll(0.0, 0.0, FeatureConstants.WIDTH, FeatureConstants.HEIGHT / 2.0, 0.0,
						FeatureConstants.HEIGHT);
			}

			if (data) {
				dataNode.getPoints().setAll(0.0, dataSymbolYPadding, FeatureConstants.WIDTH - dataSymbolXPadding,
						FeatureConstants.HEIGHT / 2.0, 0.0, FeatureConstants.HEIGHT - dataSymbolYPadding);
			}

			break;
		case OUT:
			if (event) {
				eventNode.getPoints().setAll(FeatureConstants.WIDTH, 0.0, 0.0, FeatureConstants.HEIGHT / 2.0,
						FeatureConstants.WIDTH, FeatureConstants.HEIGHT);
			}

			if (data) {
				dataNode.getPoints().setAll(FeatureConstants.WIDTH, dataSymbolYPadding, dataSymbolXPadding,
						FeatureConstants.HEIGHT / 2.0, FeatureConstants.WIDTH,
						FeatureConstants.HEIGHT - dataSymbolYPadding);
			}

			break;
		case IN_OUT:
			if (event) {
				eventNode.getPoints().setAll(FeatureConstants.WIDTH / 2.0, 0.0, FeatureConstants.WIDTH,
						FeatureConstants.HEIGHT / 2.0, FeatureConstants.WIDTH / 2.0, FeatureConstants.HEIGHT, 0.0,
						FeatureConstants.HEIGHT / 2.0, FeatureConstants.WIDTH / 2.0, 0.0);
			}

			if (data) {
				dataNode.getPoints().setAll(FeatureConstants.WIDTH / 2.0, dataSymbolYPadding,
						FeatureConstants.WIDTH - dataSymbolXPadding / 2.0, FeatureConstants.HEIGHT / 2.0,
						FeatureConstants.WIDTH / 2.0, FeatureConstants.HEIGHT - dataSymbolYPadding,
						dataSymbolXPadding / 2.0, FeatureConstants.HEIGHT / 2.0);
			}

			break;

		default:
			throw new RuntimeException("Unsupported value: " + direction);
		}

		eventNode.setStrokeType(StrokeType.INSIDE);
		eventNode.setStrokeLineCap(StrokeLineCap.BUTT);
		dataNode.setStrokeType(StrokeType.INSIDE);
		dataNode.setStrokeLineCap(StrokeLineCap.BUTT);

		setLineWidth(2.0);
		setBackgroundColor(Color.BLACK);
		setOutlineColor(Color.BLACK);
	}

	@Override
	public final void apply(final FxStyle style) {
		setBackgroundColor(style.getBackgroundColor());
		setOutlineColor(style.getOutlineColor());
		setLineWidth(style.getLineWidth());
		setStrokeDashArray(style.getStrokeDashArray());
	}

	public final void setBackgroundColor(final Color value) {
		dataNode.setFill(value);
	}

	public final void setOutlineColor(final Color value) {
		eventNode.setStroke(value);
		dataNode.setStroke(value);
	}

	public final void setLineWidth(final double value) {
		eventNode.setStrokeWidth(value);
		dataNode.setStrokeWidth(value);
	}

	public final void setStrokeDashArray(final ImmutableList<Double> value) {
		eventNode.getStrokeDashArray().setAll(value);
		dataNode.getStrokeDashArray().setAll(value);
	}
}
