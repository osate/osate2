package org.osate.mylyn.aadl.ui;

import org.eclipse.mylyn.context.ui.IContextUiStartup;
import org.eclipse.mylyn.monitor.ui.MonitorUi;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public final class AadlBridgePlugin extends AbstractUIPlugin {
	public static final String ID_PLUGIN = "org.osate.mylyn.aadi.ui";

	private static AadlBridgePlugin INSTANCE = null;

	private AadlEditingMonitor aadlEditingMonitor = null;

	public AadlBridgePlugin() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
	}

	/**
	 * Returns the shared instance.
	 */
	public static AadlBridgePlugin getDefault() {
		return INSTANCE;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		lazyStop();
		super.stop(context);
		INSTANCE = null;
	}

	private void lazyStart() {
		aadlEditingMonitor = new AadlEditingMonitor();
		MonitorUi.getSelectionMonitors().add(aadlEditingMonitor);
	}

	private void lazyStop() {
		if (aadlEditingMonitor != null) {
			MonitorUi.getSelectionMonitors().remove(aadlEditingMonitor);
		}
	}

	public static final class Startup implements IContextUiStartup {
		@Override
		public void lazyStartup() {
			AadlBridgePlugin.getDefault().lazyStart();
		}

	}

}
