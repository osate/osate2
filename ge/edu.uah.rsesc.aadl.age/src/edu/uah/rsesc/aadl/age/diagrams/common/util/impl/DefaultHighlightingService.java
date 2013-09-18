package edu.uah.rsesc.aadl.age.diagrams.common.util.impl;

import java.util.List;

import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.ModalPath;
import org.osate.aadl2.NamedElement;

import edu.uah.rsesc.aadl.age.diagrams.common.util.HighlightingService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.PropertyService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService;

public class DefaultHighlightingService implements HighlightingService {
	private final PropertyService propertyUtil;
	private final StyleService styleUtil;
	
	public DefaultHighlightingService(final PropertyService propertyUtil, final StyleService styleUtil) {
		this.propertyUtil = propertyUtil;
		this.styleUtil = styleUtil;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.HighlightingService#highlight(org.eclipse.graphiti.mm.pictograms.Diagram, org.osate.aadl2.Element, org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm)
	 */
	@Override
	public void highlight(final Diagram diagram, final Element element, final GraphicsAlgorithm ga) {
		final String selectedModeName = propertyUtil.getSelectedMode(diagram);
 		final boolean isModeSelected = !selectedModeName.equals(""); 	
 		boolean inSelectedMode = false;
 		
 		// Check the mode of the element
		if(element instanceof ModalElement) {
			final ModalElement modalElement = (ModalElement)element;
			
			// Set color based on current mode/mode transition
	 		if(isModeSelected) {
	 			// Determine the total number of modes/mode transitions
	 			final int numModesSpecified = (modalElement instanceof ModalPath) ? (modalElement.getAllInModes().size() + ((ModalPath)modalElement).getAllInModeTransitions().size()) : modalElement.getAllInModes().size();
	 			
		 		if(numModesSpecified == 0 || listContainsElementWithName(modalElement.getAllInModes(), selectedModeName)) {
		 			inSelectedMode = true;
		 		} else {
		 			if(modalElement instanceof ModalPath) {
		 				final ModalPath modalPath = (ModalPath)modalElement;
		 				if(numModesSpecified == 0 || listContainsElementWithName(modalPath.getAllInModeTransitions(), selectedModeName)) {
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
 			ga.setForeground(Graphiti.getGaService().manageColor(diagram, styleUtil.getInSelectedModeColor()));
 		}
 	}
	
	private boolean listContainsElementWithName(final List<? extends NamedElement> elements, final String name) {
		for(final NamedElement el : elements) {
			if(name.equalsIgnoreCase(el.getName())) {
				return true;
			}
		}
		
		return false;
	}
}
