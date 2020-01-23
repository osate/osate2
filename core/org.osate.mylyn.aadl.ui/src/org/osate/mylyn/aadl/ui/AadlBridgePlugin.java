/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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
