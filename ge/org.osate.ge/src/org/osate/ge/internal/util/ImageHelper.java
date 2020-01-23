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
package org.osate.ge.internal.util;

import java.net.MalformedURLException;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.osate.ge.internal.graphiti.AgeDiagramTypeProvider;

public class ImageHelper {
	protected static final String PREFIX = "org.osate.ge.";
	/**
	 * Returns the full image id of an image registered by the org.osate.ge plugin.
	 */
	public static String getImage(final String imageId) {
		return PREFIX + imageId;
	}

	public static String getImage(final EClass eClass) {
		return getImage(eClass.getName());
	}

	public static Image findImage(final IPath imagePath) {
		final ImageDescriptor imageDesc = getImageDescriptor(imagePath);
		if (imageDesc == null) {
			return null;
		}

		final Object image = AgeDiagramTypeProvider.getResources().find(imageDesc);
		return image instanceof Image ? (Image) image : null;
	}

	// Create image descriptor
	private static ImageDescriptor getImageDescriptor(final IPath imagePath) {
		try {
			final IResource imageResource = ResourcesPlugin.getWorkspace().getRoot().findMember(imagePath);
			return imageResource == null ? null
					: ImageDescriptor.createFromURL(imageResource.getRawLocationURI().toURL());
		} catch (final MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
}