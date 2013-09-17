package edu.uah.rsesc.aadl.age.diagrams.common.mapping;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public interface BusinessObjectResolver {
	/**
	 * Returns the business object linked to a pictogram element. Also responsible for "unwrapping" any objects.
	 * @param pe
	 * @return
	 */
	Object getBusinessObjectForPictogramElement(final PictogramElement pe);
}
