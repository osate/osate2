/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.common;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.impl.IIndependenceSolver;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.ge.services.SerializableReferenceService;
import org.osate.ge.ui.xtext.AgeXtextUtil;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;

// NOTE: There is an issue where there could be confusion over which element is being referenced. Qualified names are not always unique. Features and Component Implementations could conflict
public class IndependenceProvider implements IIndependenceSolver {
	private final SerializableReferenceService serializableReferenceService;
	private final IFeatureProvider featureProvider;
	private boolean gettingDiagramObj = false; // Flag to indicate which code path to use. Needed because the independence provider needs to get the object for the diagram which would otherwise result in endless recursion
	
	@Inject
	public IndependenceProvider(final SerializableReferenceService serializableReferenceService, final IFeatureProvider featureProvider) {
		this.serializableReferenceService = serializableReferenceService;
		this.featureProvider = featureProvider;
	}

	@Override
	public String getKeyForBusinessObject(Object bo) {
		return serializableReferenceService.getReference(AadlElementWrapper.unwrap(bo));
	}
	
	// Returns the named element for a key from a diagram object
	private NamedElement getDiagramElement(final String key) {
		final String[] segs = key.split(" ");
		if(segs.length < 2) {
			return null;
		}
		
		final String name = segs[1];
		
		return (NamedElement)EMFIndexRetrieval.getObjectByQualifiedName(name, AgeXtextUtil.getResourceSetByQualifiedName(name));
	}
	
	private AadlPackage getPackage() {
		final Diagram diagram = featureProvider.getDiagramTypeProvider().getDiagram();
		gettingDiagramObj = true;
		final NamedElement diagramElement = (NamedElement)featureProvider.getBusinessObjectForPictogramElement(diagram);
		gettingDiagramObj = false;
		
		if(diagramElement == null) {
			return null;
		}

		if(diagramElement instanceof AadlPackage) {
			return (AadlPackage)diagramElement;
		} else {
			final Element pkg = diagramElement.getNamespace().getOwner();
			if(pkg instanceof AadlPackage) {
				return (AadlPackage)pkg;
			}
		}
		
		return null;
	}
	
	@Override
	public Object getBusinessObjectForKey(String key) {	
		if(key == null) {
			return null;
		}

		// Check if we are trying to get the element corresponding to the diagram
		if(gettingDiagramObj) {
			return getDiagramElement(key);
		} else {
			final AadlPackage pkg = getPackage();
			if(pkg == null) {
				return null;
			}
			
			// Get the resource set
			final XtextResourceSet resourceSet = AgeXtextUtil.getResourceSetByQualifiedName(pkg.getQualifiedName());
			if(resourceSet == null) {
				return null;
			}
			
			Object bo = serializableReferenceService.getReferencedObject(resourceSet, key);
			if(bo instanceof Element) {
				bo = new AadlElementWrapper((Element)bo);
			}

			return bo;
		}
	}
}
