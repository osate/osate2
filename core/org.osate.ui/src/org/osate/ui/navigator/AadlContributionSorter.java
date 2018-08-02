package org.osate.ui.navigator;

import org.eclipse.jface.viewers.ViewerComparator;
import org.osate.xtext.aadl2.ui.resource.ContributedAadlStorage;

public class AadlContributionSorter extends ViewerComparator {

	@Override
	public int category(Object element) {
		if (element instanceof VirtualPluginResources) {
			return 10;
		}
		if (element instanceof ContributedDirectory) {
			return 20;
		}
		if (element instanceof ContributedAadlStorage) {
			return 30;
		}
		return super.category(element);
	}
}
