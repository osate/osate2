package org.osate.ui.navigator;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.osate.xtext.aadl2.ui.resource.ProjectMember;

public class ContributedDirectory implements ProjectMember {

	private ProjectMember parent;

	private final List<String> path;

	public ContributedDirectory(ProjectMember parent, List<String> path) {
		this.path = path;
		this.parent = parent;
	}

	public Object getParent() {
		return parent;
	}

	public List<String> getPath() {
		return path;
	}
	
	@Override
	public IProject getProject() {
		return parent.getProject();
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof ContributedDirectory && ((ContributedDirectory)obj).path.equals(path);
	}

	@Override
	public int hashCode() {
		return path.hashCode();
	}
}