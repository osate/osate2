// Based on OSATE Graphical Editor. Modifications are: 
/*
Copyright (c) 2016, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
*/
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
import org.osate.ge.di.Activate;
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
	
	private static class TooltipContributorInfo {
		final private int priority;
		final private Object object;
		public TooltipContributorInfo(final int priority, final Object object) {
			this.priority = priority;
			this.object = object;
		}
		
		public int getPriority() {
			return priority;
		}
		
		public Object getObject() {
			return object;
		}
	}
	
	private static final String TOOL_EXTENSION_POINT_ID = "org.osate.ge.tools";
	private static final String BUSINESS_OBJECT_HANDLERS_EXTENSION_POINT_ID = "org.osate.ge.businessObjectHandlers";
	private static final String TOOLTIP_EXTENSION_POINT_ID = "org.osate.ge.tooltips";
	private static final String COMMAND_EXTENSION_POINT_ID = "org.osate.ge.commands";
	private static final String CATEGORIES_EXTENSION_POINT_ID = "org.osate.ge.categories";
	
	private final Collection<Object> tools;
	private final Collection<Object> boHandlers;
	private final Collection<Object> commands;	
	private final List<Category> categories;
	private final Collection<Object> tooltipContributors;
	
	public DefaultExtensionRegistryService() {
		final IExtensionRegistry registry = Platform.getExtensionRegistry();		
		tools = instantiateTools(registry);
		boHandlers = instantiateBusinessObjectHandlers(registry);
		tooltipContributors = instantiateTooltipContributors(registry);
		commands = instantiateCommands(registry);
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

			// Find the business object handler which is applicable for this business object
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
	
	@Override
	public Collection<Object> getTooltipContributors() {
		return tooltipContributors;
	}
	
	@Override
	public Collection<Object> getCommands() {
		return commands;
	}
	
	private static Collection<Object> instantiateTools(final IExtensionRegistry registry) {
		return Collections.unmodifiableCollection(instantiateSimpleExtensions(registry, TOOL_EXTENSION_POINT_ID, "tool"));
	}
	
	private static Collection<Object> instantiateBusinessObjectHandlers(final IExtensionRegistry registry) {
		return Collections.unmodifiableCollection(instantiateSimpleExtensions(registry, BUSINESS_OBJECT_HANDLERS_EXTENSION_POINT_ID, "handler"));
	}

	private static Collection<Object> instantiateTooltipContributors(final IExtensionRegistry registry) {
		final Comparator<TooltipContributorInfo> tooltipContributorPriorityComparator = new Comparator<TooltipContributorInfo>() {
			@Override
			public int compare(final TooltipContributorInfo tooltipContributor1, final TooltipContributorInfo tooltipContributor2) {
				return Integer.compare(tooltipContributor1.getPriority(), tooltipContributor2.getPriority());
			}
		};
		
		final Collection<Object> tooltipContributors = new ArrayList<Object>();
		final IExtensionPoint tooltipContributorsExtPoint = registry.getExtensionPoint(TOOLTIP_EXTENSION_POINT_ID);
		if(tooltipContributorsExtPoint != null) {
			final ArrayList<TooltipContributorInfo> tooltipContributorInfos = new ArrayList<TooltipContributorInfo>();
			for(final IExtension extension : tooltipContributorsExtPoint.getExtensions()) {
				for(final IConfigurationElement ce : extension.getConfigurationElements()) {
					if(ce.getName().equals("tooltipContributor")) {
						final int priority = Integer.parseInt(ce.getAttribute("priority"));
						try {
							final Object contributor = (Object)ce.createExecutableExtension("class");
							final TooltipContributorInfo tooltipContributerInfo = new TooltipContributorInfo(priority, contributor);
							tooltipContributorInfos.add(tooltipContributerInfo);
						} catch (final CoreException e) {
							throw new RuntimeException(e);
						}
					}
				}
			}
			
			tooltipContributorInfos.sort(tooltipContributorPriorityComparator);
			for (final TooltipContributorInfo t : tooltipContributorInfos) {
				tooltipContributors.add(t.getObject());
			}
		}
		
		return Collections.unmodifiableCollection(tooltipContributors);
	}
	
	private static Collection<Object> instantiateCommands(final IExtensionRegistry registry) {
		final Collection<Object> commands = instantiateSimpleExtensions(registry, COMMAND_EXTENSION_POINT_ID, "command");
		
		// Activate command contributors to create commands
		final IEclipseContext ctx = EclipseContextFactory.create();
		try {
			for(final Object commandContributor : instantiateSimpleExtensions(registry, COMMAND_EXTENSION_POINT_ID, "commandContributor")) {
				@SuppressWarnings("unchecked")
				final Collection<Object> contributedCommands = (Collection<Object>)ContextInjectionFactory.invoke(commandContributor, Activate.class, ctx);
				if(contributedCommands != null) {
					commands.addAll(contributedCommands);
				}
			}
		} finally {
			ctx.dispose();
		}		
		
		return Collections.unmodifiableCollection(commands);
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
		
		return extensions;
	}
	
	// Returns an unmodifiable collection containing the objects created by the id and name attribute of all configuration elements
	// with the specified name for a specified extension point.
	private static List<Category> instantiateCategories(IExtensionRegistry registry) {
		final List<SimpleCategory> extensions = new ArrayList<SimpleCategory>();
		final IExtensionPoint point = registry.getExtensionPoint(CATEGORIES_EXTENSION_POINT_ID);
		if(point != null) {
			// Build a list of category config elements from all extensions so that they can be sorted.
			final List<IConfigurationElement> categoryConfigElements = new ArrayList<>();
			for(final IExtension extension : point.getExtensions()) {
				final IConfigurationElement[] tempConfigElements = extension.getConfigurationElements();
				for(final IConfigurationElement ce : tempConfigElements) {
					categoryConfigElements.add(ce);
				}
			}

			categoryConfigElements.sort(orderComparator);
			
			// Create the category objects
			for(final IConfigurationElement ce : categoryConfigElements) {
				final String categoryId = ce.getAttribute("id");
				final String categoryName = ce.getAttribute("name");
				final SimpleCategory category = new SimpleCategory(categoryId, categoryName);
				extensions.add(category);
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
