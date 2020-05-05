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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
import org.eclipse.swt.layout.FormLayout;
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
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.AbstractFeatureClassifier;
import org.osate.aadl2.BusFeatureClassifier;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.DataSubcomponentType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureClassifier;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.SubprogramClassifier;
import org.osate.aadl2.SubprogramGroupSubcomponentType;
import org.osate.aadl2.SubprogramSubcomponentType;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.operations.OperationExecutor;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.ui.dialogs.ClassifierOperationDialog;
import org.osate.ge.internal.ui.dialogs.DefaultCreateSelectClassifierDialogModel;
import org.osate.ge.internal.ui.dialogs.ElementSelectionDialog;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.internal.util.AadlClassifierUtil;
import org.osate.ge.internal.util.AadlHelper;
import org.osate.ge.internal.util.AadlImportsUtil;
import org.osate.ge.internal.util.AadlPrototypeUtil;
import org.osate.ge.internal.util.EditingUtil;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;
import org.osate.ge.internal.util.classifiers.ClassifierOperation;
import org.osate.ge.internal.util.classifiers.ClassifierOperationExecutor;
import org.osate.ge.internal.util.classifiers.ClassifierOperationPartType;
import org.osate.ge.operations.Operation;
import org.osate.ge.ui.properties.PropertySectionUtil;
import org.osgi.framework.FrameworkUtil;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;

public class SetFeatureClassifierPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> {
				if (bo instanceof Feature) {
					final Feature feature = (Feature) bo;
					return featureTypeToMetadataMap.containsKey(feature.eClass());
				}

