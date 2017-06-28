/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.di.Names;
import org.osate.ge.di.ResolveCanonicalReference;
import org.osate.ge.internal.diagram.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.RelativeBusinessObjectReference;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.services.ReferenceBuilderService;
import org.osate.ge.services.ReferenceResolutionService;
import org.osate.ge.internal.services.ProjectReferenceService;

public class DefaultProjectReferenceService implements ProjectReferenceService {
	private static final String REFERENCE_RESOLVER_ELEMENT_NAME = "referenceResolver";
	private final ReferenceBuilderService referenceBuilder;
	private final IEclipseContext ctx;
	private List<Object> referenceResolvers = null;
	private DeclarativeReferenceResolver declarativeReferenceResolver;
	
	// Use a static class to avoid keeping references to the project reference service
	private static class SimpleProjectProvider implements ProjectProvider {
		private final IProject project;
		
		public SimpleProjectProvider(final IProject project) {
			this.project = project;
		}

		@Override
		public IProject getProject() {
			return project;
		}
	}
	
	/**
	 * 
	 * @param referenceBuilder
	 * @param project
	 * @param ctx an Eclipse context which will be used to create extensions and invoke extension methods. Passed in to allow it to be disposed by the owner of the project reference service
	 */
	public DefaultProjectReferenceService(final ReferenceBuilderService referenceBuilder,
			final IProject project,
			final IEclipseContext ctx) {
		this.referenceBuilder = Objects.requireNonNull(referenceBuilder, "referenceBuilder must not be null");
		this.ctx = Objects.requireNonNull(ctx, "ctx must not be null");
		ctx.set(ProjectProvider.class, new SimpleProjectProvider(project));
	}
	
	/**
	 * Lazy instantiate reference resolvers. Ensures that all services are available.
	 */
	private void ensureReferenceResolversHaveBeenInstantiated() {
		if(referenceResolvers == null) {
			// Instantiate reference resolvers
			referenceResolvers = new ArrayList<>();

			// Create the declarative reference handler. It is not registered with plugin.xml because an explicit reference to it is needed
			this.declarativeReferenceResolver = ContextInjectionFactory.make(DeclarativeReferenceResolver.class, ctx);
			referenceResolvers.add(declarativeReferenceResolver);
			
			// Instantiate other reference handlers
			
			final IExtensionRegistry registry = Platform.getExtensionRegistry();	
			final IExtensionPoint point = Objects.requireNonNull(registry.getExtensionPoint(DefaultReferenceService.REFERENCES_EXTENSION_POINT_ID), "unable to retrieve references extension point");
			for(final IExtension extension : point.getExtensions()) {
				for(final IConfigurationElement ce : extension.getConfigurationElements()) {
					if(ce.getName().equals(REFERENCE_RESOLVER_ELEMENT_NAME)) {
						try {
							final String className = ce.getAttribute("class");
							final Class<?> resolverClass = Platform.getBundle(ce.getContributor().getName()).loadClass(className);
							referenceResolvers.add(ContextInjectionFactory.make(resolverClass, ctx));
						} catch(final ClassNotFoundException ex) {
							throw new RuntimeException(ex);
						}
					}
				}
			}
		}
	}
	
	@Override
	public Object resolve(final CanonicalBusinessObjectReference reference) {
		ensureReferenceResolversHaveBeenInstantiated();
		
		final IEclipseContext argCtx = EclipseContextFactory.create(); // Used for method arguments
		try {
			// Set context fields
			argCtx.set(ReferenceResolutionService.class, this);
			argCtx.set(Names.REFERENCE, reference.toSegmentArray());	
			
			for(final Object refResolver : referenceResolvers) {
				final Object referencedObject = ContextInjectionFactory.invoke(refResolver, ResolveCanonicalReference.class, ctx, argCtx, null);
				if(referencedObject != null) {
					return referencedObject;
				}
			}
		} finally {
			argCtx.dispose();
		}
		
		return null;
	}
	
	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final Object bo) {
		return referenceBuilder.getCanonicalReference(bo);
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(Object bo) {
		return referenceBuilder.getRelativeReference(bo);
	}
	
	// Must be called when the model changes to invalidate caches. 
	void onModelChanged() {
		// Notify the declarative reference resolvers of the model change. 
		// If other resolvers need to receive the notification, an API should be created for it.
		declarativeReferenceResolver.invalidateCache();
	}
}
