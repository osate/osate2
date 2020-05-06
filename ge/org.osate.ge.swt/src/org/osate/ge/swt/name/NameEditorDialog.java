/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.swt.name;

import java.util.Objects;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.osate.ge.swt.internal.InternalUtil;

/**
 * Simple dialog for renaming something.
 *
 */
public final class NameEditorDialog {
	private NameEditorDialog() {
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
			super(parent, "Rename", "Enter Name", model.getName(), newName -> model.validateName(newName));
			setShellStyle(getShellStyle() | SWT.RESIZE);
		}
	}

	public static void main(String[] args) {
		InternalUtil.runDialog(() -> {
			NameEditorDialog.open(null, new NameEditorRenameDialogModel(new TestNameEditorModel()));
		});
	}
}
