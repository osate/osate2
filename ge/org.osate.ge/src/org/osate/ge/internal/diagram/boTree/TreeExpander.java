package org.osate.ge.internal.diagram.boTree;

import org.osate.ge.internal.diagram.DiagramConfiguration;

public interface TreeExpander {
	/**
	 * Creates a new tree expanded based on the current state and the diagram configuration.
	 * @param configuration
	 * @param tree
	 * @return
	 */
	BusinessObjectNode expandTree(final DiagramConfiguration configuration, BusinessObjectNode tree);
}
