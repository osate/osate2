package edu.uah.rsesc.aadl.age.services;

import org.osate.aadl2.Namespace;

public interface NamingService {
	/**
	 * Builds an identifier using the specified base that doesn't conflict with identifiers in the specified namespace
	 * @param namespace
	 * @param baseIdentifier
	 * @return an identifier that is unique in the specified namespace
	 */
	String buildUniqueIdentifier(Namespace namespace, String baseIdentifier);
	
	/**
	 * Determines whether a specified string is a valid AADL identifier
	 * @param value
	 * @return
	 */
	boolean isValidIdentifier(final String value);
	
	/**
	 * Returns whether an element with a specified name exists
	 * @param namespace
	 * @param name
	 * @return
	 */
	boolean isNameInUse(final Namespace namespace, final String name);
}
