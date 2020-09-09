package org.osate.aadl2.errormodel.FaultTree.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osate.core.OsateCorePlugin;
import org.osgi.service.prefs.Preferences;

/**
 * @since 5.0
 */
public class FaultTreeModel {
	public static final String PREFS_QUALIFIER = "org.osate.aadl2.errormodel.faulttree";
	public static final String PREF_PRECISION = "org.osate.aadl2.errormodel.faulttree.precision";

//	public FaultTreeModel() {
//	}

	// Methods
	private static int getPrecision(final IProject project) {
		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);

		return prefs.getInt(PREF_PRECISION, 1);
	}

	public static final int getPrecision() {
		final IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();
		return store.getInt(PREF_PRECISION);
	}

	public static final void setPrecision(int value) {
		final IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();
		store.setValue(PREF_PRECISION, value);
	}
}