package org.osate.ge.internal.services;

import org.osate.ge.internal.DiagramElement;

public interface AadlPropertyService {
	// TODO: Rename
	static interface PropertyResult {
		// Collection<PropertyAssociation> getUsedPropertyAssociations();
		// Object getValue();		
	}
	
	// TODO: Rename. Shouldn't be part of AadlPropertyService either?
	//static interface Reference {
		/**
		 * Gets an array that contains a path from the root of the diagram to the referenced object. Each element of the array is a business object.
		 * @return
		 */
		//Object[] getAbsolutePath(); // Path of business objects.
	//}
	
	
	// TODO: Need a way to build a reference from a diagram element?
	
	PropertyResult getValue(final DiagramElement diagramElement, final String propertySetName, final String propertyName);
}
