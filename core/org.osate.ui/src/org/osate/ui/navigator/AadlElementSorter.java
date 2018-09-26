package org.osate.ui.navigator;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.osate.aadl2.NamedElement;

public class AadlElementSorter extends ViewerComparator {
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		if (e1 instanceof NamedElement && e2 instanceof NamedElement) {
			return 0;
		}
		return super.compare(viewer, e1, e2);
	}

}
