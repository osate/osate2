package org.osate.xtext.aadl2.errormodel.serializer

import org.eclipse.xtext.serializer.tokens.CrossReferenceSerializer
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor

class ErrorModelCrossReferenceSerializer extends CrossReferenceSerializer {
	val public static PREFIX = "emv2$"
	
	override serializeCrossRef(EObject semanticObject, CrossReference crossref, EObject target, INode node, Acceptor errors) {
		val crossRefString = super.serializeCrossRef(semanticObject, crossref, target, node, errors)
		if (crossRefString.startsWith(PREFIX)) {
			crossRefString.substring(PREFIX.length)
		} else {
			crossRefString
		}
	}
}