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

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;

/**
 * Node for mode graphics
 */
public class ModeNode extends Region implements ChopBoxGeometryProvider, Stylable, MinimumTopLabelPaddingProvider {
	private static final double INITIAL_MODE_ELLIPSE_RADIUS = 5.0;
	private static final double SPACING_BETWEEN_INITIAL_MODE_ELLIPSE_AND_MODE = 10.0;
	private static final double INITIAL_MODE_AREA_HEIGHT = 2.0 * INITIAL_MODE_ELLIPSE_RADIUS
			+ SPACING_BETWEEN_INITIAL_MODE_ELLIPSE_AND_MODE;
	private static final double MIN_MODE_SYMBOL_SIZE = 10.0;
	private static final double ARROW_SIZE = 8.0;

	private final Path modeSymbol = new Path();
	private final Circle initialModeCircle = new Circle(INITIAL_MODE_ELLIPSE_RADIUS);
	private final CubicCurve initialModeCurve = new CubicCurve();
	private final Path initialModeArrow = new Path();
	private BooleanProperty initialModeProperty = new SimpleBooleanProperty();

	/**
	 * Creates a new instance
	 */
	public ModeNode() {
		this.getChildren().addAll(modeSymbol, initialModeCircle, initialModeCurve, initialModeArrow);

		modeSymbol.setStrokeType(StrokeType.INSIDE);
		modeSymbol.setStrokeLineCap(StrokeLineCap.BUTT);
		initialModeCircle.setStrokeType(StrokeType.INSIDE);
		initialModeCircle.setStrokeLineCap(StrokeLineCap.BUTT);
		initialModeCurve.setStrokeLineCap(StrokeLineCap.BUTT);
		initialModeArrow.setStrokeType(StrokeType.INSIDE);
		initialModeArrow.setStrokeLineCap(StrokeLineCap.BUTT);
		initialModeCurve.setFill(null);

		// Listen to property change
		initialModeProperty.addListener((ChangeListener<Boolean>) (observable, oldValue, newValue) -> {
			updateInitialModeIndicatorVisibility();

			// Call a resize to relayout and configure the internal nodes
			resize(getWidth(), getHeight());
		});

		updateInitialModeIndicatorVisibility();

		// Set initial style
		setLineWidth(2.0);
		setBackgroundColor(Color.WHITE);
		setOutlineColor(Color.BLACK);
		setInitialMode(false);
	}

	@Override
	public void resize(double width, double height) {
		super.resize(width, height);

		final double modeTop;
		final double modeHeight;
		if (initialModeProperty.get()) {
			modeTop = INITIAL_MODE_AREA_HEIGHT;
			modeHeight = Math.max(0, height - INITIAL_MODE_AREA_HEIGHT);
		} else {
			modeTop = 0.0;
			modeHeight = height;
		}

		modeSymbol.getElements().setAll(new MoveTo(0, modeTop + modeHeight * 0.5), new LineTo(width * 0.25, modeTop),
				new LineTo(width * 0.75, modeTop), new LineTo(width, modeTop + modeHeight * 0.5),
				new LineTo(width * 0.75, modeTop + modeHeight), new LineTo(width * 0.25, modeTop + modeHeight),
				new LineTo(0, modeTop + modeHeight * 0.5));

		initialModeCircle
				.setCenterX(Math.max(0, Math.max(width / 2 - 50, width * 0.25) + initialModeCircle.getRadius()));
		initialModeCircle.setCenterY(initialModeCircle.getRadius());

		initialModeCurve.setStartX(initialModeCircle.getCenterX() + initialModeCircle.getRadius());
		initialModeCurve.setStartY(initialModeCircle.getCenterY());
		initialModeCurve.setEndX(width / 2.0);
		initialModeCurve.setEndY(modeTop - ARROW_SIZE);

		final double dx = initialModeCurve.getEndX() - initialModeCurve.getStartX();
		final double dy = initialModeCurve.getEndY() - initialModeCurve.getStartY();
		initialModeCurve.setControlX1(initialModeCurve.getStartX() + dx * 1.0);
		initialModeCurve.setControlY1(initialModeCurve.getStartY() + dy * 0.0);
		initialModeCurve.setControlX2(initialModeCurve.getStartX() + dx * 1.0);
		initialModeCurve.setControlY2(initialModeCurve.getStartY() + dy * 0.6);

		// Create arrow
		initialModeArrow.getElements().setAll(new MoveTo(-ARROW_SIZE / 2.0, 0), new LineTo(0, ARROW_SIZE),
				new LineTo(ARROW_SIZE / 2.0, 0), new ClosePath());
		initialModeArrow.setLayoutX(initialModeCurve.getEndX());
		initialModeArrow.setLayoutY(modeTop - ARROW_SIZE);
	}

	@Override
	public double getMinimumTopLabelPadding() {
		if (initialModeProperty.get()) {
			return INITIAL_MODE_AREA_HEIGHT;
		}

		return 0.0;
	}

	private void updateInitialModeIndicatorVisibility() {
		final boolean initial = initialModeProperty.getValue();
		initialModeCircle.setVisible(initial);
		initialModeCurve.setVisible(initial);
		initialModeArrow.setVisible(initial);
	}

	@Override
	public final void apply(final FxStyle style) {
		setBackgroundColor(style.getBackgroundColor());
		setOutlineColor(style.getOutlineColor());
		setLineWidth(style.getLineWidth());
		setStrokeDashArray(style.getStrokeDashArray());
	}

	public final void setBackgroundColor(final Color value) {
		modeSymbol.setFill(value);
		initialModeCircle.setFill(value);
	}

	public final void setOutlineColor(final Color value) {
		modeSymbol.setStroke(value);
		initialModeCircle.setStroke(value);
		initialModeCurve.setStroke(value);
		initialModeArrow.setStroke(value);
		initialModeArrow.setFill(value);
	}

	public final void setLineWidth(final double value) {
		modeSymbol.setStrokeWidth(value);
		initialModeCircle.setStrokeWidth(value);
		initialModeCurve.setStrokeWidth(value);
		initialModeArrow.setStrokeWidth(value);
	}

	public final void setStrokeDashArray(final ImmutableList<Double> value) {
		modeSymbol.getStrokeDashArray().setAll(value);
		initialModeCircle.getStrokeDashArray().setAll(value);
		initialModeCurve.getStrokeDashArray().setAll(value);
		initialModeArrow.getStrokeDashArray().setAll(value);
	}

	public final void setInitialMode(final boolean value) {
		initialModeProperty.setValue(value);
	}

	@Override
	protected double computeMinWidth(double height) {
		return MIN_MODE_SYMBOL_SIZE;
	}


	@Override
	protected double computeMinHeight(double width) {
		return INITIAL_MODE_AREA_HEIGHT + MIN_MODE_SYMBOL_SIZE;
	}

	@Override
	protected double computePrefWidth(double height) {
		return MIN_MODE_SYMBOL_SIZE;
	}

	@Override
	protected double computePrefHeight(double width) {
		return INITIAL_MODE_AREA_HEIGHT + MIN_MODE_SYMBOL_SIZE;
	}


	@Override
	public IGeometry getChopBoxGeometry() {
		return NodeUtils.getGeometricOutline(modeSymbol);
	}
}
