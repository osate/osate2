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
package org.osate.ge.swt.selectors;

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
import org.osate.ge.swt.internal.InternalUtil;

/**
 * View for editing a list of objects.
 *
 * Sorts items provided by model.
 */
public final class ListEditor<T> extends Composite {
	private final ListEditorModel<T> model;
	private final ListSelector<T> listViewer;
	private final Button addButton;
	private final Button removeButton;
	private final Consumer<ChangeEvent> changeListener = e -> refresh();

	public ListEditor(final Composite parent, final ListEditorModel<T> model) {
		super(parent, SWT.NONE);
		this.model = Objects.requireNonNull(model, "model must not be null");
		InternalUtil.setColorsToMatchParent(this);
		this.setLayout(GridLayoutFactory.fillDefaults().numColumns(2).create());

		this.listViewer = new ListSelector<>(this, model);
		this.listViewer.setLayoutData(
				GridDataFactory.swtDefaults().span(2, 1).grab(true, true).align(SWT.FILL, SWT.FILL).create());

		//
		// Add and remove buttons
		//
		this.addButton = new Button(this, SWT.FLAT);
		this.addButton.setText("Add");
		this.addButton
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).create());
		this.addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				model.addElement();
			}
		});

		this.removeButton = new Button(this, SWT.FLAT);
		this.removeButton.setText("Remove");
		this.removeButton
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).create());
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

	/**
	 * Sets the testing ID of SWT List
	 * @param value is the testing ID
	 */
	public void setListTestingId(final String value) {
		this.listViewer.setListTestingId(value);
	}

	private void refresh() {
		if (!this.isDisposed()) {
			setEnabled(this.isEnabled()); // Refresh enabled status
		}
	}

	@Override
	public void setEnabled(final boolean enabled) {
		super.setEnabled(enabled);
		this.addButton.setEnabled(enabled && model.canAdd());
		this.removeButton.setEnabled(enabled && model.getSelectedElement() != null);
	}


	public static void main(String[] args) {
		InternalUtil.run(shell -> {
			new ListEditor<>(shell, new TestListEditorModel());
		});
	}
}