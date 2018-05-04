package org.osate.aadl2.util;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	private static final String ERROR_PREFIX = "*** Internal error: ";

	// The plug-in ID
	public static final String PLUGIN_ID = "org.osate.aadl2";

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
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

	public static void log(IStatus aStatus) {
		getDefault().getLog().log(aStatus);
	}

	public static void logErrorMessage(String aMessage) {
		log(new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, aMessage, null));
	}

	/**
	 * log message with this plugin log
	 * @param message
	 */
	public static void internalError(String message) {
		logErrorMessage(ERROR_PREFIX + message);
	}
}