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
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.EventSource;
import org.osate.ge.swt.check.CheckboxEditor;
import org.osate.ge.swt.check.CheckboxEditorModel;
import org.osate.ge.swt.internal.InternalUtil;
import org.osate.ge.swt.name.NameEditor;
import org.osate.ge.swt.name.NameEditorModel;
import org.osate.ge.swt.selectors.ComboSelector;
import org.osate.ge.swt.selectors.FilteringListSelectorField;
import org.osate.ge.swt.selectors.LabelFilteringListSelectorModel;
import org.osate.ge.swt.selectors.RadioSelector;
import org.osate.ge.swt.selectors.SelectorModel;

/**
 * View for editing a prototype.
 *
 */
public final class PrototypeEditor<C> extends Composite {
	private static final String WIDGET_ID_PREFIX = "org.osate.ge.swt.prototypes.prototypeEditor.";
	public static final String WIDGET_ID_CHOOSE_CLASSIFIER_BUTTON = WIDGET_ID_PREFIX + "chooseClassifier";
	public static final String WIDGET_ID_CLASSIFIER_LABEL = WIDGET_ID_PREFIX + "classifierButton";
	public static final String WIDGET_ID_TYPE_COMBO = WIDGET_ID_PREFIX + "type";

	private final PrototypeEditorModel<C> model;
	private final CheckboxEditor refinedEditor;
	private final Control directionLabel;
	private final RadioSelector<PrototypeDirection> directionEditor;
	private final CheckboxEditor arrayFlagEditor;
	private final Consumer<ChangeEvent> changeListener = e -> refresh();

