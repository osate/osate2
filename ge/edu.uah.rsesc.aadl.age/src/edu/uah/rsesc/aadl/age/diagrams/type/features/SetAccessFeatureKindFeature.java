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

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.IPattern;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;

import edu.uah.rsesc.aadl.age.diagrams.pkg.patterns.PackageClassifierPattern;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;

public class SetAccessFeatureKindFeature extends AbstractCustomFeature
{
	private final BusinessObjectResolutionService bor;		
	@Inject
	public SetAccessFeatureKindFeature(final IFeatureProvider fp, final BusinessObjectResolutionService bor) 
	{
		super(fp);
		this.bor = bor;
	}
	
	@Override
    public String getName() {
        return "SetAccessKind";
    }
 
    @Override
    public String getDescription() {
        return "Place holder";
    }
	
    
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		PictogramElement[] pes = customCtx.getPictogramElements();
		
		if(customCtx.getPictogramElements().length < 1) {
			return false;
		}
		final PictogramElement pe = pes[0];	
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		
		//return bo instanceof FeatureGroupType || bo instanceof ComponentType;
		return false;
	}
	
    public boolean canExecute(ICustomContext context) 
    {   	
    	return true;
    }
    
	@Override
	public void execute(ICustomContext context) {
		// TODO Auto-generated method stub
		
		
	}
}
