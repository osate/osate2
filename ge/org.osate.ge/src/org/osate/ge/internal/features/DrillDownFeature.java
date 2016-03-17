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

import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.GraphitiService;
import org.osate.ge.internal.services.SubcomponentService;

/**
 * Drill down feature. Does not inherit from AbstractDrillDownFeature because it will create diagrams if needed.
 *
 */
public class DrillDownFeature extends AbstractCustomFeature {
	private final SubcomponentService subcomponentService;
	private final DiagramService diagramService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public DrillDownFeature(final GraphitiService graphiti, final SubcomponentService subcomponentService, final DiagramService diagramService, final BusinessObjectResolutionService bor) {
		super(graphiti.getFeatureProvider());
		this.subcomponentService = subcomponentService;
		this.diagramService = diagramService;
		this.bor = bor;
	}

	@Override
    public String getName() {
        return "Open Associated Diagram";
    }
 
    @Override
    public String getDescription() {
        return "Open the diagram associated with this model element";
    }
 
    @Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		PictogramElement[] pes = customCtx.getPictogramElements();
		
		if(customCtx.getPictogramElements().length < 1) {
			return false;
		}
		final Object bo = bor.getBusinessObjectForPictogramElement(pes[0]);
		return bo != bor.getBusinessObjectForPictogramElement(getDiagram()) && 
				(bo instanceof ComponentType || bo instanceof ComponentImplementation || bo instanceof FeatureGroupType || bo instanceof Subcomponent);	
	}
    
    @Override
    public boolean canExecute(ICustomContext context) {   	
    	PictogramElement[] pes = context.getPictogramElements();    	
        if (pes != null && pes.length == 1 && !(pes[0] instanceof Diagram)) { 
            Object bo = AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(pes[0]));
            if(bo instanceof Package || bo instanceof Classifier) {
                return true;
            }
            
            if(getSubcomponentClassifier(pes[0], bo) != null) {
            	return true;
            }
        }
        return false;
    }

    @Override
	public void execute(final ICustomContext context) {
		if(context.getPictogramElements().length > 0) {
			final Object bo = AadlElementWrapper.unwrap(this.getBusinessObjectForPictogramElement(context.getPictogramElements()[0]));
			if(bo instanceof NamedElement) {
				final NamedElement element;
				if(bo instanceof Subcomponent) {
					element = getSubcomponentClassifier(context.getPictogramElements()[0], bo);
				} else {
					element = (NamedElement)bo;
				}
				diagramService.openOrCreateDiagramForRootBusinessObject(element);
			}
		}
	}
    
    /**
     * Returns the appropriate classifier if the business object is for a subcomponent
     * @param pe
     * @param bo
     * @return
     */
    private Classifier getSubcomponentClassifier(final PictogramElement pe, final Object bo) {
    	if(pe instanceof Shape && bo instanceof Subcomponent) {
        	return subcomponentService.getComponentClassifier((Shape)pe, (Subcomponent)bo);
        }
    	return null;
    }
}