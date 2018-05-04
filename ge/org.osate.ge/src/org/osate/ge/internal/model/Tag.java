package org.osate.ge.internal.model;

import java.util.Objects;

/**
 * Generic business object for use with simple indicator which include an optional values.
 * There must be at most one tag with a particular key for any particular parent business object.
 *
 */
public class Tag {
	public static final String KEY_SUBCOMPONENT_TYPE = "sc_type";
	public static final String KEY_SUBPROGRAM_CALL_CALLED_SUBPROGRAM = "spc_csp";
	public static final String KEY_UNIDIRECTIONAL = "unidirectional"; // A tagged value of this type indicates that the connection is a unidirectional connection
	public static final String KEY_MODE_TRANSITION_TRIGGERS = "mtt";

	public final String key;
	public final Object value;

	/**
	 *
	 * @param key
	 * @param value is optional
	 */
	public Tag(final String key, final Object value) {
		this.key = Objects.requireNonNull(key, "key must not be null");
		this.value = value;
	}
}
