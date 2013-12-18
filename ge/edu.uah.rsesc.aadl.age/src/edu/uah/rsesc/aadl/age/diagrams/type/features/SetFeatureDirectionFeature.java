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
import javax.inject.Named;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.FeatureGroupType;

import edu.uah.rsesc.aadl.age.services.AadlModificationService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.ShapeService;
import edu.uah.rsesc.aadl.age.services.AadlModificationService.AbstractModifier;

public class SetFeatureDirectionFeature extends AbstractCustomFeature{
	private final BusinessObjectResolutionService bor;		
	private final AadlModificationService aadlModService;
	private final DirectionType featDir;
	
	@Inject
	public SetFeatureDirectionFeature(final IFeatureProvider fp, final BusinessObjectResolutionService bor, final ShapeService shapeService,
			final AadlModificationService aadlModService,final @Named("Direction") DirectionType featDir){
		super(fp);
		this.aadlModService = aadlModService;
		this.featDir = featDir;
		this.bor = bor;
	}
	
	@Override
    public String getName() {
		if (featDir == DirectionType.IN) {
			return "Set Direction to In";
		}
		else if (featDir == DirectionType.OUT) {
			return "Set Direction to Out";
		}
		else {
			return "Set Direction to In and Out";
		}
    }
 
    @Override
    public String getDescription() {
        return "Sets Feature Direction";
    }
	
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;		
		PictogramElement[] pes = customCtx.getPictogramElements();
		
		if(customCtx.getPictogramElements().length < 1) {
			return false;
		}
		
		final PictogramElement pe = pes[0];	
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		
		if (bo instanceof DirectedFeature) {
			final DirectedFeature feat = (DirectedFeature)bo;
			final Classifier classifier = feat.getContainingClassifier();	
			return classifier instanceof FeatureGroupType || classifier instanceof ComponentType;
		}
		else{
			return false;
		}
	}

    @Override
    public boolean canExecute(ICustomContext context) {   	
		final PictogramElement pe = context.getPictogramElements()[0];
		
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		
			final DirectedFeature df = (DirectedFeature)bo;
			if (featDir == df.getDirection()) {
				return false;
			}
    	return true;
    }
	
	@Override
	public void execute(ICustomContext context) {
		final PictogramElement pe = context.getPictogramElements()[0];
		
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		
		if(bo instanceof DirectedFeature) {
			final DirectedFeature df1 = (DirectedFeature)bo;
			aadlModService.modify(df1, new AbstractModifier<org.osate.aadl2.DirectedFeature, Object>() {
				public Object modify(final Resource res, final DirectedFeature df) {
					df.setDirection(featDir);

					return null;
				}
			});
		}
	}
}
