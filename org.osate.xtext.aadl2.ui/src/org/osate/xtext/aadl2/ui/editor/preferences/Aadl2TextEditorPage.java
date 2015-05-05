package org.osate.xtext.aadl2.ui.editor.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtext.ui.editor.preferences.LanguageRootPreferencePage;
import org.osate.workspace.WorkspacePlugin;

public class Aadl2TextEditorPage extends LanguageRootPreferencePage {

	@Override
	protected void createFieldEditors() {
		super.createFieldEditors();
		addField(new BooleanFieldEditor(WorkspacePlugin.AUTO_INDENT, "&AutoIndent next line after keywords",
				getFieldEditorParent()));
	}

	@Override
	protected IPreferenceStore doGetPreferenceStore() {
		return WorkspacePlugin.getDefault().getPreferenceStore();
	}

}
