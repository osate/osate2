/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */

package org.osate.alisa.common.typing;

import org.eclipse.xsemantics.runtime.StringRepresentation;
import org.osate.aadl2.AadlBoolean;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.AadlString;
import org.osate.aadl2.ListType;
import org.osate.aadl2.PropertyType;

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
