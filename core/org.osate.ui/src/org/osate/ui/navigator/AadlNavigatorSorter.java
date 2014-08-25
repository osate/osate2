package org.osate.ui.navigator;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

public class AadlNavigatorSorter extends ViewerSorter {
	public int compare(Viewer viewer, Object e1, Object e2) {
		if(e1 instanceof IProject
				&& ((IProject)e1).getName().equals(OsateResourceUtil.PLUGIN_RESOURCES_DIRECTORY_NAME)) {
			return 1;
		} else if(e2 instanceof IProject
				&& ((IProject)e2).getName().equals(OsateResourceUtil.PLUGIN_RESOURCES_DIRECTORY_NAME)) {
			return -1;
		} else {
			return super.compare(viewer, e1, e2);
		}

	}
}
