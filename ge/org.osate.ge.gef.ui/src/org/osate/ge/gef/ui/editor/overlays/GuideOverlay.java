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
package org.osate.ge.gef.ui.editor.overlays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.osate.ge.gef.ui.editor.AgeEditor;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElementPredicates;
import org.osate.ge.internal.diagram.runtime.DiagramNode;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Bounds;
import javafx.scene.shape.Line;

/**
 * Manages displaying a horizontal and/or a vertical guide line to aide in aligning shapes.
 */
public class GuideOverlay implements AutoCloseable {
	private final AgeEditor editor;
	private final Line horizontalLine = new Line();
	private final ObjectProperty<Double> diagramHorizontalY = new SimpleObjectProperty<Double>();
	private final Line verticalLine = new Line();
	private final ObjectProperty<Double> diagramVerticalX = new SimpleObjectProperty<Double>();
	private final double[] xValues;
	private final double[] xCenterValues;
	private final double[] yValues;
	private final double[] yCenterValues;

	public GuideOverlay(final AgeEditor editor, final Set<DiagramElement> diagramElementsBeingModified) {
		this.editor = Objects.requireNonNull(editor, "editor must not be null");

		// Set style of lines
		this.horizontalLine.setStroke(OverlayColors.GUIDE_COLOR);
		this.horizontalLine.setStrokeWidth(2.0);
		this.verticalLine.setStroke(OverlayColors.GUIDE_COLOR);
		this.verticalLine.setStrokeWidth(2.0);

		final Overlays overlays = editor.getOverlays();
		overlays.getChildren().addAll(horizontalLine, verticalLine);

		final ObjectBinding<Bounds> rootBoundsInOverlay = new ObjectBinding<Bounds>() {
			{
				bind(overlays.sceneToLocalTransformProperty());
			}

			@Override
			protected Bounds computeValue() {
				final Bounds rootBounds = editor.getFxCanvas().getScene().getRoot().getLayoutBounds();
				return overlays.getSceneToLocalTransform().transform(rootBounds);
			}
		};

		//
		// Horizontal line
		//
		final DoubleBinding horizontalStartXBinding = new DoubleBinding() {
			{
				bind(rootBoundsInOverlay);
			}

			@Override
			protected double computeValue() {
				return rootBoundsInOverlay.get().getMinX();
			}
		};
		this.horizontalLine.startXProperty().bind(horizontalStartXBinding);

		final DoubleBinding horizontalEndXBinding = new DoubleBinding() {
			{
				bind(rootBoundsInOverlay);
			}

			@Override
			protected double computeValue() {
				return rootBoundsInOverlay.get().getMaxX();
			}
		};
		this.horizontalLine.endXProperty().bind(horizontalEndXBinding);

		final DoubleBinding localHorizontalYBinding = new DoubleBinding() {
			{
				bind(overlays.diagramToLocalTransformProperty(), diagramHorizontalY);
			}

			@Override
			protected double computeValue() {
				final Double value = diagramHorizontalY.get();
				return overlays.getDiagramToLocalTransform().transform(0, value == null ? 0 : value).getY();
			}
		};
		this.horizontalLine.startYProperty().bind(localHorizontalYBinding);
		this.horizontalLine.endYProperty().bind(localHorizontalYBinding);
		this.horizontalLine.visibleProperty().bind(diagramHorizontalY.isNotNull());

		//
		// Vertical Line
		//
		final DoubleBinding verticalStartYBinding = new DoubleBinding() {
			{
				bind(rootBoundsInOverlay);
			}

			@Override
			protected double computeValue() {
				return rootBoundsInOverlay.get().getMinY();
			}
		};
		this.verticalLine.startYProperty().bind(verticalStartYBinding);

		final DoubleBinding verticalEndYBinding = new DoubleBinding() {
			{
				bind(rootBoundsInOverlay);
			}

			@Override
			protected double computeValue() {
				return rootBoundsInOverlay.get().getMaxY();
			}
		};
		this.verticalLine.endYProperty().bind(verticalEndYBinding);

		final DoubleBinding localVerticalXBinding = new DoubleBinding() {
			{
				bind(overlays.diagramToLocalTransformProperty(), diagramVerticalX);
			}

			@Override
			protected double computeValue() {
				final Double value = diagramVerticalX.get();
				return overlays.getDiagramToLocalTransform().transform(value == null ? 0 : value, 0).getX();
			}
		};
		this.verticalLine.startXProperty().bind(localVerticalXBinding);
		this.verticalLine.endXProperty().bind(localVerticalXBinding);
		this.verticalLine.visibleProperty().bind(diagramVerticalX.isNotNull());

		// Create a set of diagram elements whose bounds will be included in the list of values for which guides will be shown
		final Set<DiagramElement> undockedDiagramElementsToInclude = new HashSet<>();
		boolean hasDockedElements = false;
		for (final DiagramElement diagramElementBeingModified : diagramElementsBeingModified) {
			if (DiagramElementPredicates.isShape(diagramElementBeingModified)) {
				if (diagramElementBeingModified.getDockArea() == null) {
					// Add siblings.
					undockedDiagramElementsToInclude
							.addAll(diagramElementBeingModified.getParent().getDiagramElements());
				} else {
					hasDockedElements = true;
				}
			}
		}

		// Build a list of x and y values
		final ArrayList<Double> xValues = new ArrayList<>(100);
		final ArrayList<Double> xCenterValues = new ArrayList<>(100);
		final ArrayList<Double> yValues = new ArrayList<>(100);
		final ArrayList<Double> yCenterValues = new ArrayList<>(100);
		addValues(editor.getDiagram(), 0.0, 0.0, diagramElementsBeingModified, undockedDiagramElementsToInclude,
				hasDockedElements,
				xValues, xCenterValues, yValues, yCenterValues);

		// Convert to sorted arrays
		this.xValues = xValues.stream().mapToDouble(Double::doubleValue).toArray();
		Arrays.sort(this.xValues);

		this.xCenterValues = xCenterValues.stream().mapToDouble(Double::doubleValue).toArray();
		Arrays.sort(this.xCenterValues);

		this.yValues = yValues.stream().mapToDouble(Double::doubleValue).toArray();
		Arrays.sort(this.yValues);

		this.yCenterValues = yCenterValues.stream().mapToDouble(Double::doubleValue).toArray();
		Arrays.sort(this.yCenterValues);
	}

