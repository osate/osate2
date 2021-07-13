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
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;

/**
 * Node for Subprogram and Subprogram Group access features
 */
public class SubprogramAccessNode extends Parent implements Stylable {
	private final boolean hasBorder;
	private final Ellipse ellipse = new Ellipse(FeatureConstants.WIDTH / 2.0, FeatureConstants.HEIGHT / 2.0);
	private final javafx.scene.shape.Polyline directionIndicator = new javafx.scene.shape.Polyline();

	/**
	 * Creates a new instance
	 * @param requires true if the feature is a requires feature. Otherwise, it is an access feature. Determines orientation.
	 * @param hasBorder if true the ellipse will have a border. Otherwise, it will not. Intended to allow representing
	 * both subprogram access features and subprogram group access features while styling the direction indicator.
	 */
	public SubprogramAccessNode(final boolean requires, final boolean hasBorder) {
		this.hasBorder = hasBorder;
		this.getChildren().addAll(ellipse, directionIndicator);

		// Creates the ellipse node
		ellipse.setCenterX(FeatureConstants.WIDTH / 2.0);
		ellipse.setCenterY(FeatureConstants.HEIGHT / 2.0);
		ellipse.setStrokeType(StrokeType.INSIDE);
		ellipse.setStrokeLineCap(StrokeLineCap.BUTT);

		// Set points of direction indicator based on whether it is for a requires or provides feature
		final double directionIndicatorY = FeatureConstants.HEIGHT / 4.0;
		final double directionIndicatorWidth = FeatureConstants.WIDTH / 2.0;
		final double directionIndicatorHeight = FeatureConstants.HEIGHT - 2.0 * directionIndicatorY;
		final double directionIndicatorX = (FeatureConstants.WIDTH - directionIndicatorWidth) / 2.0;

		// Requires
		if (requires) {
			directionIndicator.getPoints().setAll(directionIndicatorWidth, 0.0, 0.0, directionIndicatorHeight / 2.0,
					directionIndicatorWidth, directionIndicatorHeight);
		} else {
			// Provides
			directionIndicator.getPoints().setAll(0.0, 0.0, directionIndicatorWidth, directionIndicatorHeight / 2.0,
					0.0, directionIndicatorHeight);
		}

		directionIndicator.setStrokeType(StrokeType.INSIDE);
		directionIndicator.setLayoutX(directionIndicatorX);
		directionIndicator.setLayoutY(directionIndicatorY);
		directionIndicator.setStrokeType(StrokeType.INSIDE);
		directionIndicator.setStrokeLineCap(StrokeLineCap.BUTT);

		setLineWidth(2.0);
		setBackgroundColor(Color.WHITE);
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
		ellipse.setFill(value);
	}

	public final void setOutlineColor(final Color value) {
		if (hasBorder) {
			ellipse.setStroke(value);
		}
		directionIndicator.setStroke(value);
	}

	public final void setLineWidth(final double value) {
		ellipse.setStrokeWidth(value);
		directionIndicator.setStrokeWidth(value);
	}

	public final void setStrokeDashArray(final ImmutableList<Double> value) {
		ellipse.getStrokeDashArray().setAll(value);
		directionIndicator.getStrokeDashArray().setAll(value);
	}
}
