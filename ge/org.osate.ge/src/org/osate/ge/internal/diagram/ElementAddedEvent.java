package org.osate.ge.internal.diagram;

public class ElementAddedEvent {
	public final AgeDiagramElement element;
	
	public ElementAddedEvent(final AgeDiagramElement element) {
		this.element = element;
	}
}