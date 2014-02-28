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
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.DiagramModificationService;
import org.osate.ge.services.AadlModificationService.AbstractModifier;

/**
 * Feature for setting whether the component classifier's modes are derived
 * @author philip.alldredge
 *
 */
public class SetDerivedModesFeature extends AbstractCustomFeature {
	private final AadlModificationService aadlModService;
	private final DiagramModificationService diagramModService;
	private final BusinessObjectResolutionService bor;
	private final boolean derivedModes;
	
	@Inject
	public SetDerivedModesFeature(final AadlModificationService aadlModService, final DiagramModificationService diagramModService, final BusinessObjectResolutionService bor, final IFeatureProvider fp, final @Named("Derived Modes") Boolean derivedModes) {
		super(fp);
		this.aadlModService = aadlModService;
		this.diagramModService = diagramModService;
		this.bor = bor;
		this.derivedModes = derivedModes;
	}
	
	@Override
    public String getName() {
        return derivedModes ? "Change to Derived Modes" : "Change to Non-derived Modes";
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
		if(!(bo instanceof ComponentClassifier)) {
			return false;
		}
		
		// Only allow setting the value if the new value would be different, the classifier contains nodes, and the classifier has not inherited any modes or mode transitions
		final ComponentClassifier cc = (ComponentClassifier)bo;
		return cc.isDerivedModes() != derivedModes && (cc.getOwnedModes().size() > 0 || cc.getOwnedModeTransitions().size() > 0) && cc.getAllModes().size() == cc.getOwnedModes().size() && cc.getAllModeTransitions().size() == cc.getOwnedModeTransitions().size() ;
	}
	
    @Override
    public boolean canExecute(final ICustomContext context) {
    	// Only allow changing whether the modes are derived if it is being set to false or if there are no mode transitions. Mode transitions are not allowed
    	// in requires mode clauses
    	final PictogramElement pe = (PictogramElement)context.getPictogramElements()[0];
		final ComponentClassifier cc = (ComponentClassifier)bor.getBusinessObjectForPictogramElement(pe);
    	return !derivedModes || cc.getOwnedModeTransitions().size() == 0;
    }
        
	@Override
	public void execute(final ICustomContext context) {
		final PictogramElement pe = (PictogramElement)context.getPictogramElements()[0];
		final ComponentClassifier cc = (ComponentClassifier)bor.getBusinessObjectForPictogramElement(pe);
		
		aadlModService.modify(cc, new AbstractModifier<ComponentClassifier, Object>() {
			private DiagramModificationService.Modification diagramMod;    	
			
			@Override
			public Object modify(final Resource resource, final ComponentClassifier cc) {
				// Start the diagram modification
     			diagramMod = diagramModService.startModification();
     			
				cc.setDerivedModes(derivedModes);
				diagramMod.markRelatedDiagramsAsDirty(cc);

				return null;
			}
			
	 		@Override
			public void beforeCommit(final Resource resource, final ComponentClassifier cc, final Object modificationResult) {
				diagramMod.commit();
			}
		});
	}
}
