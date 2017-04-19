package org.osate.ge.internal.util;

import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.BusinessObjectContext;

public class AadlSubcomponentUtil {
	public static ComponentClassifier getComponentClassifier(final BusinessObjectContext boc, final Subcomponent sc) {
		if(sc.getPrototype() == null) {
			if(sc.getClassifier() == null && sc.getRefined() != null) {
				return getComponentClassifier(boc, sc.getRefined());
			} else {
				return sc.getClassifier();
			}
		} else {
			return AadlPrototypeUtil.getComponentClassifier(AadlPrototypeUtil.getPrototypeBindingContext(boc), sc);	
		}
	}
}
