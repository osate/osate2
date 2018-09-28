package org.osate.ui.navigator;

import org.eclipse.jface.viewers.ViewerComparator;

public class AadlProjectDependenciesSorter extends ViewerComparator {

	@Override
	public int category(Object element) {
		// show plugin contributions before other project content
		if (element instanceof VirtualProjectDependencies) {
			return 11;
		}
//		// show contributed directories before contributed AADL files
//		if (element instanceof ContributedDirectory) {
//			return 10;
//		}
//		if (element instanceof ContributedAadlStorage) {
//			return 20;
//		}
		return super.category(element);
	}
}
