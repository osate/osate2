package org.osate.ge.internal.model;

import java.util.Objects;

/**
 * Generic business object for use with simple values that don't have an EMF object. Designed mostly for objects which are not editable.
 *
 */
public class TaggedValue {
	public static final String KEY_SUBCOMPONENT_TYPE = "sc_type";
	public static final String KEY_SUBPROGRAM_CALL_CALLED_SUBPROGRAM = "spc_csp";
	public static final String KEY_CONNECTION_DIRECTION = "connection_direction";
	
	public final String key;
	public final String value;
	
	public TaggedValue(final String key, final String value) {
		this.key = Objects.requireNonNull(key, "key must not be null");
		this.value = Objects.requireNonNull(value, "value must not be null");
	}
}
