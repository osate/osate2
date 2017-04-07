/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Context;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.ModalPath;
import org.osate.aadl2.ModeBinding;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.diagram.DiagramElement;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.ShapeService;

public class DefaultColoringService implements ColoringService {
	private final ShapeService shapeService;
	private final PropertyService propertyService;
	private final BusinessObjectResolutionService bor;
	private final IFeatureProvider fp;
	private final LinkedList<ColoringCalculator> coloringCalculators = new LinkedList<ColoringCalculator>();
	
	// TODO: Consider exposing functionality via the service
	private static interface ColoringCalculator {
		java.awt.Color getForegroundColor(final BusinessObjectContext boc);
	}
	
	private class SimpleColoring implements Coloring, ColoringCalculator {
		private final Map<BusinessObjectContext, java.awt.Color> foregroundColors = new HashMap<>();
		
		@Override
		public void dispose() {
			coloringCalculators.remove(this);
			
			// Reapply coloring for diagram elements
			for(final BusinessObjectContext boc : foregroundColors.keySet()) {
				applyColoring(boc);
			}
		}

		@Override
		public void setForeground(final BusinessObjectContext boc, final java.awt.Color color) {
			foregroundColors.put(boc, color);
			applyForeground(boc, color);
			return;
		}
		
		public java.awt.Color getForegroundColor(final BusinessObjectContext boc) {
			return foregroundColors.get(boc);
		}
	};	
	
