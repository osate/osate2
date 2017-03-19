package org.osate.ge.internal.diagram;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.DiagramElement;
import org.osate.ge.internal.DockArea;

public class AgeDiagramElement implements DiagramElementContainer, ModifiableDiagramElementContainer, DiagramElement {
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
	private AgeDiagramElement connectionStartElement;
	private AgeDiagramElement connectionEndElement;
	private List<Point> bendpoints; // Optional

	public AgeDiagramElement(final DiagramElementContainer container,
			final Object bo, 
			final RelativeBusinessObjectReference boRelReference,
			final CanonicalBusinessObjectReference boCanonicalReference) {
		this.container = Objects.requireNonNull(container, "container must not be null");
		this.bo = Objects.requireNonNull(bo, "bo must not be null");
		this.boRelReference = Objects.requireNonNull(boRelReference, "boRelReference must not be null");
		this.boCanonicalReference = Objects.requireNonNull(boCanonicalReference, "boCanonicalReference must not be null");
	}

	public DiagramElementContainer getContainer() {
		return container;
	}
	
	public ModifiableDiagramElementContainer getModifiableContainer() {
		return (ModifiableDiagramElementContainer)container;
	}
	
	@Override
	public Collection<AgeDiagramElement> getDiagramElements() {
		return Collections.unmodifiableCollection(children);
	}
	
	@Override
	public DiagramElementCollection getModifiableDiagramElements() {
		return children;
	}
	
	@Override
	public AgeDiagramElement getByRelativeReference(final RelativeBusinessObjectReference ref) {
		return children.getByRelativeReference(ref);
	}
	
	public Object getBusinessObject() {
		return bo;
	}
	
	final void setBusinessObject(final Object value) {
		this.bo = Objects.requireNonNull(value, "value must not be null");
	}
	
	public RelativeBusinessObjectReference getRelativeReference() {
		return boRelReference;
	}
	
	public CanonicalBusinessObjectReference getCanonicalReference() {
		return boCanonicalReference;
	}
	
	public Point getPosition() {
		return position;
	}
	
	final void setPosition(final Point value) {
		this.position = value == null ? null : new Point(value);
	}
	
	public Dimension getSize() {
		return size;
	}
	
	final void setSize(final Dimension value) {
		this.size = size == null ? null : new Dimension(value);
	}
	
	public Graphic getGraphic() {
		return graphic;
	}
	
	final void setGraphic(final Graphic value) {
		this.graphic = Objects.requireNonNull(value, "value must not be null");
	}
	
	public DockArea getDockArea() {
		return dockArea;
	}
	
	final void setDockArea(final DockArea value) {
		this.dockArea = value;
	}

	public AgeDiagramElement getStartElement() {
		return connectionStartElement;
	}
	
	final void setStartElement(final AgeDiagramElement value) {
		this.connectionStartElement = value;
	}
	
	public AgeDiagramElement getEndElement() {
		return connectionEndElement;
	}
	
	final void setEndElement(final AgeDiagramElement value) {
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
