package org.osate.ge.internal.ui.handlers;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramModification;
import org.osate.ge.internal.diagram.runtime.Dimension;
import org.osate.ge.internal.diagram.runtime.DockArea;
import org.osate.ge.internal.query.Queryable;


class AlignmentUtil {
	private AxisAlignmentUtil axisAlignmentUtil;

	private void setAxisAlignmentUtil(final AxisAlignmentUtil axisAlignmentUtil) {
		this.axisAlignmentUtil = axisAlignmentUtil;
	}

	public void alignElement(final DiagramModification m, AlignmentElement alignmentElement, final double alignLocation,
			final double elementOffset) {
		Objects.requireNonNull(axisAlignmentUtil, "axis alignment util must not be null");

		// Alignment location for element relative to diagram
		double newLocation = alignLocation - elementOffset;

		// Check if new shape location fits within parent(s)
		while (alignmentElement.getDiagramElement().getParent() instanceof DiagramElement) {
			final DiagramElement parentDe = (DiagramElement) alignmentElement.getDiagramElement().getParent();
			final double parentDiagramRelativeLocation = axisAlignmentUtil.getParentDiagramRelativeLocation(alignmentElement);

			// If new location is to the left of parent for horizontal alignment or above parent for vertical alignment,
			// parent will have to shift and resize
			if (parentDiagramRelativeLocation > newLocation) {

				// Amount that the children need to shift to stay in same place after parent resize
				final double childOffset = parentDiagramRelativeLocation - newLocation;
				shiftChildren(m, parentDe, childOffset);

				// Move shape to top or left edge of parent depending on axis alignment
				final DiagramElement de = alignmentElement.getDiagramElement();
				setPositionAndDockArea(m, de, axisAlignmentUtil.getEdgeLocation(de));

				// Set parent size to accommodate for the new alignment element location
				m.setSize(parentDe, axisAlignmentUtil.getParentSize(parentDe, childOffset));

				// The element ancestor that will be moving to the alignment location
				alignmentElement = new AlignmentElement(parentDe, parentDiagramRelativeLocation);
			} else {
				break;
			}
		}

		final DiagramElement de = alignmentElement.getDiagramElement();
		if (de.getParent() instanceof DiagramElement) {

			// Set location relative to parent
			newLocation = axisAlignmentUtil.getLocationRelativeToParent(de,
					alignmentElement.getDiagramRelativeLocation() - alignLocation) - elementOffset;

			// Ports cannot overlap, check if any collide and shift if necessary
			if (de.getDockArea() != null) {
				shiftCollidingPorts(m, de, newLocation);
			}
		}

		// Set the element new location
		setPositionAndDockArea(m, de, axisAlignmentUtil.getAlignmentPosition(de, newLocation));
	}

	private void shiftCollidingPorts(final DiagramModification m, final DiagramElement de, final double newLocation) {
		// Check for colliding ports
		for (final Queryable q : de.getParent().getChildren()) {
			if (q instanceof DiagramElement && ((DiagramElement) q).getDockArea() == de.getDockArea()) {
				final DiagramElement dockedChild = (DiagramElement) q;

				if (axisAlignmentUtil.isPortCollision(dockedChild, newLocation)) {

					// Adjust colliding port
					setPositionAndDockArea(m, dockedChild,
							axisAlignmentUtil.getNewPortLocation(dockedChild, newLocation + 1));
					break;
				}
			}
		}
	}

	// TODO Philip: Change set position to not change docked area. Example: When port is docked top and moves to left edge,
	// it auto switches to dock left
	private static void setPositionAndDockArea(final DiagramModification m, final DiagramElement de, final Point position) {
		final DockArea dockArea = de.getDockArea();
		m.setPosition(de, position);
		m.setDockArea(de, dockArea);
	}

	// Shift eligible children
	private void shiftChildren(final DiagramModification m, final DiagramElement parentDe, final double childOffset) {
		for (final Queryable q : parentDe.getChildren()) {
			if (q instanceof DiagramElement && axisAlignmentUtil.isShiftable((DiagramElement) q)) {
				final DiagramElement childDe = (DiagramElement) q;
				setPositionAndDockArea(m, childDe, axisAlignmentUtil.getShiftPostion(childDe, childOffset));
			}
		}
	}

