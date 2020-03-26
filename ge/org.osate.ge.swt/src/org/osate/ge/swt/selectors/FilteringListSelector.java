package org.osate.ge.swt.selectors;

import java.util.Objects;
import java.util.function.Consumer;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.EventSource;
import org.osate.ge.swt.util.SwtTestUtil;

/**
 * A selector which combines a text field for user specified filtering with a {@link ListSelector}
 *
 */
public final class FilteringListSelector<T> extends Composite implements SelectionDoubleClickedEventGenerator {
	private final FilteringSelectorModel<T> model;
	private final Text filterField;
	private final ListSelector<T> listViewer;
	private final Consumer<ChangeEvent> changeListener = e -> refresh();

	public FilteringListSelector(final Composite parent, final FilteringSelectorModel<T> model) {
		super(parent, SWT.NONE);
		this.model = Objects.requireNonNull(model, "model must not be null");
		this.setBackground(parent.getBackground());
		this.setLayout(GridLayoutFactory.fillDefaults().numColumns(1).create());

		// Field field to specify filter
		filterField = new Text(this, SWT.SINGLE | SWT.BORDER);
		filterField.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.FILL).create());
		filterField.addModifyListener(e -> {
			model.setFilter(filterField.getText());
		});

		// List of options
		this.listViewer = new ListSelector<>(this, model);
		this.listViewer
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).create());

		model.changed().addListener(changeListener);

		refresh();
	}

	private void refresh() {
		if (!this.isDisposed()) {
			// Update the UI. The inner list viewer handles its own refresh
			if (!Objects.equals(filterField.getText(), model.getFilter())) {
				filterField.setText(model.getFilter());
			}
		}
	}

	public static void main(String[] args) {
		SwtTestUtil.run(shell -> {
			new FilteringListSelector<>(shell, new LabelFilteringListSelectorModel<>(new TestListEditorModel()));
		});
	}

	@Override
	public EventSource<SelectionDoubleClickedEvent> selectionDoubleClicked() {
		return listViewer.selectionDoubleClicked();
	}
}
