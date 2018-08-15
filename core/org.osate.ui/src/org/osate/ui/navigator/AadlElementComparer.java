package org.osate.ui.navigator;

import org.eclipse.jface.viewers.IElementComparer;
import org.osate.aadl2.NamedElement;

public class AadlElementComparer implements IElementComparer {

	@Override
	public boolean equals(Object a, Object b) {
		if (a instanceof NamedElement && b instanceof NamedElement) {
			NamedElement nea = (NamedElement) a;
			NamedElement neb = (NamedElement) b;
			return nea.eClass() == neb.eClass() && nea.getQualifiedName().equals(neb.getQualifiedName())
					&& nea.getFullName().equals(neb.getFullName());
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
