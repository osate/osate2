package org.osate.ge.services.impl;

import java.util.Collection;
import java.util.Collections;

import org.osate.ge.services.ToolService;
import org.osate.ge.ui.tools.CreateEndToEndFlowTool;

/**
 * Instantiates tools which are registered to the tool extension point.
 */
public class DefaultToolService implements ToolService {
	public DefaultToolService() {
		// TODO: Instantiate tools
	}
	
	@Override
	public Collection<Object> getTools() {
		// TODO: Return unmodifiable list of tools		
		return Collections.singleton((Object)new CreateEndToEndFlowTool());
	}
}
