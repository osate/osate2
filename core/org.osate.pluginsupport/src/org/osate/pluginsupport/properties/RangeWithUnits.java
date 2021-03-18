package org.osate.pluginsupport.properties;

import java.util.Optional;

/**
 * @since 7.0
 */
public interface RangeWithUnits<U extends Enum<U> & GeneratedUnits<U>, T extends Scalable<U>> {
	public T getMinimum();

	public T getMaximum();

	public Optional<T> getDelta();
}
