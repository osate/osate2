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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
import org.osate.ge.internal.services.CachingService;
import org.osate.ge.internal.services.CachingService.Cache;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.InternalReferenceBuilderService;
import org.osate.ge.internal.services.ReferenceService;

public class DefaultReferenceService implements ReferenceService {
	private static final String REFERENCE_RESOLVER_ELEMENT_NAME = "referenceResolver";
	private final InternalReferenceBuilderService referenceBuilderService;
	private final IEclipseContext ctx;
	//private final IEclipseContext argCtx = EclipseContextFactory.create(); // Used for method arguments
	private List<Object> referenceResolvers = null;
	private DeclarativeReferenceResolver declarativeReferenceResolver;
	private Map<CanonicalBusinessObjectReference, Object> keyToBusinessObjectMap = new HashMap<CanonicalBusinessObjectReference, Object>();
	
	public DefaultReferenceService(final ExtensionService extService, 
			final CachingService cachingService,
			final InternalReferenceBuilderService referenceBuilderService) {
		this.referenceBuilderService = referenceBuilderService;
		ctx = extService.createChildContext();
		
		// Register the cache with the caching service so it can be invalidated.
		cachingService.registerCache(new Cache() {
			@Override
			public void invalidate() {
				keyToBusinessObjectMap.clear();
			}			
		});
	}
	
	public void dispose() {
		// Disposing of the context will dispose of reference resolvers
		ctx.dispose();
		//argCtx.dispose();
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
			final IExtensionPoint point = Objects.requireNonNull(registry.getExtensionPoint(DefaultInternalReferenceBuilderService.REFERENCES_EXTENSION_POINT_ID), "unable to retrieve references extension point");
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
		Objects.requireNonNull(reference, "reference must not be null");
		
		// Look in the cache first. Don't return null objects even if they have been stored in the cache.
		Object bo = keyToBusinessObjectMap.get(reference);
		if(bo != null) {
			return bo;
		}
		
		// Retrieve the value and add it to the cache
		bo = resolveUncachedAbsoluteReference(reference);
		keyToBusinessObjectMap.put(reference, bo);
		
		return bo;
	}
	
	private Object resolveUncachedAbsoluteReference(final CanonicalBusinessObjectReference reference) {	
		ensureReferenceResolversHaveBeenInstantiated();
		
		final IEclipseContext argCtx = EclipseContextFactory.create(); // Used for method arguments
		try {
			// Set context fields
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
		return referenceBuilderService.getCanonicalReference(bo);
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(Object bo) {
		return referenceBuilderService.getRelativeReference(bo);
	}
}
