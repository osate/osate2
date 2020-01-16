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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
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
import org.osate.aadl2.AbstractSubcomponent;
import org.osate.aadl2.AbstractSubcomponentType;
import org.osate.aadl2.BusSubcomponent;
import org.osate.aadl2.BusSubcomponentType;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DataSubcomponentType;
import org.osate.aadl2.DeviceSubcomponent;
import org.osate.aadl2.DeviceSubcomponentType;
import org.osate.aadl2.MemorySubcomponent;
import org.osate.aadl2.MemorySubcomponentType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ProcessSubcomponentType;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.ProcessorSubcomponentType;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.aadl2.SubprogramGroupSubcomponent;
import org.osate.aadl2.SubprogramGroupSubcomponentType;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.SubprogramSubcomponentType;
import org.osate.aadl2.SystemSubcomponent;
import org.osate.aadl2.SystemSubcomponentType;
import org.osate.aadl2.ThreadGroupSubcomponent;
import org.osate.aadl2.ThreadGroupSubcomponentType;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.ThreadSubcomponentType;
import org.osate.aadl2.VirtualBusSubcomponent;
import org.osate.aadl2.VirtualBusSubcomponentType;
import org.osate.aadl2.VirtualProcessorSubcomponent;
import org.osate.aadl2.VirtualProcessorSubcomponentType;
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

public class SetSubcomponentClassifierPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> bo instanceof Subcomponent);
		}
	}

	private BusinessObjectSelection selectedBos;
	private Label curScClassifier;
	private Button chooseBtn;
	private Button createBtn;

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		FormData fd;

		final Composite container = getWidgetFactory().createFlatFormComposite(parent);
		InternalPropertySectionUtil.createSectionLabel(container, getWidgetFactory(), "Classifier:");

		curScClassifier = getWidgetFactory().createLabel(container, new String());
		fd = new FormData();
		fd.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		fd.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		curScClassifier.setLayoutData(fd);

		chooseBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), container, null, setClassifierListener,
				"Choose...", SWT.PUSH);

		fd = new FormData();
		fd.left = new FormAttachment(curScClassifier, ITabbedPropertyConstants.HSPACE);
		fd.top = new FormAttachment(curScClassifier, 0, SWT.CENTER);
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
			final List<Subcomponent> scs = selectedBos.boStream(Subcomponent.class).collect(Collectors.toList());
			final Iterator<Subcomponent> it = scs.iterator();
			final Subcomponent sc = it.next();
			final List<Object> potentialFeatureClassifiers = new ArrayList<>(getPotentialSubcomponentTypes(sc));
			while (it.hasNext()) {
				potentialFeatureClassifiers.retainAll(getPotentialSubcomponentTypes(it.next()));
			}

			// Prompt the user for the element
			final ElementSelectionDialog dlg = new ElementSelectionDialog(Display.getCurrent().getActiveShell(),
					"Select a Classifier", "Select a classifier.", potentialFeatureClassifiers);
			if (dlg.open() != Window.CANCEL) {
				// Set the classifier
				// Import the package if necessary
				final SubcomponentType selectedSubcomponentType;
				if (dlg.getFirstSelectedElement() != null) {
					// Resolve the reference
					selectedSubcomponentType = (SubcomponentType) EcoreUtil
							.resolve((EObject) dlg.getFirstSelectedElement(), sc);
				} else {
					selectedSubcomponentType = null;
				}

				// Set the classifier
				selectedBos.modify(Subcomponent.class, subcomponent -> {
					setClassifier(subcomponent, selectedSubcomponentType);
				});
			}
		}
	};

	final SelectionListener createClassifierListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			// Get a list of selected subcomponents
			final List<Subcomponent> scs = selectedBos.boStream(Subcomponent.class).collect(Collectors.toList());

			// It should be safe to assume that the category of all selected subcomponents match because the button would be disabled otherwise.
			final ComponentCategory componentCategory = scs.get(0).getCategory();

			// Get required services
			final IEclipseContext context = EclipseContextFactory
					.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
			final NamingService namingService = Objects.requireNonNull(context.getActive(NamingService.class),
					"Unable to retrieve naming service");
			final AadlModificationService aadlModService = Objects.requireNonNull(
					context.getActive(AadlModificationService.class), "Unable to retrieve AADL modification service");

			// Determine project to use
			final IProject project = AadlHelper.getCommonProject(scs)
					.orElseThrow(() -> new RuntimeException("Unable to determine project"));

			// Get the resource set to use. Use the resource set from the selected model elements to ensure the proper model elements are modified.
			// If the resource set did not match for all model elements, the create button would be disabled
			final ResourceSet rs = scs.get(0).eResource().getResourceSet();

			final ClassifierOperationDialog.Model model = new DefaultCreateSelectClassifierDialogModel(namingService,
					rs, "Configure classifier.") {
				@Override
				public String getTitle() {
					return "Create Component Classifier";
				}

				@Override
				public Collection<?> getPackageOptions() {
					return AadlHelper.getEditablePackages(project);
				}

				@Override
				public Collection<?> getBaseSelectOptions(final ClassifierOperationPartType primaryOperation) {
					return scs.stream()
							.map(sc -> AadlClassifierUtil.getValidBaseClassifierDescriptions(project, componentCategory,
									primaryOperation == ClassifierOperationPartType.NEW_COMPONENT_IMPLEMENTATION))
							.reduce(Sets::intersection).orElse(Collections.emptySet());
				}
			};

			// Show the dialog to determine the operation
			final ClassifierOperationDialog.ArgumentBuilder argBuilder = new ClassifierOperationDialog.ArgumentBuilder(
					model,
					EnumSet.of(ClassifierOperationPartType.NEW_COMPONENT_TYPE,
							ClassifierOperationPartType.NEW_COMPONENT_IMPLEMENTATION))
					.defaultPackage(AadlHelper.getCommonPackage(scs).orElse(null))
					.componentCategories(ImmutableList.of(componentCategory));

			final ClassifierOperation classifierOp = ClassifierOperationDialog
					.show(Display.getCurrent().getActiveShell(), argBuilder.create());

			if (classifierOp != null) {
				final Operation op = Operation.create(opBuilder -> {
					// Add actual operation steps to the operation builder based on the classifier operation
					final ClassifierOperationExecutor classifierOperationHandler = new ClassifierOperationExecutor(
							namingService, rs, project);
					opBuilder = classifierOperationHandler.execute(opBuilder, classifierOp, null);

					// Modify the subcomponents based on the result of the classifier operation
					selectedBos.modifyWithOperation(opBuilder, Subcomponent.class, (scToModify, classifier) -> {
						if (!(classifier instanceof ComponentClassifier)) {
							throw new RuntimeException("Expected ComponentClassifier.");
						}

						final EObject resolvedClassifier = EditingUtil
								.resolveWithLiveResourceSetIfProject((EObject) classifier, project);

						setClassifier(scToModify, (ComponentClassifier) resolvedClassifier);
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
		final List<Subcomponent> scs = selectedBos.boStream(Subcomponent.class).collect(Collectors.toList());
		final String scLbl = getSubcomponentClassifierLabel(scs);
		curScClassifier.setText(scLbl);

		createBtn.setEnabled(!scs.isEmpty() && scs.stream().allMatch(sc -> sc.getCategory() == scs.get(0).getCategory())
				&& scs.stream().allMatch(sc -> sc.eResource() != null)
				&& EditingUtil.allHaveSameValidResourceSet(scs)
				&& AadlHelper.getCommonProject(scs).isPresent());
	}

	private EClass componentCategoryToSubcomponentTypeEClass(final ComponentCategory category) {
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();

		switch (category) {
		case SYSTEM:
			return p.getSystemSubcomponentType();

		case PROCESS:
			return p.getProcessSubcomponentType();

		case THREAD_GROUP:
			return p.getThreadGroupSubcomponentType();

		case THREAD:
			return p.getThreadSubcomponentType();

		case SUBPROGRAM:
			return p.getSubprogramSubcomponentType();

		case SUBPROGRAM_GROUP:
			return p.getSubprogramGroupSubcomponentType();

		case DATA:
			return p.getDataSubcomponentType();

		case ABSTRACT:
			return p.getAbstractSubcomponentType();

		case VIRTUAL_BUS:
			return p.getVirtualBusSubcomponentType();

		case VIRTUAL_PROCESSOR:
			return p.getVirtualProcessorSubcomponentType();

		case BUS:
			return p.getBusSubcomponentType();

		case PROCESSOR:
			return p.getProcessorSubcomponentType();

		case DEVICE:
			return p.getDeviceSubcomponentType();

		case MEMORY:
			return p.getMemorySubcomponentType();

		default:
			throw new RuntimeException("Unexpected category: " + category);
		}
	}

	private void setClassifier(final Subcomponent sc, final SubcomponentType selectedSubcomponentType) {
		// Import as necessary
		if (selectedSubcomponentType != null) {
			// Import its package if necessary
			final AadlPackage pkg = (AadlPackage) sc.getElementRoot();
			if (selectedSubcomponentType instanceof ComponentClassifier
					&& selectedSubcomponentType.getNamespace() != null && pkg != null) {
				final PackageSection section = pkg.getPublicSection();
				final AadlPackage selectedClassifierPkg = (AadlPackage) selectedSubcomponentType.getNamespace()
						.getOwner();
				if (selectedClassifierPkg != null && pkg != selectedClassifierPkg) {
					AadlImportsUtil.addImportIfNeeded(section, selectedClassifierPkg);
				}
			}
		}

		if (sc instanceof SystemSubcomponent) {
			((SystemSubcomponent) sc).setSystemSubcomponentType((SystemSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof AbstractSubcomponent) {
			((AbstractSubcomponent) sc)
			.setAbstractSubcomponentType((AbstractSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof ThreadGroupSubcomponent) {
			((ThreadGroupSubcomponent) sc)
			.setThreadGroupSubcomponentType((ThreadGroupSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof ThreadSubcomponent) {
			((ThreadSubcomponent) sc).setThreadSubcomponentType((ThreadSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof SubprogramSubcomponent) {
			((SubprogramSubcomponent) sc)
			.setSubprogramSubcomponentType((SubprogramSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof SubprogramGroupSubcomponent) {
			((SubprogramGroupSubcomponent) sc)
			.setSubprogramGroupSubcomponentType((SubprogramGroupSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof DataSubcomponent) {
			((DataSubcomponent) sc).setDataSubcomponentType((DataSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof AbstractSubcomponent) {
			((AbstractSubcomponent) sc)
			.setAbstractSubcomponentType((AbstractSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof VirtualBusSubcomponent) {
			((VirtualBusSubcomponent) sc)
			.setVirtualBusSubcomponentType((VirtualBusSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof VirtualProcessorSubcomponent) {
			((VirtualProcessorSubcomponent) sc)
			.setVirtualProcessorSubcomponentType((VirtualProcessorSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof BusSubcomponent) {
			((BusSubcomponent) sc).setBusSubcomponentType((BusSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof ProcessSubcomponent) {
			((ProcessSubcomponent) sc).setProcessSubcomponentType((ProcessSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof ProcessorSubcomponent) {
			((ProcessorSubcomponent) sc)
			.setProcessorSubcomponentType((ProcessorSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof DeviceSubcomponent) {
			((DeviceSubcomponent) sc).setDeviceSubcomponentType((DeviceSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof MemorySubcomponent) {
			((MemorySubcomponent) sc).setMemorySubcomponentType((MemorySubcomponentType) selectedSubcomponentType);
		} else {
			throw new RuntimeException("Unexpected type: " + sc.getClass().getName());
		}
	}

	/**
	 * Return a list of EObjectDescriptions and NamedElements for potential classifiers for the specified subcomponent
	 * @return
	 */
	private List<Object> getPotentialSubcomponentTypes(final Subcomponent sc) {
		final List<Object> subcomponentTypes = new ArrayList<Object>();
		subcomponentTypes.add(null);

		// Populate the list with valid classifier descriptions
		final EClass subcomponentTypeClass = componentCategoryToSubcomponentTypeEClass(sc.getCategory());
		for (final IEObjectDescription desc : ScopedEMFIndexRetrieval.getAllEObjectsByType(sc.eResource(),
				subcomponentTypeClass)) {
			subcomponentTypes.add(desc);
		}

		// Add any prototypes that are of the appropriate type
		for (final Prototype p : sc.getContainingComponentImpl().getAllPrototypes()) {
			if (subcomponentTypeClass.isInstance(p)) {
				subcomponentTypes.add(p);
			}
		}

		return subcomponentTypes;
	}

	private static String getSubcomponentClassifierLabel(final List<Subcomponent> scs) {
		final Iterator<Subcomponent> it = scs.iterator();
		final SubcomponentType st = getAllSubcomponentType(it.next());
		while (it.hasNext()) {
			if (st != getAllSubcomponentType(it.next())) {
				return "<Multiple>";
			}
		}

		return getSubcomponentTypeName(st);
	}

	private static SubcomponentType getAllSubcomponentType(Subcomponent sc) {
		SubcomponentType result;
		do {
			result = sc.getSubcomponentType();
			sc = sc.getRefined();
		} while (sc != null && result == null);

		return result;
	}

	private static String getSubcomponentTypeName(final SubcomponentType st) {
		if (st == null) {
			return "<None>";
		} else if (st instanceof NamedElement) {
			return Strings.emptyIfNull(((NamedElement) st).getQualifiedName());
		} else if (st instanceof Prototype) {
			return "<Prototype>";
		} else {
			return "";
		}
	}
}
