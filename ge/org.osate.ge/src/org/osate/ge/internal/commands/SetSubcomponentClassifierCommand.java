package org.osate.ge.internal.commands;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
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
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.di.GetBusinessObjectToModify;
import org.osate.ge.internal.ui.dialogs.ElementSelectionDialog;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class SetSubcomponentClassifierCommand {
	private static final StandaloneQuery parentQuery = StandaloneQuery.create((root) -> root.ancestor(1));

	@GetLabel
	public String getLabel() {
		return "Set Classifier...";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final Subcomponent sc,
			@Named(Names.BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext boc,
			final QueryService queryService) {
		return sc.getContainingClassifier() == queryService.getFirstBusinessObject(parentQuery, boc);
	}

	@GetBusinessObjectToModify
	public Object getBusinessObjectToModify(@Named(Names.BUSINESS_OBJECT) final Object bo) {
		return bo;
	}
	
	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final Subcomponent sc) {
		// Prompt the user for the classifier
		final ElementSelectionDialog dlg = new ElementSelectionDialog(Display.getCurrent().getActiveShell(), "Select a Classifier", "Select a classifier.", getPotentialSubcomponentTypes(sc));
		if(dlg.open() == Window.CANCEL) {
			return false;
		}

		// Set the classifier
		// Import the package if necessary
		SubcomponentType selectedSubcomponentType = (SubcomponentType)dlg.getFirstSelectedElement();
		if(selectedSubcomponentType != null) {
			// Resolve the reference
			selectedSubcomponentType = (SubcomponentType)EcoreUtil.resolve(selectedSubcomponentType, sc); 
			
			// Import its package if necessary
			final AadlPackage pkg = (AadlPackage)sc.getElementRoot();
			if(selectedSubcomponentType instanceof ComponentClassifier && selectedSubcomponentType.getNamespace() != null && pkg != null) {
				final PackageSection section = pkg.getPublicSection();
				final AadlPackage selectedClassifierPkg = (AadlPackage)selectedSubcomponentType.getNamespace().getOwner();
				if(pkg != selectedClassifierPkg && !section.getImportedUnits().contains(selectedClassifierPkg)) {
					section.getImportedUnits().add(selectedClassifierPkg);
				}
			}
		}				

		// Set the classifier
		if(sc instanceof SystemSubcomponent) {
			((SystemSubcomponent)sc).setSystemSubcomponentType((SystemSubcomponentType)selectedSubcomponentType);
		} else if(sc instanceof AbstractSubcomponent) {
			((AbstractSubcomponent)sc).setAbstractSubcomponentType((AbstractSubcomponentType)selectedSubcomponentType);
		} else if(sc instanceof ThreadGroupSubcomponent) {
			((ThreadGroupSubcomponent)sc).setThreadGroupSubcomponentType((ThreadGroupSubcomponentType)selectedSubcomponentType);
		} else if(sc instanceof ThreadSubcomponent) {
			((ThreadSubcomponent)sc).setThreadSubcomponentType((ThreadSubcomponentType)selectedSubcomponentType);
		} else if(sc instanceof SubprogramSubcomponent) {
			((SubprogramSubcomponent)sc).setSubprogramSubcomponentType((SubprogramSubcomponentType)selectedSubcomponentType);
		} else if(sc instanceof SubprogramGroupSubcomponent) {
			((SubprogramGroupSubcomponent)sc).setSubprogramGroupSubcomponentType((SubprogramGroupSubcomponentType)selectedSubcomponentType);
		} else if(sc instanceof DataSubcomponent) {
			((DataSubcomponent)sc).setDataSubcomponentType((DataSubcomponentType)selectedSubcomponentType);
		} else if(sc instanceof AbstractSubcomponent) {
			((AbstractSubcomponent)sc).setAbstractSubcomponentType((AbstractSubcomponentType)selectedSubcomponentType);
		} else if(sc instanceof VirtualBusSubcomponent) {
			((VirtualBusSubcomponent)sc).setVirtualBusSubcomponentType((VirtualBusSubcomponentType)selectedSubcomponentType);
		} else if(sc instanceof VirtualProcessorSubcomponent) {
			((VirtualProcessorSubcomponent)sc).setVirtualProcessorSubcomponentType((VirtualProcessorSubcomponentType)selectedSubcomponentType);
		} else if(sc instanceof BusSubcomponent) {
			((BusSubcomponent)sc).setBusSubcomponentType((BusSubcomponentType)selectedSubcomponentType);
		} else if(sc instanceof ProcessSubcomponent) {
			((ProcessSubcomponent)sc).setProcessSubcomponentType((ProcessSubcomponentType)selectedSubcomponentType);
		} else if(sc instanceof ProcessorSubcomponent) {
			((ProcessorSubcomponent)sc).setProcessorSubcomponentType((ProcessorSubcomponentType)selectedSubcomponentType);
		} else if(sc instanceof DeviceSubcomponent) {
			((DeviceSubcomponent)sc).setDeviceSubcomponentType((DeviceSubcomponentType)selectedSubcomponentType);
		} else if(sc instanceof MemorySubcomponent) {
			((MemorySubcomponent)sc).setMemorySubcomponentType((MemorySubcomponentType)selectedSubcomponentType);
		} else {
			throw new RuntimeException("Unexpected type: " + sc.getClass().getName());
		}

		return true;
	}

	private EClass componentCategoryToEClass(final ComponentCategory category) {
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();

		switch(category) {
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
	 * Return a list of EObjectDescriptions and NamedElements for potential subcomponent types for the specified subcomponent
	 * @return
	 */
	private List<Object> getPotentialSubcomponentTypes(final Subcomponent sc) {
		final List<Object> subcomponentTypes = new ArrayList<Object>();
		subcomponentTypes.add(null);

		// Populate the list with valid classifier descriptions
		final EClass subcomponentTypeClass = componentCategoryToEClass(sc.getCategory());
		for(final IEObjectDescription desc : ScopedEMFIndexRetrieval.getAllEObjectsByType(sc.eResource(), subcomponentTypeClass)) {
			subcomponentTypes.add(desc);
		}

		// Add any prototypes that are of the appropriate type
		for(final Prototype p : sc.getContainingComponentImpl().getAllPrototypes()) {
			if(subcomponentTypeClass.isInstance(p)) {
				subcomponentTypes.add(p);
			}			
		}		

		return subcomponentTypes;
	}
}
