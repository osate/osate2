package org.osate.xtext.aadl2.errormodel.serializer

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.serializer.impl.Serializer
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause
import org.osate.xtext.aadl2.errormodel.services.ErrorModelGrammarAccess

class ErrorModelSerializer extends Serializer {
	@Inject ErrorModelGrammarAccess grammarAccess
	
	override protected getIContext(EObject semanticObject) {
		switch semanticObject {
			ErrorModelLibrary: contextFinder.findByContents(semanticObject, null).findFirst[parserRule == grammarAccess.errorModelLibraryRule]
			ErrorModelSubclause: contextFinder.findByContents(semanticObject, null).findFirst[parserRule == grammarAccess.errorModelSubclauseRule]
			default: super.getIContext(semanticObject)
		}
	}
}