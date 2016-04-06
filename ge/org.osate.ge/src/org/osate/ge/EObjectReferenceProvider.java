package org.osate.ge;

import org.eclipse.emf.ecore.EObject;

/**
 * Optional interface for providing a reference EObject for a business object.
 * Used in cases where the business object is not of type EObject.
 * When this interface is implemented by a business object, it will be used to navigate to the source declaration and/or package diagram.
 */
public interface EObjectReferenceProvider {
	EObject getEObjectReference();
}
