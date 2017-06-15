package org.osate.ge.internal.ui.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
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
			final ImageDescriptor imgDesc = GraphitiUi.getImageService().getImageDescriptorForId(AgeDiagramTypeProvider.id,
					ImageHelper.getImage(((EObject)bo).eClass().getName()));

			// Check if ImageDescriptor has a valid type.
			final ImageData imageData = imgDesc.getImageData();
			if(imageData != null && imageData.type >= 0) {
				return imgDesc.createImage();
			}
		}
    	
    	return null;
    }
}
