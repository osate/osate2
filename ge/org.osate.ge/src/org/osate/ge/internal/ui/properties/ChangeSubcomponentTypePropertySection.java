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
package org.osate.ge.internal.ui.properties;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.AbstractSubcomponent;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.internal.util.AgeEmfUtil;
import org.osate.ge.internal.util.StringUtil;
import org.osate.ge.internal.util.SubcomponentUtil;
import org.osate.ge.ui.properties.PropertySectionUtil;

public class ChangeSubcomponentTypePropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> {
				return bo instanceof Subcomponent
						&& ((Subcomponent) bo).getContainingClassifier() instanceof ComponentImplementation;
			});
		}
	}

	private BusinessObjectSelection selectedBos;
	private ComboViewer comboViewer;
	private EClass selectedScType = null;

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		final Composite container = getWidgetFactory().createFlatFormComposite(parent);
		comboViewer = InternalPropertySectionUtil.createComboViewer(container, STANDARD_LABEL_WIDTH,
				scTypeSelectionListener, subcompTypeLabelProvider);
		comboViewer.setComparator(new ViewerComparator());
		InternalPropertySectionUtil.createSectionLabel(container, getWidgetFactory(), "Type:");
		InternalPropertySectionUtil.setPropertiesHelp(aTabbedPropertySheetPage.getControl());
	}

	private final SelectionAdapter scTypeSelectionListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			final SubcomponentTypeElement scTypeElement = (SubcomponentTypeElement) comboViewer.getStructuredSelection()
					.getFirstElement();
			// Check if selection has changed
			if (selectedScType != scTypeElement.getType()) {
				selectedBos.modify(Subcomponent.class, sc -> {
					final ComponentImplementation ci = sc.getContainingComponentImpl();

					// Copy structural feature values to the replacement object.
					AgeEmfUtil.transferStructuralFeatureValues(sc,
							SubcomponentUtil.createSubcomponent(ci, scTypeElement.getType()));

					// Remove the old object
					EcoreUtil.remove(sc);
				});
			}
		}
	};

	private final LabelProvider subcompTypeLabelProvider = new LabelProvider() {
		@Override
		public String getText(final Object element) {
			final SubcomponentTypeElement scTypeElement = (SubcomponentTypeElement) element;
			return scTypeElement.getName();
		}
	};

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		final Set<Subcomponent> selectedSubcomponenents = selectedBos.boStream(Subcomponent.class)
				.collect(Collectors.toSet());
		final Set<SubcomponentTypeElement> subcomponentTypeOptions = new HashSet<>();
		// Add to options
		final Consumer<EClass> addSubcomponentTypeElement = (type) -> subcomponentTypeOptions
				.add(new SubcomponentTypeElement(type));

		// Get comboviewer selected value and populate available type options for comboviewer
		selectedScType = InternalPropertySectionUtil.getTypeOptionsInformation(selectedSubcomponenents,
				SubcomponentUtil.getSubcomponentTypes(), (sc, type) -> isCompatibleSubcomponentType(sc, type),
				addSubcomponentTypeElement);

		comboViewer.setInput(subcomponentTypeOptions);
		// Set comboviewer selection
		if (selectedScType != null) {
			subcomponentTypeOptions.stream().filter(scTypeElement -> selectedScType == scTypeElement.getType())
			.findAny().ifPresent(scTypeElement -> {
				comboViewer.setSelection(new StructuredSelection(scTypeElement));
			});
		}
	}

	private static boolean isCompatibleSubcomponentType(final Subcomponent sc, final EClass subcomponentType) {
		final ComponentImplementation ci = sc.getContainingComponentImpl();
		return (SubcomponentUtil.canContainSubcomponentType(ci, subcomponentType)
				&& (sc.getRefined() == null || sc.getRefined() instanceof AbstractSubcomponent))
				|| subcomponentType == sc.eClass();
	}

	private class SubcomponentTypeElement {
		final EClass type;
		final String name;

		private SubcomponentTypeElement(final EClass type) {
			this.type = type;
			this.name = setName(type.getName());
		}

		// Remove redundancy in comboviewer options
		private String setName(final String name) {
			final String tmpName = StringUtil.camelCaseToUser(name);
			return tmpName.substring(0, tmpName.lastIndexOf(" "));
		}

		private String getName() {
			return name;
		}

		private EClass getType() {
			return type;
		}
	}
}
