package org.osate.expr.naming

import org.eclipse.xtext.naming.IQualifiedNameConverter.DefaultImpl
import org.eclipse.xtext.naming.QualifiedName

class ExprQualifiedNameConverter extends DefaultImpl {

	override toQualifiedName(String qualifiedNameAsString) {
		super.toQualifiedName('expr$' + qualifiedNameAsString)
	}
	
	override toString(QualifiedName qualifiedName) {
		val PREFIX = 'expr$'
		val result = super.toString(qualifiedName)
		if (result.startsWith(PREFIX)) {
			result.substring(PREFIX.length)
		} else {
			result
		}
	}
	
	override getDelimiter() {
		'::'
	}
	
}