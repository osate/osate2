package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;

public class ResizeHelper {
	/**
	 * Checks the size of the container and resizes it if necessary
	 */
	public static void checkContainerSize(final ContainerShape shape, final IFeatureProvider fp) {
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
	
	public static void checkSize(final ContainerShape container, final IFeatureProvider fp) {
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
