package org.osate.ui.navigator;

import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.model.WorkbenchContentProvider;

public class ViewerRefresher extends WorkbenchContentProvider {

	private Viewer viewer;

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		super.inputChanged(viewer, oldInput, newInput);

		this.viewer = viewer;
	}

	@Override
	protected void processDelta(IResourceDelta delta) {
		super.processDelta(delta);
		Display.getDefault().asyncExec(() -> {
			TreeViewer tv = (TreeViewer) viewer;
			Object[] expanded = tv.getExpandedElements();
			viewer.refresh();
			tv.setExpandedElements(expanded);
		});
	}

}
