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
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.modelsupport.util.AadlUtil;

public class Aadl2CrossReferenceSerializer extends CrossReferenceSerializer {

	@Override
	protected String getCrossReferenceNameFromScope(EObject semanticObject, CrossReference crossref, EObject target,
			final IScope scope, Acceptor errors) {
		if (target instanceof AadlPackage){
			return ((NamedElement)target).getName();
		} else if (target instanceof Classifier){
			return AadlUtil.getClassifierName((Classifier)target, (Element) semanticObject);
		} else if (target instanceof Property || target instanceof PropertyType ||
				target instanceof PropertyConstant){
			return AadlUtil.getPropertySetElementName((NamedElement)target);
		} else if (target instanceof NamedElement){
			return ((NamedElement)target).getName();
		} else return "<noname>";
	}

}
