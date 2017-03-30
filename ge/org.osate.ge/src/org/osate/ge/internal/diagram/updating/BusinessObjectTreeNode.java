package org.osate.ge.internal.diagram.updating;

import java.util.Collection;

import org.osate.ge.internal.diagram.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.RelativeBusinessObjectReference;

public interface BusinessObjectTreeNode {
	Object getBusinessObject();
	RelativeBusinessObjectReference getRelativeReference();
	CanonicalBusinessObjectReference getCanonicalReference();
	Collection<BusinessObjectTreeNode> getChildren();
	String getName(); // Get name for the business object's name label
	Object getBusinessObjectHandler();
}