package org.osate.ge;

import org.eclipse.emf.ecore.EObject;

/**
 * Optional interface for providing the EObject which owns a business object.
 * Used in cases where the business object is not of type EObject.
 * When this interface is implemented by a business object, it will be used to allow deletion of the EObject.
 */
public interface EObjectOwnerProvider {
	EObject getEObjectOwner();
}
