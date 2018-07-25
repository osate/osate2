/**
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 *
 * @version $Id: OsateUiPlugin.java,v 1.8 2007-07-06 22:47:26 jseibel Exp $
 */
package org.osate.ui;

import java.net.URL;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class OsateUiPlugin extends AbstractUIPlugin {
	public static final String PLUGIN_ID = "org.osate.ui";

	public static final String copyright = "Copyright 2014 by Carnegie Mellon University, all rights reserved";

	// The shared instance.
	private static volatile OsateUiPlugin plugin;

	// Resource bundle.
	private ResourceBundle resourceBundle;

	/**
	 * The constructor.
	 */
	public OsateUiPlugin() {
		super();
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle("org.osate.ui.OsateUiPluginResources");
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
	public static OsateUiPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle = OsateUiPlugin.getDefault().getResourceBundle();
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

	public static IWorkspace getWorkspace() {
		return ResourcesPlugin.getWorkspace();
	}

	public static Shell getActiveWorkbenchShell() {
		final AtomicReference<Shell> result = new AtomicReference<>();
		Display.getDefault().syncExec(() -> {
			final IWorkbenchWindow window = getDefault().getWorkbench().getActiveWorkbenchWindow();
			result.set(window != null ? window.getShell() : null);
		});
		return result.get();
	}

	public static IWorkbenchWindow getActiveWorkbenchWindow() {
		final AtomicReference<IWorkbenchWindow> result = new AtomicReference<>();
		Display.getDefault().syncExec(() -> result.set(getDefault().getWorkbench().getActiveWorkbenchWindow()));
		return result.get();
	}

	public static IWorkbenchPage getActiveWorkbenchPage() {
		final AtomicReference<IWorkbenchPage> result = new AtomicReference<>();
		Display.getDefault().syncExec(() -> result.set(getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage()));
		return result.get();
	}

	public static String getPluginId() {
		return plugin.getBundle().getSymbolicName();
	}

	public static IPath getInstallLocation() {
		return new Path(getInstallURL().getFile());
	}

	public static URL getInstallURL() {
		return plugin.getBundle().getEntry("/");
	}

	public static String getUniqueIdentifier() {
		return plugin.getBundle().getSymbolicName();
	}

	public static void log(IStatus aStatus) {
		getDefault().getLog().log(aStatus);
	}

	public static void log(Throwable aThrowable) {
		log(new Status(IStatus.ERROR, getPluginId(), IStatus.OK, getMessage("Plugin.internal_error"), aThrowable));
	}

	public static void logErrorMessage(String aMessage) {
		log(new Status(IStatus.ERROR, getPluginId(), IStatus.OK, aMessage, null));
	}

	public static void logErrorStatus(String aMessage, IStatus aStatus) {
		if (aStatus == null) {
			logErrorMessage(aMessage);
		} else {
			MultiStatus multi = new MultiStatus(getPluginId(), IStatus.OK, aMessage, null);
			multi.add(aStatus);
			log(multi);
		}
	}

	/**
	 * Create a status associated with this plugin.
	 *
	 * @param severity
	 * @param aCode
	 * @param aMessage
	 * @param exception
	 * @return A status configured with this plugin's id and the given
	 *         parameters.
	 */
	public static IStatus createStatus(int severity, int aCode, String aMessage, Throwable exception) {
		return new Status(severity, PLUGIN_ID, aCode, aMessage != null ? aMessage : "No message.", exception); //$NON-NLS-1$
	}

	public static boolean isDebug() {
		return getDefault().isDebugging();
	}

	public static String getMessage(String aKey) {
		String bundleString;
		ResourceBundle bundle = getDefault().getResourceBundle();
		if (bundle != null) {
			try {
				bundleString = bundle.getString(aKey);
			} catch (MissingResourceException e) {
				log(e);
				bundleString = "!" + aKey + "!";
			}
		} else {
			bundleString = "!" + aKey + "!";
		}
		return bundleString;
	}

	public static String getFormattedMessage(String aKey, String anArg) {
		return getFormattedMessage(aKey, new String[] { anArg });
	}

	public static String getFormattedMessage(String aKey, String[] anArgs) {
		return MessageFormat.format(getMessage(aKey), (Object[]) anArgs);
	}

	public static ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin("org.osate.ui", path);
	}
}