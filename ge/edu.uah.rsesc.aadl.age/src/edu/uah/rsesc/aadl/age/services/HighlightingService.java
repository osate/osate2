/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.services;

import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.osate.aadl2.Context;
import org.osate.aadl2.Element;

/**
 * Contains methods to handle highlighting objects based on editor state
 * @author philip.alldredge
 *
 */
public interface HighlightingService {
	/**
	 * Sets the foreground color of the element depending on the selected mode, mode transition, flow, etc
	 * @param modalElement
	 * @param context is the context in which the element is used. For example for a flow specification, the context will be the subcomponent. May be null
	 * @param ga
	 */
	void highlight(Element element, Context context, GraphicsAlgorithm ga);
}