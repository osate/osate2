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

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.eclipse.jface.dialogs.Dialog;
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
import org.osate.ge.swt.internal.InternalUtil;
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

		final ClassifierWithBindingsDialogModel<N, D, T, C> wrappedModel = new ClassifierWithBindingsDialogModel<>(
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


	private static class InnerDialog<N, D, T, C> extends Dialog {
		private final String title;
		private final PrototypeBindingsModel<N, D, T, C> model;
		private final N node;
		private final Consumer<ChangeEvent> changeListener = e -> refresh();
		private final Consumer<SelectionDoubleClickedEvent> selectionDoubleClickedListener = e -> okPressed();
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
		protected Control createDialogArea(final Composite parent) {
			final Composite container = (Composite) super.createDialogArea(parent);
			container.setLayout(GridLayoutFactory.swtDefaults().numColumns(1).create());

			//
			// Classifier
			//
			// Determine preferred size for the classifier selector
			final int classifierSelectorPreferredWidth = convertWidthInCharsToPixels(80);
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
			final int bindingEditorPreferredWidth = convertWidthInCharsToPixels(80);
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
			refresh();


			return container;
		}

		@Override
		protected void configureShell(final Shell shell) {
			super.configureShell(shell);
			shell.setText(title);
		}

		private void refresh() {
			// Update the bindings scrolled composites minimum size based on the content
			if (!bindingsScrolled.isDisposed()) {
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

	/**
	 * Model decorator used by the dialog which tracks changes and allows reverting.
	 *
	 * @param <N>
	 * @param <D>
	 * @param <T>
	 * @param <C>
	 */
	private static class ClassifierWithBindingsDialogModel<N, D, T, C>
			extends PrototypeBindingsModelDecorator<N, D, T, C> {
		private final Map<N, D> originalDirections = new HashMap<>();
		private final Map<N, T> originalTypes = new HashMap<>();
		private final Map<N, C> originalClassifiers = new HashMap<>();

		public ClassifierWithBindingsDialogModel(final PrototypeBindingsModel<N, D, T, C> inner) {
			super(inner);
		}

		@Override
		public void setDirection(final N node, final D value) {
			// Store original value to allow reverting
			if (!originalDirections.containsKey(node)) {
				originalDirections.put(node, super.getDirection(node));
			}

			super.setDirection(node, value);
		}

		@Override
		public void setType(final N node, final T value) {
			// Store original value to allow reverting
			if (!originalTypes.containsKey(node)) {
				originalTypes.put(node, super.getType(node));
			}

			super.setType(node, value);
		}

		@Override
		public void setClassifier(final N node, final C value) {
			// Store original value to allow reverting
			if (!originalClassifiers.containsKey(node)) {
				originalClassifiers.put(node, super.getClassifier(node));
			}

			super.setClassifier(node, value);
		}

		public void revert() {
			// Revert classifier changes
			for (final Entry<N, C> e : originalClassifiers.entrySet()) {
				super.setClassifier(e.getKey(), e.getValue());
			}
			originalClassifiers.clear();

			// Revert type changes
			for (final Entry<N, T> e : originalTypes.entrySet()) {
				super.setType(e.getKey(), e.getValue());
			}
			originalTypes.clear();

			// Revert direction changes
			for (final Entry<N, D> e : originalDirections.entrySet()) {
				super.setDirection(e.getKey(), e.getValue());
			}
			originalDirections.clear();
		}
	}

	/**
	 * Model decorator which is passed to the binding editor to prevent flushing.
	 *
	 * @param <N>
	 * @param <D>
	 * @param <T>
	 * @param <C>
	 */
	private static class NoFlushPrototypeBindingsModel<N, D, T, C>
			extends PrototypeBindingsModelDecorator<N, D, T, C> {
		public NoFlushPrototypeBindingsModel(final PrototypeBindingsModel<N, D, T, C> inner) {
			super(inner);
		}

		@Override
		public void flush() {
			// Avoid flushing until the top-level dialog has closed to allow batching changes.
		}
	}

	public static void main(String[] args) {
		InternalUtil.runDialog(() -> {
			ClassifierWithBindingsDialog.open(null, "Select Classifier and Bindings",
					new TestPrototypeBindingsModel(), null);
		});
	}
}
