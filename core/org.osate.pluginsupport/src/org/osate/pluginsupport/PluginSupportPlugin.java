/**
 * <copyright>
 * Copyright 2006 by Carnegie Mellon University, all rights reserved.
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
 *
 * </copyright>
 */
package org.osate.pluginsupport;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 *
 * @author lwrage
 * @version $Id: PluginSupportPlugin.java,v 1.4 2007-06-04 17:03:01 lwrage Exp $
 */
public class PluginSupportPlugin extends Plugin {

	public static final String PLUGIN_ID = "org.osate.pluginsupport";

	public static final String PROPERTY_CONTRIBUTOR_EXTENSION_ID = "propertycontributor";

	public static final String AADL_CONTRIBUTION_EXTENSION_ID = "aadlcontribution";

	// The shared instance.
	private static PluginSupportPlugin plugin;

	/**
	 * The constructor.
	 */
	public PluginSupportPlugin() {
		plugin = this;
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
		plugin = null;
	}

	/**
	 * Returns the shared instance.
	 */
	public static PluginSupportPlugin getDefault() {
		return plugin;
	}

	public static String getPluginId() {
		return plugin.getBundle().getSymbolicName();
	}

	// Logging methods

	/**
	 * Log the specified information.
	 * @param message a log message.
	 */
	public static void logInfo(String message) {
		log(IStatus.INFO, IStatus.OK, message, null);
	}

	/**
	 * Log the specified warning.
	 * @param message a log message.
	 */
	public static void logWarning(String message) {
		log(IStatus.WARNING, IStatus.OK, message, null);
	}

	/**
	 * Log the specified error.
	 * @param exception - an expeption.
	 */
	public static void logError(Throwable exception) {
		logError("Unexpected Exception", exception);
	}

	/**
	 * Log the specified error.
	 * @param message a message
	 * @param exception the exception
	 */
	public static void logError(String message, Throwable exception) {
		log(IStatus.ERROR, IStatus.OK, message, exception);
	}

	/**
	 * Log the specified information.
	 * @param severity
	 *                the severity; one of the following: <code>IStatus.OK</code>,
	 *                <code>IStatus.ERROR</code>,<code>IStatus.INFO</code>,
	 *                or <code>IStatus.WARNING</code>.
	 * @param code
	 *                the plug-in-specific status code, or <code>OK</code>.
	 * @param message
	 *                a human-readable message, localized to the current locale.
	 * @param exception
	 *                a low-level exception, or <code>null</code> if not
	 *                applicable.
	 */
	public static void log(int severity, int code, String message, Throwable exception) {
		log(createStatus(severity, code, message, exception));
	}

	/**
	 * Create a status object representing the specified information.
	 *
	 * @param severity
	 *                the severity; one of the following: <code>IStatus.OK</code>,
	 *                <code>IStatus.ERROR</code>,<code>IStatus.INFO</code>,
	 *                or <code>IStatus.WARNING</code>.
	 * @param code
	 *                the plug-in-specific status code, or <code>OK</code>.
	 * @param message
	 *                a human-readable message, localized to the current locale.
	 * @param exception
	 *                a low-level exception, or <code>null</code> if not
	 *                applicable.
	 * @return the status object (not <code>null</code>).
	 */
	public static IStatus createStatus(int severity, int code, String message, Throwable exception) {
		return new Status(severity, PluginSupportPlugin.getDefault().getBundle().getSymbolicName(), code, message,
				exception);
	}

	/**
	 * Log the given status.
	 *
	 * @param status
	 *                the status to log.
	 */
	public static void log(IStatus status) {
		PluginSupportPlugin.getDefault().getLog().log(status);
	}
}
