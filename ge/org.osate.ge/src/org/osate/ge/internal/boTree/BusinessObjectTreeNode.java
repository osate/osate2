package org.osate.ge.internal.boTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BusinessObjectTreeNode {
	private final Object businessObject;
	private final List<BusinessObjectTreeNode> children;
	
	public BusinessObjectTreeNode(final Object businessObject, final List<BusinessObjectTreeNode> children) {
		this.businessObject = businessObject;
		this.children = Collections.unmodifiableList(new ArrayList<>(Objects.requireNonNull(children, "children must not be null")));
	}	
}
