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
 * @version $Id: OsateCorePlugin.java,v 1.9 2007-07-06 22:47:27 jseibel Exp $
 */
package org.osate.core;

import java.net.URL;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class OsateCorePlugin extends AbstractUIPlugin {

	public static final String copyright = "Copyright 2004 by Carnegie Mellon University, all rights reserved";

	/**
	 * ID of the AADL core plugin (value <code>"org.osate.core"</code>)
	 */
	public static final String PLUGIN_ID = "org.osate.core";

	public static final String EXPAND_DEFAULT_FLAG = "expandXMLDefaults";

	/**
	 * Name of preference for the maximum number of system operation modes to generate.
	 */
	public static final String MAX_SOM = "maxSOM";
	public static final int MAX_SOM_DEFAULT = 1000;

	public static final String AUTO_REINSTANTIATE = "autoReinstantiate";
	public static final String AUTO_INDENT = "AUTO_INDENT";
	public static final String AUTO_COMPLETE = "AUTO_COMPLETE";
	public static final String CAPITALIZE = "CAPITALIZE";
	public static final String INDENT_SECTIONS = "INDENT_SECTIONS";

	// The shared instance.
	private static OsateCorePlugin plugin;

	// Resource bundle.
	private ResourceBundle resourceBundle;

	private IResourceChangeListener projectRenameHandler = null;

	/**
	 * The constructor.
	 */
	public OsateCorePlugin() {
		super();
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle("org.osate.core.OsateCorePluginResources");
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
		projectRenameHandler = new ProjectRenameHandler();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(projectRenameHandler);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		if (projectRenameHandler != null) {
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(projectRenameHandler);
			projectRenameHandler = null;
		}
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 */
	public static OsateCorePlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle = OsateCorePlugin.getDefault().getResourceBundle();
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

	public static String getPluginId() {
		return plugin.getBundle().getSymbolicName();
	}

	public static IPath getInstallLocation() {
		return new Path(getInstallURL().getFile());
	}

	public static URL getInstallURL() {
		return plugin.getBundle().getEntry("/");
	}

	public static void log(IStatus status) {
		getDefault().getLog().log(status);
	}

	public static void log(Throwable t) {
		log(new Status(IStatus.ERROR, getPluginId(), IStatus.OK, getMessage("OsateCorePlugin.internal_error"), t));
	}

	public static void logErrorMessage(String message) {
		log(new Status(IStatus.ERROR, getPluginId(), IStatus.OK, message, null));
	}

	public static void logErrorStatus(String message, IStatus status) {
		if (status == null) {
			logErrorMessage(message);
		} else {
			MultiStatus multi = new MultiStatus(getPluginId(), IStatus.OK, message, null);
			multi.add(status);
			log(multi);
		}
	}

	public static boolean isDebug() {
		return getDefault().isDebugging();
	}

	public static boolean isDebug(String option) {
		boolean debug;
		if (isDebug()) {
			String value = Platform.getDebugOption(option);
			debug = (value != null && value.equalsIgnoreCase("true") ? true : false);
		} else {
			debug = false;
		}
		return debug;
	}

	public static String getMessage(String key) {
		String bundleString;
		ResourceBundle bundle = getDefault().getResourceBundle();
		if (bundle != null) {
			try {
				bundleString = bundle.getString(key);
			} catch (MissingResourceException e) {
				log(e);
				bundleString = "!" + key + "!";
			}
		} else {
			bundleString = "!" + key + "!";
		}
		return bundleString;
	}

	public static String getFormattedMessage(String key, String arg) {
		return getFormattedMessage(key, new String[] { arg });
	}

	public static String getFormattedMessage(String key, String[] args) {
		return MessageFormat.format(getMessage(key), (Object[]) args);
	}

	/**
	 * When a project with an AADL Nature is renamed, we check the rest of the projects in the
	 * workspace to see if they depended on the renamed project.  If so, we update them to
	 * depend on the renamed project.
	 */
	private static class ProjectRenameHandler implements IResourceChangeListener {
		@Override
		public void resourceChanged(final IResourceChangeEvent event) {
			if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
				final IResourceDelta docDelta = event.getDelta();
				if (docDelta != null) {
					final RenameDeltaVisitor visitor = new RenameDeltaVisitor();
					try {
						docDelta.accept(visitor);
						visitor.executeRename();
					} catch (CoreException e) {
						OsateCorePlugin.log(e);
					}
				}
			}
		}
	}

	/*
	 * This is more complicated than seems necessary because I need to keep hold of the IProject
	 * references as I don't really know how to produce them later. Also, assume that many
	 * rename events could be reported at once because there is nothing that says that
	 * cannot happen.
	 */
	private static class RenameDeltaVisitor implements IResourceDeltaVisitor {
		private final Set<IProject> moved = new HashSet<>();
		private final Map<String, IProject> movedTo = new HashMap<>();

		@Override
		public boolean visit(final IResourceDelta delta) throws CoreException {
			final IResource resource = delta.getResource();
			if (resource instanceof IProject) {
				final IProject project = (IProject) resource;
				final int flags = delta.getFlags();
				if ((flags & IResourceDelta.MOVED_TO) != 0) {
					moved.add(project);
				}
				if ((flags & IResourceDelta.MOVED_FROM) != 0) {
					final IPath movedFromPath = delta.getMovedFromPath();
					final String oldName = movedFromPath.segment(movedFromPath.segmentCount() - 1);
					movedTo.put(oldName, project);
				}
			}
			return true;
		}

		public void executeRename() {
			final Job job = new RenameJob(moved, movedTo);
			job.schedule();
		}
	}

	private static class RenameJob extends Job {
		private final Set<IProject> moved;
		private final Map<String, IProject> movedTo;

		public RenameJob(final Set<IProject> moved, final Map<String, IProject> movedTo) {
			super("Rename AADL Project");
			this.moved = moved;
			this.movedTo = movedTo;
		}

		@Override
		protected IStatus run(final IProgressMonitor monitor) {
			/*
			 * For each project in moved:
			 * - check if the project it was moved to is AADL Nature (which would imply that it had AADL Nature originally)
			 * - get the list of referencing projects. For each one that is open and has AADL Nature,
			 * update the list of referenced projects
			 */
			try {
				ResourcesPlugin.getWorkspace().run(innerMonitor -> {
					for (final IProject before : moved) {
						final IProject after = movedTo.get(before.getName());
						if (AadlNature.hasNature(after)) {
							for (final IProject referencingProject : before.getReferencingProjects()) {
								// NB. hasNature() returns false if the project is not open
								if (AadlNature.hasNature(referencingProject)) {
									final IProjectDescription description = referencingProject.getDescription();
									final IProject[] referencedProjects = description.getReferencedProjects();
									for (int i = 0; i < referencedProjects.length; i++) {
										if (referencedProjects[i].equals(before)) {
											referencedProjects[i] = after;
											break;
										}
									}
									description.setReferencedProjects(referencedProjects);
									referencingProject.setDescription(description, innerMonitor);
								}
							}
						}
					}
				}, monitor);
			} catch (CoreException e) {
				OsateCorePlugin.log(e);
			}

			return Status.OK_STATUS;
		}

	}

	public final int getSOMLimit() {
		final IPreferenceStore store = getPreferenceStore();
		return store.getInt(MAX_SOM);
	}
}