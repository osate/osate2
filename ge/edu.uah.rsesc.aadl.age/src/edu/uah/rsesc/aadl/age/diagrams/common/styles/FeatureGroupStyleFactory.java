package edu.uah.rsesc.aadl.age.diagrams.common.styles;

import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.ui.PlatformUI;

import edu.uah.rsesc.aadl.age.services.StyleProviderService;
import edu.uah.rsesc.aadl.age.styles.StyleFactory;

public class FeatureGroupStyleFactory implements StyleFactory {
	@Override
	public Style create(final String styleId, final Diagram diagram) {
		final IGaService gaService = Graphiti.getGaService();
		final StyleProviderService styleProvider = (StyleProviderService) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getService(StyleProviderService.class);

		final Style classifierStyle = styleProvider.getStyle(diagram, "classifier");
		final Style style = gaService.createPlainStyle(classifierStyle, styleId);
		style.setBackground(Graphiti.getGaService().manageColor(diagram, ColorConstant.BLACK));
		return style;
	}
}
