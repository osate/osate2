package org.osate.ui.internal.preferences;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osate.internal.ui.preferences.ContributedResourcesPreferencePage.FileLabelProvider;
import org.osate.internal.ui.preferences.ContributedResourcesPreferencePage.Sorter;
import org.osate.internal.ui.preferences.ContributedResourcesPreferencePage.TreeContentProvider;
import org.osate.internal.ui.preferences.ContributedResourcesPreferencePage.TreeNode;
import org.osate.ui.utils.PropertySetModel;

/**
 * This class represents the OSATE > Property Set workspace preferences.
 * @since 6.0
 */
public class IgnoredPropertySetPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	private TreeViewer tree;
	private Button addButton, resetButton, deleteButton;
	private TreeNode selectedNode;

	public IgnoredPropertySetPreferencePage() {
		super("Property Sets");
	}

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

	@Override
	protected Control createContents(Composite parent) {
		// get all property set names that were previously added by user
		List<String> addedNames = PropertySetModel.getAllAddedPropertySetNames();

		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(3, true));

		SashForm sashForm = new SashForm(composite, SWT.HORIZONTAL);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);
		sashForm.setLayoutData(gd);
		initializeDialogUnits(sashForm);

		tree = createTree(sashForm);
		tree.setLabelProvider(new FileLabelProvider(null, null));
		tree.setContentProvider(new TreeContentProvider());
		tree.setAutoExpandLevel(3);

		tree.setInput(createTreeHierarchy());
		tree.setComparator(new ViewerComparator());

		Sorter sort = new Sorter();
		tree.setSorter(sort);

		tree.addSelectionChangedListener(event -> {
			IStructuredSelection selection = (IStructuredSelection) event.getSelection();

			if (selection.isEmpty()) {
				deleteButton.setEnabled(false);
			}

			for (final Iterator<?> iter = selection.iterator(); iter.hasNext();) {
				final Object object = iter.next();
				if (object instanceof TreeNode) {
					selectedNode = (TreeNode) object;
					deleteButton.setEnabled(true);
				}
			}
		});
		tree.addDoubleClickListener(event -> {
			final TreeViewer viewer = (TreeViewer) event.getViewer();
			final IStructuredSelection thisSelection = (IStructuredSelection) event.getSelection();
			final TreeNode selectedNode = (TreeNode) thisSelection.getFirstElement();
			if (selectedNode != null) {
				if (selectedNode.getNode().isEmpty()) {
					// doOverrideAction(selectedNode);
				} else {
					viewer.setExpandedState(selectedNode, !viewer.getExpandedState(selectedNode));
				}
			}
		});

		addButton = new Button(composite, SWT.PUSH);
		addButton.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, false, false));
		addButton.setText("Add Property Set to be ignored");
		addButton.setToolTipText("Add Property Set name that will be ignored in the workspace.");
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (selectedNode != null) {
					// add to preferences
				}
			}
		});

		deleteButton = new Button(composite, SWT.PUSH);
		deleteButton.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, false, false));
		deleteButton.setText("Delete Property Set from ignored list");
		deleteButton.setToolTipText("Delete Property Set from ignored list in the workspace.");
		deleteButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (selectedNode != null) {
					// delete this string from preferences
				}
			}
		});

		resetButton = new Button(composite, SWT.PUSH);
		resetButton.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false));
		resetButton.setText("Reset");
		resetButton.setToolTipText("Reset property set settings to use all property sets.");
		resetButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				// delete the list of strings
			}
		});

		return composite;
	}
}