package org.osate.ge.internal.ui.navigator;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.navigator.CommonNavigator;
import org.osate.ge.internal.ui.util.ContextHelpUtil;
import org.osate.ge.internal.util.DiagramUtil;

public class DiagramsView extends CommonNavigator {
	private final IResourceChangeListener resourceChangeListener = event -> {
		if (event.getDelta() != null) {
			// Refresh the view when resource changes are made
			final Control ctrl = getCommonViewer().getControl();
			if (ctrl != null && !ctrl.isDisposed()) {
				// Refresh the viewer if the change could affect it.
				if (needsRefresh(event.getDelta())) {
					ctrl.getDisplay().asyncExec(() -> getCommonViewer().refresh());
				}
			}
		}
	};

	private boolean needsRefresh(final IResourceDelta delta) {
		// Refresh if a container was added or removed.
		if (delta.getResource() instanceof IContainer
				&& ((delta.getKind() & IResourceDelta.ADDED) != 0 || (delta.getKind() & IResourceDelta.REMOVED) != 0)) {
			return true;
		}

		// Refresh if the change affected a diagram file.
		if (delta.getResource() instanceof IFile
				&& DiagramUtil.isDiagram((IFile) delta.getResource())) {
			return true;
		}

		// Check children
		for (final IResourceDelta child : delta.getAffectedChildren()) {
			if (needsRefresh(child)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		ContextHelpUtil.setHelp(getCommonViewer().getControl(), ContextHelpUtil.AADL_DIAGRAMS_VIEW);
		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener);
	}

	@Override
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);
		super.dispose();
	}
}
