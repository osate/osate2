package org.osate.ge.internal.aadlproperties;

import org.osate.aadl2.ListType;
import org.osate.aadl2.ReferenceType;
import org.osate.aadl2.Type;

public class AadlPropertyUtil {
	public static boolean isReferenceOrListReferenceType(final Type type) {
		if (type instanceof ListType) {
			return isReferenceOrListReferenceType(((ListType) type).getOwnedElementType());
		}

		return type instanceof ReferenceType;
	}
}
