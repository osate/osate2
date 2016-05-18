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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.Categories;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.services.ExtensionRegistryService;

/**
 * Instantiates extensions which are registered via extension points.
 */
public class DefaultExtensionRegistryService implements ExtensionRegistryService {
	public static class ContextFunction extends SimpleServiceContextFunction<ExtensionRegistryService> {
		@Override
		public ExtensionRegistryService createService(final IEclipseContext context) {
			return new DefaultExtensionRegistryService();
		}		
	}
	
	private static final String TOOL_EXTENSION_POINT_ID = "org.osate.ge.tools";
	private static final String BUSINESS_OBJECT_HANDLERS_EXTENSION_POINT_ID = "org.osate.ge.businessObjectHandlers";
	private static final String CATEGORIES_EXTENSION_POINT_ID = "org.osate.ge.categories";
	
	private final Collection<Object> tools;
	private final Collection<Object> boHandlers;
	private final List<Category> categories;
	
	public DefaultExtensionRegistryService() {
		final IExtensionRegistry registry = Platform.getExtensionRegistry();		
		tools = instantiateTools(registry);
		boHandlers = instantiateBusinessObjectHandlers(registry);
		categories = instantiateCategories(registry);
	}

	@Override
	public Collection<Object> getTools() {
		return tools;
	}
	
	@Override
	public Collection<Object> getBusinessObjectHandlers() {
    	return boHandlers;
    }
	
	@Override
	public Object getApplicableBusinessObjectHandler(final Object bo) {
		final IEclipseContext eclipseCtx =  EclipseContextFactory.create();

		try {
			eclipseCtx.set(Names.BUSINESS_OBJECT, bo);

			// Find the business object handler which can be used to handle the double-click
			for(final Object handler : getBusinessObjectHandlers()) {
				final boolean isApplicable = (boolean)ContextInjectionFactory.invoke(handler, IsApplicable.class, eclipseCtx, false);
				if(isApplicable) {
					return handler;
				}
				
			}
			
		} finally {
			eclipseCtx.dispose();
		}
		
		return null;
	}
	
	@Override
	public List<Category> getCategories() {
		return categories;
	}
	
	private static Collection<Object> instantiateTools(final IExtensionRegistry registry) {
		return instantiateSimpleExtensions(registry, TOOL_EXTENSION_POINT_ID, "tool");
	}
	
	private static Collection<Object> instantiateBusinessObjectHandlers(final IExtensionRegistry registry) {
		return instantiateSimpleExtensions(registry, BUSINESS_OBJECT_HANDLERS_EXTENSION_POINT_ID, "handler");
	}

	// Returns an unmodifiable collection containing the objects created by instantiating class referenced by the "class" attribute of all configuration elements
	// with the specified name for a specified extension point.
	private static Collection<Object> instantiateSimpleExtensions(final IExtensionRegistry registry, final String extensionPointId, final String elementName) {
		final Collection<Object> extensions = new ArrayList<Object>();
		
		final IExtensionPoint point = registry.getExtensionPoint(extensionPointId);
		if(point != null) {
			// Iterate over all the extensions
			for(final IExtension extension : point.getExtensions()) {
				for(final IConfigurationElement ce : extension.getConfigurationElements()) {
					if(ce.getName().equals(elementName)) {
						try {								
							final Object ext = (Object)ce.createExecutableExtension("class");
							extensions.add(ext);
						} catch(final CoreException ex) {
							throw new RuntimeException(ex);
						}
					}
				}
			}
		}
		
		return Collections.unmodifiableCollection(extensions);
	}
	
	// Returns an unmodifiable collection containing the objects created by the id and name attribute of all configuration elements
	// with the specified name for a specified extension point.
	private static List<Category> instantiateCategories(IExtensionRegistry registry) {
		final List<SimpleCategory> extensions = new ArrayList<SimpleCategory>();
		final IExtensionPoint point = registry.getExtensionPoint(CATEGORIES_EXTENSION_POINT_ID);
		if(point != null) {
			for(final IExtension extension : point.getExtensions()) {
				final IConfigurationElement[] tempConfigElements = extension.getConfigurationElements();
				Arrays.sort(tempConfigElements, orderComparator);
				for(final IConfigurationElement ce : tempConfigElements) {
					final String categoryId = ce.getAttribute("id");
					final String categoryName = ce.getAttribute("name");
					final SimpleCategory category = new SimpleCategory(categoryId, categoryName);
					extensions.add(category);
				}
			}
		}
		
		extensions.add(new SimpleCategory(Categories.MISC, "Miscellaneous"));
		return Collections.unmodifiableList(extensions);
	}
	
	private static final Comparator<IConfigurationElement> orderComparator 
	= new Comparator<IConfigurationElement>() {
		@Override
		public int compare(final IConfigurationElement ce1, final IConfigurationElement ce2) {
			return Integer.valueOf(ce1.getAttribute("order")).compareTo(Integer.valueOf(ce2.getAttribute("order")));
		}
	};
	
	private static class SimpleCategory implements Category {
		private String id;
		private String name;
		
		public SimpleCategory(final String id, final String name) {
			this.id = id;
			this.name = name;
		}
		
		@Override
		public String getId() {
			return id;
		}

		@Override
		public String getName() {
			return name;
		}
	}
}
