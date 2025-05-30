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
package org.osate.ge.swt.classifiers;

import java.util.Objects;
import java.util.stream.Stream;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osate.ge.swt.EventSource;
import org.osate.ge.swt.SwtUtil;
import org.osate.ge.swt.selectors.ComboSelector;
import org.osate.ge.swt.selectors.SingleSelectorModel;

/**
 * View for editing a prototype binding. Also intended to be used for selecting the type for subcomponent types.
 * Fields for which options are not available are hidden.
 *
 * @param <N> is the type of the node being edited.
 * @param <D> is the type of the direction options.
 * @param <T> is the type of the type options.
 * @param <C> is the type of the classifiers.
 * @since 1.1
 */
public class PrototypeBindingActualEditor<N, D, T, C> extends Composite {
	private final PrototypeBindingsModel<N, D, T, C> model;
	private N node;
	private final ComboSelector<D> directionSelector;
	private final ComboSelector<T> typeSelector;
	private final ClassifierWithBindingsField<N, D, T, C> classifierAndBindingSelector;
	private final Runnable changeListener = this::refresh;

	/**
	 * Creates a new instance
	 * @param parent the widget which is the parent of the editor. Must not be null.
	 * @param model the model which provides the contents for the editor
	 * @param node the binding node to edit
	 */
	public PrototypeBindingActualEditor(final Composite parent, final PrototypeBindingsModel<N, D, T, C> model,
			N node) {
		super(parent, SWT.NONE);
		this.model = Objects.requireNonNull(model, "model must not be null");
		this.node = node;
		SwtUtil.setColorsToMatchParent(this);

		// Type
		typeSelector = new ComboSelector<>(this, new SingleSelectorModel<T>() {
			@Override
			public EventSource changed() {
				return model.changed();
			}

			@Override
			public Stream<T> getElements() {
				return model.getTypeOptions(node);
			}

			@Override
			public String getLabel(T element) {
				return model.getTypeLabel(element);
			}

			@Override
			public T getSelectedElement() {
				return model.getType(node);
			}

			@Override
			public void setSelectedElement(T value) {
				model.setType(node, value);
				model.flush();
			}
		});
		typeSelector
				.setLayoutData(GridDataFactory.swtDefaults().grab(false, false).align(SWT.FILL, SWT.CENTER).create());

		// Direction
		directionSelector = new ComboSelector<>(this, new SingleSelectorModel<D>() {
			@Override
			public EventSource changed() {
				return model.changed();
			}

			@Override
			public Stream<D> getElements() {
				return model.getDirectionOptions(node);
			}

			@Override
			public String getLabel(D element) {
				return model.getDirectionLabel(element);
			}

			@Override
			public D getSelectedElement() {
				return model.getDirection(node);
			}

			@Override
			public void setSelectedElement(D value) {
				model.setDirection(node, value);
				model.flush();
			}
		});
		directionSelector
				.setLayoutData(GridDataFactory.swtDefaults().grab(false, false).align(SWT.FILL, SWT.CENTER).create());

		// Classifier and bindings
		classifierAndBindingSelector = new ClassifierWithBindingsField<>(this, model, node);
		classifierAndBindingSelector
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).create());

		model.changed().addListener(changeListener);
		refresh();
	}

	private void refresh() {
		if (!this.isDisposed()) {
			SwtUtil.setVisibilityAndExclusion(typeSelector, model.getTypeOptions(node).limit(1).count() != 0);
			SwtUtil.setVisibilityAndExclusion(directionSelector,
					model.getDirectionOptions(node).limit(1).count() != 0);

			this.setLayout(GridLayoutFactory.swtDefaults().numColumns(oneIfVisible(directionSelector)
					+ oneIfVisible(typeSelector) + oneIfVisible(classifierAndBindingSelector)).create());

			this.requestLayout();
		}
	}

	private int oneIfVisible(final Control control) {
		return control.getVisible() ? 1 : 0;
	}

	/**
	 * Sets the node which this control is editing.
	 * @param node the new node. May be null. Must be valid node as provided by the model.
	 */
	public void setNode(final N node) {
		this.node = node;
		classifierAndBindingSelector.setNode(node);
		refresh();
	}

	/**
	 * Entry point for an interactive test application.
	 * @param args command line arguments
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public static void main(String[] args) {
		SwtUtil.run(shell -> new PrototypeBindingActualEditor<>(shell, new TestPrototypeBindingsModel(), null));
	}

}
