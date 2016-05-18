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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.ge.di.GetEmfResource;
import org.osate.ge.di.Names;
import org.osate.ge.di.BuildReference;
import org.osate.ge.di.GetProject;
import org.osate.ge.di.GetTitle;
import org.osate.ge.internal.services.InternalReferenceBuilderService;
import org.osate.ge.internal.ui.util.SelectionHelper;
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
	}

	public DefaultInternalReferenceBuilderService() {
		referenceBuilders = instantiateReferenceBuilders();
		
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		serviceContext = EclipseContextFactory.getServiceContext(bundle.getBundleContext()).createChild();
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
	public String getReference(Object bo) {
		try {
			// Set context fields
			argCtx.set(Names.BUSINESS_OBJECT, bo);
			for(final Object refBuilder : referenceBuilders) {
				final String[] ref = (String[])ContextInjectionFactory.invoke(refBuilder, BuildReference.class, serviceContext, argCtx, null);
				if(ref != null) {
					return segmentsToReference(ref);
				}
			}
		} finally {
			// Remove entries from context
			argCtx.remove(Names.BUSINESS_OBJECT);
		}
		
		return null;
	}
	
	private static String segmentsToReference(final String[] segs) {
		final StringBuilder sb = new StringBuilder();
		sb.append(ReferenceEncoder.encodeSegment(segs[0]));
		for(int i = 1; i < segs.length; i++) {
			sb.append(' ');
			sb.append(ReferenceEncoder.encodeSegment(segs[i]));
		}
		
		return sb.toString();
	}
	
	@Override
	public String getTitle(Object bo) {
		if(bo == null) {
			return null;
		}
		
		try {
			// Set context fields
			argCtx.set(Names.BUSINESS_OBJECT, bo);
			for(final Object refBuilder : referenceBuilders) {
				final String title = (String)ContextInjectionFactory.invoke(refBuilder, GetTitle.class, serviceContext, argCtx, null);
				if(title != null) {
					return title;
				}
			}
		} finally {
			// Remove entries from context
			argCtx.remove(Names.BUSINESS_OBJECT);
		}
		
		return null;
	}
	
	@Override
	public IProject getProject(Object bo) {
		// Handle EObject instances without delegating to specialized handlers
		if(bo instanceof EObject) {
			final Resource resource = ((EObject)bo).eResource();
			if(resource != null) {
				final URI uri = resource.getURI();
				if(uri != null) {
					return SelectionHelper.getProject(uri);
				}
			}
		}
		
		try {
			// Set context fields
			argCtx.set(Names.BUSINESS_OBJECT, bo);
			for(final Object refBuilder : referenceBuilders) {
				final IProject project = (IProject)ContextInjectionFactory.invoke(refBuilder, GetProject.class, serviceContext, argCtx, null);
				if(project != null) {
					return project;
				}
			}
		} finally {
			// Remove entries from context
			argCtx.remove(Names.BUSINESS_OBJECT);
		}
		
		return null;
	}
	
	@Override
	public Resource getResource(Object bo) {
		// Handle EObject instances without delegating to specialized handlers
		if(bo instanceof EObject) {
			return ((EObject)bo).eResource();
		}
		
		try {
			// Set context fields
			argCtx.set(Names.BUSINESS_OBJECT, bo);
			for(final Object refBuilder : referenceBuilders) {
				final Resource res = (Resource)ContextInjectionFactory.invoke(refBuilder, GetEmfResource.class, serviceContext, argCtx, null);
				if(res!= null) {
					return res;
				}
			}
		} finally {
			// Remove entries from context
			argCtx.remove(Names.BUSINESS_OBJECT);
		}
		
		return null;
	}
}
