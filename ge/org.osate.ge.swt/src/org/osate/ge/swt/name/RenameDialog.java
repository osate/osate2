package org.osate.ge.swt.name;

import java.util.Objects;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.osate.ge.swt.util.SwtTestUtil;

/**
 * Simple dialog for renaming something.
 *
 */
public class RenameDialog {
	private RenameDialog() {
	}

	/**
	 * Opens the dialog. Returns once the dialog has been closed and the rename has been performed using the provided {@link RenameDialogModel}
	 * @param parent is the parent shell or null if the dialog shoudl be a top-level window.
	 * @param model is the view model for the dialog.
	 */
	public static void open(final Shell parent, final RenameDialogModel model) {
		Objects.requireNonNull(model, "model must not be null");
		final InnerDialog dlg = new InnerDialog(parent, model);
		if (dlg.open() == Window.OK) {
			model.setName(dlg.getValue());
		}
	}

	private static class InnerDialog extends InputDialog {
		public InnerDialog(final Shell parent, final RenameDialogModel model) {
			super(parent, "Rename", "Enter Name", model.getName(), newName -> model.validateName(newName));
			setShellStyle(getShellStyle() | SWT.RESIZE);
		}

		@Override
		protected void configureShell(final Shell shell) {
			super.configureShell(shell);
		}
	}

	public static void main(String[] args) {
		SwtTestUtil.runDialog(() -> {
			RenameDialog.open(null, new NameEditorRenameDialogModel(new TestNameEditorModel()));
		});
	}
}
