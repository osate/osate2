package org.osate.expr.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.osate.aadl2.AadlPackage;
import org.osate.expr.expr.EDeclaration;
import org.osate.expr.expr.ExprLibrary;

public class ExprQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {

	@Override
	public QualifiedName getFullyQualifiedName(final EObject obj) {
		final AadlPackage pkg = EcoreUtil2.<AadlPackage> getContainerOfType(obj, AadlPackage.class);

		if (obj instanceof AadlPackage) {
			return getConverter().toQualifiedName(((AadlPackage) obj).getName());
		}

		String pkgName = "expr$" + pkg.getName();
		QualifiedName result = null;

		if (obj instanceof ExprLibrary) {
			result = getConverter().toQualifiedName(pkgName);
		} else if (obj instanceof EDeclaration) {
			final EDeclaration decl = (EDeclaration) obj;
			result = getConverter().toQualifiedName(pkgName + "::" + decl.getName());
		}
		return result;
	}

}
