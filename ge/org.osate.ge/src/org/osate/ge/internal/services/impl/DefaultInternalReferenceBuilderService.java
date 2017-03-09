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
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.di.Names;
import org.osate.ge.di.BuildReference;
import org.osate.ge.internal.di.BuildRelativeReference;
import org.osate.ge.internal.services.InternalReferenceBuilderService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class DefaultInternalReferenceBuilderService implements InternalReferenceBuilderService {
	public static final String REFERENCES_EXTENSION_POINT_ID = "org.osate.ge.references";
	private static final String REFERENCE_BUILDER_ELEMENT_NAME = "referenceBuilder";
	private List<Object> referenceBuilders = null;
	private final IEclipseContext argCtx = EclipseContextFactory.create(); // Used for method arguments
	private final IEclipseContext serviceContext;
	
	public static class ContextFunction extends SimpleServiceContextFunction<InternalReferenceBuilderService> {
		@Override
		public InternalReferenceBuilderService createService(final IEclipseContext context) {
			return new DefaultInternalReferenceBuilderService();
		}	
		
		@Override
		protected void deactivate() {
			// Dispose the service if it is valid
			final InternalReferenceBuilderService service = getService();
			if(service instanceof DefaultInternalReferenceBuilderService) {
				((DefaultInternalReferenceBuilderService)service).dispose();
			}
			
			super.deactivate();
		}
	}

	public DefaultInternalReferenceBuilderService() {
		referenceBuilders = instantiateReferenceBuilders();
		
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		serviceContext = EclipseContextFactory.getServiceContext(bundle.getBundleContext()).createChild();
	}
	
	public void dispose() {
		argCtx.dispose();
	}
	
	private static List<Object> instantiateReferenceBuilders() {		
		final List<Object> referenceBuilders = new ArrayList<>();
		
		final IExtensionRegistry registry = Platform.getExtensionRegistry();	
		final IExtensionPoint point = Objects.requireNonNull(registry.getExtensionPoint(DefaultInternalReferenceBuilderService.REFERENCES_EXTENSION_POINT_ID), "unable to retrieve references extension point");
		for(final IExtension extension : point.getExtensions()) {
			for(final IConfigurationElement ce : extension.getConfigurationElements()) {
				if(ce.getName().equals(REFERENCE_BUILDER_ELEMENT_NAME)) {
					try {								
						final Object ext = (Object)ce.createExecutableExtension("class");
						referenceBuilders.add(ext);
					} catch(final CoreException ex) {
						throw new RuntimeException(ex);
					}
				}
			}
		}
		
		return Collections.unmodifiableList(referenceBuilders);
	}
	
	@Override
	public String getAbsoluteReference(final Object bo) {
		try {
			// Set context fields
			argCtx.set(Names.BUSINESS_OBJECT, bo);
			for(final Object refBuilder : referenceBuilders) {
				final String[] ref = (String[])ContextInjectionFactory.invoke(refBuilder, BuildReference.class, serviceContext, argCtx, null);
				if(ref != null) {
					return ReferenceEncoder.encode(ref);
				}
			}
		} finally {
			// Remove entries from context
			argCtx.remove(Names.BUSINESS_OBJECT);
		}
		
		return null;
	}
	
	
	@Override
	public String getRelativeReference(final Object bo) {
		try {
			// Set context fields
			argCtx.set(Names.BUSINESS_OBJECT, bo);
			for(final Object refBuilder : referenceBuilders) {
				final String[] ref = (String[])ContextInjectionFactory.invoke(refBuilder, BuildRelativeReference.class, serviceContext, argCtx, null);
				if(ref != null) {
					return ReferenceEncoder.encode(ref);
				}
			}
		} finally {
			// Remove entries from context
			argCtx.remove(Names.BUSINESS_OBJECT);
		}
		
		return null;
	}
}
