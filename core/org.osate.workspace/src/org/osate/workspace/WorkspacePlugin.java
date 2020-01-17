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
package org.osate.workspace;

import java.net.URL;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class WorkspacePlugin extends Plugin {
	/**
	 * ID of the AADL core plugin (value
	 * <code>"org.osate.workspace"</code>)
	 */
	public static final String PLUGIN_ID = "org.osate.workspace";

	/**
	 * File extension of AADL source text files
	 */
	public static final String SOURCE_FILE_EXT = "aadl";
	public static final String SOURCE_FILE_EXT2 = "aadl2";

	/**
	 * File extension of AADL model files
	 */
	public static final String MODEL_FILE_EXT = "aaxl2";

//	 Instance model extensions and naming
	// new naming convention is "aail2" and no need for name ending with "_instance"
	// Code for handling new convention is in place
	// Have not enabled until people depending on it are made aware of the change

	/**
	 * File extension of AADL instance model files
	 */
	public static final String INSTANCE_FILE_EXT = "aaxl2";

	/**
	 * Default Aadl instances directory.
	 */
	public static final String AADL_INSTANCES_DIR = "instances";

	/**
	 * Default Aadl instances directory.
	 */
	public static final String AADL_REPORTS_DIR = "reports";

	/**
	 * instance model name postfix
	 */
	public static final String INSTANCE_MODEL_POSTFIX = "_Instance";

	/**
	 * Package separator in AADL source files.
	 */
	public static final String AADL_PACKAGE_SEPARATOR = "::";

	/**
	 * Package separator in package file names.
	 */
	public static final String FILE_PACKAGE_SEPARATOR = "-";

	// The shared instance.
	private static WorkspacePlugin plugin;

	// Resource bundle.
	private ResourceBundle resourceBundle;

	/**
	 * The constructor.
	 */
	public WorkspacePlugin() {
		super();
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle("org.osate.workspace.WorkspacePluginResources");
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
	}

	/**
	 * This method is called upon plug-in activation
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 */
	public static WorkspacePlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the string from the plugin's resource bundle, or 'key' if not
	 * found.
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle = WorkspacePlugin.getDefault().getResourceBundle();
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

	public static URL getInstallURL() {
		return plugin.getBundle().getEntry("/");
	}

	public static void log(IStatus status) {
		getDefault().getLog().log(status);
	}

	public static void log(Throwable t) {
		log(new Status(IStatus.ERROR, getPluginId(), IStatus.OK, "WorkspacePlugin internal error", t));
	}

	public static void logErrorMessage(String message) {
		log(new Status(IStatus.ERROR, getPluginId(), IStatus.OK, message, null));
	}

	public static String getPluginId() {
		return plugin.getBundle().getSymbolicName();
	}
}