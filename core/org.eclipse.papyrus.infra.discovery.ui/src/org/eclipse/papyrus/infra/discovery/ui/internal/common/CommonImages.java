/*******************************************************************************
 * Copyright (c) 2004, 2009 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tasktop Technologies - initial API and implementation
 *     Obeo - adaptation for Amalgamation, EMF based and no Mylyn dependency
 *     CEA LIST - adaptation to Papyrus
 *******************************************************************************/

package org.eclipse.papyrus.infra.discovery.ui.internal.common;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.infra.discovery.ui.Activator;
import org.eclipse.swt.graphics.Image;

/**
 * @author Mik Kersten
 * @since 3.0
 */
public class CommonImages {

	private static final URL baseURL = Activator.getDefault().getBundle().getEntry("/icons/full/"); //$NON-NLS-1$

	private static ImageRegistry imageRegistry;

	private static final String T_TOOL = "etool16"; //$NON-NLS-1$

	private static final String T_WIZBAN = "wizban"; //$NON-NLS-1$

	// Discovery

	public static final ImageDescriptor BANNER_DISCOVERY = create(T_WIZBAN, "banner-discovery-papyrus.png"); //$NON-NLS-1$

	public static final ImageDescriptor FIND_CLEAR = create(T_TOOL, "find-clear.gif"); //$NON-NLS-1$

	public static final ImageDescriptor FIND_CLEAR_DISABLED = create(T_TOOL, "find-clear-disabled.gif"); //$NON-NLS-1$

	private static ImageDescriptor create(String prefix, String name) {
		try {
			return ImageDescriptor.createFromURL(makeIconFileURL(prefix, name));
		} catch (MalformedURLException e) {
			return ImageDescriptor.getMissingImageDescriptor();
		}
	}

	/**
	 * Lazily initializes image map.
	 *
	 * @param imageDescriptor
	 * @return Image
	 */
	public static Image getImage(ImageDescriptor imageDescriptor) {
		ImageRegistry imageRegistry = getImageRegistry();
		Image image = imageRegistry.get("" + imageDescriptor.hashCode()); //$NON-NLS-1$
		if (image == null) {
			image = imageDescriptor.createImage(true);
			imageRegistry.put("" + imageDescriptor.hashCode(), image); //$NON-NLS-1$
		}
		return image;
	}

	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}

		return imageRegistry;
	}

	private static URL makeIconFileURL(String prefix, String name) throws MalformedURLException {
		if (baseURL == null) {
			throw new MalformedURLException();
		}

		StringBuffer buffer = new StringBuffer(prefix);
		buffer.append('/');
		buffer.append(name);
		return new URL(baseURL, buffer.toString());
	}

}
