package org.osate.ui.navigator;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;

public class AadlElementSorter extends ViewerComparator {
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		if (e1 instanceof NavigatorEObjectNode && e2 instanceof NavigatorEObjectNode) {
			return 0;
		}
		return super.compare(viewer, e1, e2);
	}

}
