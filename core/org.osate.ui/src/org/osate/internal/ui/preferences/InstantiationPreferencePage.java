/*
 * <copyright>
 * Copyright  2009 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
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