package org.osate.ge.internal;

public interface BusinessObjectContext {
	BusinessObjectContext getParent();
	Object getBusinessObject();
}
