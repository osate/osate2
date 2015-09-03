package org.osate.ge.services;

import org.eclipse.e4.core.contexts.IEclipseContext;

/**
 * Service with provides useful functionality for interacting with extensions.
 *
 */
public interface ExtensionService extends ExtensionRegistryService {
	/**
	 * Creates a context which contains the base set of services passed to all extensions.
	 * @return
	 */
	IEclipseContext createChildContext();
}
