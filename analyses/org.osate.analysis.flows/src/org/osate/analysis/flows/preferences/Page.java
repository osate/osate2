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
package org.osate.analysis.flows.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osate.analysis.flows.FlowanalysisPlugin;

public class Page extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private TabFolder folder;

	public Page() {
		super(GRID);
		setPreferenceStore(FlowanalysisPlugin.getDefault().getPreferenceStore());
		setDescription("Choose the default settings for the flow latency analysis.");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	@Override
	public void createFieldEditors() {
		RadioGroupFieldEditor synchronousSystem = new RadioGroupFieldEditor(Constants.ASYNCHRONOUS_SYSTEM,
				"System type", 1,
				new String[][] { { "Asynchronous system (AS)", Constants.ASYNCHRONOUS_SYSTEM_YES },
						{ "Synchronous system (SS)", Constants.ASYNCHRONOUS_SYSTEM_NO } },
				getFieldEditorParent(), true);
		addField(synchronousSystem);
		RadioGroupFieldEditor partitioningPolicy = new RadioGroupFieldEditor(Constants.PARTITONING_POLICY,
				"Partition output policy", 1,
				new String[][] { { "Partition end (PE)", Constants.PARTITIONING_POLICY_PARTITION_END_STR },
						{ "Major frame delayed (MF)", Constants.PARTITIONING_POLICY_MAJOR_FRAME_DELAYED_STR } },
				getFieldEditorParent(), true);
		addField(partitioningPolicy);
		RadioGroupFieldEditor worstCaseDeadline = new RadioGroupFieldEditor(Constants.WORST_CASE_DEADLINE,
				"For worst-case processing time use", 1,
				new String[][] { { "Deadline (DL)", Constants.WORST_CASE_DEADLINE_YES },
			{ "Maximum compute execution time (ET)", Constants.WORST_CASE_DEADLINE_NO } },
				getFieldEditorParent(), true);
		addField(worstCaseDeadline);
		RadioGroupFieldEditor bcEmptyQueue = new RadioGroupFieldEditor(Constants.BESTCASE_EMPTY_QUEUE,
				"For best-case queuing latency on incoming ports", 1,
				new String[][] { { "Assume an empty queue (EQ)", Constants.BESTCASE_EMPTY_QUEUE_YES },
						{ "Assume a full queue (FQ)", Constants.BESTCASE_EMPTY_QUEUE_NO } },
				getFieldEditorParent(), true);
		addField(bcEmptyQueue);
		BooleanFieldEditor dontShow = new BooleanFieldEditor(Constants.DONT_SHOW_DIALOG,
				"Don't show the settings dialog when analysis is executed", getFieldEditorParent());
		addField(dontShow);

//		RadioGroupFieldEditor reportSubtotals = new RadioGroupFieldEditor(Constants.REPORT_SUBTOTALS,
//				"Report Subtotals", 1,
//				new String[][] { { "Yes", Constants.REPORT_SUBTOTALS_YES }, { "No", Constants.REPORT_SUBTOTALS_NO } },
//				getFieldEditorParent(), true);
//		addField(reportSubtotals);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	@Override
	public void init(IWorkbench workbench) {
	}

	/**
	 * Adjust the layout of the field editors so that they are properly aligned.
	 */
	@Override
	protected void adjustGridLayout() {
		if (folder != null) {
			TabItem[] items = folder.getItems();
			for (int j = 0; j < items.length; j++) {
				GridLayout layout = ((GridLayout) ((Composite) items[j].getControl()).getLayout());
				layout.numColumns = 3;
				layout.marginHeight = 5;
				layout.marginWidth = 5;
			}
		}

		// need to call super.adjustGridLayout() since fieldEditor.adjustForNumColumns() is protected
		super.adjustGridLayout();

		// reset the main container to a single column
		((GridLayout) super.getFieldEditorParent().getLayout()).numColumns = 1;
	}

	/**
	 * Returns a parent composite for a field editor.
	 * <p>
	 * This value must not be cached since a new parent may be created each time this method called. Thus this method
	 * must be called each time a field editor is constructed.
	 * </p>
	 * @return a parent
	 */
	@Override
	protected Composite getFieldEditorParent() {
		if (folder == null || folder.getItemCount() == 0) {
			return super.getFieldEditorParent();
		}
		return (Composite) folder.getItem(folder.getItemCount() - 1).getControl();
	}

	/**
	 * Adds a tab to the page.
	 * @param text the tab label
	 */
	public void addTab(String text) {
		if (folder == null) {
			// initialize tab folder
			folder = new TabFolder(super.getFieldEditorParent(), SWT.NONE);
			folder.setLayoutData(new GridData(GridData.FILL_BOTH));
		}

		TabItem item = new TabItem(folder, SWT.NONE);
		item.setText(text);

		Composite currentTab = new Composite(folder, SWT.NULL);
		GridLayout layout = new GridLayout();
		currentTab.setLayout(layout);
		currentTab.setFont(super.getFieldEditorParent().getFont());
		currentTab.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		item.setControl(currentTab);
	}

}