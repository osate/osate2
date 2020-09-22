/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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

package org.osate.aadl2.errormodel.FaultTree.ui;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osate.aadl2.errormodel.FaultTree.util.FaultTreeModel;
import org.osate.core.OsateCorePlugin;

/**
 * This class represents the OSATE > Fault Tree workspace preferences.
 * @since 5.0
 */
public class FaultTreePreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
	private IntegerFieldEditor precisionField;

	public FaultTreePreferencePage() {
		super(GRID);
		setPreferenceStore(OsateCorePlugin.getDefault().getPreferenceStore());
		setDescription("Probability precision preferences for fault tree analysis");
	}

	@Override
	protected Label createDescriptionLabel(final Composite parent) {
		return super.createDescriptionLabel(parent);
	}
	/**
	 * Create the field editors.
	 */
	@Override
	public void createFieldEditors() {
		precisionField = new IntegerFieldEditor(FaultTreeModel.PREF_PRECISION,
				"Probability precision",
				getFieldEditorParent());
		precisionField.setValidRange(1, Integer.MAX_VALUE);
		addField(precisionField);
	}

	@Override
	public void init(final IWorkbench workbench) {
	}

	@Override
	public boolean performOk() {
		FaultTreeModel.setPrecision(precisionField.getIntValue());
		return true;
	}
}