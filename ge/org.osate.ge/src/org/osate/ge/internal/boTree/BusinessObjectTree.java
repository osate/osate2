package org.osate.ge.internal.boTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

//TODO: Cleanup. Rename and/or merge with org.osate.ge.internal.diagram as appropriate.
class BusinessObjectTree {
	private final List<BusinessObjectTreeNode> rootNodes;
	
	public BusinessObjectTree(final List<BusinessObjectTreeNode> rootNodes) {
		this.rootNodes = Collections.unmodifiableList(new ArrayList<>(Objects.requireNonNull(rootNodes, "rootNodes must not be null")));
	}
}
