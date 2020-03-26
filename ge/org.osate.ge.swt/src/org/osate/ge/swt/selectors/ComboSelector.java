package org.osate.ge.swt.selectors;

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
 * Wrapper around JFace's {@link org.eclipse.jface.viewers.ComboViewer} which uses a {@link SelectorModel}
 *
 * Sorts items provided by model.
 */
public final class ComboSelector<T> extends Composite {
	private final NullRemovingSelectorModel wrappedModel;
	private final org.eclipse.jface.viewers.ComboViewer comboViewer;
	private final Consumer<ChangeEvent> changeListener = e -> refresh();

	public ComboSelector(final Composite parent, final SelectorModel<T> model) {
		super(parent, SWT.NONE);
		this.wrappedModel = new NullRemovingSelectorModel(Objects.requireNonNull(model, "model must not be null"));
		this.setBackground(parent.getBackground());
		this.setLayout(GridLayoutFactory.fillDefaults().numColumns(1).create());

		this.comboViewer = new org.eclipse.jface.viewers.ComboViewer(this);
		this.comboViewer.getControl()
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).create());
		this.comboViewer.setComparator(new ViewerComparator());
		this.comboViewer.setContentProvider(
				(IStructuredContentProvider) inputElement -> this.wrappedModel.getElements().toArray());
		this.comboViewer.setInput(this.wrappedModel);
		this.comboViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return wrappedModel.getLabel(element);
			}
		});

		// Listen to selection changes
		this.comboViewer.addSelectionChangedListener(event -> {
			@SuppressWarnings("unchecked")
			final T newSelection = (T) this.comboViewer.getStructuredSelection().getFirstElement();
			if (newSelection != null && !Objects.equals(newSelection, this.wrappedModel.getSelectedElement())) {
				this.wrappedModel.setSelectedElement(newSelection);
				refresh();
			}
		});

		this.wrappedModel.changed().addListener(changeListener);

		refresh();
	}

	private void refresh() {
		if (!this.isDisposed()) {
			this.comboViewer.refresh();

			// Avoid attempting to select an element that is not in the selector. Will result in a stack overflow while trying to synchronize the selection with
			// the model.
			final Object selectedElement = wrappedModel.getSelectedElement();
			final boolean selectionAvailable = this.wrappedModel.getElements()
					.anyMatch(e -> Objects.equals(e, selectedElement));
			this.comboViewer.setSelection(
					selectionAvailable ? new StructuredSelection(wrappedModel.getSelectedElement()) : null);

			setEnabled(wrappedModel.isEnabled());
		}
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
