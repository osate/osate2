package org.osate.ge.swt.list;

import java.util.Objects;
import java.util.function.Consumer;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.util.SwtTestUtil;

/**
 * A selector which combines a text field for user specified filtering with a {@link ListSelector}
 *
 */
public class FilteringListSelector<T> extends Composite {
	private final FilterableListSelectorModel<T> model;
	private final CLabel prompt;
	private final Text filterField;
	private final ListSelector<T> listViewer;
	private final Consumer<ChangeEvent> changeListener = e -> refresh();

	public FilteringListSelector(final Composite parent, final FilterableListSelectorModel<T> model) {
		super(parent, SWT.NONE);
		this.model = Objects.requireNonNull(model, "model must not be null");
		this.setBackground(parent.getBackground());
		this.setLayout(GridLayoutFactory.fillDefaults().numColumns(1).create());

		// Caption
		prompt = new CLabel(this, SWT.NONE);
		prompt.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.FILL).create());

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
		// Update the UI. The inner list viewer handles its own refresh
		prompt.setText(model.getPrompt());

		if (!Objects.equals(filterField.getText(), model.getFilter())) {
			filterField.setText(model.getFilter());
		}
	}

	public static void main(String[] args) {
		SwtTestUtil.run(shell -> {
			new FilteringListSelector<>(shell, new LabelFilteringListSelectorModel<>(new TestListEditorModel()));
		});
	}
}
