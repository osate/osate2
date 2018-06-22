package org.osate.ge.internal.diagram.runtime;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public class ElementUpdatedEvent {
	public final DiagramElement element;
	public final Set<ModifiableField> updatedFields;
	
	public ElementUpdatedEvent(final DiagramElement element, final EnumSet<ModifiableField> updatedFields) {
		this.element = element;
		this.updatedFields = Collections.unmodifiableSet(EnumSet.copyOf(updatedFields));
	}
}