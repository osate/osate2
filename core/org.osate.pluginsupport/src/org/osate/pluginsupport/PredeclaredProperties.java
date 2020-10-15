package org.osate.pluginsupport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.PlatformUI;

/**
 * @since 5.0
 */
public final class PredeclaredProperties {
	/**
	 * Property that declares the total number of predeclared resource that are overridden by resources in the workspace.
	 */
	public static final String NUMBER_OF_WORKSPACE_OVERRIDES = "contributed.resource.numOverrides";
	/**
	 * Each resource that is overridden is identified by a property <code>contributed.resource.override.key.N</code>
	 * where <code>N</code> is an integer starting at 0.  The value here is the URI of the resource as it is
	 * contributed.
	 */
	private static final String WORKSPACE_OVERRIDE_KEY_PREFIX = "contributed.resource.override.key.";
	/**
	 * The overriding resource is identified by a property <code>contributed.resource.override.value.N</code> where
	 * <code>N</code> is an integer starting at 0.  The value is the URI of the resource in the workspace.
	 */
	private static final String WORKSPACE_OVERRIDE_VALUE_PREFIX = "contributed.resource.override.value.";

	private static final IPreferenceStore preferenceStore = PluginSupportPlugin.getDefault().getPreferenceStore();

	/*
	 * We make this thread-safe because the preferences are changed in the UI thread (most likely) and the
	 * state is read from builder threads. We don't expect the preferences to be changed while the builder is
	 * running???
	 */
	private static volatile boolean isChanged = false;
	private static volatile List<URI> contributedResources;
	private static volatile Map<URI, URI> overriddenResources;

	/** Inverse of the above */
	private static volatile Map<URI, URI> overriddingResources;
	private static volatile List<URI> effectiveContributedResources;

	/*
	 * These are used to control the updating of preference properties and prevent harmful or
	 * unneeded updates. selfUpdating is set to true when we are setting the preference
	 * properties and therefore property change listener should not respond to the
	 * corresponding update events. openingAndClosing is true when we are reseting the
	 * workspace to force it to rebuild using the new workspace contributions. This shuts down
	 * the processing of resource change events because otherwise we will be flooded with spurious
	 * remove and add events as projects open and close. These would cause the workspace
	 * overrides to BE REMOVED because they would be seen as deleted in the workspace
	 */
	private static volatile boolean selfUpdating = false;
	private static volatile boolean openingAndClosing = false;

	static {
		// Init the cached list of contributions
		buildContributedResources();

		// Add a listener for EXTERNAL changes to the properties, so we know when to update the cached list of contributions
		preferenceStore.addPropertyChangeListener(e -> {
			if (!selfUpdating) {
				final String propName = e.getProperty();
				if (propName.startsWith(NUMBER_OF_WORKSPACE_OVERRIDES)
						|| propName.startsWith(WORKSPACE_OVERRIDE_KEY_PREFIX)
						|| propName.equals(WORKSPACE_OVERRIDE_VALUE_PREFIX)) {
					isChanged = true;
				}
			}
		});
	}

	private static synchronized void buildContributedResources() {
		final List<URI> contributed = PluginSupportUtil.getContributedAadl();

		final Map<URI, URI> replaced = new HashMap<>();
		final Map<URI, URI> replaces = new HashMap<>();
		final int num = preferenceStore.getInt(NUMBER_OF_WORKSPACE_OVERRIDES);
		for (int i = 0; i < num; i++) {
			final URI key = URI.createURI(preferenceStore.getString(WORKSPACE_OVERRIDE_KEY_PREFIX + i));
			final URI value = URI.createURI(preferenceStore.getString(WORKSPACE_OVERRIDE_VALUE_PREFIX + i));
			replaced.put(key, value);
			replaces.put(value, key);
		}

		final List<URI> effective = new ArrayList<>(contributed.size());
		for (final URI key : contributed) {
			final URI value = replaced.get(key);
			effective.add(value == null ? key : value);
		}

		contributedResources = Collections.unmodifiableList(contributed);
		overriddenResources = Collections.unmodifiableMap(replaced);
		overriddingResources = Collections.unmodifiableMap(replaces);
		effectiveContributedResources = Collections.unmodifiableList(effective);
		isChanged = false;
	}

	private static void updateCachedState() {
		if (isChanged) {
			buildContributedResources();
		}
	}

	/**
	 * Get the list of resources contributed by plug-ins.  This list is not affected by
	 * overriding.
	 * @return An immutable list.
	 */
	public static List<URI> getContributedResources() {
		updateCachedState();
		return contributedResources;
	}

	/**
	 * Get the effective list of contributed resources, as determined by replacing contributed resources with
	 * workspace overrides.
	 * @return An immutable list.
	 */
	public static List<URI> getEffectiveContributedResources() {
		updateCachedState();
		return effectiveContributedResources;
	}

	/**
	 * Get a map that describes the contributed resources that are overridden by workspace resources.
	 * Contains one entry for each workspace resource that is actually overridden.  Keys are the
	 * URIs from {@link #getContributedResources}.  Values are URIs to the workspace.  Looking up
	 * a URI for a resource that is not overridden returns <code>null</code>.
	 *
	 * @return An immutable map.
	 */
	public static Map<URI, URI> getOverriddenResources() {
		updateCachedState();
		return overriddenResources;
	}

	/**
	 * Given a URI from the workspace, return the contributed URI, if any, that it overrides.
	 * Return <code>null</code> if the workspace URI doesn't override anything.
	 */
	public static URI getOverridesURI(final URI workspaceURI) {
		return overriddingResources.get(workspaceURI);
	}

