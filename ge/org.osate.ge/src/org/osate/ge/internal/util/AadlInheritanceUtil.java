package org.osate.ge.internal.util;

import org.osate.aadl2.Element;
import org.osate.ge.BusinessObjectContext;

// Contains helper functions related to model elements which may originated from extended classifiers
public class AadlInheritanceUtil {
	public static boolean isInherited(final BusinessObjectContext boc) {
		return boc.getParent() != null && 
				boc.getBusinessObject() instanceof Element && 
				((Element)boc.getBusinessObject()).getContainingClassifier() != boc.getParent().getBusinessObject();
	}
	
}
