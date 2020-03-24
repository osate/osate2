package org.osate.ge.swt.list;

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
 * View for editing a list of objects.
 *
 * Sorts items provided by model.
 */
public class ListEditor<T> extends Composite {
	private final ListEditorModel<T> model;
	private final ListSelector<T> listViewer;
	private final Button addButton;
	private final Button removeButton;
	private final Consumer<ChangeEvent> changeListener = e -> refresh();

	public ListEditor(final Composite parent, final ListEditorModel<T> model) {
		super(parent, SWT.NONE);
		this.model = Objects.requireNonNull(model, "model must not be null");
		this.setBackground(parent.getBackground());
		this.setLayout(GridLayoutFactory.fillDefaults().numColumns(2).create());

		this.listViewer = new ListSelector<>(this, model);
		this.listViewer.setLayoutData(
				GridDataFactory.swtDefaults().span(2, 1).grab(true, true).align(SWT.FILL, SWT.FILL).create());

		//
		// Add and remove buttons
		//
		this.addButton = new Button(this, SWT.FLAT);
		this.addButton.setText("Add");
		this.addButton.setLayoutData(
				GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).create());
		this.addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				model.addElement();
			}
		});

		this.removeButton = new Button(this, SWT.FLAT);
		this.removeButton.setText("Remove");
		this.removeButton.setLayoutData(
				GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).create());
		this.removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (model.getSelectedElement() != null) {
					model.removeElement(model.getSelectedElement());
				}
			}
		});

		model.changed().addListener(changeListener);

		refresh();
	}

	private void refresh() {
		this.removeButton.setEnabled(model.getSelectedElement() != null);
	}

	public static void main(String[] args) {
		SwtTestUtil.run(shell -> {
			new ListEditor<>(shell, new TestListEditorModel());
		});
	}
}