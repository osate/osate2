package org.osate.ge.internal.boTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BusinessObjectTree {
	private final List<BusinessObjectTreeNode> rootNodes;
	
	public BusinessObjectTree(final List<BusinessObjectTreeNode> rootNodes) {
		this.rootNodes = Collections.unmodifiableList(new ArrayList<>(Objects.requireNonNull(rootNodes, "rootNodes must not be null")));
	}
}
