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
import org.osate.aadl2.Access;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.businessObjectHandlers.AadlFeatureUtil;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.DiagramModificationService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;

public class RefineFeatureFeature extends AbstractCustomFeature {
	private final AadlModificationService aadlModService;
	private final DiagramModificationService diagramModService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public RefineFeatureFeature(final AadlModificationService aadlModService, final BusinessObjectResolutionService bor, final DiagramModificationService diagramModService, final IFeatureProvider fp) {
		super(fp);
		this.aadlModService = aadlModService;
		this.diagramModService = diagramModService;
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
		
		// Check that the shape represents a feature and that the feature is not owned by the classifier represented by the shape's container
		final PictogramElement pe = pes[0];		
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		final Object containerBo = bor.getBusinessObjectForPictogramElement(((Shape)pe).getContainer());
		if(!(bo instanceof Feature && containerBo instanceof Classifier)) {
			return false;
		}
		
		final Feature feature = (Feature)bo;	
		return feature.getContainingClassifier() != containerBo && (containerBo instanceof FeatureGroupType || containerBo instanceof ComponentType);
	}
    
    @Override
    public boolean canExecute(final ICustomContext context) {
    	return true;
    }
        
	@Override
	public void execute(final ICustomContext context) {
		final Shape shape = (Shape)context.getPictogramElements()[0];
		final Feature feature = (Feature)bor.getBusinessObjectForPictogramElement(shape);
		final Classifier featureOwner = (Classifier)bor.getBusinessObjectForPictogramElement(shape.getContainer());
		
		// Set the classifier
		aadlModService.modify(feature, new AbstractModifier<Feature, Feature>() {
			private DiagramModificationService.Modification diagramMod;   
			
			@Override
			public Feature modify(final Resource resource, final Feature feature) {
				// Start the diagram modification
     			diagramMod = diagramModService.startModification();
     			
				// Refine the feature
				final NamedElement newFeatureEl = AadlFeatureUtil.createFeature(featureOwner, feature.eClass());
				if(newFeatureEl instanceof Feature) {
					final Feature newFeature = (Feature)newFeatureEl;
					newFeature.setRefined(feature);
					
					if(feature instanceof DirectedFeature) {
						final DirectedFeature refinedDirectedFeature= (DirectedFeature)feature;
						final DirectedFeature newDirectedFeature = (DirectedFeature)newFeature;						
						newDirectedFeature.setIn(refinedDirectedFeature.isIn());
						newDirectedFeature.setOut(refinedDirectedFeature.isOut());
					} else if(feature instanceof Access) {
						((Access)newFeature).setKind(((Access)feature).getKind());
					}
					
					diagramMod.markOpenRelatedDiagramsAsDirty(featureOwner);	
					
					return newFeature;
				}
				
				return null;			
			}			
			
			@Override
			public void beforeCommit(final Resource resource, final Feature feature, final Feature newFeature) {
				if(newFeature != null) {
					// Relink the shape
					getFeatureProvider().link(shape, new AadlElementWrapper(newFeature));
				}
								
				diagramMod.commit();
			}
		});
	}	
}
