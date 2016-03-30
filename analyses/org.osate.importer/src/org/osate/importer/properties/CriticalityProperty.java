/*
 * Copyright 2013 Carnegie Mellon University

 * Any opinions, findings and conclusions or recommendations expressed in this 
 * Material are those of the author(s) and do not necessarily reflect the 
 * views of the United States Department of Defense. 

 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING 
 * INSTITUTE MATERIAL IS FURNISHED ON AN �AS-IS� BASIS. CARNEGIE MELLON 
 * UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, 
 * AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR 
 * PURPOSE OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF 
 * THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT MAKE ANY WARRANTY OF 
 * ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT 
 * INFRINGEMENT.
 * 
 * This Material has been approved for public release and unlimited 
 * distribution except as restricted below. 
 * 
 * This Material is provided to you under the terms and conditions of the 
 * Eclipse Public License Version 1.0 ("EPL"). A copy of the EPL is 
 * provided with this Content and is also available at 
 * http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Carnegie Mellon� is registered in the U.S. Patent and Trademark 
 * Office by Carnegie Mellon University. 
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
