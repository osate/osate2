package edu.uah.rsesc.aadl.age.diagrams.common.util.impl;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;

import edu.uah.rsesc.aadl.age.diagrams.common.util.ResizeService;

public class DefaultResizeService implements ResizeService {
	private final IFeatureProvider fp;
	
	public DefaultResizeService(final IFeatureProvider fp) {
		this.fp = fp;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ResizeService#checkContainerSize(org.eclipse.graphiti.mm.pictograms.ContainerShape)
	 */
	@Override
	public void checkContainerSize(final ContainerShape shape) {
		// Check if the shape is entirely in the container
		final GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
		final int endX = ga.getX() + ga.getWidth();
		final int endY = ga.getY() + ga.getHeight();
		final ContainerShape container = shape.getContainer();
		final GraphicsAlgorithm containerGa = container.getGraphicsAlgorithm();
		if(ga.getX() < 0 || ga.getY() < 0 || containerGa.getWidth() < endX || containerGa.getHeight() < endY) {
			// Call the update feature on the container to adjust the size
			final UpdateContext context = new UpdateContext(container);
			final IUpdateFeature feature = fp.getUpdateFeature(context);
			if(feature != null) {
				if(feature.canUpdate(context)) {
					feature.update(context);
					
					// Refresh the diagram visualization
					fp.getDiagramTypeProvider().getDiagramBehavior().refresh();
				}
			}
		}		
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ResizeService#checkSize(org.eclipse.graphiti.mm.pictograms.ContainerShape)
	 */
	@Override
	public void checkSize(final ContainerShape container) {
		boolean updateShape = false;
		
		// Check if the shape is entirely in the container
		final GraphicsAlgorithm containerGa = container.getGraphicsAlgorithm();
		for(final Shape child : container.getChildren()) {
			final GraphicsAlgorithm childGa = child.getGraphicsAlgorithm();
			final int endX = childGa.getX() + childGa.getWidth();
			final int endY = childGa.getY() + childGa.getHeight();
			if(childGa.getX() < 0 || childGa.getY() < 0 || containerGa.getWidth() < endX || containerGa.getHeight() < endY) {
				updateShape = true;
				break;
			}	
		}
		
		if(updateShape) {
			// Call the update feature on the shape to adjust the size
			final UpdateContext context = new UpdateContext(container);
			final IUpdateFeature feature = fp.getUpdateFeature(context);
			if(feature != null) {
				if(feature.canUpdate(context)) {
					feature.update(context);
					
					// Refresh the diagram visualization
					fp.getDiagramTypeProvider().getDiagramBehavior().refresh();
				}
			}
		}			
	}
}
