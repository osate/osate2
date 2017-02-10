/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.features;

import javax.inject.Inject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;
import org.osate.ge.internal.util.SubcomponentUtil;

public class RefineSubcomponentFeature extends AbstractCustomFeature {
	private final AadlModificationService aadlModService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public RefineSubcomponentFeature(final AadlModificationService aadlModService, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		super(fp);
		this.aadlModService = aadlModService;
		this.bor = bor;
	}

	@Override
    public String getName() {
        return "Refine";
    }
	
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
	
    @Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		final PictogramElement[] pes = customCtx.getPictogramElements();		
		if(customCtx.getPictogramElements().length < 1 || !(customCtx.getPictogramElements()[0] instanceof Shape)) {
			return false;
		}
		
		// Check that the shape represents a subcomponent and that the subcomponent is not owned by the classifier represented by the shape's container
		final PictogramElement pe = pes[0];		
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		final Object containerBo = bor.getBusinessObjectForPictogramElement(((Shape)pe).getContainer());
		if(!(bo instanceof Subcomponent && containerBo instanceof ComponentImplementation)) {
			return false;
		}
		
		final Subcomponent sc = (Subcomponent)bo;
		final ComponentImplementation ci = (ComponentImplementation)containerBo;		
		return sc.getContainingClassifier() != ci && SubcomponentUtil.canContainSubcomponentType(ci, sc.eClass());
	}
    
    @Override
    public boolean canExecute(final ICustomContext context) {
    	return true;
    }
        
	@Override
	public void execute(final ICustomContext context) {
		final Shape shape = (Shape)context.getPictogramElements()[0];
		final Subcomponent sc = (Subcomponent)bor.getBusinessObjectForPictogramElement(shape);
		final ComponentImplementation containerComponentImplementation = (ComponentImplementation)bor.getBusinessObjectForPictogramElement(shape.getContainer());
		
		// Set the classifier
		aadlModService.modify(sc, new AbstractModifier<Subcomponent, Subcomponent>() {
			@Override
			public Subcomponent modify(final Resource resource, final Subcomponent sc) {
				// Refine the subcomponent
				final Subcomponent newSc = SubcomponentUtil.createSubcomponent(containerComponentImplementation, sc.eClass());
				newSc.setRefined(sc);
				
				return newSc;
			}			
			
			@Override
			public void beforeCommit(final Resource resource, final Subcomponent sc, final Subcomponent newSc) {
				// Relink the shape
				getFeatureProvider().link(shape, new AadlElementWrapper(newSc));
			}
		});
	}	
}
