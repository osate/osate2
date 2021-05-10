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

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

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
	private final ObjectProperty<Double> horizontalY = new SimpleObjectProperty<Double>();
	private final Line verticalLine = new Line();
	private final ObjectProperty<Double> verticalX = new SimpleObjectProperty<Double>();
	private final TreeSet<Double> xValues = new TreeSet<>(); // TODO.. Set an initial size ot avoid resizing alot?
	private final TreeSet<Double> xMidValues = new TreeSet<>(); // TODO.. Set an initial size ot avoid resizing alot?
	private final TreeSet<Double> yValues = new TreeSet<>(); // TODO.. Set an initial size ot avoid resizing alot?
	private final TreeSet<Double> yMidValues = new TreeSet<>(); // TODO.. Set an initial size ot avoid resizing alot?

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

		// TODO: Rename this or other to indicate local?
		final DoubleBinding horizontalYBinding = new DoubleBinding() {
			{
				bind(overlays.diagramToLocalTransformProperty(), horizontalY);
			}

			@Override
			protected double computeValue() {
				final Double value = horizontalY.get();
				return overlays.getDiagramToLocalTransform().transform(0, value == null ? 0 : value).getY();
			}
		};
		this.horizontalLine.startYProperty().bind(horizontalYBinding);
		this.horizontalLine.endYProperty().bind(horizontalYBinding);
		this.horizontalLine.visibleProperty().bind(horizontalY.isNotNull());

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

		// TODO: Rename this or other to indicate local?
		final DoubleBinding verticalXBinding = new DoubleBinding() {
			{
				bind(overlays.diagramToLocalTransformProperty(), verticalX);
			}

			@Override
			protected double computeValue() {
				final Double value = verticalX.get();
				return overlays.getDiagramToLocalTransform().transform(value == null ? 0 : value, 0).getX();
			}
		};
		this.verticalLine.startXProperty().bind(verticalXBinding);
		this.verticalLine.endXProperty().bind(verticalXBinding);
		this.verticalLine.visibleProperty().bind(verticalX.isNotNull());

		//
		Set<DiagramElement> diagramElementsToCheck = new HashSet<>(); // TODO: Rename? Just undocked shapes. Docked shapes are controlled by flag
		boolean hasDockedElements = false;
		for (final DiagramElement diagramElementBeingModified : diagramElementsBeingModified) {
			if (DiagramElementPredicates.isShape(diagramElementBeingModified)) {
				if (diagramElementBeingModified.getDockArea() == null) {
					// TODO. Add siblings. TODO: Consider whether to check here
					diagramElementsToCheck.addAll(diagramElementBeingModified.getParent().getDiagramElements());
				} else {
					hasDockedElements = true;
				}
			}
		}

		// TODO: Verify sorting, etc. WOuld a regular set work better?
		add(editor.getDiagram(), 0.0, 0.0, diagramElementsBeingModified, diagramElementsToCheck, hasDockedElements,
				xValues, xMidValues, yValues, yMidValues);
	}

//
	// TODO: Rename. Rename arguments?
	private static void add(final DiagramNode parent, final double parentX, final double parentY,
			final Set<DiagramElement> diagramElementsToIgnore, final Set<DiagramElement> diagramElementsToCheck,
			final boolean checkDockedShapes, final Collection<Double> xValues, final Collection<Double> xMidValues,
			final Collection<Double> yValues, final Collection<Double> yMidValues) {

		// TODO: Consdier whether parent thing is still an issue with this new design
		for (final DiagramElement child : parent.getDiagramElements()) {
			if (!diagramElementsToIgnore.contains(child)) {
				final double childLeft = parentX + child.getX();
				final double childTop = parentY + child.getY();

				if ((child.getDockArea() != null && checkDockedShapes) || diagramElementsToCheck.contains(child)) {
					// TODO; add to list
					xValues.add(childLeft);
					xMidValues.add(childLeft + child.getWidth() / 2.0);
					xValues.add(childLeft + child.getWidth());
					yValues.add(childTop);
					yMidValues.add(childTop + child.getHeight() / 2.0);
					yValues.add(childTop + child.getHeight());
				}

				add(child, childLeft, childTop, diagramElementsToIgnore, diagramElementsToCheck, checkDockedShapes,
						xValues, xMidValues, yValues, yMidValues);
			}
		}

	}

	@Override
	public void close() {
		editor.getOverlays().getChildren().removeAll(horizontalLine, verticalLine);
	}

	// TODO; For resze.. may just want to use points or somehow constrain things since only part of it is changed... or not?
	// TODO; Consider usign bounds in scene
	// TODO: DOn't use list.. Have a reset function?

	public void reset() {
		horizontalY.set(null);
		verticalX.set(null);
	}

	// TODO: Rename
	public boolean shouldUpdate() {
		return horizontalY.get() == null || verticalX.get() == null;
	}

	// TODO: Need variant that only checks subset...
	// TODO: Update documentation doesn't do anything if values are already updated
	// TODO: Rename to bounds in diagram?
	public void update(final Bounds bounds) {
		// TODO: This is too eager/simplistic... Exterme of new bounds should check against extremes of other elements
		// TODO; Should check mid of boudns against mid of others..
		// TOOD; HOWEVER: SHoudl not check mid against top for example

		// TODO: Only do it when not already set

		if (horizontalY.get() == null) {
			final double midY = (bounds.getMinY() + bounds.getMaxY()) / 2.0;
			if (yMidValues.contains(midY)) {
				horizontalY.set(midY);
			} else if (yValues.contains(bounds.getMinY())) {
				horizontalY.set(bounds.getMinY());
			} else if (yValues.contains(bounds.getMaxY())) {
				horizontalY.set(bounds.getMaxY());
			}
		}

		if (verticalX.get() == null) {
			final double midX = (bounds.getMinX() + bounds.getMaxX()) / 2.0;
			if (xMidValues.contains(midX)) {
				verticalX.set(midX);
			} else if (xValues.contains(bounds.getMinX())) {
				verticalX.set(bounds.getMinX());
			} else if (xValues.contains(bounds.getMaxX())) {
				verticalX.set(bounds.getMaxX());
			}
		}
	}
}
