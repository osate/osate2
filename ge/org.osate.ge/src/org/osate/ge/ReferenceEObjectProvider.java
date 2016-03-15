package org.osate.ge;

import org.eclipse.emf.ecore.EObject;

/**
 * Optional interface for providing a EObject for referencing a business object which of not of type EObject.
 * When this interface is implemented by a business object, it will be used to navigate to the source declaration.
 */
public interface ReferenceEObjectProvider {
	EObject getRefereneEObject();
}
