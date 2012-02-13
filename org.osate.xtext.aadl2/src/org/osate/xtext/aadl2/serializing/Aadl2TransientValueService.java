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
					|| feature == Aadl2Package.eINSTANCE.getPublicPackageSection_PrivateSection()
					|| feature == Aadl2Package.eINSTANCE.getPackageSection_NoAnnexes()
					|| feature == Aadl2Package.eINSTANCE.getPackageSection_NoProperties()
					||feature == Aadl2Package.eINSTANCE.getElement_OwnedElement()
					||feature == Aadl2Package.eINSTANCE.getNamedElement_QualifiedName()
					||feature == Aadl2Package.eINSTANCE.getNamespace_Member()
					||feature == Aadl2Package.eINSTANCE.getNamespace_OwnedMember()
					||feature == Aadl2Package.eINSTANCE.getGeneralization_General()
					||feature == Aadl2Package.eINSTANCE.getGeneralization_Specific()
					||feature == Aadl2Package.eINSTANCE.getDirectedRelationship_Source()
					||feature == Aadl2Package.eINSTANCE.getDirectedRelationship_Target()
					||feature == Aadl2Package.eINSTANCE.getRelationship_RelatedElement()
					||feature == Aadl2Package.eINSTANCE.getComponentType_Extended()
					||feature == Aadl2Package.eINSTANCE.getComponentType_OwnedFeature()
					||feature == Aadl2Package.eINSTANCE.getRefinableElement_RefinementContext()
					||feature == Aadl2Package.eINSTANCE.getRefinableElement_RefinedElement()
					||feature == Aadl2Package.eINSTANCE.getClassifierFeature_FeaturingClassifier()
					||feature == Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature()
					||feature == Aadl2Package.eINSTANCE.getClassifier_General()
					||feature == Aadl2Package.eINSTANCE.getClassifier_NoAnnexes()
					||feature == Aadl2Package.eINSTANCE.getClassifier_InheritedMember()
					||feature == Aadl2Package.eINSTANCE.getClassifier_Generalization()
					||feature == Aadl2Package.eINSTANCE.getPort_Category()
					||feature == Aadl2Package.eINSTANCE.getFeature_Classifier()
					||feature == Aadl2Package.eINSTANCE.getFeature_Prototype()
			) 
			{
					return true;
			}
			else if (owner instanceof PackageSection && feature == Aadl2Package.eINSTANCE.getNamedElement_Name()){
				// name not explicitly stored
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
