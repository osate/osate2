/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.common.features;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Mode;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.DiagramModificationService;
import org.osate.ge.services.ShapeService;
import org.osate.ge.services.AadlModificationService.AbstractModifier;

/**
 * Feature for setting whether a mode is an initial mode
 * @author philip.alldredge
 *
 */
public class SetInitialModeFeature extends AbstractCustomFeature {
	private final AadlModificationService aadlModService;
	private final DiagramModificationService diagramModService;
	private final ShapeService shapeService;
	private final BusinessObjectResolutionService bor;
	private final boolean isInitial;
	
	@Inject
	public SetInitialModeFeature(final AadlModificationService aadlModService, final DiagramModificationService diagramModService, final ShapeService shapeService, final BusinessObjectResolutionService bor, final IFeatureProvider fp, final @Named("Is Initial") Boolean isInitial) {
		super(fp);
		this.aadlModService = aadlModService;
		this.diagramModService = diagramModService;
		this.shapeService = shapeService;
		this.bor = bor;
		this.isInitial = isInitial;
	}
	
	@Override
    public String getName() {
        return isInitial ? "Change to Initial Mode" : "Change to Non-initial Mode";
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
		if(!(pe instanceof Shape)) {
			return false;
		}
		
		// Check that the pictogram represents a mode	
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		if(!(bo instanceof Mode)) {
			return false;
		}
		
		final Mode mode = (Mode)bo;
		return mode.getContainingClassifier() == getComponentClassifier((Shape)pe) && mode.isInitial() != isInitial;
	}
    
	private ComponentClassifier getComponentClassifier(final Shape modeShape) {
		return shapeService.getClosestBusinessObjectOfType(modeShape, ComponentClassifier.class);
	}
	
    @Override
    public boolean canExecute(final ICustomContext context) {
    	return true;
    }
        
	@Override
	public void execute(final ICustomContext context) {
		final PictogramElement pe = (PictogramElement)context.getPictogramElements()[0];
		final Mode mode = (Mode)bor.getBusinessObjectForPictogramElement(pe);
		
		aadlModService.modify(mode, new AbstractModifier<Mode, Object>() {
			private DiagramModificationService.Modification diagramMod;    	
			
			@Override
			public Object modify(final Resource resource, final Mode mode) {
				// Start the diagram modification
     			diagramMod = diagramModService.startModification();
     			
				// Reset the current initial mode. Only look in the current classifier and not in classifiers that have been extended
				if(isInitial) {
					final ComponentClassifier cc = (ComponentClassifier)mode.getContainingClassifier();
					for(final Mode m : cc.getOwnedModes()) {
						if(m.isInitial()) {
							m.setInitial(false);
						}
					}
				}
				
				mode.setInitial(isInitial);			
				diagramMod.markOpenRelatedDiagramsAsDirty(mode.getContainingClassifier());

				return null;
			}
			
	 		@Override
			public void beforeCommit(final Resource resource, final Mode mode, final Object modificationResult) {
				diagramMod.commit();
			}
		});
	}
}
