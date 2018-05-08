package org.osate.ge.internal.services;

import org.eclipse.core.resources.IProject;

public interface ProjectProvider {	
	/**
	 * Get the project containing the current diagram
	 * @return
	 */
	IProject getProject();
}
