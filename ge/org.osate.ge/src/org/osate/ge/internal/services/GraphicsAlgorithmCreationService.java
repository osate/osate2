// Based on OSATE Graphical Editor. Modifications are: 
/*
Copyright (c) 2016, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
*/
/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.services;

import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.MultiText;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.AccessCategory;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PortCategory;
import org.osate.aadl2.instance.FeatureInstance;

/**
 * Contains methods to create graphics algorithms.
 *
 */
// TODO: Move architecture in a direction so that this interface will only provide generic functionality
public interface GraphicsAlgorithmCreationService {

	Text createLabelGraphicsAlgorithm(GraphicsAlgorithmContainer container, String labelTxt);
	
	MultiText createMultiLineLabelGraphicsAlgorithm(GraphicsAlgorithmContainer container, String labelTxt);
	
	Text createAnnotationGraphicsAlgorithm(GraphicsAlgorithmContainer container, String annotationTxt);

	/**
	 * Creates a graphics algorithm that is designed to be placed behind a label to improve readability
	 * @param container
	 * @return
	 */
	GraphicsAlgorithm createTextBackground(GraphicsAlgorithmContainer container);
	
	/**
	 * Creates a graphics algorithm representing a specified classifer or subcomponent. 
	 * @param shape
	 * @param element the classifier or subcomponent for which to create the graphics algorithm. If the classifier is null then a generic representation is returned.
	 * @param width
	 * @param height
	 * @return
	 */
	GraphicsAlgorithm createClassifierGraphicsAlgorithm(Shape shape, Element element, int width, int height);
	
	GraphicsAlgorithm createComponentGraphicsAlgorithm(Shape shape, ComponentCategory category, boolean isImplementation, int width, int height);

	/**
	 * Works for regular, internal, and processor features
	 * @param shape
	 * @param feature
	 * @return
	 */
	GraphicsAlgorithm createFeatureGraphicsAlgorithm(Shape shape, NamedElement feature);

	/**
	 * 
	 * @param shape
	 * @param featureInstance
	 * @param height only used for feature groups
	 * @return
	 */
	GraphicsAlgorithm createFeatureInstanceGraphicsAlgorithm(Shape shape, FeatureInstance featureInstance, int height);

	GraphicsAlgorithm createPortGraphicsAlgorithm(Shape shape, PortCategory category, DirectionType direction);

	GraphicsAlgorithm createAccessGraphicsAlgorithm(Shape shape, AccessCategory category, AccessType accessType);

	GraphicsAlgorithm createModeGraphicsAlgorithm(
			GraphicsAlgorithmContainer container, int width,
			int height);

	GraphicsAlgorithm createInitialModeGraphicsAlgorithm(
			GraphicsAlgorithmContainer container, int size);

	GraphicsAlgorithm createFeatureGroupGraphicsAlgorithm(
			GraphicsAlgorithmContainer container, int width,
			int height);

	void createDirectionIndicator(final GraphicsAlgorithmContainer gaContainer, final int x, final Style style);
	void createDelayedIndicator(final GraphicsAlgorithmContainer gaContainer, final int x, final Style style);

}