package org.osate.pluginsupport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.preference.IPreferenceStore;

public final class PredeclaredProperties {
	private static final String IS_VISIBLE_PREFIX = "contributed.resource.isVisible.";
	public static final String NUMBER_OF_WORKSPACE_CONTRIBUTIONS = "contributed.resource.numWorkspace";
	private static final String WORKSPACE_CONTRIBUTION_PREFIX = "contributed.resource.workspaceURI.";

	private static final IPreferenceStore preferenceStore = PluginSupportPlugin.getDefault().getPreferenceStore();

	/*
	 * We make this thread-safe because the preferences are changed the UI thread (most likely) and the
	 * state is read from builder threads. We don't expect the preferences to be changed while the builder is
	 * running???
	 */
	private static volatile boolean isChanged = false;
	private static volatile List<URI> visiblePluginResources;
	private static volatile List<URI> visibleWorkspaceResources;
	private static volatile List<URI> visibleContributedResources;
	private static volatile boolean hasWorkspaceContributions;

	static {
		// Init the cached list of contributions
		buildVisibleContributedResources();
		hasWorkspaceContributions = preferenceStore.getInt(NUMBER_OF_WORKSPACE_CONTRIBUTIONS) > 0;

		// Add a listener so we know when to update the cached list of contributions
		preferenceStore.addPropertyChangeListener(e -> {
			final String propName = e.getProperty();
			if (propName.startsWith(IS_VISIBLE_PREFIX) || propName.startsWith(WORKSPACE_CONTRIBUTION_PREFIX)
					|| propName.equals(NUMBER_OF_WORKSPACE_CONTRIBUTIONS)) {
				isChanged = true;
			}
		});
	}

	public static IPreferenceStore getPreferenceStore() {
		return preferenceStore;
	}

	public static String getIsVisiblePreferenceNameForURI(final URI resourceURI) {
		return IS_VISIBLE_PREFIX + resourceURI.toString();
	}

	private static void buildVisibleContributedResources() {
		final List<URI> plugin = new ArrayList<>();
		final List<URI> workspace;
		final List<URI> allVisible = new ArrayList<>();
		for (final URI pluginURI : PluginSupportUtil.getContributedAadl()) {
			if (preferenceStore.getBoolean(getIsVisiblePreferenceNameForURI(pluginURI))) {
				plugin.add(pluginURI);
				allVisible.add(pluginURI);
			}
		}
		workspace = getWorkspaceContributions();
		allVisible.addAll(workspace);

		visiblePluginResources = Collections.unmodifiableList(plugin);
		visibleWorkspaceResources = Collections.unmodifiableList(workspace);
		visibleContributedResources = Collections.unmodifiableList(allVisible);
	}

	private static void updateCachedState() {
		if (isChanged) {
			buildVisibleContributedResources();
			hasWorkspaceContributions = preferenceStore.getInt(NUMBER_OF_WORKSPACE_CONTRIBUTIONS) > 0;
			isChanged = false;
		}
	}

	public static List<URI> getVisiblePluginContributedResources() {
		updateCachedState();
		return visiblePluginResources;
	}

	public static List<URI> getVisibleWorkspaceContributedResources() {
		updateCachedState();
		return visibleWorkspaceResources;
	}

	public static List<URI> getVisibleContributedResources() {
		updateCachedState();
		return visibleContributedResources;
	}

	public static boolean hasWorkspaceContributions() {
		updateCachedState();
		return hasWorkspaceContributions;
	}

	public static void setWorkspaceContributions(final List<URI> workspaceContributions) {
		final int size = workspaceContributions.size();
		preferenceStore.setValue(NUMBER_OF_WORKSPACE_CONTRIBUTIONS, size);
		for (int i = 0; i < size; i++) {
			String name = WORKSPACE_CONTRIBUTION_PREFIX + (i + 1);
			String string = workspaceContributions.get(i).toString();
			preferenceStore.setValue(name, string);
		}
	}

	private static List<URI> getWorkspaceContributions(final Function<String, Integer> getSize,
			final Function<String, String> getURIString) {
		final int size = getSize.apply(NUMBER_OF_WORKSPACE_CONTRIBUTIONS);
		if (size > 0) {
			final List<URI> workspaceContributions = new ArrayList<>(size);
			for (int i = 1; i <= size; i++) {
				workspaceContributions.add(URI.createURI(getURIString.apply(WORKSPACE_CONTRIBUTION_PREFIX + i)));
			}
			return workspaceContributions;
		} else {
			return Collections.emptyList();
		}
	}

	private static List<URI> getWorkspaceContributions() {
		return getWorkspaceContributions(preferenceStore::getInt, preferenceStore::getString);
	}

	public static List<URI> getDefaultWorkspaceContributions() {
		return getWorkspaceContributions(preferenceStore::getDefaultInt, preferenceStore::getDefaultString);
	}

	public static boolean hasSameNameAsVisibleContributedResource(final URI testMe) {
		final String fileName = testMe.lastSegment();
		for (final URI uri : getVisibleContributedResources()) {
			if (uri.lastSegment().equalsIgnoreCase(fileName)) {
				return true;
			}
		}
		return false;
	}
}