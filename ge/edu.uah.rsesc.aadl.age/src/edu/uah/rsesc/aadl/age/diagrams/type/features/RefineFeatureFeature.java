/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.diagrams.type.features;

import javax.inject.Inject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Feature;

import edu.uah.rsesc.aadl.age.services.AadlModificationService.AbstractModifier;
import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.FeaturePattern;
import edu.uah.rsesc.aadl.age.services.AadlModificationService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;

public class RefineFeatureFeature extends AbstractCustomFeature {
	private final AadlModificationService aadlModService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public RefineFeatureFeature(final AadlModificationService aadlModService, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
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
		
		// Check that the shape represents a feature and that the feature is not owned by the classifier represented by the shape's container
		final PictogramElement pe = pes[0];		
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		final Object containerBo = bor.getBusinessObjectForPictogramElement(((Shape)pe).getContainer());
		if(!(bo instanceof Feature && containerBo instanceof Classifier)) {
			return false;
		}
		
		final Feature feature = (Feature)bo;	
		return feature.getContainingClassifier() != containerBo;
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
			@Override
			public Feature modify(final Resource resource, final Feature feature) {
				// Refine the feature
				final Feature newFeature = FeaturePattern.createFeature(featureOwner, feature.eClass());
				newFeature.setRefined(feature);
				
				return newFeature;
			}			
			
			@Override
			public void beforeCommit(final Resource resource, final Feature feature, final Feature newFeature) {
				// Relink the shape
				getFeatureProvider().link(shape, new AadlElementWrapper(newFeature));
			}
		});
	}	
}
