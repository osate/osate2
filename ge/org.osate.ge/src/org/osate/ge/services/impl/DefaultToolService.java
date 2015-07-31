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
import org.osate.ge.services.ToolService;
import org.osate.ge.util.Log;

/**
 * Instantiates tools which are registered to the tool extension point.
 */
public class DefaultToolService implements ToolService {

	final ArrayList<Object> AGETools = new ArrayList<Object>();

	public DefaultToolService() {
		final IExtensionRegistry registry = Platform.getExtensionRegistry();
		final IExtensionPoint point = registry.getExtensionPoint("org.osate.ge.tools");
		if(point != null) {
			// Iterate over all the extensions
			for(final IExtension extension : point.getExtensions()) {
				for(final IConfigurationElement ce : extension.getConfigurationElements()) {
					if(ce.getName().equals("tool")) {
						try {								
							final Object tool = (Object)ce.createExecutableExtension("class");
							AGETools.add(tool);
						} catch(final CoreException ex) {
							//TODO: Update maybe
							Log.error("Error creating AGE tool: " + ex);
						}
					}
				}
			}
		}
	}

	@Override
	public Collection<Object> getTools() {
		return Collections.unmodifiableList(AGETools);
	}
}
