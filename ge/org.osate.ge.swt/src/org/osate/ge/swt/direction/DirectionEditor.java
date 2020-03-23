package org.osate.ge.swt.direction;

import java.util.Objects;

import org.eclipse.jface.layout.RowLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.osate.ge.swt.util.SwtTestUtil;

// TODO; Feature direction? Also prototype feature.
/**
 * View for editing a feature direction.
 *
 */
public class DirectionEditor extends Composite {
	private final DirectionEditorModel model;
	private final Button inBtn;
	private final Button outBtn;
	private final Button inOutBtn;

	public DirectionEditor(final Composite parent, final DirectionEditorModel model) {
		super(parent, SWT.NONE);
		this.model = Objects.requireNonNull(model, "model must not be null");
		this.setBackground(parent.getBackground());

		setLayout(RowLayoutFactory.fillDefaults().wrap(false).create());

		final SelectionListener selectionListener = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final Button btn = (Button) e.widget;
				if (btn.getSelection()) {
					final Direction newDirection = (Direction) e.widget.getData();
					model.setDirection(newDirection);
				}
			}
		};

		inBtn = new Button(this, SWT.RADIO);
		inBtn.setBackground(getBackground());
		inBtn.setText("Input");
		inBtn.setData(Direction.IN);
		inBtn.addSelectionListener(selectionListener);

		outBtn = new Button(this, SWT.RADIO);
		outBtn.setBackground(getBackground());
		outBtn.setText("Output");
		outBtn.setData(Direction.OUT);
		outBtn.addSelectionListener(selectionListener);

		inOutBtn = new Button(this, SWT.RADIO);
		inOutBtn.setBackground(getBackground());
		inOutBtn.setText("Bidirectional");
		inOutBtn.setData(Direction.IN_OUT);
		inOutBtn.addSelectionListener(selectionListener);

		model.changed().addListener(e -> refresh());

		refresh();
	}

	private void refresh() {
		final Direction value = model.getDirection();
		inBtn.setSelection(inBtn.getData() == value);
		outBtn.setSelection(outBtn.getData() == value);
		inOutBtn.setSelection(inOutBtn.getData() == value);

		setEnabled(model.isEnabled());
	}

	@Override
	public void setEnabled(final boolean enabled) {
		super.setEnabled(enabled);
		inBtn.setEnabled(enabled);
		outBtn.setEnabled(enabled);
		inOutBtn.setEnabled(enabled);
	}

	public static void main(String[] args) {
		SwtTestUtil.run(shell -> {
			new DirectionEditor(shell, new TestDirectionEditorModel());
		});
	}
}
