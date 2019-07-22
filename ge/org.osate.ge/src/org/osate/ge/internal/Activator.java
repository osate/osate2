/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {
	final static Properties properties = createProperties();

	private static Properties createProperties() {
		final Properties prop = new Properties();
		try {
			final InputStream input = Activator.class.getClassLoader()
					.getResourceAsStream("../org.osate.ge.doc/help_ctx_constants.properties");
			prop.load(input);
		} catch (final IOException e) {
			throw new RuntimeException("Contextual help cannot be loaded.");
		}

		return prop;
	}

	// The plug-in ID
	public static final String PLUGIN_ID = "org.osate.ge"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	public static Object getHelpContext(final String key) {
		System.err.println(properties.get(key) + " key");
		return Objects.requireNonNull(properties.get(key), "Cannot find help context: " + key);
	}

	// MOVE TO UTIL
	public static void showHelp(final Object contextHelpId) {
		PlatformUI.getWorkbench().getHelpSystem().displayHelp(Activator.PLUGIN_ID + ".doc." + contextHelpId);
	}

}
