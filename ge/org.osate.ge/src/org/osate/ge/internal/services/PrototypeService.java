/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services;

import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.internal.DiagramElementProxy;

/**
 * Contains methods for working with AADL prototypes
 *
 */
public interface PrototypeService {
	ComponentClassifier getComponentClassifier(Element bindingContext, Subcomponent sc);
	FeatureGroupType getFeatureGroupType(Element bindingContext, FeatureGroup fg);
	
	/**
	 * @param shape
	 * @param fp
	 * @return
	 */
	Element getPrototypeBindingContext(Shape shape);
}
