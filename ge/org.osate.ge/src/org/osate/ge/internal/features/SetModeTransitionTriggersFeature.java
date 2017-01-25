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
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.DiagramModificationService;
import org.osate.ge.internal.services.ShapeService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;
import org.osate.ge.internal.ui.dialogs.ModeTransitionTriggerSelectionDialog;
import org.osate.ge.internal.ui.dialogs.ModeTransitionTriggerSelectionDialog.ModeTransitionTriggerInfo;

/**
 * Feature for setting the triggers for a mode transition
 *
 */
public class SetModeTransitionTriggersFeature extends AbstractCustomFeature {
	private final AadlModificationService aadlModService;
	private final DiagramModificationService diagramModService;
	private final ShapeService shapeService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public SetModeTransitionTriggersFeature(final AadlModificationService aadlModService, final DiagramModificationService diagramModService, final ShapeService shapeService, 
			final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		super(fp);
		this.aadlModService = aadlModService;
		this.diagramModService = diagramModService;
		this.shapeService = shapeService;
		this.bor = bor;
	}
	
	@Override
    public String getName() {
        return "Set Mode Transition Triggers...";
    }
	
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
	
    @Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		final PictogramElement[] pes = customCtx.getPictogramElements();		
		if(customCtx.getPictogramElements().length != 1) {
			return false;
		}
		
		final PictogramElement pe = pes[0];
		if(!(pe instanceof Connection)) {
			return false;
		}
		
		// Check that the pictogram represents a mode transition
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);		
		if(!(bo instanceof ModeTransition)) {
			return false;
		}
		
		// Check that the container is the same shape that owns the mode transition
		final ModeTransition mt = (ModeTransition)bo;
		final ComponentClassifier cc = getComponentClassifier((Connection)pe);
		return mt.getContainingClassifier() == cc;
	}
    
	private ComponentClassifier getComponentClassifier(final Connection connection) {
		final AnchorContainer startContainer = connection.getStart().getParent();
		if(!(startContainer instanceof Shape)) {
			return null;
		}
		
		return shapeService.getClosestBusinessObjectOfType((Shape)startContainer, ComponentClassifier.class);
	}
    
    @Override
    public boolean canExecute(final ICustomContext context) {
    	return true;
    }
        
	@Override
	public void execute(final ICustomContext context) {
		final PictogramElement pe = (PictogramElement)context.getPictogramElements()[0];
		final ComponentClassifier cc = getComponentClassifier((Connection)pe);
		if(cc == null) {
			return;
		}
		
		final ModeTransition mt = (ModeTransition)bor.getBusinessObjectForPictogramElement(pe);
		final ModeTransitionTriggerInfo[] selectedTriggers = ModeTransitionTriggerSelectionDialog.promptForTriggers(cc, mt);
		if(selectedTriggers != null) {
			// Make the modification to the mode	
			aadlModService.modify(mt, new AbstractModifier<ModeTransition, Object>() {
				private DiagramModificationService.Modification diagramMod;
				
				@Override
				public Object modify(final Resource resource, final ModeTransition mt) {
					// Start the diagram modification
		 			diagramMod = diagramModService.startModification();	 			
		 			
		 			// Mark other diagrams for updating
		 			diagramMod.markOpenRelatedDiagramsAsDirty(mt.getContainingClassifier());

		 			// Remove all trigger port triggers from the mode transition
					mt.getOwnedTriggers().clear();
					
					// Add the selected ones to it				
		 			for(ModeTransitionTriggerInfo selectedPort : selectedTriggers) {
		 				final ModeTransitionTrigger mtt = mt.createOwnedTrigger();
		 				mtt.setTriggerPort(selectedPort.port);
		 				mtt.setContext(selectedPort.context);
		 			}

					return null;
				}
				
		 		@Override
				public void beforeCommit(final Resource resource, final ModeTransition mt, final Object modificationResult) {
					diagramMod.commit();
				}
			});
		}
	}
}
