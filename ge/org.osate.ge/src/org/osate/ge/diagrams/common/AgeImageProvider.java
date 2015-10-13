package org.osate.ge.diagrams.common;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
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
					final String imagePlugin = ce.getAttribute("plugin");
					final String imagePath = ce.getAttribute("path");
					if(imagePlugin != null) {
						final URI plugInImage = URI.createPlatformPluginURI(imagePlugin + imagePath, true);
						
						addImageFilePath(imageId, plugInImage.toString());
					} else {
					
						addImageFilePath(imageId, imagePath);
					}
				}
			}
		}
	}
}
