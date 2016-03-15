package org.osate.ge.internal.services;

import org.osate.aadl2.AadlPackage;

/**
 * Service for referencing business objects using a string value.
 *
 */
public interface SerializableReferenceService {
	String getReference(final Object bo);
	
	/**
	 * AADL elements will be wrapped with an AadlElementWrapper object
	 * @param reference
	 * @return
	 */
	Object getReferencedObject(final String reference);
	
	AadlPackage getAadlPackage(final String qualifiedName);
}
