package org.osate.ge.swt.name;

import java.util.Objects;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.osate.ge.swt.util.SwtTestUtil;

/**
 * View for displaying a name and allowing it to be edited using the {@link RenameDialog}
 *
 */
public class NameEditor extends Composite
{
	private final NameEditorModel model;
	private final CLabel nameLbl;
	private final Button renameBtn;

	public NameEditor(final Composite parent, final NameEditorModel model) {
		super(parent, SWT.NONE);
		this.model = Objects.requireNonNull(model, "model must not be null");
		this.setBackground(parent.getBackground());
		this.setLayout(GridLayoutFactory.fillDefaults().numColumns(2).create());

		this.nameLbl = new CLabel(this, SWT.BORDER);
		this.nameLbl
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).create());

		this.renameBtn = new Button(this, SWT.FLAT);
		this.renameBtn
				.setLayoutData(
						GridDataFactory.swtDefaults().grab(false, false).align(SWT.CENTER, SWT.CENTER).create());
		this.renameBtn.setText("Rename");
		this.renameBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				RenameDialog.open(getShell(), new NameEditorRenameDialogModel(model));
			}
		});

		model.changed().addListener(e -> refresh());

		refresh();
	}

	private void refresh() {
		nameLbl.setText(model.getName());
		setEnabled(model.isEnabled());
	}

	@Override
	public void setEnabled(final boolean enabled) {
		super.setEnabled(enabled);
		renameBtn.setEnabled(enabled);
	}

	public static void main(String[] args) {
		SwtTestUtil.run(shell -> {
			new NameEditor(shell, new TestNameEditorModel());
		});
	}
}
