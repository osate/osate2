package org.osate.ge.internal.ui.properties;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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
import org.osate.aadl2.Classifier;
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
import org.osate.ge.internal.ui.util.SelectionUtil;
import org.osate.ge.internal.util.AadlImportsUtil;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;
import org.osate.ge.internal.util.classifiers.ClassifierOperation;
import org.osate.ge.internal.util.classifiers.ClassifierOperationExecutor;
import org.osate.ge.internal.util.classifiers.ClassifierOperationPartType;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.OperationBuilder;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.ui.properties.PropertySectionUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

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
		InternalPropertySectionUtil.createSectionLabel(container, getWidgetFactory(),
				"Classifier:");

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
	}

	final SelectionListener setClassifierListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			final List<Subcomponent> scs = selectedBos.boStream(Subcomponent.class).collect(Collectors.toList());
			final Iterator<Subcomponent> it = scs.iterator();
			final Subcomponent sc = it.next();
			final List<Object> potentialFeatureClassifiers = new ArrayList<>(
					getPotentialSubcomponentTypes(sc));
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
							.resolve((EObject) dlg.getFirstSelectedElement(),
									sc);
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
			// Get a list of all subcomponents
			final List<Subcomponent> scs = selectedBos.boStream(Subcomponent.class).collect(Collectors.toList());

			// It should be safe to assume that the category of all selected subcomponents match because the button would be disabled otherwise.
			final ComponentCategory componentCategory = scs.get(0).getCategory();
			final EClass classifierType = componentCategoryToClassifierEClass(componentCategory);

			// TODO: Cleanup
			final Bundle bundle = FrameworkUtil.getBundle(getClass());
			final IEclipseContext context = EclipseContextFactory.getServiceContext(bundle.getBundleContext());
			final NamingService namingService = Objects.requireNonNull(context.getActive(NamingService.class),
					"Unable to retrieve naming service");

			final AadlModificationService aadlModService = Objects.requireNonNull(
					context.getActive(AadlModificationService.class), "Unable to retrieve AADL modification service");

			// TODO: Decide what resource set to use.

			final ResourceSet rs = scs.get(0).eResource().getResourceSet(); // TODO: Consider and rework
			// TODO: Adjust label
			final ClassifierOperationDialog.Model model = new DefaultCreateSelectClassifierDialogModel(namingService,
					rs, "Configure classifier.") {
				@Override
				public String getTitle() {
					return "Create Component Classifier";
				}

				@Override
				public Collection<?> getPackageOptions() {
					// Get list of projects which are accessible from all the subcomponent declarations
					return scs.stream()
							.map(SetSubcomponentClassifierPropertySection::getEditablePackages).reduce(Sets::intersection)
							.map(s -> (List<IEObjectDescription>) new ArrayList<>(s)).orElse(Collections.emptyList());
				}

				@Override
				public Collection<?> getBaseSelectOptions(final ClassifierOperationPartType primaryOperation) {
					return scs.stream()
							.map(sc -> getValidBaseClassifierDescriptions(sc, classifierType,
									primaryOperation == ClassifierOperationPartType.NEW_COMPONENT_IMPLEMENTATION))
							.reduce(Sets::intersection).orElse(Collections.emptySet());
				}
			};

			// TODO: Ergonomics:
			// - Initial default package
			// - If package is set and base package is empty.. Set both of them?

			// Show the dialog to determine the operation
			final ClassifierOperation args = ClassifierOperationDialog.show(Display.getCurrent().getActiveShell(),
					new ClassifierOperationDialog.ArgumentBuilder(model,
							EnumSet.of(ClassifierOperationPartType.NEW_COMPONENT_TYPE,
									ClassifierOperationPartType.NEW_COMPONENT_IMPLEMENTATION))// .defaultPackage(pkg) // TODO: Default package
					.componentCategory(componentCategory).create());

			if (args != null) {
				// TODO: Cleanup
				// SelectionUtil.getProject(dim.eResource())

				// TODO: project
				final Subcomponent tmpBo = selectedBos.boStream(Subcomponent.class).collect(Collectors.toList()).get(0); // TODO: Rework
				final IProject project = SelectionUtil.getProjectOrThrow(tmpBo.eResource()); // TODO

				// TODO: How to select project?
				// TODO: Should this take a live resource set?
				final Operation op = Operation.create(opBuilder -> {
					// TODO: Review and rename

					// TODO: This executor really just builds? Consider renaming
					final ClassifierOperationExecutor opExec = new ClassifierOperationExecutor(namingService, rs,
							project);
					final OperationBuilder<Classifier> classifierOpBuilder = opExec.execute(opBuilder, args,
							null);

					// TODO: The subcomponent retireved from the BOS should not be modified based on the documentation... Need an API for doi ng that.
					scs.forEach(sc -> {
						classifierOpBuilder.modifyModel(null, (t, c) -> sc, (tag, scToModify, classifier) -> {
							// TODO: Should be safe but should check.
							setClassifier(scToModify, (SubcomponentType) classifier);
							return StepResultBuilder.create().build();
						});
					});
				});

				// Perform modification
				final OperationExecutor opExecutor = new OperationExecutor(aadlModService);
				opExecutor.execute(op, results -> {
				});
			}
		}
	};

	// TODO: Share? Move?
	private static Set<IEObjectDescription> getEditablePackages(final EObject bo) {
		return ScopedEMFIndexRetrieval
				.getAllEObjectsByType(bo.eResource(), Aadl2Factory.eINSTANCE.getAadl2Package().getAadlPackage())
				.stream().filter(od -> od.getEObjectURI() != null && !od.getEObjectURI().isPlatformPlugin())
				.collect(Collectors.toSet());
	}

	// TODO: Consider not accepting sc but resource or something else that may make more sense.
	private static Set<IEObjectDescription> getValidBaseClassifierDescriptions(final EObject sc,
			final EClass classifierType, boolean includeImplementations) {
		final IProject project = SelectionUtil.getProjectOrThrow(sc.eResource());
		// TODO: Should the helper function return a Set instead of list that needs to be converted?
		return new HashSet<>(getValidBaseClassifierDescriptions(project, classifierType, includeImplementations));
	}

	// TODO: May be shareable with ClassifierHandler?
	private static Set<IEObjectDescription> getValidBaseClassifierDescriptions(final IProject project,
			final EClass classifierType, boolean includeImplementations) {
		System.err.println(includeImplementations);
		// TODO: Need to test using base Implementation. Is there a reason why it isn't supportedin ClassifierHandler?
		// The implementation check in classifier handler is flawed... Share this implementation with it? May not undersatnd it properly..
		// May be related to usage of classifierType argument?

		final Set<IEObjectDescription> objectDescriptions = new HashSet<IEObjectDescription>();
		for (final IEObjectDescription desc : ScopedEMFIndexRetrieval.getAllEObjectsByType(project,
				Aadl2Factory.eINSTANCE.getAadl2Package().getComponentClassifier())) {
			// Add objects that have are either types or implementations of the same category as the classifier type
			System.err.println(classifierType + " : " + desc.getEClass());
			if (classifierType.isSuperTypeOf(desc.getEClass()) && (includeImplementations || !Aadl2Factory.eINSTANCE
					.getAadl2Package().getComponentImplementation().isSuperTypeOf(desc.getEClass()))) {
				objectDescriptions.add(desc);
			}
		}

		return objectDescriptions;
	}

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

		createBtn.setEnabled(
				!scs.isEmpty() && scs.stream().allMatch(sc -> sc.getCategory() == scs.get(0).getCategory()));
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

	private EClass componentCategoryToClassifierEClass(final ComponentCategory category) {
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();

		switch (category) {
		case SYSTEM:
			return p.getSystemClassifier();

		case PROCESS:
			return p.getProcessClassifier();

		case THREAD_GROUP:
			return p.getThreadGroupClassifier();

		case THREAD:
			return p.getThreadClassifier();

		case SUBPROGRAM:
			return p.getSubprogramClassifier();

		case SUBPROGRAM_GROUP:
			return p.getSubprogramGroupClassifier();

		case DATA:
			return p.getDataClassifier();

		case ABSTRACT:
			return p.getAbstractClassifier();

		case VIRTUAL_BUS:
			return p.getVirtualBusClassifier();

		case VIRTUAL_PROCESSOR:
			return p.getVirtualProcessorClassifier();

		case BUS:
			return p.getBusClassifier();

		case PROCESSOR:
			return p.getProcessorClassifier();

		case DEVICE:
			return p.getDeviceClassifier();

		case MEMORY:
			return p.getMemoryClassifier();

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
