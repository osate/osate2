/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.common;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.EventDataSource;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.PortProxy;
import org.osate.aadl2.ProcessorFeature;
import org.osate.aadl2.SubprogramProxy;
import org.osate.ge.diagrams.common.features.DrillDownFeature;
import org.osate.ge.services.PropertyService;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.osate.ge.diagrams.common.features.GraphicalToTextualFeature;


public class AgeToolBehaviorProvider extends DefaultToolBehaviorProvider {
	private final PropertyService propertyService;
	public AgeToolBehaviorProvider(final IDiagramTypeProvider diagramTypeProvider, final PropertyService propertyService) {
		super(diagramTypeProvider);
		this.propertyService = propertyService;
	}

	@Override
	public String getContributorId() {
		return "org.osate.ge.editor.AgeDiagramEditor";
	}
	
	//Remove context buttons from pictogram elements
	@Override
	public IContextButtonPadData getContextButtonPad(IPictogramElementContext context) {
	return null;
	}
	
	// Override the business object equality check. This is needed in the case of Generalization because the owner is one of the defining
	// characteristics and is not checked by the default check which uses EcoreUtil.equals().
	@Override
	public boolean equalsBusinessObjects(final Object o1, final Object o2) {            	
		if(o1 instanceof Generalization) {
			return o1.equals(o2);
		} 
		return super.equalsBusinessObjects(o1, o2);
	}
	
	private IEclipseContext getContext() {
		return ((AgeFeatureProvider)this.getDiagramTypeProvider().getFeatureProvider()).getContext();
	}
	
	
	@Override
	public ICustomFeature getDoubleClickFeature(final IDoubleClickContext context) {
	    final ICustomFeature customFeature = ContextInjectionFactory.make(DrillDownFeature.class, getContext());
	    if(customFeature.canExecute(context)) {
	        return customFeature;
	    }
	    return super.getDoubleClickFeature(context);
	 }
	
	/**
	 * Override of getSelection that checks the shape and containers and returns the first shape with a business object. Allows using active objects without them being
	 * selectable.
	 */
	@Override
	public PictogramElement getSelection(PictogramElement originalPe, PictogramElement[] oldSelection) {
		if(originalPe instanceof ConnectionDecorator) {
			if(propertyService.isUnselectable(originalPe)) {
				return getDiagramTypeProvider().getDiagram();
			}
		} else if(originalPe instanceof Shape) {					
			// Return the first shape that has a business object
			Shape shape = (Shape)originalPe;
			while(shape != null && (getFeatureProvider().getBusinessObjectForPictogramElement(shape) == null || propertyService.isInnerShape(shape) || propertyService.isUnselectable(originalPe))) {
				shape = shape.getContainer();
			}
			return shape;
		}
		return null;
	}
	
	//Execute when keyboard command is pressed.  Registered in plugin.xml
	@Override
	public ICustomFeature getCommandFeature(final CustomContext context, String hint){
		//Use hint to verify command should be executed
		if(GraphicalToTextualFeature.HINT.equals(hint)){
			final ICustomFeature customFeature = ContextInjectionFactory.make(GraphicalToTextualFeature.class, getContext());
				if(customFeature.canExecute(context)){	
					return customFeature;
				}
		}
		return super.getCommandFeature(context, hint);
	}
	
	@Override
	public String getTitleToolTip() {		
		final String diagramTitle = getDiagramTypeProvider() == null ? null : getDiagramTypeProvider().getDiagramTitle();
		return diagramTitle == null ? super.getTitleToolTip() : diagramTitle;
	}
	
	@Override
	public Object getToolTip(final GraphicsAlgorithm ga) {
	    PictogramElement pe = ga.getPictogramElement();
	    final Object bo = AadlElementWrapper.unwrap(getFeatureProvider().getBusinessObjectForPictogramElement(pe));

	    // Use the classifier name as the tooltip for features
	    if(bo instanceof Feature || bo instanceof InternalFeature || bo instanceof ProcessorFeature) {
	    	final Classifier featureClassifier;
	    	if(bo instanceof EventDataSource) {
		    	final EventDataSource aadlFeature = (EventDataSource)bo;
		    	featureClassifier = aadlFeature.getDataClassifier();
		    } else if(bo instanceof PortProxy) {
		    	final PortProxy aadlFeature = (PortProxy)bo;
		    	featureClassifier = aadlFeature.getDataClassifier();
		    } else if(bo instanceof SubprogramProxy) {
		    	final SubprogramProxy aadlFeature = (SubprogramProxy)bo;
		    	featureClassifier = aadlFeature.getSubprogramClassifier();
		    } else if(bo instanceof Feature) {
		    	final Feature aadlFeature = (Feature)bo;
		    	featureClassifier = aadlFeature.getAllClassifier();		    	
		    } else {
		    	featureClassifier = null;
		    }
	    	
	    	if(featureClassifier instanceof ComponentClassifier) {
	    		return ((ComponentClassifier) featureClassifier).getCategory() + " " + featureClassifier.getQualifiedName();
	    	} else if(featureClassifier instanceof FeatureGroupType) {
	    		return  "feature group " + featureClassifier.getQualifiedName();
	    	} else if(featureClassifier == null) {
	    		return "No Classifier";
	    	} else {
	    		return featureClassifier.getQualifiedName();	
	    	}	    	
	    }
	    
	    return super.getToolTip(ga);
	}
	
}
