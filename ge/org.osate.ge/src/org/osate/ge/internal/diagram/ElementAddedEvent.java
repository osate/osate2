package org.osate.ge.internal.diagram;

public class ElementAddedEvent {
	public final DiagramElement element;
	
	public ElementAddedEvent(final DiagramElement element) {
		this.element = element;
	}
}