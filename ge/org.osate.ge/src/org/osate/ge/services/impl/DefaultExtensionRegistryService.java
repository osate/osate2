package org.osate.ge.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.osate.ge.services.ExtensionRegistryService;

/**
 * Instantiates extensions which are registered via extension points.
 */
public class DefaultExtensionRegistryService implements ExtensionRegistryService {
	private final ArrayList<Object> tools = new ArrayList<Object>();
	private static final String TOOL_EXTENSION_POINT_ID = "org.osate.ge.tools";

	public DefaultExtensionRegistryService() {
		final IExtensionRegistry registry = Platform.getExtensionRegistry();
		
		// Instantiate Tools
		final IExtensionPoint point = registry.getExtensionPoint(TOOL_EXTENSION_POINT_ID);
		if(point != null) {
			// Iterate over all the extensions
			for(final IExtension extension : point.getExtensions()) {
				for(final IConfigurationElement ce : extension.getConfigurationElements()) {
					if(ce.getName().equals("tool")) {
						try {								
							final Object tool = (Object)ce.createExecutableExtension("class");
							tools.add(tool);
						} catch(final CoreException ex) {
							throw new RuntimeException(ex);
						}
					}
				}
			}
		}
	}

	@Override
	public Collection<Object> getTools() {
		return Collections.unmodifiableList(tools);
	}
}
