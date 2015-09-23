package org.osate.ge.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.osate.ge.ext.ExtensionConstants;
import org.osate.ge.ext.annotations.Activate;
import org.osate.ge.services.ExtensionRegistryService;
import org.osate.ge.services.ExtensionService;
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
	
	public static Style getStyle(final Diagram diagram, final String styleId, ExtensionService extensionService) {
		// Find the style
		final IGaService gaService = Graphiti.getGaService();
        final Style style = gaService.findStyle(diagram, styleId);
    	
        // If it does not exist, create it
        if(style == null) {
        	final Object styleFactory = styleFactoryMap.get(styleId);
        	final IEclipseContext context = Objects.requireNonNull(extensionService, "extensionService must not be null").createChildContext();
        	context.set(ExtensionConstants.STYLE_ID, styleId);
        	context.set(Diagram.class, diagram);
        	context.set(ExtensionService.class, extensionService);
        	ContextInjectionFactory.invoke(styleFactory, Activate.class, context);
        }
		
		return style;
	}
}
