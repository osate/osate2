package org.osate.ui.navigator;

import org.eclipse.jface.viewers.ViewerComparator;

public class AadlProjectDependenciesSorter extends ViewerComparator {

	@Override
	public int category(Object element) {
		// show project dependencies before other project content
		if (element instanceof VirtualProjectDependencies) {
			return 11;
		}
		return super.category(element);
	}
}
