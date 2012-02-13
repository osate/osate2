package org.osate.xtext.aadl2.propertyset.linking;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.NamedElement;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService;

public class PropertysetLinkingService extends PropertiesLinkingService {
//	private  ErrorModelLanguageServices emLangS  = new ErrorModelLanguageServices();
//	private ILinkingService emLS = emLangS.getLinkingService();

	public NamedElement getContainingAnnex(EObject obj){
		while (obj != null ){
			if (obj instanceof AnnexLibrary || obj instanceof AnnexSubclause)
				return (NamedElement)obj;
			obj = obj.eContainer();
		}
		return null;
	}
	
	@Override
	public List<EObject> getLinkedObjects(EObject context,
			EReference reference, INode node) throws IllegalNodeException {
		NamedElement annex = getContainingAnnex(context);
//		if (annex != null){
//			String annexName = annex.getName();
//			if (annexName.equalsIgnoreCase("error_model")){
//				return emLS.getLinkedObjects(context, reference, node);
//						//emLS.getLinkingService().getLinkedObjects(context, reference, node);
//			}
//		}
		final EClass requiredType = reference.getEReferenceType();
		if (requiredType == null)
			return Collections.<EObject> emptyList();
		
		final EClass pt = Aadl2Package.eINSTANCE.getPropertyType();
		final String name = getCrossRefNodeAsString(node);
        if (pt.isSuperTypeOf(requiredType)) {
			// look for property type in property set
			return findPropertyType(context, reference, name);

		} else if (Aadl2Package.eINSTANCE.getPropertyConstant() == requiredType
				) {
			// look for property constant in property set
			return findPropertyConstant(context, reference, name);

		} else if (Aadl2Package.eINSTANCE.getUnitLiteral() == requiredType) {
			// look for unit literal pointed to by baseUnit
			return findUnitLiteralAsList(context, reference, name);

		} else if (Aadl2Package.eINSTANCE.getEnumerationLiteral() == requiredType) {
			// look for enumeration literal
			return findEnumLiteralAsList(context, reference, name);

		} else {
			
 			List<EObject> res = super.getLinkedObjects(context, reference, node);
 			return res;
//			Activator.logErrorMessage("Unhandled reference in Aadl2LinkingService: "+reference.getName()+" to "+requiredType.getName());
		}

//		return Collections.emptyList();
	}
	


}
