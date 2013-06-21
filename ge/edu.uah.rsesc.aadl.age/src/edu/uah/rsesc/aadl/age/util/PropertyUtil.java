package edu.uah.rsesc.aadl.age.util;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.osate.aadl2.NamedElement;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;

public class PropertyUtil {
	private static final String AADL_ELEMENT_KEY = "aadl-element";
	
	public static final void setAadlElement(PictogramElement pe, NamedElement ne) {
		Graphiti.getPeService().setPropertyValue(pe, AADL_ELEMENT_KEY, ne.getQualifiedName());
	}
	
	public static final NamedElement getAadlElement(PictogramElement pe) {
		final String aadlElementName = getAadlElementName(pe);
		
		// TODO: Need to support connections, packages, components, etc.
		// TODO: Wait for response to issue: I believe this would be extremely useful.
		
		final NamedElement element = EMFIndexRetrieval.getPackageInWorkspace(aadlElementName);

		// TODO: Handle null.
		
		return element;
	}
	
	public static final String getAadlElementName(PictogramElement pe) {
		return Graphiti.getPeService().getPropertyValue(pe, AADL_ELEMENT_KEY);
	}
}
