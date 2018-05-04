package org.osate.ge.internal.util;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.ge.BusinessObjectContext;

// Contains helper functions related to model elements which may originated from extended classifiers
public class AadlInheritanceUtil {
	public static boolean isInherited(final BusinessObjectContext boc) {
		if (boc.getParent() != null && boc.getBusinessObject() instanceof Element) {
			final Element e = ((Element) boc.getBusinessObject());
			final Classifier c = e.getContainingClassifier();
			if (c != null && c != boc.getParent().getBusinessObject()) {
				return true;
			}
		}

		return false;
	}
}
