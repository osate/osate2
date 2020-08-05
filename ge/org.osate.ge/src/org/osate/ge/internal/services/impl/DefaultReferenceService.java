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
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.WeakHashMap;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.businessobjecthandlers.BusinessObjectHandlerProvider;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.referencehandling.GetCanonicalReferenceLabelContext;
import org.osate.ge.referencehandling.GetRelativeReferenceLabelContext;
import org.osate.ge.referencehandling.ReferenceLabelProvider;
import org.osate.ge.referencehandling.internal.ReferenceLabelProviderRegistry;

public class DefaultReferenceService implements ReferenceService {
	private final static ReferenceQueue<ProjectReferenceService> serviceReferenceQueue = new ReferenceQueue<>();

	// Start a thread which will monitor the service reference queue and call the dispose method of the reference.
	static {
		final Thread referenceDisposalThread = new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				ProjectReferenceServiceReference ref;
				try {
					while ((ref = (ProjectReferenceServiceReference) serviceReferenceQueue.remove()) != null) {
						ref.dispose();
					}
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});
		referenceDisposalThread.setDaemon(true);
		referenceDisposalThread.start();
	}

	private static class ProjectReferenceServiceReference extends WeakReference<DefaultProjectReferenceService> {
		private final Runnable cleanup;

		public ProjectReferenceServiceReference(final DefaultProjectReferenceService service,
				final ReferenceQueue<? super ProjectReferenceService> queue) {
			super(service, queue);
			this.cleanup = service.getCleanupRunnable();
		}

		public void dispose() {
			cleanup.run();
		}
	}

	public static class ContextFunction extends SimpleServiceContextFunction<ReferenceService> {
		@Override
		public ReferenceService createService(final IEclipseContext context) {
			return new DefaultReferenceService(context.get(ExtensionRegistryService.class));
		}
	}

	private final ReferenceLabelProviderRegistry labelProviderRegistry;
	private final WeakHashMap<IProject, ProjectReferenceServiceReference> projectToProjectReferenceService = new WeakHashMap<>();
	private final BusinessObjectHandlerProvider bohProvider;

	public DefaultReferenceService(
			final BusinessObjectHandlerProvider bohProvider) {
		this.labelProviderRegistry = new ReferenceLabelProviderRegistry(Platform.getExtensionRegistry());
		this.bohProvider = Objects.requireNonNull(bohProvider, "bohProvider must not be null");

	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final Object bo) {
		Objects.requireNonNull(bo, "bo must not be null");

		final BusinessObjectHandler boh = bohProvider.getApplicableBusinessObjectHandler(bo);
		if (boh == null) {
			return null;
		}

		try {
			return boh.getCanonicalReference(new ReferenceContext(bo, this));
		} catch (RuntimeException ex) {
			StatusManager.getManager().handle(
					new Status(IStatus.ERROR, Activator.PLUGIN_ID,
							"Error retrieving canonical reference for " + bo.getClass().getCanonicalName()
							+ ".",
							ex),
					StatusManager.LOG | StatusManager.SHOW);
			return null;
		}
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final Object bo) {
		Objects.requireNonNull(bo, "bo must not be null");

		final BusinessObjectHandler boh = bohProvider.getApplicableBusinessObjectHandler(bo);
		if (boh == null) {
			return null;
		}

		try {
			return Objects.requireNonNull(boh.getRelativeReference(new ReferenceContext(bo, this)),
					() -> "Business object handlers must not return a null relative reference. Null reference returned by '"
							+ boh.getClass().getCanonicalName() + "'");
		} catch (RuntimeException ex) {
			StatusManager.getManager().handle(
					new Status(IStatus.ERROR, Activator.PLUGIN_ID,
							"Error retrieving relative reference for " + bo.getClass().getCanonicalName() + ".",
							ex),
					StatusManager.LOG | StatusManager.SHOW);
			return null;
		}
	}

	@Override
	public ProjectReferenceService getProjectReferenceService(final IProject project) {
		ProjectReferenceServiceReference serviceRef = projectToProjectReferenceService.get(project);
		DefaultProjectReferenceService result = serviceRef == null ? null : serviceRef.get();
		if (result == null) {
			// Create the reference service
			result = new DefaultProjectReferenceService(this, this, project);

			// Create the reference
			final ProjectReferenceServiceReference newServiceRef = new ProjectReferenceServiceReference(result,
					serviceReferenceQueue);
			projectToProjectReferenceService.put(project, newServiceRef);
		}

		return result;
	}

	@Override
	public String getLabel(final CanonicalBusinessObjectReference ref) {
		Objects.requireNonNull(ref, "ref must not be null");

		final GetCanonicalReferenceLabelContext ctx = new GetCanonicalReferenceLabelContext(ref);
		for (final ReferenceLabelProvider provider : labelProviderRegistry.getProviders()) {
			final Optional<String> label = provider.getCanonicalReferenceLabel(ctx);
			if (label.isPresent()) {
				return label.get();
			}
		}

		return getFallbackLabel(ref.getSegments());
	}

	@Override
	public String getLabel(final RelativeBusinessObjectReference ref) {
		Objects.requireNonNull(ref, "ref must not be null");

		final GetRelativeReferenceLabelContext ctx = new GetRelativeReferenceLabelContext(ref);
		for (final ReferenceLabelProvider provider : labelProviderRegistry.getProviders()) {
			final Optional<String> label = provider.getRelativeReferenceLabel(ctx);
			if (label.isPresent()) {
				return label.get();
			}
		}

		return getFallbackLabel(ref.getSegments());
	}

	/**
	 * Returns a label created by joining the specified segments. Intended for use when a label provider is not available.
	 * @param segments the segments to join
	 * @return the label.
	 */
	private final String getFallbackLabel(final List<String> segments) {
		return segments.stream().collect(Collectors.joining(" "));
	}
}
