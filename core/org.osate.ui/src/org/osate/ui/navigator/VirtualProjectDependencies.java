package org.osate.ui.navigator;

import org.eclipse.core.resources.IProject;

public final class VirtualProjectDependencies {
	private IProject[] children;

	public VirtualProjectDependencies(final IProject[] children) {
		this.children = children;
	}

	public IProject[] getChildren() {
		return children;
	}
}
