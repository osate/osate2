package org.osate.search;

import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescriptionsProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

import com.google.inject.Inject;
import com.google.inject.Injector;

@SuppressWarnings("restriction")
public final class AadlFinder {
	@FunctionalInterface
	public interface Scope {
		public boolean contains(IResourceDescription rsrcDesc);
	}

	public static class ResourceSetScope implements Scope {
		private final URI[] uris;

		public ResourceSetScope(final Set<IResource> resources) {
			final URI[] temp = new URI[resources.size()];
			int i = 0;
			for (final IResource resource : resources) {
				temp[i++] = OsateResourceUtil.getResourceURI(resource);
			}
			this.uris = temp;
		}

		@Override
		public boolean contains(final IResourceDescription rsrcDesc) {
			for (final URI uri : uris) {
				if (isPrefixOf(uri, rsrcDesc.getURI())) {
					return true;
				}
			}
			return false;
		}

		/**
		 * A URI is a prefix of another URI if:
		 * <br/>
		 * <ul>
		 * 	<li>Both have the same scheme</li>
		 * 	<li>The segments of both URIs match up to the prefix's length</li>
		 * </ul>
		 */
		/*
		 * Took this from org.eclipse.emf.common.util.URI.UriUtil, but took out the check for the trailing separator on the
		 * prefix.
		 */
		private static boolean isPrefixOf(URI prefix, URI uri) {
			if (prefix.scheme() == null || !prefix.scheme().equals(uri.scheme())) {
				return false;
			}
			String[] prefixSeg = prefix.segments();
			String[] uriSeg = uri.segments();
			if (prefixSeg.length == 0 || uriSeg.length == 0) {
				return false;
			}
			if (uriSeg.length < prefixSeg.length) {
				return false;
			}
			for (int i = 0; i < prefixSeg.length; i++) {
				if (!uriSeg[i].equals(prefixSeg[i])) {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * Scope that contains the whole workspace.
	 */
	public static final Scope WORKSPACE_SCOPE = rsrcDesc -> true;

	/**
	 * The empty scope&mdash;contains nothing.
	 */
	public static final Scope EMPTY_SCOPE = rsrcDesc -> false;

	@FunctionalInterface
	public interface FinderConsumer<T> {
		public void found(ResourceSet resourceSet, T objDesc);
	}

	private static final AadlFinder instance = new AadlFinder();

	@Inject
	private IResourceDescriptionsProvider resourcesDescriptionProvider;

	@Inject
	private IReferenceFinder referenceFinder;

	private AadlFinder() {
		final Injector injector = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(URI.createFileURI("dummy.aadl")).get(Injector.class);
		injector.injectMembers(this);
	}

	public static AadlFinder getInstance() {
		return instance;
	}

	/**
	 * Get all the {@code EObject}s of the given type in the workspace.
	 */
	public void getAllObjectsOfTypeInWorkspace(final EClass eClass,
			final FinderConsumer<IEObjectDescription> consumer) {
		getAllObjectsOfType(eClass, WORKSPACE_SCOPE, consumer);
	}

	/**
	 * Get all the {@code EObject}s of the given type contained in the given scope.
	 */
	public void getAllObjectsOfType(final EClass eClass, final Scope scope,
			final FinderConsumer<IEObjectDescription> consumer) {
		final ResourceSet resourceSet = OsateResourceUtil.getResourceSet();
		final IResourceDescriptions resourceDescriptions = resourcesDescriptionProvider
				.getResourceDescriptions(resourceSet);
		for (final IResourceDescription rsrcDesc : resourceDescriptions.getAllResourceDescriptions()) {
			if (scope.contains(rsrcDesc)) {
				for (final IEObjectDescription objDesc : rsrcDesc.getExportedObjectsByType(eClass)) {
					consumer.found(resourceSet, objDesc);
				}
			}
		}
	}

	public void getAllReferencesToTypeInWorkspace(final FinderConsumer<IReferenceDescription> consumer) {
		getAllReferencesToType(WORKSPACE_SCOPE, consumer);
	}

	public void getAllReferencesToType(final Scope scope,
			final FinderConsumer<IReferenceDescription> consumer) {
		final ResourceSet resourceSet = OsateResourceUtil.getResourceSet();
		final IResourceDescriptions resourceDescriptions = resourcesDescriptionProvider
				.getResourceDescriptions(resourceSet);
		for (final IResourceDescription rsrcDesc : resourceDescriptions.getAllResourceDescriptions()) {
			if (scope.contains(rsrcDesc)) {
				final Resource rsrc = resourceSet.getResource(rsrcDesc.getURI(), true);
				referenceFinder.findAllReferences(rsrc, new IReferenceFinder.Acceptor() {
					@Override
					public void accept(final EObject source, final URI sourceURI, final EReference eReference,
							final int index, final EObject targetOrProxy, final URI targetURI) {
						accept(new DefaultReferenceDescription(sourceURI, targetURI, eReference, index, null));
					}

					@Override
					public void accept(final IReferenceDescription refDesc) {
						consumer.found(resourceSet, refDesc);
					}
				}, null);
			}
		}
	}
}
