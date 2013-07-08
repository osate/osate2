package edu.uah.rsesc.aadl.age.styles;

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

import edu.uah.rsesc.aadl.age.util.Log;

public class StyleProviderImpl implements StyleProvider {
	/**
	 * Mapping from style id's to style factories.
	 */
	private Map<String, StyleFactory> styleFactoryMap = new HashMap<String, StyleFactory>();
	
	public StyleProviderImpl() {
		// Get the extension point
		final IExtensionRegistry registry = Platform.getExtensionRegistry();
		final IExtensionPoint point = registry.getExtensionPoint("org.uah.rsesc.aadl.age.styles");
		if(point != null) {
			// Iterate over all the extensions
			for(final IExtension extension : point.getExtensions()) {
				// Create the declared style factories
				for(final IConfigurationElement ce : extension.getConfigurationElements()) {
					if(ce.getName().equals("factory")) {
						final String styleId = ce.getAttribute("styleId");
						if(styleId != null) {
							try {								
								final StyleFactory styleFactory = (StyleFactory)ce.createExecutableExtension("class");
								styleFactoryMap.put(styleId,  styleFactory);
							} catch(final CoreException ex) {
								Log.error("Error creating AGE style factory for style: " + styleId, ex);
							}
						}
					}
				}
			}
		}
	}
	
	@Override
	public Style getStyle(final Diagram diagram, final String id) {
		// Find the style
		final IGaService gaService = Graphiti.getGaService();
        final Style style = gaService.findStyle(diagram, id);
        
        // If it does not exist, create it
        if(style == null) {
        	final StyleFactory styleFactory = styleFactoryMap.get(id);
        	
        	// Create the style
        	if(styleFactory != null) {
        		return styleFactory.create(id, diagram);
        	}        		
        }
		
		return style;
	}
}
