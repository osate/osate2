package org.osate.ge.swt.prototypes;

import java.util.Objects;

/**
 * Enumeration for valid prototype feature directions
 *
 */
public enum PrototypeDirection {
	//@formatter:off
	INPUT("Input"),
	OUTPUT("Output"),
	UNSPECIFIED("Unspecified");
	//@formatter:on

	private final String label;

	PrototypeDirection(final String label) {
		this.label = Objects.requireNonNull(label);
	}

	@Override
	public String toString() {
		return label;
	}
}
