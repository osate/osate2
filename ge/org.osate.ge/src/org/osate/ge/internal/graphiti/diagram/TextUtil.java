package org.osate.ge.internal.graphiti.diagram;

import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.mm.algorithms.AbstractText;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.widgets.Display;
import org.osate.ge.graphics.Style;

public class TextUtil {
	// Default font size will be used if specified font size is null.
	// The text's size will be updated based on its current value. For that reason, the value of the text must be set before calling this function.
	public static void setStyleAndSize(final Diagram diagram, final AbstractText text, final Double fontSize) {
		setStyle(diagram, text, fontSize);

		// Get sizes of text graphics algorithms
		final IDimension labelTextSize = GraphitiUi.getUiLayoutService().calculateTextSize(text.getValue(),
				text.getFont(), true);

		// Add padding to the text size to account for rounding issues in GEF3/Graphiti
		final int paddedLabelTextWidth = labelTextSize.getWidth() + Math.max(15, text.getValue().length());
		final int paddedLabelTextHeight = labelTextSize.getHeight() + 5;

		text.setWidth(paddedLabelTextWidth);
		text.setHeight(paddedLabelTextHeight);
	}

	public static void setStyle(final Diagram diagram, final AbstractText text, final Double fontSize) {
		final IGaService gaService = Graphiti.getGaService();
		text.setForeground(gaService.manageColor(diagram, IColorConstant.BLACK));
		text.setFilled(false);
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setFont(gaService.manageFont(diagram, "Arial",
				getScaledFontPointSize(fontSize == null ? Style.DEFAULT.getFontSize() : fontSize), false, true));
	}

	private static int getScaledFontPointSize(final double unscaledFontSize) {
		double scaleFactor = 1.0;
		// Don't scale on Linux. Assume font DPI is 96, which is the default for X.org.
		// There seems to be no OS independent way to get the font DPI if the X.org default is overridden.
		if (!System.getProperty("os.name").startsWith("Linux")) {
			final Device device = Display.getCurrent();
			scaleFactor = 96.0 / device.getDPI().y;
		}
		// Round to 1 decimal point before casting to int.
		// This ensures that the value is rounded up only in cases where the value is within .1 of a whole number
		final int fontSizeInPoints = (int) (Math.round(unscaledFontSize * scaleFactor * 10.0) / 10.0);
		return fontSizeInPoints;
	}
}
