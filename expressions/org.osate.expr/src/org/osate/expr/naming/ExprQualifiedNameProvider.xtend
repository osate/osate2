package org.osate.expr.naming

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider
import org.osate.aadl2.AadlPackage
import org.osate.expr.expr.Declaration
import org.osate.expr.expr.ExprLibrary

class ExprQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {

	override getFullyQualifiedName(EObject obj) {
		val pkg = EcoreUtil2.getContainerOfType(obj, AadlPackage)

		switch obj {
			ExprLibrary:
				getConverter().toQualifiedName(pkg.name)
			Declaration: {
				getConverter().toQualifiedName(pkg.name + '::' + obj.name)
			}
			default:
				null
		}
	}

}
