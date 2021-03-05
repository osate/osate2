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

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osate.core.OsateCorePlugin;

/**
 * This class represents the OSATE workspace preferences.
 *
 * @author lwrage
 * @version $Id: OsatePreferencePage.java,v 1.15 2007-06-18 18:47:27 jseibel Exp $
 * @since 6.0
 */

public class OsatePreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public OsatePreferencePage() {
		super(GRID);
		setPreferenceStore(OsateCorePlugin.getDefault().getPreferenceStore());
		setDescription("OSATE workspace preferences\n");
	}

	/**
	 * Create the field editors.
	 */
	@Override
	public void createFieldEditors() {
		BooleanFieldEditor be = new BooleanFieldEditor(OsateCorePlugin.EXPAND_DEFAULT_FLAG,
				"Store Default Attribute Values in XML File (Normally defaults recorded in the schema are not stored)",
				getFieldEditorParent());
		addField(be);
//		addField(new BooleanFieldEditor(WorkspacePlugin.AUTO_REINSTANTIATE, "Automatically reinstantiate models during build.", getFieldEditorParent()));
	}

	@Override
	public void init(IWorkbench workbench) {
	}
}