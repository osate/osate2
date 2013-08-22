package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.ModalPath;

public class ModalElementHelper {
	/**
	 * Sets the foreground color if the modal element is in the selected mode/mode transition
	 * @param diagram
	 * @param modalElement
	 * @param ga
	 */
	public static void setColorIfInSelectedMode(final Diagram diagram, final ModalElement modalElement, final GraphicsAlgorithm ga) {
		boolean highlight = false;
		
		// Set color based on current mode/mode transition
 		final String selectedModeName = PropertyUtil.getSelectedMode(diagram);
 		if(!selectedModeName.equals("")) { 			
 			// Determine the total number of modes/mode transitions
 			final int numModesSpecified = (modalElement instanceof ModalPath) ? (modalElement.getAllInModes().size() + ((ModalPath)modalElement).getAllInModeTransitions().size()) : modalElement.getAllInModes().size();
 			
	 		if(numModesSpecified == 0 || ElementHelper.listContainsElementWithName(modalElement.getAllInModes(), selectedModeName)) {
	 			highlight = true;
	 		} else {
	 			if(modalElement instanceof ModalPath) {
	 				final ModalPath modalPath = (ModalPath)modalElement;
	 				if(numModesSpecified == 0 || ElementHelper.listContainsElementWithName(modalPath.getAllInModeTransitions(), selectedModeName)) {
	 					highlight = true;
	 				}
	 	 		}	
	 		}
 		}
 		
 		if(highlight) {
 			ga.setForeground(Graphiti.getGaService().manageColor(diagram, StyleUtil.getInSelectedModeColor()));
 		}	
 	}
}
