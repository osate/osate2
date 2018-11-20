package org.osate.ge;

/**
 * A configurable content filters is one whose enablement can be toggled by the user. Must be stateless.
 * This interface does not have Configurable in the name because it predates the concept of fundamental content filters.
 *
 */
public interface ContentFilter {
	String getId();

	/**
	 * Optional. If the method does not return null, it must return the id of the content filter of which this content filter represents a part.
	 * Enabling all parts of a filter must be equivalent to enabling the filter itself.
	 * @return
	 */
	default String getParentId() {
		return null;
	}

	String getName();

	boolean isApplicable(Object bo);

	boolean test(Object bo);
}
