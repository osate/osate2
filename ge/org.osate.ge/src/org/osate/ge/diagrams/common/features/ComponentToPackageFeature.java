/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.common.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.DiagramService;

import javax.inject.Inject;

public class ComponentToPackageFeature extends AbstractCustomFeature {
	private final DiagramService diagramService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public ComponentToPackageFeature(final IFeatureProvider fp, final DiagramService diagramService,final BusinessObjectResolutionService bor)  {
		super(fp);
		this.diagramService = diagramService;
		this.bor = bor;
	}

	@Override
    public String getName() {
        return "Go to Package diagram";
    }
 
    @Override
    public String getDescription() {
        return "Open the package diagram associated with this component classifier's package";
    }
 
    @Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		PictogramElement[] pes = customCtx.getPictogramElements();		
		if(customCtx.getPictogramElements().length != 1) {
			return false;
		}
		final PictogramElement pe = pes[0];	
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		return (!(bo instanceof AadlPackage)) && bo instanceof NamedElement && ((NamedElement)bo).getElementRoot() instanceof AadlPackage;
	}
    

    @Override
    public boolean canExecute(final ICustomContext context) {   	
		return true;
    }
    
	@Override
	public void execute(final ICustomContext context) {		
		final ICustomContext customCtx = (ICustomContext)context;
		final PictogramElement[] pes = customCtx.getPictogramElements();		
		final PictogramElement pe = pes[0];	
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);		
		NamedElement component = (NamedElement)bo;
		
		diagramService.openOrCreateDiagramForRootBusinessObject(component.getElementRoot());
	}

}
