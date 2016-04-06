package org.osate.ge.internal.features;

import javax.inject.Inject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ShapeService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;

/**
 * Abstract custom feature for reordering a subprogram call within a subprogram call sequence.
 *
 */
public abstract class ReorderSubprogramCallFeature extends AbstractCustomFeature{
	private final AadlModificationService aadlModService;
	private final ShapeService shapeService;
	private final BusinessObjectResolutionService bor;
		
	@Inject
	public ReorderSubprogramCallFeature(final AadlModificationService aadlModService, final ShapeService shapeService, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		super(fp);
		this.aadlModService = aadlModService;
		this.shapeService = shapeService;
		this.bor = bor;
	}
	
    /**
     * Returns the new index for a subprogram call on which this feature is executed 
     */
    abstract protected int getNewIndex(final SubprogramCall call);
    
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

		// Check that the shape represents a subprogram call and that the call sequence is owned by the classifier represented by the shape's container
		final PictogramElement pe = pes[0];
		final Shape shape = (Shape)pe;
		final Object bo = bor.getBusinessObjectForPictogramElement(shape);
		if(!(bo instanceof SubprogramCall && ((SubprogramCall)bo).eContainer() instanceof SubprogramCallSequence)) {
			return false;
		}

		final Shape shapeContainer = shape.getContainer();
		final Object containerBo = bor.getBusinessObjectForPictogramElement(shapeContainer);
		return containerBo instanceof SubprogramCallSequence && ((SubprogramCallSequence)containerBo).getContainingClassifier() == getComponentImplementation(shapeContainer);
	}
    
    @Override
    public boolean canExecute(final ICustomContext context) {
		final Shape shape = (Shape)context.getPictogramElements()[0];
		final SubprogramCall call = (SubprogramCall)bor.getBusinessObjectForPictogramElement(shape);		
		final SubprogramCallSequence cs = (SubprogramCallSequence)call.eContainer();
		final int currentIndex = cs.getOwnedSubprogramCalls().indexOf(call);
		final int newIndex = getNewIndex(call);
		return currentIndex != -1 && currentIndex != newIndex && newIndex >= 0 && newIndex < cs.getOwnedSubprogramCalls().size();
    }
    
	@Override
	public void execute(final ICustomContext context) {
		final Shape shape = (Shape)context.getPictogramElements()[0];
		final SubprogramCall call = (SubprogramCall)bor.getBusinessObjectForPictogramElement(shape);
		
		// Set the classifier
		aadlModService.modify(call, new AbstractModifier<SubprogramCall, Object>() {
			@Override
			public Object modify(final Resource resource, final SubprogramCall call) {
				final SubprogramCallSequence cs = (SubprogramCallSequence)call.eContainer();
				cs.getOwnedSubprogramCalls().move(getNewIndex(call), call);

				return null;
			}			
		});
	}	
    
    /**
	 * Returns the first component implementation associated with the specified or a containing shape.
	 * @param shape
	 * @return
	 */
	private ComponentImplementation getComponentImplementation(final Shape shape) {
		return shapeService.getClosestBusinessObjectOfType(shape, ComponentImplementation.class);
	}
	
}
