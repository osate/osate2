// Based on OSATE Graphical Editor. Modifications are: 
/*
Copyright (c) 2016, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
*/
/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
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
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.osate.aadl2.Generalization;
import org.osate.ge.internal.commands.GraphicalToTextualCommand;
import org.osate.ge.internal.graphiti.features.BoHandlerDoubleClickFeature;
import org.osate.ge.internal.graphiti.features.CommandCustomFeature;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ExtensionRegistryService.Category;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.GraphitiService;
import org.osate.ge.internal.services.PropertyService;

public class AgeToolBehaviorProvider extends DefaultToolBehaviorProvider {
	private final static String GRAPHICAL_TO_TEXTUAL_FEATURE_HINT = "graphicalToTextualFeature";
	
	private final PropertyService propertyService;
	private final IEclipseContext context;
	private final ExtensionService extensionService;
	private final BoHandlerDoubleClickFeature defaultDoubleClickFeature;
	
	@Inject
	public AgeToolBehaviorProvider(final GraphitiService graphiti, final BusinessObjectResolutionService bor, final PropertyService propertyService, final ExtensionService extensionService, final IEclipseContext context) {
		super(graphiti.getDiagramTypeProvider());
		this.propertyService = propertyService;
		this.extensionService = extensionService;
		this.context = context;
		this.defaultDoubleClickFeature = new BoHandlerDoubleClickFeature(extensionService, bor, getFeatureProvider());
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
	
	/**
	 * This is how we provide objects in the context to the editor.
	 */
	@Override
	public Object getAdapter(Class<?> type) {
		if(type == IEclipseContext.class) {
			return context;
		}
		
		final Object result = context.get(type);
		if(result != null) {
			return result;
		}
		
		return super.getAdapter(type);
	}	

	@Override
	public ICustomFeature getDoubleClickFeature(final IDoubleClickContext context) {
	    return defaultDoubleClickFeature;
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
		if(GRAPHICAL_TO_TEXTUAL_FEATURE_HINT.equals(hint)){		
			for(final ICustomFeature customFeature : getFeatureProvider().getCustomFeatures(context)) {
				if(customFeature instanceof CommandCustomFeature) {
					if(((CommandCustomFeature) customFeature).getCommand() instanceof GraphicalToTextualCommand) {
						if(customFeature.canExecute(context)){	
							return customFeature;
						}
						break;
					}
				}
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
	public IPaletteCompartmentEntry[] getPalette() {	
		final class PaletteCompartments {
			private final ArrayList<PaletteCompartmentEntry> compartments = createCompartmentEntries();
			private ArrayList<PaletteCompartmentEntry> createCompartmentEntries() {
				final ArrayList<PaletteCompartmentEntry> compartmentEntries= new ArrayList<PaletteCompartmentEntry>();
				for(final Category category : extensionService.getCategories()) {
					final PaletteCompartmentEntry newEntry = new PaletteCompartmentEntry(((Category)category).getName(), null);
					compartmentEntries.add(newEntry);
				}

				return compartmentEntries;
			}
	
			/**
			 * Add the tool entry to the correct category
			 * @param toolEntry the toolEntry to be added to the palette
			 * @param feature the feature that holds which category to which the tool should be added.
			 */
			public void addToolEntry(final IToolEntry toolEntry, final IFeature feature) {
				final Category category = getCategory(feature);
				if(category != null) {
					for(final PaletteCompartmentEntry compartmentEntry : compartments) {
						if(compartmentEntry.getLabel().equals(category.getName())) {
							compartmentEntry.addToolEntry(toolEntry);
						}
					}
				} else {
					//Add to miscellaneous
					compartments.get(compartments.size()-1).addToolEntry(toolEntry);
				}
			}
			
			/**
			 * Get the category
			 * @param feature
			 * @return the category to which the toolEntry will be added
			 */
			private Category getCategory(final IFeature feature) {
				if(feature instanceof Categorized) {
					return getCategoryById(((Categorized)feature).getCategory());
				} else {
					return null;
				}
			}

			/**
			 * Get the Category based on id
			 * @param id is the compartment/category id
			 * @return the Category
			 */
			private Category getCategoryById(final String id) {
				final List<Category> categories = extensionService.getCategories();
				for(final Category category : categories) {
					if(category.getId().equals(id)) {
						return category;
					}
				}
				
				return null;
			}

			public void removeEmpty() {
				// Remove empty compartments		
				final Iterator<PaletteCompartmentEntry> it = compartments.iterator(); 
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
				compartments.addToolEntry(ccTool, createConnectionFeature);
			}
		}
		
		final ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
		if (createFeatures.length > 0){
			for (ICreateFeature createFeature : createFeatures) {
				final ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry(
						createFeature.getCreateName(), createFeature.getCreateDescription(),
						createFeature.getCreateImageId(), createFeature.getCreateLargeImageId(), createFeature);
				compartments.addToolEntry(objectCreationToolEntry, createFeature);
			}
		}
		
		compartments.removeEmpty();

		return compartments.toArray();
	}
	
	/**
	 * Overrides the mechanism to get the graphics algorithm used to determine the chop box location so that it uses the first graphics algorithm that isn't invisible.
	 * @param pe
	 * @return
	 */
	@Override
	public GraphicsAlgorithm getChopboxAnchorArea(final PictogramElement pe) {
		GraphicsAlgorithm ga = super.getChopboxAnchorArea(pe);
		while(!ga.getFilled() && !ga.getLineVisible() && ga.getGraphicsAlgorithmChildren().size() >= 1) {
			ga = ga.getGraphicsAlgorithmChildren().get(0);
		}

		return ga;
	}
}
