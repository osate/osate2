package edu.uah.rsesc.aadl.age.diagrams.common.patterns;

import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.AbstractPattern;
import org.eclipse.graphiti.pattern.ICustomUndoablePattern;
import org.eclipse.graphiti.pattern.IPattern;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.Element;
import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;

/**
 * Base class for all shape patterns for AGE. Contains logic shared between all shape patterns.
 * @author philip.alldredge
 *
 */
public abstract class AgePattern extends AbstractPattern implements IPattern, ICustomUndoablePattern {
	public AgePattern() {
		super(null);
	}
	
	@Override
	protected boolean isPatternControlled(final PictogramElement pictogramElement) {
		final Object domainObject = getBusinessObjectForPictogramElement(pictogramElement);
	    return isMainBusinessObjectApplicable(domainObject);
	}

	@Override
	protected boolean isPatternRoot(final PictogramElement pictogramElement) {
		final Object domainObject = getBusinessObjectForPictogramElement(pictogramElement);
	    return isMainBusinessObjectApplicable(domainObject);
	}
		
	@Override
	public boolean canUpdate(final IUpdateContext context) {
		return isMainBusinessObjectApplicable(getBusinessObjectForPictogramElement(context.getPictogramElement())) && context.getPictogramElement() instanceof ContainerShape;
	}
	
	@Override
	public boolean canUndo(final IFeature feature, final IContext context) {
		return false;
	}

	@Override
	public void undo(final IFeature feature, final IContext context) {
	}

	@Override
	public boolean canRedo(final IFeature feature, final IContext context) {
		return false;
	}

	@Override
	public void redo(final IFeature feature, final IContext context) {
	}
	
	@Override
	public boolean canRemove(final IRemoveContext context) {
		return false;
	}	
	
	@Override
	public boolean canDelete(final IDeleteContext context) {
		return false;
	}
	
	@Override
	public final PictogramElement add(final IAddContext context) {
		final Element element = (Element)AadlElementWrapper.unwrap(context.getNewObject());
		final Diagram diagram = getDiagram();
		
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();

        // Create the container shape
        final ContainerShape container = peCreateService.createContainerShape(diagram, true);
        link(container, new AadlElementWrapper(element));

		// Create the GA and inner Shape
        createGaAndInnerShapes(container, element, context.getX(), context.getY());
        
        // Create anchor
        // TODO: Reevaluate when to create an anchor, etc. Delegate to child classes?
        peCreateService.createChopboxAnchor(container);
        
        this.setShapeProperties(container, element);
        
        return container;
	}
	
	@Override
	public final boolean update(final IUpdateContext context) {
		// Cause problems for connections?
		final PictogramElement pe = context.getPictogramElement();
		final Object bo = AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(pe));

		if(pe instanceof ContainerShape) {
			final ContainerShape container = (ContainerShape)pe;
			
			// Remove child shapes
			container.getChildren().clear();
			
			// Recreate the child shapes and the graphics algorithm for the shape
			createGaAndInnerShapes((ContainerShape)pe, bo, pe.getGraphicsAlgorithm().getX(), pe.getGraphicsAlgorithm().getY());
			
			setShapeProperties(container, bo);
		}

		return true;
	}

	/**
	 * Called to set properties after the shape has been created/updated
	 * @param container
	 * @param bo
	 */
	protected void setShapeProperties(final ContainerShape container, final Object bo) {}
	
	/**
	 * 
	 * @param container
	 * @param bo the unwrapped business object
	 * @param x
	 * @param y
	 */
	protected abstract void createGaAndInnerShapes(final ContainerShape container, final Object bo, int x, int y);
}
