package org.osate.ge.internal.util;

import java.util.HashMap;
import java.util.Map;

import org.osate.ge.internal.diagram.runtime.boTree.BusinessObjectNode;

/**
 * Helper class for determining if a node is part of manual branch. A manual branch is one where the node or one of its descendant is set to manual.
 *
 */
public class ManualBranchCache {
	private final Map<BusinessObjectNode, Boolean> manualBranchMap = new HashMap<>();

	public void reset() {
		manualBranchMap.clear();
	}

	public boolean isManualBranch(final BusinessObjectNode node) {
		final Boolean cachedIsManual = manualBranchMap.get(node);
		if (cachedIsManual != null) {
			return cachedIsManual;
		}

		boolean isManual = false;
		if (node.isManual()) {
			isManual = true;
		} else {
			for (final BusinessObjectNode child : node.getChildren()) {
				if (isManualBranch(child)) {
					isManual = true;
					break;
				}
			}
		}

		// Cache the value
		manualBranchMap.put(node, isManual);

		return isManual;
	}
}