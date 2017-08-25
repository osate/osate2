package org.osate.ge.internal.ui.editor;

import java.util.OptionalInt;

import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.ge.internal.graphiti.ShapeNames;
import org.osate.ge.internal.graphiti.diagram.PropertyUtil;

public class StyleUtil {
	public static void overrideStyle(final PictogramElement pe,
			final org.eclipse.graphiti.mm.algorithms.styles.Color background,
			final org.eclipse.graphiti.mm.algorithms.styles.Color outline,
			final org.eclipse.graphiti.mm.algorithms.styles.Color labelBackground,
			final org.eclipse.graphiti.mm.algorithms.styles.Color fontColor, final OptionalInt lineWidth,
			final boolean inLabel) {
		if (pe.getGraphicsAlgorithm() != null) {
			final org.eclipse.graphiti.mm.algorithms.styles.Color childBackground = inLabel ? labelBackground
					: background;

			overrideStyle(pe.getGraphicsAlgorithm(), childBackground, outline, fontColor, lineWidth);
		}

		// Handle coloring containers
		if (pe instanceof ContainerShape) {
			for (final Shape childShape : ((ContainerShape) pe).getChildren()) {
				// Only update child shapes which are transient. Transient shapes are typically and inherent part of the shape rather than being an independent
				// object.
				if (inLabel || isPrimaryLabelOrAnnotation(childShape)) {
					overrideStyle(childShape, background, outline, labelBackground,
							fontColor, lineWidth, true);
				}
			}
		} else if (pe instanceof Connection) {
			// Color connection decorators
			for (final ConnectionDecorator cd : ((Connection) pe).getConnectionDecorators()) {
				if (inLabel || isPrimaryLabelOrAnnotation(cd) || PropertyUtil.isStylingContainer(cd)) {
					overrideStyle(cd, background, outline, labelBackground, fontColor, lineWidth, true);
				}
			}
		}
	}

	private static boolean isPrimaryLabelOrAnnotation(final PictogramElement pe) {
		final String name = PropertyUtil.getName(pe);
		return ShapeNames.primaryLabelShapeName.equals(name) || ShapeNames.annotationShapeName.equals(name);
	}

	private static void overrideStyle(final GraphicsAlgorithm ga,
			final org.eclipse.graphiti.mm.algorithms.styles.Color background,
			final org.eclipse.graphiti.mm.algorithms.styles.Color outline,
			final org.eclipse.graphiti.mm.algorithms.styles.Color fontColor, final OptionalInt lineWidth) {
		final boolean isStylingContainer = PropertyUtil.isStylingContainer(ga);
		final boolean isStylingChild = PropertyUtil.isStylingChild(ga);
		final boolean isStylingOutlineEnabled = PropertyUtil.isStylingOutlineEnabled(ga);

		if(isStylingOutlineEnabled) {
			if(ga.getForeground() != null && !(ga instanceof Text)) {
				if (outline != null) {
					ga.setForeground(outline);
				}
			}
		}

		if (isStylingChild) {
			if (ga.getForeground() != null) {
				if (ga instanceof Text) {
					ga.setForeground(fontColor);
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

		if (isStylingContainer) {
			for (final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
				overrideStyle(childGa, background, outline, fontColor, lineWidth);
			}
		}
	}
}
