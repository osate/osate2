package org.osate.assure.ui.views;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.osate.alisa.workbench.alisa.AssuranceCase;
import org.osate.alisa.workbench.alisa.AssurancePlan;

public class AlisaTreeViewer extends TreeViewer {
	public AlisaTreeViewer(Composite parent, int style) {
		super(parent, style);
		buildViewer();
		setUseHashlookup(true);
	}

	private void buildViewer() {
		// NEED this to activate tooltip
		ColumnViewerToolTipSupport.enableFor(this);

		setContentProvider(new AlisaTreeContentProvider());

		TreeViewerColumn viewerColumn = new TreeViewerColumn(this, SWT.NONE);

		viewerColumn.getColumn().setWidth(500);
		viewerColumn.getColumn().setMoveable(false);
		viewerColumn.getColumn().setText("Name");
		viewerColumn.getColumn().setResizable(true);

		viewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof AssuranceCase) {
					return "Assurance Case: " + ((AssuranceCase)element).getName();
				} else if (element instanceof AssurancePlan) {
					return "Assurance Plan: " + ((AssurancePlan)element).getName();
				} else {
					return "";
				}
			}
		});

		// Turn on the header and the lines
		getTree().setHeaderVisible(true);
		getTree().setLinesVisible(true);
	}
}