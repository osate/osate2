package org.osate.ge.internal.diagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.DockArea;
import org.osate.ge.internal.labels.AgeLabelConfiguration;
import org.osate.ge.internal.query.Queryable;

public class DiagramElement implements DiagramNode, ModifiableDiagramElementContainer, BusinessObjectContext {	
	private final DiagramNode container;

	private Object bo;
	private final Object boHandler;
	private final RelativeBusinessObjectReference boRelReference;
	private final CanonicalBusinessObjectReference boCanonicalReference; // Use to determine whether two elements refer to the same business object.
	private final DiagramElementCollection children = new DiagramElementCollection();
	private final String name;
	private Graphic graphic; // Required after initialization.
	
	// Shape Specific
	private Point position; // Optional. Relative to container.
	private Dimension size; // Optional
	private DockArea dockArea; // Optional
	private AgeLabelConfiguration labelConfiguration;
	
	// Connection Specific
	private DiagramElement connectionStartElement;
	private DiagramElement connectionEndElement;
	private List<Point> bendpoints; // Optional. Diagram coordinate system.
	
	public DiagramElement(final DiagramNode container,
			final Object bo, 
			final Object boHandler,
			final RelativeBusinessObjectReference boRelReference,
			final CanonicalBusinessObjectReference boCanonicalReference,
			final String name,
			final Point position) {
		this.container = Objects.requireNonNull(container, "container must not be null");
		this.bo = Objects.requireNonNull(bo, "bo must not be null");
		this.boHandler = Objects.requireNonNull(boHandler, "boHandler must not be null");
		this.boRelReference = Objects.requireNonNull(boRelReference, "boRelReference must not be null");
		this.boCanonicalReference = Objects.requireNonNull(boCanonicalReference, "boCanonicalReference must not be null");
		this.name = name;
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
	
	public final Object getBusinessObjectHandler() {
		return boHandler;
	}
	
	final void setBusinessObject(final Object value) {
		this.bo = Objects.requireNonNull(value, "value must not be null");
	}
	
	public final RelativeBusinessObjectReference getRelativeReference() {
		return boRelReference;
	}
	
	public final CanonicalBusinessObjectReference getCanonicalReference() {
		return boCanonicalReference;
	}
	
	public final String getName() {
		return name;
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
	
	public final Graphic getGraphic() {
		return graphic;
	}
	
	final void setGraphic(final Graphic value) {
		this.graphic = Objects.requireNonNull(value, "value must not be null");
	}
	
	public final DockArea getDockArea() {
		return dockArea;
	}
	
	final void setDockArea(final DockArea value) {
		this.dockArea = value;
	}

	public final AgeLabelConfiguration getLabelConfiguration() {
		return labelConfiguration;
	}
	
	final void setLabelConfiguration(final AgeLabelConfiguration value) {
		this.labelConfiguration = value;
	}

	public final DiagramElement getStartElement() {
		return connectionStartElement;
	}
	
	final void setStartElement(final DiagramElement value) {
		this.connectionStartElement = value;
	}
	
	public final DiagramElement getEndElement() {
		return connectionEndElement;
	}
	
	final void setEndElement(final DiagramElement value) {
		this.connectionEndElement = value;
	}
	
	/**
	 * Returns an unmodifiable list of the element's bendpoints. The returned list is not guaranteed to be updated to reflect changes.
	 * Bendpoints are specified in diagram coordinates rather than relative to the diagram element.
	 * @return never returns null.
	 */
	public final List<Point> getBendpoints() {
		return bendpoints == null ? Collections.emptyList() : Collections.unmodifiableList(bendpoints);
	}
	
	public final void setBendpoints(final List<Point> value) {
		bendpoints = value == null ? null : new ArrayList<>(value);
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
		sb.append("canonical reference: ");
		sb.append(boCanonicalReference);
		sb.append(System.lineSeparator());
		
		sb.append(innerIndention);
		sb.append("graphic: ");
		sb.append(graphic);
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
		
		if(connectionStartElement != null) {
			sb.append(innerIndention);
			sb.append("connection start: ");
			sb.append(connectionStartElement.getCanonicalReference());
			sb.append(System.lineSeparator());
		}
		
		if(connectionEndElement != null) {
			sb.append(innerIndention);
			sb.append("connection end: ");
			sb.append(connectionEndElement.getCanonicalReference());
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
