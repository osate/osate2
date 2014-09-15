/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.services.impl;

import java.util.List;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Context;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.ModalPath;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.HighlightingService;
import org.osate.ge.services.PropertyService;
import org.osate.ge.services.StyleService;

public class DefaultHighlightingService implements HighlightingService {
	private final PropertyService propertyUtil;
	private final StyleService styleUtil;
	private final BusinessObjectResolutionService bor;
	private final IFeatureProvider fp;
	
	
	public DefaultHighlightingService(final PropertyService propertyUtil, final StyleService styleUtil, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		this.propertyUtil = propertyUtil;
		this.styleUtil = styleUtil;
		this.bor = bor;
		this.fp = fp;
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.HighlightingService#highlight(org.eclipse.graphiti.mm.pictograms.Diagram, org.osate.aadl2.Element, org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm)
	 */
	@Override
	public void highlight(final Element element, final Context context, final GraphicsAlgorithm ga) {
 		// Check the mode of the element
		final String selectedModeName = propertyUtil.getSelectedMode(getDiagram());
 		final boolean isModeSelected = !selectedModeName.equals(""); 	
 		boolean inSelectedMode = false;
 		if(isModeSelected && !(context instanceof Subcomponent)) {
			if(element instanceof ModalElement) {
				final ModalElement modalElement = (ModalElement)element;
				inSelectedMode = isInMode(modalElement, selectedModeName);	 			
			}
 		}
		
 		// Check whether the element is in the flow
		final String selectedFlowName = propertyUtil.getSelectedFlow(getDiagram());
 		final boolean isFlowSelected = !selectedFlowName.equals("");
 		boolean inSelectedFlow = false;
 		ModalPath selectedFlow = null;
 		if(isFlowSelected) {
 			if(element instanceof NamedElement) {
 				final NamedElement namedElement = (NamedElement)element;
	 			// If the current diagram's BO is a component implementation
		 		final Object bo = bor.getBusinessObjectForPictogramElement(getDiagram());
		 		if(bo instanceof ComponentImplementation) {
		 			final ComponentImplementation ci = (ComponentImplementation)bo;
		 			
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
 		
 		boolean isFlowInMode =  (isModeSelected && selectedFlow != null) ? isInMode(selectedFlow, selectedModeName) : false;
		
		// Highlight accordingly
 		if(inSelectedMode && (inSelectedFlow && isFlowInMode)) {
 			setForeground(ga, Graphiti.getGaService().manageColor(getDiagram(), styleUtil.getInSelectedModeAndFlowColor()));
 		} else if(inSelectedMode) {
 			setForeground(ga, Graphiti.getGaService().manageColor(getDiagram(), styleUtil.getInSelectedModeColor()));
 		} else if(inSelectedFlow && isFlowInMode) {
 			setForeground(ga, Graphiti.getGaService().manageColor(getDiagram(), styleUtil.getInSelectedFlowColor()));
 		}
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
	
	private void setForeground(final GraphicsAlgorithm ga, Color color) {
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
}