package org.osate.xtext.aadl2.properties.ui.builder;

import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.builder.MonitorBasedCancelIndicator;
import org.eclipse.xtext.builder.builderState.BuilderStateUtil;
import org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl;
import org.eclipse.xtext.builder.clustering.ClusteringBuilderState;
import org.eclipse.xtext.builder.clustering.CurrentDescriptions;
import org.eclipse.xtext.builder.debug.IBuildLogger;
import org.eclipse.xtext.builder.impl.BuildData;
import org.eclipse.xtext.builder.resourceloader.IResourceLoader;
import org.eclipse.xtext.builder.resourceloader.IResourceLoader.LoadOperation;
import org.eclipse.xtext.builder.resourceloader.IResourceLoader.LoadOperationException;
import org.eclipse.xtext.builder.resourceloader.IResourceLoader.LoadResult;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.name.Named;

@SuppressWarnings("restriction")
public class OsateClusteringBuilderState extends ClusteringBuilderState {

	/** Class-wide logger. */
	private static final Logger LOGGER = Logger.getLogger(OsateClusteringBuilderState.class);

	@Inject
	private org.eclipse.xtext.resource.clustering.IResourceClusteringPolicy clusteringPolicy;

	@Inject
	@Named(RESOURCELOADER_GLOBAL_INDEX)
	private IResourceLoader globalIndexResourceLoader;

	@Inject
	@Named(RESOURCELOADER_CROSS_LINKING)
	private IResourceLoader crossLinkingResourceLoader;

	@Inject
	private IBuildLogger buildLogger;

	private static final int MONITOR_DO_UPDATE_CHUNK = 10;

