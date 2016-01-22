package org.osate.ge.ext.services;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public interface BusinessObjectService {
	/**
	 * Returns the business object linked to a pictogram element.
	 * @param pe
	 * @return
	 */
	Object getBusinessObject(PictogramElement pe);
	
	// TODO: Remove of not needed
	/**
	 * Links a pictogram element with a business object
	 * @param pe
	 * @param bo
	 */
	//void link(PictogramElement pe, Object bo);
}
