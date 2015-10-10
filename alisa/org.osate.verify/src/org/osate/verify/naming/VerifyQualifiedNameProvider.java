package org.osate.verify.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationCondition;

public class VerifyQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
	// Enable to limit indexing to global items
	@Override
	public QualifiedName getFullyQualifiedName(final EObject obj) {
		if (obj instanceof VerificationActivity || obj instanceof VerificationCondition) {
			return null;
		}
		return super.getFullyQualifiedName(obj);
	}
}
