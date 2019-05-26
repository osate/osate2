package org.osate.expr.serializer

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.serializer.impl.Serializer
import org.osate.expr.expr.ExprLibrary
import org.osate.expr.expr.ExprSubclause
import org.osate.expr.services.ExprGrammarAccess

class ExprSerializer extends Serializer {

	@Inject
	ExprGrammarAccess grammarAccess

	override protected getIContext(EObject semanticObject) {
		switch semanticObject {
			ExprLibrary:
				contextFinder.findByContents(semanticObject, null).findFirst [
					parserRule == grammarAccess.exprLibraryRule
				]
			ExprSubclause:
				contextFinder.findByContents(semanticObject, null).findFirst [
					parserRule == grammarAccess.exprSubclauseRule
				]
			default:
				super.getIContext(semanticObject)
		}
	}

}
