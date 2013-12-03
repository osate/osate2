package edu.uah.rsesc.aadl.age.diagrams.componentImplementation.features;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.dialogs.Dialog;
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
import org.osate.aadl2.VitualBusSubcomponentType;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;

import edu.uah.rsesc.aadl.age.services.AadlModificationService.AbstractModifier;
import edu.uah.rsesc.aadl.age.dialogs.ElementSelectionDialog;
import edu.uah.rsesc.aadl.age.services.AadlModificationService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;

public class SetSubcomponentClassifierFeature extends AbstractCustomFeature {
	private final AadlModificationService aadlModService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public SetSubcomponentClassifierFeature(final AadlModificationService aadlModService, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		super(fp);
		this.aadlModService = aadlModService;
		this.bor = bor;
	}

	@Override
    public String getName() {
        return "Set Classifier...";
    }
	
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
	
    @Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		final PictogramElement[] pes = customCtx.getPictogramElements();		
		if(customCtx.getPictogramElements().length < 1 || !(customCtx.getPictogramElements()[0] instanceof Shape)) {
			return false;
		}
		
		// Check that the shape represents a subcomponent and that the subcomponent is owned by the classifier represented by the shape's container
		final PictogramElement pe = pes[0];		
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		final Object containerBo = bor.getBusinessObjectForPictogramElement(((Shape)pe).getContainer());
		return bo instanceof Subcomponent && ((Subcomponent)bo).getContainingClassifier() == containerBo;
	}
    
    @Override
    public boolean canExecute(final ICustomContext context) {
    	return true;
    }
        
	@Override
	public void execute(final ICustomContext context) {
		final PictogramElement pe = context.getPictogramElements()[0];
		final Subcomponent sc = (Subcomponent)bor.getBusinessObjectForPictogramElement(pe);

		// Prompt the user for the classifier
		final ElementSelectionDialog dlg = new ElementSelectionDialog(Display.getCurrent().getActiveShell(), "Select a classifier.", getPotentialSubcomponentTypes(sc));
		if(dlg.open() == Dialog.CANCEL) {
			return;
		}

		// Set the classifier
		aadlModService.modify(sc, new AbstractModifier<Subcomponent, Object>() {
			@Override
			public Object modify(final Resource resource, final Subcomponent sc) {
				
				// Import the package if necessary
				SubcomponentType selectedSubcomponentType = (SubcomponentType)dlg.getSelectedElement();
				if(selectedSubcomponentType != null) {
					// Resolve the reference
					selectedSubcomponentType = (SubcomponentType)EcoreUtil.resolve(selectedSubcomponentType, resource);
					
					// Import its package if necessary
					final AadlPackage pkg = (AadlPackage)sc.getElementRoot();
					if(selectedSubcomponentType instanceof ComponentClassifier && selectedSubcomponentType != null && selectedSubcomponentType.getNamespace() != null && pkg != null) {
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
					((VirtualBusSubcomponent)sc).setVirtualBusSubcomponentType((VitualBusSubcomponentType)selectedSubcomponentType);
				} else if(sc instanceof BusSubcomponent) {
					((BusSubcomponent)sc).setBusSubcomponentType((BusSubcomponentType)selectedSubcomponentType);
				} else if(sc instanceof ProcessorSubcomponent) {
					((ProcessorSubcomponent)sc).setProcessorSubcomponentType((ProcessorSubcomponentType)selectedSubcomponentType);
				} else if(sc instanceof DeviceSubcomponent) {
					((DeviceSubcomponent)sc).setDeviceSubcomponentType((DeviceSubcomponentType)selectedSubcomponentType);
				} else if(sc instanceof MemorySubcomponent) {
					((MemorySubcomponent)sc).setMemorySubcomponentType((MemorySubcomponentType)selectedSubcomponentType);
				} else {
					throw new RuntimeException("Unexpected type: " + sc.getClass().getName());
				}
				
				return null;
			}			
		});
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
			return p.getVitualBusSubcomponentType();
			
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
		for(final IEObjectDescription desc : EMFIndexRetrieval.getAllClassifiersOfTypeInWorkspace(subcomponentTypeClass)) {
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
