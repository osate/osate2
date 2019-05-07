package org.osate.ui.navigator;

import org.eclipse.core.resources.IProject;

public final class VirtualPluginResources {
	private final IProject project;

	public VirtualPluginResources(final IProject project) {
		this.project = project;
	}

	public IProject getParent() {
		return project;
	}

}