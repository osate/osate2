/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.palette.IToolEntry;
import org.eclipse.graphiti.palette.impl.ConnectionCreationToolEntry;
import org.eclipse.graphiti.palette.impl.ObjectCreationToolEntry;
import org.eclipse.graphiti.palette.impl.PaletteCompartmentEntry;
import org.eclipse.graphiti.pattern.CreateConnectionFeatureForPattern;
import org.eclipse.graphiti.pattern.CreateFeatureForPattern;
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
	private final IEclipseContext context;
	
	@Inject
	public AgeToolBehaviorProvider(final IDiagramTypeProvider diagramTypeProvider, final PropertyService propertyService, final IEclipseContext context) {
		super(diagramTypeProvider);
		this.propertyService = propertyService;
		this.context = context;
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
		return context;
	}	
	
	/**
	 * This is how we provide objects in the context to the editor.
	 */
	@Override
	public Object getAdapter(Class<?> type) {
		final Object result = context.get(type);
		if(result != null) {
			return result;
		}
		
		return super.getAdapter(type);
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
			while(shape != null && (getFeatureProvider().getBusinessObjectForPictogramElement(shape) == null || propertyService.isInnerShape(shape) || propertyService.isUnselectable(shape))) {
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
	
	@Override
	public IPaletteCompartmentEntry[] getPalette() {				
		final class PaletteCompartments {
			private final List<IPaletteCompartmentEntry> compartments = new ArrayList<IPaletteCompartmentEntry>();
			private final PaletteCompartmentEntry classifiersCompartmentEntry = createComparmentEntry("Classifiers");
			private final PaletteCompartmentEntry connectionsCompartmentEntry = createComparmentEntry("Connections");
			private final PaletteCompartmentEntry featuresCompartmentEntry = createComparmentEntry("Features");
			private final PaletteCompartmentEntry flowsCompartmentEntry = createComparmentEntry("Flows");
			private final PaletteCompartmentEntry modesCompartmentEntry = createComparmentEntry( "Modes");
			private final PaletteCompartmentEntry relationshipsCompartmentEntry = createComparmentEntry("Relationships");
			private final PaletteCompartmentEntry subcomponentCompartmentEntry = createComparmentEntry("Subcomponents");
			private final PaletteCompartmentEntry subprogramCallsCompartmentEntry = createComparmentEntry("Subprogram Calls");
			private final PaletteCompartmentEntry miscCompartmentEntry = createComparmentEntry("Misc");
			
			private PaletteCompartmentEntry createComparmentEntry(final String label) {
				final PaletteCompartmentEntry newEntry = new PaletteCompartmentEntry(label, null);
				compartments.add(newEntry);
				return newEntry;
			}
			
			public void addToolEntry(final IToolEntry toolEntry, final Object featureOrPattern) {
				final PaletteCompartmentEntry compartmentEntry;
				if(featureOrPattern instanceof Categorized) {
					final Categorized.Category compartment = ((Categorized) featureOrPattern).getCategory();
					switch(compartment) {
					case CLASSIFIERS:
						compartmentEntry = classifiersCompartmentEntry;
						break;
						
					case CONNECTIONS:
						compartmentEntry = connectionsCompartmentEntry;
						break;
						
					case FEATURES:
						compartmentEntry = featuresCompartmentEntry;
						break;
						
					case FLOWS:
						compartmentEntry = flowsCompartmentEntry;
						break;
						
					case MODES:
						compartmentEntry = modesCompartmentEntry;
						break;
						
					case RELATIONSHIPS:
						compartmentEntry = relationshipsCompartmentEntry;
						break;
						
					case SUBCOMPONENTS:
						compartmentEntry = subcomponentCompartmentEntry;
						break;	
						
					case SUBPROGRAM_CALLS:
						compartmentEntry = subprogramCallsCompartmentEntry;
						break;
						
					default:
						compartmentEntry = miscCompartmentEntry;
					}
				} else {
					compartmentEntry = miscCompartmentEntry;
				}
				
				compartmentEntry.addToolEntry(toolEntry);
			}
			
			public void removeEmpty() {
				// Remove empty compartments		
				final Iterator<IPaletteCompartmentEntry> it = compartments.iterator(); 
				while(it.hasNext()) {
					final IPaletteCompartmentEntry entry = it.next();
					if(entry.getToolEntries().isEmpty()) {
						it.remove();
					}
				}
			}
			
			public IPaletteCompartmentEntry[] toArray() {
				return compartments.toArray(new IPaletteCompartmentEntry[compartments.size()]);
			}
		};
		
		final PaletteCompartments compartments = new PaletteCompartments();	
		final IFeatureProvider featureProvider = getFeatureProvider();		
		final ICreateConnectionFeature[] createConnectionFeatures = featureProvider.getCreateConnectionFeatures();
		if (createConnectionFeatures.length > 0) {
			for (ICreateConnectionFeature createConnectionFeature : createConnectionFeatures) {	
				final ConnectionCreationToolEntry ccTool = new ConnectionCreationToolEntry(
						createConnectionFeature.getCreateName(), createConnectionFeature.getCreateDescription(),
						createConnectionFeature.getCreateImageId(), createConnectionFeature.getCreateLargeImageId());
				ccTool.addCreateConnectionFeature(createConnectionFeature);

				// Use the pattern if the feature was created from one.
				final Object featureOrPattern = (createConnectionFeature instanceof CreateConnectionFeatureForPattern) ? ((CreateConnectionFeatureForPattern)createConnectionFeature).getPattern() : createConnectionFeature;
				compartments.addToolEntry(ccTool, featureOrPattern);
			}
		}
		
		final ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
		if (createFeatures.length > 0){
			for (ICreateFeature createFeature : createFeatures) {
				final ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry(
						createFeature.getCreateName(), createFeature.getCreateDescription(),
						createFeature.getCreateImageId(), createFeature.getCreateLargeImageId(), createFeature);
				
				// Use the pattern if the feature was created from one.
				final Object featureOrPattern = (createFeature instanceof CreateFeatureForPattern) ? ((CreateFeatureForPattern)createFeature).getPattern() : createFeature;
				compartments.addToolEntry(objectCreationToolEntry, featureOrPattern);
			}
		}
		
		compartments.removeEmpty();

		return compartments.toArray();
	}
	
	/**
	 * Overrides the mechanism to get the graphics algorithm used to determine the chop box location so that if the graphics algorithm that would normally be used for the chopbox is 
	 * invisible and has a single visible child, then it uses the child instead. 
	 * @param pe
	 * @return
	 */
	@Override
	public GraphicsAlgorithm getChopboxAnchorArea(final PictogramElement pe) {
		final GraphicsAlgorithm ga = super.getChopboxAnchorArea(pe);
		if(!ga.getFilled() && !ga.getLineVisible() && ga.getGraphicsAlgorithmChildren().size() == 1) {
			final GraphicsAlgorithm childGa = ga.getGraphicsAlgorithmChildren().get(0);
			if(childGa.getLineVisible() || childGa.getFilled()) {
				return childGa;
			}
		}
		
		return ga;
	}
}
