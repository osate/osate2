package org.osate.ge.swt.list;

import java.util.Objects;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * View for editing a list of objects.
 *
 */
public class ListEditor extends Composite {
	private final ListEditorModel model;
	private final ListViewer listViewer;
	private final Button addButton;
	private final Button removeButton;

	public ListEditor(final Composite parent, final ListEditorModel model) {
		super(parent, SWT.NONE);
		this.model = Objects.requireNonNull(model, "model must not be null");
		this.setBackground(parent.getBackground());
		this.setLayout(GridLayoutFactory.fillDefaults().numColumns(2).create());

		this.listViewer = new ListViewer(this, model);
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

		model.changed().addListener(e -> refresh());
		refresh();
	}

	private void refresh() {
		this.removeButton.setEnabled(model.getSelectedElement() != null);
	}
}