/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil. Contributions by Peter Feiler.                                               *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.ui.views.filter;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.osate.aadl2.util.OsateDebug;
import org.osate.imv.model.ElementInhibitStatus;
import org.osate.imv.ui.util.EmulatedNativeCheckBoxLabelProvider;

public class FilterPanel extends Composite {

	private TableViewer tableViewer;

	private Font labelFont;
	private Color enabledLabelColor;

	public FilterPanel(Composite parent, int style, String title) {
		super(parent, style);

		// Set layout.
		this.setLayout(new FillLayout());

		// Create table viewer.
		tableViewer = createTableViewer(this, title);
		// Content provider.
		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
	}

	protected TableViewer createTableViewer(Composite parent, String title) {
		final TableViewer viewer = new TableViewer(parent, SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL
				| SWT.FULL_SELECTION);

		// Configure table.
		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(false);

		// Table layout.
		TableColumnLayout columnLayout = new TableColumnLayout();
		parent.setLayout(columnLayout);

		// Set foreground color based on feature inhibit status.
		viewer.getTable().addListener(SWT.EraseItem, new Listener() {

			@Override
			public void handleEvent(Event event) {
				TableItem item = (TableItem) event.item;
				ElementInhibitStatus status = (ElementInhibitStatus) item.getData();
				if (status != null) {
					if (status.isInhibited())
						item.setForeground(ColorConstants.red);
					else
						item.setForeground(enabledLabelColor);
				}
			}
		});

		// The first column contains a check box used for setting the feature category inhibit status.
		TableViewerColumn col = createTableViewerColumn(title, 0, 100, viewer, columnLayout);
		// The first column contains a check box used for setting the feature category inhibit status.
		col.setLabelProvider(new EmulatedNativeCheckBoxLabelProvider(col.getViewer()) {

			@Override
			protected boolean isChecked(Object element) {
				return !((ElementInhibitStatus) element).isInhibited();
			}

			public String getText(Object element) {
				String label = "";
				if (element instanceof ElementInhibitStatus)
					label = ((ElementInhibitStatus) element).toString();

				return label;
			}

		});

		col.setEditingSupport(new EditingSupport(viewer) {

			@Override
			protected CellEditor getCellEditor(Object element) {
				return new CheckboxCellEditor(viewer.getTable());
			}

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}

			@Override
			protected Object getValue(Object element) {
				return !((ElementInhibitStatus) element).isInhibited();
			}

			@Override
			protected void setValue(Object element, Object value) {
				((ElementInhibitStatus) element).setInhibited(!((Boolean) value).booleanValue());
//				System.out.println("Checkbox changed state");
				OsateDebug.osateDebug("FilterPanel", "Checkbox changed state");
				viewer.refresh();
			}

		});

		return viewer;
	}

	protected TableViewerColumn createTableViewerColumn(String title, final int columnNumber, int weight,
			TableViewer viewer, TableColumnLayout columnLayout) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		columnLayout.setColumnData(column, new ColumnWeightData(weight));
		column.setMoveable(false);
		column.setText(title);
		column.setAlignment(SWT.CENTER);

		return viewerColumn;
	}

	@Override
	public boolean setFocus() {
		return tableViewer.getControl().setFocus();
	}

	@Override
	public void dispose() {
		/* Release OS resources */
		if (labelFont != null)
			labelFont.dispose();

		if (enabledLabelColor != null)
			enabledLabelColor.dispose();

		super.dispose();
	}

	public void setInput(Object input) {
		// Set feature category list as the table input.
		this.tableViewer.setInput(input);
	}
}
