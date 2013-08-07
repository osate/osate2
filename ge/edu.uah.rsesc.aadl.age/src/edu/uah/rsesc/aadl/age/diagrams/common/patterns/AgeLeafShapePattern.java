package edu.uah.rsesc.aadl.age.diagrams.common.patterns;

import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.Element;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.AnchorUtil;

/**
 * Class for shapes that have their inside recreated on updating. Even though they may have child shapes they are created as an automatic unit because their children may 
 * be recreated during updates.
 * @author philip.alldredge
 *
 */
public abstract class AgeLeafShapePattern extends AgePattern {
	@Override
	public final PictogramElement add(final IAddContext context) {
		final Element element = (Element)AadlElementWrapper.unwrap(context.getNewObject());
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();

        // Create the container shape
        final ContainerShape container = peCreateService.createContainerShape(context.getTargetContainer(), true);
        link(container, new AadlElementWrapper(element));

		// Create the GA and inner Shape
        refreshGaAndInnerShapes(container, element, context.getX(), context.getY());
        updateAnchors(container);
        setShapeProperties(container, element);
        
        return container;
	}
	
	/**
	 * Creates anchors. If they already exist, then they are updated.
	 * @param container
	 */
	protected void updateAnchors(final ContainerShape container) {
		AnchorUtil.createOrUpdateChopboxAnchor(container, chopboxAnchorName);
	}
	
	@Override
	public final boolean update(final IUpdateContext context) {
		final PictogramElement pe = context.getPictogramElement();
		final Object bo = AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(pe));

		if(pe instanceof ContainerShape) {
			final ContainerShape container = (ContainerShape)pe;		
		
			// Update/Recreate the child shapes and the graphics algorithm for the shape
			refreshGaAndInnerShapes((ContainerShape)pe, bo, pe.getGraphicsAlgorithm().getX(), pe.getGraphicsAlgorithm().getY());
			
			updateAnchors(container);
			
			setShapeProperties(container, bo);
		}

		return true;
	}

	/**
	 * Called to set properties after the shape has been created/updated
	 * @param container
	 * @param bo
	 */
	protected void setShapeProperties(final ContainerShape shape, final Object bo) {}
	
	/**
	 * 
	 * @param container
	 * @param bo the unwrapped business object
	 * @param x
	 * @param y
	 */
	protected abstract void refreshGaAndInnerShapes(final ContainerShape shape, final Object bo, int x, int y);
}
