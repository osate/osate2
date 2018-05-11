package org.osate.ge.internal.diagram.runtime;

public class ElementAddedEvent {
	public final DiagramElement element;
	
	public ElementAddedEvent(final DiagramElement element) {
		this.element = element;
	}
}