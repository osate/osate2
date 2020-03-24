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
 * Wrapper around JFace's {@link org.eclipse.jface.viewers.ComboViewer} which uses a {@link ListSelectorModel}
 *
 * Sorts items provided by model.
 */
public class ComboSelector<T> extends Composite {
	private final ListSelectorModel<T> model;
	private final org.eclipse.jface.viewers.ComboViewer comboViewer;
	private final Consumer<ChangeEvent> changeListener = e -> refresh();

	public ComboSelector(final Composite parent, final ListSelectorModel<T> model) {
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
			@SuppressWarnings("unchecked")
			@Override
			public String getText(Object element) {
				return model.getLabel((T) element);
			}
		});

		// Listen to selection changes
		this.comboViewer.addSelectionChangedListener(event -> {
			@SuppressWarnings("unchecked")
			final T newSelection = (T)this.comboViewer.getStructuredSelection().getFirstElement();
			if (!Objects.equals(newSelection, model.getSelectedElement())) {
				model.setSelectedElement(newSelection);
				refresh();
			}
		});

		model.changed().addListener(changeListener);

		refresh();
	}

	private void refresh() {
		this.comboViewer.refresh();
		this.comboViewer.setSelection(
				model.getSelectedElement() == null ? null : new StructuredSelection(model.getSelectedElement()));
		setEnabled(model.isEnabled());
	}

	@Override
	public void setEnabled(final boolean enabled) {
		super.setEnabled(enabled);
		comboViewer.getControl().setEnabled(enabled);
	}

	public static void main(String[] args) {
		SwtTestUtil.run(shell -> {
			new ComboSelector<>(shell, new TestListEditorModel());
		});
	}
}
