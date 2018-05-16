package org.osate.ge.internal.util;

import org.osate.aadl2.NamedElement;

/**
 * Utility class for performing case insensitive name comparison for named elements.
 *
 */
public class AadlNameUtil {
	// Compares the names of the named element. If either name is null then the result is false.
	// Designed to compare named elements in cases where the instances aren't guaranteed to be the same.
	public static boolean namesAreEqual(final NamedElement ne1, final NamedElement ne2) {
		if (ne1 == null || ne2 == null) {
			return false;
		}

		return namesAreEqual(ne1.getName(), ne2.getName());
	}

	public static boolean namesAreEqual(final String n1, final String n2) {
		if (n1 == null || n2 == null) {
			return false;
		}

		return n1.equalsIgnoreCase(n2);
	}
}
