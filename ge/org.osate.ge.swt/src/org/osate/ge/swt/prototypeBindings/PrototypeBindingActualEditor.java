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
package org.osate.ge.swt.prototypeBindings;

import java.util.Objects;
import java.util.stream.Stream;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.EventSource;
import org.osate.ge.swt.selectors.ComboSelector;
import org.osate.ge.swt.selectors.FilteringListSelectorField;
import org.osate.ge.swt.selectors.LabelFilteringListSelectorModel;
import org.osate.ge.swt.selectors.SelectorModel;
import org.osate.ge.swt.util.SwtTestUtil;

// TODO: Rename. Intended for displaying/allowing selection of subcomponent type as well
/**
 * View for editing prototype bindings
 *
 * @param <N> is the type of the node being edited.
 * @param <D> is the type of the direction options.
 * @param <T> is the type of the type options.
 * @param <C> is the type of the classifiers.
 */
public class PrototypeBindingActualEditor<N, D, T, C> extends Composite {
	private N node;

	public PrototypeBindingActualEditor(final Composite parent, final PrototypeBindingsModel<N, D, T, C> model,
			N node) {
		super(parent, SWT.NONE);
		Objects.requireNonNull(model, "model must not be null");
		this.node = node;
		this.setBackground(parent.getBackground());
		this.setLayout(GridLayoutFactory.swtDefaults().numColumns(3).create()); // TODO. Adjust layout. Some widgets won't be visible. No need for grid

		// TODO: Hide widgets when no selections are available
		// TODO: Widget layout

		// Direction
		final ComboSelector<D> directionSelector = new ComboSelector<D>(this, new SelectorModel<D>() {
			@Override
			public EventSource<ChangeEvent> changed() {
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
			}
		});

		// Type
		final ComboSelector<T> typeSelector = new ComboSelector<T>(this, new SelectorModel<T>() {
			@Override
			public EventSource<ChangeEvent> changed() {
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
			}
		});

		// Classifier and bindings
		final FilteringListSelectorField classifierAndBindingSelector = new FilteringListSelectorField<>(this,
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
					public C getSelectedElement() {
						return model.getClassifier(node);
					}

					@Override
					public String getLabel(final C element) {
						return model.getClassifierLabel(element);
					}

					@Override
					public void setSelectedElement(final C value) {
						model.setClassifier(node, value);
					}

				}));
	}

	public static void main(String[] args) {
		SwtTestUtil.run(shell -> {
			new PrototypeBindingActualEditor<>(shell, new TestPrototypeBindingsModel(), null);
		});
	}

}
