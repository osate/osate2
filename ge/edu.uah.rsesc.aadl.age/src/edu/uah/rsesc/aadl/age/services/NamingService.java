package edu.uah.rsesc.aadl.age.services;

import org.osate.aadl2.NamedElement;
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
	boolean isValidIdentifier(String value);
	
	/**
	 * Returns whether an element with a specified name exists
	 * @param namespace
	 * @param name
	 * @return
	 */
	boolean isNameInUse(Namespace namespace, String name);
	
	/**
	 * Helper function for checking if a name is valid for a specified named element. Essentially a generic implementation of checkValueValid.
	 * @param ne
	 * @param name
	 * @return null is the name is valid. Otherwise a text string explaining why it is not.
	 */
	String checkNameValidity(NamedElement ne, String name);
}
