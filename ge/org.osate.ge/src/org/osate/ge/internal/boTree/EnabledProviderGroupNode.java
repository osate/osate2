package org.osate.ge.internal.boTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class EnabledProviderGroupNode {
	final BusinessObjectProviderGroup providerGroup;
	final Object businessObject; // Optional. If null, indicates that the provider group is enabled for all business objects provided by the parent
	final List<EnabledProviderGroupNode> children; // TODO: Decide on appropriate data structure
	
	public EnabledProviderGroupNode(final BusinessObjectProviderGroup providerGroup, 
			final Object businessObject,
			final List<EnabledProviderGroupNode> children) {
		this.providerGroup = Objects.requireNonNull(providerGroup, "providerGroup must not be null");
		this.businessObject = businessObject;
		this.children = Collections.unmodifiableList(new ArrayList<>(Objects.requireNonNull(children, "children must not be null")));
	}
}
