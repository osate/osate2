package org.osate.ge.internal.diagram.runtime;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.AgeGraphicalConfiguration;
import org.osate.ge.internal.DockArea;
import org.osate.ge.internal.diagram.runtime.boTree.Completeness;
import org.osate.ge.internal.labels.AgeLabelConfiguration;
import org.osate.ge.internal.query.Queryable;

public class DiagramElement implements DiagramNode, ModifiableDiagramElementContainer, BusinessObjectContext {	
	private final DiagramNode container;

	private Object bo;
	private Object boHandler;
	private RelativeBusinessObjectReference boRelReference;
	private boolean manual = false; // Specifies that the element was created as part of a manual process and not from an auto contents filter or other automatic mechanism.
	private ContentsFilter autoContentsFilter;
	private Completeness completeness = Completeness.UNKNOWN;
	private final DiagramElementCollection children = new DiagramElementCollection();
	private String name;
	private AgeGraphicalConfiguration graphicalConfig; // Required after initialization.
	
	// Shape Specific
	private Point position; // Optional. Relative to container.
	private Dimension size; // Optional
	private DockArea dockArea; // Optional
	
	// Connection Specific
	private List<Point> bendpoints; // Optional. Diagram coordinate system.
	private Point connectionPrimaryLabelPosition; // Optional. Position of the connection label.
	
	/**
	 * It is intended that bo and boHandler will not be null except for during the diagram loading process. 
	 * Once the diagram is updated, these fields should be non-null 
	 * @param container
	 * @param bo
	 * @param boHandler
	 * @param boRelReference
	 * @param position
	 */
	public DiagramElement(final DiagramNode container,
			final Object bo, 
			final Object boHandler,
			final RelativeBusinessObjectReference boRelReference,
			final Point position) {
		this.container = Objects.requireNonNull(container, "container must not be null");
		this.bo = bo;
		this.boHandler = boHandler;
		this.boRelReference = Objects.requireNonNull(boRelReference, "boRelReference must not be null");
		this.position = position;
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
	
	public final Object getBusinessObject() {
		return bo;
	}
	
	public final boolean isManual() {
		return manual;
	}
	
	final void setManual(final boolean value) {
		this.manual = value;
	}
	
	public final ContentsFilter getAutoContentsFilter() {
		return autoContentsFilter;
	}
	
	final void setAutoContentsFilter(final ContentsFilter value) {
		this.autoContentsFilter = value;
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
	
	public final RelativeBusinessObjectReference getRelativeReference() {
		return boRelReference;
	}
	
	public final String getName() {
		return name;
	}
	
	final void setName(final String value) {
		this.name = value;
	}
	
	public final boolean hasPosition() {
		return position != null;
	}	
	
	/**
	 * 
	 * @return copy of the element's position or null.
	 */
	public final Point getPosition() {
		return position;
	}
	
	/**
	 * 
	 * @return 0 if the element does not have a position
	 */
	public final int getX() {
		return position == null ? 0 : position.x;
	}
	
	/**
	 * 
	 * @return 0 if the element does not have a position
	 */
	public final int getY() {
		return position == null ? 0 : position.y;
	}
	
	final void setPosition(final Point value) {
		this.position = value;
	}
	
	/**
	 * Intended for internal use by platform specific code in order to update the element's position to reflect the actual position after layout.
	 * Using this method prevents notifications from being sent.
	 * @param x
	 * @param y
	 */
	public final void setPositionInternal(final int x, final int y) {
		this.position = new Point(x, y);
	}
		
	public boolean hasSize() {
		return size != null;
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
	public final int getWidth() {
		return size == null ? 0 : size.width;
	}
	
	/**
	 * 
	 * @return 0 if the element does not have a size
	 */
	public final int getHeight() {
		return size == null ? 0 : size.height;
	}
		
	final void setSize(final Dimension value) {
		this.size = value;
	}
	
	/**
	 * Intended for internal use by platform specific code in order to update the element's size to reflect the actual size after layout.
	 * Using this method prevents notifications from being sent.
	 * @param width
	 * @param height
	 */
	public final void setSizeInternal(final int width, final int height) {
		this.size = new Dimension(width, height);
	}
	
	public final AgeGraphicalConfiguration getGraphicalConfiguration() {
		return graphicalConfig;
	}

	final void setGraphicalConfiguration(final AgeGraphicalConfiguration value) {
		this.graphicalConfig = Objects.requireNonNull(value, "value must not be null");
	}
	
	public final Graphic getGraphic() {
		return graphicalConfig.graphic;
	}
	
	public final Color getDefaultForeground() {
		return graphicalConfig.defaultForeground;
	}

	public final boolean isDecoration() {
		return graphicalConfig.isDecoration;
	}
	
	public final DockArea getDockArea() {
		return dockArea;
	}
	
	final void setDockArea(final DockArea value) {
		this.dockArea = value;
	}

	public final AgeLabelConfiguration getLabelConfiguration() {
		return graphicalConfig.defaultLabelConfiguration;
	}
	
	public final DiagramElement getStartElement() {
		return graphicalConfig.connectionSource;
	}
	
	public final DiagramElement getEndElement() {
		return graphicalConfig.connectionDestination;
	}
	
	/**
	 * Returns an unmodifiable list of the element's bendpoints. The returned list is not guaranteed to be updated to reflect changes.
	 * Bendpoints are specified in diagram coordinates rather than relative to the diagram element.
	 * @return never returns null.
	 */
	public final List<Point> getBendpoints() {
		return bendpoints == null ? Collections.emptyList() : Collections.unmodifiableList(bendpoints);
	}
	
	final void setBendpoints(final List<Point> value) {
		bendpoints = value == null ? null : new ArrayList<>(value);
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
		
		if(children.size() > 0) { 
			children.toString(sb, innerIndention);
		}
		
		sb.append(indention);
		sb.append('}');
		sb.append(System.lineSeparator());
	}
}
