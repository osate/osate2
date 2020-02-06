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
package org.osate.ge.internal.ui.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.RowDataFactory;
import org.eclipse.jface.layout.RowLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.osate.aadl2.ComponentCategory;
import org.osate.ge.internal.ui.util.UiUtil;
import org.osate.ge.internal.util.StringUtil;
import org.osate.ge.internal.util.classifiers.ClassifierOperationPart;
import org.osate.ge.internal.util.classifiers.ClassifierOperationPartType;

import com.google.common.base.CaseFormat;
import com.google.common.collect.ImmutableList;

class ClassifierOperationPartEditor extends Composite {
	private ElementLabelProvider elementLabelProvider = new ElementLabelProvider();
	private final CopyOnWriteArrayList<SelectionListener> selectionListeners = new CopyOnWriteArrayList<>();
	private final Group operationGroup;
	private final Label existingLabel;
	private final Composite existingValueContainer;
	private final Label existingValueLabel;
	private final Label componentCategoryLabel;
	private final ComboViewer componentCategoryField;
	private final Label packageLabel;
	private final Composite packageValueContainer;
	private final Label selectedPackageLabel;
	private final Label identifierLabel;
	private final Text identifierField;
	private final List<Button> operationPartTypeBtns = new ArrayList<>();
	private final boolean showPackageSelector;
	private final Value currentValue = new Value();

	static interface Model {
		Collection<?> getPackageOptions();

		Collection<?> getSelectOptions();

		Collection<?> getUnfilteredSelectOptions();

		String getSelectTitle();

		String getSelectMessage();
	}

	/**
	 * Private class that stores mutable value.
	 *
	 */
	private class Value {
		ClassifierOperationPartType type;
		private Object selectedPackage;
		private Object selectedElement;
		private String identifier = "";
		private ComponentCategory componentCategory;

		public ClassifierOperationPart toConfiguredOperation() {
			return new ClassifierOperationPart(type, selectedPackage, identifier, componentCategory,
					selectedElement);
		}
	}

