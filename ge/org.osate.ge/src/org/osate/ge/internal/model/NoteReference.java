package org.osate.ge.internal.model;

import java.util.UUID;

public class NoteReference implements EmbeddedBusinessObject {
	private final UUID referencedId; // The diagram element that is referenced by the note reference.

	public NoteReference(UUID referencedId) {
		this.referencedId = referencedId;
	}

	public UUID getReferencedDiagramElementId() {
		return referencedId;
	}

	@Override
	public NoteReference copy() {
		return new NoteReference(referencedId);
	}
}
