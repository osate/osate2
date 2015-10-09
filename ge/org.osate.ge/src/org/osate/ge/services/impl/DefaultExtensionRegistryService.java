package org.osate.ge.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.osate.ge.ext.Categories;
import org.osate.ge.services.ExtensionRegistryService;
/**
 * Instantiates extensions which are registered via extension points.
 */
public class DefaultExtensionRegistryService implements ExtensionRegistryService {
	public static class ContextFunction extends SimpleServiceContextFunction<ExtensionRegistryService> {
		@Override
		public ExtensionRegistryService createService() {
			return new DefaultExtensionRegistryService();
		}		
	}
	
	private static final String TOOL_EXTENSION_POINT_ID = "org.osate.ge.tools";
	private static final String STYLE_EXTENSION_POINT_ID = "org.osate.ge.styles";
	private static final String CATEGORIES_EXTENSION_POINT_ID = "org.osate.ge.categories";
	
	/**
	 * Mapping from style id's to style factories.
	 */
	private final Collection<Object> tools;
	private final Map<String, Object> styleFactoryMap;
	private final List<Category> categories;
	
	public DefaultExtensionRegistryService() {
		final IExtensionRegistry registry = Platform.getExtensionRegistry();		
		tools = instantiateTools(registry);
		styleFactoryMap = instantiateStyles(registry);
		categories = instantiateCategories(registry);
	}

	@Override
	public Collection<Object> getTools() {
		return tools;
	}
	
	@Override
	public Object getStyleFactory(final String styleId) {
		return styleFactoryMap.get(styleId);
	}
	
	@Override
	public List<Category> getCategories() {
		return categories;
	}
	
	private static Collection<Object> instantiateTools(final IExtensionRegistry registry) {
		return instantiateSimpleExtensions(registry, TOOL_EXTENSION_POINT_ID, "tool");
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
	
	public static Map<String, Object> instantiateStyles(final IExtensionRegistry registry) {
		final Map<String, Object> styleFactoryMap = new HashMap<>();
		
		// Get the extension point
		final IExtensionPoint point = registry.getExtensionPoint(STYLE_EXTENSION_POINT_ID);
		if(point != null) {
			// Iterate over all the extensions
			for(final IExtension extension : point.getExtensions()) {
				// Create the declared style factories
				for(final IConfigurationElement ce : extension.getConfigurationElements()) {
					if(ce.getName().equals("factory")) {
						final String styleId = ce.getAttribute("styleId");
						if(styleId != null) {
							try {								
								final Object styleFactory = (Object)ce.createExecutableExtension("class");
								styleFactoryMap.put(styleId,  styleFactory);
							} catch(final CoreException ex) {
								throw new RuntimeException("Error creating AGE style factory for style: " + styleId, ex);
							}
						}
					}
				}
			}
		}
		
		return styleFactoryMap;
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
