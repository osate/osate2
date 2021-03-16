package org.osate.pluginsupport.properties;

import java.util.Optional;
import java.util.function.Function;

import org.osate.aadl2.NamedElement;

/**
 * @since 7.0
 */
public final class PropertyUtils {
	private PropertyUtils() {
		// Utility class
	}

	public static final <V> boolean propertyEquals(final Function<NamedElement, Optional<V>> f, final NamedElement ne,
			final V value) {
		return f.apply(ne).map(x -> x == value).orElse(false);
	}
}
