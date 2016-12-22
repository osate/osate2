/**
 * <copyright>
 * Copyright 2016 by Carnegie Mellon University, all rights reserved.
 * 
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * NO WARRANTY
 * 
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 * 
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 * 
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract FA8721-05-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
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
