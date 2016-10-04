/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.styles;

import javax.inject.Named;

import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.widgets.Display;
import org.osate.ge.di.Activate;
import org.osate.ge.internal.di.InternalNames;

public class LabelStyleFactory {
	@Activate
	public Style create(final @Named(InternalNames.STYLE_ID) String styleId, final Diagram diagram) {
		final IGaService gaService = Graphiti.getGaService();
		final Style style = gaService.createPlainStyle(diagram, styleId);
		style.setForeground(gaService.manageColor(diagram, IColorConstant.BLACK));
        style.setFilled(false);
        style.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
        style.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
        style.setFont(gaService.manageFont(diagram, "Arial", getScaledFontPointSize(10.0), false, true));
		return style;
	}
	
	private static int getScaledFontPointSize(final double unscaledFontSize) {
		final Device device = Display.getCurrent();
		// Round to 1 decimal point before casting to int. 
		// This ensures that the value is rounded up only in cases where the value is within .1 of a whole number
		final int fontSizeInPoints = (int)(Math.round(unscaledFontSize*96.0/device.getDPI().y*10.0)/10.0);
		return fontSizeInPoints;
	}
}
