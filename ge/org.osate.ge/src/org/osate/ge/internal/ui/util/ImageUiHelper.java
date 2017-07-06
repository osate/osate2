package org.osate.ge.internal.ui.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.swt.graphics.Image;
import org.osate.ge.internal.graphiti.AgeDiagramTypeProvider;
import org.osate.ge.internal.util.ImageHelper;

public class ImageUiHelper {
	/**
	 * Returns an image for the specified business object. The image must not be disposed by the caller.
	 * @param bo
	 * @return
	 */
    public static Image getImage(final Object bo) {
    	if(bo instanceof EObject) {
			return GraphitiUi.getImageService().getImageForId(AgeDiagramTypeProvider.id, ImageHelper.getImage(((EObject)bo).eClass().getName()));
		}
    	
    	return null;
    }
}
