package org.osate.ge.internal.diagram.runtime;

public class ElementRemovedEvent {
	public final DiagramElement element;
	
	public ElementRemovedEvent(final DiagramElement element) {
		this.element = element;
	}
}