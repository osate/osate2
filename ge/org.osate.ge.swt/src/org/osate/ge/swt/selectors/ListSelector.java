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
import org.osate.ge.swt.DefaultEventSource;
import org.osate.ge.swt.EventSource;
import org.osate.ge.swt.util.SwtTestUtil;

/**
 * Wrapper around JFace's {@link org.eclipse.jface.viewers.ListViewer} which uses a {@link SelectorModel}
 *
 * Allows selecting a single element. Sorts items provided by model.
 */
public final class ListSelector<T> extends Composite implements SelectionDoubleClickedEventGenerator {
	private final SelectorModel<Object> wrappedModel;
	private final org.eclipse.jface.viewers.ListViewer listViewer;
	private final Consumer<ChangeEvent> changeListener = e -> refresh();
	private final DefaultEventSource<SelectionDoubleClickedEvent> selectionDoubleClickedEventSrc = new DefaultEventSource<>();

	/**
	 * Creates a {@link ListSelector}.
	 * @param parent the container to which to add the widget.
	 * @param model the view model for the widget.
	 */
	public ListSelector(final Composite parent, final SelectorModel<T> model) {
		super(parent, SWT.NONE);
		this.wrappedModel = new NullRemovingSelectorModel(Objects.requireNonNull(model, "model must not be null"));
		this.setBackground(parent.getBackground());
		this.setLayout(GridLayoutFactory.fillDefaults().numColumns(1).create());

		this.listViewer = new org.eclipse.jface.viewers.ListViewer(this,
				SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		this.listViewer.getControl().setLayoutData(
				GridDataFactory.swtDefaults().span(2, 1).grab(true, true).align(SWT.FILL, SWT.FILL).create());
		this.listViewer.setComparator(new ViewerComparator());
		this.listViewer
				.setContentProvider((IStructuredContentProvider) inputElement -> wrappedModel.getElements().toArray());
		this.listViewer.setInput(this.wrappedModel);
		this.listViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return wrappedModel.getLabel(element);
			}
		});

		this.listViewer.addSelectionChangedListener(event -> {
			@SuppressWarnings("unchecked")
			final T newSelection = (T) this.listViewer.getStructuredSelection().getFirstElement();
			if (newSelection != null && !Objects.equals(newSelection, wrappedModel.getSelectedElement())) {
				wrappedModel.setSelectedElement(newSelection);
			}
		});

		this.listViewer.addDoubleClickListener(
				event -> selectionDoubleClickedEventSrc.triggerEvent(new SelectionDoubleClickedEvent()));

		wrappedModel.changed().addListener(changeListener);
		refresh();
	}

	@Override
	public EventSource<SelectionDoubleClickedEvent> selectionDoubleClicked() {
		return selectionDoubleClickedEventSrc;
	}

	private void refresh() {
		if (!this.isDisposed()) {
			this.listViewer.refresh();

			// Avoid attempting to select an element that is not in the selector. Will result in a stack overflow while trying to synchronize the selection with
			// the model.
			final Object selectedElement = wrappedModel.getSelectedElement();
			final boolean selectionAvailable = this.wrappedModel.getElements()
					.anyMatch(e -> Objects.equals(e, selectedElement));
			this.listViewer.setSelection(
					selectionAvailable ? new StructuredSelection(wrappedModel.getSelectedElement()) : null);

			setEnabled(wrappedModel.isEnabled());
		}
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
