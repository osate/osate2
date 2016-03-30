package org.osate.analysis.resource.management;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class ResourcemanagementPlugin extends AbstractUIPlugin {
	private static final String ERROR_PREFIX = "*** Internal error: ";
	// The shared instance.
	private static ResourcemanagementPlugin plugin;
	// Resource bundle.
	private ResourceBundle resourceBundle;

	/**
	 * The constructor.
	 */
	public ResourcemanagementPlugin() {
		super();
		plugin = this;
		try {
			resourceBundle = ResourceBundle
					.getBundle("org.osate.analysis.resource.management.ResourcemanagementPluginResources");
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
	}

	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 */
	public static ResourcemanagementPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle = ResourcemanagementPlugin.getDefault().getResourceBundle();
		try {
			return (bundle != null) ? bundle.getString(key) : key;
		} catch (MissingResourceException e) {
			return key;
		}
	}

	/**
	 * Returns the plugin's resource bundle,
	 */
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	public static void log(IStatus aStatus) {
		getDefault().getLog().log(aStatus);
	}

	public static void logThrowable(Throwable aThrowable) {
		final String msg = aThrowable.getMessage();
		final String logMsg;
		if (msg != null) {
			logMsg = msg;
		} else {
			logMsg = "Exception " + aThrowable.getClass().getName();
		}
		log(new Status(IStatus.ERROR, plugin.getBundle().getSymbolicName(), Status.OK, ERROR_PREFIX + logMsg,
				aThrowable));
	}

	public static void logErrorMessage(String aMessage) {
		log(new Status(IStatus.ERROR, plugin.getBundle().getSymbolicName(), Status.OK, aMessage, null));
	}

}
