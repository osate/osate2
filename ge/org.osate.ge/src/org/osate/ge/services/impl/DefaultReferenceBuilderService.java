/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.services.impl;

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
import org.osate.ge.ext.Names;
import org.osate.ge.ext.annotations.BuildReference;
import org.osate.ge.services.ReferenceBuilderService;

public class DefaultReferenceBuilderService implements ReferenceBuilderService {
	public static final String REFERENCES_EXTENSION_POINT_ID = "org.osate.ge.references";
	private static final String REFERENCE_BUILDER_ELEMENT_NAME = "referenceBuilder";
	private List<Object> referenceBuilders = null;
	private final IEclipseContext argCtx = EclipseContextFactory.create(); // Used for method arguments
	
	public static class ContextFunction extends SimpleServiceContextFunction<ReferenceBuilderService> {
		@Override
		public ReferenceBuilderService createService() {
			return new DefaultReferenceBuilderService();
		}		
	}

	public DefaultReferenceBuilderService() {
		referenceBuilders = instantiateReferenceBuilders();
	}
	
	private static List<Object> instantiateReferenceBuilders() {		
		final List<Object> referenceBuilders = new ArrayList<>();
		
		final IExtensionRegistry registry = Platform.getExtensionRegistry();	
		final IExtensionPoint point = Objects.requireNonNull(registry.getExtensionPoint(DefaultReferenceBuilderService.REFERENCES_EXTENSION_POINT_ID), "unable to retrieve references extension point");
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
	public String getReference(Object bo) {
		try {
			// Set context fields
			argCtx.set(Names.BUSINESS_OBJECT, bo);
			for(final Object refBuilder : referenceBuilders) {
				final String[] ref = (String[])ContextInjectionFactory.invoke(refBuilder, BuildReference.class, null, argCtx, null);
				if(ref != null) {
					return String.join(" ", ref);
				}
			}
		} finally {
			// Remove entries from context
			argCtx.remove(Names.BUSINESS_OBJECT);
		}
		
		return null;
	}
	
}
