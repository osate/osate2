package org.osate.expr.naming

import org.eclipse.xtext.naming.IQualifiedNameConverter.DefaultImpl
import org.eclipse.xtext.naming.QualifiedName

class ExprQualifiedNameConverter extends DefaultImpl {

	override getDelimiter() {
		'::'
	}

}
