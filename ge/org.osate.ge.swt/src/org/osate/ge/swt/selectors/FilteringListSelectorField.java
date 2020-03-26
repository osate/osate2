package org.osate.ge.swt.selectors;

import java.util.Objects;
import java.util.function.Consumer;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.util.SwtTestUtil;

/**
 * A selector which combines a text field for displaying the label of the current selection and {@link FilteringSelectorDialog}.
 *
 * @param <T> is the type of the element being selected.
 */
public final class FilteringListSelectorField<T> extends Composite {
	private final FilteringSelectorModel<T> model;
	private final CLabel selectedLbl;
	private final Button chooseBtn;
	private final Consumer<ChangeEvent> changeListener = e -> refresh();

	public FilteringListSelectorField(final Composite parent, final FilteringSelectorModel<T> model) {
		super(parent, SWT.NONE);
		this.model = Objects.requireNonNull(model, "model must not be null");
		this.setBackground(parent.getBackground());
		this.setLayout(GridLayoutFactory.fillDefaults().numColumns(2).create());

		this.selectedLbl = new CLabel(this, SWT.BORDER);
		this.selectedLbl
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER)
						.create());

		this.chooseBtn = new Button(this, SWT.FLAT);
		this.chooseBtn
				.setLayoutData(GridDataFactory.swtDefaults().grab(false, false).align(SWT.CENTER, SWT.CENTER).create());
		this.chooseBtn.setText("Choose...");
		this.chooseBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				FilteringSelectorDialog.open(getShell(), "Select", model);
			}
		});

		model.changed().addListener(changeListener);

		refresh();
	}

	private void refresh() {
		if (!this.isDisposed()) {
			selectedLbl.setText(model.getLabel(model.getSelectedElement()));
			setEnabled(model.isEnabled());
		}
	}

	@Override
	public void setEnabled(final boolean enabled) {
		super.setEnabled(enabled);
		chooseBtn.setEnabled(enabled && model.getElements().anyMatch(e -> true));
	}

	public static void main(String[] args) {
		SwtTestUtil.run(shell -> {
			new FilteringListSelectorField<>(shell, new LabelFilteringListSelectorModel<>(new TestListEditorModel()));
		});
	}
}
