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
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Access;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;

import edu.uah.rsesc.aadl.age.services.AadlModificationService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.ShapeService;
import edu.uah.rsesc.aadl.age.services.AadlModificationService.AbstractModifier;

public class SetAccessFeatureKindFeature extends AbstractCustomFeature{
	private final BusinessObjectResolutionService bor;
	private final AadlModificationService aadlModService;
	private final AccessType accType;
	
	@Inject
	public SetAccessFeatureKindFeature(final IFeatureProvider fp, final BusinessObjectResolutionService bor, final ShapeService shapeService,
			final AadlModificationService aadlModService,final @Named("Access") AccessType accType){
		super(fp);
		this.aadlModService = aadlModService;
		this.accType = accType;
		this.bor = bor;
	}
	
	@Override
    public String getName() {
		if(accType == AccessType.PROVIDES) {
			 return "Set Kind to Provides";
		}
		else {
			 return "Set Kind to Requires";
		}
    }
 
    @Override
    public String getDescription() {
        return "Sets the Access Kind of the Feature";
    }
	 
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;		
		PictogramElement[] pes = customCtx.getPictogramElements();
		
		if(customCtx.getPictogramElements().length != 1 || !(customCtx.getPictogramElements()[0] instanceof Shape)) {
			return false;
		}
		
		final PictogramElement pe = pes[0];	
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		
		if(!(bo instanceof Access)) {
			return false;
		}
		
		final Object containerBo = bor.getBusinessObjectForPictogramElement(((Shape)pe).getContainer());
		final Access feat = (Access)bo;
		final Classifier classifier = feat.getContainingClassifier();	
		return classifier == containerBo && (classifier instanceof FeatureGroupType || classifier instanceof ComponentType);
	}
	
    public boolean canExecute(ICustomContext context){   	
		final PictogramElement pe = context.getPictogramElements()[0];		
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		
		final Access af = (Access)bo;
		if (accType == af.getKind()){
				return false;
			}
    	return true;
    }
    
	@Override
	public void execute(ICustomContext context) {
		final PictogramElement pe = context.getPictogramElements()[0];		
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		
		if(bo instanceof Access) {
			final Access af1 = (Access)bo;
			aadlModService.modify(af1, new AbstractModifier<org.osate.aadl2.Access, Object>() {
				public Object modify(final Resource res, final Access af) {
					af.setKind(accType);
					
					return null;
				}
			});	
		}
	}
}
