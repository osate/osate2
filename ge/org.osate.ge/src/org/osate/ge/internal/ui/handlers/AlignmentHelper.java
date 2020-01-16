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
package org.osate.ge.internal.ui.handlers;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.osate.ge.graphics.Dimension;
import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramModification;
import org.osate.ge.internal.diagram.runtime.DockArea;
import org.osate.ge.internal.query.Queryable;


class AlignmentHelper {
	private final Axis axis;

	private AlignmentHelper(final Axis axis) {
		this.axis = axis;
	}

	public static AlignmentHelper create(final Axis axis) {
		return new AlignmentHelper(axis);
	}

	public void alignElement(final DiagramModification m, AlignmentElement alignmentElement, final double alignLocation,
			final double elementOffset) {

		// Alignment location for element relative to diagram
		double newLocation = alignLocation - elementOffset;

		// Check if new shape location fits within parent(s)
		while (alignmentElement.getDiagramElement().getParent() instanceof DiagramElement) {
			final DiagramElement parentDe = (DiagramElement) alignmentElement.getDiagramElement().getParent();
			final double parentAbsoluteLocation = axis.getParentAbsoluteLocation(alignmentElement);

			// If new location is to the left of parent for horizontal alignment or above parent for vertical alignment,
			// parent will have to shift and resize
			if (parentAbsoluteLocation > newLocation) {

				// Amount that the children need to shift to stay in same place after parent resize
				final double childOffset = parentAbsoluteLocation - newLocation;
				shiftChildren(m, parentDe, childOffset);

				// Move shape to top or left edge of parent depending on axis alignment
				final DiagramElement de = alignmentElement.getDiagramElement();
				m.setPosition(de, axis.getEdgeLocation(de), false, true);

				// Set parent size to accommodate for the new alignment element location
				m.setSize(parentDe, axis.getParentSize(parentDe, childOffset));

				// The element ancestor that will be moving to the alignment location
				alignmentElement = new AlignmentElement(parentDe, parentAbsoluteLocation);
			} else {
				break;
			}
		}

		final DiagramElement de = alignmentElement.getDiagramElement();
		if (de.getParent() instanceof DiagramElement) {

			// Set location relative to parent
			newLocation = axis.getLocationRelativeToParent(de,
					alignmentElement.getAbsoluteLocation() - alignLocation) - elementOffset;

			// Ports cannot overlap, check if any collide and shift if necessary
			if (de.getDockArea() != null) {
				shiftCollidingPorts(m, de, newLocation);
			}
		}

		// Set the element new location and update bendpoints
		m.setPosition(de, axis.getAlignmentPosition(de, newLocation), false, true);
	}

	private void shiftCollidingPorts(final DiagramModification m, final DiagramElement de, final double newLocation) {
		// Check for colliding ports
		for (final Queryable q : de.getParent().getChildren()) {
			if (q instanceof DiagramElement && ((DiagramElement) q).getDockArea() == de.getDockArea()) {
				final DiagramElement dockedChild = (DiagramElement) q;

				if (axis.isPortCollision(dockedChild, newLocation)) {
					// Adjust colliding port
					m.setPosition(dockedChild, axis.getNewPortLocation(dockedChild, newLocation + 1), false, true);
					break;
				}
			}
		}
	}

	// Shift eligible children
	private void shiftChildren(final DiagramModification m, final DiagramElement parentDe, final double childOffset) {
		for (final Queryable q : parentDe.getChildren()) {
			if (q instanceof DiagramElement && axis.isValidDockArea().apply(((DiagramElement) q).getDockArea())) {
				final DiagramElement childDe = (DiagramElement) q;
				m.setPosition(childDe, axis.getShiftPostion(childDe, childOffset), false, true);
			}
		}
	}

	// Any selected element must not be a descendant of any other selected element.
	// Must be docked to appropriate area
	boolean getEnabled() {
		final List<DiagramElement> selectedElements = AgeHandlerUtil.getSelectedDiagramElements();

		// More than one diagram elements must be selected
		if (selectedElements.size() < 2) {
			return false;
		}

		for (final DiagramElement de : selectedElements) {
			if (!axis.isValidDockArea().apply(de.getDockArea()) || isAncestorSelected(de, selectedElements)) {
				return false;
			}
		}

		final List<DiagramElement> dockedElements = selectedElements.stream().filter(de -> de.getDockArea() != null)
				.collect(Collectors.toList());
		if (dockedElements.size() > 1) {
			return validDockedElement(dockedElements);
		}

		return true;
	}

	// Docked elements must be docked to opposite sides if they have the same parent
	private static boolean validDockedElement(final List<DiagramElement> dockedElements) {
		for (int i = 0; i < (dockedElements.size() - 1); i++) {
			final DiagramElement de = dockedElements.get(i);
			if (hasSameParentAndDockArea(dockedElements, de, i)) {
				return false;
			}
		}

		return true;
	}

	private static boolean hasSameParentAndDockArea(final List<DiagramElement> dockedElements, final DiagramElement de,
			int i) {
		while (i < (dockedElements.size() - 1)) {
			final DiagramElement tmp = dockedElements.get(++i);
			if (de.getDockArea() == tmp.getDockArea() && de.getParent() == tmp.getParent()) {
				return true;
			}
		}

		return false;
	}

	static boolean isAncestorSelected(final DiagramElement de, final List<DiagramElement> selectedElements) {
		Queryable parent = de.getParent();

		while (parent != null) {
			if (selectedElements.contains(parent)) {
				return true;
			}
			parent = parent.getParent();
		}

		return false;
	}

