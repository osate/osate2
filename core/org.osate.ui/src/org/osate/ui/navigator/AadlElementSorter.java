package org.osate.ui.navigator;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.osate.aadl2.modelsupport.EObjectURIWrapper;

public class AadlElementSorter extends ViewerComparator {
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		if (e1 instanceof EObjectURIWrapper && e2 instanceof EObjectURIWrapper) {
			return 0;
		}
		return super.compare(viewer, e1, e2);
	}

}
