/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.type.features;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.ge.services.AadlFeatureService;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.ShapeService;
import org.osate.ge.services.AadlModificationService.AbstractModifier;

public class SetFeatureGroupInverseFeature extends AbstractCustomFeature{
	private final AadlFeatureService featureService;
	private final BusinessObjectResolutionService bor;		
	private final AadlModificationService aadlModService;
	private final boolean inverse;
	
	@Inject
	public SetFeatureGroupInverseFeature(final AadlFeatureService featureService, final IFeatureProvider fp, final BusinessObjectResolutionService bor, final ShapeService shapeService,
			final AadlModificationService aadlModService,final @Named("Inverse") Boolean inverse) {
		super(fp);
		this.featureService = featureService;
		this.aadlModService = aadlModService;
		this.inverse = inverse;
		this.bor = bor;
	}
	
	@Override
    public String getName() {
		if (inverse) {
			return "Set to Inverse";
		}
		else {
			return "Set to Not Inverse";
		}
    }
 
    @Override
    public String getDescription() {
        return "Sets Feature Group Inverse Of State";
    }
	
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;		
		PictogramElement[] pes = customCtx.getPictogramElements();
		
		if(pes.length != 1 || !(pes[0] instanceof Shape)) {
			return false;
		}
		
		final Shape pe = (Shape)pes[0];	
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		
		if(!(bo instanceof FeatureGroup)) {
			return false;
		}
		
		final Object containerBo = bor.getBusinessObjectForPictogramElement(((Shape)pe).getContainer());
		final DirectedFeature feat = (DirectedFeature)bo;
		final Classifier classifier = feat.getContainingClassifier();
		return classifier == containerBo && (classifier instanceof FeatureGroupType || classifier instanceof ComponentType);
	}

    @Override
    public boolean canExecute(ICustomContext context) {   
    	final ICustomContext customCtx = (ICustomContext)context;
    	final Shape shape = (Shape)customCtx.getPictogramElements()[0];
    	final Object bo = bor.getBusinessObjectForPictogramElement(shape);
    	return featureService.getFeatureGroupType(shape, (FeatureGroup)bo) != null && ((FeatureGroup)bo).isInverse() != inverse;
    }
	
	@Override
	public void execute(ICustomContext context) {
		final PictogramElement pe = context.getPictogramElements()[0];		
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		
		final FeatureGroup fg = (FeatureGroup)bo;
		aadlModService.modify(fg, new AbstractModifier<FeatureGroup, Object>() {
			public Object modify(final Resource res, final FeatureGroup fg) {
				fg.setInverse(inverse);

				return null;
			}
		});
	}
}
