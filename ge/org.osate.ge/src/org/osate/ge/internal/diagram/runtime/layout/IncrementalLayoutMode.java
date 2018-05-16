package org.osate.ge.internal.diagram.runtime.layout;

import java.util.Optional;

public enum IncrementalLayoutMode {
	LAYOUT_DIAGRAM("org.osate.ge.layout.incremental.mode.diagram"), LAYOUT_CONTAINER(
			"org.osate.ge.layout.incremental.mode.container"), LAYOUT_CONTENTS(
					"org.osate.ge.layout.incremental.mode.contents");

	public final String id;

	IncrementalLayoutMode(final String id) {
		this.id = id;
	}

	public static Optional<IncrementalLayoutMode> getById(final String id) {
		for (final IncrementalLayoutMode mode : IncrementalLayoutMode.values()) {
			if (mode.id.equals(id)) {
				return Optional.of(mode);
			}
		}

		return Optional.empty();
	}
}