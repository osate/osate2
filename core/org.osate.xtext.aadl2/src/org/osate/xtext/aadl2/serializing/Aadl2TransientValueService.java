package org.osate.xtext.aadl2.serializing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultTransientValueService;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.PackageSection;

public class Aadl2TransientValueService  extends DefaultTransientValueService {

		@Override
		public boolean isTransient(EObject owner, EStructuralFeature feature, int index) {
			if (feature == Aadl2Package.eINSTANCE.getAadlPackage_PublicSection()
					|| feature == Aadl2Package.eINSTANCE.getAadlPackage_PrivateSection()
					|| feature == Aadl2Package.eINSTANCE.getSubprogramCall_Context()
					) return true;
//			else if (owner instanceof PackageSection && feature == Aadl2Package.eINSTANCE.getNamedElement_Name()){
//				// name not explicitly stored
//				return true;
//			}
////					} else if (owner instanceof TypeExtension){
////					if (feature == Aadl2Package.eINSTANCE.getTypeExtension_Extended()
////							|| feature == Aadl2Package.eINSTANCE.getAadlPackage_PrivateSection()
////					) {
////							return true;
////					}
			return super.isTransient(owner, feature, index);
			}

}
