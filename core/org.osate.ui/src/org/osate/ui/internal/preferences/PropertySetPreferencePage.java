/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ui.internal.preferences;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osate.core.OsateCorePlugin;
import org.osate.pluginsupport.PredeclaredProperties;
import org.osate.ui.utils.PropertySetModel;

/**
 * @since 6.0
 */
public class PropertySetPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
	private List<BooleanFieldEditor> fields = new ArrayList<>();
	private List<StringFieldEditor> inputFields = new ArrayList<>();
	private Group group;
	private Composite composite;
//	private Composite content;

	public PropertySetPreferencePage() {
		super();
		setPreferenceStore(OsateCorePlugin.getDefault().getPreferenceStore());
		setDescription("Property Sets Plugin preferences");

		// set defaults for all property sets as use all contributed property sets
		PropertySetModel.setDefaultPreference();
	}

	/**
	 * Create the field editors.
	 */
	@Override
	public void createFieldEditors() {
		// Label label = new Label(getFieldEditorParent(), SWT.WRAP);
		// label.setText("Check the property sets that should be ignored: ");
		// label.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, true, true));

		group = new Group(getFieldEditorParent(), SWT.NONE);

		group.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, true, true));
		group.setText("Check the property sets that should be ignored");
		group.setLayout(new GridLayout(1, false));


		composite = new Composite(group, SWT.NONE);

		// get all property set names that were previously added by user
		List<String> addedNames = PropertySetModel.getAllAddedPropertySetNames();
		if (addedNames != null) {
			for (String prefName : addedNames) {
				final BooleanFieldEditor propField = new BooleanFieldEditor(prefName.toLowerCase(),
						prefName, composite);

				addField(propField);
				fields.add(propField);
			}
		}

		// need input field and 'Add' button to add new items to ignore list
		StringFieldEditor input = new StringFieldEditor("inputPropertySet", "Add Property Set Name: ",
				getFieldEditorParent());
		addField(input);
		inputFields.add(input);

		group.pack();
	}

	@Override
	public void init(final IWorkbench workbench) {
	}

	@Override
	public boolean performOk() {
		Boolean hasChanged = false;

		for (StringFieldEditor field : inputFields) {
			// add new property set name to the preferences. Set to ignore by default
			PropertySetModel.setPreference(true, field.getStringValue());

			String newValue = field.getStringValue();
			if (!newValue.isEmpty()) {
				final BooleanFieldEditor propField = new BooleanFieldEditor(newValue.toLowerCase(),
						newValue, composite);// getFieldEditorParent());
				addField(propField);
				fields.add(propField);

				field.setStringValue(""); // reset input field to empty string
				hasChanged = true;

				group.pack();
			}
		}

		for (BooleanFieldEditor field : fields) {
			String prefName = field.getLabelText();
			if (field.getBooleanValue() != PropertySetModel.getPreference(prefName)) {
				hasChanged = true;
			}

			PropertySetModel.setPreference(field.getBooleanValue(), prefName);
		}

		if (hasChanged) {
			PredeclaredProperties.closeAndReopenProjects();
		}

		return super.performOk();
	}
}