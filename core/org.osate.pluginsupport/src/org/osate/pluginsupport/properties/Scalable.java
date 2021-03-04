package org.osate.pluginsupport.properties;

/**
 * @since 6.1
 */
public interface Scalable<U extends Enum<U> & GeneratedUnits<U>> {
	public double getValue(U targetUnit);
}
