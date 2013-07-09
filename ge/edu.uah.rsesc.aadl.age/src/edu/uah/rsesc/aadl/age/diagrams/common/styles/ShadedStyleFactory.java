package edu.uah.rsesc.aadl.age.diagrams.common.styles;

import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.ColorConstant;

import edu.uah.rsesc.aadl.age.styles.StyleFactory;

public class ShadedStyleFactory implements StyleFactory {
	@Override
	public Style create(final String styleId, final Diagram diagram) {
		final IGaService gaService = Graphiti.getGaService();
		final Style style = gaService.createPlainStyle(diagram, styleId);
		style.setBackground(Graphiti.getGaService().manageColor(diagram, ColorConstant.LIGHT_GRAY));
		return style;
	}
}
