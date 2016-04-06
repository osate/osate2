/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.features;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;

import javax.inject.Inject;

import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.GraphitiService;

public class GraphicalToTextualFeature extends AbstractCustomFeature {
	private final BusinessObjectResolutionService bor;
	public final static String HINT = "graphicalToTextualFeature";
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

		return bo instanceof NamedElement;
	}
    
    @Override
    public boolean canExecute(ICustomContext context) {   	
    	return true;
    }
    
	@Override
	public void execute(ICustomContext context) 
	{
		final Element bo = (Element)bor.getBusinessObjectForPictogramElement(context.getPictogramElements()[0]);
		final Resource res = bo.eResource();
		final IResource ires = OsateResourceUtil.convertToIResource(res);
		final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		
		// Try to fine the node using NodeModelUtils first. We do not use a ILocationInFileProvider because it will return the location of the parent if it can not find the
		// location of the actual node
		final INode n = NodeModelUtils.getNode(bo);
		final int offset, line;
		if(n == null) {	
			// If we were unable to find the location, it may be because the editor is not open. Try to load the business object into a new resource set and find the location.
			// See: http://www.eclipse.org/forums/index.php/m/1219754/#msg_1219754
			XtextResourceSet rs = new XtextResourceSet();
			final EObject bo2 = rs.getEObject(EcoreUtil.getURI(bo), true);
			if(bo2 == null) {
				throw new RuntimeException("Unable to find node in saved resource");
			}
			
			if(!(bo2.eResource() instanceof XtextResource)) {
				throw new RuntimeException("The resource of the loaded business object resource is not an XtextResource");
			}
			
			// Get the location provider
			final ILocationInFileProvider locationProvider = ((XtextResource)bo2.eResource()).getResourceServiceProvider().get(ILocationInFileProvider.class);
			final ITextRegion textRegion = locationProvider.getSignificantTextRegion(bo2);			
			if(!(textRegion instanceof ITextRegionWithLineInformation)) {
				throw new RuntimeException("Unable to get ITextRegionWithLineInformation");
			}
			
			final ITextRegionWithLineInformation textRegionWithLineInfo = (ITextRegionWithLineInformation)textRegion;			
			offset = textRegion.getOffset();
			line = textRegionWithLineInfo.getLineNumber() + 1;				
		} else {
			line = n.getStartLine();
			offset = n.getOffset();
		}

		try {	
			final IMarker marker = ires.createMarker(AadlConstants.AADLGOTOMARKER);
			marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
			final String dest = EcoreUtil.getURI(bo).toString();
			marker.setAttribute(IMarker.MESSAGE, "Going to "+ dest);
			marker.setAttribute(IMarker.LOCATION, offset);
			marker.setAttribute(IMarker.LINE_NUMBER, line);
			marker.setAttribute(EValidator.URI_ATTRIBUTE, dest);
			IDE.openEditor(page, marker);

			// Editor opened. Get rid of goto marker
			ires.deleteMarkers(AadlConstants.AADLGOTOMARKER, false, IResource.DEPTH_ZERO);
		} 
		catch(final CoreException e) {
			throw new RuntimeException(e);
		}	
	}
	


}