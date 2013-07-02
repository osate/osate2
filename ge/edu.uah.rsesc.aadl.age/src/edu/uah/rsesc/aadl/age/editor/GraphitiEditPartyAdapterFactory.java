package edu.uah.rsesc.aadl.age.editor;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.graphiti.ui.platform.GraphitiConnectionEditPart;
import org.eclipse.graphiti.ui.platform.GraphitiShapeEditPart;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;

import edu.uah.rsesc.aadl.age.xtext.AgeXtextUtil;

// TODO: Document
public class GraphitiEditPartyAdapterFactory implements IAdapterFactory {
	@Override
	public Object getAdapter(Object adaptableObject, @SuppressWarnings("rawtypes") Class adapterType) {		
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
		if(bo instanceof NamedElement) {
			final NamedElement namedElement = (NamedElement)bo;
			if(XtextDocument.class.equals(adapterType)) {
				return AgeXtextUtil.getDocumentByQualifiedName(namedElement.getQualifiedName());
			} else if(Element.class.equals(adapterType)) {
				return namedElement;
			}
		}
		
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class[] getAdapterList() {
		return new Class[] { XtextDocument.class, Element.class };
	}
}