				return false;
			});
		}
	}

	private static Map<EClass, FeatureClassifierMetadata> featureTypeToMetadataMap = new HashMap<EClass, FeatureClassifierMetadata>();

	static {
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		featureTypeToMetadataMap.put(p.getBusAccess(), new FeatureClassifierMetadata(
				p.getBusFeatureClassifier(), BusFeatureClassifier.class, "setBusFeatureClassifier",
				ImmutableList.of(ComponentCategory.BUS, ComponentCategory.VIRTUAL_BUS)));
		featureTypeToMetadataMap.put(p.getDataAccess(), new FeatureClassifierMetadata(
				p.getDataSubcomponentType(), DataSubcomponentType.class, "setDataFeatureClassifier",
				ImmutableList.of(ComponentCategory.DATA)));
		featureTypeToMetadataMap.put(p.getSubprogramAccess(), new FeatureClassifierMetadata(
				p.getSubprogramSubcomponentType(), SubprogramSubcomponentType.class, "setSubprogramFeatureClassifier",
				ImmutableList.of(ComponentCategory.SUBPROGRAM)));
		featureTypeToMetadataMap.put(p.getSubprogramGroupAccess(),
				new FeatureClassifierMetadata(p.getSubprogramGroupSubcomponentType(),
						SubprogramGroupSubcomponentType.class, "setSubprogramGroupFeatureClassifier",
						ImmutableList.of(ComponentCategory.SUBPROGRAM_GROUP)));
		featureTypeToMetadataMap.put(p.getAbstractFeature(), new FeatureClassifierMetadata(
				p.getAbstractFeatureClassifier(), AbstractFeatureClassifier.class, "setAbstractFeatureClassifier",
				ImmutableList.of(ComponentCategory.ABSTRACT, ComponentCategory.DATA, ComponentCategory.BUS,
						ComponentCategory.VIRTUAL_BUS, ComponentCategory.SUBPROGRAM,
						ComponentCategory.SUBPROGRAM_GROUP)));
		featureTypeToMetadataMap.put(p.getFeatureGroup(),
				new FeatureClassifierMetadata(p.getFeatureType(), FeatureType.class, "setFeatureType",
						ImmutableList.of()));
		featureTypeToMetadataMap.put(p.getParameter(), new FeatureClassifierMetadata(
				p.getDataSubcomponentType(), DataSubcomponentType.class, "setDataFeatureClassifier",
				ImmutableList.of(ComponentCategory.DATA)));
		featureTypeToMetadataMap.put(p.getDataPort(), new FeatureClassifierMetadata(
				p.getDataSubcomponentType(), DataSubcomponentType.class, "setDataFeatureClassifier",
				ImmutableList.of(ComponentCategory.DATA)));
		featureTypeToMetadataMap.put(p.getEventDataPort(), new FeatureClassifierMetadata(
				p.getDataSubcomponentType(), DataSubcomponentType.class, "setDataFeatureClassifier",
				ImmutableList.of(ComponentCategory.DATA)));
		featureTypeToMetadataMap.put(p.getEventDataSource(),
				new FeatureClassifierMetadata(p.getDataClassifier(), DataClassifier.class, "setDataClassifier",
						ImmutableList.of(ComponentCategory.DATA)));
		featureTypeToMetadataMap.put(p.getPortProxy(),
				new FeatureClassifierMetadata(p.getDataClassifier(), DataClassifier.class, "setDataClassifier", ImmutableList.of(ComponentCategory.BUS)));
		featureTypeToMetadataMap.put(p.getSubprogramProxy(), new FeatureClassifierMetadata(
				p.getSubprogramClassifier(), SubprogramClassifier.class, "setSubprogramClassifier",
				ImmutableList.of(ComponentCategory.SUBPROGRAM)));
	}

	/**
	 * Holds information used to implement property section functionality that is specific to the type of feature.
	 *
	 */
	private static class FeatureClassifierMetadata {
		private final EClass classifierEClass;
		private final Class<?> classifierClass;
		private final String setterName;
		private final ImmutableList<ComponentCategory> createComponentCategories; // Component categories which are allowed if creating a new one.

		public FeatureClassifierMetadata(final EClass classifierEClass, final Class<?> classifierClass,
				final String setterName, final ImmutableList<ComponentCategory> componentCategories) {
			this.classifierEClass = classifierEClass;
			this.classifierClass = classifierClass;
			this.setterName = setterName;
			this.createComponentCategories = componentCategories;
		}
	}

	private BusinessObjectSelection selectedBos;
	private Label curFeatureClassifier;
	private Button chooseBtn;
	private Button createBtn;

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		FormData fd;

		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		final Composite container = getWidgetFactory().createComposite(composite);
		final Label sectionLabel = InternalPropertySectionUtil.createSectionLabel(composite, getWidgetFactory(),
				"Classifier:");

		container.setLayout(new FormLayout());
		fd = new FormData();
		fd.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		fd.top = new FormAttachment(sectionLabel, 0, SWT.CENTER);
		container.setLayoutData(fd);

		curFeatureClassifier = getWidgetFactory().createLabel(container, new String());
		fd = new FormData();
		fd.left = new FormAttachment(0, 0);
		fd.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		curFeatureClassifier.setLayoutData(fd);

		chooseBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), container, null, setClassifierListener,
				"Choose...", SWT.PUSH);

		fd = new FormData();
		fd.left = new FormAttachment(curFeatureClassifier, ITabbedPropertyConstants.HSPACE);
		fd.top = new FormAttachment(curFeatureClassifier, 0, SWT.CENTER);
		chooseBtn.setLayoutData(fd);

		createBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), container, null,
				createClassifierListener, "Create...", SWT.PUSH);

		fd = new FormData();
		fd.left = new FormAttachment(chooseBtn, ITabbedPropertyConstants.HSPACE);
		fd.top = new FormAttachment(chooseBtn, 0, SWT.CENTER);
		createBtn.setLayoutData(fd);

		InternalPropertySectionUtil.setPropertiesHelp(aTabbedPropertySheetPage.getControl());
	}

	final SelectionListener setClassifierListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			final List<Feature> features = selectedBos.boStream(Feature.class).collect(Collectors.toList());
			final Iterator<Feature> it = features.iterator();
			final Feature feature = it.next();
			final List<Object> potentialFeatureClassifiers = new ArrayList<>(getPotentialFeatureClassifiers(feature));
			// List will contain classifiers that are available to all selected elements
			while (it.hasNext()) {
				potentialFeatureClassifiers.retainAll(getPotentialFeatureClassifiers(it.next()));
			}

			// Prompt the user for the element
			final ElementSelectionDialog dlg = new ElementSelectionDialog(Display.getCurrent().getActiveShell(),
					"Select a Classifier", "Select a classifier.", potentialFeatureClassifiers);
			if (dlg.open() != Window.CANCEL) {
				// Import the package if necessary
				final EObject selectedType;
				if (dlg.getFirstSelectedElement() != null) {
					// Resolve the reference
					selectedType = EcoreUtil.resolve((EObject) dlg.getFirstSelectedElement(), feature.eResource());
				} else {
					selectedType = null;
				}

				// Set the classifier
				selectedBos.modify(Feature.class, f -> {
					setFeatureClassifier(f, selectedType);
				});
			}
		}
	};

	final SelectionListener createClassifierListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			final List<Feature> features = selectedBos.boStream(Feature.class).collect(Collectors.toList());

			// It should be safe to assume that the EClass of all selected feature match because the button would be disabled otherwise.
			final FeatureClassifierMetadata metadata = featureTypeToMetadataMap.get(features.get(0).eClass());

			// Get required services
			final IEclipseContext context = EclipseContextFactory
					.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
			final NamingService namingService = Objects.requireNonNull(context.getActive(NamingService.class),
					"Unable to retrieve naming service");
			final AadlModificationService aadlModService = Objects.requireNonNull(
					context.getActive(AadlModificationService.class), "Unable to retrieve AADL modification service");

			// Determine project to use
			final IProject project = AadlHelper.getCommonProject(features)
					.orElseThrow(() -> new RuntimeException("Unable to determine project"));

			// Get the resource set to use. Use the resource set from the selected model elements to ensure the proper model elements are modified.
			// If the resource set did not match for all model elements, the create button would be disabled
			final ResourceSet rs = features.get(0).eResource().getResourceSet();

			final ClassifierOperationDialog.Model model = new DefaultCreateSelectClassifierDialogModel(namingService,
					rs, "Configure classifier.") {
				@Override
				public String getTitle() {
					return "Create Classifier";
				}

				@Override
				public Collection<?> getPackageOptions() {
					return AadlHelper.getEditablePackages(project);
				}

				@Override
				public Collection<?> getBaseSelectOptions(final ClassifierOperationPartType primaryOperation) {
					return metadata.createComponentCategories.stream()
							.map(cc -> AadlClassifierUtil.getValidBaseClassifierDescriptions(project, cc,
									primaryOperation == ClassifierOperationPartType.NEW_COMPONENT_IMPLEMENTATION))
							.reduce(Sets::union).orElse(Collections.emptySet());
				}
			};

			// Show the dialog to determine the operation
			final boolean isFeatureGroup = metadata.classifierEClass == Aadl2Factory.eINSTANCE.getAadl2Package()
					.getFeatureType();

			final ClassifierOperationDialog.ArgumentBuilder argBuilder = new ClassifierOperationDialog.ArgumentBuilder(
					model,
					isFeatureGroup ? EnumSet.of(ClassifierOperationPartType.NEW_FEATURE_GROUP_TYPE)
							: EnumSet.of(ClassifierOperationPartType.NEW_COMPONENT_TYPE,
									ClassifierOperationPartType.NEW_COMPONENT_IMPLEMENTATION))
					.defaultPackage(AadlHelper.getCommonPackage(features).orElse(null))
					.componentCategories(metadata.createComponentCategories);

			final ClassifierOperation classifierOp = ClassifierOperationDialog
					.show(Display.getCurrent().getActiveShell(), argBuilder.create());

			if (classifierOp != null) {
				final Operation op = Operation.create(opBuilder -> {
					// Add actual operation steps to the operation builder based on the classifier operation
					final ClassifierOperationExecutor classifierOperationHandler = new ClassifierOperationExecutor(
							namingService, rs, project);
					opBuilder = classifierOperationHandler.execute(opBuilder, classifierOp, null);

					// Modify the subcomponents based on the result of the classifier operation
					selectedBos.modifyWithOperation(opBuilder, Feature.class, (featureToModify, classifier) -> {
						final EObject resolvedClassifier = EditingUtil
								.resolveWithLiveResourceSetIfProject((EObject) classifier, project);

						setFeatureClassifier(featureToModify, resolvedClassifier);
					});
				});

				// Execute the operation
				new OperationExecutor(aadlModService).execute(op);
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
		final List<Feature> features = selectedBos.boStream(Feature.class).collect(Collectors.toList());
		curFeatureClassifier.setText(getFeatureClassifierLabel(features));

		createBtn.setEnabled(
				!features.isEmpty() && features.stream().allMatch(f -> f.eClass() == features.get(0).eClass())
				&& EditingUtil.allHaveSameValidResourceSet(features)
				&& AadlHelper.getCommonProject(features).isPresent());
	}

	private static String getFeatureClassifierLabel(final List<Feature> features) {
		final Iterator<Feature> it = features.iterator();
		final EObject fc = getAllFeatureClassifier(it.next());
		while (it.hasNext()) {
			// If feature classifiers are not the same, set to multiple
			if (fc != getAllFeatureClassifier(it.next())) {
				return "<Multiple>";
			}
		}

		return getFeatureClassifierName(fc);
	}

	private static EObject getAllFeatureClassifier(Feature feature) {
		if (feature instanceof FeatureGroup) {
			final FeatureGroup fg = (FeatureGroup) feature;
			return fg.getAllClassifier();
		}

		FeatureClassifier result;
		do {
			result = feature.getFeatureClassifier();
			feature = feature.getRefined();
		} while (feature != null && result == null);

		return result;
	}

	private static String getFeatureClassifierName(final EObject fc) {
		if (fc == null) {
			return "<None>";
		} else if (fc instanceof NamedElement) {
			return Strings.emptyIfNull(((NamedElement) fc).getQualifiedName());
		} else if (fc instanceof Prototype) {
			return "<Prototype>";
		} else {
			return "";
		}
	}

	/**
	 * Return a list of EObjectDescriptions and NamedElements for potential classifiers for the specified feature
	 * @return
	 */
	private List<Object> getPotentialFeatureClassifiers(final NamedElement feature) {
		final List<Object> featureClassifiers = new ArrayList<Object>();
		featureClassifiers.add(null);

		final FeatureClassifierMetadata setterInfo = featureTypeToMetadataMap.get(feature.eClass());
		// Populate the list with valid classifier descriptions
		for (final IEObjectDescription desc : ScopedEMFIndexRetrieval.getAllEObjectsByType(feature.eResource(),
				setterInfo.classifierEClass)) {
			featureClassifiers.add(desc);
		}

		// Add any prototypes that are of the appropriate type
		AadlPrototypeUtil.getAllPrototypes(feature.getContainingClassifier()).forEachOrdered(p -> {
			if (setterInfo.classifierEClass.isInstance(p)) {
				featureClassifiers.add(p);
			}
		});

		return featureClassifiers;
	}

	private static void setFeatureClassifier(final NamedElement feature, final Object classifier) {
		if (classifier != null) {
			// Import its package if necessary
			final AadlPackage pkg = (AadlPackage) feature.getElementRoot();
			if (classifier instanceof Classifier && ((Classifier) classifier).getNamespace() != null && pkg != null) {
				final PackageSection section = pkg.getPublicSection();
				final AadlPackage selectedClassifierPkg = (AadlPackage) ((Classifier) classifier).getNamespace()
						.getOwner();
				if (selectedClassifierPkg != null && pkg != selectedClassifierPkg) {
					AadlImportsUtil.addImportIfNeeded(section, selectedClassifierPkg);
				}
			}

			// If the feature is an abstract feature, need to reset the feature prototype. Only a prototype or a classifier may be set.
			if (feature instanceof AbstractFeature) {
				((AbstractFeature) feature).setFeaturePrototype(null);
			}
		}

		final FeatureClassifierMetadata setterInfo = featureTypeToMetadataMap.get(feature.eClass());
		try {
			final Method method = feature.getClass().getMethod(setterInfo.setterName, setterInfo.classifierClass);
			method.invoke(feature, classifier);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
}
