package org.osate.ge.internal.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.diagram.runtime.layout.IncrementalLayoutMode;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		final IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault(Preferences.INCREMENTAL_LAYOUT_MODE,
				IncrementalLayoutMode.LAYOUT_CONTENTS.id);
	}
}
