package org.osate.ge.services;

/**
 * Service for referencing business objects using a string value.
 * @author philip.alldredge
 *
 */
public interface SerializableReferenceService {
	String getReference(final Object bo);
	Object getReferencedObject(final String reference);
}
