package org.osate.xtext.aadl2.errormodel.naming

import org.eclipse.xtext.naming.IQualifiedNameConverter

class ErrorModelQualifiedNameConverter extends IQualifiedNameConverter.DefaultImpl {
	override getDelimiter() {
		"::"
	}
}