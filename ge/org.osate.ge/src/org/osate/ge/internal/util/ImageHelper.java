/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
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