	// Element that other elements will align with
	public static AlignmentElement getPrimaryAlignmentElement(final List<AlignmentElement> elements) {
		if (elements.size() == 0) {
			return null;
		}

		return elements.get(elements.size() - 1);
	}

	static class AlignmentElement {
		private final DiagramElement de;
		private double absoluteLocation; // Element's location relative to the diagram

		public AlignmentElement(final DiagramElement de, final double absoluteLocation) {
			this.de = de;
			this.absoluteLocation = absoluteLocation;
		}

		public AlignmentElement(final DiagramElement de, final Function<DiagramElement, Double> getAxisValue) {
			this(de, getDiagramAbsoluteLocation(de, getAxisValue));
		}

		public double getAbsoluteLocation() {
			return absoluteLocation;
		}

		public DiagramElement getDiagramElement() {
			return de;
		}

		private static double getDiagramAbsoluteLocation(DiagramElement de,
				final Function<DiagramElement, Double> getLocation) {
			double loc = getLocation.apply(de);
			while (de.getParent() instanceof DiagramElement) {
				de = (DiagramElement) de.getParent();
				loc += getLocation.apply(de);
			}

			return loc;
		}
	}

	/**
	 * Helper methods for aligning elements on an axis
	 */
	private interface Axis {
		Dimension getParentSize(final DiagramElement de, final double offset);

		Point getShiftPostion(final DiagramElement de, final double offset);

		double getLocationRelativeToParent(final DiagramElement de, final double alignLocation);

		double getParentAbsoluteLocation(final AlignmentElement alignmentElement);

		Point getEdgeLocation(final DiagramElement de);

		Point getAlignmentPosition(final DiagramElement de, final double newLoc);

		Function<DiagramElement, Double> getAxisLocation();

		boolean isPortCollision(final DiagramElement dockedChild, final double location);

		Point getNewPortLocation(final DiagramElement dockedChild, final double location);

		Function<DockArea, Boolean> isValidDockArea();
	}

	/**
	 * Horizontal axis alignment methods
	 */
	static class HorizontalAxis implements Axis {
		@Override
		public Dimension getParentSize(final DiagramElement de, final double offset) {
			return new Dimension(de.getWidth() + offset, de.getHeight());
		}

		@Override
		public Point getShiftPostion(final DiagramElement de, final double offset) {
			return new Point(de.getX() + offset, de.getY());
		}

		@Override
		public double getLocationRelativeToParent(final DiagramElement de, final double alignLocation) {
			return de.getX() - alignLocation;
		}

		@Override
		public double getParentAbsoluteLocation(final AlignmentElement alignmentElement) {
			return alignmentElement.getAbsoluteLocation() - alignmentElement.getDiagramElement().getX();
		}

		@Override
		public Point getEdgeLocation(final DiagramElement de) {
			return new Point(0, de.getY());
		}

		@Override
		public Point getAlignmentPosition(final DiagramElement de, final double newLoc) {
			return new Point(newLoc, de.getY());
		}

		@Override
		public Function<DiagramElement, Double> getAxisLocation() {
			return (diagramElement) -> (diagramElement.getX());
		}

		@Override
		public Point getNewPortLocation(final DiagramElement dockedChild, final double location) {
			return new Point(location + 1, dockedChild.getY());
		}

		@Override
		public boolean isPortCollision(final DiagramElement dockedChild, final double location) {
			return location >= dockedChild.getX()
					&& location <= dockedChild.getX() + dockedChild.getWidth();
		}

		@Override
		public Function<DockArea, Boolean> isValidDockArea() {
			return (dockArea) -> dockArea == null || dockArea == DockArea.TOP || dockArea == DockArea.BOTTOM;
		}
	}

	/**
	 * Vertical axis alignment methods
	 */
	static class VerticalAxis implements Axis {
		@Override
		public Dimension getParentSize(final DiagramElement de, final double offset) {
			return new Dimension(de.getWidth(), de.getHeight() + offset);
		}

		@Override
		public Point getShiftPostion(final DiagramElement de, final double offset) {
			return new Point(de.getX(), de.getY() + offset);
		}

		@Override
		public double getLocationRelativeToParent(final DiagramElement de, final double alignLocation) {
			return de.getY() - alignLocation;
		}

		@Override
		public double getParentAbsoluteLocation(final AlignmentElement alignmentElement) {
			return alignmentElement.getAbsoluteLocation() - alignmentElement.getDiagramElement().getY();
		}

		@Override
		public Point getEdgeLocation(final DiagramElement de) {
			return new Point(de.getX(), 0);
		}

		@Override
		public Point getAlignmentPosition(final DiagramElement de, final double newLoc) {
			return new Point(de.getX(), newLoc);
		}

		@Override
		public Function<DiagramElement, Double> getAxisLocation() {
			return (de) -> (de.getY());
		}

		@Override
		public Point getNewPortLocation(final DiagramElement dockedChild, final double location) {
			return new Point(dockedChild.getX(), location);
		}

		@Override
		public boolean isPortCollision(final DiagramElement dockedChild, final double location) {
			return location >= dockedChild.getY()
					&& location <= dockedChild.getY() + dockedChild.getHeight();
		}

		@Override
		public Function<DockArea, Boolean> isValidDockArea() {
			return (dockArea) -> dockArea == null || dockArea == DockArea.LEFT || dockArea == DockArea.RIGHT;
		}
	}

	public Function<DiagramElement, Double> getAxisLocation() {
		return axis.getAxisLocation();
	}
}