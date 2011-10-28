package org.osate.xtext.aadl2.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.tokens.CrossReferenceSerializer;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService;

public class Aadl2CrossReferenceSerializer extends CrossReferenceSerializer {

	@Override
	protected String getCrossReferenceNameFromScope(EObject semanticObject, CrossReference crossref, EObject target,
			final IScope scope, Acceptor errors) {
		if (target instanceof AadlPackage){
			return ((NamedElement)target).getName();
		} else if (target instanceof Classifier){
			if (((Classifier) target).getElementRoot() == ((Element)semanticObject).getElementRoot()){
				return ((NamedElement)target).getName();
			} else {
				return ((NamedElement)target).getQualifiedName();
			}
//			String s = super.getCrossReferenceNameFromScope(semanticObject, crossref, target, scope, errors);
//			return s;
		} else if (target instanceof Property || target instanceof PropertyType ||
				target instanceof PropertyConstant){
			PropertySet ps = (PropertySet)target.eContainer();
			if (PropertiesLinkingService.isPredeclaredPropertySet(ps.getName())){
				return ((NamedElement)target).getName();
			} else {				
				return ((NamedElement)target).getQualifiedName();
			}
		} else if (target instanceof NamedElement){
			return ((NamedElement)target).getName();
		} else return "<noname>";
	}

}
