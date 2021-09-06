package org.osate.pluginsupport.properties;

/**
 * @since 7.0
 */
public interface Scalable<U extends Enum<U> & GeneratedUnits<U>> {
	public double getValue(U targetUnit);
}
