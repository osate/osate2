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
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.features;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;

import java.util.Objects;

import javax.inject.Inject;

import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;
import org.osate.ge.EmfContainerProvider;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.GraphitiService;

public class GraphicalToTextualFeature extends AbstractCustomFeature {
	private final BusinessObjectResolutionService bor;

	@Inject
	public GraphicalToTextualFeature(final GraphitiService graphiti, final BusinessObjectResolutionService bor) {	
		super(graphiti.getFeatureProvider());
		this.bor = bor;
	}	
	
	@Override
    public String getName() {
        return "Go to AADL Source";
    }
 
    @Override
    public String getDescription() {
        return "Go to the AADL textual representation of this element.";
    }

    @Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		PictogramElement[] pes = customCtx.getPictogramElements();		
		if(customCtx.getPictogramElements().length < 1) {
			return false;
		}
		final PictogramElement pe = pes[0];	
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);

		return (bo instanceof EObject || bo instanceof EmfContainerProvider) && !(bo instanceof InstanceObject);
	}
    
    @Override
    public boolean canExecute(ICustomContext context) {   	
    	return true;
    }
    
	@Override
	public void execute(ICustomContext context) 
	{
		final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElements()[0]);
		final EObject boEObj;
		if(bo instanceof EObject) {
			boEObj = (EObject)bo;
		} else if(bo instanceof EmfContainerProvider) {
			boEObj = ((EmfContainerProvider) bo).getEmfContainer();
		} else {
			throw new RuntimeException("Unsupported type: " + bo);
		}
		
		final URI uri = Objects.requireNonNull(EcoreUtil.getURI(boEObj), "Unable to get URI for business object");
		if(!(boEObj.eResource() instanceof XtextResource)) {
			throw new RuntimeException("The resource of the loaded business object resource is not an XtextResource");
		}

		final XtextResource res = (XtextResource)boEObj.eResource();
		final GlobalURIEditorOpener opener = Objects.requireNonNull((GlobalURIEditorOpener)res.getResourceServiceProvider().get(GlobalURIEditorOpener.class), "unable to get global URI Editor opener");
		opener.open(uri, true);
	}
}