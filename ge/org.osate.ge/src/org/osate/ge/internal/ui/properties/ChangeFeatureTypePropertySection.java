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
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DataSubcomponentType;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.ProcessorFeature;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.internal.util.AadlFeatureUtil;
import org.osate.ge.internal.util.AgeEmfUtil;
import org.osate.ge.internal.util.StringUtil;
import org.osate.ge.ui.properties.PropertySectionUtil;

public class ChangeFeatureTypePropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> {
				if (bo instanceof NamedElement) {
					final NamedElement ne = (NamedElement) bo;
					// Check that the shape represents a feature and that the classifier can contain features of the type this feature changes features into.
					if (!(ne instanceof Feature || ne instanceof InternalFeature || ne instanceof ProcessorFeature)) {
						return false;
					}

					for (final EClass featureType : AadlFeatureUtil.getFeatureTypes()) {
						if (isValidFeatureType(ne, featureType)) {
							return true;
						}
					}
				}

				return false;
			});
		}
	}

	private BusinessObjectSelection selectedBos;
	private ComboViewer comboViewer;
	private EClass selectedFeatureType = null;

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		final Composite container = getWidgetFactory().createFlatFormComposite(parent);
		comboViewer = InternalPropertySectionUtil.createComboViewer(container, STANDARD_LABEL_WIDTH,
				featureTypeSelectionListener, featureTypeLabelProvider);
		comboViewer.setComparator(new ViewerComparator());
		InternalPropertySectionUtil.createSectionLabel(container, getWidgetFactory(), "Type:");
		InternalPropertySectionUtil.setPropertiesHelp(aTabbedPropertySheetPage.getControl());
	}

	private final SelectionAdapter featureTypeSelectionListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			if (selectedFeatureType != comboViewer.getStructuredSelection().getFirstElement()) {
				selectedBos.modify(NamedElement.class, feature -> {
					final Classifier featureOwner = feature.getContainingClassifier();
					final NamedElement replacementFeature = AadlFeatureUtil.createFeature(featureOwner,
							(EClass) comboViewer.getStructuredSelection().getFirstElement());

					// Copy structural feature values to the replacement object.
					AgeEmfUtil.transferStructuralFeatureValues(feature, replacementFeature);

// Handle copying the data feature classifier
					if (replacementFeature instanceof DirectedFeature) {
						final DirectedFeature replacementDirectedFeature = (DirectedFeature) replacementFeature;
						setDirection(replacementDirectedFeature, getDirection(feature));

						if (replacementFeature instanceof EventDataPort) {
							((EventDataPort) replacementFeature)
							.setDataFeatureClassifier(getDataFeatureClassifier(feature));
						} else if (replacementFeature instanceof DataPort) {
							((DataPort) replacementFeature).setDataFeatureClassifier(getDataFeatureClassifier(feature));
						}
					}

// Remove the old object
					EcoreUtil.remove(feature);
				});
			}
		}
	};

	private static void setDirection(final DirectedFeature feature, final DirectionType newDirection) {
		if (feature instanceof AbstractFeature || feature instanceof FeatureGroup) {
			feature.setIn(newDirection != DirectionType.IN_OUT && newDirection == DirectionType.IN);
			feature.setOut(newDirection != DirectionType.IN_OUT && newDirection == DirectionType.OUT);
		} else {
			feature.setIn(newDirection == DirectionType.IN_OUT || newDirection == DirectionType.IN);
			feature.setOut(newDirection == DirectionType.IN_OUT || newDirection == DirectionType.OUT);
		}
	}

	/**
	 * Returns replacement feature's direction.  Keep direction of original feature if possible.
	 * @param feature - original feature
	 * @return
	 */
	private static DirectionType getDirection(final NamedElement feature) {
		// Get direction for replacement feature
		return feature instanceof DirectedFeature ? ((DirectedFeature) feature).getDirection() : DirectionType.IN;
	}

	private final LabelProvider featureTypeLabelProvider = new LabelProvider() {
		@Override
		public String getText(final Object element) {
			final EClass featureType = (EClass) element;
			return StringUtil.camelCaseToUser(featureType.getName());
		}
	};

	private static DataSubcomponentType getDataFeatureClassifier(final NamedElement feature) {
		if (feature instanceof EventDataPort) {
			return ((EventDataPort) feature).getDataFeatureClassifier();
		} else if (feature instanceof DataPort) {
			return ((DataPort) feature).getDataFeatureClassifier();
		}

		return null;
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		final Set<NamedElement> selectedFeatures = selectedBos.boStream(NamedElement.class).collect(Collectors.toSet());
		final Set<EClass> featureTypeOptions = new HashSet<>();
		// Add to options
		final Consumer<EClass> addFeatureTypeOption = (type) -> featureTypeOptions.add(type);

// Get comboviewer selected value and populate available type options for comboviewer
		selectedFeatureType = InternalPropertySectionUtil.getTypeOptionsInformation(selectedFeatures,
				AadlFeatureUtil.getFeatureTypes(), (feature, type) -> isValidFeatureType(feature, type),
				addFeatureTypeOption);

		comboViewer.setInput(featureTypeOptions);
// Set comboviewer selection
		if (selectedFeatureType != null) {
			comboViewer.setSelection(new StructuredSelection(selectedFeatureType));
		}
	}

	private static boolean isValidFeatureType(final NamedElement feature, final EClass featureType) {
		return AadlFeatureUtil.canOwnFeatureType(feature.getContainingClassifier(), featureType)
				&& (!(feature instanceof Feature) || (((Feature) feature).getRefined() == null
				|| ((Feature) feature).getRefined() instanceof AbstractFeature));
	}
}
