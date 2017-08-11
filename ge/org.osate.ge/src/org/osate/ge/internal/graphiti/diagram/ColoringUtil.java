package org.osate.ge.internal.graphiti.diagram;

import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

class ColoringUtil {
	public static void overrideForeground(final PictogramElement pe, final org.eclipse.graphiti.mm.algorithms.styles.Color color) {
		if(pe.getGraphicsAlgorithm() != null) {
			overrideForeground(pe.getGraphicsAlgorithm(), color);
		}
		
		// Handle coloring containers
		if(pe instanceof ContainerShape) {
			for(final Shape childShape : ((ContainerShape)pe).getChildren()) {
				// Only update child shapes which are transient. Transient shapes are typically and inherent part of the shape rather than being an independent object. 
				if(PropertyUtil.isTransient(childShape)) {
					overrideForeground(childShape, color);
				}
			}
		} else {			
			// Color connection decorators
			if(pe instanceof Connection) {
				for(final ConnectionDecorator cd : ((Connection) pe).getConnectionDecorators()) {
					overrideForeground(cd, color);
				}
			}
		}
	}
	
	private static void overrideForeground(final GraphicsAlgorithm ga, org.eclipse.graphiti.mm.algorithms.styles.Color color) {
		final boolean isColoringContainer = PropertyUtil.isColoringContainer(ga);
		final boolean isColoringChild = PropertyUtil.isColoringChild(ga);
		
		if(isColoringChild && ga.getForeground() != null) {
			ga.setForeground(color);
		}
		
		if(isColoringContainer) {
			for(final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
				overrideForeground(childGa, color);
			}
		}
	}
}
