package org.osate.ge.services;

/**
 * Service for referencing business objects using a string value.
 * @author philip.alldredge
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
}
