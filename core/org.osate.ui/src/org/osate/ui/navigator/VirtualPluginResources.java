package org.osate.ui.navigator;

import org.eclipse.core.resources.IProject;
import org.osate.xtext.aadl2.ui.resource.ProjectMember;

public final class VirtualPluginResources implements ProjectMember {
	private final IProject project;

	public VirtualPluginResources(final IProject project) {
		this.project = project;
	}

	public IProject getParent() {
		return project;
	}
	
	@Override
	public IProject getProject() {
		return project;
	}
}