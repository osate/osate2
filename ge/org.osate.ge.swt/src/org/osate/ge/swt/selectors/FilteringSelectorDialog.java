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
import java.util.function.BiFunction;
import java.util.function.Consumer;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.osate.ge.swt.internal.InternalUtil;

/**
 * Dialog for selecting from a filtering selector. Selected element is set when dialog is closed.
 *
 * If the dialog's contents supports {@link SelectionDoubleClickedEventGenerator}, the dialog will be confirmed when the event is generated.
 */
public final class FilteringSelectorDialog {
	private FilteringSelectorDialog() {
	}

	/**
	 * Opens the dialog using a {@link FilteringListSelector}.
	 *
	 * @param <T> is the type of element being selected.
	 * @param parent is the parent shell or null if the dialog should be a top-level window.
	 * @param title is the title of the dialog's shell.
	 * @param model is the view model for the dialog.
	 *
	 * @see #open(Shell, String, FilteringSelectorModel, BiFunction)
	 */
	public static <T> void open(final Shell parent, final String title, final FilteringSelectorModel<T> model) {
		open(parent, title, model,
				(container, dialogModel) -> new FilteringListSelector<>(container, dialogModel));

	}

	/**
	 * Opens the dialog using a control supplied by the specified function.
	 * Returns once the dialog has been closed and the rename has been performed using the provided {@link FilteringSelectorModel}
	 * The model provided to the control creator will not match the specified model. The supplied model must be used by the control.
	 * @param <T> is the type of element being selected.
	 * @param parent is the parent shell or null if the dialog should be a top-level window.
	 * @param title is the title of the dialog's shell.
	 * @param model is the view model for the dialog.
	 * @param controlCreator is a function that creates the control using the supplied container and model.
	 */
	public static <T> void open(final Shell parent, final String title, final FilteringSelectorModel<T> model,
			final BiFunction<Composite, FilteringSelectorModel<T>, Control> controlCreator) {
		Objects.requireNonNull(title, "title must not be null");
		Objects.requireNonNull(model, "model must not be null");
		Objects.requireNonNull(controlCreator, "controlCreator must not be null");

		final FilteringListSelectorDialogModel<T> dialogModel = new FilteringListSelectorDialogModel<>(model);
		final InnerDialog<T> dlg = new InnerDialog<>(parent, title, dialogModel,
				controlCreator);

		// Update the underlying selection if the dialog is confirmed.
		if (dlg.open() == Window.OK && dialogModel.dialogSelectionIsValid) {
			model.setSelectedElement(dialogModel.dialogSelection);
		}
	}

	private static class InnerDialog<T> extends Dialog {
		private final String title;
		private final FilteringSelectorModel<T> model;
		private final BiFunction<Composite, FilteringSelectorModel<T>, Control> controlCreator;
		private final Consumer<SelectionDoubleClickedEvent> selectionDoubleClickedListener = e -> okPressed();

		public InnerDialog(final Shell parent, final String title,
				final FilteringSelectorModel<T> model,
				final BiFunction<Composite, FilteringSelectorModel<T>, Control> controlCreator) {
			super(parent);
			this.title = title;
			this.model = model;
			this.controlCreator = controlCreator;
			setShellStyle(getShellStyle() | SWT.RESIZE);
		}

		@Override
		protected Control createDialogArea(final Composite parent) {
			final Composite container = (Composite) super.createDialogArea(parent);

			// Determine preferred size
			final int preferredWidth = convertWidthInCharsToPixels(80);
			final int preferredHeight = convertHeightInCharsToPixels(30);

			// Create contents
			final Control control = controlCreator.apply(container, model);
			control.setLayoutData(GridDataFactory.swtDefaults().grab(true, true).hint(preferredWidth, preferredHeight).align(SWT.FILL, SWT.FILL).create());

			if (control instanceof SelectionDoubleClickedEventGenerator) {
				((SelectionDoubleClickedEventGenerator) control).selectionDoubleClicked()
						.addListener(selectionDoubleClickedListener);
			}

			return container;
		}

		@Override
		protected void configureShell(final Shell shell) {
			super.configureShell(shell);
			shell.setText(title);
		}
	}

	/**
	 * {@link FilteringSelectorModel} which wraps a model but does not update the underlying selection.
	 * However, it does keep track of the selection.
	 */
	private static class FilteringListSelectorDialogModel<T> extends FilteringListSelectorModelDecorator<T> {
		/**
		 * Tracks whether {@Link #dialogSelection} has been set. Needed to differentiate between the null and the not set case.
		 */
		boolean dialogSelectionIsValid = false;

		/**
		 * Element selected via the dialog. Should be ignored if {@link #dialogSelectionIsValid} is null
		 */
		T dialogSelection = null;

		public FilteringListSelectorDialogModel(final FilteringSelectorModel<T> inner) {
			super(inner);
		}

		@Override
		public T getSelectedElement() {
			return dialogSelectionIsValid ? dialogSelection : super.getSelectedElement();
		}

		@Override
		public void setSelectedElement(final T element) {
			if (!dialogSelectionIsValid || !Objects.equals(dialogSelection, element)) {
				dialogSelection = element;
				dialogSelectionIsValid = true;
				triggerChangeEvent();
			}
		}
	}

	public static void main(String[] args) {
		InternalUtil.runDialog(() -> {
			FilteringSelectorDialog.open(null, "Select an Item",
					new LabelFilteringListSelectorModel<>(new TestListEditorModel()));
		});
	}
}
