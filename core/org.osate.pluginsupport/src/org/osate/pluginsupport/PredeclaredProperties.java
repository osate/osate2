package org.osate.pluginsupport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.preference.IPreferenceStore;

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

	static {
		// Init the cached list of contributions
		buildContributedResources();

		// Add a listener so we know when to update the cached list of contributions
		preferenceStore.addPropertyChangeListener(e -> {
			final String propName = e.getProperty();
			if (propName.startsWith(NUMBER_OF_WORKSPACE_OVERRIDES) || propName.startsWith(WORKSPACE_OVERRIDE_KEY_PREFIX)
					|| propName.equals(WORKSPACE_OVERRIDE_VALUE_PREFIX)) {
				isChanged = true;
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
	}

	private static void updateCachedState() {
		if (isChanged) {
			buildContributedResources();
			isChanged = false;
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
		final int size = replaced.size();
		preferenceStore.setValue(NUMBER_OF_WORKSPACE_OVERRIDES, size);
		int i = 0;
		for (Map.Entry<URI, URI> entry : replaced.entrySet()) {
			final String keyName = WORKSPACE_OVERRIDE_KEY_PREFIX + i;
			preferenceStore.setValue(keyName, entry.getKey().toString());

			final String valueName = WORKSPACE_OVERRIDE_VALUE_PREFIX + i;
			preferenceStore.setValue(valueName, entry.getValue().toString());
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
}
