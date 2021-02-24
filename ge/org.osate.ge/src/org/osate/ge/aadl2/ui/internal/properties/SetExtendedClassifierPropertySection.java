/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.aadl2.ui.internal.properties;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.Strings;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.aadl2.internal.util.AadlImportsUtil;
import org.osate.ge.aadl2.ui.AadlModelAccessUtil;
import org.osate.ge.aadl2.ui.internal.dialogs.ElementSelectionDialog;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.ui.PropertySectionUtil;

import com.google.common.base.Objects;

public class SetExtendedClassifierPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> {
				return bo instanceof ComponentType || bo instanceof ComponentImplementation
						|| bo instanceof FeatureGroupType;
			});
		}
	}

	private BusinessObjectSelection selectedBos;
	private Label extendedClassifier;
	private Button chooseBtn;

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		FormData fd;

		final Composite container = getWidgetFactory().createFlatFormComposite(parent);
		PropertySectionUtil.createSectionLabel(container, getWidgetFactory(), "Extends:");

		extendedClassifier = getWidgetFactory().createLabel(container, new String());
		fd = new FormData();
		fd.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		fd.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		extendedClassifier.setLayoutData(fd);

		chooseBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), container, null,
				setExtendedClassifierListener, "Choose...", SWT.PUSH);

		fd = new FormData();
		fd.left = new FormAttachment(extendedClassifier, ITabbedPropertyConstants.HSPACE);
		fd.top = new FormAttachment(extendedClassifier, 0, SWT.CENTER);
		chooseBtn.setLayoutData(fd);

		InternalPropertySectionUtil.setPropertiesHelp(aTabbedPropertySheetPage.getControl());
	}

	final SelectionListener setExtendedClassifierListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			final List<Classifier> classifiers = selectedBos.boStream(Classifier.class).collect(Collectors.toList());
			final Iterator<Classifier> it = classifiers.iterator();
			final Classifier classifier = it.next();
			final List<IEObjectDescription> extensibleClassifierDescs = getExtensibleClassifierDescriptions(classifier);
			while (it.hasNext()) {
				extensibleClassifierDescs.retainAll(getExtensibleClassifierDescriptions(it.next()));
			}

			// Prompt the user for the element
			final ElementSelectionDialog dlg = new ElementSelectionDialog(Display.getCurrent().getActiveShell(),
					"Select a Classifier", "Select a classifier to extend.", extensibleClassifierDescs);
			if (dlg.open() != Window.CANCEL) {
				// Resolve the selected classifier
				final Classifier classifierToExtend = (dlg.getFirstSelectedElement() != null
						&& ((EObject) dlg.getFirstSelectedElement()).eIsProxy())
						? (Classifier) EcoreUtil.resolve(((EObject) dlg.getFirstSelectedElement()),
								classifier.eResource())
								: (Classifier) dlg.getFirstSelectedElement();
						selectedBos.modify(Classifier.class, classifierToModify -> {
							if (classifierToExtend != null) {
								AadlImportsUtil.ensurePackageIsImportedForClassifier(classifierToModify, classifierToExtend);

								// Don't create an extension if the classifier hasn't changed. Creating identical extensions
								// can cause xtext validation errors regardless of whether the old extension is removed first.
								if (classifierToModify.getExtended() == null
										|| !Objects.equal(classifierToModify.getExtended().getQualifiedName(),
												classifierToExtend.getQualifiedName())) {

									// Extend the classifier
									if (classifierToModify instanceof ComponentType) {
										((ComponentType) classifierToModify).createOwnedExtension()
										.setExtended((ComponentType) classifierToExtend);
									} else if (classifierToModify instanceof ComponentImplementation) {
										((ComponentImplementation) classifierToModify).createOwnedExtension()
										.setExtended((ComponentImplementation) classifierToExtend);
									} else if (classifierToModify instanceof FeatureGroupType) {
										((FeatureGroupType) classifierToModify).createOwnedExtension()
										.setExtended((FeatureGroupType) classifierToExtend);
									}
								}
							} else {
								// Extend the classifier
								if (classifierToModify instanceof ComponentType) {
									removeIfNotNull(((ComponentType) classifierToModify).getOwnedExtension());
								} else if (classifierToModify instanceof ComponentImplementation) {
									removeIfNotNull(((ComponentImplementation) classifierToModify).getOwnedExtension());
								} else if (classifierToModify instanceof FeatureGroupType) {
									removeIfNotNull(((FeatureGroupType) classifierToModify).getOwnedExtension());
								}
							}
						});
			}
		}
	};

	private static void removeIfNotNull(final EObject obj) {
		if (obj != null) {
			EcoreUtil.remove(obj);
		}
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		final List<Classifier> classifiers = selectedBos.boStream(Classifier.class).collect(Collectors.toList());
		extendedClassifier.setText(getExtendedClassifierLabel(classifiers));
	}

	private static String getExtendedClassifierLabel(final List<Classifier> elements) {
		final Iterator<Classifier> it = elements.iterator();
		final Classifier extClassifier = getExtended(it.next());
		while (it.hasNext()) {
			if (extClassifier != getExtended(it.next())) {
				return "<Multiple>";
			}
		}

		return getClassifierName(extClassifier);
	}

	private static String getClassifierName(final Classifier c) {
		if (c == null) {
			return "<None>";
		} else if (c instanceof NamedElement) {
			return Strings.emptyIfNull(((NamedElement) c).getQualifiedName());
		} else {
			return "";
		}
	}

	private static Classifier getExtended(final Classifier classifier) {
		Classifier extendedObject;
		if (classifier instanceof ComponentType) {
			extendedObject = ((ComponentType) classifier).getExtended();
		} else if (classifier instanceof ComponentImplementation) {
			extendedObject = ((ComponentImplementation) classifier).getExtended();
		} else if (classifier instanceof FeatureGroupType) {
			extendedObject = ((FeatureGroupType) classifier).getExtended();
		} else {
			throw new RuntimeException("Unsupported type: " + classifier);
		}

		return extendedObject == null ? null : extendedObject;
	}

	/**
	 * Return a list of EObjectDescriptions for classifiers that could be extended.
	 * The result will includes null since extending no classifier is a valid option.
	 * @return
	 */
	private List<IEObjectDescription> getExtensibleClassifierDescriptions(final Classifier classifier) {
		final List<IEObjectDescription> objectDescriptions = new ArrayList<IEObjectDescription>();
		objectDescriptions.add(null);

		final String name = classifier.getQualifiedName();

		// Populate the list with valid classifier descriptions
		if (name != null) {
			for (final IEObjectDescription desc : AadlModelAccessUtil.getAllEObjectsByType(classifier.eResource(),
					classifier.eClass())) {
				if (!name.equalsIgnoreCase(desc.getName().toString("::"))) {
					objectDescriptions.add(desc);
				}
			}

			// Ensure that abstract classifiers are in the list
			if (classifier instanceof ComponentType) {
				if (classifier.eClass() != Aadl2Package.eINSTANCE.getAbstractType()) {
					for (final IEObjectDescription desc : AadlModelAccessUtil.getAllEObjectsByType(
							classifier.eResource(), Aadl2Package.eINSTANCE.getAbstractType())) {
						if (!name.equalsIgnoreCase(desc.getName().toString("::"))) {
							objectDescriptions.add(desc);
						}
					}
				}
			} else if (classifier instanceof ComponentImplementation) {
				if (classifier.eClass() != Aadl2Package.eINSTANCE.getAbstractImplementation()) {
					for (final IEObjectDescription desc : AadlModelAccessUtil.getAllEObjectsByType(
							classifier.eResource(),
							Aadl2Package.eINSTANCE.getAbstractImplementation())) {
						if (!name.equalsIgnoreCase(desc.getName().toString("::"))) {
							objectDescriptions.add(desc);
						}
					}
				}
			}
		}

		return objectDescriptions;
	}
}
