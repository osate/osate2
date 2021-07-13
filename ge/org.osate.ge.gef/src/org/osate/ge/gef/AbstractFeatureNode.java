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

import com.google.common.collect.ImmutableList;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;

/**
 * Node for abstract feature graphics
 */
public class AbstractFeatureNode extends Parent implements Stylable {
	private final javafx.scene.shape.Polyline directionIndicator = new javafx.scene.shape.Polyline();
	private final Circle circle = new Circle();

	/**
	 * Creates a new instance
	 * @param direction the direction of the abstract feature
	 */
	public AbstractFeatureNode(final FeatureDirection direction) {
		this.getChildren().addAll(directionIndicator, circle);

		// Configure direction indicator
		final double circlePadding = direction == FeatureDirection.IN_OUT ? 0 : 3;
		switch (direction) {
		case IN:
			directionIndicator.getPoints().setAll(0.0, 0.0, FeatureConstants.WIDTH, FeatureConstants.HEIGHT / 2.0, 0.0,
					FeatureConstants.HEIGHT);
			break;
		case OUT:
			directionIndicator.getPoints().setAll(FeatureConstants.WIDTH, 0.0, 0.0, FeatureConstants.HEIGHT / 2.0,
					FeatureConstants.WIDTH, FeatureConstants.HEIGHT);
			break;
		case IN_OUT:
		default:
			break;
		}

		directionIndicator.setStrokeType(StrokeType.INSIDE);

		// Configure circle
		final double circleDiameter = FeatureConstants.MIN_DIMENSION - 2.0 * circlePadding;
		final double circleRadius = circleDiameter / 2.0;
		circle.setStrokeType(StrokeType.INSIDE);
		circle.setCenterX(circleRadius);
		circle.setCenterY(circleRadius);
		circle.setRadius(circleRadius);
		circle.setLayoutY(circlePadding);
		circle.setStrokeLineCap(StrokeLineCap.BUTT);
		if (direction == FeatureDirection.OUT) {
			circle.setLayoutX(FeatureConstants.WIDTH - circleDiameter);
		}

		// Set initial style
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
		circle.setFill(value);
	}

	public final void setOutlineColor(final Color value) {
		directionIndicator.setStroke(value);
		circle.setStroke(value);
	}

	public final void setLineWidth(final double value) {
		directionIndicator.setStrokeWidth(value);
		circle.setStrokeWidth(value);
	}

	public final void setStrokeDashArray(final ImmutableList<Double> value) {
		circle.getStrokeDashArray().setAll(value);
	}
}
