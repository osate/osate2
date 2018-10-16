package org.osate.ui.navigator;

import org.eclipse.core.resources.IProject;

public final class VirtualProjectDependencies {
	private final IProject project;
	private final IProject[] children;

	public VirtualProjectDependencies(final IProject project, final IProject[] children) {
		this.project = project;
		this.children = children;
	}

	public IProject getProject() {
		return project;
	}

	public boolean hasChildren() {
		return children.length > 0;
	}

	public IProject[] getChildren() {
		return children;
	}
}
