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
		addField(new BooleanFieldEditor(WorkspacePlugin.AUTO_COMPLETE,
				"Auto&Complete Package Classifier with blank line and \"end\" on next line", getFieldEditorParent()));
		addField(new BooleanFieldEditor(WorkspacePlugin.CAPITALIZE,
				"Use &upper case instead of lower case for \"public\" and \"end\" when using auto complete above",
				getFieldEditorParent()));
	}

	@Override
	protected IPreferenceStore doGetPreferenceStore() {
		return WorkspacePlugin.getDefault().getPreferenceStore();
	}

}
