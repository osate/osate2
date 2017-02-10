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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.aadl2.Element;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.di.Names;
import org.osate.ge.di.ResolveReference;
import org.osate.aadl2.AadlPackage;
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
	
	public DefaultSerializableReferenceService(final ExtensionService extService, final InternalReferenceBuilderService referenceBuilderService) {
		this.referenceBuilderService = referenceBuilderService;
		ctx = extService.createChildContext();
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
	public String getReference(final Object bo) {
		return referenceBuilderService.getReference(bo);
	}

	@Override
	public Object getReferencedObject(final String referenceStr) {
		Objects.requireNonNull(referenceStr, "referenceStr must not be null");
		ensureReferenceResolversHaveBeenInstantiated();
		
		// Break the reference into segments
		final String[] ref = referenceStr.split(" ");
		if(ref.length < 1) {
			return null;
		}
		
		// Restore spaces
		final StringBuilder sb = new StringBuilder();
		for(int i = 0; i < ref.length; i++) {
			sb.setLength(0);
			ReferenceEncoder.decodeSegment(sb, ref[i]);
			ref[i] = sb.toString();
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
	public AadlPackage getAadlPackage(final String qualifiedName) {
		return declarativeReferenceResolver.getAadlPackage(qualifiedName);
	}
}
