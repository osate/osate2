/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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
