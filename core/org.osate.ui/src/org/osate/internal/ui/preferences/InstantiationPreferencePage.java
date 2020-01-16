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
package org.osate.internal.ui.preferences;

import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.osate.core.AadlNature;
import org.osate.core.OsateCorePlugin;
import org.osate.ui.dialogs.ProjectSelectionDialog;

/**
 * This class represents the OSATE > Instantiation workspace preferences.
 */

public class InstantiationPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
	private static final String LABEL = "Configure Project Specific Settings...";
	private static final String TITLE = "Project Specific Configuration";
	private static final String MESSAGE = "Select the project to configure:";
	private static final String ID = "org.osate.internal.ui.properties.InstantiationPropertyPage";
	private static final String[] ID_LIST = { ID };
	private static final Object DUMMY_DATA = new Object();

	private Link changeWorkspaceSettings;

	public InstantiationPreferencePage() {
		super(GRID);
		setPreferenceStore(OsateCorePlugin.getDefault().getPreferenceStore());
		setDescription("AADL model instantiation preferences");
	}

	@Override
	protected Label createDescriptionLabel(final Composite parent) {
		changeWorkspaceSettings = createLink(parent, LABEL);
		changeWorkspaceSettings.setLayoutData(new GridData(SWT.END, SWT.CENTER, true, false));
		return super.createDescriptionLabel(parent);
	}

	private Link createLink(final Composite composite, final String text) {
		Link link = new Link(composite, SWT.NONE);
		link.setFont(composite.getFont());
		link.setText("<A>" + text + "</A>");
		link.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				doLinkActivated((Link) e.widget);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				doLinkActivated((Link) e.widget);
			}
		});
		return link;
	}

	/**
	 * Create the field editors.
	 */
	@Override
	public void createFieldEditors() {
		IntegerFieldEditor f = new IntegerFieldEditor(OsateCorePlugin.MAX_SOM,
				"Maximum number of system operation modes to generate",
				getFieldEditorParent());
		f.setValidRange(1, Integer.MAX_VALUE);
		addField(f);
	}

	@Override
	public void init(final IWorkbench workbench) {
	}

	final void doLinkActivated(final Link link) {
		final ArrayList<IProject> projectsWithSpecifics = new ArrayList<>();
		final IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (IProject project : projects) {
			if (AadlNature.hasNature(project)) {
				projectsWithSpecifics.add(project);
			}
		}

		final ProjectSelectionDialog dialog = new ProjectSelectionDialog(getShell(), projectsWithSpecifics, TITLE,
				MESSAGE);
		if (dialog.open() == Window.OK) {
			final IProject project = dialog.getSelectedProject();
			PreferencesUtil.createPropertyDialogOn(getShell(), project, ID, ID_LIST, DUMMY_DATA).open();
		}
	}

}