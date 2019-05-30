package org.osate.expr.naming

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider
import org.osate.aadl2.AadlPackage
import org.osate.expr.expr.EDeclaration
import org.osate.expr.expr.ExprLibrary

class ExprQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {

	override getFullyQualifiedName(EObject obj) {
		val pkg = EcoreUtil2.getContainerOfType(obj, AadlPackage)

		if (obj instanceof AadlPackage) {
			return converter.toQualifiedName(obj.name);
		}

		switch obj {
			ExprLibrary:
				converter.toQualifiedName('expr$' + pkg.name)
			EDeclaration: {
				converter.toQualifiedName('expr$' + pkg.name + '::' + obj.name)
			}
			default:
				null
		}
	}

}
