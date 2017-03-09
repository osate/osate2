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
import org.osate.aadl2.Element;
import org.osate.aadl2.ProcessImplementation;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.di.ResolveRelativeReference;
import org.osate.ge.di.Names;
import org.osate.ge.di.ResolveReference;
import org.osate.aadl2.AadlPackage;
import org.osate.ge.internal.services.CachingService;
import org.osate.ge.internal.services.CachingService.Cache;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.InternalReferenceBuilderService;
import org.osate.ge.internal.services.SerializableReferenceService;

public class DefaultSerializableReferenceService implements SerializableReferenceService {
	private static final String REFERENCE_RESOLVER_ELEMENT_NAME = "referenceResolver";
	private final InternalReferenceBuilderService referenceBuilderService;
	private final IEclipseContext ctx;
	//private final IEclipseContext argCtx = EclipseContextFactory.create(); // Used for method arguments
	private List<Object> referenceResolvers = null;
	private DeclarativeReferenceResolver declarativeReferenceResolver;
	private Map<String, Object> keyToBusinessObjectMap = new HashMap<String, Object>();
	
	public DefaultSerializableReferenceService(final ExtensionService extService, 
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
	public String getAbsoluteReference(final Object bo) {
		// TODO: Cleanup when AadlElementWrapper is removed
		return referenceBuilderService.getAbsoluteReference(bo instanceof AadlElementWrapper ? AadlElementWrapper.unwrap(bo) : bo);
	}
	
	@Override
	public String getRelativeReference(final Object bo) {
		// TODO: Cleanup when AadlElementWrapper is removed
		return referenceBuilderService.getRelativeReference(bo instanceof AadlElementWrapper ? AadlElementWrapper.unwrap(bo) : bo);
	}

	@Override
	public Object resolveAbsoluteReference(final String referenceStr) {
		if(referenceStr == null) {
			return null;
		}
		
		// Look in the cache first. Don't return null objects even if they have been stored in the cache.
		Object bo = keyToBusinessObjectMap.get(referenceStr);
		if(bo != null) {
			return bo;
		}
		
		// Retrieve the value and add it to the cache
		bo = resolveUncachedAbsoluteReference(referenceStr);
		keyToBusinessObjectMap.put(referenceStr, bo);
		
		return bo;
	}
	
	private Object resolveUncachedAbsoluteReference(final String referenceStr) {	
		Objects.requireNonNull(referenceStr, "referenceStr must not be null");
		ensureReferenceResolversHaveBeenInstantiated();
		
		// Break the reference into segments
		final String[] ref = ReferenceEncoder.decode(referenceStr);
		if(ref == null) {
			return null;
		}

		final IEclipseContext argCtx = EclipseContextFactory.create(); // Used for method arguments
		try {
			// Set context fields
			argCtx.set(Names.REFERENCE, ref);	
			
			for(final Object refResolver : referenceResolvers) {
				final Object referencedObject = ContextInjectionFactory.invoke(refResolver, ResolveReference.class, ctx, argCtx, null);
				if(referencedObject != null) {
					return referencedObject instanceof Element ?  new AadlElementWrapper((Element)referencedObject) : referencedObject;
				}
			}
		} finally {
			argCtx.dispose();
		}
		
		return null;
	}
	
	@Override
	public Object resolveRelativeReference(final Object parentBo, final String referenceStr) {
		Objects.requireNonNull(parentBo, "parentBo must not be null");
		// TODO: Caching. Need a cache for each parent businesss object.
		return resolveUncachedRelativeReference(parentBo, referenceStr);
	}
				
	private Object resolveUncachedRelativeReference(final Object parentBo, final String referenceStr) {	
		Objects.requireNonNull(referenceStr, "referenceStr must not be null");
		ensureReferenceResolversHaveBeenInstantiated();
		
		// Break the reference into segments
		final String[] ref = ReferenceEncoder.decode(referenceStr);
		if(ref == null) {
			return null;
		}

		final IEclipseContext argCtx = EclipseContextFactory.create(); // Used for method arguments
		try {
			// Set context fields
			// TODO: Owner vs parent BO
			argCtx.set(Names.OWNER_BO, parentBo);
			argCtx.set(Names.REFERENCE, ref);	
			
			for(final Object refResolver : referenceResolvers) {
				final Object referencedObject = ContextInjectionFactory.invoke(refResolver, ResolveRelativeReference.class, ctx, argCtx, null);
				if(referencedObject != null) {
					return referencedObject instanceof Element ?  new AadlElementWrapper((Element)referencedObject) : referencedObject;
				}
			}
		} finally {
			argCtx.dispose();
		}
		
		return null;
	}
	
	@Override
	public AadlPackage getAadlPackage(final String qualifiedName) {
		return declarativeReferenceResolver.getAadlPackage(qualifiedName);
	}
}