	// Any selected element must not be a descendant of any other selected element.
	// Must be docked to appropriate area
	static boolean getEnabled(final Function<DockArea, Boolean> isValidDockArea) {
		final List<DiagramElement> selectedElements = AgeHandlerUtil.getSelectedDiagramElements();

		// More than one diagram elements must be selected
		if (selectedElements.size() < 2) {
			return false;
		}

		for (final DiagramElement de : selectedElements) {
			if (!isValidDockArea.apply(de.getDockArea()) || isAncestorSelected(de, selectedElements)) {
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
		private double relativeLocation; // Element's location relative to the diagram

		public AlignmentElement(final DiagramElement de, final Function<DiagramElement, Double> getAxisValue) {
			this.de = de;
			setDiagramRelativeLocation(de, getAxisValue);
		}

		public AlignmentElement(final DiagramElement de, final double relativeLocation) {
			this.de = de;
			this.relativeLocation = relativeLocation;
		}

		public double getDiagramRelativeLocation() {
			return relativeLocation;
		}

		public DiagramElement getDiagramElement() {
			return de;
		}

		private void setDiagramRelativeLocation(DiagramElement de,
				final Function<DiagramElement, Double> getLocation) {
			double loc = getLocation.apply(de);
			while (de.getParent() instanceof DiagramElement) {
				de = (DiagramElement) de.getParent();
				loc += getLocation.apply(de);
			}

			this.relativeLocation = loc;
		}
	}

	private interface AxisAlignmentUtil {
		Dimension getParentSize(final DiagramElement de, final double offset);

		Point getShiftPostion(final DiagramElement de, final double offset);

		double getLocationRelativeToParent(final DiagramElement de, final double alignLocation);

		double getParentDiagramRelativeLocation(final AlignmentElement alignmentElement);

		Point getEdgeLocation(final DiagramElement de);

		Point getAlignmentPosition(final DiagramElement de, final double newLoc);

		Function<DiagramElement, Double> getAxisLocation();

		boolean isPortCollision(final DiagramElement dockedChild, final double relativeLocation);

		Point getNewPortLocation(final DiagramElement dockedChild, final double relativeLocation);

		boolean isShiftable(final DiagramElement de);
	}

	static class HorizontalAlignmentUtil extends AlignmentUtil implements AxisAlignmentUtil {
		public HorizontalAlignmentUtil() {
			super.setAxisAlignmentUtil(this);
		}

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
		public double getParentDiagramRelativeLocation(final AlignmentElement alignmentElement) {
			return alignmentElement.getDiagramRelativeLocation() - alignmentElement.getDiagramElement().getX();
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
		public Point getNewPortLocation(final DiagramElement dockedChild, final double relativeLocation) {
			return new Point(relativeLocation + 1, dockedChild.getY());
		}

		@Override
		public boolean isShiftable(final DiagramElement de) {
			return isValidDockArea.apply(de.getDockArea());
		}

		@Override
		public boolean isPortCollision(final DiagramElement dockedChild, final double relativeLocation) {
			return relativeLocation >= dockedChild.getX()
					&& relativeLocation <= dockedChild.getX() + dockedChild.getWidth();
		}

		public static Function<DockArea, Boolean> isValidDockArea = (dockArea) -> {
			return dockArea == null || dockArea == DockArea.TOP || dockArea == DockArea.BOTTOM;
		};
	}

	static class VerticalAlignmentUtil extends AlignmentUtil implements AxisAlignmentUtil {
		public VerticalAlignmentUtil() {
			super.setAxisAlignmentUtil(this);
		}

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
		public double getParentDiagramRelativeLocation(final AlignmentElement alignmentElement) {
			return alignmentElement.getDiagramRelativeLocation() - alignmentElement.getDiagramElement().getY();
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
		public Point getNewPortLocation(final DiagramElement dockedChild, final double relativeLocation) {
			return new Point(dockedChild.getX(), relativeLocation);
		}

		@Override
		public boolean isShiftable(final DiagramElement de) {
			return isValidDockArea.apply(de.getDockArea());
		}

		@Override
		public boolean isPortCollision(final DiagramElement dockedChild, final double relativeLocation) {
			return relativeLocation >= dockedChild.getY()
					&& relativeLocation <= dockedChild.getY() + dockedChild.getHeight();
		}

		public static Function<DockArea, Boolean> isValidDockArea = (dockArea) -> {
			return dockArea == null || dockArea == DockArea.LEFT || dockArea == DockArea.RIGHT;
		};
	}
}