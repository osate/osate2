/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.styles;

import javax.inject.Named;

import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.IColorConstant;
import org.osate.ge.ext.ExtensionConstants;
import org.osate.ge.ext.annotations.Activate;

/**
 * Style used for annotations such as feature annotations that specify that a feature is an internal or processor feature
 * @author philip.alldredge
 *
 */
public class AnnotationStyleFactory {
	@Activate
	public Style create(final @Named(ExtensionConstants.STYLE_ID) String styleId, final Diagram diagram) {
		final IGaService gaService = Graphiti.getGaService();
		final Style style = gaService.createPlainStyle(diagram, styleId);
		style.setForeground(gaService.manageColor(diagram, IColorConstant.BLACK));
        style.setFilled(false);
        style.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
        style.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
        style.setFont(gaService.manageFont(diagram, "Arial", 10, false, true));
		return style;
	}
}