	public PrototypeEditor(final Composite parent, final PrototypeEditorModel<C> model) {
		super(parent, SWT.NONE);
		this.model = Objects.requireNonNull(model, "model must not be null");
		InternalUtil.setColorsToMatchParent(this);
		this.setLayout(GridLayoutFactory.fillDefaults().numColumns(2).create());

		//
		// Refinement
		//
		refinedEditor = new CheckboxEditor(this, new CheckboxEditorModel() {
			@Override
			public EventSource<ChangeEvent> changed() {
				return model.changed();
			}

			@Override
			public String getLabel() {
				final String refineableElementLabel = model.getRefineableElementLabel();
				return "Refine " + (refineableElementLabel == null ? "" : refineableElementLabel);
			}

			@Override
			public boolean isEnabled() {
				return model.isEnabled() && model.getRefineableElementLabel() != null;
			}

			@Override
			public Boolean getValue() {
				return model.isRefined();
			}

			@Override
			public void setValue(final boolean value) {
				model.setRefined(value);
			}

		});
		refinedEditor.setLayoutData(
				GridDataFactory.swtDefaults().span(2, 1).grab(true, false).align(SWT.FILL, SWT.CENTER).create());

		//
		// Name
		//
		addLabel("Name:");
		final NameEditor nameEditor = new NameEditor(this, new NameEditorModel() {
			@Override
			public boolean isEnabled() {
				return model.isEnabled();
			};

			@Override
			public EventSource<ChangeEvent> changed() {
				return model.changed();
			}

			@Override
			public String getName() {
				return model.getName();
			}

			@Override
			public void setName(String value) {
				model.setName(value);
			}

			@Override
			public String validateName(String newName) {
				return model.validateName(newName);
			}

		});
		nameEditor
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).create());

		//
		// Type
		//
		addLabel("Type:");
		final ComboSelector<PrototypeType> typeSelector = new ComboSelector<>(this, new SelectorModel<PrototypeType>() {
			@Override
			public EventSource<ChangeEvent> changed() {
				return model.changed();
			}

			@Override
			public boolean isEnabled() {
				return model.isEnabled();
			}

			@Override
			public Stream<PrototypeType> getElements() {
				return Stream.of(PrototypeType.values());
			}

			@Override
			public PrototypeType getSelectedElement() {
				return model.getType();
			}

			@Override
			public void setSelectedElement(PrototypeType element) {
				model.setType(element);
			}

			@Override
			public String getLabel(final PrototypeType element) {
				return element.toString();
			}
		});
		typeSelector.setComboTestingId(WIDGET_ID_TYPE_COMBO);
		typeSelector
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).create());

		//
		// Classifier
		//
		addLabel("Classifier:");
		final FilteringListSelectorField<C> classifierSelector = new FilteringListSelectorField<>(this,
				new LabelFilteringListSelectorModel<>(new SelectorModel<C>() {

					@Override
					public EventSource<ChangeEvent> changed() {
						return model.changed();
					}

					@Override
					public Stream<C> getElements() {
						return model.getConstrainingClassifierOptions();
					}

					@Override
					public C getSelectedElement() {
						return model.getConstrainingClassifier();
					}

					@Override
					public void setSelectedElement(C value) {
						model.setConstrainingClassifier(value);
					}

					@Override
					public String getLabel(C value) {
						return model.getClassifierLabel(value);
					}

				}));
		classifierSelector
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).create());
		classifierSelector.setLabelTestingId(WIDGET_ID_CLASSIFIER_LABEL);
		classifierSelector.setChooseButtonTestingId(WIDGET_ID_CHOOSE_CLASSIFIER_BUTTON);

		//
		// Direction
		//
		this.directionLabel = addLabel("Direction:");
		this.directionEditor = new RadioSelector<>(this, new SelectorModel<PrototypeDirection>() {
			@Override
			public EventSource<ChangeEvent> changed() {
				return model.changed();
			}

			@Override
			public boolean isEnabled() {
				return model.isEnabled();
			}

			@Override
			public Stream<PrototypeDirection> getElements() {
				return Stream.of(PrototypeDirection.values());
			}

			@Override
			public PrototypeDirection getSelectedElement() {
				return model.getDirection();
			}

			@Override
			public void setSelectedElement(final PrototypeDirection element) {
				model.setDirection(element);
			}

			@Override
			public String getLabel(final PrototypeDirection element) {
				return element.toString();
			}
		});

		directionEditor
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).create());

		//
		// Array
		//
		arrayFlagEditor = new CheckboxEditor(this, new CheckboxEditorModel() {
			@Override
			public EventSource<ChangeEvent> changed() {
				return model.changed();
			}

			@Override
			public boolean isEnabled() {
				return model.isEnabled();
			}

			@Override
			public String getLabel() {
				return "Array";
			}

			@Override
			public Boolean getValue() {
				return model.isArray();
			}

			@Override
			public void setValue(final boolean value) {
				model.setArray(value);
			}
		});
		arrayFlagEditor.setLayoutData(
				GridDataFactory.swtDefaults().span(2, 1).grab(true, false).align(SWT.FILL, SWT.CENTER).create());

		model.changed().addListener(changeListener);
		refresh();
	}

	private void refresh() {
		if (!this.isDisposed()) {
			final PrototypeType type = model.getType();

			// Make the refine checkbox visible when the refinement status can be adjusted or the refinement status is not false.
			InternalUtil.setVisibilityAndExclusion(refinedEditor, model.isEnabled()
					&& (model.getRefineableElementLabel() != null || model.isRefined() != Boolean.FALSE));

			// Update visibility of direction editor and label
			final boolean directionVisible = type == PrototypeType.FEATURE;
			InternalUtil.setVisibilityAndExclusion(directionLabel, directionVisible);
			InternalUtil.setVisibilityAndExclusion(directionEditor, directionVisible);

			// Hide the array checkbox unless the component is an array.
			InternalUtil.setVisibilityAndExclusion(arrayFlagEditor,
					model.isEnabled() && type != null && type.isComponent());

			// Update enabled state
			setEnabled(model.isEnabled());
		}
	}

	private Control addLabel(final String txt) {
		final CLabel label = new CLabel(this, SWT.NONE);
		InternalUtil.setColorsToMatchParent(label);
		label.setText(txt);
		label.setLayoutData(GridDataFactory.swtDefaults().grab(false, false).align(SWT.FILL, SWT.CENTER).create());
		return label;
	}
}