package org.osate.ui.navigator;

import org.eclipse.jface.viewers.IElementComparer;
import org.osate.aadl2.NamedElement;

public class AadlElementComparer implements IElementComparer {

	@Override
	public boolean equals(Object a, Object b) {
		if (a instanceof NamedElement && b instanceof NamedElement) {
			final NamedElement nea = (NamedElement) a;
			final NamedElement neb = (NamedElement) b;
			final String qnA = nea.getQualifiedName();
			final String qnB = neb.getQualifiedName();
			final String fnA = nea.getFullName();
			final String fnB = neb.getFullName();
			return nea.eClass() == neb.eClass() &&
					(qnA == null ? qnB == null : qnA.equals(qnB)) &&
					(fnA == null ? fnB == null : fnA.equals(fnB));
		} else {
			return a.equals(b);
		}
	}

	@Override
	public int hashCode(Object element) {
		if (element instanceof NamedElement) {
			NamedElement ne = (NamedElement) element;
			return (ne.eClass().getName() + ne.getQualifiedName() + ne.getFullName()).hashCode();
		} else {
			return element.hashCode();
		}
	}

}
