/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.diagrams.componentImplementation.features;

import javax.inject.Inject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.Flow;
import org.osate.aadl2.FlowImplementation;

import edu.uah.rsesc.aadl.age.services.AadlModificationService.AbstractModifier;
import edu.uah.rsesc.aadl.age.dialogs.EditFlowsDialog;
import edu.uah.rsesc.aadl.age.services.AadlModificationService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.NamingService;
import edu.uah.rsesc.aadl.age.services.PrototypeService;

public class EditFlowsFeature extends AbstractCustomFeature {
	private final PrototypeService prototypeService;
	private final NamingService namingService;
	private final AadlModificationService aadlModService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public EditFlowsFeature(final PrototypeService prototypeService, final NamingService namingService, final AadlModificationService aadlModService, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		super(fp);
		this.prototypeService = prototypeService;
		this.namingService = namingService;
		this.aadlModService = aadlModService;
		this.bor = bor;
	}

	@Override
    public String getName() {
        return "Edit Flows...";
    }
	
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
	
    @Override
	public boolean isAvailable(final IContext context) {
    	/*
		final ICustomContext customCtx = (ICustomContext)context;
		final PictogramElement[] pes = customCtx.getPictogramElements();		
		if(customCtx.getPictogramElements().length < 1) {
			return false;
		}
		
		// Check that the shape represents a component implementation
		final PictogramElement pe = pes[0];		
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		return bo instanceof ComponentImplementation;
		*/
    	// Disabled until issue with serialization of flow sink implementations is resolved
    	return false;
	}
    
    @Override
    public boolean canExecute(final ICustomContext context) {
    	return true;
    }
        
	@Override
	public void execute(final ICustomContext context) {
		final PictogramElement pe = context.getPictogramElements()[0];
		final ComponentImplementation ci = (ComponentImplementation)bor.getBusinessObjectForPictogramElement(pe);
		
		// Show the edit flows dialog
		final EditFlowsDialog dlg = new EditFlowsDialog(Display.getCurrent().getActiveShell(), prototypeService, namingService, ci);
		if(dlg.open() == Dialog.CANCEL) {
			return;
		}
		
		// Update the flows
		aadlModService.modify(ci, new AbstractModifier<ComponentImplementation, Object>() {
			@Override
			public Object modify(final Resource resource, final ComponentImplementation ci) {
				// Clear existing flows
				ci.getOwnedEndToEndFlows().clear();
				ci.getOwnedFlowImplementations().clear();
				
				for(final Flow flow : dlg.getFlows()) {
					if(flow instanceof EndToEndFlow) {
						ci.getOwnedEndToEndFlows().add((EndToEndFlow)flow);
					} else if(flow instanceof FlowImplementation) {
						ci.getOwnedFlowImplementations().add((FlowImplementation)flow);
					}
				}

				return null;
			}
		});
	}	
}
