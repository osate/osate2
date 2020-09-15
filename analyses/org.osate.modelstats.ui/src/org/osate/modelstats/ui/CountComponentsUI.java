package org.osate.modelstats.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.osate.aadl2.ComponentCategory;
import org.osate.modelstats.ElementsCounts;

public class CountComponentsUI extends Dialog {
	private final static String COMPONENTS_NODE = "Components";
	private final static String CONNECTIONS_NODE = "Connections";
	private final static String ETEF_NODE = "End to End Flows";
	private final String actionName;
	private final String fileName;
	private final ElementsCounts elementsCounts;

	// constructor
	protected CountComponentsUI(Shell parentShell, String fileName, String actionName, ElementsCounts elementCounts) {
		super(parentShell);
		this.elementsCounts = elementCounts;
		this.actionName = actionName;
		this.fileName = fileName;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		composite.getShell().setText(actionName);

		Label infoLabel = new Label(composite, SWT.NONE);
		infoLabel.setText("Model element counts for " + fileName);

		TreeViewer viewer = new TreeViewer(composite);
		viewer.setComparator(new ViewerComparator());
		viewer.getTree().setHeaderVisible(true);
		viewer.getTree().setLinesVisible(true);
		viewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		viewer.setContentProvider(new ViewContentProvider());

		// how component column is created
		TreeViewerColumn componentNameColumn = new TreeViewerColumn(viewer, SWT.NONE);
		componentNameColumn.getColumn().setWidth(convertWidthInCharsToPixels(25));
		componentNameColumn.getColumn().setResizable(true);
		componentNameColumn.getColumn().setText("Model Elements");
		componentNameColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof String) {
					return element.toString();
				} else if (element instanceof ComponentCategory) {
					String compName = ((ComponentCategory) element).getName();
					return compName.substring(0, 1).toUpperCase() + compName.substring(1);
				} else {
					return null;
				}
			}
		});

		// how count column is created
		TreeViewerColumn countNameColumn = new TreeViewerColumn(viewer, SWT.NONE);
		countNameColumn.getColumn().setWidth(convertWidthInCharsToPixels(15));
		countNameColumn.getColumn().setResizable(true);
		countNameColumn.getColumn().setText("Counts");
		countNameColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof ComponentCategory) {
					return elementsCounts.getComponentCountMap().get(element).toString();
				} else if (element == COMPONENTS_NODE) {
					return Integer.toString(elementsCounts.getTotalComponentCount());
				} else if (element == CONNECTIONS_NODE) {
					return Integer.toString(elementsCounts.getConnectionsCount());
				} else if (element == ETEF_NODE) {
					return Integer.toString(elementsCounts.getEndToEndFlowsCount());
				}
				return null;
			}
		});
		viewer.setInput(elementsCounts);
		return composite;
	}

	// Override the original to remove the cancel option
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
	}

	// overrides the original so that the window can be resized
	@Override
	protected boolean isResizable() {
		return true;
	}

	private class ViewContentProvider implements ITreeContentProvider {
		@Override
		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof ElementsCounts) {
				List<Object> list = new ArrayList<Object>();
				list.add(COMPONENTS_NODE);
				if (((ElementsCounts) parentElement).getConnectionsCount() != 0) {
					list.add(CONNECTIONS_NODE);
				}
				if (((ElementsCounts) parentElement).getEndToEndFlowsCount() != 0) {
					list.add(ETEF_NODE);
				}
				return list.toArray();
			} else if (parentElement == COMPONENTS_NODE) {
				return elementsCounts.getComponentCountMap().keySet().toArray();
			} else {
				return null;
			}
		}

		@Override
		public Object getParent(Object element) {
			if (element instanceof ComponentCategory) {
				return COMPONENTS_NODE;
			} else if (element instanceof String) {
				return elementsCounts;
			}
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			return element == COMPONENTS_NODE;
		}
	}
}
