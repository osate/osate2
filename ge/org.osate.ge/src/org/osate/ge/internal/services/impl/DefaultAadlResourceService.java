package org.osate.ge.internal.services.impl;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.LiveScopeResourceSetInitializer;
import org.osate.aadl2.AadlPackage;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.services.AadlResourceService;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;

import com.google.inject.Injector;

public class DefaultAadlResourceService implements AadlResourceService {
	public static class ContextFunction extends SimpleServiceContextFunction<AadlResourceService> {
		@Override
		public AadlResourceService createService(final IEclipseContext context) {
			return new DefaultAadlResourceService(context.get(ModelChangeNotifier.class));
		}

		@Override
		protected void deactivate() {
			// Dispose the service if it is valid
			final AadlResourceService service = getService();
			if (service instanceof DefaultAadlResourceService) {
				((DefaultAadlResourceService) service).dispose();
			}

			super.deactivate();
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
	private final Thread referenceCleanupThread;
	private final ModelChangeNotifier changeNotifier;

	private ModelChangeNotifier.ChangeListener changeListener = new ModelChangeNotifier.ChangeListener() {
		@Override
		public void resourceChanged(final URI resourceUri) {
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
					if (emfResource != null && Objects.equals(emfResource.getURI(), resourceUri)) {
						emfResource.unload();
					}
				}
			}
		}
	};

	// Runnable class intended to be used as a daemon thread for unloading resources once they are no longer referenced.
	private final Runnable referenceCleanupRunnable = (Runnable) () -> {
		while (Thread.currentThread().isInterrupted()) {
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
				Thread.currentThread().interrupt();
			}
		}
	};

	public DefaultAadlResourceService(final ModelChangeNotifier changeNotifier) {
		this.changeNotifier = Objects.requireNonNull(changeNotifier, "changeNotifier must not be null");

		// Use live scope
		final Injector injector = Aadl2Activator.getInstance().getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2);
		injector.getInstance(LiveScopeResourceSetInitializer.class).initialize(resourceSet);

		// Start the reference cleanup thread
		referenceCleanupThread = new Thread(referenceCleanupRunnable);
		referenceCleanupThread.setDaemon(true);
		referenceCleanupThread.start();

		// Register a resource change listener
		changeNotifier.addChangeListener(changeListener);
	}

	public void dispose() {
		resourceSet.getResources().clear();
		changeNotifier.removeChangeListener(changeListener);
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
}
