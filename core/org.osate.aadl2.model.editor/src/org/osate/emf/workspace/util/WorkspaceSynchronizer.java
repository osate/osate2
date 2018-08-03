/**
 * <copyright>
 *
 * Copyright (c) 2005, 2011 IBM Corporation, Zeligsoft Inc. and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Geoff Martin - Fix deletion of resource that has markers
 *   Zeligsoft - Bug 233004
 *   Christian Vogt - Bug 235634
 *   Mariot Chauvin - Bug 351813
 *   Martin Fluegge - Bug 333690
 *
 * </copyright>
 *
 * $Id: WorkspaceSynchronizer.java,v 1.13 2011/08/23 22:08:39 ahunter Exp $
 */
package org.osate.emf.workspace.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceRuleFactory;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.MultiRule;
import org.eclipse.emf.common.archive.ArchiveURLConnection;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.internal.EMFWorkspacePlugin;
import org.eclipse.emf.workspace.internal.Tracing;
import org.eclipse.emf.workspace.internal.l10n.Messages;

/**
 * A utility object that listens to workspace resource changes to synchronize
 * the state of an EMF resource set with the workspace.
 * <p>
 * The default behaviour
 * on workspace resource deletions is to unload the corresponding EMF resource.
 * The default behaviour on resource changes is to unload and reload the
 * corresponding EMF resource, unless the resource path has changed (by move
 * or rename), in which case it is simply unloaded.
 * </p>
 * <p>
 * To customize the behaviour of the synchronizer, initialize it with a
 * {@link WorkspaceSynchronizer.Delegate delegate} that provides the required
 * behaviour.  For example, it might be more user-friendly to prompt the user
 * before taking drastic measures.
 * </p>
 * <p>
 * Whether implemented by a delegate or not, the synchronization algorithm is
 * invoked asynchronously (as a job) and in a read-only transaction on the
 * synchronizer's editing domain.  This ensures timely completion of the
 * workspace's event dispatching and exclusive access to the resource set
 * according to the transaction protocol.  Also, the job is scheduled on the
 * workspace rule, so that the delegate call-backs are free to read or modify
 * any resources that they may need.
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("restriction")
public final class WorkspaceSynchronizer {
	private final TransactionalEditingDomain domain;
	private Delegate delegate;

	// we employ a copy-on-write strategy on this collection for thread safety
	private static Collection<WorkspaceSynchronizer> synchronizers = new java.util.ArrayList<WorkspaceSynchronizer>();

	// we use a single listener to serve all synchronizers.
	private static IResourceChangeListener workspaceListener = new WorkspaceListener();

	// the default synchronization strategies
	static Delegate defaultDelegate = new DefaultDelegate();

	/**
	 * Initializes me with the editing domain for which I synchronize resources,
	 * using the default change-handling behaviour.
	 * <p>
	 * I immediately start listening for workspace resource changes.
	 * </p>
	 * 
	 * @param domain my domain (must not be <code>null</code>)
	 */
	public WorkspaceSynchronizer(TransactionalEditingDomain domain) {
		this(domain, null);
	}

	/**
	 * Initializes me with the editing domain for which I synchronize resources,
	 * using the specified delegate to handle resource changes.
	 * <p>
	 * I immediately start listening for workspace resource changes.
	 * </p>
	 * 
	 * @param domain my domain (must not be <code>null</code>)
	 * @param delegate the delegate that handles my resource changes, or
	 *     <code>null</code> to get the default behaviour
	 */
	public WorkspaceSynchronizer(TransactionalEditingDomain domain, Delegate delegate) {
		if (domain == null) {
			throw new IllegalArgumentException("null domain"); //$NON-NLS-1$
		}

		if (delegate == null) {
			delegate = defaultDelegate;
		}

		this.domain = domain;
		this.delegate = delegate;

		startListening(this);
	}

	/**
	 * Queries the editing domain whose resources I synchronize with the
	 * workspace.
	 * 
	 * @return my editing domain
	 */
	public TransactionalEditingDomain getEditingDomain() {
		return domain;
	}

	/**
	 * Obtains the delegate that handles resource changes.
	 * 
	 * @return my delegate
	 */
	Delegate getDelegate() {
		return delegate;
	}

	/**
	 * Disposes me, in particular disconnecting me from the workspace so that
	 * I no longer respond to resource change events.
	 */
	public void dispose() {
		stopListening(this);

		synchronized (this) {
			if (!isDisposed()) {
				delegate.dispose();
				delegate = null;
			}
		}
	}

	/**
	 * Queries whether I am disposed already.
	 * 
	 * @return whether I am disposed
	 * 
	 * @since 1.2.1
	 */
	boolean isDisposed() {
		return delegate == null;
	}

	/**
	 * Processes a resource delta to determine whether it corresponds to a
	 * resource in my editing domain and, if so, how to handle removal or
	 * change of that resource.
	 * 
	 * @param delta the resource change
	 * @param synchRequests accumulates synch requests for the deltas
	 * @param affectedFiles accumulates the files affected by the deltas
	 */
	void processDelta(IResourceDelta delta, List<SynchRequest> synchRequests, List<IFile> affectedFiles) {
		String fullPath = delta.getFullPath().toString();
		URI uri = URI.createPlatformResourceURI(fullPath, false);
		ResourceSet rset = getEditingDomain().getResourceSet();

		// try the unencoded URI first, in case the client doesn't encode
		Resource resource = rset.getResource(uri, false);
		if (resource == null) {
			URI encodedURI = URI.createPlatformResourceURI(fullPath, true);
			if (!encodedURI.equals(uri)) {
				// the URI needs to be encoded. Try it, then
				uri = encodedURI;
				resource = rset.getResource(uri, false);
			}
		}

		if ((resource != null) && resource.isLoaded()) {
			switch (delta.getKind()) {
			case IResourceDelta.ADDED:
				if ((delta.getFlags() & IResourceDelta.MOVED_FROM) != 0) {
					affectedFiles.add((IFile) delta.getResource());
				}
				break;
			case IResourceDelta.REMOVED:
				if ((delta.getFlags() & IResourceDelta.MOVED_TO) != 0) {
					// first, see whether a resource with the new URI already
					// exists. If so, then we will use the same URI (whether
					// encoded or not) because that seems to be what the
					// client prefers. Otherwise, always encode
					String newPath = delta.getMovedToPath().toString();
					URI newURI = URI.createPlatformResourceURI(newPath, false);
					if (rset.getResource(newURI, false) == null) {
						// this may be the same, depending on absence of
						// special characters
						newURI = URI.createPlatformResourceURI(newPath, true);
					}

					synchRequests.add(new MovedSynchRequest(this, resource, newURI));
				} else {
					synchRequests.add(new DeletedSynchRequest(this, resource));
				}

				break;
			case IResourceDelta.CHANGED:
				if ((delta.getFlags() & IResourceDelta.MARKERS) != 0) {
					synchRequests.add(new MarkerSynchRequest(this, resource, (IFile) delta.getResource()));
				}
				if ((delta.getFlags() & IResourceDelta.CONTENT) != 0) {
					synchRequests.add(new ChangedSynchRequest(this, resource));
				}
				affectedFiles.add((IFile) delta.getResource());
				break;
			}
		}
	}

	/**
	 * Obtains the workspace file corresponding to the specified resource, if
	 * it has a platform-resource URI.  Note that the resulting file, if not
	 * <code>null</code>, may nonetheless not actually exist (as the file is
	 * just a handle).
	 * <p>
	 * Note that, if the <tt>resource</tt> is in an archive (such as a ZIP file)
	 * then it does not map to a workspace file.  In this case, however, the
	 * workspace file (if any) corresponding to the containing archive can be
	 * obtained via the {@link #getUnderlyingFile(Resource)} method.
	 * </p>
	 * 
	 * @param resource an EMF resource
	 * 
	 * @return the corresponding workspace file, or <code>null</code> if the
	 *    resource's URI is not a platform-resource URI
	 *    
	 * @see #getUnderlyingFile(Resource)
	 */
	public static IFile getFile(Resource resource) {
		if (resource == null) {
			return null;
		}
		ResourceSet rset = resource.getResourceSet();

		return getFile(resource.getURI(), (rset != null) ? rset.getURIConverter() : null, false);
	}

	/**
	 * Obtains the workspace file underlying the specified resource.
	 * If the resource has an {@link URI#isArchive() archive} scheme, the
	 * {@linkplain URI#authority() authority} is considered instead.
	 * If the URI has a file scheme, it's looked up in the workspace, just as
	 * in the {@link #getFile(Resource)} method.
	 * Otherwise, a platform scheme is assumed.
	 * <p>
	 * Note that the resulting file, if not
	 * <code>null</code>, may nonetheless not actually exist (as the file is
	 * just a handle).
	 * </p>
	 * 
	 * @param resource an EMF resource
	 * 
	 * @return the underlying workspace file, or <code>null</code> if the
	 *    resource's URI is not a platform-resource URI
	 * 
	 * @see #getFile(Resource)
	 * @since 1.2
	 */
	public static IFile getUnderlyingFile(Resource resource) {
		ResourceSet rset = resource.getResourceSet();

		return getFile(resource.getURI(), (rset != null) ? rset.getURIConverter() : null, true);
	}

	/**
	 * Finds the file corresponding to the specified URI, using a URI converter
	 * if necessary (and provided) to normalize it.
	 * 
	 * @param uri a URI
	 * @param converter an optional URI converter (may be <code>null</code>)
	 * 
	 * @return the file, if available in the workspace
	 */
	private static IFile getFile(URI uri, URIConverter converter, boolean considerArchives) {
		IFile result = null;

		if (considerArchives && uri.isArchive()) {
			class MyArchiveURLConnection extends ArchiveURLConnection {
				public MyArchiveURLConnection(String url) {
					super(url);
				}

				public String getNestedURI() {
					try {
						return getNestedURL();
					} catch (IOException exception) {
						return ""; //$NON-NLS-1$
					}
				}
			}
			MyArchiveURLConnection archiveURLConnection = new MyArchiveURLConnection(uri.toString());
			result = getFile(URI.createURI(archiveURLConnection.getNestedURI()), converter, considerArchives);
		} else if (uri.isPlatformPlugin()) {
			/* resource with platform plug-in URI could not be in the workspace */
			return result;
		} else if (uri.isPlatformResource()) {
			IPath path = new Path(uri.toPlatformString(true));
			result = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		} else if (uri.isFile() && !uri.isRelative()) {
			result = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(uri.toFileString()));
		} else {
			// normalize, to see whether may we can resolve it this time
			if (converter != null) {
				URI normalized = converter.normalize(uri);

				if (!uri.equals(normalized)) {
					// recurse on the new URI
					result = getFile(normalized, converter, considerArchives);
				}
			}
		}

		if ((result == null) && !uri.isRelative()) {
			try {
				java.net.URI location = new java.net.URI(uri.toString());

				if (hasRegisteredEFS(location)) {
					IFile[] files = ResourcesPlugin.getWorkspace().getRoot()
							.findFilesForLocationURI(new java.net.URI(uri.toString()));
					if (files.length > 0) {
						// set the result to be the first file found
						result = files[0];
					}
				}
			} catch (URISyntaxException e) {
				// won't get this because EMF provides a well-formed URI
			}
		}

		return result;
	}

	private static boolean hasRegisteredEFS(java.net.URI location) {
		try {
			if (EFS.getStore(location) != null) {
				return true;
			}
		} catch (CoreException ex) {

			return false;
		}
		return false;
	}

	/**
	 * Starts a synchronizer listening to resource change events.
	 * 
	 * @param synchronizer the synchronizer to start
	 */
	static void startListening(WorkspaceSynchronizer synchronizer) {
		// copy-on-write for thread safety
		synchronized (synchronizers) {
			Collection<WorkspaceSynchronizer> newList = new java.util.ArrayList<WorkspaceSynchronizer>(
					synchronizers.size() + 1);
			newList.addAll(synchronizers);
			newList.add(synchronizer);
			synchronizers = newList;

			// ensure that we are listening to the workspace
			ResourcesPlugin.getWorkspace().addResourceChangeListener(workspaceListener,
					IResourceChangeEvent.POST_CHANGE);
		}
	}

	/**
	 * Stops a synchronizer listening to resource change events.
	 * 
	 * @param synchronizer the synchronizer to stop
	 */
	static void stopListening(WorkspaceSynchronizer synchronizer) {
		// copy-on-write for thread safety
		synchronized (synchronizers) {
			Collection<WorkspaceSynchronizer> newList = new java.util.ArrayList<WorkspaceSynchronizer>(synchronizers);
			newList.remove(synchronizer);
			synchronizers = newList;

			if (synchronizers.isEmpty()) {
				// stop listening to the workspace
				ResourcesPlugin.getWorkspace().removeResourceChangeListener(workspaceListener);
			}
		}
	}

	/**
	 * Obtains the synchronizers that need to process a resource change event.
	 * 
	 * @return the currently active synchronizers
	 */
	static Collection<WorkspaceSynchronizer> getSynchronizers() {
		// does not need synchronization because we copy on write
		return synchronizers;
	}

	/**
	 * Call-back interface for an object to which a {@link WorkspaceSynchronizer}
	 * delegates the algorithms for handling different kinds of resource
	 * changes.
	 * <p>
	 * Every call-back is invoked asynchronously in a read-only transaction on
	 * the synchronizer's editing domain.  Any model changes that the
	 * receiver wishes to make must be scheduled asynchronously, although
	 * workspace changes are permitted as the calling thread has the
	 * workspace lock.  The call-backs are not actually required to handle the
	 * resource change; they can defer to the default behaviour.
	 * </p>
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	public static interface Delegate {
		/**
		 * Optionally handles the deletion of the physical workspace resource
		 * behind the specified EMF resource.
		 * 
		 * @param resource a resource whose storage has been deleted
		 * 
		 * @return <code>true</code> if I handled the resource deletion;
		 *    <code>false</code> to defer to the workspace synchronizer's
		 *    default algorithm
		 */
		boolean handleResourceDeleted(Resource resource);

		/**
		 * Optionally handles the move of the physical workspace resource
		 * behind the specified EMF resource.  Both in-place renames of a
		 * resource and relocations of a resource to another container are
		 * considered as moves.
		 * 
		 * @param resource a resource whose storage has been moved
		 * @param newURI the new URI of the moved resource
		 * 
		 * @return <code>true</code> if I handled the resource deletion;
		 *    <code>false</code> to defer to the workspace synchronizer's
		 *    default algorithm
		 */
		boolean handleResourceMoved(Resource resource, URI newURI);

		/**
		 * Optionally handles a change to the physical workspace resource
		 * behind the specified EMF resource.
		 * 
		 * @param resource a resource whose storage has been changed
		 * 
		 * @return <code>true</code> if I handled the resource change;
		 *    <code>false</code> to defer to the workspace synchronizer's
		 *    default algorithm
		 */
		boolean handleResourceChanged(Resource resource);

		boolean handleResourceMarkersChanged(Resource resource, IFile file);

		/**
		 * Disposes me.  This is called by the synchronizer when it is disposed.
		 */
		void dispose();
	}

	/**
	 * The single shared workspace listener that passes workspace changes
	 * along to the currently active synchronizers.
	 *
	 * @author Christian W. Damus (cdamus)
	 */
	private static class WorkspaceListener implements IResourceChangeListener {
		@Override
		public void resourceChanged(IResourceChangeEvent event) {
			IResourceDelta delta = event.getDelta();

			try {
				final List<SynchRequest> synchRequests = new java.util.ArrayList<SynchRequest>();

				final List<IFile> affectedFiles = new java.util.ArrayList<IFile>();

				delta.accept(new IResourceDeltaVisitor() {
					@Override
					public boolean visit(IResourceDelta delta) {
						if (delta.getResource().getType() == IResource.FILE) {
							switch (delta.getKind()) {
							case IResourceDelta.CHANGED:
//							    if (delta.getFlags() == IResourceDelta.MARKERS) {
//							        break;
//							    }
							case IResourceDelta.REMOVED:
								processDelta(delta, synchRequests, affectedFiles);
								break;
							}
						}

						return true;
					}
				});

				if (!synchRequests.isEmpty()) {
					new ResourceSynchJob(synchRequests, affectedFiles).schedule();
				}
			} catch (CoreException e) {
				Tracing.catching(WorkspaceListener.class, "resourceChanged", e); //$NON-NLS-1$
				EMFWorkspacePlugin.INSTANCE.log(e);
			}
		}

		/**
		 * Passes the delta to all available synchronizers, to process it.
		 * 
		 * @param delta the delta to process
		 * @param synchRequests accumulates synch requests for the deltas
		 * @param affectedFiles accumulates files affected by the deltas
		 */
		private void processDelta(IResourceDelta delta, List<SynchRequest> synchRequests, List<IFile> affectedFiles) {
			for (WorkspaceSynchronizer next : getSynchronizers()) {
				next.processDelta(delta, synchRequests, affectedFiles);
			}
		}
	}

	/**
	 * The default algorithms for handling workspace resource changes.
	 *
	 * @author Christian W. Damus (cdamus)
	 */
	private static class DefaultDelegate implements Delegate {

		@Override
		public boolean handleResourceDeleted(Resource resource) {
			resource.unload();
			return true;
		}

		@Override
		public boolean handleResourceMoved(Resource resource, URI newURI) {
			resource.unload();
			return true;
		}

		@Override
		public boolean handleResourceChanged(Resource resource) {
			resource.unload();
			try {
				resource.load(resource.getResourceSet().getLoadOptions());
			} catch (IOException e) {
				Tracing.catching(DefaultDelegate.class, "handleResourceChanged", e); //$NON-NLS-1$
				EMFWorkspacePlugin.INSTANCE.log(e);
			}

			return true;
		}

		@Override
		public boolean handleResourceMarkersChanged(Resource resource, IFile file) {
			return true;
		}

		@Override
		public void dispose() {
			// nothing to dispose (especially as I am shared)
		}
	}

	/**
	 * A job that runs under the workspace scheduling rule to process one or
	 * more resource synchronization requests.
	 *
	 * @author Christian W. Damus (cdamus)
	 */
	private static class ResourceSynchJob extends WorkspaceJob {
		private final List<SynchRequest> synchRequests;

		/**
		 * Initializes me with the list of resources changes that I am to
		 * process.
		 * 
		 * @param synchRequests the resource synchronization requests
		 * @param affectedResources the resources affected by the workspace changes
		 */
		ResourceSynchJob(List<SynchRequest> synchRequests, List<? extends IResource> affectedResources) {
			super(Messages.synchJobName);

			this.synchRequests = synchRequests;

			setRule(getRule(affectedResources));
		}

		/**
		 * Processes my queued resource synchronization requests.
		 */
		@Override
		public IStatus runInWorkspace(IProgressMonitor monitor) {
			try {
				for (SynchRequest next : synchRequests) {
					try {
						synchronized (next.getLock()) {
							if (!next.isDisposed()) {
								next.perform();
							}
						}
					} catch (RuntimeException e) {
						Tracing.catching(ResourceSynchJob.class, "run", e); //$NON-NLS-1$
						EMFWorkspacePlugin.INSTANCE.log(e);
					}
				}
			} catch (InterruptedException e) {
				Tracing.catching(ResourceSynchJob.class, "run", e); //$NON-NLS-1$
				return Status.CANCEL_STATUS;
			}

			return Status.OK_STATUS;
		}

		/**
		 * Obtains a scheduling rule to schedule myself on to give my delegate
		 * access to the specified affected resources.
		 * 
		 * @param affectedResources
		 * @return the appropriate scheduling rule, or <code>null</code> if
		 *     none is required
		 */
		private ISchedulingRule getRule(List<? extends IResource> affectedResources) {
			ISchedulingRule result = null;

			if (!affectedResources.isEmpty()) {
				IResourceRuleFactory factory = ResourcesPlugin.getWorkspace().getRuleFactory();

				for (IResource next : affectedResources) {
					result = MultiRule.combine(result, factory.modifyRule(next));
				}
			}

			return result;
		}
	}
}
