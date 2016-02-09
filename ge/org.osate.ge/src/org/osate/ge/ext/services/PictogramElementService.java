package org.osate.ge.ext.services;

import java.util.List;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public interface PictogramElementService {
	/**
	 * Returns the business object linked to a pictogram element.
	 * @param pe
	 * @return
	 */
	Object getBusinessObject(PictogramElement pe);
	
	void refreshShapesForBusinessObject(final ContainerShape container, final Object bo);
	void refreshShapesForBusinessObjects(final ContainerShape container, final List<?> bos);
	void refreshConnectionsForBusinessObjects(final ContainerShape ownerShape, final List<?> bos);
}
