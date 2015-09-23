package org.osate.ge.diagrams.common.styles;

import javax.inject.Named;

import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.IColorConstant;
import org.osate.ge.ext.ExtensionConstants;
import org.osate.ge.ext.annotations.Activate;

public class DefaultAnnexStyleFactory {
	@Activate
	public Style create(final @Named(ExtensionConstants.STYLE_ID) String styleId, Diagram diagram) {
		final IGaService gaService = Graphiti.getGaService();
		final Style style = gaService.createPlainStyle(diagram, styleId);
		style.setFilled(false);
		style.setBackground(gaService.manageColor(diagram, IColorConstant.WHITE));
		style.setForeground(gaService.manageColor(diagram, IColorConstant.BLACK));
		style.setLineStyle(LineStyle.SOLID);
		style.setLineVisible(true);
		style.setLineWidth(2);
		style.setTransparency(0.0);
		return style;
	}
}
