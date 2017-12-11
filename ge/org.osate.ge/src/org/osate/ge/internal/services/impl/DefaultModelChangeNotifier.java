package org.osate.ge.internal.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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
import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.widgets.Display;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.ui.xtext.AgeXtextUtil;
import org.osate.ge.internal.ui.xtext.XtextDocumentChangeListener;

public class DefaultModelChangeNotifier implements ModelChangeNotifier {
	private final ProjectDeltaVisitor projectVisitor = new ProjectDeltaVisitor();
	private final AadlResourceUriCollectorVisitor resourceUriCollectorVisitor = new AadlResourceUriCollectorVisitor();
	private final List<ChangeListener> changeListeners = new CopyOnWriteArrayList<>();
	private Lock currentLock;
	private final Set<URI> pendingChangedResourceUris = new HashSet<>();
	private boolean hasModelChanged = false;

	public static class ContextFunction extends SimpleServiceContextFunction<ModelChangeNotifier> {
		@Override
		public  ModelChangeNotifier createService(final IEclipseContext context) {
			return new DefaultModelChangeNotifier();
		}

		@Override
		protected void deactivate() {
			// Dispose the service if it is valid
			final ModelChangeNotifier service = getService();
			if (service instanceof DefaultModelChangeNotifier) {
				((DefaultModelChangeNotifier) service).dispose();
			}

			super.deactivate();
		}
	}

	// Marks model has changed if a notification affects a project.
	private class ProjectDeltaVisitor implements IResourceDeltaVisitor {
		@Override
		public boolean visit(final IResourceDelta delta) {
			final IResource resource = delta.getResource();

			// Trigger a change if the project itself has changed
			if (resource.getType() == IResource.PROJECT && (delta.getKind() != IResourceDelta.CHANGED
					|| (delta.getKind() == IResourceDelta.CHANGED && delta.getFlags() != 0))) {
				hasModelChanged = true;
			}

			return resource.getType() == IResource.ROOT && !hasModelChanged;
		}
	};

	private class AadlResourceUriCollectorVisitor implements IResourceDeltaVisitor {
		@Override
		public boolean visit(final IResourceDelta delta) {
			final IResource resource = delta.getResource();
			// aadlbin changes indicate an AADL file has been (re)built.
			if (resource.getType() == IResource.FILE && ("aadl".equalsIgnoreCase(resource.getFileExtension())
					|| "aadlbin".equalsIgnoreCase(resource.getFileExtension()))) {
				final URI resourceUri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
				pendingChangedResourceUris.add(resourceUri);
				return false;
			}

			return true;
		}
	};

	private final IResourceChangeListener resourceChangeListener = event -> {
		final IResourceDelta delta = event.getDelta();
		if(delta != null) {
			try {
				delta.accept(resourceUriCollectorVisitor);

				hasModelChanged = hasModelChanged || pendingChangedResourceUris.size() > 0;
				if (!hasModelChanged) {
					delta.accept(projectVisitor);
				}
			} catch (final CoreException e) {
				// Ignore. No reasonable way to handle.
				e.printStackTrace();
			}

			Display.getDefault().syncExec(() -> {
				handleNotifications();
			});
		}
	};

	private XtextDocumentChangeListener xtextModelListener = resourceUri -> {
		if (resourceUri == null) {
			return;
		}

		final String platformString = resourceUri.toPlatformString(true);
		if (platformString == null) {
			return;
		}

		if (platformString.toLowerCase().endsWith(".aadl")) {
			pendingChangedResourceUris.add(resourceUri);
			hasModelChanged = true;

			handleNotifications();
		}
	};

	// Checks notifications. If there is a lock then it does nothing. Change notifications will wait until the lock is closed. If there isn't a lock, it
	// notifies listeners of changes that are pending.
	private synchronized void handleNotifications() {
		if (currentLock == null) {
			if (pendingChangedResourceUris.size() > 0 || hasModelChanged) {
				// Make copy of the flags so that recursive calls to handle notifications will not trigger an update for the same resources
				final List<URI> changedResourceUrisBeingProcessed = new ArrayList<>(pendingChangedResourceUris);
				final boolean hadModelChanged = hasModelChanged;

				// Reset flags
				pendingChangedResourceUris.clear();
				hasModelChanged = false;

				// Send notifications
				// Send resource change notifications
				for (final URI resourceUri : changedResourceUrisBeingProcessed) {
					for (final ChangeListener listener : changeListeners) {
						listener.resourceChanged(resourceUri);
					}
				}

				// Send a single notification that the model has changed regardless of the number of changes
				if (hadModelChanged) {
					onModelChanged();
				}
			}
		}
	}

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
	public synchronized Lock lock() {
		if(currentLock != null) {
			throw new RuntimeException("Already locked");
		}

		// Create a new lock
		currentLock = new Lock() {
			@Override
			public void close() {
				synchronized (DefaultModelChangeNotifier.this) {
					if (currentLock != this) {
						throw new RuntimeException("Not the current lock");
					}

					currentLock = null;

					// Send pending notifications
					handleNotifications();
				}
			}

		};

		return currentLock;
	}
}
