package org.osate.ge.internal.graphiti.diagram;

import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

class ColoringUtil {
	public static void overrideElementStyle(final PictogramElement pe, final org.eclipse.graphiti.mm.algorithms.styles.Color background, final org.eclipse.graphiti.mm.algorithms.styles.Color outline, final org.eclipse.graphiti.mm.algorithms.styles.Color fontColor, final int lineWidth) {
		if(pe.getGraphicsAlgorithm() != null) {
			overrideElementStyle(pe.getGraphicsAlgorithm(), background, outline, fontColor, lineWidth);
		}

		// Handle coloring containers
		if(pe instanceof ContainerShape) {
			for(final Shape childShape : ((ContainerShape)pe).getChildren()) {
				// Only update child shapes which are transient. Transient shapes are typically and inherent part of the shape rather than being an independent object. 
				if(PropertyUtil.isTransient(childShape)) {
					overrideElementStyle(childShape, background, outline, fontColor, 0);
				}
			}
		} else if(pe instanceof Connection) {			
			// Color connection decorators
			for(final ConnectionDecorator cd : ((Connection) pe).getConnectionDecorators()) {
				overrideElementStyle(cd, background, outline, fontColor, lineWidth);
			}
		}
	}

	private static void overrideElementStyle(final GraphicsAlgorithm ga, final org.eclipse.graphiti.mm.algorithms.styles.Color background, final org.eclipse.graphiti.mm.algorithms.styles.Color outline, final org.eclipse.graphiti.mm.algorithms.styles.Color fontColor, final int lineWidth) {
		final boolean isColoringContainer = PropertyUtil.isColoringContainer(ga);
		final boolean isColoringChild = PropertyUtil.isColoringChild(ga);

		if(isColoringChild && ga.getForeground() != null) {
			if(ga instanceof Text) {
				ga.setForeground(fontColor);
			} else if(outline != null) {
				ga.setForeground(outline);
			}
		}

		// Also set background of label
		if(ga.getBackground() != null) {
			ga.setBackground(background);
		}
		
		if(lineWidth != 0 && ga.getLineWidth() != null) {
			ga.setLineWidth(lineWidth);
		}

		if(isColoringContainer) {
			for(final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
				overrideElementStyle(childGa, background, outline, fontColor, lineWidth);
			}
		}
	}
}
