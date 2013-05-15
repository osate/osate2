package org.osate.xtext.aadl2.ui.propertyview.associationwizard.assistant;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.serializer.ISerializer;
import org.osate.aadl2.AadlBoolean;
import org.osate.aadl2.AadlString;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NumberType;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RangeType;

public class AssistantFactory
{
	private AssistantFactory(){}
	
	public static AbstractAssistant getAssistantForType(Composite parent, PropertyType type, ISerializer serializer, NamedElement holder, AssistantValueChangedListener listener) {
		if (type instanceof EnumerationType)
			return new EnumerationAssistant(parent, (EnumerationType)type, listener);
		else if (type instanceof AadlBoolean)
			return new BooleanAssistant(parent, listener);
		else if (type instanceof AadlString)
			return new StringAssistant(parent, listener);
		else if (type instanceof NumberType) {
			NumberType numType = (NumberType)type;
			if (numType.getUnitsType() == null)
				return new SingleNumberTypeAssistant(parent, numType, serializer, listener);
			else
				return new SingleNumberTypeWithUnitsAssistant(parent, numType, serializer, listener);
		}
		else if (type instanceof RangeType) {
			NumberType numType = ((RangeType)type).getNumberType();
			if (numType.getUnitsType() == null)
				return new NumberTypeRangeAssistant(parent, numType, serializer, listener);
			else
				return new NumberTypeRangeWithUnitsAssistant(parent, numType, serializer, listener);
		}
		else
			return null;
	}
}