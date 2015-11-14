package org.osate.assure.serializer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.tokens.CrossReferenceSerializer;

public class AssureCrossReferenceSerializer extends CrossReferenceSerializer {
	@Override
	protected String getCrossReferenceNameFromScope(EObject semanticObject, CrossReference crossref, EObject target,
			final IScope scope, Acceptor errors) {
//		if (target instanceof AadlPackage) {
//			return ((NamedElement) target).getName();
//		} else if (target instanceof Classifier) {
//			return AadlUtil.getClassifierName((Classifier) target, (Element) semanticObject);
//		} else if (target instanceof Property || target instanceof PropertyType || target instanceof PropertyConstant) {
//			return AadlUtil.getPropertySetElementName((NamedElement) target);
//		} else if (target instanceof NamedElement) {
//			return ((NamedElement) target).getName();
//		} else {
//			return "<noname>";
//		}
		if (target instanceof EObject) {
			EObject io = (EObject) target;
			URI uri = EcoreUtil.getURI(io);
			return "\"" + uri.toString() + "\"";
		}
		return super.getCrossReferenceNameFromScope(semanticObject, crossref, target, scope, errors);
	}
}