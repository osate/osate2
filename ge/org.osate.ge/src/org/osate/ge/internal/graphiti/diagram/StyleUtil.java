package org.osate.ge.internal.graphiti.diagram;

import java.util.OptionalInt;

import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

class StyleUtil {
	public static void overrideStyle(final PictogramElement pe,
			final org.eclipse.graphiti.mm.algorithms.styles.Color background,
			final org.eclipse.graphiti.mm.algorithms.styles.Color outline,
			final org.eclipse.graphiti.mm.algorithms.styles.Color fontColor, final OptionalInt lineWidth) {
		if (pe.getGraphicsAlgorithm() != null) {
			overrideStyle(pe.getGraphicsAlgorithm(), background, outline, fontColor, lineWidth);
		}

		// Handle coloring containers
		if (pe instanceof ContainerShape) {
			for (final Shape childShape : ((ContainerShape) pe).getChildren()) {
				// Only update child shapes which are transient. Transient shapes are typically and inherent part of the shape rather than being an independent
				// object.
				if (PropertyUtil.isTransient(childShape)) {
					overrideStyle(childShape, background, outline, fontColor, lineWidth);
				}
			}
		} else if (pe instanceof Connection) {
			// Color connection decorators
			for (final ConnectionDecorator cd : ((Connection) pe).getConnectionDecorators()) {
				overrideStyle(cd, background, outline, fontColor, lineWidth);
			}
		}
	}

	private static void overrideStyle(final GraphicsAlgorithm ga,
			final org.eclipse.graphiti.mm.algorithms.styles.Color background,
			final org.eclipse.graphiti.mm.algorithms.styles.Color outline,
			final org.eclipse.graphiti.mm.algorithms.styles.Color fontColor, final OptionalInt lineWidth) {
		final boolean isColoringContainer = PropertyUtil.isColoringContainer(ga);
		final boolean isColoringChild = PropertyUtil.isColoringChild(ga);

		if (isColoringChild) {
			if (ga.getForeground() != null) {
				if (ga instanceof Text) {
					ga.setForeground(fontColor);
				} else if (outline != null) {
					ga.setForeground(outline);
				}
			}

			// Also set background of label
			if (ga.getBackground() != null) {
				ga.setBackground(background);
			}

			if (lineWidth.isPresent() && ga.getLineWidth() != null) {
				ga.setLineWidth(lineWidth.getAsInt());
			}
		}

		if (isColoringContainer) {
			for (final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
				overrideStyle(childGa, background, outline, fontColor, lineWidth);
			}
		}
	}
}
