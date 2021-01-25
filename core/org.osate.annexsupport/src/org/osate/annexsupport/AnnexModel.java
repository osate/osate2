package org.osate.annexsupport;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osate.aadl2.NamedElement;
import org.osate.core.OsateCorePlugin;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

/**
 * @since 3.1
 */
public class AnnexModel {
	public static final String PREFS_QUALIFIER = "org.osate.ui.internal.annex";
	public static final String PREF_ANNEX_USE_WORKSPACE = "org.osate.ui.internal.annex_use_workspace";

	// Methods
	public static final boolean getWorkspacePref(IProject project) {
		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);
		return prefs.getBoolean(AnnexModel.PREF_ANNEX_USE_WORKSPACE, true);
	}

	public static final boolean getAnnex(String annexExtensionId) {
		final IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();
		return store.getBoolean(annexExtensionId.toLowerCase());
	}

	public static final boolean getAnnex(final IProject project, String annexExtensionId) {
		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);

		Boolean annexTurnedOn = null;
		if (!prefs.getBoolean(PREF_ANNEX_USE_WORKSPACE, true)) {
			annexTurnedOn = prefs.getBoolean(annexExtensionId.toLowerCase(), true);
		}

		// It's possible the above may have failed for some reason, in which case we revert to the workspace preferences
		if (annexTurnedOn == null) {
			annexTurnedOn = getAnnex(annexExtensionId);
		}

		return annexTurnedOn;
	}

	public static final boolean getAnnexBasedOnWorkspacePreference(final IProject project, String annexExtensionId) {
		if (getWorkspacePref(project)) { // preferences set per workspace
			return getAnnex(annexExtensionId);
		}

		return getAnnex(project, annexExtensionId); // preference set per project
	}

	public static final void setAnnex(boolean value, IProject project, String annexExtensionId) {
		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);
		if (!prefs.getBoolean(PREF_ANNEX_USE_WORKSPACE, true)) {
			prefs.putBoolean(annexExtensionId, value);
			try {
				prefs.flush();
			} catch (BackingStoreException e) {
				AnnexPlugin.logError(e);
			}
		}
	}

	public static final void setAnnex(boolean value, String annexExtensionId) {
		final IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();
		store.setValue(annexExtensionId, value);
	}

	public static final void setWorkspacePref(boolean useWorkspace, IProject project) {
		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);
		prefs.putBoolean(AnnexModel.PREF_ANNEX_USE_WORKSPACE, useWorkspace);
	}

	public static <A extends NamedElement, D extends A> String filterDisabledAnnexes(
			D defaultAnnexSection,
			String annexName) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IFile file = root.getFile(new Path(defaultAnnexSection.eResource().getURI().toPlatformString(true)));
		IProject project = file.getProject();

		// check if this annex plugin is enabled in osate annex preferences
		if (org.osate.annexsupport.AnnexModel.getAnnexBasedOnWorkspacePreference(project, annexName)) {
			return annexName;
		}

		return "*";
	}
}