package org.osate.ge.internal.services.impl;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.osate.aadl2.AadlPackage;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.services.SavedAadlResourceService;

public class DefaultSavedAadlResourceService implements SavedAadlResourceService {
	public static class ContextFunction extends SimpleServiceContextFunction<SavedAadlResourceService> {
		@Override
		public SavedAadlResourceService createService(final IEclipseContext context) {
			return new DefaultSavedAadlResourceService(context.get(ModelChangeNotifier.class));
		}
	}

	private class SimpleAadlPackageReference implements AadlPackageReference {
		private final URI elementUri;
		private AadlPackage pkg = null;

		public SimpleAadlPackageReference(final URI elementUri) {
			this.elementUri = elementUri;
		}

		@Override
		public AadlPackage getAadlPackage() {
			if (pkg == null) {
				final WeakPackageReference weakRef = getWeakReference();
				final EObject eobj = resourceSet.getEObject(elementUri, true);
				if (eobj instanceof AadlPackage) {
					pkg = (AadlPackage) eobj;
					weakRef.resource = pkg.eResource();
				}
			}

			return pkg;
		}

		private WeakPackageReference getWeakReference() {
			// Find the weak reference for the this object
			for (final WeakPackageReference weakRef : elementUriToAadlPackageReference.values()) {
				if (weakRef.get() == this) {
					return weakRef;
				}
			}

			throw new RuntimeException("Unable to retrieve weak package reference");
		}
	}

	private class WeakPackageReference extends WeakReference<SimpleAadlPackageReference> {
		private Resource resource = null;

		public WeakPackageReference(final SimpleAadlPackageReference referent,
				final ReferenceQueue<? super SimpleAadlPackageReference> q) {
			super(referent, q);
		}

		public void unloadResource() {
			if (resource != null) {
				resource.unload();
				resource = null;
			}
		}
	}

	private final XtextResourceSet resourceSet = new XtextResourceSet();
	private final Map<URI, WeakPackageReference> elementUriToAadlPackageReference = new HashMap<>();
	private final ReferenceQueue<SimpleAadlPackageReference> collectedAadlPkgReferenceQueue = new ReferenceQueue<>();
	private final Map<URI, Long> resourceUriToModificationStamp = new HashMap<>(); // Value will be null if a modification is in progress.

	private IResourceDeltaVisitor visitor = delta -> {
		// If the resource's contents has changed changed
		if (delta.getKind() != IResourceDelta.CHANGED || (delta.getFlags() & IResourceDelta.CONTENT) == 0) {
			return true;
		}

		// Check AADL files
		final IResource iResource = delta.getResource();
		if (iResource.getType() == IResource.FILE && "aadl".equalsIgnoreCase(iResource.getFileExtension())) {
			final URI resourceUri = URI.createPlatformResourceURI(iResource.getFullPath().toString(), true);
			final boolean upToDate;
			if (resourceUriToModificationStamp.containsKey(resourceUri)) {
				final Long storedStamp = resourceUriToModificationStamp.get(resourceUri);
				upToDate = storedStamp == null || iResource.getModificationStamp() == storedStamp.longValue();
			} else {
				upToDate = false;
			}

			// Don't unload the resource is being saved by the editor
			if (!upToDate) {
				boolean resourceUnloaded = false;
				for (final WeakPackageReference weakRef : elementUriToAadlPackageReference.values()) {
					final SimpleAadlPackageReference pkgRef = weakRef.get();
					if (pkgRef != null && pkgRef.pkg != null && weakRef.resource != null
							&& weakRef.resource.getURI().equals(resourceUri)) {
						weakRef.unloadResource();

						// Remove the reference to the package
						pkgRef.pkg = null;

						resourceUnloaded = true;
					}
				}

				// Check if the resource has been loaded indirectly and unload it
				if (!resourceUnloaded) {
					for (final Resource emfResource : resourceSet.getResources()) {
						if (emfResource != null
								&& (emfResource.getURI() == null || emfResource.getURI().equals(resourceUri))) {
							emfResource.unload();
						}
					}
				}

			}
		}

		return true;
	};

	private final IResourceChangeListener resourceChangeListener = event -> {
		final IResourceDelta delta = event.getDelta();
		if (delta != null) {
			try {
				delta.accept(visitor);
			} catch (CoreException e) {
			}
		}
	};

	// Thread class intended to be used as a daemon thread for unloading resources once they are no longer referenced.
	private final Thread referenceCleanupThread = new Thread() {
		@Override
		public void run() {
			while (true) {
				try {
					final WeakPackageReference weakRef = (WeakPackageReference) collectedAadlPkgReferenceQueue.remove();
					weakRef.unloadResource();
					elementUriToAadlPackageReference.values().removeAll(Collections.singleton(weakRef));

					// Clear all resources if there aren't any active Aadl package references.
					// Needed to clear resources which may have been added to the resource set indirectly
					if (elementUriToAadlPackageReference.size() == 0) {
						resourceSet.getResources().clear();
					}
				} catch (final InterruptedException e) {
					interrupt();
				}
			}
		}
	};

	public DefaultSavedAadlResourceService(final ModelChangeNotifier changeNotifier) {
		Objects.requireNonNull(changeNotifier, "changeNotifier must not be null");

		// Start the reference cleanup thread
		referenceCleanupThread.setDaemon(true);
		referenceCleanupThread.start();

		// Register a resource change listener
		changeNotifier.addResourceChangeListener(resourceChangeListener);
	}

	@Override
	public AadlPackageReference getPackageReference(final URI elementUri) {
		// Return existing reference if it exists
		final WeakPackageReference weakPkgRef = elementUriToAadlPackageReference.get(elementUri);
		if (weakPkgRef != null) {
			final AadlPackageReference pkgRef = weakPkgRef.get();
			if (pkgRef != null) {
				return pkgRef;
			}
		}
		// Create a reference object for the package
		final SimpleAadlPackageReference pkgReference = new SimpleAadlPackageReference(elementUri);

		// Store a weak reference so that it can be updated as needed
		elementUriToAadlPackageReference.put(elementUri,
				new WeakPackageReference(pkgReference, collectedAadlPkgReferenceQueue));

		final AadlPackage pkg = pkgReference.getAadlPackage();
		if (pkg == null) {
			return null;
		}

		return pkgReference;
	}

	@Override
	public void setSaveInProgress(final Resource resource, boolean value) {
		final URI resourceUri = resource.getURI();
		if (value) {
			resourceUriToModificationStamp.putIfAbsent(resourceUri, null);
		} else {
			resourceUriToModificationStamp.remove(resourceUri, null);
		}
	}

	@Override
	public void markAsSaved(final Resource resource) {
		final URI resourceUri = resource.getURI();
		if (resourceUri == null) {
			return;
		}

		final IWorkspace ws = ResourcesPlugin.getWorkspace();
		if (ws == null) {
			return;
		}

		final IWorkspaceRoot rootResource = ws.getRoot();
		if (rootResource == null) {
			return;
		}

		final IResource ires = rootResource.getFile(new Path(resourceUri.toPlatformString(true)));
		if (ires == null) {
			return;
		}

		resourceUriToModificationStamp.put(resourceUri, ires.getModificationStamp());
	}
}
