package edu.uah.rsesc.aadl.age.diagrams.componentImplementation.features;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;

import edu.uah.rsesc.aadl.age.services.AadlModificationService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.AadlModificationService.AbstractModifier;
import edu.uah.rsesc.aadl.age.util.StringUtil;

public class ChangeSubcomponentTypeFeature extends AbstractCustomFeature {
	private static LinkedHashMap<EClass, String> subcomponentTypeToCreateMethodNameMap = new LinkedHashMap<EClass, String>();
	private final AadlModificationService aadlModService;
	private final BusinessObjectResolutionService bor;
	private final EClass subcomponentType;	
	
	/**
	 * Populate the map that contains the subcomponent type to create method name mapping
	 */
	static {
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		subcomponentTypeToCreateMethodNameMap.put(p.getAbstractSubcomponent(), "createOwnedAbstractSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getBusSubcomponent(), "createOwnedBusSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getDataSubcomponent(), "createOwnedDataSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getDeviceSubcomponent(), "createOwnedDeviceSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getMemorySubcomponent(), "createOwnedMemorySubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getProcessSubcomponent(), "createOwnedProcessSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getProcessorSubcomponent(), "createOwnedProcessorSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getSubprogramSubcomponent(), "createOwnedSubprogramSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getSubprogramGroupSubcomponent(), "createOwnedSubprogramGroupSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getSystemSubcomponent(), "createOwnedSystemSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getThreadSubcomponent(), "createOwnedThreadSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getThreadGroupSubcomponent(), "createOwnedThreadGroupSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getVirtualBusSubcomponent(), "createOwnedVirtualBusSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getVirtualProcessorSubcomponent(), "createOwnedVirtualProcessorSubcomponent");
	}
	
	@Inject
	public ChangeSubcomponentTypeFeature(final AadlModificationService aadlModService, final BusinessObjectResolutionService bor, 
			final IFeatureProvider fp, final @Named("Subcomponent Type") EClass subcomponentType) {
		super(fp);
		this.aadlModService = aadlModService;
		this.bor = bor;
		this.subcomponentType = subcomponentType;
	}

	@Override
    public String getName() {
        return "Convert to " + StringUtil.camelCaseToUser(subcomponentType.getName());
    }
	
    @Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		final PictogramElement[] pes = customCtx.getPictogramElements();		
		if(customCtx.getPictogramElements().length < 1 || !(customCtx.getPictogramElements()[0] instanceof Shape)) {
			return false;
		}
		
		// Check that the shape represents a subcomponent and that the subcomponent is owned by the classifier represented by the shape's container, and that the classifier can
		// contain subcomponents of the type this feature changes subcomponents into.
		final PictogramElement pe = pes[0];		
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		final Object containerBo = bor.getBusinessObjectForPictogramElement(((Shape)pe).getContainer());
		
		return bo instanceof Subcomponent && ((Subcomponent)bo).getContainingClassifier() == containerBo && getSubcomponentCreateMethod(((Subcomponent)bo).getContainingComponentImpl(), subcomponentType) != null;
	}   	
    
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
    
    @Override
    public boolean canExecute(final ICustomContext context) {
    	// Only allow when the subcomponent is owned by the container
    	final PictogramElement pe = context.getPictogramElements()[0];
    	final Subcomponent sc = (Subcomponent)bor.getBusinessObjectForPictogramElement(((Shape)pe));
		
		// Check that the subcomponent is not already of the target type
    	return sc.eClass() != subcomponentType;
    }
    
	@Override
	public void execute(final ICustomContext context) {
		final PictogramElement pe = context.getPictogramElements()[0];		
		final Subcomponent sc = (Subcomponent)bor.getBusinessObjectForPictogramElement(pe);
		aadlModService.modify(sc, new AbstractModifier<Subcomponent, Object>() {
			@Override
			public Object modify(final Resource resource, final Subcomponent sc) {
				final ComponentImplementation ci = sc.getContainingComponentImpl();
				final Subcomponent replacementSc = createSubcomponent(ci, subcomponentType);
				
				// Copy structural feature values to the replacement object.
				transferStructuralFeatureValues(sc, replacementSc);
				
				// Remove the old object
				EcoreUtil.remove(sc);

				return null;
			}			
		});
	}
	
	/**
	 * Copies structural feature values from original to replacement. If replacement does not contain a matching structural feature, the value is ignored. If a feature is not set,
	 * its value is not copied over to the replacement.
	 * @param original
	 * @param replacement
	 */
	private void transferStructuralFeatureValues(final EObject original, final EObject replacement) {
		for(final EStructuralFeature feature : original.eClass().getEAllStructuralFeatures())	{
			if(feature.isChangeable() && !feature.isDerived()) {
				final Object originalValue = original.eGet(feature, true);						

				// Only copy values that are set
				if(original.eIsSet(feature)) {
					if(replacement.eClass().getEAllStructuralFeatures().contains(feature)) {
						if(feature.isMany()) {
							final @SuppressWarnings("unchecked") List<Object> originalList = (List<Object>)originalValue;
							final Object replacementValue = replacement.eGet(feature);
							final @SuppressWarnings("unchecked") List<Object> replacementList = (List<Object>)replacementValue;
							replacementList.addAll(originalList);					
						} else {
							replacement.eSet(feature, originalValue);
						}
					}
				}
			}
		}
	}
	
	public static Collection<EClass> getSubcomponentTypes() {
		return subcomponentTypeToCreateMethodNameMap.keySet();
	}
	
	private Method getSubcomponentCreateMethod(final ComponentImplementation subcomponentOwner, final EClass subcomponentType) {
		// Determine the method name of the type of subcomponent
		final String methodName = subcomponentTypeToCreateMethodNameMap.get(subcomponentType);
		if(methodName == null) {
			return null;
		}
		
		// Get the method
		try {
			final Method method = subcomponentOwner.getClass().getMethod(methodName);
			return method;
		} catch(final Exception ex) {
			return null;
		}
	}
	
	private Subcomponent createSubcomponent(final ComponentImplementation subcomponentOwner, final EClass subcomponentClass) {
		try {
			return (Subcomponent)getSubcomponentCreateMethod(subcomponentOwner, subcomponentClass).invoke(subcomponentOwner);
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
