package org.osate.ge.services;

import java.util.Collection;

import org.osate.ge.services.impl.DefaultExtensionRegistryService;
import org.osate.ge.services.impl.SimpleServiceFactory;

public interface ExtensionRegistryService {
	public static class Factory extends SimpleServiceFactory {
		public Factory() {
			super(ExtensionRegistryService.class, DefaultExtensionRegistryService.class);
		}
	}

	/**
	 * Tools are objects that allow the user to perform a specific action using the editor. Only a single tool may be active at a time and tools should have their own 
	 * user interface to provide feedback to the user. 
	 * The following annotations are used with tools:
	 * Activate - Required
	 * CanActivate - Optional
	 * Deactivate - Required
	 * Description - Required
	 * Icon - Required
	 * Id - Required
	 * SelectionChanged - Optional
	 */
    Collection<Object> getTools();

	Object getStyleFactory(String styleId);
}
