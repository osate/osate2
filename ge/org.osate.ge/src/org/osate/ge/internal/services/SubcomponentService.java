/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services;

import java.util.List;

import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementationReference;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.ge.internal.diagram.AgeDiagramElement;

/**
 * Contains methods for working with AADL Subcomponents
 *
 */
public interface SubcomponentService {
	ComponentClassifier getComponentClassifier(AgeDiagramElement diagramElementContainer, Subcomponent sc);
	
	/**
	 * Resolves the component classifier for the subcomponent
	 * @param shape
	 * @param sc
	 * @return
	 */
	ComponentClassifier getComponentClassifier(Shape shape, Subcomponent sc);
	
	ComponentCategory getComponentCategory(Shape shape, Subcomponent sc);

	boolean isImplementation(Shape shape, Subcomponent sc);
	
	/**
	 * Gets the subcomponent type for a subcomponent. Checks refined subcomponents.
	 * This is different from getComponentClassifier() because it does not resolve the type if it is a prototype
	 * @param sc
	 * @return
	 */
	SubcomponentType getAllSubcomponentType(Subcomponent sc);

	// Checks the subcomponent and then refined subcomponents and returns the first non-empty list of component implementation references.
	// Returns an empty list if they are all empty.
	List<ComponentImplementationReference> getArrayComponentImplementationReferences(Subcomponent sc);
}
