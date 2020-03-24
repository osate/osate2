package org.osate.ge.swt.list;

import java.util.Objects;
import java.util.function.Consumer;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.util.SwtTestUtil;

/**
 * Wrapper around JFace's {@link org.eclipse.jface.viewers.ListViewer} which uses a {@link ListSelectorModel}
 *
 * Sorts items provided by model.
 */
public class ListSelector<T> extends Composite {
	private final ListSelectorModel<T> model;
	private final org.eclipse.jface.viewers.ListViewer listViewer;
	private final Consumer<ChangeEvent> changeListener = e -> refresh();

	public ListSelector(final Composite parent, final ListSelectorModel<T> model) {
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
			@SuppressWarnings("unchecked")
			@Override
			public String getText(Object element) {
				return model.getLabel((T) element);
			}
		});

		this.listViewer.addSelectionChangedListener(event -> {
			@SuppressWarnings("unchecked")
			final T newSelection = (T)this.listViewer.getStructuredSelection().getFirstElement();
			if (!Objects.equals(newSelection, model.getSelectedElement())) {
				model.setSelectedElement(newSelection);
			}
		});

		model.changed().addListener(changeListener);
		refresh();
	}

	private void refresh() {
		this.listViewer.refresh();
		this.listViewer.setSelection(
				model.getSelectedElement() == null ? null : new StructuredSelection(model.getSelectedElement()));
		setEnabled(model.isEnabled());
	}

	@Override
	public void setEnabled(final boolean enabled) {
		super.setEnabled(enabled);
		listViewer.getControl().setEnabled(enabled);
	}

	public static void main(String[] args) {
		SwtTestUtil.run(shell -> {
			new ListSelector<>(shell, new TestListEditorModel());
		});
	}
}
