/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.search;

import java.util.Collection;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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

		public ResourceSetScope(final Set<? extends IResource> resources) {
			final URI[] temp = new URI[resources.size()];
			int i = 0;
			for (final IResource resource : resources) {
				temp[i++] = OsateResourceUtil.toResourceURI(resource);
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
		public void found(T objDesc);
	}

	/**
	 * @since 6.0
	 */
	@FunctionalInterface
	public interface FinderConsumerWithResourceSet<T> {
		public void found(ResourceSet resourceSet, T objDesc);
	}

	public static abstract class ResourceConsumer<T> {
		private ResourceSet resourceSet;

		protected final ResourceSet getResourceSet() {
			return resourceSet;
		}

		private void init(final ResourceSet resourceSet, final int count) {
			this.resourceSet = resourceSet;
			begin(count);
		}

		protected void begin(int count) {
		}

		protected void inScope(final T rsrcDesc) {
		}

		protected void skipped(final T rsrcDesc) {
		}

		protected void end() {
		}
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
	 * Get all the {@code EObject}s of the given type contained in the given scope.
	 */
	public void processAllAadlFilesInScope(final Scope scope, final ResourceConsumer<IResourceDescription> consumer) {
		final ResourceSet resourceSet = new ResourceSetImpl();
		final IResourceDescriptions resourceDescriptions = resourcesDescriptionProvider
				.getResourceDescriptions(resourceSet);

		int count = 0;
		for (@SuppressWarnings("unused")
		final IResourceDescription rsrcDesc : resourceDescriptions.getAllResourceDescriptions()) {
			count += 1;
		}
		consumer.init(resourceSet, count);
		try {
			for (final IResourceDescription rsrcDesc : resourceDescriptions.getAllResourceDescriptions()) {
				if (scope.contains(rsrcDesc)) {
					consumer.inScope(rsrcDesc);
				} else {
					consumer.skipped(rsrcDesc);
				}
			}
		} finally {
			consumer.end();
		}
	}

	@Deprecated
	public void getAllObjectsOfTypeInWorkspace(final EClass eClass,
			final FinderConsumer<IEObjectDescription> consumer) {
		getAllObjectsOfTypeInWorkspace(eClass, (rs, o) -> consumer.found(o));
	}

	/**
	 * Get all the {@code EObject}s of the given type in the workspace.
	 * @since 6.0
	 */
	public void getAllObjectsOfTypeInWorkspace(final EClass eClass,
			final FinderConsumerWithResourceSet<IEObjectDescription> consumer) {
		getAllObjectsOfTypeInScope(eClass, WORKSPACE_SCOPE, consumer);
	}

	@Deprecated
	public void getAllObjectsOfTypeInScope(final EClass eClass, final Scope scope,
			final FinderConsumer<IEObjectDescription> consumer) {
		getAllObjectsOfTypeInScope(eClass, scope, (rs, o) -> consumer.found(o));
	}

	/**
	 * Get all the {@code EObject}s of the given type contained in the given scope.
	 * @since 6.0
	 */
	public void getAllObjectsOfTypeInScope(final EClass eClass, final Scope scope,
			final FinderConsumerWithResourceSet<IEObjectDescription> consumer) {
		processAllAadlFilesInScope(scope, new ResourceConsumer<IResourceDescription>() {
			@Override
			protected void inScope(final IResourceDescription rsrcDesc) {
				getAllObjectsOfTypeInResource(rsrcDesc, eClass, getResourceSet(), consumer);
			}
		});
	}

	@Deprecated
	public void getAllObjectsOfTypeInCollection(final EClass eClass, final Collection<IFile> fileSet,
			final FinderConsumer<IEObjectDescription> consumer) {
		getAllObjectsOfTypeInCollection(eClass, fileSet, (rs, o) -> consumer.found(o));
	}

	/**
	 * @since 6.0
	 */
	public void getAllObjectsOfTypeInCollection(final EClass eClass, final Collection<IFile> fileSet,
			final FinderConsumerWithResourceSet<IEObjectDescription> consumer) {
		final ResourceSet resourceSet = new ResourceSetImpl();
		final IResourceDescriptions resourceDescriptions = resourcesDescriptionProvider
				.getResourceDescriptions(resourceSet);
		for (final IFile file : fileSet) {
			final IResourceDescription rsrcDesc = resourceDescriptions
					.getResourceDescription(OsateResourceUtil.toResourceURI(file));
			getAllObjectsOfTypeInResource(rsrcDesc, eClass, resourceSet, consumer);
		}
	}

	@Deprecated
	public void getAllObjectsOfTypeInResource(final IResourceDescription rsrcDesc,
			final EClass eClass, final FinderConsumer<IEObjectDescription> consumer) {
		getAllObjectsOfTypeInResource(rsrcDesc, eClass, new ResourceSetImpl(), (rs, o) -> consumer.found(o));
	}

	/**
	 * @since 6.0
	 */
	public void getAllObjectsOfTypeInResource(final IResourceDescription rsrcDesc, final EClass eClass,
			final ResourceSet resourceSet, final FinderConsumerWithResourceSet<IEObjectDescription> consumer) {
		for (final IEObjectDescription objDesc : rsrcDesc.getExportedObjectsByType(eClass)) {
			consumer.found(resourceSet, objDesc);
		}
	}

	@Deprecated
	public void getAllReferencesToTypeInWorkspace(final FinderConsumer<IReferenceDescription> consumer) {
		getAllReferencesToTypeInWorkspace((rs, o) -> consumer.found(o), null);
	}

	/**
	 * @param progressMonitor May be {@code null}.
	 * @since 6.0
	 */
	public void getAllReferencesToTypeInWorkspace(final FinderConsumerWithResourceSet<IReferenceDescription> consumer,
			final IProgressMonitor progressMonitor) {
		getAllReferencesToTypeInScope(WORKSPACE_SCOPE, consumer, progressMonitor);
	}

	@Deprecated
	public void getAllReferencesToTypeInWorkspace(final ResourceConsumer<IResourceDescription> rsrcConsumer,
			final FinderConsumer<IReferenceDescription> consumer) {
		getAllReferencesToTypeInWorkspace(rsrcConsumer, (rs, o) -> consumer.found(o), null);
	}

	/**
	 * @param progressMonitor May be {@code null}.
	 * @since 6.0
	 */
	public void getAllReferencesToTypeInWorkspace(final ResourceConsumer<IResourceDescription> rsrcConsumer,
			final FinderConsumerWithResourceSet<IReferenceDescription> consumer,
			final IProgressMonitor progressMonitor) {
		getAllReferencesToTypeInScope(WORKSPACE_SCOPE, rsrcConsumer, consumer, progressMonitor);
	}

	@Deprecated
	public void getAllReferencesToTypeInScope(final Scope scope,
			final ResourceConsumer<IResourceDescription> rsrcConsumer,
			final FinderConsumer<IReferenceDescription> consumer) {
		getAllReferencesToTypeInScope(scope, rsrcConsumer, (rs, o) -> consumer.found(o), null);
	}

	/**
	 * @param progressMonitor May be {@code null}.
	 * @since 6.0
	 */
	public void getAllReferencesToTypeInScope(final Scope scope,
			final ResourceConsumer<IResourceDescription> rsrcConsumer,
			final FinderConsumerWithResourceSet<IReferenceDescription> consumer,
			final IProgressMonitor progressMonitor) {
		processAllAadlFilesInScope(scope, new ResourceConsumer<IResourceDescription>() {
			@Override
			protected void begin(int count) {
				rsrcConsumer.begin(count);
			}

			@Override
			protected void inScope(final IResourceDescription rsrcDesc) {
				getAllReferencesToTypeInResource(rsrcDesc, getResourceSet(), consumer, progressMonitor);
				rsrcConsumer.inScope(rsrcDesc);
			}

			@Override
			protected void skipped(final IResourceDescription rsrcDesc) {
				rsrcConsumer.skipped(rsrcDesc);
			}

			@Override
			protected void end() {
				rsrcConsumer.end();
			}
		});
	}

	@Deprecated
	public void getAllReferencesToTypeInScope(final Scope scope, final FinderConsumer<IReferenceDescription> consumer) {
		getAllReferencesToTypeInScope(scope, (rs, o) -> consumer.found(o), null);
	}

	/**
	 * @param progressMonitor May be {@code null}.
	 * @since 6.0
	 */
	public void getAllReferencesToTypeInScope(final Scope scope,
			final FinderConsumerWithResourceSet<IReferenceDescription> consumer,
			IProgressMonitor progressMonitor) {
		processAllAadlFilesInScope(scope, new ResourceConsumer<IResourceDescription>() {
			@Override
			protected void inScope(final IResourceDescription rsrcDesc) {
				getAllReferencesToTypeInResource(rsrcDesc, getResourceSet(), consumer, progressMonitor);
			}
		});
	}

	@Deprecated
	public void getAllReferencesToTypeInResource(final IResourceDescription rsrcDesc, final ResourceSet resourceSet,
			final FinderConsumer<IReferenceDescription> consumer) {
		getAllReferencesToTypeInResource(rsrcDesc, resourceSet, (rs, o) -> consumer.found(o), null);
	}

	/**
	 * @param progressMonitor May be {@code null}.
	 * @since 6.0
	 */
	public void getAllReferencesToTypeInResource(final IResourceDescription rsrcDesc, final ResourceSet resourceSet,
			final FinderConsumerWithResourceSet<IReferenceDescription> consumer,
			final IProgressMonitor progressMonitor) {
		final Resource rsrc = resourceSet.getResource(rsrcDesc.getURI(), true);
		referenceFinder.findAllReferences(rsrc, new IReferenceFinder.Acceptor() {
			@Override
			public void accept(final EObject source, final URI sourceURI, final EReference eReference, final int index,
					final EObject targetOrProxy, final URI targetURI) {
				accept(new DefaultReferenceDescription(sourceURI, targetURI, eReference, index, null));
			}

			@Override
			public void accept(final IReferenceDescription refDesc) {
				consumer.found(resourceSet, refDesc);
			}
		}, progressMonitor);
	}
}
