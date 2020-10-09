package org.osate.aadl2.errormodel.FaultTree.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osate.core.OsateCorePlugin;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

/**
 * @since 5.0
 */
public class FaultTreeModel {
	public static final String PREFS_QUALIFIER = "org.osate.aadl2.errormodel.faulttree";
	public static final String PREF_PRECISION = "org.osate.aadl2.errormodel.faulttree.precision";
	public static final String PREF_PRECISION_USE_WORKSPACE = "org.osate.aadl2.errormodel.faulttree.precision_use_workspace";

	// Methods
	public static final boolean getWorkspacePref(IProject project) {
		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);
		return prefs.getBoolean(FaultTreeModel.PREF_PRECISION_USE_WORKSPACE, true);
	}

	public static final int getPrecision() {
		final IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();
		return store.getInt(PREF_PRECISION);
	}

	public static final int getPrecision(final IProject project) {
		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);

		int precision = -1;
		if (!prefs.getBoolean(PREF_PRECISION_USE_WORKSPACE, true)) {
			precision = prefs.getInt(PREF_PRECISION, -1);
		}
		// It's possible the above may have failed for some reason, in which case we revert to the workspace preferences
		if (precision == -1) {
			precision = getPrecision();
		}

		if (precision < 1) {
			precision = 1; // use default setting
		}

		return precision;
	}

	public static final void setPrecision(int value, IProject project) {
		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);
		if (!prefs.getBoolean(PREF_PRECISION_USE_WORKSPACE, true)) {
			prefs.putInt(PREF_PRECISION, value);
			try {
				prefs.flush();
			} catch (BackingStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static final void setPrecision(int value) {
		final IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();
		store.setValue(PREF_PRECISION, value);
	}

	public static final void setWorkspacePref(boolean useWorkspace, IProject project) {
		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);
		prefs.putBoolean(FaultTreeModel.PREF_PRECISION_USE_WORKSPACE, useWorkspace);
	}
}