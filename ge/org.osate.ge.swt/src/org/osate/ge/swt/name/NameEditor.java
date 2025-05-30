/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.osate.ge.swt.BorderedCLabel;
import org.osate.ge.swt.SwtUtil;

/**
 * Component for displaying a name and allowing it to be edited using the {@link NameEditorDialog}
 * @since 1.1
 *
 */
public final class NameEditor extends Composite {
	private final NameEditorModel model;
	private final BorderedCLabel nameLbl;
	private final Button renameBtn;
	private final Runnable changeListener = this::refresh;

	/**
	 * Creates a new instance
	 * @param parent the widget which is the parent of the editor. Must not be null.
	 * @param model the model for the editor
	 */
	public NameEditor(final Composite parent, final NameEditorModel model) {
		super(parent, SWT.NONE);
		this.model = Objects.requireNonNull(model, "model must not be null");
		SwtUtil.setColorsToMatchParent(this);
		this.setLayout(GridLayoutFactory.fillDefaults().numColumns(2).create());

		this.nameLbl = new BorderedCLabel(this);
		this.nameLbl
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).create());
		SwtUtil.setColorsToMatchParent(this.nameLbl);

		this.renameBtn = new Button(this, SWT.FLAT);
		SwtUtil.setColorsToMatchParent(renameBtn);
		this.renameBtn
				.setLayoutData(GridDataFactory.swtDefaults().grab(false, false).align(SWT.CENTER, SWT.CENTER).create());
		this.renameBtn.setText("Rename");
		this.renameBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				NameEditorDialog.open(getShell(), new NameEditorRenameDialogModel(model));
			}
		});

		model.changed().addListener(changeListener);

		refresh();
	}

	private void refresh() {
		if (!this.isDisposed()) {
			nameLbl.setText(model.getName());
			setEnabled(model.isEnabled());
		}
	}

	@Override
	public void setEnabled(final boolean enabled) {
		super.setEnabled(enabled);
		renameBtn.setEnabled(enabled);
	}

	/**
	 * Entry point for an interactive test application.
	 * @param args command line arguments
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public static void main(String[] args) {
		SwtUtil.run(shell -> new NameEditor(shell, new TestNameEditorModel()));
	}
}
