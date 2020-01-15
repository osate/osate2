/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */

package org.osate.importer.properties;

import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.properties.PropertyLookupException;
import org.osate.contribution.sei.names.ARINC653;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;

public class CriticalityProperty {

	private static Property criticalityProperty = null;
	public static final int INVALID_CRITICALITY = 0;
	public static final int LEVEL_A = 1;
	public static final int LEVEL_B = 2;
	public static final int LEVEL_C = 3;
	public static final int LEVEL_D = 4;
	public static final int LEVEL_E = 5;

	public static final int NB_CRITICALITIES = 6;

	public static String toString(int criticalityValue) {
		switch (criticalityValue) {
		case LEVEL_A: {
			return "A";
		}
		case LEVEL_B: {
			return "B";
		}
		case LEVEL_C: {
			return "C";
		}
		case LEVEL_D: {
			return "D";
		}
		case LEVEL_E: {
			return "E";
		}
		default: {
			return "N/A";
		}
		}
	}

	public static int getCriticality(final NamedElement ph) {

		if (criticalityProperty == null) {
			criticalityProperty = GetProperties.lookupPropertyDefinition(ph, ARINC653._NAME, ARINC653.DAL);
		}

		try {
			EnumerationLiteral el = PropertyUtils.getEnumLiteral(ph, criticalityProperty);
			if (el.getName().equals(ARINC653.DAL_LEVEL_A)) {
				return LEVEL_A;
			}

			if (el.getName().equals(ARINC653.DAL_LEVEL_B)) {
				return LEVEL_B;
			}

			if (el.getName().equals(ARINC653.DAL_LEVEL_C)) {
				return LEVEL_C;
			}

			if (el.getName().equals(ARINC653.DAL_LEVEL_D)) {
				return LEVEL_D;
			}

			if (el.getName().equals(ARINC653.DAL_LEVEL_E)) {
				return LEVEL_E;
			}

		} catch (PropertyLookupException e) {
			return INVALID_CRITICALITY;
		}

		return INVALID_CRITICALITY;
	}
}
