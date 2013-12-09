/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.services;

import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.util.IColorConstant;

/**
 * Contains methods for accessing styles
 * @author philip.alldredge
 *
 */
// CLEAN-UP: Needs to be merged with StyleProviderService
// TODO: Move architecture in a direction so that the style interface will only provide generic functionality
public interface StyleService {

	Style getStyle(String styleId);

	Style getSystemStyle(boolean isImplementation);

	Style getProcessStyle(boolean isImplementation);

	Style getThreadGroupStyle(boolean isImplementation);

	Style getThreadStyle(boolean isImplementation);

	Style getSubprogramStyle(boolean isImplementation);

	Style getSubprogramGroupStyle(boolean isImplementation);

	Style getDataStyle(boolean isImplementation);

	Style getAbstractStyle(boolean isImplementation);

	Style getVirtualBusStyle(boolean isImplementation);

	Style getVirtualProcessorStyle(boolean isImplementation);

	Style getBusStyle(boolean isImplementation);

	Style getProcessorStyle(boolean isImplementation);

	Style getDeviceStyle(boolean isImplementation);

	Style getMemoryStyle(boolean isImplementation);

	Style getFeatureGroupStyle();

	Style getShadedStyle();

	Style getImplementsStyle();

	Style getFlowSpecificationStyle();

	Style getExtendsStyle();

	Style getGeneralizationArrowHeadStyle();

	Style getDecoratorStyle();

	Style getModeTransitionTrigger();

	Style getLabelStyle();

	Style getFeatureStyle();

	Style getSubprogramAccessStyle();

	Style getSubprogramGroupAccessStyle();

	Style getBackgroundStyle();

	Style getFeatureGroupLargeCircleStyle();

	Style getFeatureGroupSmallCircleStyle();

	Style getModeStyle();

	Style getInitialModeStyle();

	IColorConstant getInSelectedModeColor();
	
	/**
	 * Refresh styles used by all the diagrams. Removes all styles from the diagram and then finds any usage of styles and reset them.
	 * @param diagram
	 */
	void refreshStyles();

}