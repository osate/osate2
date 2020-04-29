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
package org.osate.ge.swt.classifiers;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.EventSource;
import org.osate.ge.swt.selectors.FilteringListSelector;
import org.osate.ge.swt.selectors.LabelFilteringListSelectorModel;
import org.osate.ge.swt.selectors.SelectionDoubleClickedEvent;
import org.osate.ge.swt.selectors.SelectorModel;

/**
 * Dialog for selecting a classifier and prototype bindings. Values are set while the dialog is open and then reverted if the dialog is closed without pressing the OK button.
 * This behavior is important because options displayed by the dialog may change based on current values.
 *
 */
public class ClassifierWithBindingsDialog {
	private ClassifierWithBindingsDialog() {
	}

	/**
	 * Opens the dialog. Returns once the dialog has been closed.
	 * @param <N> See {@link PrototypeBindingsModel}
	 * @param <D> See {@link PrototypeBindingsModel}
	 * @param <T> See {@link PrototypeBindingsModel}
	 * @param <C> See {@link PrototypeBindingsModel}
	 * @param parent the parent shell
	 * @param title the title of the dialog
	 * @param model is the model to use for displaying and editing data.
	 * @param node is the node for which to show the dialog.
	 */
	public static <N, D, T, C> void open(final Shell parent, final String title,
			final PrototypeBindingsModel<N, D, T, C> model, final N node) {
		Objects.requireNonNull(title, "title must not be null");
		Objects.requireNonNull(model, "model must not be null");

		final PrototypeBindingsEditorDialogModel<N, D, T, C> wrappedModel = new PrototypeBindingsEditorDialogModel<>(
				model);
		final InnerDialog<N, D, T, C> dlg = new InnerDialog<>(parent, title,
				wrappedModel, node);

		// Open dialog
		if (dlg.open() == Window.OK) {
			// Flush changes when the user confirms the dialog.
			wrappedModel.flush();
		} else {
			wrappedModel.revert();
		}
	}


	private static class InnerDialog<N, D, T, C> extends TitleAreaDialog {
		private final String title;
		private final PrototypeBindingsModel<N, D, T, C> model;
		private final N node;
		private final Consumer<ChangeEvent> changeListener = e -> refresh();
		private final Consumer<SelectionDoubleClickedEvent> selectionDoubleClickedListener = e -> {
			if(getErrorMessage() == null) {
				okPressed();
			}
		};
		private ScrolledComposite bindingsScrolled;

		public InnerDialog(final Shell parent, final String title, final PrototypeBindingsModel<N, D, T, C> model,
				final N node) {
			super(parent);
			this.title = title;
			this.model = model;
			this.node = node;
			setShellStyle(getShellStyle() | SWT.RESIZE);
		}

		@Override
		public void create() {
			super.create();
			setTitle(getShell().getText());
			refresh();
		}

		@Override
		protected Control createDialogArea(final Composite parent) {
			final Composite container = (Composite) super.createDialogArea(parent);
			container.setLayout(GridLayoutFactory.swtDefaults().numColumns(1).create());

			//
			// Classifier
			//
			// Determine preferred size for the classifier selector
			final int classifierSelectorPreferredWidth = convertWidthInCharsToPixels(120);
			final int classifierSelectorPreferredHeight = convertHeightInCharsToPixels(30);

			final Group classifierGroup = new Group(container, SWT.SHADOW_ETCHED_IN);
			classifierGroup.setText("Classifier");
			classifierGroup
					.setLayoutData(GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).create());
			classifierGroup.setLayout(GridLayoutFactory.swtDefaults().numColumns(1).create());

			final FilteringListSelector<C> classifierSelector = new FilteringListSelector<>(classifierGroup,
					new LabelFilteringListSelectorModel<>(new SelectorModel<C>() {

						@Override
						public EventSource<ChangeEvent> changed() {
							return model.changed();
						}

						@Override
						public Stream<C> getElements() {
							return model.getClassifierOptions(node);
						}

						@Override
						public String getLabel(C element) {
							return model.getClassifierLabel(element);
						}

						@Override
						public C getSelectedElement() {
							return model.getClassifier(node);
						}

						@Override
						public void setSelectedElement(C value) {
							model.setClassifier(node, value);
						}
					}));


			// Create contents
			classifierSelector.setLayoutData(GridDataFactory.swtDefaults().grab(true, true)
					.hint(classifierSelectorPreferredWidth, classifierSelectorPreferredHeight)
					.align(SWT.FILL, SWT.FILL).create());

			classifierSelector.selectionDoubleClicked()
						.addListener(selectionDoubleClickedListener);


			//
			// Bindings
			//
			// Determine preferred size for the binding editor
			final int bindingEditorPreferredWidth = convertWidthInCharsToPixels(120);
			final int bindingEditorPreferredHeight = convertHeightInCharsToPixels(10);

			final Group bindingsGroup = new Group(container, SWT.SHADOW_ETCHED_IN);
			bindingsGroup.setText("Prototype Bindings");
			bindingsGroup
					.setLayoutData(GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).create());
			bindingsGroup.setLayout(GridLayoutFactory.swtDefaults().numColumns(1).create());

			// Scrollable for Bindings
			bindingsScrolled = new ScrolledComposite(bindingsGroup, SWT.H_SCROLL | SWT.V_SCROLL);
			bindingsScrolled.setLayoutData(GridDataFactory.swtDefaults().grab(true, true)
					.hint(bindingEditorPreferredWidth, bindingEditorPreferredHeight)
					.align(SWT.FILL, SWT.FILL).create());
			bindingsScrolled.setExpandVertical(true);
			bindingsScrolled.setExpandHorizontal(true);

			final Control bindingsEditor = new PrototypeBindingsEditor<>(bindingsScrolled,
					new NoFlushPrototypeBindingsModel<>(model), node);
			bindingsEditor
					.setLayoutData(GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).create());

			bindingsScrolled.setContent(bindingsEditor);

			model.changed().addListener(changeListener);

			return container;
		}

		@Override
		protected void configureShell(final Shell shell) {
			super.configureShell(shell);
			shell.setText(title);
		}

		private void refresh() {
			if (!bindingsScrolled.isDisposed()) {
				setErrorMessage(model.validateNode(node));
				this.getButton(IDialogConstants.OK_ID).setEnabled(getErrorMessage() == null);

				// Update the bindings scrolled composites minimum size based on the content
				// Don't set a minimum width. This can cause odd behavior with scrollbars appearing but inner controls truncating themselves.
				// For example CLabels will shorten themselves if provided with less space than computed. In such cases they will be sized based on the size of
				// the scrolled and not their preferred size.
				final Point minSize = bindingsScrolled.getContent().computeSize(SWT.DEFAULT,
						SWT.DEFAULT);
				minSize.x = 0;
				bindingsScrolled.setMinSize(minSize);
			}
		}
	}
}
