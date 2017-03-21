package org.osate.ge.internal.diagram;

public class ModificationsCompletedEvent {
	public final AgeDiagram diagram;
	
	public ModificationsCompletedEvent(final AgeDiagram diagram) {
		this.diagram = diagram;
	}
}