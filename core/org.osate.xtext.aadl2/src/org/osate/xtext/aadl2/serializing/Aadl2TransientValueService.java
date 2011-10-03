package org.osate.xtext.aadl2.serializing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultTransientValueService;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.TypeExtension;

public class Aadl2TransientValueService  extends DefaultTransientValueService {

		@Override
		public boolean isTransient(EObject owner, EStructuralFeature feature, int index) {
			if (feature == Aadl2Package.eINSTANCE.getAadlPackage_PublicSection()
					|| feature == Aadl2Package.eINSTANCE.getAadlPackage_PrivateSection()
			) 
			{
					return true;
			} else if (feature == Aadl2Package.eINSTANCE.getElement_OwnedElement()	) {
						return true;
			} else if  (feature == Aadl2Package.eINSTANCE.getNamedElement_QualifiedName()) {
						return true;
				}
//					} else if (owner instanceof TypeExtension){
//					if (feature == Aadl2Package.eINSTANCE.getTypeExtension_Extended()
//							|| feature == Aadl2Package.eINSTANCE.getAadlPackage_PrivateSection()
//					) {
//							return true;
//					}
			return false;
			}

}
