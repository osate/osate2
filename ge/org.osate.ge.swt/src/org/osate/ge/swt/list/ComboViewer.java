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
 * Wrapper around JFace's {@link org.eclipse.jface.viewers.ComboViewer} which uses a {@link ListViewerModel}
 *
 */
public class ComboViewer extends Composite {
	private final ListViewerModel model;
	private final org.eclipse.jface.viewers.ComboViewer comboViewer;

	public ComboViewer(final Composite parent, final ListViewerModel model) {
		super(parent, SWT.NONE);
		this.model = Objects.requireNonNull(model, "model must not be null");
		this.setBackground(parent.getBackground());
		this.setLayout(GridLayoutFactory.fillDefaults().numColumns(1).create());

		this.comboViewer = new org.eclipse.jface.viewers.ComboViewer(this);
		this.comboViewer.getControl().setLayoutData(
				GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).create());
		this.comboViewer.setComparator(new ViewerComparator());
		this.comboViewer.setContentProvider((IStructuredContentProvider) inputElement -> model.getElements());
		this.comboViewer.setInput(model);
		this.comboViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return model.getLabel(element);
			}
		});

		// Listen to selection changes
		this.comboViewer.addSelectionChangedListener(event -> {
			final Object newSelection = this.comboViewer.getStructuredSelection().getFirstElement();
			if (!Objects.equals(newSelection, model.getSelectedElement())) {
				model.setSelectedElement(newSelection);
				refresh();
			}
		});

		model.changed().addListener(e -> refresh());
		refresh();
	}

	private void refresh() {
		this.comboViewer.refresh();
		this.comboViewer.setSelection(
				model.getSelectedElement() == null ? null : new StructuredSelection(model.getSelectedElement()));
	}
}
