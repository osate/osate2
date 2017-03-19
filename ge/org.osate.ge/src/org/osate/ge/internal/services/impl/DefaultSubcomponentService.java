/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import java.util.List;

import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentImplementationReference;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.ge.internal.diagram.AgeDiagramElement;
import org.osate.ge.internal.services.PrototypeService;
import org.osate.ge.internal.services.SubcomponentService;

public class DefaultSubcomponentService implements SubcomponentService {
	private final PrototypeService prototypeService;
	
	public DefaultSubcomponentService(final PrototypeService prototypeService) {
		this.prototypeService = prototypeService;
	}
	
	@Override
	public ComponentClassifier getComponentClassifier(final AgeDiagramElement diagramElementContainer, final Subcomponent sc) {
		if(sc.getPrototype() == null) {
			if(sc.getClassifier() == null && sc.getRefined() != null) {
				return getComponentClassifier(diagramElementContainer, sc.getRefined());
			} else {
				return sc.getClassifier();
			}
		} else {
			return prototypeService.getComponentClassifier(prototypeService.getPrototypeBindingContextByContainer(diagramElementContainer), sc);	
		}
	}	
	
	@Override
	public ComponentClassifier getComponentClassifier(final Shape shape, final Subcomponent sc) {
		if(sc.getPrototype() == null) {
			if(sc.getClassifier() == null && sc.getRefined() != null) {
				return getComponentClassifier(shape, sc.getRefined());
			} else {
				return sc.getClassifier();
			}
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
	
	@Override
	public SubcomponentType getAllSubcomponentType(Subcomponent sc) {
		SubcomponentType scType;
		do {
			scType = sc.getSubcomponentType();
			sc = sc.getRefined();
		} while(sc != null && scType == null);
		
		return scType;		
	}
	
	public List<ComponentImplementationReference> getArrayComponentImplementationReferences(final Subcomponent sc) {
		Subcomponent tmpSc = sc;
		List<ComponentImplementationReference> refs;
		
		do {
			refs = tmpSc.getImplementationReferences();
			tmpSc = tmpSc.getRefined();
		} while(tmpSc != null && refs.size() == 0);
		
		return refs;
	}
}