	private class SelectedModeFlowColoringCalculator implements ColoringCalculator {
		@Override
		public java.awt.Color getForegroundColor(final BusinessObjectContext boc) {
			// TODO: Migrate
			/*
			final Object bo = boc.getBusinessObject();
			final Shape possibleContextShape;
			if(bo instanceof Feature) {
				return null;
			} else if(bo instanceof Subcomponent && pe instanceof Shape) {
				possibleContextShape = shapeService.getClosestAncestorWithBusinessObjectType(((Shape)pe).getContainer(), Context.class, Classifier.class);
			} else if(bo instanceof FlowSpecification && pe instanceof Connection) {
				possibleContextShape = getSubcomponentShape((Connection)pe); 
			} else {
				possibleContextShape = null;
			}

			final Context context;
			final Shape contextShape;
			final Object possibleContext = possibleContextShape == null ? null : bor.getBusinessObjectForPictogramElement(possibleContextShape);
			if(possibleContext instanceof Context) {
				context = (Context)possibleContext;
				contextShape = possibleContextShape;
			} else {
				context = null;
				contextShape = null;
			}
			
			// Exclude sub-subcomponents from highlighting...
			if(context instanceof Subcomponent) {
				if(shapeService.getClosestBusinessObjectOfType(contextShape.getContainer(), Context.class) != null) {
					return null;
				}
			}
			
			// Check the mode of the element
			final String selectedModeName = propertyService.getSelectedMode(getDiagram());
	 		final boolean isModeSelected = !selectedModeName.equals(""); 	
	 		boolean inSelectedMode = false;
	 		if(isModeSelected) {
	 			if(bo instanceof ModalElement) {
					final ModalElement modalElement = (ModalElement)bo;
		 			if(context instanceof Subcomponent) {
		 				final Subcomponent sc = (Subcomponent)context;
		 				final boolean subcomponentIsInMode = isInMode(sc, selectedModeName);
		 				
		 				// If the subcomponent uses derived modes, then check that the element is in the derived mode
		 				final ComponentType ct = sc.getComponentType();
		 				final boolean elementIsInDerviedMode;
		 				if(ct != null && ct.isDerivedModes()) {
		 					String derivedModeName = "";
			 				for(final ModeBinding modeBinding : sc.getOwnedModeBindings()) {
			 					if(modeBinding.getParentMode() != null && selectedModeName.equalsIgnoreCase(modeBinding.getParentMode().getName())) {
			 						derivedModeName = modeBinding.getDerivedMode() == null ? modeBinding.getParentMode().getName() : modeBinding.getDerivedMode().getName();
			 						break;
			 					}
		 					}
			 				
			 				elementIsInDerviedMode = derivedModeName == null ? false : isInMode(modalElement, derivedModeName);
		 				} else {
		 					elementIsInDerviedMode = true;
		 				}
		 				
		 				inSelectedMode = subcomponentIsInMode && elementIsInDerviedMode;
		 			} else {	 			
						inSelectedMode = isInMode(modalElement, selectedModeName);	 			
		 			}
	 			}
	 		}
			
	 		// Check whether the element is in the flow
			final String selectedFlowName = propertyService.getSelectedFlow(getDiagram());
	 		final boolean isFlowSelected = !selectedFlowName.equals("");
	 		boolean inSelectedFlow = false;
	 		ModalPath selectedFlow = null;
	 		if(isFlowSelected) {
	 			if(bo instanceof NamedElement) {
	 				final NamedElement namedElement = (NamedElement)bo;
		 			// If the current diagram's BO is a component implementation
			 		final Object diagramBo = bor.getBusinessObjectForPictogramElement(getDiagram());
			 		if(diagramBo instanceof ComponentImplementation) {
			 			final ComponentImplementation ci = (ComponentImplementation)diagramBo;
			 			
			 			// Check Flow Implementations
			 			for(final FlowImplementation flow : ci.getAllFlowImplementations()) {
			 				if(flow.getSpecification() != null && selectedFlowName.equalsIgnoreCase(flow.getSpecification().getName())) {					
			 					if(flow.getSpecification().getInEnd() != null && doesElementMatchFlowElement(namedElement, context, flow.getSpecification().getInEnd().getFeature(), flow.getSpecification().getInEnd().getContext() )) {
		 							inSelectedFlow = true;
		 							selectedFlow = flow;
		 						} else if(flow.getSpecification().getOutEnd() != null && doesElementMatchFlowElement(namedElement, context, flow.getSpecification().getOutEnd().getFeature(), flow.getSpecification().getOutEnd().getContext())) {
		 							inSelectedFlow = true;
		 							selectedFlow = flow;
		 						} else {
				 					for(final FlowSegment fs : flow.getOwnedFlowSegments()) {
				 						if(doesElementMatchFlowElement(namedElement, context, fs.getFlowElement(), fs.getContext())) {
				 							inSelectedFlow = true;
				 							selectedFlow = flow;
											break;
				 						}
				 					}
		 						}
			 				}
			 				
			 				if(inSelectedFlow) {
			 					break;
			 				}
			 			}
			 			
			 			// Check End to End Flows
						for(final EndToEndFlow flow : ci.getAllEndToEndFlows()) {
							if(selectedFlowName.equalsIgnoreCase(flow.getName())) {
								inSelectedFlow = isInEndToEndFlow(namedElement, context, flow);
								selectedFlow = flow;
								break;
			 				}
						}
			 		}
	 			}
	 		}
	 		boolean isFlowInMode =  (isModeSelected && selectedFlow != null) ? isInMode(selectedFlow, selectedModeName) : true;

			// Highlight accordingly
	 		if(inSelectedMode && (inSelectedFlow && isFlowInMode)) {
	 			return Graphiti.getGaService().manageColor(getDiagram(), getInSelectedModeAndFlowColor());
	 		} else if(inSelectedMode) {
	 			return Graphiti.getGaService().manageColor(getDiagram(), getInSelectedModeColor());
	 		} else if(inSelectedFlow && isFlowInMode) {
	 			return Graphiti.getGaService().manageColor(getDiagram(), getInSelectedFlowColor());
	 		}
	 		*/
	 		return null;
		}
		
		private Shape getSubcomponentShape(final Connection connection) {
			if(connection.getStart() == null) {
				return null;
			}
			
			final AnchorContainer startContainer = connection.getStart().getParent();
			if(!(startContainer instanceof Shape)) {
				return null;
			}		
			
			return shapeService.getClosestAncestorWithBusinessObjectType((Shape)startContainer, Subcomponent.class);
		}
	};
	
	public DefaultColoringService(final ShapeService shapeService, final PropertyService propertyService, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		this.shapeService = shapeService;
		this.propertyService = propertyService;
		this.bor = bor;
		this.fp = fp;
		
		// Add coloring calculator to handle mode and flow behavior. It is contained here to replicate behavior of the highlighting service. 
		// In the future this could be moved outside the coloring service
		this.coloringCalculators.add(new SelectedModeFlowColoringCalculator());
	}	
	
	@Override
	public Coloring adjustColors() {
		final SimpleColoring newColoring = new SimpleColoring();
		coloringCalculators.addFirst(newColoring);
		return newColoring;
	}
	
