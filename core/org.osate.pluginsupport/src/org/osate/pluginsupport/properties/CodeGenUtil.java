/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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

	/**
	 * Recursively resolves references to other properties and property constants and returns the ultimate value of the
	 * property expression. This is meant only to be called by generated Java property getters when looking up the value
	 * of a property.
	 */
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

	/**
	 * Recursively resolves references to other property constants and returns the ultimate value of the property
	 * expression. This is meant only to be called by generated Java property getters when looking up the value of
	 * a property constant.
	 *
	 * @since 7.1
	 */
	public static PropertyExpression resolveNamedValue(PropertyExpression propertyExpression) {
		if (propertyExpression instanceof NamedValue) {
			AbstractNamedValue namedValue = ((NamedValue) propertyExpression).getNamedValue();
			if (namedValue instanceof PropertyConstant) {
				return resolveNamedValue(((PropertyConstant) namedValue).getConstantValue());
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