package edu.uah.rsesc.aadl.age.diagrams.common.styles;

import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.IColorConstant;

import edu.uah.rsesc.aadl.age.styles.StyleFactory;

public class SubprogramAccessStyleFactory implements StyleFactory {
	@Override
	public Style create(final String styleId, final Diagram diagram) {
		final IGaService gaService = Graphiti.getGaService();
		final Style style = gaService.createPlainStyle(diagram, styleId);
		style.setForeground(gaService.manageColor(diagram, IColorConstant.BLACK));
        style.setBackground(gaService.manageColor(diagram, IColorConstant.WHITE));
        style.setLineStyle(LineStyle.SOLID);
        style.setLineVisible(true);
        style.setLineWidth(2);
		return style;
	}
}