	@Override
	public void applyColoring(final BusinessObjectContext boc) {
		// Determine the appropriate color
		java.awt.Color foregroundColor = null;
		for(final ColoringCalculator coloring : coloringCalculators) {
			foregroundColor = coloring.getForegroundColor(boc);
			if(foregroundColor != null) {
				break;
			}			
		}
		
		applyForeground(boc, foregroundColor);
	}
	
	private void applyForeground(final BusinessObjectContext boc, final java.awt.Color color) {
		// TODO: Adjust color for appropriate graphical algorithms
		/*
		// Handle coloring containers
		if(pe instanceof ContainerShape && propertyService.isColoringContainer(pe)) {
			for(final Shape childShape : ((ContainerShape)pe).getChildren()) {
				if(propertyService.isColoringChild(childShape)) {
					if(childShape.getGraphicsAlgorithm() != null) {
						DefaultColoringService.this.setForeground(childShape.getGraphicsAlgorithm(), color);
					}
				}
			}
		} else {			
			if(pe.getGraphicsAlgorithm() != null) {
				DefaultColoringService.this.setForeground(pe.getGraphicsAlgorithm(), color);
			}
			
			// Color connection decorators
			if(pe instanceof Connection) {
				for(final ConnectionDecorator cd : ((Connection) pe).getConnectionDecorators()) {
					if(cd.getGraphicsAlgorithm() != null) {
						DefaultColoringService.this.setForeground(cd.getGraphicsAlgorithm(), color);
					}
				}
			}
		}*/		
	}
	
	private boolean isInMode(final ModalElement modalElement, final String modeName) {
		// Determine the total number of modes/mode transitions
		final int numModesSpecified = (modalElement instanceof ModalPath) ? (modalElement.getAllInModes().size() + ((ModalPath)modalElement).getAllInModeTransitions().size()) : modalElement.getAllInModes().size();
			
 		if(numModesSpecified == 0 || listContainsElementWithName(modalElement.getAllInModes(), modeName)) {
 			return true;
 		} else {
 			if(modalElement instanceof ModalPath) {
 				final ModalPath modalPath = (ModalPath)modalElement;
 				if(numModesSpecified == 0 || listContainsElementWithName(modalPath.getAllInModeTransitions(), modeName)) {
 					return true;
 				}
 	 		}	
 		}
 		
 		return false;
	}
	
	private void setForeground(final GraphicsAlgorithm ga, org.eclipse.graphiti.mm.algorithms.styles.Color color) {
		ga.setForeground(color);
		
		for(final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
			setForeground(childGa, color);
		}
	}
	
	private boolean isInEndToEndFlow(final NamedElement element, final Context context, final EndToEndFlow flow) {
		for(final EndToEndFlowSegment fs : flow.getAllFlowSegments()) {
			if(doesElementMatchFlowElement(element, context, fs.getFlowElement(), fs.getContext())) {
				return true;
			}
			
			// Handle referencing another ETEF
			if(fs.getContext() == null && fs.getFlowElement() instanceof EndToEndFlow) {
				if(isInEndToEndFlow(element, context, (EndToEndFlow)fs.getFlowElement())) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean doesElementMatchFlowElement(final NamedElement element, final Context context, final NamedElement flowElement, final Context flowContext) {
		if(areNamesEqualOrBothNull(context, flowContext) && areNamesEqualOrBothNull(element, flowElement)) {
			return true;
		}

		return false;
	}
	
	private boolean areNamesEqualOrBothNull(final NamedElement e1, final NamedElement e2) {
		if(e1 == null && e2 == null) {
			return true;
		}
		
		if(e1 == null || e1.getName() == null || e2 == null || e2.getName() == null)
			return false;

		return e1.getName().equalsIgnoreCase(e2.getName());
	}
	
	private boolean listContainsElementWithName(final List<? extends NamedElement> elements, final String name) {
		for(final NamedElement el : elements) {
			if(name.equalsIgnoreCase(el.getName())) {
				return true;
			}
		}
		
		return false;
	}
	
	private Diagram getDiagram() {
		return fp.getDiagramTypeProvider().getDiagram();
	}
	
	private IColorConstant getInSelectedModeColor() {
		return ColorConstant.BLUE;
	}
	
	private IColorConstant getInSelectedFlowColor() {
		return ColorConstant.DARK_GREEN;
	}
	
	private IColorConstant getInSelectedModeAndFlowColor() {
		return ColorConstant.CYAN;
	};
}