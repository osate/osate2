/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.common.styles;

import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.ui.PlatformUI;
import org.osate.ge.services.StyleProviderService;
import org.osate.ge.styles.StyleFactory;

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
