/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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
	private boolean hasChangesWhileUnlocked = false;

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

				if (currentLock == null) {
					hasChangesWhileUnlocked = true;
				}
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
				if (hasModelChanged) {
					if (currentLock == null) {
						hasChangesWhileUnlocked = true;
					}
				} else {
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
			if (currentLock == null) {
				hasChangesWhileUnlocked = true;
			}

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
				final boolean wasModelLocked = !hasChangesWhileUnlocked;

				// Reset flags
				pendingChangedResourceUris.clear();
				hasModelChanged = false;
				hasChangesWhileUnlocked = false;

				// Send notifications. Notifications are sent using the display thread so that all diagrams updates will take place in the main thread and avoid
				// updating the diagram while change notifications are being handled.
				Display.getDefault().asyncExec(() -> {
					// Send resource change notifications
					for (final URI resourceUri : changedResourceUrisBeingProcessed) {
						for (final ChangeListener listener : changeListeners) {
							listener.resourceChanged(resourceUri);
						}
					}

					// Send a single notification that the model has changed regardless of the number of changes
					if (hadModelChanged) {
						onModelChanged(wasModelLocked);
					}
				});
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

	private void onModelChanged(final boolean modelWasLocked) {
		// Send a model changed notification
		for(final ChangeListener listener : changeListeners) {
			listener.modelChanged(modelWasLocked);
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
