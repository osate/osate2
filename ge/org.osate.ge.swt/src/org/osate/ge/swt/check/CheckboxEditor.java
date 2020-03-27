package org.osate.ge.swt.check;

import java.util.Objects;
import java.util.function.Consumer;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.util.SwtTestUtil;

/**
 * A view that contains a checkbox for editing a boolean value.
 *
 */
public class CheckboxEditor extends Composite {
	private final CheckboxEditorModel model;
	private final Button check;
	private final Consumer<ChangeEvent> changeListener = e -> refresh();

	public CheckboxEditor(final Composite parent, final CheckboxEditorModel model) {
		super(parent, SWT.NONE);
		this.model = Objects.requireNonNull(model, "model must not be null");
		this.setBackground(parent.getBackground());
		this.setLayout(GridLayoutFactory.fillDefaults().numColumns(1).create());

		check = new Button(this, SWT.CHECK);
		check.setBackground(getBackground());
		check.setLayoutData(
				GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.FILL).create());
		check.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				model.setValue(check.getSelection());
				refresh();
			}
		});

		model.changed().addListener(changeListener);

		refresh();
	}

	private void refresh() {
		if (!this.isDisposed()) {
			check.setText(model.getLabel());

			final Boolean value = model.getValue();
			check.setSelection(value == null || value == Boolean.TRUE);
			check.setGrayed(value == null);
			setEnabled(model.isEnabled());
		}
	}

	@Override
	public void setEnabled(final boolean enabled) {
		super.setEnabled(enabled);
		check.setEnabled(enabled);
	}

	public static void main(String[] args) {
		SwtTestUtil.run(shell -> {
			new CheckboxEditor(shell, new TestCheckboxEditorModel());
		});
	}

}
