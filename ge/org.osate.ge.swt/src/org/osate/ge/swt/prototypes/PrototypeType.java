package org.osate.ge.swt.prototypes;

import java.util.Objects;

/**
 * Enumeration of types of prototype. Concatenation of the various types of component classifiers with a feature and feature group
 *
 */
public enum PrototypeType {
	//@formatter:off
	ABSTRACT("Abstract"),
	BUS("Bus"),
	DATA("Data"),
	DEVICE("Device"),
	MEMORY("Memory"),
	PROCESSOR("Processor"),
	PROCESS("Process"),
	SUBPROGRAM_GROUP("Subprogram Group"),
	SUBPROGRAM("Subprogram"),
	SYSTEM("System"),
	THREAD_GROUP("Thread Group"),
	THREAD("Thread"),
	VIRTUAL_BUS("Virtual Bus"),
	VIRTUAL_PROCESSOR("Virtual Processor"),
	FEATURE("Feature"),
	FEATURE_GROUP("Feature Group");
	//@formatter:on

	private final String label;

	PrototypeType(final String label) {
		this.label = Objects.requireNonNull(label);
	}

	@Override
	public String toString() {
		return label;
	}

	public boolean isComponent() {
		return this != FEATURE && this != FEATURE_GROUP;
	}
}
