package org.osate.alisa.common.typing;

import org.osate.aadl2.AadlBoolean;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.AadlString;
import org.osate.aadl2.ListType;
import org.osate.aadl2.PropertyType;

import it.xsemantics.runtime.StringRepresentation;

public class CommonStringRepresentation extends StringRepresentation {

	protected String stringRep(AadlInteger a) {
		String name = "integer";
		if (a.getUnitsType() != null) {
			name += " units " + a.getUnitsType().qualifiedName();
		}
		return name;
	}

	protected String stringRep(AadlReal a) {
		String name = "real";
		if (a.getUnitsType() != null) {
			name += " units " + a.getUnitsType().qualifiedName();
		}
		return name;
	}

	protected String stringRep(AadlBoolean a) {
		return "boolean";
	}

	protected String stringRep(AadlString a) {
		return "string";
	}

	protected String stringRep(ListType l) {
		return "list of " + stringRep(l.getElementType());
	}

	protected String stringRep(PropertyType t) {
		if (t.qualifiedName() != null) {
			return t.qualifiedName();
		} else {
			return "xxx";
		}
	}
}
