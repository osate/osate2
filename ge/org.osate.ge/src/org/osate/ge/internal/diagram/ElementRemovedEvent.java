package org.osate.ge.internal.diagram;

public class ElementRemovedEvent {
	public final DiagramElement element;
	
	public ElementRemovedEvent(final DiagramElement element) {
		this.element = element;
	}
}