/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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
	// All items are static
	private TextUtil() {
	}

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
