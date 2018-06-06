package org.osate.ge.internal.diagram.runtime;

import java.util.Objects;

public class BeforeModificationsCompletedEvent {
	public final AgeDiagram diagram;
	public final DiagramModification mod;

	public BeforeModificationsCompletedEvent(final AgeDiagram diagram, final DiagramModification mod) {
		this.diagram = Objects.requireNonNull(diagram, "diagram must not be null");
		this.mod = Objects.requireNonNull(mod, "mod must not be null");
	}
}