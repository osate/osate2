package org.osate.ui.navigator;

import java.util.List;

import org.eclipse.emf.common.util.URI;

public class ContributedDirectory {
	private final String name;
	private final List<URI> members;
	
	public ContributedDirectory(String name, List<URI> members) {
		this.name = name;
		this.members = members;
	}
	
	public String getName() {
		return name;
	}
	
	public List<URI> getMembers() {
		return members;
	}
}