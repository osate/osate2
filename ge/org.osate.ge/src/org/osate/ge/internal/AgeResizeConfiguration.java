package org.osate.ge.internal;

/**
 * An interface similar to the Graphiti ResizeConfiguration interface that provides information regarding whether there is a minimum size for a particular type of shape.
 * This interface should be implemented by the resize configuration returned by resize shape features and patterns in order to define a minimum size.
 * Used by the layout algorithm to determine the minimum size of a shape. 
 *
 */
public interface AgeResizeConfiguration {
	boolean hasMinimumSize();
	int getMinimumWidth();
	int getMinimumHeight();
}
