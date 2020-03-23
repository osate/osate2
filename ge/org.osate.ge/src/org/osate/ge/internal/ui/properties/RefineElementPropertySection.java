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

import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.Access;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Connection;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.internal.util.AadlConnectionUtil;
import org.osate.ge.internal.util.AadlFeatureUtil;
import org.osate.ge.internal.util.SubcomponentUtil;
import org.osate.ge.ui.properties.PropertySectionUtil;

public class RefineElementPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBocCompatible(toTest, boc -> {
				final Object bo = boc.getBusinessObject();
				if (bo instanceof RefinableElement) {
					final RefinableElement re = (RefinableElement) bo;
					final Object parent = boc.getParent().getBusinessObject();
					// Return true if element is refined
					if (re.getRefinedElement() != null) {
						return true;
					}

					if (re instanceof Feature) {
						return parent instanceof Classifier && re.getContainingClassifier() != parent
								&& (parent instanceof FeatureGroupType || parent instanceof ComponentType);
					} else if (re instanceof Connection) {
						return parent instanceof ComponentImplementation && re.getContainingClassifier() != parent;
					} else if (re instanceof FlowSpecification) {
						return parent instanceof ComponentType && re.getContainingClassifier() != parent;
					} else if (re instanceof Subcomponent) {
						return parent instanceof ComponentImplementation && re.getContainingClassifier() != parent
								&& SubcomponentUtil.canContainSubcomponentType((ComponentImplementation) parent,
										re.eClass());
					}
				}
				return false;
			});
		}
	}

	private BusinessObjectSelection selectedBos;
	private Button refineBtn;

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		final Composite container = getWidgetFactory().createFlatFormComposite(parent);
		final Label sectionLabel = InternalPropertySectionUtil.createSectionLabel(container, getWidgetFactory(),
				"Refined:");

		refineBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), container, SWT.NONE,
				refineSelectionListener,
				"", SWT.CHECK);

		final FormData fd = new FormData();
		fd.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		fd.top = new FormAttachment(sectionLabel, 0, SWT.CENTER);
		refineBtn.setLayoutData(fd);

		InternalPropertySectionUtil.setPropertiesHelp(aTabbedPropertySheetPage.getControl());
	}

	private SelectionAdapter refineSelectionListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			final Button btn = (Button) e.widget;
			if (!btn.getSelection()) {
				// Remove refinement
				selectedBos.modify(NamedElement.class, ne -> {
					final RefinableElement re = (RefinableElement) ne;
					if (re.getRefinedElement() != null) {
						EcoreUtil.remove(re);
					}
				});
			} else {
				// Refine selected elements
				selectedBos.modify(boc -> (EObject) boc.getParent().getBusinessObject(), (container, boc) -> {
					final RefinableElement re = (RefinableElement) boc.getBusinessObject();
					if (re.getRefinedElement() == null) {
						if (re instanceof Feature) {
							final Feature newFeature = (Feature) AadlFeatureUtil.createFeature((Classifier) container,
									re.eClass());
							// Refine the feature
							newFeature.setRefined((Feature) re);
							if (re instanceof DirectedFeature) {
								final DirectedFeature refinedDirectedFeature = (DirectedFeature) re;
								final DirectedFeature newDirectedFeature = (DirectedFeature) newFeature;
								newDirectedFeature.setIn(refinedDirectedFeature.isIn());
								newDirectedFeature.setOut(refinedDirectedFeature.isOut());
							} else if (re instanceof Access) {
								((Access) newFeature).setKind(((Access) re).getKind());
							}
						} else if (boc.getBusinessObject() instanceof Connection) {
							final org.osate.aadl2.Connection newAadlConnection = AadlConnectionUtil
									.createConnection((ComponentImplementation) container, re.eClass());
							// Refine the connection
							newAadlConnection.setRefined((Connection) re);
						} else if (boc.getBusinessObject() instanceof FlowSpecification) {
							final FlowSpecification fs = (FlowSpecification) boc.getBusinessObject();
							final ComponentType ct = (ComponentType) container;
							// Refine the flow specification
							final FlowSpecification newFs = ct.createOwnedFlowSpecification();
							newFs.setKind(fs.getKind());
							newFs.setRefined(fs);
						} else if (boc.getBusinessObject() instanceof Subcomponent) {
							// Refine the subcomponent
							final Subcomponent newSc = SubcomponentUtil
									.createSubcomponent((ComponentImplementation) container, re.eClass());
							newSc.setRefined((Subcomponent) re);
						}
					}
				});
			}
		}
	};

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		final Set<RefinableElement> refinableElements = selectedBos.boStream(RefinableElement.class)
				.collect(Collectors.toSet());
		// Get refined state of selected elements
		final Boolean isRefined = isRefined(refinableElements);
		// Grayed state set if elements are mixed refined and not refined
		refineBtn.setGrayed(isRefined == null);
		// Set initial selection
		refineBtn.setSelection(isRefined == Boolean.TRUE);
	}

	private static Boolean isRefined(final Set<RefinableElement> refinableElements) {
		final Iterator<RefinableElement> it = refinableElements.iterator();
		// Initial value of buttons
		final Boolean isRefined = it.next().getRefinedElement() != null;

		while (it.hasNext()) {
			// Check if all elements are refined or not refined
			if (isRefined != (it.next().getRefinedElement() != null)) {
				return null;
			}
		}

		return isRefined;
	}
}
