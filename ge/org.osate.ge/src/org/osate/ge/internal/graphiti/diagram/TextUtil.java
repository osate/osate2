package org.osate.ge.internal.graphiti.diagram;

import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.widgets.Display;
import org.osate.ge.graphics.Style;

public class TextUtil {
	// Default font size will be used if specified font size is null.
	public static void setStyle(final Diagram diagram, final Text text, final Double fontSize) {
		final IGaService gaService = Graphiti.getGaService();
		text.setForeground(gaService.manageColor(diagram, IColorConstant.BLACK));
		text.setFilled(false);
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setFont(gaService.manageFont(diagram, "Arial",
				getScaledFontPointSize(fontSize == null ? Style.DEFAULT.getFontSize() : fontSize), false, true));
	}

	private static int getScaledFontPointSize(final double unscaledFontSize) {
		final Device device = Display.getCurrent();
		// Round to 1 decimal point before casting to int.
		// This ensures that the value is rounded up only in cases where the value is within .1 of a whole number
		final int fontSizeInPoints = (int)(Math.round(unscaledFontSize*96.0/device.getDPI().y*10.0)/10.0);
		return fontSizeInPoints;
	}
}
