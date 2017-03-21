package org.osate.ge.internal.diagram;

public class ElementRemovedEvent {
	public final AgeDiagramElement element;
	
	public ElementRemovedEvent(final AgeDiagramElement element) {
		this.element = element;
	}
}