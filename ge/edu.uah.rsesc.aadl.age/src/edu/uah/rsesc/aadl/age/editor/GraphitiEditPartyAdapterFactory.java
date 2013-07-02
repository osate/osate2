package edu.uah.rsesc.aadl.age.editor;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.platform.GraphitiConnectionEditPart;
import org.eclipse.graphiti.ui.platform.GraphitiShapeEditPart;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.osate.aadl2.Element;

// TODO: Implement so that objects are actuyally adapted
public class GraphitiEditPartyAdapterFactory implements IAdapterFactory {
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {		
		// Get the business object
		Object bo = null;
		if (adaptableObject instanceof GraphitiShapeEditPart) {
			final GraphitiShapeEditPart part = (GraphitiShapeEditPart)adaptableObject;
			bo = part.getFeatureProvider().getBusinessObjectForPictogramElement(part.getPictogramElement());
		} else if (adaptableObject instanceof GraphitiConnectionEditPart) {
			final GraphitiConnectionEditPart part = (GraphitiConnectionEditPart)adaptableObject;
			bo = part.getFeatureProvider().getBusinessObjectForPictogramElement(part.getPictogramElement());
		}
		
		// If the business object is an AADL Element
		if(bo instanceof Element) {
			if(XtextDocument.class.equals(adapterType)) {
				
			} else if(Element.class.equals(adapterType)) {
				
			}
		}
		
		return null;
	}

	@Override
	public Class[] getAdapterList() {
		return new Class[] { XtextDocument.class, Element.class };
	}
}
