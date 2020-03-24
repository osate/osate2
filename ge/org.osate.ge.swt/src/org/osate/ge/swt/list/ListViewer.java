package org.osate.ge.swt.list;

import java.util.Objects;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * Wrapper around JFace's {@link org.eclipse.jface.viewers.ListViewer} which uses a {@link ListViewerModel}
 *
 */
public class ListViewer extends Composite {
	private final ListViewerModel model;
	private final org.eclipse.jface.viewers.ListViewer listViewer;

	public ListViewer(final Composite parent, final ListViewerModel model) {
		super(parent, SWT.NONE);
		this.model = Objects.requireNonNull(model, "model must not be null");
		this.setBackground(parent.getBackground());
		this.setLayout(GridLayoutFactory.fillDefaults().numColumns(1).create());

		this.listViewer = new org.eclipse.jface.viewers.ListViewer(this);
		this.listViewer.getControl().setLayoutData(
				GridDataFactory.swtDefaults().span(2, 1).grab(true, true).align(SWT.FILL, SWT.FILL).create());
		this.listViewer.setComparator(new ViewerComparator());
		this.listViewer.setContentProvider((IStructuredContentProvider) inputElement -> model.getElements());
		this.listViewer.setInput(model);
		this.listViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return model.getLabel(element);
			}
		});

		this.listViewer.addSelectionChangedListener(event -> {
			final Object newSelection = this.listViewer.getStructuredSelection().getFirstElement();
			if (!Objects.equals(newSelection, model.getSelectedElement())) {
				model.setSelectedElement(newSelection);
			}
		});

		model.changed().addListener(e -> refresh());
		refresh();
	}

	private void refresh() {
		this.listViewer.refresh();
		this.listViewer.setSelection(
				model.getSelectedElement() == null ? null : new StructuredSelection(model.getSelectedElement()));
	}
}