	/**
	 * Update the overridden contributed resources in the the stored properties.
	 */
	public static synchronized void setOverriddenResources(final Map<URI, URI> replaced) {
		selfUpdating = true;

		/*
		 * First clean up the old settings. This isn't strictly necessary, but things can bet confusing if the
		 * number of overrides shrinks but the old key and value preferences are still left hanging around.
		 */
		final int oldSize = preferenceStore.getInt(NUMBER_OF_WORKSPACE_OVERRIDES);
		for (int i = 0; i < oldSize; i++) {
			final String keyName = WORKSPACE_OVERRIDE_KEY_PREFIX + i;
			preferenceStore.setToDefault(keyName);

			final String valueName = WORKSPACE_OVERRIDE_VALUE_PREFIX + i;
			preferenceStore.setToDefault(valueName);
		}
		preferenceStore.setToDefault(NUMBER_OF_WORKSPACE_OVERRIDES);

		/* Now set the new values */
		final int size = replaced.size();
		preferenceStore.setValue(NUMBER_OF_WORKSPACE_OVERRIDES, size);
		int i = 0;
		for (Map.Entry<URI, URI> entry : replaced.entrySet()) {
			final String keyName = WORKSPACE_OVERRIDE_KEY_PREFIX + i;
			preferenceStore.setValue(keyName, entry.getKey().toString());

			final String valueName = WORKSPACE_OVERRIDE_VALUE_PREFIX + i;
			preferenceStore.setValue(valueName, entry.getValue().toString());
		}
		isChanged = true;
		selfUpdating = false;
	}

	/**
	 * Update the contributed resources that have workspace overrides when those files are
	 * moved or deleted.
	 */
	public static synchronized void processDelta(final Set<URI> deleted, final Map<URI, URI> moved) {
		/*
		 * DO NOT PROCESS CHANGES IF THEY ARE RESULT OF OUR OWN OPENING AND CLOSING OF PROJECTS TO
		 * FORCE THE BUILD TO UPDATE!! Otherwise we end up processing a _delete_ of the all the workspace
		 * files and erase all our settings.
		 */
		if (!openingAndClosing) {
			// Make sure we have the most recent information
			updateCachedState();
			final Map<URI, URI> overridden = new HashMap<>(overriddenResources);
			boolean changed = false;
			String message = "";

			// Restore any predeclared resources that were overridden by the removed file
			for (final URI d : deleted) {
				final URI key = overriddingResources.get(d);
				if (key != null) {
					overridden.remove(key);
					changed = true;
					message += "    " + d + " removed" + System.lineSeparator();
				}
			}

			/*
			 * Update any predeclared resources that are overridden by the moved file.
			 * If the file is renamed so that it no longer matches the name of the
			 * plug-in contribution, then we treat the file as removed.
			 */
			for (final Map.Entry<URI, URI> entry : moved.entrySet()) {
				final URI key = overriddingResources.get(entry.getKey());
				if (key != null) {
					final String contributedName = key.lastSegment();
					final String newName = entry.getValue().lastSegment();
					if (contributedName.equalsIgnoreCase(newName)) {
						// name is the same, but the location changed
						overridden.put(key, entry.getValue());
					} else {
						// name changed, violation of the invariants, so we remove it
						overridden.remove(key);
						message += "    " + entry.getKey() + " renamed" + System.lineSeparator();
					}
					changed = true;
				}
			}

			if (changed) {
				if (!message.isEmpty()) {
					final String finalMessage = message;
					PlatformUI.getWorkbench().getDisplay().asyncExec(() -> {
						MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
								"Overriding of Contributed Resources Updated",
								"Contributed resources updated because resources in workpace" + System.lineSeparator()
										+ "that override them have changed:" + System.lineSeparator() + finalMessage);
					});
				}
				setOverriddenResources(overridden);
				save();
				buildContributedResources();
				closeAndReopenProjects();
			}
		}
	}

	private static void save() {
		try {
			((IPersistentPreferenceStore) preferenceStore).save();
		} catch (final IOException e) {
			PluginSupportPlugin.logError(e);
		}
	}

	public static boolean hasSameNameAsVisibleContributedResource(final URI testMe) {
		final String fileName = testMe.lastSegment();
		for (final URI uri : getContributedResources()) {
			if (uri.lastSegment().equalsIgnoreCase(fileName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * In a separate job, closes and reopens all the projects in the workspace to force the new
	 * set of contributed resources to be considered.
	 */
	public static void closeAndReopenProjects() {
		/*
		 * Rebuilding or cleaning the workspace doesn't seem to get the job done. It leaves
		 * dangling links and other strangeness in the workspace. The most effective thing
		 * to do seems to be closing and reopening projects. Have no idea why.
		 *
		 * NB. THis CANNOT be a WorkspaceJob because that will cause various events to be suppressed or
		 * optimized away, and then the build won't happen correctly.
		 */
		final Job job = new Job("Contributed Resources Rebuild") {
			@Override
			public IStatus run(final IProgressMonitor monitor) {
				openingAndClosing = true;
				try {
					final IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
					final List<IProject> projectsToOpenAndClose = new ArrayList<>(projects.length);

					// (1) close all the open projects
					for (final IProject project : projects) {
						if (project.isOpen()) {
							projectsToOpenAndClose.add(project);
							project.close(monitor);
						}
					}

					// (2) Reopen all the projects we closed
					for (final IProject project : projectsToOpenAndClose) {
						project.open(monitor);
					}

					return Status.OK_STATUS;
				} catch (final CoreException e) {
					return new Status(IStatus.ERROR, PluginSupportPlugin.PLUGIN_ID, "Error building workspace");
				} finally {
					openingAndClosing = false;
				}
			}
		};
		job.setRule(ResourcesPlugin.getWorkspace().getRoot()); // Lock the workspace?
		job.schedule();
	}
}