	@Override
	protected Collection<Delta> doUpdate(BuildData buildData, ResourceDescriptionsData newData,
			IProgressMonitor monitor) {
		final SubMonitor progress = SubMonitor.convert(monitor, 100);

		// Step 1: Clean the set of deleted URIs. If any of them are also added, they're not deleted.
		final Set<URI> toBeDeleted = buildData.getAndRemoveToBeDeleted();

		// Step 2: Create a new state (old state minus the deleted resources). This, by virtue of the flag
		// NAMED_BUILDER_SCOPE in the resource set's load options
		// and a Guice binding, is the index that is used during the build; i.e., linking during the build will
		// use this. Once the build is completed, the persistable index is reset to the contents of newState by
		// virtue of the newMap, which is maintained in synch with this.
		ResourceSet resourceSet = buildData.getResourceSet();
		final CurrentDescriptions newState = new CurrentDescriptions(resourceSet, newData, buildData);
		buildData.getSourceLevelURICache().cacheAsSourceURIs(toBeDeleted);
		installSourceLevelURIs(buildData);
		// Step 3: Create a queue; write new temporary resource descriptions for the added or updated resources so that we can link
		// subsequently; put all the added or updated resources into the queue.
		writeNewResourceDescriptions(buildData, this, newState, progress.newChild(20));

		if (progress.isCanceled()) {
			throw new OperationCanceledException();
		}

		// Step 4: Create a URI set of resources not yet in the delta. This is used for queuing; whenever a resource is
		// queued for processing, its URI is removed from this set. queueAffectedResources will consider only resources
		// in this set as potential candidates.
		for (final URI uri : toBeDeleted) {
			newData.removeDescription(uri);
		}
		final Set<URI> allRemainingURIs = Sets.newLinkedHashSet(newData.getAllURIs());
		allRemainingURIs.removeAll(buildData.getToBeUpdated());
		for (URI remainingURI : buildData.getAllRemainingURIs()) {
			allRemainingURIs.remove(remainingURI);
		}
		// TODO: consider to remove any entry from upstream projects and independent projects
		// from the set of remaining uris (template method or service?)
		// this should reduce the number of to-be-checked descriptions significantly
		// for common setups (large number of reasonable sized projects)

		// Our return value. It contains all the deltas resulting from this build.
		final Set<Delta> allDeltas = Sets.newHashSet();

		// Step 5: Put all resources depending on a deleted resource into the queue. Also register the deltas in allDeltas.
		if (!toBeDeleted.isEmpty()) {
			for (final URI uri : toBeDeleted) {
				final IResourceDescription oldDescription = this.getResourceDescription(uri);
				if (oldDescription != null) {
					allDeltas.add(new DefaultResourceDescriptionDelta(oldDescription, null));
				}
			}
		}
		// Add all pending deltas to all deltas (may be scheduled java deltas)
		Collection<Delta> pendingDeltas = buildData.getAndRemovePendingDeltas();
		allDeltas.addAll(pendingDeltas);
		queueAffectedResources(allRemainingURIs, this, newState, allDeltas, allDeltas, buildData, progress.newChild(1));
		installSourceLevelURIs(buildData);

		IProject currentProject = getBuiltProject(buildData);
		LoadOperation loadOperation = null;
		try {
			Queue<URI> queue = buildData.getURIQueue();

			loadOperation = crossLinkingResourceLoader.create(resourceSet, currentProject);
			loadOperation.load(queue);

			// Step 6: Iteratively got through the queue. For each resource, create a new resource description and queue all depending
			// resources that are not yet in the delta. Validate resources. Do this in chunks.
			final SubMonitor subProgress = progress.newChild(80);
			CancelIndicator cancelMonitor = new MonitorBasedCancelIndicator(progress);

			int index = 0;
			while (!queue.isEmpty()) {
				// heuristic: only 2/3 of ticks will be consumed; rest kept for affected resources
				if (index % MONITOR_DO_UPDATE_CHUNK == 0) {
					subProgress.setWorkRemaining(((queue.size() / MONITOR_DO_UPDATE_CHUNK) + 1) * 3);
				}
				int clusterIndex = 0;
				final List<Delta> changedDeltas = Lists.newArrayList();
				while (!queue.isEmpty()) {
					if (subProgress.isCanceled()) {
						loadOperation.cancel();
						throw new OperationCanceledException();
					}
					if (!clusteringPolicy.continueProcessing(resourceSet, null, clusterIndex)) {
						break;
					}
					URI changedURI = null;
					URI actualResourceURI = null;
					Resource resource = null;
					Delta newDelta = null;

					try {
						// Load the resource and create a new resource description
						LoadResult loadResult = loadOperation.next();
						changedURI = loadResult.getUri();
						actualResourceURI = loadResult.getResource().getURI();
						resource = addResource(loadResult.getResource(), resourceSet);
						if (index % MONITOR_DO_UPDATE_CHUNK == 0) {
							subProgress.subTask(
									"Updating resource descriptions chunk " + (index / MONITOR_DO_UPDATE_CHUNK + 1)
									+ " of " + ((index + queue.size()) / MONITOR_DO_UPDATE_CHUNK + 1));
						}
						if (LOGGER.isDebugEnabled()) {
							LOGGER.debug("Update resource description " + actualResourceURI);
						}
						queue.remove(changedURI);
						if (toBeDeleted.contains(changedURI)) {
							break;
						}
						buildLogger.log("indexing " + changedURI);
						final IResourceDescription.Manager manager = getResourceDescriptionManager(actualResourceURI);
						if (manager != null) {
							// Resolve links here!
							try {
								if (resource instanceof XtextResource) {
									// ((XtextResource) resource).getCache().clear(resource);
								}
								EcoreUtil2.resolveLazyCrossReferences(resource, cancelMonitor);
								final IResourceDescription description = manager.getResourceDescription(resource);
								final IResourceDescription copiedDescription = BuilderStateUtil.create(description);
								newDelta = manager.createDelta(this.getResourceDescription(actualResourceURI),
										copiedDescription);
							} catch (OperationCanceledException e) {
								loadOperation.cancel();
								throw e;
							} catch (WrappedException e) {
								throw e;
							} catch (RuntimeException e) {
								LOGGER.error("Error resolving cross references on resource '" + actualResourceURI + "'",
										e);
								throw new LoadOperationException(actualResourceURI, e);
							}
						}
					} catch (final WrappedException ex) {
						if (ex instanceof LoadOperationException) {
							changedURI = ((LoadOperationException) ex).getUri();
						}
						Throwable cause = ex.getCause();
						boolean wasResourceNotFound = false;
						if (cause instanceof CoreException) {
							if (IResourceStatus.RESOURCE_NOT_FOUND == ((CoreException) cause).getStatus().getCode()) {
								wasResourceNotFound = true;
							}
						}
						if (changedURI == null) {
							LOGGER.error("Error loading resource", ex); //$NON-NLS-1$
						} else {
							queue.remove(changedURI);
							if (toBeDeleted.contains(changedURI)) {
								break;
							}
							if (!wasResourceNotFound) {
								LOGGER.error("Error loading resource from: " + changedURI.toString(), ex); //$NON-NLS-1$
							}
							if (resource != null) {
								resourceSet.getResources().remove(resource);
							}
							final IResourceDescription oldDescription = this.getResourceDescription(changedURI);
							final IResourceDescription newDesc = newState.getResourceDescription(changedURI);
							ResourceDescriptionImpl indexReadyDescription = newDesc != null
									? BuilderStateUtil.create(newDesc)
											: null;
									if ((oldDescription != null || indexReadyDescription != null)
											&& oldDescription != indexReadyDescription) {
										newDelta = new DefaultResourceDescriptionDelta(oldDescription, indexReadyDescription);
									}
						}
					}
					if (newDelta != null) {
						allDeltas.add(newDelta);
						clusterIndex++;
						if (newDelta.haveEObjectDescriptionsChanged()) {
							changedDeltas.add(newDelta);
						}
						// Make the new resource description known and update the map.
						newState.register(newDelta);
						// Validate now.
						if (!buildData.isIndexingOnly()) {
							try {
								updateMarkers(newDelta, resourceSet, subProgress);
							} catch (OperationCanceledException e) {
								loadOperation.cancel();
								throw e;
							} catch (Exception e) {
								LOGGER.error("Error validating " + newDelta.getUri(), e);
							}
						}
					}
					index++;
					if (index % MONITOR_DO_UPDATE_CHUNK == 0) {
						subProgress.worked(1);
					}
				}

				loadOperation.cancel();

				queueAffectedResources(allRemainingURIs, this, newState, changedDeltas, allDeltas, buildData,
						subProgress.newChild(1));
				installSourceLevelURIs(buildData);
				if (queue.size() > 0) {
					loadOperation = crossLinkingResourceLoader.create(resourceSet, currentProject);
					loadOperation.load(queue);
				}

				// Release memory
				if (!queue.isEmpty() && !clusteringPolicy.continueProcessing(resourceSet, null, clusterIndex)) {
					clearResourceSet(resourceSet);
				}
			}
		} finally {
			if (loadOperation != null) {
				loadOperation.cancel();
			}
			if (!progress.isCanceled()) {
				progress.done();
			}
		}
		return allDeltas;
	}

}
