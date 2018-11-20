package org.osate.ge.internal.diagram.runtime;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.ContentFilter;
import org.osate.ge.graphics.Dimension;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Point;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.internal.AgeGraphicalConfiguration;
import org.osate.ge.internal.diagram.runtime.boTree.Completeness;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.query.RelativeReferenceProvider;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

public class DiagramElement
implements DiagramNode, ModifiableDiagramElementContainer, BusinessObjectContext, RelativeReferenceProvider {
	private final DiagramNode container;

	private final UUID id; // Identifier for the diagram element. Unique within a diagram.
	private Object bo;
	private Object boHandler;
	private RelativeBusinessObjectReference boRelReference;
	private boolean manual = false; // Specifies that the element was created as part of a manual process and not from an auto contents filter or other automatic mechanism.
	private ImmutableSet<ContentFilter> contentFilters = ImmutableSet.of();
	private Completeness completeness = Completeness.UNKNOWN;
	private final DiagramElementCollection children = new DiagramElementCollection();
	private String labelName;
	private String uiName;
	private AgeGraphicalConfiguration graphicalConfig; // Required after initialization.
	private Style style = Style.EMPTY; // Will never be null

	// Shape Specific
	private Point position; // Optional. Relative to container.
	private Dimension size; // Optional
	private DockArea dockArea; // Optional

	// Connection Specific
	private ImmutableList<Point> bendpoints; // Optional. Diagram coordinate system. A null value indicates that the bendpoints have not been configured.
	private Point connectionPrimaryLabelPosition; // Optional. Position of the connection label. Relative to the midpoint of the connection.

	/**
	 * It is intended that bo and boHandler will not be null except for during the diagram loading process.
	 * Once the diagram is updated, these fields should be non-null
	 * @param container
	 * @param bo
	 * @param boHandler
	 * @param boRelReference
	 */
	public DiagramElement(final DiagramNode container,
			final Object bo,
			final Object boHandler,
			final RelativeBusinessObjectReference boRelReference,
			final UUID id) {
		this.container = container;
		this.bo = bo;
		this.boHandler = boHandler;
		this.boRelReference = Objects.requireNonNull(boRelReference, "boRelReference must not be null");
		this.id = Objects.requireNonNull(id, "id must not be null");
	}

	@Override
	public final DiagramNode getContainer() {
		return container;
	}

	public final ModifiableDiagramElementContainer getModifiableContainer() {
		return (ModifiableDiagramElementContainer)container;
	}

	@Override
	public final Collection<DiagramElement> getDiagramElements() {
		return Collections.unmodifiableCollection(children);
	}

	@Override
	public final Collection<Queryable> getChildren() {
		return Collections.unmodifiableCollection(children);
	}

	@Override
	public final DiagramElementCollection getModifiableDiagramElements() {
		return children;
	}

	@Override
	public final DiagramElement getByRelativeReference(final RelativeBusinessObjectReference ref) {
		return children.getByRelativeReference(ref);
	}

	public final UUID getId() {
		return id;
	}

	@Override
	public final Object getBusinessObject() {
		return bo;
	}

	public final boolean isManual() {
		return manual;
	}

	final void setManual(final boolean value) {
		this.manual = value;
	}

	/**
	 * @return will never be null.
	 */
	public final ImmutableSet<ContentFilter> getContentFilters() {
		return contentFilters;
	}

	final void setContentFilters(final ImmutableSet<ContentFilter> value) {
		this.contentFilters = Objects.requireNonNull(value, "value must not be null");
	}

	public final Completeness getCompleteness() {
		return completeness;
	}

	final void setCompleteness(final Completeness value) {
		this.completeness = Objects.requireNonNull(value, "value must not be null");
	}

	public final Object getBusinessObjectHandler() {
		return boHandler;
	}

	final void setBusinessObject(final Object value) {
		this.bo = Objects.requireNonNull(value, "value must not be null");
	}

	final void setRelativeReference(final RelativeBusinessObjectReference value) {
		this.boRelReference = Objects.requireNonNull(value, "value must not be null");
	}

	public final void setBusinessObjectHandler(final Object value) {
		this.boHandler = value;
	}

	@Override
	public final RelativeBusinessObjectReference getRelativeReference() {
		return boRelReference;
	}

	public final String getLabelName() {
		return labelName;
	}

	final void setLabelName(final String value) {
		this.labelName = value;
	}

	public final String getUserInterfaceName() {
		return uiName;
	}

	final void setUserInterfaceName(final String value) {
		this.uiName = value;
	}

	public final boolean hasPosition() {
		return position != null;
	}

	/**
	 *
	 * @return the element's position or null.
	 */
	public final Point getPosition() {
		return position;
	}

	/**
	 *
	 * @return 0 if the element does not have a position
	 */
	public final double getX() {
		return position == null ? 0 : position.x;
	}

	/**
	 *
	 * @return 0 if the element does not have a position
	 */
	public final double getY() {
		return position == null ? 0 : position.y;
	}

	final void setPosition(final Point value) {
		this.position = value;
	}

	public boolean hasSize() {
		return size != null;
	}

	public final Style getStyle() {
		return style;
	}

	public final void setStyle(final Style value) {
		this.style = Objects.requireNonNull(value, "value must not be null");
	}

	/**
	 *
	 * @return copy of the element's size or null.
	 */
	public final Dimension getSize() {
		return size;
	}

	/**
	 *
	 * @return 0 if the element does not have a size
	 */
	public final double getWidth() {
		return size == null ? 0 : size.width;
	}

	/**
	 *
	 * @return 0 if the element does not have a size
	 */
	public final double getHeight() {
		return size == null ? 0 : size.height;
	}

	final void setSize(final Dimension value) {
		this.size = value;
	}

	public final AgeGraphicalConfiguration getGraphicalConfiguration() {
		return graphicalConfig;
	}

	final void setGraphicalConfiguration(final AgeGraphicalConfiguration value) {
		this.graphicalConfig = value;
	}

	public final Graphic getGraphic() {
		return graphicalConfig == null ? null : graphicalConfig.graphic;
	}

	public final boolean isDecoration() {
		return graphicalConfig != null && graphicalConfig.isDecoration;
	}

	public final DockArea getDockArea() {
		return dockArea;
	}

	final void setDockArea(final DockArea value) {
		this.dockArea = value;
	}

	public final DiagramElement getStartElement() {
		return graphicalConfig.connectionSource;
	}

	public final DiagramElement getEndElement() {
		return graphicalConfig.connectionDestination;
	}

	/**
	 * Returns true if the diagram element's bendpoints have been set. Will return true when there are no bendpoints if the bendpoints have been set to an empty list.
	 * @return
	 */
	public final boolean isBendpointsSet() {
		return bendpoints != null;
	}

	/**
	 * Returns an immutable list of the element's bendpoints. The returned list is not guaranteed to be updated to reflect changes.
	 * Bendpoints are specified in diagram coordinates rather than relative to the diagram element.
	 * @return never returns null.
	 */
	public final List<Point> getBendpoints() {
		return bendpoints == null ? Collections.emptyList() : bendpoints;
	}

	/**
	 * Bendpoints is set to null instead of an empty list so that it can be determined if the bendpoints have been set. To indicate that the diagram element
	 * does not have any bendpoints, an empty value should be set.
	 * @param value
	 */
	final void setBendpoints(final List<Point> value) {
		bendpoints = value == null ? null : ImmutableList.copyOf(value);
	}

	/**
	 *
	 * @return will return null if the position has not been set.
	 */
	public final Point getConnectionPrimaryLabelPosition() {
		return connectionPrimaryLabelPosition;
	}

	final void setConnectionPrimaryLabelPosition(final Point value) {
		this.connectionPrimaryLabelPosition = value;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		toString(sb, "");
		return sb.toString();
	}

	void toString(final StringBuilder sb, final String indention) {
		sb.append(indention);
		sb.append('{');
		sb.append(System.lineSeparator());

		final String innerIndention = indention + '\t';
		sb.append(innerIndention);
		sb.append("relative reference: ");
		sb.append(boRelReference);
		sb.append(System.lineSeparator());

		sb.append(innerIndention);
		sb.append("id: ");
		sb.append(id);
		sb.append(System.lineSeparator());

		sb.append(innerIndention);
		sb.append("graphicalConfig: ");
		sb.append(graphicalConfig);
		sb.append(System.lineSeparator());

		if(position != null) {
			sb.append(innerIndention);
			sb.append("position: ");
			sb.append(position);
			sb.append(System.lineSeparator());
		}

		if(size != null) {
			sb.append(innerIndention);
			sb.append("size: ");
			sb.append(size);
			sb.append(System.lineSeparator());
		}

		if(dockArea != null) {
			sb.append(innerIndention);
			sb.append("dock area: ");
			sb.append(dockArea);
			sb.append(System.lineSeparator());
		}

		if(bendpoints != null) {
			sb.append(innerIndention);
			sb.append("bendpoints: ");
			sb.append(Arrays.toString(bendpoints.toArray(new Point[bendpoints.size()])));
			sb.append(System.lineSeparator());
		}

		if (style != null) {
			sb.append(innerIndention);
			sb.append("style: ");
			sb.append(style);
			sb.append(System.lineSeparator());
		}

		if(children.size() > 0) {
			children.toString(sb, innerIndention);
		}

		sb.append(indention);
		sb.append('}');
		sb.append(System.lineSeparator());
	}
}
