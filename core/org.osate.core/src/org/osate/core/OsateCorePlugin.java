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
			if (!moved.isEmpty()) {
				final Job job = new RenameJob(moved, movedTo);
				job.schedule();
			}
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