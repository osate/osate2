package org.osate.ge.internal.query;

import java.util.function.Predicate;

import org.osate.ge.query.FilterArguments;

public class QueryFilters {
	/**
	 * Prints the business object to the standard error and returns true for all objects 
	 * @param label a label to add to include with the output.
	 * @return true
	 */
	public static <A> Predicate<FilterArguments<A>> boToStdErr(final String label) {
		return (fa) -> {System.err.println("[" + label + "] " + fa.getBusinessObject()); return true;};	
	}
}
