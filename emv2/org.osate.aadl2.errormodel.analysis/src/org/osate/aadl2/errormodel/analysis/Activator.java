package org.osate.aadl2.errormodel.analysis;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osate.aadl2.errormodel.analysis.fha.FHAReport;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.osate.aadl2.errormodel.analysis"; //$NON-NLS-1$

	/**
	 * Name of the preference for which version of the analysis to use.
	 */
	public static final String HAZARD_FORMAT_PREF = "hazardFormat";
	public static final String HAZARD_FORMAT_DEFAULT = FHAReport.HazardFormat.EMV2.name();

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
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 *
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

}
