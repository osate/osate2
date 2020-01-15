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

package org.osate.codegen.checker.utils;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.properties.PropertyLookupException;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class PokProperties {

	public static final String _NAME = "pok";
	public static final String _SLOTS = "slots";
	public static final String _SLOTS_ALLOCATION = "slots_allocation";

	public static List<ComponentInstance> getSlotsAllocation(final NamedElement ne) {
		List<ComponentInstance> res;

		res = new ArrayList<ComponentInstance>();
		try {
			Property slotsAllocation = GetProperties.lookupPropertyDefinition(ne, PokProperties._NAME,
					PokProperties._SLOTS_ALLOCATION);

			List<? extends PropertyExpression> propertyValues = ne.getPropertyValueList(slotsAllocation);
			for (PropertyExpression propertyExpression : propertyValues) {

				InstanceReferenceValue ref = (InstanceReferenceValue) propertyExpression;
				res.add(ref.getReferencedInstanceObject().getComponentInstance());
			}
			return res;

		} catch (PropertyLookupException e) {
			return null;
		}
	}

	public static List<Double> getTimeSlotInMs(final NamedElement ne) {
		List<Double> res;
		UnitLiteral milliseconds;

		res = new ArrayList<Double>();
		try {
			Property slots = GetProperties.lookupPropertyDefinition(ne, PokProperties._NAME, PokProperties._SLOTS);
			milliseconds = GetProperties.getMSUnitLiteral(slots);

			List<? extends PropertyExpression> propertyValues = ne.getPropertyValueList(slots);
			for (PropertyExpression propertyExpression : propertyValues) {

				double time = ((IntegerLiteral) propertyExpression).getScaledValue(milliseconds);
				res.add(time);
			}
			return res;

		} catch (PropertyLookupException e) {
			return null;
		}
	}
}
