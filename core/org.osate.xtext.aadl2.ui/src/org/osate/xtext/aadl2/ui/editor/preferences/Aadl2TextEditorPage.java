package org.osate.xtext.aadl2.ui.editor.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtext.ui.editor.preferences.LanguageRootPreferencePage;
import org.osate.core.OsateCorePlugin;

public class Aadl2TextEditorPage extends LanguageRootPreferencePage {

	@Override
	protected void createFieldEditors() {
		/*
		 * Don't call super-implementation because we don't want the
		 * "reset prompts" button.
		 */
//		super.createFieldEditors();
		addField(new BooleanFieldEditor(OsateCorePlugin.AUTO_INDENT, "&AutoIndent next line after keywords",
				getFieldEditorParent()));
		addField(new BooleanFieldEditor(OsateCorePlugin.AUTO_COMPLETE,
				"Auto&Complete Package and Components with blank line and \"end\" on next line",
				getFieldEditorParent()));
		addField(new BooleanFieldEditor(OsateCorePlugin.CAPITALIZE,
				"Use &upper case instead of lower case for \"public\" and \"end\" when using auto complete above",
				getFieldEditorParent()));
		addField(new BooleanFieldEditor(OsateCorePlugin.INDENT_SECTIONS,
				"Automatically set indent of component &section keywords", getFieldEditorParent()));
	}

	@Override
	protected IPreferenceStore doGetPreferenceStore() {
		return OsateCorePlugin.getDefault().getPreferenceStore();
	}

}
