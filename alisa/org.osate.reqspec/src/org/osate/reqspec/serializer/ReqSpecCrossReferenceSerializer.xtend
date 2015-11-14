package org.osate.reqspec.serializer;

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor
import org.eclipse.xtext.serializer.tokens.CrossReferenceSerializer
import org.osate.aadl2.ComponentClassifier

class ReqSpecCrossReferenceSerializer extends CrossReferenceSerializer {

	override serializeCrossRef(EObject semanticObject, CrossReference crossref, EObject target, INode node,
			Acceptor errors) {

		val crossRefString = super.serializeCrossRef(semanticObject, crossref, target, node, errors)
		
		switch target{
			ComponentClassifier : {
				val qn =  target.qualifiedName()
				val qnDoubleColonIndex = qn.indexOf("::")
				if (qnDoubleColonIndex < 0 || crossRefString.indexOf("::") > -1) crossRefString
				else {
					val crsPeriodIndex = crossRefString.indexOf(".")
					if (crsPeriodIndex == qnDoubleColonIndex){
						val checkString = crossRefString.substring(0, crsPeriodIndex) + "::" 
										+ crossRefString.substring(crsPeriodIndex + 1)
						if (checkString.equalsIgnoreCase(qn)) checkString
						else crossRefString
					} else crossRefString
				}
			}
			default : crossRefString
		}

	}
	

}
