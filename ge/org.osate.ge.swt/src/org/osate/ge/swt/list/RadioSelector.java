package org.osate.ge.swt.list;

import java.util.Objects;
import java.util.function.Consumer;

import org.eclipse.jface.layout.RowLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.util.SwtTestUtil;

/**
 * Set of radio buttons which uses a {@link ListSelectorModel}
 *
 */
public class RadioSelector<T> extends Composite {
	private final ListSelectorModel<T> model;
	private final Consumer<ChangeEvent> changeListener = e -> refresh();

	public RadioSelector(final Composite parent, final ListSelectorModel<T> model) {
		super(parent, SWT.NONE);
		this.model = Objects.requireNonNull(model, "model must not be null");
		this.setBackground(parent.getBackground());
		this.setLayout(RowLayoutFactory.fillDefaults().wrap(false).create());

		model.changed().addListener(changeListener);
		refresh();
	}

	private void refresh() {
		for (final Control child : getChildren()) {
			child.dispose();
		}

		final Object value = model.getSelectedElement();

		// Create new buttons
		for (final T element : model.getElements()) {
			final Button btn = new Button(this, SWT.RADIO);
			btn.setBackground(getBackground());
			btn.setText(model.getLabel(element));
			btn.setData(element);
			btn.setSelection(element == value);
			btn.addSelectionListener(selectionListener);
		}

		setEnabled(model.isEnabled());
		requestLayout();
	}

	@Override
	public void setEnabled(final boolean enabled) {
		super.setEnabled(enabled);

		for (final Control c : getChildren()) {
			c.setEnabled(enabled);
		}
	}

	private final SelectionListener selectionListener = new SelectionAdapter() {
		@SuppressWarnings("unchecked")
		@Override
		public void widgetSelected(SelectionEvent e) {
			final Button btn = (Button) e.widget;
			if (btn.getSelection()) {
				model.setSelectedElement((T) e.widget.getData());
			}
		}
	};

	public static void main(String[] args) {
		SwtTestUtil.run(shell -> {
			new RadioSelector<>(shell, new TestListEditorModel());
		});
	}
}
