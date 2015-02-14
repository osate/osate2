package org.osate.xtext.aadl2.errormodel.valueconversion;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.aadl2.DirectionType;

public class ErrorModelValueConverter extends DefaultTerminalConverters {
	@ValueConverter(rule = "PropagationDirection")
	public IValueConverter<DirectionType> InOutDirection() {
		return new IValueConverter<DirectionType>() {
			public DirectionType toValue(String string, INode node) {
				if (string == null) {
					return DirectionType.OUT;
				}
				return DirectionType.get(string.toLowerCase());
			}

			public String toString(DirectionType value) {
				return value.getName();
			}
		};
	}

}
