package edu.uah.rsesc.aadl.age.styles;

import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.IColorConstant;

public class ClassifierLabelStyleFactory implements StyleFactory {
	@Override
	public Style create(final String styleId, final Diagram diagram) {
		final IGaService gaService = Graphiti.getGaService();
		final Style style = gaService.createPlainStyle(diagram, styleId);
		style.setForeground(gaService.manageColor(diagram, IColorConstant.BLACK));
        style.setFilled(false);
        style.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
        style.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
        style.setFont(gaService.manageDefaultFont(diagram, false, true));
		return style;
	}
}
