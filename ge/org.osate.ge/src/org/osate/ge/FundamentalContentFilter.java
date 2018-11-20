package org.osate.ge;

/**
 * A fundamental content filter is a content filter which is always enabled.
 *
 */
public interface FundamentalContentFilter {
	boolean test(Object bo);
}
