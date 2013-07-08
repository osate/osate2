package edu.uah.rsesc.aadl.age.styles;

import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.ui.PlatformUI;

public class DashedComponentTypeStyleFactory implements StyleFactory {
	@Override
	public Style create(final String styleId, final Diagram diagram) {
		final IGaService gaService = Graphiti.getGaService();
		final StyleProvider styleProvider = (StyleProvider) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getService(StyleProvider.class);
		
		final String implSuffix = "-implementation";
		if(styleId.endsWith(implSuffix)) {
			final Style baseStyle = styleProvider.getStyle(diagram, styleId.substring(0, styleId.length()-implSuffix.length()));
			final Style style = gaService.createPlainStyle(baseStyle, styleId);
			style.setLineWidth(2);
			return style;
		} else {
			final Style classifierStyle = styleProvider.getStyle(diagram, "classifier");
			final Style style = gaService.createPlainStyle(classifierStyle, styleId);
			style.setLineStyle(LineStyle.DASH);
			return style;
		}
	}
}
