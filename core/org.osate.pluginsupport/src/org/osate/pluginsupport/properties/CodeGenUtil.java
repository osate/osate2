package org.osate.pluginsupport.properties;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.instance.InstanceFactory;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.properties.PropertyNotPresentException;

/**
 * @since 5.0
 */
public final class CodeGenUtil {
	private CodeGenUtil() {
	}
	
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

	public static PropertyExpression lookupProperty(Property property, NamedElement lookupContext,
			Optional<Mode> mode) {
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

	public static <T> ListValue toPropertyExpression(List<T> list,
			Function<? super T, ? extends PropertyExpression> mapper) {
		ListValue listValue = Aadl2Factory.eINSTANCE.createListValue();
		list.stream().map(mapper).forEachOrdered(listValue.getOwnedListElements()::add);
		return listValue;
	}

	public static BooleanLiteral toPropertyExpression(boolean value) {
		BooleanLiteral booleanLiteral = Aadl2Factory.eINSTANCE.createBooleanLiteral();
		booleanLiteral.setValue(value);
		return booleanLiteral;
	}
	
	public static StringLiteral toPropertyExpression(String value) {
		StringLiteral stringLiteral = Aadl2Factory.eINSTANCE.createStringLiteral();
		stringLiteral.setValue(value);
		return stringLiteral;
	}
	
	public static ClassifierValue toPropertyExpression(Classifier value) {
		ClassifierValue classifierValue = Aadl2Factory.eINSTANCE.createClassifierValue();
		classifierValue.setClassifier(value);
		return classifierValue;
	}
	
	public static IntegerLiteral toPropertyExpression(long value) {
		IntegerLiteral integerLiteral = Aadl2Factory.eINSTANCE.createIntegerLiteral();
		integerLiteral.setValue(value);
		return integerLiteral;
	}
	
	public static RealLiteral toPropertyExpression(double value) {
		RealLiteral realLiteral = Aadl2Factory.eINSTANCE.createRealLiteral();
		realLiteral.setValue(value);
		return realLiteral;
	}
	
	public static InstanceReferenceValue toPropertyExpression(InstanceObject value) {
		InstanceReferenceValue instanceReferenceValue = InstanceFactory.eINSTANCE.createInstanceReferenceValue();
		instanceReferenceValue.setReferencedInstanceObject(value);
		return instanceReferenceValue;
	}
}