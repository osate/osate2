package org.osate.ge.internal.ui;

import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.diagram.runtime.layout.IncrementalLayoutMode;
import org.osate.ge.internal.preferences.Preferences;

public class AgePreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	@Override
	protected void createFieldEditors() {
		addField(new ComboFieldEditor(Preferences.INCREMENTAL_LAYOUT_MODE, "Incremental Layout Mode",
				getIncrementalUpdateModeNamesAndLabels(),
				getFieldEditorParent()));
	}

	private static String[][] getIncrementalUpdateModeNamesAndLabels() {
		return new String[][] {
			new String[] { "Diagram", IncrementalLayoutMode.LAYOUT_DIAGRAM.id },
			new String[] { "Container", IncrementalLayoutMode.LAYOUT_CONTAINER.id },
			new String[] { "Contents", IncrementalLayoutMode.LAYOUT_CONTENTS.id } };
	}
}
