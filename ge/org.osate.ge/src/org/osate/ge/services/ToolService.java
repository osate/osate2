package org.osate.ge.services;

import java.util.Collection;

import org.osate.ge.services.impl.DefaultToolService;
import org.osate.ge.services.impl.SimpleServiceFactory;

/**
 * Tools are objects that allow the user to perform a specific action using the editor. Only a single tool may be active at a time and tools should have their own 
 * user interface to provide feedback to the user. 
 */
public interface ToolService {
	public static class Factory extends SimpleServiceFactory {
		public Factory() {
			super(ToolService.class, DefaultToolService.class);
		}
	}
	
    Collection<Object> getTools();
}
