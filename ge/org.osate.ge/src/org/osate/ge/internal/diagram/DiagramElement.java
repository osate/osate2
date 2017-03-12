package org.osate.ge.internal.diagram;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.DockArea;

public class DiagramElement implements DiagramElementContainer {
	private final DiagramElementContainer container;

	private Object bo;
	private final RelativeBusinessObjectReference boRelReference;
	private final CanonicalBusinessObjectReference boCanonicalReference;
	private final DiagramElementCollection children = new DiagramElementCollection();
	private Graphic graphic; // Required after initialization.
	
	// Shape Specific
	private Point position; // Optional. Relative to container.
	private Dimension size; // Optional
	private DockArea dockArea; // Optional
	
	// Connection Specific
	private DiagramElement connectionStartElement;
	private DiagramElement connectionEndElement;
	private List<Point> bendpoints; // Optional

	public DiagramElement(final DiagramElementContainer container,
			final Object bo, 
			final RelativeBusinessObjectReference boRelReference,
			final CanonicalBusinessObjectReference boCanonicalReference) {
		this.container = Objects.requireNonNull(container, "container must not be null");
		this.bo = Objects.requireNonNull(bo, "bo must not be null");
		this.boRelReference = Objects.requireNonNull(boRelReference, "boRelReference must not be null");
		this.boCanonicalReference = Objects.requireNonNull(boCanonicalReference, "boCanonicalReference must not be null");
		
		// TODO: Think about this. It may be beneficial to allow the updater to manually add elements to the collection to prevent premature otificatons.
		// Add the element to the container
		container.getDiagramElements().add(this);
	}

	public DiagramElementContainer getContainer() {
		return container;
	}
	
	@Override
	public DiagramElementCollection getDiagramElements() {
		return children;
	}	
	
	public Object getBusinessObject() {
		return bo;
	}
	
	void setBusinessObject(final Object value) {
		this.bo = Objects.requireNonNull(value, "value must not be null");
	}
	
	public RelativeBusinessObjectReference getRelativeReference() {
		return boRelReference;
	}
	
	public CanonicalBusinessObjectReference getCanonicalReference() {
		return boCanonicalReference;
	}
	
	public void setPosition(final Point value) {
		this.position = value == null ? null : new Point(value);
	}
	
	public Point getPosition() {
		return position;
	}
	
	public Graphic getGraphic() {
		return graphic;
	}
	
	void setGraphic(final Graphic value) {
		this.graphic = Objects.requireNonNull(value, "value must not be null");
	}

	public DiagramElement getStartElement() {
		return connectionStartElement;
	}
	
	void setStartElement(final DiagramElement value) {
		this.connectionStartElement = value;
	}
	
	public DiagramElement getEndElement() {
		return connectionEndElement;
	}
	
	void setEndElement(final DiagramElement value) {
		this.connectionEndElement = value;
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
