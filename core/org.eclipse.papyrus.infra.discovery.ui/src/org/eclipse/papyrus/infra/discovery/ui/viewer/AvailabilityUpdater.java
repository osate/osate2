/*******************************************************************************
 * Copyright (c)  2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *     CEA LIST - adaptation to Papyrus additional components
 *******************************************************************************/
package org.eclipse.papyrus.infra.discovery.ui.viewer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.URIHandlerImpl;
import org.eclipse.papyrus.infra.discovery.DiscoveryDefinition;
import org.eclipse.papyrus.infra.discovery.InstallableComponent;
import org.eclipse.papyrus.infra.discovery.ui.Activator;

/**
 * Updater that checks that features are available for installation
 */
public class AvailabilityUpdater {

	private DiscoveryDefinitionBrowser discovery;

	public AvailabilityUpdater(DiscoveryDefinition newdiscovery) {
		this.discovery = new DiscoveryDefinitionBrowser(newdiscovery);
	}

	public void update(IProgressMonitor monitor) {

		Collection<InstallableComponent> connectors = discovery
				.getAllInstallableComponents();

		Map<String, Collection<InstallableComponent>> urlToDescriptors = new HashMap<String, Collection<InstallableComponent>>();

		for (InstallableComponent descriptor : connectors) {
			for (String url : descriptor.getSitesURLS()) {
				handleSiteURL(urlToDescriptors, descriptor, url);
			}
		}
		final int totalTicks = urlToDescriptors.size();
		monitor.beginTask("Checking update sites availability", totalTicks);
		try {
			if (!urlToDescriptors.isEmpty()) {
				ExecutorService executorService = Executors
						.newFixedThreadPool(Math
								.min(urlToDescriptors.size(), 4));
				try {
					List<Future<VerifyUpdateSiteJob>> futures = new ArrayList<Future<VerifyUpdateSiteJob>>(
							urlToDescriptors.size());
					for (String url : urlToDescriptors.keySet()) {
						futures.add(executorService
								.submit(new VerifyUpdateSiteJob(url)));
					}
					for (Future<VerifyUpdateSiteJob> jobFuture : futures) {
						try {
							for (;;) {
								try {
									VerifyUpdateSiteJob job = jobFuture.get(1L,
											TimeUnit.SECONDS);

									Collection<InstallableComponent> descriptors = urlToDescriptors
											.get(job.url);
									for (InstallableComponent descriptor : descriptors) {
										descriptor.setAvailable(job.ok);
									}
									break;
								} catch (TimeoutException e) {
									if (monitor.isCanceled()) {
										return;
									}
								}
							}
						} catch (InterruptedException e) {
							monitor.setCanceled(true);
							return;
						} catch (ExecutionException e) {
							if (e.getCause() instanceof OperationCanceledException) {
								monitor.setCanceled(true);
								return;
							}
							IStatus status;
							if (e.getCause() instanceof CoreException) {
								status = ((CoreException) e.getCause())
										.getStatus();
							} else {
								status = new Status(
										IStatus.ERROR,
										Activator.PLUGIN_ID,
										"Error while checking update sites availability.",
										e.getCause());
							}
							Activator.logHelper.error(status.getMessage(), status.getException());
						}
						monitor.worked(1);
					}
				} finally {
					executorService.shutdownNow();
				}
			}
		} finally {
			monitor.done();
		}

	}

	private void handleSiteURL(
			Map<String, Collection<InstallableComponent>> urlToDescriptors,
			InstallableComponent descriptor, String url) {
		if (!url.endsWith("/")) { //$NON-NLS-1$
			url += "/"; //$NON-NLS-1$
		}
		Collection<InstallableComponent> collection = urlToDescriptors.get(url);
		if (collection == null) {
			collection = new ArrayList<InstallableComponent>();
			urlToDescriptors.put(url, collection);
		}
		collection.add(descriptor);
	}

	private static class VerifyUpdateSiteJob implements
			Callable<VerifyUpdateSiteJob> {

		private final String url;

		private boolean ok = false;

		public VerifyUpdateSiteJob(String url) {
			this.url = url;
		}

		public VerifyUpdateSiteJob call() throws Exception {
			URI baseUrl = URI.createURI(removeTraillingSlash(url));
			List<URI> locations = new ArrayList<URI>();
			for (String location : new String[] { "compositeContent.jar", "content.jar", "content.xml", "site.xml", "compositeContent.xml" }) { //$NON-NLS-1//$NON-NLS-1//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
				URI locationURI = baseUrl.appendSegment(location);
				locations.add(locationURI);
			}
			URIHandler handler = new URIHandlerImpl();
			Iterator<URI> it = locations.iterator();
			while (it.hasNext() && !ok) {
				URI uri = it.next();
				if (handler.canHandle(uri)
						&& handler.exists(uri, Collections.EMPTY_MAP)) {
					ok = true;
				}
			}
			return this;
		}

		private String removeTraillingSlash(String url2) {
			if (url2.endsWith("/")) {
				return url2.substring(0, url2.length() - 1);
			}
			return url2;
		}

	}
}
