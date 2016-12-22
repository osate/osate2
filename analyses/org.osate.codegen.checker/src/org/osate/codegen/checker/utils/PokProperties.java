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
