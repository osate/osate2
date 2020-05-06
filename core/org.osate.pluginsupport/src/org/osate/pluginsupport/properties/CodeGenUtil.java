package org.osate.pluginsupport.properties;

import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;

/**
 * @since 3.1
 */
public class CodeGenUtil {
	public static PropertyExpression resolveNamedValue(PropertyExpression propertyExpression,
			NamedElement lookupContext) {
		if (propertyExpression instanceof NamedValue) {
			AbstractNamedValue namedValue = ((NamedValue) propertyExpression).getNamedValue();
			if (namedValue instanceof Property) {
				return resolveNamedValue(lookupContext.getNonModalPropertyValue((Property) namedValue), lookupContext);
			} else if (namedValue instanceof PropertyConstant) {
				return resolveNamedValue(((PropertyConstant) namedValue).getConstantValue(), lookupContext);
			}
		}
		return propertyExpression;
	}
}