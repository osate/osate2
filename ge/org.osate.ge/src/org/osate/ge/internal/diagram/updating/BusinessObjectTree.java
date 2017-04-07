package org.osate.ge.internal.diagram.updating;

import java.util.Collection;

public interface BusinessObjectTree {
	/**
	 * Returns the business object that provides additional context for the root nodes. This is used in particular for cases such as package diagrams where the package isn't shown.
	 * @return
	 */
	Object getBusinessObject();
	Collection<BusinessObjectTreeNode> getRootNodes();
}