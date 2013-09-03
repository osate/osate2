package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.ModalPath;

public class HighlightingHelper {
	/**
	 * Sets the foreground color of the element depending on the selected mode, mode transition, or flow
	 * @param diagram
	 * @param modalElement
	 * @param ga
	 */
	public static void highlight(final Diagram diagram, final Element element, final GraphicsAlgorithm ga, final IFeatureProvider fp) {
		final String selectedModeName = PropertyUtil.getSelectedMode(diagram);
 		final boolean isModeSelected = !selectedModeName.equals(""); 	
 		boolean inSelectedMode = false;
 		
 		// Check the mode of the element
		if(element instanceof ModalElement) {
			final ModalElement modalElement = (ModalElement)element;
			
			// Set color based on current mode/mode transition
	 		if(isModeSelected) {
	 			// Determine the total number of modes/mode transitions
	 			final int numModesSpecified = (modalElement instanceof ModalPath) ? (modalElement.getAllInModes().size() + ((ModalPath)modalElement).getAllInModeTransitions().size()) : modalElement.getAllInModes().size();
	 			
		 		if(numModesSpecified == 0 || ElementHelper.listContainsElementWithName(modalElement.getAllInModes(), selectedModeName)) {
		 			inSelectedMode = true;
		 		} else {
		 			if(modalElement instanceof ModalPath) {
		 				final ModalPath modalPath = (ModalPath)modalElement;
		 				if(numModesSpecified == 0 || ElementHelper.listContainsElementWithName(modalPath.getAllInModeTransitions(), selectedModeName)) {
		 					inSelectedMode = true;
		 				}
		 	 		}	
		 		}
	 		}
		} else {
			inSelectedMode = true;
		}
		
		// Highlight accordingly
 		if(isModeSelected && inSelectedMode) {
 			ga.setForeground(Graphiti.getGaService().manageColor(diagram, StyleUtil.getInSelectedModeColor()));
 		}
 	}
}
