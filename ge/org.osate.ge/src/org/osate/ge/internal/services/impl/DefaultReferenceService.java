/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.di.BuildCanonicalReference;
import org.osate.ge.di.BuildRelativeReference;
import org.osate.ge.di.Names;
import org.osate.ge.internal.di.GetCanonicalReferenceLabel;
import org.osate.ge.internal.di.GetRelativeReferenceLabel;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.services.ReferenceService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class DefaultReferenceService implements ReferenceService {
	public static final String REFERENCES_EXTENSION_POINT_ID = "org.osate.ge.references";
	private static final String REFERENCE_BUILDER_ELEMENT_NAME = "referenceBuilder";
	private static final String REFERENCE_LABEL_PROVIDER_ELEMENT_NAME = "referenceLabelProvider";

	private final static ReferenceQueue<ProjectReferenceService> serviceReferenceQueue = new ReferenceQueue<>();

	// Start a thread which will monitor the service reference queue and call the dispose method of the reference.
	static {
		final Thread referenceDisposalThread = new Thread(() -> {
			while(!Thread.currentThread().isInterrupted()) {
				ProjectReferenceServiceReference ref;
				try {
					while((ref = (ProjectReferenceServiceReference)serviceReferenceQueue.remove()) != null) {
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

	// A weak reference that holds the IEclipesContext used by the referenced service.
	private static class ProjectReferenceServiceReference extends WeakReference<DefaultProjectReferenceService> {
		private final IEclipseContext ctx;

		public ProjectReferenceServiceReference(final DefaultProjectReferenceService service,
				final ReferenceQueue<? super ProjectReferenceService> queue,
				final IEclipseContext ctx) {
			super(service, queue);
			this.ctx = Objects.requireNonNull(ctx, "ctx must not be null");
		}

		public void dispose() {
			// Dispose of the context
			ctx.dispose();
		}
	}

	public static class ContextFunction extends SimpleServiceContextFunction<ReferenceService> {
		@Override
		public ReferenceService createService(final IEclipseContext context) {
			return new DefaultReferenceService(context.get(ModelChangeNotifier.class));
		}

		@Override
		protected void deactivate() {
			// Dispose the service if it is valid
			final ReferenceService service = getService();
			if(service instanceof DefaultReferenceService) {
				((DefaultReferenceService)service).dispose();
			}

			super.deactivate();
		}
	}

	private List<Object> referenceBuilders = null;
	private List<Object> referenceLabelProviders = null;
	private final IEclipseContext argCtx = EclipseContextFactory.create(); // Used for method arguments
	private final IEclipseContext serviceContext;
	private final WeakHashMap<IProject, ProjectReferenceServiceReference> projectToProjectReferenceService = new WeakHashMap<>();
	private final ModelChangeNotifier modelChangeNotifier;

	private ModelChangeNotifier.ChangeListener modelChangeListener = new ModelChangeNotifier.ChangeListener() {
		@Override
		public void modelChanged(final boolean modelWasLocked) {
			// Notify project reference services of the model change
			for(final ProjectReferenceServiceReference ref : projectToProjectReferenceService.values()) {
				final DefaultProjectReferenceService projectReferenceService = ref.get();
				if(projectReferenceService != null) {
					projectReferenceService.onModelChanged();
				}
			}
		}
	};

	public DefaultReferenceService(final ModelChangeNotifier modelChangeNotifier) {
		this.modelChangeNotifier = Objects.requireNonNull(modelChangeNotifier, "modelChangeNotifier must not be null");
		referenceBuilders = instantiateReferenceBuilders();
		referenceLabelProviders = instantiateReferenceLabelProviders();

		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		serviceContext = EclipseContextFactory.getServiceContext(bundle.getBundleContext());

		// Start listening to model changes
		modelChangeNotifier.addChangeListener(modelChangeListener);
	}

	public void dispose() {
		// Stop listening to model changes
		modelChangeNotifier.removeChangeListener(modelChangeListener);

		argCtx.dispose();
	}

	private static List<Object> instantiateReferenceBuilders() {
		final List<Object> referenceBuilders = new ArrayList<>();

		final IExtensionRegistry registry = Platform.getExtensionRegistry();
		final IExtensionPoint point = Objects.requireNonNull(registry.getExtensionPoint(DefaultReferenceService.REFERENCES_EXTENSION_POINT_ID), "unable to retrieve references extension point");
		for(final IExtension extension : point.getExtensions()) {
			for(final IConfigurationElement ce : extension.getConfigurationElements()) {
				if(ce.getName().equals(REFERENCE_BUILDER_ELEMENT_NAME)) {
					try {
						final Object ext = ce.createExecutableExtension("class");
						referenceBuilders.add(ext);
					} catch(final CoreException ex) {
						throw new RuntimeException(ex);
					}
				}
			}
		}

		return Collections.unmodifiableList(referenceBuilders);
	}

	private static List<Object> instantiateReferenceLabelProviders() {
		final List<Object> referenceBuilders = new ArrayList<>();

		final IExtensionRegistry registry = Platform.getExtensionRegistry();
		final IExtensionPoint point = Objects.requireNonNull(
				registry.getExtensionPoint(DefaultReferenceService.REFERENCES_EXTENSION_POINT_ID),
				"unable to retrieve references extension point");
		for (final IExtension extension : point.getExtensions()) {
			for (final IConfigurationElement ce : extension.getConfigurationElements()) {
				if (ce.getName().equals(REFERENCE_LABEL_PROVIDER_ELEMENT_NAME)) {
					try {
						final Object ext = ce.createExecutableExtension("class");
						referenceBuilders.add(ext);
					} catch (final CoreException ex) {
						throw new RuntimeException(ex);
					}
				}
			}
		}

		return Collections.unmodifiableList(referenceBuilders);
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final Object bo) {
		Objects.requireNonNull(bo, "bo must not be null");
		try {
			// Set context fields
			argCtx.set(Names.BUSINESS_OBJECT, bo);
			for(final Object refBuilder : referenceBuilders) {
				final String[] ref = (String[])ContextInjectionFactory.invoke(refBuilder, BuildCanonicalReference.class, serviceContext, argCtx, null);
				if(ref != null) {
					// Return null if any segment is null.
					// This is done to prevent the reference builder from having to check all fields such as qualified name for null values.
					for(final String seg : ref) {
						if(seg == null) {
							return null;
						}
					}

					return new CanonicalBusinessObjectReference(ref);
				}
			}
		} finally {
			// Remove entries from context
			argCtx.remove(Names.BUSINESS_OBJECT);
		}

		return null;
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final Object bo) {
		Objects.requireNonNull(bo, "bo must not be null");
		try {
			// Set context fields
			argCtx.set(Names.BUSINESS_OBJECT, bo);
			for(final Object refBuilder : referenceBuilders) {
				final Object rawRef = ContextInjectionFactory.invoke(refBuilder,
						BuildRelativeReference.class, serviceContext, argCtx, null);
				if (rawRef != null) {
					if (rawRef instanceof RelativeBusinessObjectReference) {
						return (RelativeBusinessObjectReference) rawRef;
					} else if (rawRef instanceof String[]) {
						return RelativeBusinessObjectReference.fromNullableSegments((String[]) rawRef);
					} else {
						throw new RuntimeException(
								"Invalid value: '" + rawRef + "' returned by relative reference builder");
					}
				}
			}
		} finally {
			// Remove entries from context
			argCtx.remove(Names.BUSINESS_OBJECT);
		}

		return null;
	}

	@Override
	public ProjectReferenceService getProjectReferenceService(final IProject project) {
		ProjectReferenceServiceReference serviceRef = projectToProjectReferenceService.get(project);
		DefaultProjectReferenceService result = serviceRef == null ? null : serviceRef.get();
		if(result == null) {
			// Create a new context
			final Bundle bundle = FrameworkUtil.getBundle(getClass());
			final IEclipseContext ctx = EclipseContextFactory.getServiceContext(bundle.getBundleContext())
					.createChild(); // Will be disposed when ProjectReferenceServiceReference is disposed.

			// Create the reference service
			result = new DefaultProjectReferenceService(this, this, project, ctx);

			// Create the reference
			final ProjectReferenceServiceReference newServiceRef = new ProjectReferenceServiceReference(result, serviceReferenceQueue, ctx);
			projectToProjectReferenceService.put(project, newServiceRef);
		}

		return result;
	}

	@Override
	public String getLabel(final CanonicalBusinessObjectReference ref, final IProject project) {
		Objects.requireNonNull(ref, "ref must not be null");
		Objects.requireNonNull(project, "project must not be null");

		try {
			// Set context fields
			argCtx.set(InternalNames.REFERENCE, ref);
			argCtx.set(InternalNames.PROJECT, project);
			for (final Object refLabelProvider : referenceLabelProviders) {
				final String label = (String) ContextInjectionFactory.invoke(refLabelProvider,
						GetCanonicalReferenceLabel.class,
						serviceContext, argCtx, null);
				if (label != null) {
					return label;
				}
			}
		} finally {
			// Remove entries from context
			argCtx.remove(InternalNames.PROJECT);
			argCtx.remove(InternalNames.REFERENCE);
		}

		return null;
	}

	@Override
	public String getLabel(final RelativeBusinessObjectReference ref) {
		Objects.requireNonNull(ref, "ref must not be null");
		try {
			// Set context fields
			argCtx.set(InternalNames.REFERENCE, ref);
			for (final Object refLabelProvider : referenceLabelProviders) {
				final String label = (String) ContextInjectionFactory.invoke(refLabelProvider,
						GetRelativeReferenceLabel.class, serviceContext, argCtx, null);
				if (label != null) {
					return label;
				}
			}
		} finally {
			// Remove entries from context
			argCtx.remove(InternalNames.REFERENCE);
		}

		return null;
	}
}
