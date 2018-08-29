package org.osate.ui.navigator;

import java.util.List;

public class ContributedDirectory {
	private final List<String> path;
	
	public ContributedDirectory(List<String> path) {
		this.path = path;
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