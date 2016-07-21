package org.osate.ui.navigator;

import org.eclipse.emf.common.util.URI;

public class ContributedAadlFile {
	private final URI uri;
	private final Object parent;
	
	public ContributedAadlFile(URI uri, Object parent) {
		this.uri = uri;
		this.parent = parent;
	}
	
	public URI getURI() {
		return uri;
	}
	
	public Object getParent() {
		return parent;
	}
}