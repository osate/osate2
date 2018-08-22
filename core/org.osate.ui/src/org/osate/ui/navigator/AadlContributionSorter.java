package org.osate.ui.navigator;

import org.eclipse.jface.viewers.ViewerComparator;
import org.osate.xtext.aadl2.ui.resource.ContributedAadlStorage;

public class AadlContributionSorter extends ViewerComparator {

	@Override
	public int category(Object element) {
		// show plugin contributions before other project content
		if (element instanceof VirtualPluginResources) {
			return 10;
		}
		// show contributed directories before contributed AADL files
		if (element instanceof ContributedDirectory) {
			return 10;
		}
		if (element instanceof ContributedAadlStorage) {
			return 20;
		}
		return super.category(element);
	}
}
