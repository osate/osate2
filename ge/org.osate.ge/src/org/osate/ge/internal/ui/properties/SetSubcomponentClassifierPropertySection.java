package org.osate.ge.internal.ui.properties;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.emf.ecore.EClass;
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
import org.osate.ge.internal.ui.dialogs.ElementSelectionDialog;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.internal.util.AadlImportsUtil;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;
import org.osate.ge.ui.properties.PropertySectionUtil;

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
				((VirtualProcessorSubcomponent) sc).setVirtualProcessorSubcomponentType(
						(VirtualProcessorSubcomponentType) selectedSubcomponentType);
			} else if (sc instanceof BusSubcomponent) {
				((BusSubcomponent) sc).setBusSubcomponentType((BusSubcomponentType) selectedSubcomponentType);
			} else if (sc instanceof ProcessSubcomponent) {
				((ProcessSubcomponent) sc)
				.setProcessSubcomponentType((ProcessSubcomponentType) selectedSubcomponentType);
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
	}

	private EClass componentCategoryToEClass(final ComponentCategory category) {
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
			return p.getBus();

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

	/**
	 * Return a list of EObjectDescriptions and NamedElements for potential classifiers for the specified subcomponent
	 * @return
	 */
	private List<Object> getPotentialSubcomponentTypes(final Subcomponent sc) {
		final List<Object> subcomponentTypes = new ArrayList<Object>();
		subcomponentTypes.add(null);

		// Populate the list with valid classifier descriptions
		final EClass subcomponentTypeClass = componentCategoryToEClass(sc.getCategory());
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
		final ComponentClassifier cc = it.next().getClassifier();
		while (it.hasNext()) {
			if (cc != it.next().getClassifier()) {
				return "<Multiple>";
			}
		}

		return getSubcomponentClassifierName(cc);
	}

	private static String getSubcomponentClassifierName(final ComponentClassifier cc) {
		if (cc != null && cc.eResource() != null) {
			return cc.eResource().getURI().trimFileExtension().lastSegment() + "::" + cc.getName();
		}

		return "<None>";
	}
}
