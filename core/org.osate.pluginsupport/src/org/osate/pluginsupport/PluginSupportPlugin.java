/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.pluginsupport;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 *
 * @author lwrage
 * @version $Id: PluginSupportPlugin.java,v 1.4 2007-06-04 17:03:01 lwrage Exp $
 */
public class PluginSupportPlugin extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.osate.pluginsupport";

	public static final String PROPERTY_CONTRIBUTOR_EXTENSION_ID = "propertycontributor";

	public static final String AADL_CONTRIBUTION_EXTENSION_ID = "aadlcontribution";

	// The shared instance.
	private static PluginSupportPlugin plugin;

	private IResourceChangeListener rsrcListener = null;

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
		rsrcListener = new Listener();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(rsrcListener);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		if (rsrcListener != null) {
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(rsrcListener);
		}
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

	/**
	 * When a resource in the workspace is moved or deleted we check to see if it is overrides a
	 * plug-in contributed resource.  If so, we need to update the global preferences.
	 */
	private static class Listener implements IResourceChangeListener {
		@Override
		public void resourceChanged(final IResourceChangeEvent event) {
			if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
				final IResourceDelta docDelta = event.getDelta();
				if (docDelta != null) {
					final Job job = new DeltaJob(docDelta);
					job.schedule();
				}
			}
		}
	}

	private static class DeltaJob extends Job {
		private final IResourceDelta rsrcDelta;

		public DeltaJob(final IResourceDelta rsrcDelta) {
			super("Update contributed resources");
			this.rsrcDelta = rsrcDelta;
			setSystem(true);
			setUser(false);
		}

		@Override
		protected IStatus run(final IProgressMonitor monitor) {
			final Set<URI> deleted = new HashSet<>();
			final Map<URI, URI> moved = new HashMap<>();
			final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

			try {
				rsrcDelta.accept(delta -> {
					final IResource resource = delta.getResource();
					if (resource instanceof IFile) {
						if ((delta.getKind() & IResourceDelta.REMOVED) != 0) {
							final URI uri = OsateResourceUtil.toResourceURI(resource);
							if ((delta.getFlags() & IResourceDelta.MOVED_TO) != 0) {
								// File moved
								moved.put(uri, OsateResourceUtil.toResourceURI(root.getFile(delta.getMovedToPath())));
							} else {
								// normal delete
								deleted.add(uri);
							}
						}
					}
					return true;
				});
			} catch (final CoreException e) {
				logError(e);
			}

			PredeclaredProperties.processDelta(deleted, moved);
			return Status.OK_STATUS;
		}
	}
}