	// Adds X and Y values for which the guides should appear to the collections
	private static void addValues(final DiagramNode parent, final double parentX, final double parentY,
			final Set<DiagramElement> diagramElementsToIgnore, final Set<DiagramElement> diagramElementsToInclude,
			final boolean includeDockedShapes, final Collection<Double> xValues, final Collection<Double> centerXValues,
			final Collection<Double> yValues, final Collection<Double> centerYValues) {
		for (final DiagramElement child : parent.getDiagramElements()) {
			if (!diagramElementsToIgnore.contains(child)) {
				final double childLeft = parentX + child.getX();
				final double childTop = parentY + child.getY();

				// Add values
				if ((child.getDockArea() != null && includeDockedShapes) || diagramElementsToInclude.contains(child)) {
					xValues.add(childLeft);
					centerXValues.add(childLeft + child.getWidth() / 2.0);
					xValues.add(childLeft + child.getWidth());
					yValues.add(childTop);
					centerYValues.add(childTop + child.getHeight() / 2.0);
					yValues.add(childTop + child.getHeight());
				}

				// Add values for children
				addValues(child, childLeft, childTop, diagramElementsToIgnore, diagramElementsToInclude, includeDockedShapes,
						xValues, centerXValues, yValues, centerYValues);
			}
		}
	}

	@Override
	public void close() {
		editor.getOverlays().getChildren().removeAll(horizontalLine, verticalLine);
	}

	/**
	 * Reset the values for which guides are being shown. This will hide the guides until these values are set.
	 */
	public void reset() {
		diagramHorizontalY.set(null);
		diagramVerticalX.set(null);
	}

	/**
	 * Returns whether the update* methods should be called.
	 * @return true if either the horizontal or vertical guide is not being shown due to a position not being set.
	 */
	public boolean shouldUpdate() {
		return diagramHorizontalY.get() == null || diagramVerticalX.get() == null;
	}

	/**
	 * Updates whether guides are shown for the specified bounds in diagram coordinates.
	 * @param bounds is the bounds in diagram coordinates.
	 */
	public void update(final Bounds bounds) {
		updateCenterX(bounds.getCenterX());
		updateX(bounds.getMinX());
		updateX(bounds.getMaxX());
		updateCenterY(bounds.getCenterY());
		updateY(bounds.getMinY());
		updateY(bounds.getMaxY());
	}

	/**
	 * Updates whether a vertical guide is shown for the specified X value. Does not check center X values.
	 * @param value is the X value.
	 */
	public void updateX(final double value) {
		if (diagramVerticalX.get() == null) {
			if (Arrays.binarySearch(xValues, value) >= 0) {
				diagramVerticalX.set(value);
			}
		}
	}

	/**
	 * Updates whether a vertical guide is shown for the specified X value. Only checks center X values.
	 * @param value is the X value.
	 */
	public void updateCenterX(final double value) {
		if (diagramVerticalX.get() == null) {
			if (Arrays.binarySearch(xCenterValues, value) >= 0) {
				diagramVerticalX.set(value);
			}
		}
	}

	/**
	 * Updates whether a horizontal guide is shown for the specified X value. Does not check center Y values.
	 * @param value is the Y value.
	 */
	public void updateY(final double value) {
		if (diagramHorizontalY.get() == null) {
			if (Arrays.binarySearch(yValues, value) >= 0) {
				diagramHorizontalY.set(value);
			}
		}
	}

	/**
	 * Updates whether a horizontal guide is shown for the specified Y value. Only checks center Y values.
	 * @param value is the Y value.
	 */
	public void updateCenterY(final double value) {
		if (diagramHorizontalY.get() == null) {
			if (Arrays.binarySearch(yCenterValues, value) >= 0) {
				diagramHorizontalY.set(value);
			}
		}
	}
}
