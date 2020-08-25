package org.osate.ge.swt.name;

import java.util.Objects;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.osate.ge.swt.SwtUtil;

/**
 * @since 1.1
 */
public class DiagramNameDialog {
	private DiagramNameDialog() {
	}

	/**
	 * Opens the dialog. Returns once the dialog has been closed and the rename has been performed using the provided {@link NameEditorDialogModel}
	 * @param parent is the parent shell or null if the dialog should be a top-level window.
	 * @param model is the view model for the dialog.
	 */
	public static void open(final Shell parent, final NameEditorDialogModel model) {
		Objects.requireNonNull(model, "model must not be null");
		final InnerDialog dlg = new InnerDialog(parent, model);
		if (dlg.open() == Window.OK) {
			model.setName(dlg.getValue());
		}
	}

	private static class InnerDialog extends InputDialog {
		public InnerDialog(final Shell parent, final NameEditorDialogModel model) {
			super(parent, "Create Diagram", "Enter Name", model.getName(), newName -> model.validateName(newName));
			setShellStyle(getShellStyle() | SWT.RESIZE);
		}
	}

	public static void main(String[] args) {
		SwtUtil.runDialog(() -> {
			NameEditorDialog.open(null, new NameEditorRenameDialogModel(new TestNameEditorModel()));
		});
	}
}
