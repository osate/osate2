package org.osate.ui.internal.annex;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osate.core.OsateCorePlugin;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

/*
 * Since number of installed annexes is unknown, annex's ExtensionId is used as a
 * preference name (all spaces in ExtensionId are replaced with underscore)
 * */

/**
 * @since 5.0
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
		return store.getBoolean(annexExtensionId);
	}

	public static final boolean getAnnex(final IProject project, String annexExtensionId) {
		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);

		Boolean annexTurnedOn = null;
		if (!prefs.getBoolean(PREF_ANNEX_USE_WORKSPACE, true)) {
			annexTurnedOn = prefs.getBoolean(annexExtensionId, true);
		}

		// It's possible the above may have failed for some reason, in which case we revert to the workspace preferences
		if (annexTurnedOn == null) {
			annexTurnedOn = getAnnex(annexExtensionId);
		}

		return annexTurnedOn;
	}

	public static final void setAnnex(boolean value, IProject project, String annexExtensionId) {
		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);
		if (!prefs.getBoolean(PREF_ANNEX_USE_WORKSPACE, true)) {
			prefs.putBoolean(annexExtensionId, value);
			try {
				prefs.flush();
			} catch (BackingStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
}