package org.osate.xtext.aadl2.ui.propertyview.associationwizard.assistant;

import org.eclipse.swt.widgets.Composite;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyType;

public class AssistantFactory
{
	private AssistantFactory(){}
	
	public static AbstractAssistant getAssistantForType(Composite parent, PropertyType type, NamedElement holder, AssistantValueChangedListener listener) {
		if (type instanceof EnumerationType)
			return new EnumerationAssistant(parent, (EnumerationType)type, listener);
		else
			return null;
	}
}