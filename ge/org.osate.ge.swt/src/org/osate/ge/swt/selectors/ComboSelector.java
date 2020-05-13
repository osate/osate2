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
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.internal.InternalUtil;
import org.osate.ge.swt.util.SwtTestUtil;

/**
 * Wrapper around JFace's {@link org.eclipse.jface.viewers.ComboViewer} which uses a {@link SelectorModel}
 *
 * Sorts items provided by model.
 */
public final class ComboSelector<T> extends Composite {
	private final NullRemovingSelectorModel wrappedModel;
	private final org.eclipse.jface.viewers.ComboViewer comboViewer;
	private final Consumer<ChangeEvent> changeListener = e -> refresh();

	public ComboSelector(final Composite parent, final SelectorModel<T> model) {
		super(parent, SWT.NONE);
		this.wrappedModel = new NullRemovingSelectorModel(Objects.requireNonNull(model, "model must not be null"));
		InternalUtil.setColorsToMatchParent(this);
		this.setLayout(GridLayoutFactory.fillDefaults().numColumns(1).create());

		this.comboViewer = new org.eclipse.jface.viewers.ComboViewer(this);
		this.comboViewer.getControl()
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).create());
		this.comboViewer.setComparator(new ViewerComparator());
		this.comboViewer.setContentProvider(
				(IStructuredContentProvider) inputElement -> this.wrappedModel.getElements().toArray());
		this.comboViewer.setInput(this.wrappedModel);
		this.comboViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return wrappedModel.getLabel(element);
			}
		});

		// Disable mouse wheel scrolling to prevent a large number of change and refresh events which could be potentially expensive.
		this.comboViewer.getControl().addListener(SWT.MouseVerticalWheel, event -> event.doit = false);

		// Listen to selection changes
		this.comboViewer.addSelectionChangedListener(event -> {
			@SuppressWarnings("unchecked")
			final T newSelection = (T) this.comboViewer.getStructuredSelection().getFirstElement();
			if (newSelection != null && !Objects.equals(newSelection, this.wrappedModel.getSelectedElement())) {
				this.wrappedModel.setSelectedElement(newSelection);
				refresh();
			}
		});

		this.wrappedModel.changed().addListener(changeListener);

		refresh();
	}

	/**
	 * Sets the testing ID use to identify the combo box during testing.
	 * @param value is the identifier used to identify the combo box during testing.
	 */
	public void setComboTestingId(final String value) {
		SwtTestUtil.setTestingId(comboViewer.getControl(), value);
	}

	private void refresh() {
		if (!this.isDisposed()) {
			this.comboViewer.refresh();

			// Avoid attempting to select an element that is not in the selector. Will result in a stack overflow while trying to synchronize the selection with
			// the model.
			final Object selectedElement = wrappedModel.getSelectedElement();
			final boolean selectionAvailable = this.wrappedModel.getElements()
					.anyMatch(e -> Objects.equals(e, selectedElement));
			this.comboViewer.setSelection(
					selectionAvailable ? new StructuredSelection(wrappedModel.getSelectedElement()) : null);

			setEnabled(wrappedModel.isEnabled());
		}
	}

	@Override
	public void setEnabled(final boolean enabled) {
		super.setEnabled(enabled);
		comboViewer.getControl().setEnabled(enabled);
	}

	public static void main(String[] args) {
		InternalUtil.run(shell -> {
			new ComboSelector<>(shell, new TestListEditorModel());
		});
	}
}
