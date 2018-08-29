/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.graphiti;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.graphiti.ui.platform.AbstractImageProvider;
import org.eclipse.graphiti.ui.platform.IImageProvider;

public class AgeImageProvider extends AbstractImageProvider implements
		IImageProvider {
	private static final String IMAGES_EXTENSION_POINT_ID = "org.osate.ge.images";

	@Override
	protected void addAvailableImages() {
		final IExtensionRegistry registry = Platform.getExtensionRegistry();
		final IExtensionPoint point = registry.getExtensionPoint(IMAGES_EXTENSION_POINT_ID);
		if(point != null) {
			for(final IExtension extension : point.getExtensions()) {
				for(final IConfigurationElement ce : extension.getConfigurationElements()) {
					final String imageId = ce.getAttribute("id");
					String imagePlugin = ce.getAttribute("plugin");
					if(imagePlugin == null) {
						imagePlugin = extension.getContributor().getName();
					}

					final String imagePath = ce.getAttribute("path");
					final URI imageUri = getCompleteImagePath(imagePlugin, imagePath);
					if(CommonPlugin.asLocalURI(imageUri).isFile()) {
						addImageFilePath(imageId, imageUri.toString());
					}
				}
			}
		}
	}

	private static URI getCompleteImagePath(final String imagePlugin, final String imagePath) {
		return URI.createPlatformPluginURI("/" + imagePlugin + "/" + imagePath, true);
	}
}
