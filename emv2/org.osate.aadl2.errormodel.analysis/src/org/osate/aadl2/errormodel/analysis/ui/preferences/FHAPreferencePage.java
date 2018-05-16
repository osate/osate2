package org.osate.aadl2.errormodel.analysis.ui.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osate.aadl2.errormodel.analysis.Activator;
import org.osate.aadl2.errormodel.analysis.fha.FHAReport.HazardFormat;

public class FHAPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
	private static final String LABEL = "Choose the hazard format for the assessment";
	private static final String[][] LABEL_AND_VALUES = new String[][] { { "EMV2", HazardFormat.EMV2.name() },
			{ "MILSTD882", HazardFormat.MILSTD882.name() }, { "ARP4761", HazardFormat.ARP4761.name() } };

	public FHAPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Functional hazard assessment preferences");
	}

	@Override
	protected void createFieldEditors() {
		RadioGroupFieldEditor f = new RadioGroupFieldEditor(Activator.HAZARD_FORMAT_PREF,
				LABEL, 1, LABEL_AND_VALUES, getFieldEditorParent(), true);
		addField(f);
	}

	@Override
	public void init(final IWorkbench workbench) {
		// do nothing
	}

}
