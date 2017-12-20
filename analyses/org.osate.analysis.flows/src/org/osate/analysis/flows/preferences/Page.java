package org.osate.analysis.flows.preferences;

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
		setDescription("Configuration for the Latency Analysis Plugin");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	@Override
	public void createFieldEditors() {
		RadioGroupFieldEditor synchronousSystem = new RadioGroupFieldEditor(Constants.SYNCHRONOUS_SYSTEM,
				"Treat as synchronous or asynchronous system", 1,
				new String[][] { { "Asynchronous system (AS)", Constants.SYNCHRONOUS_SYSTEM_NO },
			{ "Synchronous system (SS)", Constants.SYNCHRONOUS_SYSTEM_YES } },
				getFieldEditorParent(), true);
		addField(synchronousSystem);
		RadioGroupFieldEditor partitioningPolicy = new RadioGroupFieldEditor(Constants.PARTITONING_POLICY,
				"Partition Output Policy", 1,
				new String[][] { { "Partition End (PE)", Constants.PARTITIONING_POLICY_PARTITION_END_STR },
			{ "Major Frame Delayed (MF)", Constants.PARTITIONING_POLICY_MAJOR_FRAME_DELAYED_STR } },
				getFieldEditorParent(), true);
		addField(partitioningPolicy);
		RadioGroupFieldEditor worstCaseDeadline = new RadioGroupFieldEditor(Constants.WORST_CASE_DEADLINE,
				"For worst-case processing time use", 1,
				new String[][] { { "Deadline (DL)", Constants.WORST_CASE_DEADLINE_YES },
			{ "Maximum compute execution time (ET)", Constants.WORST_CASE_DEADLINE_NO } },
				getFieldEditorParent(), true);
		addField(worstCaseDeadline);
		RadioGroupFieldEditor bcEmptyQueue = new RadioGroupFieldEditor(Constants.BESTCASE_EMPTY_QUEUE,
				"Best case queuing latency on incoming ports", 1,
				new String[][] { { "Assume empty queue (EQ)", Constants.BESTCASE_EMPTY_QUEUE_YES },
			{ "Assume full queue (FQ)", Constants.BESTCASE_EMPTY_QUEUE_NO } },
				getFieldEditorParent(), true);
		addField(bcEmptyQueue);
		RadioGroupFieldEditor reportSubtotals = new RadioGroupFieldEditor(Constants.REPORT_SUBTOTALS,
				"Report Subtotals", 1,
				new String[][] { { "Yes", Constants.REPORT_SUBTOTALS_YES }, { "No", Constants.REPORT_SUBTOTALS_NO } },
				getFieldEditorParent(), true);
		addField(reportSubtotals);
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