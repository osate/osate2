package org.osate.xtext.aadl2.ui.editor.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osate.workspace.WorkspacePlugin;

public class Aadl2TextEditorPreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = WorkspacePlugin.getDefault().getPreferenceStore();
		store.setDefault(WorkspacePlugin.AUTO_INDENT, true);
		store.setDefault(WorkspacePlugin.AUTO_COMPLETE, true);
		store.setDefault(WorkspacePlugin.CAPITALIZE, false);
		store.setDefault(WorkspacePlugin.INDENT_SECTIONS, true);
	}
}
