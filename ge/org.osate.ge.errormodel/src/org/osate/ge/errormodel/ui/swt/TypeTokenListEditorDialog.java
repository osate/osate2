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
package org.osate.ge.errormodel.ui.swt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.osate.ge.swt.BaseObservableModel;
import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.SwtUtil;
import org.osate.ge.swt.selectors.FilteringSelectorDialog;
import org.osate.ge.swt.selectors.LabelFilteringListSelectorModel;
import org.osate.ge.swt.selectors.ListSelector;
import org.osate.ge.swt.selectors.SelectorModel;
import org.osate.ge.swt.selectors.SingleSelectorModel;
import org.osate.ge.swt.selectors.SingleSelectorModelToSelectorModelAdapter;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

import com.google.common.base.Strings;

/**
 * Dialog for editing a list of type tokens. For example: this is used to select the contents for of a type set.
 *
 */
public class TypeTokenListEditorDialog {
	private TypeTokenListEditorDialog() {
	}

	/**
	 * Opens a dialog to edit a list of type tokens.
	 * @param parent the parent of the dialog
	 * @param title the dialog's title
	 * @param model is the model to use to get and set the type tokens
	 * @return true if OK was selected. {@link TypeTokenListEditorModel#setTypeTokens(List)} will not be called unless OK was selected.
	 */
	public static boolean open(final Shell parent, final String title, final TypeTokenListEditorModel model) {
		Objects.requireNonNull(model, "model must not be null");
		final InnerDialog dlg = new InnerDialog(parent, title, model);
		if (dlg.open() == Window.OK) {
			model.setTypeTokens(dlg.getTypeTokens());
			return true;
		}

		return false;
	}

	private static class InnerDialog extends TitleAreaDialog {
		private final Consumer<ChangeEvent> changeListener = e -> refresh();
		private final String title;
		private final TypeTokenListEditorModel editorModel;
		private final TypeTokenListEditorDialogModel model;
		private ListSelector<TypeToken> tokenSelector;
		private Button addTypesButton;
		private Button addTypeProductButton;
		private Button editProductTokenButton;
		private Button removeButton;

		public InnerDialog(final Shell parentShell, final String title, final TypeTokenListEditorModel model) {
			super(parentShell);
			this.title = Objects.requireNonNull(title, "title must not be null");
			this.editorModel = Objects.requireNonNull(model, "model must not be null");
			this.model = new TypeTokenListEditorDialogModel(model);
			setShellStyle(getShellStyle() | SWT.RESIZE);
		}

		@Override
		public void create() {
			super.create();
			setTitle(getShell().getText());
			refresh();
		}

		@Override
		protected void configureShell(final Shell shell) {
			super.configureShell(shell);
			shell.setText(title);
		}

		@Override
		protected Control createDialogArea(final Composite parent) {
			final Composite dialogArea = (Composite) super.createDialogArea(parent);

			final Composite container = new Composite(dialogArea, SWT.NONE);
			container.setLayoutData(GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).create());
			container.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());

			// Determine preferred size
			final int preferredListWidth = convertWidthInCharsToPixels(120);
			final int preferredListHeight = convertHeightInCharsToPixels(30);

			this.tokenSelector = new ListSelector<TypeToken>(container,
					new SingleSelectorModelToSelectorModelAdapter<>(model));
			this.tokenSelector.setLayoutData(
					GridDataFactory.swtDefaults().span(1, 4).grab(true, true)
							.hint(preferredListWidth, preferredListHeight)
							.align(SWT.FILL, SWT.FILL).create());

