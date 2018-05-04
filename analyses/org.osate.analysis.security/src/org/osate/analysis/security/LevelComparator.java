/* Created on Jul 11, 2005
 */
package org.osate.analysis.security;

public interface LevelComparator {
	/**
	 * Return <code>true</code> if the level of the source component is
	 * compatible with the level of the destintation component. (A
	 * <code>false</code> return value indicates an error.)
	 * 
	 * @param sourceLevel
	 *            The level of the source component of the connection
	 * @param destLevel
	 *            The level of the destintation component of the connection
	 */
	boolean compareLevels(long sourceLevel, long destLevel);
}
