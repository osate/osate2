package org.osate.ge.internal.features;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.aadl2.ComponentImplementation;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.services.BusinessObjectResolutionService;

public class InstantiateComponentImplementationFeature extends AbstractCustomFeature {
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public InstantiateComponentImplementationFeature(final IFeatureProvider fp, final BusinessObjectResolutionService bor) {
		super(fp);
		this.bor = bor;
	}

	@Override
    public String getName() {
        return "Instantiate";
    }
 
    @Override
    public String getDescription() {
        return "Instantiates the selected componenent implementation type.";
    }
    
    //Available if the element selected is of type ComponentImplementation
    @Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		PictogramElement[] pes = customCtx.getPictogramElements();
		
		if(customCtx.getPictogramElements().length != 1){
			return false;
		}
		final Object bo = AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(pes[0]));
		
		return bo instanceof ComponentImplementation;	
	}
    
    //Can execute if the element selected is not null, and part of diagram
    @Override
    public boolean canExecute(ICustomContext context) {
    	PictogramElement[] pes = context.getPictogramElements();    	
        if (pes != null && pes.length == 1 && !(pes[0] instanceof Diagram)) { 
            Object bo = AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(pes[0]));
            if(bo instanceof ComponentImplementation) {
                return true;
            }
            if(pes[0]!=null){
            	return true;
            }
        }
        return false;
    }

    //Instantiates the selected component implementation
    @Override
	public void execute(final ICustomContext context) {
    	final ICustomContext customCtx = (ICustomContext)context;
		final PictogramElement[] pes = customCtx.getPictogramElements();		
		final PictogramElement pe = pes[0];	
    	final Object bo = bor.getBusinessObjectForPictogramElement(pe);
    	final ComponentImplementation compImpl = (ComponentImplementation)bo;
		try {
			org.osate.aadl2.instantiation.InstantiateModel.buildInstanceModelFile(compImpl);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
