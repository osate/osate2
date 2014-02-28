/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.services.impl;

import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.services.PrototypeService;
import org.osate.ge.services.SubcomponentService;

public class DefaultSubcomponentService implements SubcomponentService {
	private final PrototypeService prototypeService;
	
	public DefaultSubcomponentService(final PrototypeService prototypeService) {
		this.prototypeService = prototypeService;
	}
	
	@Override
	public ComponentClassifier getComponentClassifier(final Shape shape, final Subcomponent sc) {
		if(sc.getPrototype() == null) {
			return sc.getClassifier();
		} else {
			return prototypeService.getComponentClassifier(prototypeService.getPrototypeBindingContext(shape), sc);	
		}
	}	
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.ClassifierService#getComponentCategory(org.eclipse.graphiti.mm.pictograms.Shape, org.osate.aadl2.Subcomponent)
	 */
	@Override
	public ComponentCategory getComponentCategory(final Shape shape, final Subcomponent sc) {
		final ComponentClassifier c = getComponentClassifier(shape, sc);
		return c == null ? sc.getCategory() : c.getCategory();
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.ClassifierService#isImplementation(org.eclipse.graphiti.mm.pictograms.Shape, org.osate.aadl2.Subcomponent)
	 */
	@Override
	public boolean isImplementation(final Shape shape, final Subcomponent sc) {
		final ComponentClassifier c = getComponentClassifier(shape, sc);
		return c == null ? false : c instanceof ComponentImplementation;
	}
}
