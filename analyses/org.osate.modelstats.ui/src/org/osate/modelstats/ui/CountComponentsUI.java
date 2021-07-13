/*******************************************************************************
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
 *******************************************************************************/
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
