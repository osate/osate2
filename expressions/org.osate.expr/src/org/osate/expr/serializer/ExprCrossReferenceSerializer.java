package org.osate.expr.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.tokens.CrossReferenceSerializer;

@SuppressWarnings("restriction")
public class ExprCrossReferenceSerializer extends CrossReferenceSerializer {
	static String PREFIX = "expr$";

	@Override
	public String serializeCrossRef(EObject semanticObject, CrossReference crossref, EObject target, INode node, Acceptor errors) {
		String crossRefString = super.serializeCrossRef(semanticObject, crossref, target, node, errors);
		if (crossRefString.startsWith(PREFIX)) {
			return crossRefString.substring(PREFIX.length());
		} else {
			return crossRefString;
		}
	}
}
