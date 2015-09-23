package org.osate.ge.services.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.osate.ge.services.ExtensionRegistryService;
/**
 * Instantiates extensions which are registered via extension points.
 */
public class DefaultExtensionRegistryService implements ExtensionRegistryService {
	private static final String TOOL_EXTENSION_POINT_ID = "org.osate.ge.tools";
	private static final String STYLE_EXTENSION_POINT_ID = "org.osate.ge.styles";
	
	/**
	 * Mapping from style id's to style factories.
	 */
	public static Map<String, Object> styleFactoryMap = new HashMap<String, Object>();
	private final Collection<Object> tools;

	public DefaultExtensionRegistryService() {
		final IExtensionRegistry registry = Platform.getExtensionRegistry();		
		tools = instantiateTools(registry);
		instantiateStyles(registry);
	}

	@Override
	public Collection<Object> getTools() {
		return tools;
	}
	
	@Override
	public Object getStyleFactory(final String styleId) {
		return styleFactoryMap.get(styleId);
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
	
	public static void instantiateStyles(final IExtensionRegistry registry) {
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
	}
	
	public static Style getStyle(final Diagram diagram, final String id) {
		// Find the style
		final IGaService gaService = Graphiti.getGaService();
        final Style style = gaService.findStyle(diagram, id);
    	
        // If it does not exist, create it
        if(style == null) {
        	final Object styleFactory = styleFactoryMap.get(id);
        	Method t = styleFactory.getClass().getMethods()[0];
        	Object[] args = new Object[2];
        	args[0] = id;
        	args[1] = diagram;
        	// Create the style
        	if(styleFactory != null) {
        		try {
					return (Style)t.invoke(styleFactory, args);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		//return styleFactory.create(id, diagram);
        	}        		
        }
		
		return style;
	}
}
