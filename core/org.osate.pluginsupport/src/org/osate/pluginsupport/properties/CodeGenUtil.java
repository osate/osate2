package org.osate.pluginsupport.properties;

import java.util.Optional;

import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.properties.PropertyNotPresentException;

/**
 * @since 4.1
 */
public class CodeGenUtil {
	public static PropertyExpression resolveNamedValue(PropertyExpression propertyExpression,
			NamedElement lookupContext, Optional<Mode> mode) {
		if (propertyExpression instanceof NamedValue) {
			AbstractNamedValue namedValue = ((NamedValue) propertyExpression).getNamedValue();
			if (namedValue instanceof Property) {
				Property property = (Property) namedValue;
				return resolveNamedValue(lookupProperty(property, lookupContext, mode), lookupContext, mode);
			} else if (namedValue instanceof PropertyConstant) {
				return resolveNamedValue(((PropertyConstant) namedValue).getConstantValue(), lookupContext, mode);
			}
		}
		return propertyExpression;
	}
	
	public static PropertyExpression lookupProperty(Property property, NamedElement lookupContext, Optional<Mode> mode) {
		Optional<PropertyExpression> modalValue = mode.map(m -> {
			PropertyAssociation association = lookupContext.getPropertyValue(property).first();
			if (association == null) {
				PropertyExpression defaultValue = property.getDefaultValue();
				if (defaultValue == null) {
					throw new PropertyNotPresentException(lookupContext, property, "No property value");
				} else {
					return defaultValue;
				}
			} else {
				return association.valueInMode(m);
			}
		});
		return modalValue.orElseGet(() -> lookupContext.getNonModalPropertyValue(property));
	}
}