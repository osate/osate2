package org.osate.xtext.aadl2.ui.editor.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osate.core.OsateCorePlugin;

public class Aadl2TextEditorPreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();
		store.setDefault(OsateCorePlugin.AUTO_INDENT, true);
		store.setDefault(OsateCorePlugin.AUTO_COMPLETE, true);
		store.setDefault(OsateCorePlugin.CAPITALIZE, false);
		store.setDefault(OsateCorePlugin.INDENT_SECTIONS, true);
	}
}
