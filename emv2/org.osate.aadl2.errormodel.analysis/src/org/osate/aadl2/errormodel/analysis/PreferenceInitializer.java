package org.osate.aadl2.errormodel.analysis;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		final IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault(Activator.HAZARD_FORMAT_PREF, Activator.HAZARD_FORMAT_DEFAULT);
	}

}
