package org.osate.aadl2.modelsupport;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
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
	public static final String PLUGIN_ID = "org.osate.aadl2.modelsupport";

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

	public static IWorkspace getWorkspace() {
		return ResourcesPlugin.getWorkspace();
	}

	public static String getPluginId() {
		return plugin.getBundle().getSymbolicName();
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
		log(new Status(IStatus.ERROR, getPluginId(), IStatus.OK, ERROR_PREFIX + logMsg, aThrowable));
	}

	public static void logErrorMessage(String aMessage) {
		log(new Status(IStatus.ERROR, getPluginId(), IStatus.OK, aMessage, null));
	}
}
