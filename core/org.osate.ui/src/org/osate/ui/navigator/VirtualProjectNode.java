package org.osate.ui.navigator;

import org.eclipse.core.resources.IProject;

public final class VirtualProjectNode {
	private final VirtualProjectDependencies parent;
	private final IProject project;

	public VirtualProjectNode(final VirtualProjectDependencies parent, final IProject project) {
		this.parent = parent;
		this.project = project;
	}

	public VirtualProjectDependencies getParent() {
		return parent;
	}

	public IProject getProject() {
		return project;
	}

	public String getLabel() {
		return project.getName();
	}
}
