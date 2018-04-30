package org.osate.ge.internal.ui.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.osate.ge.internal.graphiti.AgeDiagramTypeProvider;
import org.osate.ge.internal.model.BusinessObjectProxy;
import org.osate.ge.internal.util.ImageHelper;

public class ImageUiHelper {
	/**
	 * Returns an image for the specified business object. The image must not be disposed by the caller.
	 * @param bo
	 * @return
	 */
	public static Image getImage(final Object bo) {
		final EClass eClass;
		if (bo instanceof EObject) {
			eClass = ((EObject) bo).eClass();
		} else if (bo instanceof BusinessObjectProxy) {
			eClass = ((BusinessObjectProxy) bo).getEClass();
		} else {
			eClass = null;
		}

		final String imageId = eClass == null ? null : ImageHelper.getImage(eClass.getName());

		if (imageId == null) {
			return null;
		}

		final Image img = GraphitiUi.getImageService().getImageForId(AgeDiagramTypeProvider.id, imageId);
		if(img == null) {
			return null;
		}

		final ImageData imageData = img.getImageData();
		if(imageData == null) {
			return null;
		}

		// If the icon is below a certain size, assume it is the default icon that is used when the image can't be loaded and ignore it.
		if(imageData.width < 10) {
			return null;
		}

		return img;
	}
}
