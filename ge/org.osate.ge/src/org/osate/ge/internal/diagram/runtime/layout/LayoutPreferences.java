package org.osate.ge.internal.diagram.runtime.layout;

import org.osate.ge.internal.Activator;
import org.osate.ge.internal.preferences.Preferences;

public class LayoutPreferences {
	public static IncrementalLayoutMode getCurrentLayoutMode() {
		return IncrementalLayoutMode
				.getById(Activator.getDefault().getPreferenceStore().getString(Preferences.INCREMENTAL_LAYOUT_MODE))
				.orElse(IncrementalLayoutMode.LAYOUT_CONTENTS);
	}
}
