package org.osate.ge.internal.model;

import java.util.Objects;
import java.util.UUID;

public class Note implements EmbeddedBusinessObject {
	private final UUID id;
	private final String text;

	public Note(UUID id) {
		this(id, "");
	}

	public Note(UUID id, final String text) {
		this.id = Objects.requireNonNull(id, "id must not be null");
		this.text = Objects.requireNonNull(text, "text must not be null");
	}

	public UUID getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	@Override
	public Note copy() {
		return new Note(UUID.randomUUID(), text);
	}

	@Override
	public String getData() {
		return getText();
	}
}
