package org.osate.ge.internal.boTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

// TODO: Implement
public class BusinessObjectProviderGroup {
	private final BusinessObjectProviderGroup parent;
	private final String id;
	private final String name;
	private final Collection<BusinessObjectProviderGroup> children = new ArrayList<>();
	private final Collection<BusinessObjectProvider> providers = new HashSet<>();
	
	public BusinessObjectProviderGroup(final BusinessObjectProviderGroup parent, final String id, final String name) {
		this.parent = parent;
		this.id = Objects.requireNonNull(id, "id must not be null");
		this.name = Objects.requireNonNull(name, "name must not be null");
		
		if(parent != null) {
			parent.children.add(this);
		}
	}
	
	public String getName() {
		return name;
	}
}
