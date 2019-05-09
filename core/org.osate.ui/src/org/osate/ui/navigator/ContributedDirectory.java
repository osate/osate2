package org.osate.ui.navigator;

import java.util.List;

public class ContributedDirectory {

	private Object parent;

	private final List<String> path;

	public ContributedDirectory(Object parent, List<String> path) {
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
	public boolean equals(Object obj) {
		return obj instanceof ContributedDirectory && ((ContributedDirectory)obj).path.equals(path);
	}

	@Override
	public int hashCode() {
		return path.hashCode();
	}
}