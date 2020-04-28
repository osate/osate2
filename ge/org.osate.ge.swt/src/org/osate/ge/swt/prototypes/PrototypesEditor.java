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
package org.osate.ge.swt.prototypes;

import java.util.Objects;
import java.util.stream.Stream;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.EventSource;
import org.osate.ge.swt.internal.InternalUtil;
import org.osate.ge.swt.selectors.ListEditor;
import org.osate.ge.swt.selectors.ListEditorModel;

/**
 * View for editing a list of prototypes and their details.
 * Combination of {@link org.osate.ge.swt.selectors.ListEditor} and {@link PrototypeEditor}.
 *
 */
public final class PrototypesEditor<T, C> extends Composite {
	private static final String WIDGET_ID_PREFIX = "org.osate.ge.swt.prototypes.prototypesEditor.";
	public static final String WIDGET_ID_PROTOTYPE_LIST = WIDGET_ID_PREFIX + "prototypeList";

	private final ListEditor<T> listView;
	private final PrototypeEditor<C> detailsView;

	public PrototypesEditor(final Composite parent, final PrototypesEditorModel<T, C> model) {
		super(parent, SWT.NONE);
		Objects.requireNonNull(model, "model must not be null");
		InternalUtil.setColorsToMatchParent(this);

		this.setLayout(GridLayoutFactory.swtDefaults().numColumns(3).create());
		this.listView = new ListEditor<>(this, new ListEditorModel<T>() {
			@Override
			public EventSource<ChangeEvent> changed() {
				return model.changed();
			}

			@Override
			public Stream<T> getElements() {
				return model.getPrototypes();
			}

			@Override
			public boolean canAdd() {
				return model.canAddPrototype();
			}

			@Override
			public void addElement() {
				model.addPrototype();
			}

			@Override
			public void removeElement(T element) {
				model.removePrototype(element);
			}

			@Override
			public T getSelectedElement() {
				return model.getSelectedPrototype();
			}

			@Override
			public void setSelectedElement(T value) {
				model.setSelectedPrototype(value);
			}

			@Override
			public String getLabel(T prototype) {
				return model.getPrototypeLabel(prototype);
			}
		});
		this.listView.setListTestingId(WIDGET_ID_PROTOTYPE_LIST);
		this.listView
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).create());

		final Label separator = new Label(this, SWT.SEPARATOR | SWT.VERTICAL);
		separator.setLayoutData(GridDataFactory.swtDefaults().grab(false, true).align(SWT.CENTER, SWT.FILL).create());

		this.detailsView = new PrototypeEditor<>(this, new PrototypeEditorModel<C>() {
			@Override
			public EventSource<ChangeEvent> changed() {
				return model.changed();
			}

			@Override
			public boolean isEnabled() {
				return model.getSelectedPrototype() != null;
			}

			@Override
			public String getName() {
				return model.getSelectedPrototype() == null ? "" : model.getPrototypeName(model.getSelectedPrototype());
			}

			@Override
			public String validateName(final String newName) {
				return model.getSelectedPrototype() == null ? null
						: model.validatePrototypeName(model.getSelectedPrototype(), newName);
			}

			@Override
			public void setName(final String value) {
				if (model.getSelectedPrototype() != null) {
					model.setPrototypeName(model.getSelectedPrototype(), value);
				}
			}

			@Override
			public PrototypeDirection getDirection() {
				return model.getSelectedPrototype() == null ? null
						: model.getPrototypeDirection(model.getSelectedPrototype());
			}

			@Override
			public void setDirection(final PrototypeDirection value) {
				if (model.getSelectedPrototype() != null) {
					model.setPrototypeDirection(model.getSelectedPrototype(), value);
				}
			}

			@Override
			public PrototypeType getType() {
				return model.getSelectedPrototype() == null ? null
						: model.getPrototypeType(model.getSelectedPrototype());
			}

			@Override
			public void setType(final PrototypeType value) {
				if (model.getSelectedPrototype() != null) {
					model.setPrototypeType(model.getSelectedPrototype(), value);
				}
			}

			@Override
			public Stream<C> getConstrainingClassifierOptions() {
				return model.getSelectedPrototype() == null ? Stream.empty()
						: model.getConstrainingClassifierOptions(model.getSelectedPrototype());
			}

			@Override
			public String getClassifierLabel(final C classifier) {
				return model.getClassifierLabel(classifier);
			}

			@Override
			public C getConstrainingClassifier() {
				return model.getSelectedPrototype() == null ? null
						: model.getConstrainingClassifier(model.getSelectedPrototype());
			}

			@Override
			public void setConstrainingClassifier(C value) {
				if (model.getSelectedPrototype() != null) {
					model.setConstrainingClassifier(model.getSelectedPrototype(), value);
				}
			}

			@Override
			public Boolean isArray() {
				return model.getSelectedPrototype() == null ? null
						: model.isArray(model.getSelectedPrototype());
			}

			@Override
			public void setArray(boolean value) {
				model.setArray(model.getSelectedPrototype(), value);
			}

			@Override
			public String getRefineableElementLabel() {
				return model.getSelectedPrototype() == null ? null
						: model.getRefineableElementLabel(model.getSelectedPrototype());
			}

			@Override
			public Boolean isRefined() {
				return model.getSelectedPrototype() == null ? null : model.isRefined(model.getSelectedPrototype());
			}

			@Override
			public void setRefined(boolean value) {
				model.setRefined(model.getSelectedPrototype(), value);
			}
		});
		this.detailsView
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).create());
	}

	public static void main(String[] args) {
		InternalUtil.run(shell -> {
			new PrototypesEditor<>(shell, new TestPrototypesEditorModel());
		});
	}
}