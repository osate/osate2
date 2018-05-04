package org.osate.ge.internal.services.impl;

import java.util.Objects;

public enum DeclarativeReferenceType {
	// @formatter:off
	PROJECT_OVERVIEW("project_overview"),
	PACKAGE("package"),
	CLASSIFIER("classifier"),
	SUBCOMPONENT("subcomponent"),
	REALIZATION("realization"),
	TYPE_EXTENSION("type_extension"),
	IMPLEMENTATION_EXTENSION("implementation_extension"),
	GROUP_EXTENSION("group_extension"),
	FEATURE("feature"),
	INTERNAL_FEATURE("internal_feature"),
	PROCESSOR_FEATURE("processor_feature"),
	FLOW_SPECIFICATION("flow_specification"),
	CONNECTION("connection"),
	MODE("mode"),
	MODE_TRANSITION_UNNAMED("mode_transition"),
	MODE_TRANSITION_NAMED("mt"),
	MODE_TRANSITION_TRIGGER("mtt"),
	SUBPROGRAM_CALL_SEQUENCE("subprogram_call_sequence"),
	SUBPROGRAM_CALL("subprogram_call"),
	SUBPROGRAM_CALL_ORDER("subprogram_call_order"),
	ANNEX_LIBRARY("annex_library"),
	ANNEX_SUBCLAUSE("annex_subclause");
	// @formatter:on

	private String id;

	DeclarativeReferenceType(final String id) {
		this.id = Objects.requireNonNull(id, "tag must not be null");
	}

	/**
	 * Returned id is lower case.
	 */
	public final String getId() {
		return id;
	}

	/**
	 * Case sensitive. Returns whether a specified value matches the id of one of the elements of the enumeration.
	 * @param value
	 * @return
	 */
	public static boolean isId(final String value) {
		for (final DeclarativeReferenceType type : DeclarativeReferenceType.values()) {
			if (type.getId().equals(value)) {
				return true;
			}
		}

		return false;
	}
}