	public ClassifierOperationPartEditor(final Composite parent,
			final EnumSet<ClassifierOperationPartType> allowedOperations, final boolean showPackageSelector,
			final ImmutableList<ComponentCategory> componentCategories,
			final ClassifierOperationPartEditor.Model widgetModel) {
		super(parent, SWT.NONE);
		this.showPackageSelector = showPackageSelector;
		setLayout(GridLayoutFactory.fillDefaults().numColumns(2).create());

		//
		// Operations
		//
		operationGroup = new Group(this, SWT.NONE);
		operationGroup.setLayout(RowLayoutFactory.fillDefaults().type(SWT.HORIZONTAL).wrap(true).create());
		operationGroup.setLayoutData(GridDataFactory.fillDefaults().span(2, 1).grab(true, false).create());

		final SelectionListener operationSelectedListener = new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final Button btn = ((Button) e.widget);
				if (btn.getSelection()) {
					currentValue.type = (ClassifierOperationPartType) btn.getData();

					notifySelectionListeners();
					updateOperationDetailsVisibility();
				}
			}
		};

		for (final ClassifierOperationPartType operation : ClassifierOperationPartType.values()) {
			final Button newBtn = new Button(operationGroup, SWT.RADIO);
			newBtn.setText(StringUtil
					.camelCaseToUser(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, operation.toString())));
			newBtn.setData(operation);
			newBtn.addSelectionListener(operationSelectedListener);
			operationPartTypeBtns.add(newBtn);
		}

		setAllowedOperations(allowedOperations);

		//
		// Select Existing
		//
		existingLabel = new Label(this, SWT.NONE);
		existingLabel.setText("Existing:");
		existingLabel.setLayoutData(GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.CENTER).create());

		final RowLayout existingValueContainerLayout = new RowLayout(SWT.HORIZONTAL);
		existingValueContainerLayout.center = true;
		existingValueContainer = new Composite(this, SWT.NONE);
		existingValueContainer.setLayout(existingValueContainerLayout);
		existingValueContainer.setLayoutData(GridDataFactory.fillDefaults().create());

		existingValueLabel = new Label(existingValueContainer, SWT.NONE);
		existingValueLabel.setText(ClassifierOperationDialog.NOT_SELECTED_LABEL);

		final Button selectExistingBtn = new Button(existingValueContainer, SWT.NONE);
		selectExistingBtn.setText("...");

		selectExistingBtn.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				final ElementSelectionDialog dlg = new ElementSelectionDialog(Display.getCurrent().getActiveShell(),
						widgetModel.getSelectTitle(), widgetModel.getSelectMessage(),
						widgetModel.getSelectOptions(), "Show All", widgetModel.getUnfilteredSelectOptions(),
						false);
				if (dlg.open() == Window.OK) {
					setSelectedElement(dlg.getFirstSelectedElement());
					notifySelectionListeners();
				}
			}
		});

		//
		// Create
		//
		componentCategoryLabel = new Label(this, SWT.NONE);
		componentCategoryLabel.setText("Component Category:");

		componentCategoryField = new ComboViewer(this, SWT.DROP_DOWN | SWT.READ_ONLY);
		componentCategoryField.setComparator(new ViewerComparator());
		componentCategoryField.setContentProvider(new ArrayContentProvider());
		componentCategoryField.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return Arrays.stream(element.toString().split(" ")).map(StringUtil::capitalize)
						.collect(Collectors.joining(" "));
			}
		});
		setAllowedComponentCategories(componentCategories);
		componentCategoryField.addPostSelectionChangedListener(event -> {
			setSelectedComponentCategory((ComponentCategory) componentCategoryField.getStructuredSelection().getFirstElement());
			notifySelectionListeners();
		});

		packageLabel = new Label(this, SWT.NONE);
		packageLabel.setText("Package:");
		packageLabel.setLayoutData(GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.CENTER).create());

		final RowLayout packageValueContainerLayout = new RowLayout(SWT.HORIZONTAL);
		packageValueContainerLayout.center = true;
		packageValueContainer = new Composite(this, SWT.NONE);
		packageValueContainer.setLayout(packageValueContainerLayout);
		packageValueContainer
		.setLayoutData(GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.CENTER).create());

		selectedPackageLabel = new Label(packageValueContainer, SWT.NONE);
		selectedPackageLabel.setText(ClassifierOperationDialog.NOT_SELECTED_LABEL);

		final Button selectPackageBtn = new Button(packageValueContainer, SWT.NONE);
		selectPackageBtn.setText("...");

		selectPackageBtn.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				final ElementSelectionDialog dlg = new ElementSelectionDialog(Display.getCurrent().getActiveShell(),
						"Select a Package", "Select a package.", widgetModel.getPackageOptions(), false);
				if (dlg.open() == Window.OK) {
					setSelectedPackage(dlg.getFirstSelectedElement());
					notifySelectionListeners();
				}
			}
		});

		identifierLabel = new Label(this, SWT.NONE);
		identifierLabel.setText("Identifier:");
		identifierLabel.setLayoutData(GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.CENTER).create());
		identifierField = new Text(this, SWT.SINGLE | SWT.BORDER);
		identifierField.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());
		identifierField.addModifyListener(e -> {
			currentValue.identifier = identifierField.getText();
			notifySelectionListeners();
		});

		// Update widget visibility
		updateOperationDetailsVisibility();
	}

	public void setAllowedComponentCategories(final ImmutableList<ComponentCategory> componentCategories) {
		Objects.requireNonNull(componentCategories, "componentCategories must not be null");
		componentCategoryField.setInput(componentCategories);

		final boolean visible = componentCategories.size() > 1;
		componentCategoryLabel.setVisible(visible);
		componentCategoryField.getCombo().setVisible(visible);

		componentCategoryLabel.setLayoutData(GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.CENTER).exclude(!visible).create());
		componentCategoryField.getCombo().setLayoutData(GridDataFactory.fillDefaults().exclude(!visible).create());

		requestLayout();
	}

	public void setAllowedOperations(final EnumSet<ClassifierOperationPartType> allowedOperations) {
		if (allowedOperations == null || allowedOperations.size() == 0) {
			throw new RuntimeException("allowedOperations must contain at least one operation.");
		}

		setGridChildVisible(operationGroup, allowedOperations.size() > 1);

		if (allowedOperations.size() > 1) {
			ClassifierOperationPartType newType = null;

			// Update the visibility of the operation part type buttons
			for (final Button typeBtn : operationPartTypeBtns) {
				final boolean typeIsAllowed = allowedOperations.contains(typeBtn.getData());
				typeBtn.setVisible(typeIsAllowed);
				typeBtn.setLayoutData(RowDataFactory.swtDefaults().exclude(!typeIsAllowed).create());
				if (typeIsAllowed && typeBtn.getData() == currentValue.type) {
					newType = currentValue.type;
				}
			}

			// Update the current operation to reflect the UI
			setCurrentOperationPartType(newType);

			operationGroup.requestLayout();
		} else {
			setCurrentOperationPartType(allowedOperations.iterator().next());
		}

		updateOperationDetailsVisibility();

		// Request Layout
		requestLayout();
	}

	/**
	 * Selection listeners are called when the value of the widget changes.
	 * @param listener
	 */
	public void addSelectionListener(final SelectionListener listener) {
		selectionListeners.add(listener);
	}

	void setCurrentOperationPartType(final ClassifierOperationPartType value) {
		final boolean opIsChanging = currentValue.type != value;
		currentValue.type = value;
		if (opIsChanging) {
			notifySelectionListeners();
		}

		// Update button selection to reflect the new type
		for (final Button typeBtn : operationPartTypeBtns) {
			final boolean isSelectedType = typeBtn.getData() == currentValue.type;
			typeBtn.setSelection(isSelectedType);
		}

		updateOperationDetailsVisibility();
	}

	void setSelectedElement(final Object element) {
		currentValue.selectedElement = element;
		existingValueLabel.setText(getElementDescription(element));
		existingValueContainer.requestLayout();
	}

	void setSelectedComponentCategory(final ComponentCategory category) {
		currentValue.componentCategory = category;
		if (componentCategoryField.getStructuredSelection().getFirstElement() != category) {
			componentCategoryField
			.setSelection(category == null ? StructuredSelection.EMPTY : new StructuredSelection(category));
		}
	}

	void setSelectedPackage(final Object pkg) {
		currentValue.selectedPackage = pkg;
		selectedPackageLabel.setText(getElementDescription(pkg));
		packageValueContainer.requestLayout();
	}

	private String getElementDescription(final Object value) {
		if (value == null) {
			return ClassifierOperationDialog.NOT_SELECTED_LABEL;
		}

		final String desc = elementLabelProvider.getText(value);
		return desc == null ? "<null>" : desc;
	}

	private void notifySelectionListeners() {
		final Event e = new Event();
		e.widget = this;
		final SelectionEvent selectionEvent = new SelectionEvent(e);
		for (final SelectionListener l : selectionListeners) {
			l.widgetSelected(selectionEvent);
		}
	}

	private static void setGridChildVisible(final Control c, final boolean visible) {
		// Check for null to support widgets that are not created because they are not necessary for the allowed operations
		if (c != null) {
			if (c.getLayoutData() == null) {
				c.setLayoutData(GridDataFactory.fillDefaults().create());
			}

			((GridData) c.getLayoutData()).exclude = !visible;
			// c.setLayoutData(GridDataFactory.fillDefaults().exclude(!visible).create());
			c.setVisible(visible);
		}
	}

	private void updateOperationDetailsVisibility() {
		final boolean selectExisting = currentValue.type == ClassifierOperationPartType.EXISTING;
		setGridChildVisible(existingLabel, selectExisting);
		setGridChildVisible(existingValueContainer, selectExisting);

		final boolean createNew = ClassifierOperationPartType.isCreate(currentValue.type);
		setGridChildVisible(identifierLabel, createNew);
		setGridChildVisible(identifierField, createNew);

		final boolean showPackageWidgets = showPackageSelector && createNew;
		setGridChildVisible(packageLabel, showPackageWidgets);
		setGridChildVisible(packageValueContainer, showPackageWidgets);

		requestLayout();
	}

	public ClassifierOperationPart getConfiguredOperation() {
		return currentValue.toConfiguredOperation();
	}

	public void setData(final String id) {
		identifierField.setData(UiUtil.AUTOMATED_SWTBOT_TESTING_KEY, id);
	}
}