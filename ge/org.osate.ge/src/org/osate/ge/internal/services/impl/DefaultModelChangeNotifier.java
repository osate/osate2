package org.osate.ge.internal.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.ui.xtext.AgeXtextUtil;

public class DefaultModelChangeNotifier implements ModelChangeNotifier {
	private ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
	private final List<ChangeListener> changeListeners = new CopyOnWriteArrayList<>();
	private final List<IResourceChangeListener> childResourceChangeListeners = new CopyOnWriteArrayList<>();

	public static class ContextFunction extends SimpleServiceContextFunction<ModelChangeNotifier> {
		@Override
		public  ModelChangeNotifier createService(final IEclipseContext context) {
			return new DefaultModelChangeNotifier();
		}
	}

	private static class ResourceDeltaVisitor implements IResourceDeltaVisitor {
		public boolean hasModelChanged = false;

		@Override
		public boolean visit(final IResourceDelta delta) {
			// Invalidate cache if AADL files are changed or changes to projects besides changes.
			// Don't notify of AADL file changes if the xtext document is open. Wait until the xtext document modification notification.
			final IResource resource = delta.getResource();
			if ((resource.getType() == IResource.PROJECT && delta.getKind() != IResourceDelta.CHANGED) ||
					(resource.getType() == IResource.FILE && "aadl".equalsIgnoreCase(resource.getFileExtension()) && AgeXtextUtil.getOpenXtextResource(resource) == null)) {
				hasModelChanged = true;
			}

			return !hasModelChanged;
		}

		// Resets the flag which indicate whether a change occurred.
		void reset() {
			hasModelChanged = false;
		}
	};

	private final IResourceChangeListener resourceChangeListener = event -> {
		// Notify other resource listeners before processing the resource listener
		for(final IResourceChangeListener childListener : childResourceChangeListeners) {
			childListener.resourceChanged(event);
		}

		final IResourceDelta delta = event.getDelta();
		if(delta != null) {
			try {
				visitor.reset();
				delta.accept(visitor);

				// Send a single notification that the model has changed regardless of the number of changes
				if(visitor.hasModelChanged) {
					onModelChanged();
				}
			} catch (CoreException e) {
			}
		}
	};

	private IXtextModelListener xtextModelListener = resource -> {
		if (resource.getURI() == null) {
			return;
		}

		final String platformString = resource.getURI().toPlatformString(true);
		if(platformString == null) {
			return;
		}

		if (platformString.toLowerCase().endsWith(".aadl")) {
			// Invalidate the cache
			onModelChanged();
		}
	};

	public DefaultModelChangeNotifier() {
		// Register a resource change listener
		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		workspace.addResourceChangeListener(resourceChangeListener, IResourceChangeEvent.POST_BUILD);

		// Listen for xtext model changes
		AgeXtextUtil.addModelListener(xtextModelListener);
	}

	public void dispose() {
		// Stop listening for xtext model changes
		AgeXtextUtil.removeModelListener(xtextModelListener);

		// Remove the resource change listener
		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		workspace.removeResourceChangeListener(resourceChangeListener);
	}

	private void onModelChanged() {
		// Send a model changed notification
		for(final ChangeListener listener : changeListeners) {
			listener.modelChanged();
		}

		// Send an after model changed notification
		for(final ChangeListener listener : changeListeners) {
			listener.afterModelChangeNotification();
		}
	}

	@Override
	public void addChangeListener(final ChangeListener listener) {
		changeListeners.add(Objects.requireNonNull(listener, "listener must not be null"));
	}

	@Override
	public void removeChangeListener(final ChangeListener listener) {
		changeListeners.remove(Objects.requireNonNull(listener, "listener must not be null"));
	}

	@Override
	public void addResourceChangeListener(final IResourceChangeListener listener) {
		childResourceChangeListeners.add(listener);
	}

	@Override
	public void removeResourceChangeListener(final IResourceChangeListener listener) {
		childResourceChangeListeners.remove(listener);
	}
}
