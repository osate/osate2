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
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.LiveScopeResourceSetInitializer;
import org.osate.aadl2.AadlPackage;
import org.osate.ge.internal.services.AadlResourceService;
import org.osate.ge.internal.services.ModelChangeNotifier;
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
				EObject eobj = null;
				try {
					eobj = resourceSet.getEObject(elementUri, true);
				} catch (final RuntimeException ex) {
					// Unable to load resource
					// Ignore the exception. The null EObject will reset the resource.
				}

				if (eobj instanceof AadlPackage) {
					pkg = (AadlPackage) eobj;
					weakRef.resource = pkg.eResource();
				} else {
					weakRef.resource = null;
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
	private final TransactionalEditingDomain editingDomain;
	private final Map<URI, WeakPackageReference> elementUriToAadlPackageReference = new HashMap<>();
	private final ReferenceQueue<SimpleAadlPackageReference> collectedAadlPkgReferenceQueue = new ReferenceQueue<>();
	private final Thread referenceCleanupThread;
	private final ModelChangeNotifier changeNotifier;

	private ModelChangeNotifier.ChangeListener changeListener = new ModelChangeNotifier.ChangeListener() {
		@Override
		public void resourceChanged(final URI resourceUri) {
			// Closing the resource immediate can cause problems if something is accessing the resource.
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

		// Create the editing domain
		editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resourceSet);

		// Start the reference cleanup thread
		referenceCleanupThread = new Thread(referenceCleanupRunnable);
		referenceCleanupThread.setDaemon(true);
		referenceCleanupThread.start();

		// Register a resource change listener
		changeNotifier.addChangeListener(changeListener);
	}

	public void dispose() {
		editingDomain.dispose();
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
