package org.osate.ui.navigator;

import org.eclipse.core.resources.IProject;

public final class VirtualProjectDependencies {
	private final IProject project;
	private final VirtualProjectNode[] children;

	public VirtualProjectDependencies(final IProject project, final IProject[] children) {
		this.project = project;
		this.children = new VirtualProjectNode[children.length];
		for (int i = 0; i < children.length; i++) {
			this.children[i] = new VirtualProjectNode(this, children[i]);
		}
	}

	public IProject getProject() {
		return project;
	}

	public boolean hasChildren() {
		return children.length > 0;
	}

	public VirtualProjectNode[] getChildren() {
		return children;
	}
}
