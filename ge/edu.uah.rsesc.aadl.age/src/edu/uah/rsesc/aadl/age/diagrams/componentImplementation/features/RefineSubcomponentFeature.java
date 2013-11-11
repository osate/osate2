package edu.uah.rsesc.aadl.age.diagrams.componentImplementation.features;

import javax.inject.Inject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;

import edu.uah.rsesc.aadl.age.services.AadlModificationService.AbstractModifier;
import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.services.AadlModificationService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;

public class RefineSubcomponentFeature extends AbstractCustomFeature {
	private final AadlModificationService aadlModService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public RefineSubcomponentFeature(final AadlModificationService aadlModService, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		super(fp);
		this.aadlModService = aadlModService;
		this.bor = bor;
	}

	@Override
    public String getName() {
        return "Refine";
    }
	
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
	
    @Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		final PictogramElement[] pes = customCtx.getPictogramElements();		
		if(customCtx.getPictogramElements().length < 1 && customCtx.getPictogramElements()[0] instanceof Shape) {
			return false;
		}
		
		// Check that the shape represents a subcomponent and that the subcomponent is not owned by the classifier represented by the shape's container
		final PictogramElement pe = pes[0];		
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		final Object containerBo = bor.getBusinessObjectForPictogramElement(((Shape)pe).getContainer());
		return bo instanceof Subcomponent && containerBo instanceof ComponentImplementation && ((Subcomponent)bo).getContainingClassifier() != containerBo;
	}
    
    @Override
    public boolean canExecute(final ICustomContext context) {
    	return true;
    }
        
	@Override
	public void execute(final ICustomContext context) {
		final Shape shape = (Shape)context.getPictogramElements()[0];
		final Subcomponent sc = (Subcomponent)bor.getBusinessObjectForPictogramElement(shape);
		final ComponentImplementation containerComponentImplementation = (ComponentImplementation)bor.getBusinessObjectForPictogramElement(shape.getContainer());
		
		// Set the classifier
		aadlModService.modify(sc, new AbstractModifier<Subcomponent, Subcomponent>() {
			@Override
			public Subcomponent modify(final Resource resource, final Subcomponent sc) {
				// Refine the subcomponent
				final Subcomponent newSc = containerComponentImplementation.createOwnedAbstractSubcomponent();
				newSc.setRefined(sc);
				
				return newSc;
			}			
			
			@Override
			public void beforeCommit(final Resource resource, final Subcomponent sc, final Subcomponent newSc) {
				// Relink the shape
				getFeatureProvider().link(shape, new AadlElementWrapper(newSc));
			}
		});
	}	
}