			//
			// Buttons to edit the list
			//
			this.addTypesButton = new Button(container, SWT.FLAT);
			this.addTypesButton.setText("Add Error Type(s)");
			this.addTypesButton.setLayoutData(
					GridDataFactory.swtDefaults().grab(false, false).align(SWT.FILL, SWT.BEGINNING).create());
			this.addTypesButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					final ErrorTypesSelectorModel selectorModel = new ErrorTypesSelectorModel(editorModel, (t) -> true,
							Collections.emptyList());
					if (FilteringSelectorDialog.open(getShell(), "Add Types",
							new LabelFilteringListSelectorModel<>(selectorModel))) {
						for (final ErrorTypes errorType : selectorModel.selection) {
							// Create token with single type.
							final TypeToken newToken = (TypeToken) EcoreUtil
									.create(ErrorModelPackage.eINSTANCE.getTypeToken());
							newToken.getType().add(errorType);

							model.addTypeToken(newToken);
						}
					}
				}
			});

			this.addTypeProductButton = new Button(container, SWT.FLAT);
			this.addTypeProductButton.setText("Add Type Product");
			this.addTypeProductButton.setLayoutData(
					GridDataFactory.swtDefaults().grab(false, false).align(SWT.FILL, SWT.BEGINNING).create());
			this.addTypeProductButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					// Open dialog to prompt for types which are used in the product
					final ErrorTypesSelectorModel selectorModel = new ErrorTypesSelectorModel(editorModel,
							(t) -> t instanceof ErrorType, Collections.emptyList());
					if (FilteringSelectorDialog.open(getShell(),
							"Select Error Types for Product",
							new LabelFilteringListSelectorModel<>(selectorModel))) {
						// Create token with single type.
						final TypeToken newToken = (TypeToken) EcoreUtil
								.create(ErrorModelPackage.eINSTANCE.getTypeToken());
						newToken.getType().addAll(selectorModel.selection);
						model.addTypeToken(newToken);
					}
				}
			});

			// Edit product button
			this.editProductTokenButton = new Button(container, SWT.FLAT);
			this.editProductTokenButton.setText("Edit Type Product");
			this.editProductTokenButton.setLayoutData(
					GridDataFactory.swtDefaults().grab(false, false).align(SWT.FILL, SWT.BEGINNING).create());
			this.editProductTokenButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					// Open dialog to prompt for types which are used in the product
					final TypeToken token = model.getSelectedElement();
					final ErrorTypesSelectorModel selectorModel = new ErrorTypesSelectorModel(editorModel,
							(t) -> t instanceof ErrorType,
							token.getType().stream().map(EcoreUtil::getURI).collect(Collectors.toList()));
					if (FilteringSelectorDialog.open(getShell(), "Select Error Types for Product",
							new LabelFilteringListSelectorModel<>(selectorModel))) {
						final TypeToken updatedToken = (TypeToken) EcoreUtil
								.create(ErrorModelPackage.eINSTANCE.getTypeToken());
						updatedToken.getType().addAll(selectorModel.selection);
						model.replaceSelectedToken(updatedToken);
					}

				}
			});

			this.removeButton = new Button(container, SWT.FLAT);
			this.removeButton.setText("Remove");
			this.removeButton.setLayoutData(
					GridDataFactory.swtDefaults().grab(false, false).align(SWT.FILL, SWT.BEGINNING).create());
			this.removeButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					model.removeSelected();
				}
			});

			model.changed().addListener(changeListener);
			refresh();

			return dialogArea;
		}

		private void refresh() {
			// Refresh error message and state of buttons
			if (this.getShell() != null && !this.getShell().isDisposed()) {
				final String error = Strings.emptyToNull(model.getErrorMessage());
				this.setErrorMessage(error);
				this.editProductTokenButton.setEnabled(model.getSelectedElement() != null
						&& !model.getSelectedElement().getType().stream().anyMatch(t -> t instanceof TypeSet));
				this.removeButton.setEnabled(model.getSelectedElement() != null);

				final Button okBtn = getButton(IDialogConstants.OK_ID);

				if (okBtn != null) {
					okBtn.setEnabled(error == null);
				}
			}
		}

		private List<TypeToken> getTypeTokens() {
			return model.getTypeTokens();
		}
	}

	// Make a list of the type tokens
	private static class TypeTokenListEditorDialogModel extends BaseObservableModel
			implements SingleSelectorModel<TypeToken> {
		private final Consumer<ChangeEvent> changeListener = e -> triggerChangeEvent();
		private final TypeTokenListEditorModel model;
		private final List<TypeToken> typeTokens;
		private TypeToken selectedToken;

		public TypeTokenListEditorDialogModel(final TypeTokenListEditorModel model) {
			this.model = Objects.requireNonNull(model, "model must not be null");
			this.typeTokens = model.getTypeTokens().collect(Collectors.toCollection(() -> new ArrayList<>()));
			this.model.changed().addListener(changeListener);
		}

		public List<TypeToken> getTypeTokens() {
			return Collections.unmodifiableList(typeTokens);
		}

		@Override
		public Stream<TypeToken> getElements() {
			return typeTokens.stream();
		}

		@Override
		public TypeToken getSelectedElement() {
			return selectedToken;
		}

		@Override
		public void setSelectedElement(final TypeToken value) {
			if (!Objects.equals(selectedToken, value)) {
				this.selectedToken = value;
				triggerChangeEvent();
			}
		}

		public void removeSelected() {
			if (selectedToken != null) {
				if (typeTokens.remove(selectedToken)) {
					this.selectedToken = null;
					triggerChangeEvent();
				}
			}
		}

		public void addTypeToken(final TypeToken value) {
			typeTokens.add(value);
			triggerChangeEvent();
		}

		public void replaceSelectedToken(final TypeToken value) {
			final int index = typeTokens.indexOf(selectedToken);
			if(index == -1) {
				throw new RuntimeException("Unable to find selected token");
			} else {
				typeTokens.set(index, value);
				selectedToken = value;
				triggerChangeEvent();
			}
		}

		@Override
		public String getLabel(final TypeToken element) {
			return model.getTypeTokenLabel(element);
		}

		public String getErrorMessage() {
			return model.validate(getTypeTokens());
		}
	}

	private static class ErrorTypesSelectorModel extends BaseObservableModel implements SelectorModel<ErrorTypes> {
		private final TypeTokenListEditorModel model;
		private final Consumer<ChangeEvent> changeListener = e -> triggerChangeEvent();
		private List<ErrorTypes> selection;
		private Predicate<ErrorTypes> filter;

		public ErrorTypesSelectorModel(final TypeTokenListEditorModel model, final Predicate<ErrorTypes> filter,
				final List<URI> selectionUris) {
			this.model = Objects.requireNonNull(model, "model must not be null");
			this.filter = Objects.requireNonNull(filter, "filter must not be null");
			Objects.requireNonNull(selectionUris, "selectionUris must not be null");

			// Set the selection by finding the elements with the specified URIs. This ensures that the same object is used for both
			// the current selection and the list.
			this.selection = getElements().filter(t -> selectionUris.contains(EcoreUtil.getURI(t)))
					.collect(Collectors.toList());
			this.model.changed().addListener(changeListener);
		}

		@Override
		public Stream<ErrorTypes> getElements() {
			return model.getErrorTypes().filter(filter);
		}

		@Override
		public Stream<ErrorTypes> getSelectedElements() {
			return selection.stream();
		}

		@Override
		public void setSelectedElements(final Stream<ErrorTypes> value) {
			final List<ErrorTypes> newSelection = value.collect(Collectors.toList());
			if (!Objects.equals(selection, newSelection)) {
				selection = newSelection;
				triggerChangeEvent();
			}
		}

		@Override
		public String getLabel(final ErrorTypes element) {
			return model.getErrorTypeLabel(element);
		}

		@Override
		public boolean supportsMultiSelect() {
			return true;
		}
	}

	public static void main(String[] args) {
		SwtUtil.runDialog(() -> {
			TypeTokenListEditorDialog.open(null, "Select Type Tokens", new TestTypeTokenListEditorModel());
		});
	}
}
