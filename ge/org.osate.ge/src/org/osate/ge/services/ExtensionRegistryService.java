package org.osate.ge.services;

import java.util.Collection;

public interface ExtensionRegistryService {
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

	/**
	 * Style factories create styles.  
	 * The following annotations are used with style factories:
	 * Activate - Required
	 */
	Object getStyleFactory(String styleId);
}
