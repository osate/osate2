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
package org.osate.xtext.aadl2.properties.util;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.NumberType;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RangeType;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.impl.ClassifierValueImpl;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyIsListException;
import org.osate.aadl2.properties.PropertyIsModalException;
import org.osate.aadl2.properties.PropertyLookupException;
import org.osate.aadl2.properties.PropertyNotPresentException;

/**
 * This class contains static methods for assisting in getting simple property
 * values of specific types. These methods are convenient, but they can mask
 * errors in the specification being analyzed because they cannot distinguish
 * between a property value being not present and a property value being modal
 * or list-valued.
 *
 * @author aarong
 */
// FIXME-LW: Range min, max, delta - evaluate signed constant; sign currently ignored
public class PropertyUtils {
	/*
	 * Private constructor: prevent instantiation of this class.
	 */
	private PropertyUtils() {
	}

	/**
	 * Get a non-modal integer property value with no units. Returns a given
	 * default value if no property value exists.
	 *
	 * @param ph The property holder from which to retrieve the property value.
	 * @param pd The property to retrieve.
	 * @param defaultVal The value to return if the property has no value.
	 * @return The integer value of the property.
	 */
	public static long getIntegerValue(final NamedElement ph, final Property pd, final long defaultVal) {
		try {
			final PropertyExpression pv = getSimplePropertyValue(ph, pd);
			return ((IntegerLiteral) pv).getValue();
		} catch (PropertyLookupException e) {
			return defaultVal;
		}
	}

	/**
	 * Get a non-modal integer property value with no units. Throws an exception
	 * if no property value exists or an error occurs.
	 *
	 * @param ph The property holder from which to retrieve the property value.
	 * @param pd The property to retrieve.
	 * @return The integer value of the property.
	 * @throws InvalidModelException Thrown if the property value cannot be
	 *             retrieved because the model is incomplete or otherwise
	 *             invalid.
	 * @throws PropertyNotPresentException Thrown if the property is undefined
	 *             for ph.
	 * @throws PropertyIsModalException Thrown if ph is modal and declarative.
	 * @throws IllegalStateException Thrown if the lookup encounters a cycle of
	 *             property reference dependencies.
	 * @throws IllegalArgumentException Thrown if ph or pd is null.
	 * @throws PropertyDoesNotApplyToHolderException Thrown if pd does not apply
	 *             to ph.
	 * @throws PropertyIsListException Thrown if the property is not scalar.
	 * @throws ClassCastException Thrown if the retrieved value is not an integer
	 *             value.
	 */
	public static long getIntegerValue(final NamedElement ph, final Property pd) throws InvalidModelException,
			PropertyNotPresentException, PropertyIsModalException, IllegalStateException, IllegalArgumentException,
			PropertyDoesNotApplyToHolderException, PropertyIsListException, ClassCastException {
		final PropertyExpression pv = getSimplePropertyValue(ph, pd);
		if (pv == null) {
			throw new PropertyNotPresentException(ph, pd, "cannot find the property");
		}
		return ((IntegerLiteral) pv).getValue();
	}

	/**
	 * Get a non-modal real property value with no units. Returns a given
	 * default value if no property value exists.
	 *
	 * @param ph The property holder from which to retrieve the property value.
	 * @param pd The property to retrieve.
	 * @param defaultVal The value to return if the property has no value.
	 * @return The real value of the property.
	 */
	public static double getRealValue(final NamedElement ph, final Property pd, final double defaultVal) {
		if (pd == null) {
			return defaultVal;
		}
		try {
			final PropertyExpression pv = getSimplePropertyValue(ph, pd);
			return ((RealLiteral) pv).getValue();
		} catch (PropertyLookupException e) {
			return defaultVal;
		}
	}

	/**
	 * Get a non-modal real property with no units Throws an exception if no
	 * property value exists or an error occurs.
	 *
	 * @param ph The property holder from which to retrieve the property value.
	 * @param pd The property to retrieve.
	 * @return The real value of the property.
	 * @throws InvalidModelException Thrown if the property value cannot be
	 *             retrieved because the model is incomplete or otherwise
	 *             invalid.
	 * @throws PropertyNotPresentException Thrown if the property is undefined
	 *             for ph.
	 * @throws PropertyIsModalException Thrown if ph is modal and declarative.
	 * @throws IllegalStateException Thrown if the lookup encounters a cycle of
	 *             property reference dependencies.
	 * @throws IllegalArgumentException Thrown if ph or pd is null.
	 * @throws PropertyDoesNotApplyToHolderException Thrown if pd does not apply
	 *             to ph.
	 * @throws PropertyIsListException Thrown if the property is not scalar.
	 * @throws ClassCastException Thrown if the retrieved value is not a real
	 *             value.
	 */
	public static double getRealValue(final NamedElement ph, final Property pd) throws InvalidModelException,
			PropertyNotPresentException, PropertyIsModalException, IllegalStateException, IllegalArgumentException,
			PropertyDoesNotApplyToHolderException, PropertyIsListException, ClassCastException {
		final PropertyExpression pv = getSimplePropertyValue(ph, pd);
		return ((RealLiteral) pv).getValue();
	}

	/**
	 * Get a non-modal string property value. Throws an exception if no property
	 * value exists or an error occurs.
	 *
	 * @param ph The property holder from which to retrieve the property value.
	 * @param pd The property to retrieve.
	 * @return The string value of the property.
	 * @throws InvalidModelException Thrown if the property value cannot be
	 *             retrieved because the model is incomplete or otherwise
	 *             invalid.
	 * @throws PropertyNotPresentException Thrown if the property is undefined
	 *             for ph.
	 * @throws PropertyIsModalException Thrown if ph is modal and declarative.
	 * @throws IllegalStateException Thrown if the lookup encounters a cycle of
	 *             property reference dependencies.
	 * @throws IllegalArgumentException Thrown if ph or pd is null.
	 * @throws PropertyDoesNotApplyToHolderException Thrown if pd does not apply
	 *             to ph.
	 * @throws PropertyIsListException Thrown if the property is not scalar.
	 * @throws ClassCastException Thrown if the retrieved value is not a string
	 *             value.
	 */
	public static String getStringValue(final NamedElement ph, final Property pd) throws InvalidModelException,
			PropertyNotPresentException, PropertyIsModalException, IllegalStateException, IllegalArgumentException,
			PropertyDoesNotApplyToHolderException, PropertyIsListException, ClassCastException {
		final PropertyExpression pv = getSimplePropertyValue(ph, pd);
		return ((StringLiteral) pv).getValue();
	}

	/**
	 * Get a non-modal string property value. Returns a given
	 * default value if no property value exists.
	 *
	 * @param ph The property holder from which to retrieve the property value.
	 * @param pd The property to retrieve.
	 * @param defaultVal The value to return if the property has no value.
	 * @return The String value of the property.
	 */
	public static String getStringValue(final NamedElement ph, final Property pd, final String defaultvalue) {
		try {
			final PropertyExpression pv = getSimplePropertyValue(ph, pd);
			return ((StringLiteral) pv).getValue();
		} catch (PropertyLookupException e) {
			return defaultvalue;
		}
	}

	public static PropertyExpression getRecordFieldValue(final RecordValue rv, final String fieldName) {
		final EList<BasicPropertyAssociation> pvl = rv.getOwnedFieldValues();
		for (BasicPropertyAssociation ba : pvl) {
			if (ba.getProperty().getName().equalsIgnoreCase(fieldName)) {
				return ba.getValue();
			}
		}
		return null;
	}

	/**
	 * Get a non-modal boolean property value. Returns a given default value if
	 * no property value exists. Throws an exception if an error occurs.
	 *
	 * @param ph The property holder from which to retrieve the property value.
	 * @param pd The property to retrieve.
	 * @param defaultVal The value to return if the property has no value.
	 * @return The boolean value of the property.
	 */
	public static boolean getBooleanValue(final NamedElement ph, final Property pd, final boolean defaultVal) {
		try {
			final PropertyExpression pv = getSimplePropertyValue(ph, pd);
			final BooleanLiteral v = (BooleanLiteral) pv;
			return v.getValue();
		} catch (PropertyLookupException e) {
			return defaultVal;
		}
	}

	/**
	 * Get a non-modal boolean property value. Throws an exception if no
	 * property value exists or an error occurs.
	 *
	 * @param ph The property holder from which to retrieve the property value.
	 * @param pd The property to retrieve.
	 * @return The boolean value of the property.
	 * @throws InvalidModelException Thrown if the property value cannot be
	 *             retrieved because the model is incomplete or otherwise
	 *             invalid.
	 * @throws PropertyNotPresentException Thrown if the property is undefined
	 *             for ph.
	 * @throws PropertyIsModalException Thrown if ph is modal and declarative.
	 * @throws IllegalStateException Thrown if the lookup encounters a cycle of
	 *             property reference dependencies.
	 * @throws IllegalArgumentException Thrown if ph or pd is null.
	 * @throws PropertyDoesNotApplyToHolderException Thrown if pd does not apply
	 *             to ph.
	 * @throws PropertyIsListException Thrown if the property is not scalar.
	 * @throws ClassCastException Thrown if the retrieved value is not a
	 *             {@link TrueFalseValue} value.
	 */
	public static boolean getBooleanValue(final NamedElement ph, final Property pd) throws InvalidModelException,
			PropertyNotPresentException, PropertyIsModalException, IllegalStateException, IllegalArgumentException,
			PropertyDoesNotApplyToHolderException, PropertyIsListException, ClassCastException {
		final BooleanLiteral pv = (BooleanLiteral) getSimplePropertyValue(ph, pd);
		return pv.isValue();
	}

	/**
	 * Get a non-modal enumeration property value. Throws an exception if no
	 * property value exists or an error occurs.
	 *
	 * @param ph The property holder from which to retrieve the property value.
	 * @param pd The property to retrieve.
	 * @return The enumeration literal of the property.
	 * @throws InvalidModelException Thrown if the property value cannot be
	 *             retrieved because the model is incomplete or otherwise
	 *             invalid.
	 * @throws PropertyNotPresentException Thrown if the property is undefined
	 *             for ph.
	 * @throws PropertyIsModalException Thrown if ph is modal and declarative.
	 * @throws IllegalStateException Thrown if the lookup encounters a cycle of
	 *             property reference dependencies.
	 * @throws IllegalArgumentException Thrown if ph or pd is null.
	 * @throws PropertyDoesNotApplyToHolderException Thrown if pd does not apply
	 *             to ph.
	 * @throws PropertyIsListException Thrown if the property is not scalar.
	 * @throws ClassCastException Thrown if the retrieved value is not an
	 *             enumeration value.
	 */

	public static EnumerationLiteral getEnumLiteral(final NamedElement ph, final Property pd)
			throws InvalidModelException, PropertyNotPresentException, PropertyIsModalException, IllegalStateException,
			IllegalArgumentException, PropertyDoesNotApplyToHolderException, PropertyIsListException,
			ClassCastException {
		final PropertyExpression pv = getSimplePropertyValue(ph, pd);
		return (EnumerationLiteral) ((NamedValue) pv).getNamedValue();
	}

	/**
	 * Get a non-modal numeric property value scaled to the given unit. Returns
	 * a given default value if no property value exists.
	 *
	 * @param ph The property holder from which to retrieve the property value.
	 * @param pd The property to retrieve.
	 * @param unit The unit to scale the value to.
	 * @param defaultVal The value to return if the property has no value.
	 * @return The scaled property value of the property.
	 */
	public static double getScaledNumberValue(final NamedElement ph, final Property pd, final UnitLiteral unit,
			final double defaultVal) {
		try {
			final PropertyExpression pv = checkUnitsAndGetSimplePropertyValue(ph, pd, unit);
			return ((NumberValue) pv).getScaledValue(unit);
		} catch (PropertyLookupException e) {
			return defaultVal;
		}
	}

	/**
	 * Get a non-modal numeric property value scaled to the given unit. Throws
	 * an exception is no property value exists or an error occurs.
	 *
	 * @param ph The property holder from which to retrieve the property value.
	 * @param pd The property to retrieve.
	 * @param unit The unit to scale the value to.
	 * @return The scaled property value of the property.
	 * @throws InvalidModelException Thrown if the property value cannot be
	 *             retrieved because the model is incomplete or otherwise
	 *             invalid.
	 * @throws PropertyNotPresentException Thrown if the property is undefined
	 *             for ph.
	 * @throws PropertyIsModalException Thrown if ph is modal and declarative.
	 * @throws IllegalStateException Thrown if the lookup encounters a cycle of
	 *             property reference dependencies.
	 * @throws IllegalArgumentException Thrown if the given unit literal is not
	 *             from the property's unit type or if ph, pd, or unit is null.
	 * @throws PropertyDoesNotApplyToHolderException Thrown if pd does not apply
	 *             to ph.
	 * @throws PropertyIsListException Thrown if the property is not scalar.
	 * @throws ClassCastException Thrown if the retrieved value is not a number
	 *             value.
	 */
	public static double getScaledNumberValue(final NamedElement ph, final Property pd, final UnitLiteral unit)
			throws InvalidModelException, PropertyNotPresentException, PropertyIsModalException, IllegalStateException,
			IllegalArgumentException, PropertyDoesNotApplyToHolderException, PropertyIsListException,
			ClassCastException {
		final PropertyExpression pv = checkUnitsAndGetSimplePropertyValue(ph, pd, unit);
		return ((NumberValue) pv).getScaledValue(unit);
	}

	/**
	 * Return the maximum value of a non-modal range property value scaled to a
	 * given unit. Returns a given default value if no property value exists.
	 * Throws an exception if an error occurs.
	 *
	 * @param ph The property holder from which to retrieve the property value.
	 * @param pd The property to retrieve.
	 * @param unit The unit to scale the value to.
	 * @param defaultVal The value to return if the property has no value.
	 * @return The maximum of the range value scaled to the given unit.
	 */
	public static double getScaledRangeMaximum(final NamedElement ne, final Property pd, final UnitLiteral unit,
			final double defaultVal) {
		try {
			final PropertyExpression pv = checkUnitsAndGetSimplePropertyValue(ne, pd, unit);
			final RangeValue rv = (RangeValue) pv;
			PropertyExpression maximum = rv.getMaximum().evaluate(null, 0).first().getValue();

			if (maximum instanceof NumberValue) {
				return ((NumberValue) maximum).getScaledValue(unit);
			} else {
				return defaultVal;
			}
		} catch (PropertyLookupException e) {
			return defaultVal;
		}
	}

	/**
	 * Return the maximum value of a non-modal range property value scaled to a
	 * given unit. Throws an exception if no property value exists or an error
	 * occurs.
	 *
	 * @param ph The property holder from which to retrieve the property value.
	 * @param pd The property to retrieve.
	 * @param unit The unit to scale the value to.
	 * @return The maximum of the range value scaled to the given unit.
	 * @throws InvalidModelException Thrown if the property value cannot be
	 *             retrieved because the model is incomplete or otherwise
	 *             invalid.
	 * @throws PropertyNotPresentException Thrown if the property is undefined
	 *             for ph.
	 * @throws PropertyIsModalException Thrown if ph is modal and declarative.
	 * @throws IllegalStateException Thrown if the lookup encounters a cycle of
	 *             property reference dependencies.
	 * @throws IllegalArgumentException Thrown if the given unit literal is not
	 *             from the property's unit type or if ph, pd, or unit is null.
	 * @throws PropertyDoesNotApplyToHolderException Thrown if pd does not apply
	 *             to ph.
	 * @throws PropertyIsListException Thrown if the property is not scalar.
	 * @throws ClassCastException Thrown if the retrieved value is not a range
	 *             value.
	 */
	public static double getScaledRangeMaximum(final NamedElement ph, final Property pd, final UnitLiteral unit)
			throws InvalidModelException, PropertyNotPresentException, PropertyIsModalException, IllegalStateException,
			IllegalArgumentException, PropertyDoesNotApplyToHolderException, PropertyIsListException,
			ClassCastException {
		final PropertyExpression pv = checkUnitsAndGetSimplePropertyValue(ph, pd, unit);
		RangeValue rv = (RangeValue) pv;
		PropertyExpression maximum = rv.getMaximum().evaluate(null, 0).first().getValue();

		if (maximum instanceof NumberValue) {
			return ((NumberValue) maximum).getScaledValue(unit);
		}
		throw new InvalidModelException(maximum, "Cannot evaluate upper range limit");
	}

	// TODO-LW: treat minimum same as maximum
	/**
	 * Return the minimum value of a non-modal range property value scaled to a
	 * given unit. Returns a given default value if no property value exists.
	 * Throws an exception if an error occurs.
	 *
	 * @param ph The property holder from which to retrieve the property value.
	 * @param pd The property to retrieve.
	 * @param unit The unit to scale the value to.
	 * @param defaultVal The value to return if the property has no value.
	 * @return The minimum of the range value scaled to the given unit.
	 */
	public static double getScaledRangeMinimum(final NamedElement ph, final Property pd, final UnitLiteral unit,
			final double defaultVal) {
		try {
			final PropertyExpression pv = checkUnitsAndGetSimplePropertyValue(ph, pd, unit);
			final RangeValue rv = (RangeValue) pv;
			return rv.getMinimumValue().getScaledValue(unit);
		} catch (PropertyLookupException e) {
			return defaultVal;
		}
	}

	/**
	 * Return the minimum value of a non-modal range property value scaled to a
	 * given unit. Throws an exception if no property value exists or an error
	 * occurs.
	 *
	 * @param ph The property holder from which to retrieve the property value.
	 * @param pd The property to retrieve.
	 * @param unit The unit to scale the value to.
	 * @return The minimum of the range value scaled to the given unit.
	 * @throws InvalidModelException Thrown if the property value cannot be
	 *             retrieved because the model is incomplete or otherwise
	 *             invalid.
	 * @throws PropertyNotPresentException Thrown if the property is undefined
	 *             for ph.
	 * @throws PropertyIsModalException Thrown if ph is modal and declarative.
	 * @throws IllegalStateException Thrown if the lookup encounters a cycle of
	 *             property reference dependencies.
	 * @throws IllegalArgumentException Thrown if the given unit literal is not
	 *             from the property's unit type or if ph, pd, or unit is null.
	 * @throws PropertyDoesNotApplyToHolderException Thrown if pd does not apply
	 *             to ph.
	 * @throws PropertyIsListException Thrown if the property is not scalar.
	 * @throws ClassCastException Thrown if the retrieved value is not a range
	 *             value.
	 */
	public static double getScaledRangeMinimum(final NamedElement ph, final Property pd, final UnitLiteral unit)
			throws InvalidModelException, PropertyNotPresentException, PropertyIsModalException, IllegalStateException,
			IllegalArgumentException, PropertyDoesNotApplyToHolderException, PropertyIsListException,
			ClassCastException {
		final PropertyExpression pv = checkUnitsAndGetSimplePropertyValue(ph, pd, unit);
		RangeValue rv = (RangeValue) pv;
		return rv.getMinimumValue().getScaledValue(unit);
	}

	/**
	 * Return the delta value of a non-modal range property value scaled to a
	 * given unit. Returns a given default value if no property value exists.
	 * Throws an exception if an error occurs.
	 *
	 * @param ph The property holder from which to retrieve the property value.
	 * @param pd The property to retrieve.
	 * @param unit The unit to scale the value to.
	 * @param defaultVal The value to return if the property has no value.
	 * @return The delta of the range value scaled to the given unit.
	 */
	public static double getScaledRangeDelta(final NamedElement ph, final Property pd, final UnitLiteral unit,
			final double defaultVal) {
		try {
			final PropertyExpression pv = checkUnitsAndGetSimplePropertyValue(ph, pd, unit);
			final RangeValue rv = (RangeValue) pv;
			return rv.getDeltaValue().getScaledValue(unit);
		} catch (PropertyLookupException e) {
			return defaultVal;
		}
	}

	/**
	 * Return the delta value of a non-modal range property value scaled to a
	 * given unit. Throws an exception if no property value exists or an error
	 * occurs.
	 *
	 * @param ph The property holder from which to retrieve the property value.
	 * @param pd The property to retrieve.
	 * @param unit The unit to scale the value to.
	 * @return The delta of the range value scaled to the given unit.
	 * @throws InvalidModelException Thrown if the property value cannot be
	 *             retrieved because the model is incomplete or otherwise
	 *             invalid.
	 * @throws PropertyNotPresentException Thrown if the property is undefined
	 *             for ph.
	 * @throws PropertyIsModalException Thrown if ph is modal and declarative.
	 * @throws IllegalStateException Thrown if the lookup encounters a cycle of
	 *             property reference dependencies.
	 * @throws IllegalArgumentException Thrown if the given unit literal is not
	 *             from the property's unit type or if ph, pd, or unit is null.
	 * @throws PropertyDoesNotApplyToHolderException Thrown if pd does not apply
	 *             to ph.
	 * @throws PropertyIsListException Thrown if the property is not scalar.
	 * @throws ClassCastException Thrown if the retrieved value is not a range
	 *             value.
	 */
	public static double getScaledRangeDelta(final NamedElement ph, final Property pd, final UnitLiteral unit)
			throws InvalidModelException, PropertyNotPresentException, PropertyIsModalException, IllegalStateException,
			IllegalArgumentException, PropertyDoesNotApplyToHolderException, PropertyIsListException,
			ClassCastException {
		final PropertyExpression pv = checkUnitsAndGetSimplePropertyValue(ph, pd, unit);
		RangeValue rv = (RangeValue) pv;
		return rv.getDeltaValue().getScaledValue(unit);
	}

	/**
	 * Get an InstanceObject from an instance reference value. Throws an
	 * exception if no property value exists or an error occurs.
	 *
	 * @param io The instance object from which to retrieve the property value.
	 *            (We don't use a property holder because we can only get an
	 *            instance reference value as a property value from an instance
	 *            object.)
	 * @param pd The property to retrieve.
	 * @return The instance object of the property.
	 */
	public static InstanceObject getInstanceObjectReference(final InstanceObject io, final Property pd) {
		if (io == null) {
			return null;
		}
		try {
			final PropertyExpression pv = io.getSimplePropertyValue(pd);
			final InstanceObject ref = ((InstanceReferenceValue) pv).getReferencedInstanceObject();
			return ref;
		} catch (PropertyLookupException e) {
			return null;
		}
	}

	public static Classifier getClassifierReference(final NamedElement ph, final Property pd) {
		if (ph == null) {
			return null;
		}
		try {
			final PropertyExpression pv = ph.getSimplePropertyValue(pd);
			final Classifier ref = ((ClassifierValueImpl) pv).getClassifier();
			return ref;
		} catch (PropertyLookupException e) {
			return null;
		}

	}

	/**
	 * Creates a PropertyValue for an aadlinteger.
	 */
	public static IntegerLiteral createIntegerValue(long intValue) {
		IntegerLiteral newPropertyValue = Aadl2Factory.eINSTANCE.createIntegerLiteral();
		newPropertyValue.setValue(intValue);
		return newPropertyValue;
	}

	/**
	 * Creates a PropertyValue for an aadlinteger with units.
	 *
	 * @throws IllegalArgumentException Thrown if unit is null.
	 */
	public static IntegerLiteral createIntegerValue(long intValue, UnitLiteral unit) throws IllegalArgumentException {
		if (unit == null) {
			throw new IllegalArgumentException("UnitLiteral unit cannot be null.");
		}
		IntegerLiteral newPropertyValue = createIntegerValue(intValue);
		newPropertyValue.setUnit(unit);
		return newPropertyValue;
	}

	/**
	 * Creates a PropertyValue for a range of aadlinteger.
	 *
	 * @throws IllegalArgumentException Thrown if min is greater than max.
	 */
	public static RangeValue createIntegerRangeValue(long min, long max) throws IllegalArgumentException {
		if (min > max) {
			throw new IllegalArgumentException("min cannot be greater than max.");
		}
		RangeValue newPropertyValue = Aadl2Factory.eINSTANCE.createRangeValue();
		newPropertyValue.setMinimum(createIntegerValue(min));
		newPropertyValue.setMaximum(createIntegerValue(max));
		return newPropertyValue;
	}

	/**
	 * Creates a PropertyValue for a range of aadlinteger with units.
	 *
	 * @throws IllegalArgumentException Thrown if minUnits or maxUnits is null,
	 *             if minUnits and maxUnits are not of the same UnitType, or if
	 *             min is greater than max.
	 */
	public static RangeValue createIntegerRangeValue(long min, UnitLiteral minUnits, long max, UnitLiteral maxUnits)
			throws IllegalArgumentException {
		if (minUnits == null) {
			throw new IllegalArgumentException("minUnits cannot be null.");
		}
		if (maxUnits == null) {
			throw new IllegalArgumentException("maxUnits cannot be null.");
		}
		if (!minUnits.eContainer().equals(maxUnits.eContainer())) {
			throw new IllegalArgumentException("minUnits and maxUnits are not of the same type.");
		}

		IntegerLiteral minimumValue = createIntegerValue(min, minUnits);
		IntegerLiteral maximumValue = createIntegerValue(max, maxUnits);
		if (minimumValue.getScaledValue() > maximumValue.getScaledValue()) {
			throw new IllegalArgumentException("min cannot be greater than max.");
		}

		RangeValue newPropertyValue = Aadl2Factory.eINSTANCE.createRangeValue();
		newPropertyValue.setMinimum(minimumValue);
		newPropertyValue.setMaximum(maximumValue);
		return newPropertyValue;
	}

	/**
	 * Creates a PropertyValue for a range of aadlinteger.
	 *
	 * @throws IllegalArgumentException Thrown if min is greater than max.
	 */
	public static RangeValue createIntegerRangeValue(long min, long max, long delta) throws IllegalArgumentException {
		RangeValue newPropertyValue = createIntegerRangeValue(min, max);
		newPropertyValue.setDelta(createIntegerValue(delta));
		return newPropertyValue;
	}

	/**
	 * Creates a PropertyValue for a range of aadlinteger with units.
	 *
	 * @throws IllegalArgumentException Thrown if minUnits, maxUnits, or
	 *             deltaUnits is null, if minUnits, maxUnits, and deltaUnits are
	 *             not of the same UnitType, or if min is greater than max.
	 */
	public static RangeValue createIntegerRangeValue(long min, UnitLiteral minUnits, long max, UnitLiteral maxUnits,
			long delta, UnitLiteral deltaUnits) throws IllegalArgumentException {
		RangeValue newPropertyValue = createIntegerRangeValue(min, minUnits, max, maxUnits);

		if (deltaUnits == null) {
			throw new IllegalArgumentException("deltaUnits cannot be null.");
		}
		if (!minUnits.eContainer().equals(deltaUnits.eContainer())) {
			throw new IllegalArgumentException("minUnits, maxUnits, and deltaUnits are not of the same type.");
		}

		newPropertyValue.setDelta(createIntegerValue(delta, deltaUnits));
		return newPropertyValue;
	}

	/**
	 * Creates a PropertyValue for an aadlreal.
	 */
	public static RealLiteral createRealValue(double realValue) {
		RealLiteral newPropertyValue = Aadl2Factory.eINSTANCE.createRealLiteral();
		newPropertyValue.setValue(realValue);
		return newPropertyValue;
	}

	/**
	 * Creates a PropertyValue for an aadlreal with units.
	 *
	 * @throws IllegalArgumentException Thrown if unit is null.
	 */
	public static RealLiteral createRealValue(double realValue, UnitLiteral unit) throws IllegalArgumentException {
		if (unit == null) {
			throw new IllegalArgumentException("UnitLiteral unit cannot be null.");
		}
		RealLiteral newPropertyValue = createRealValue(realValue);
		newPropertyValue.setUnit(unit);
		return newPropertyValue;
	}

	/**
	 * Creates a PropertyValue for a range of aadlreal.
	 *
	 * @throws IllegalArgumentException Thrown if min is greater than max.
	 */
	public static RangeValue createRealRangeValue(double min, double max) throws IllegalArgumentException {
		if (min > max) {
			throw new IllegalArgumentException("min cannot be greater than max.");
		}
		RangeValue newPropertyValue = Aadl2Factory.eINSTANCE.createRangeValue();
		newPropertyValue.setMinimum(createRealValue(min));
		newPropertyValue.setMaximum(createRealValue(max));
		return newPropertyValue;
	}

	/**
	 * Creates a PropertyValue for a range of aadlreal with units.
	 *
	 * @throws IllegalArgumentException Thrown if minUnits or maxUnits is null,
	 *             if minUnits and maxUnits are not of the same UnitType, or if
	 *             min is greater than max.
	 */
	public static RangeValue createRealRangeValue(double min, UnitLiteral minUnits, double max, UnitLiteral maxUnits)
			throws IllegalArgumentException {
		if (minUnits == null) {
			throw new IllegalArgumentException("minUnits cannot be null.");
		}
		if (maxUnits == null) {
			throw new IllegalArgumentException("maxUnits cannot be null.");
		}
		if (!minUnits.eContainer().equals(maxUnits.eContainer())) {
			throw new IllegalArgumentException("minUnits and maxUnits are not of the same type.");
		}

		RealLiteral minimumValue = createRealValue(min, minUnits);
		RealLiteral maximumValue = createRealValue(max, maxUnits);
		if (minimumValue.getScaledValue() > maximumValue.getScaledValue()) {
			throw new IllegalArgumentException("min cannot be greater than max.");
		}

		RangeValue newPropertyValue = Aadl2Factory.eINSTANCE.createRangeValue();
		newPropertyValue.setMinimum(minimumValue);
		newPropertyValue.setMaximum(maximumValue);
		return newPropertyValue;
	}

	/**
	 * Creates a PropertyValue for a range of aadlreal.
	 *
	 * @throws IllegalArgumentException Thrown if min is greater than max.
	 */
	public static RangeValue createRealRangeValue(double min, double max, double delta)
			throws IllegalArgumentException {
		RangeValue newPropertyValue = createRealRangeValue(min, max);
		newPropertyValue.setDelta(createRealValue(delta));
		return newPropertyValue;
	}

	/**
	 * Creates a PropertyValue for a range of aadlreal with units.
	 *
	 * @throws IllegalArgumentException Thrown if minUnits, maxUnits, or
	 *             deltaUnits is null, if minUnits, maxUnits, and deltaUnits are
	 *             not of the same UnitType, or if min is greater than max.
	 */
	public static RangeValue createRealRangeValue(double min, UnitLiteral minUnits, double max, UnitLiteral maxUnits,
			double delta, UnitLiteral deltaUnits) throws IllegalArgumentException {
		RangeValue newPropertyValue = createRealRangeValue(min, minUnits, max, maxUnits);

		if (deltaUnits == null) {
			throw new IllegalArgumentException("deltaUnits cannot be null.");
		}
		if (!minUnits.eContainer().equals(deltaUnits.eContainer())) {
			throw new IllegalArgumentException("minUnits, maxUnits, and deltaUnits are not of the same type.");
		}

		newPropertyValue.setDelta(createRealValue(delta, deltaUnits));
		return newPropertyValue;
	}

	/**
	 * Creates a PropertyValue for a string.
	 *
	 * @throws IllegalArgumentException Thrown if stringValue is null.
	 */
	public static StringLiteral createStringValue(String stringValue) throws IllegalArgumentException {
		if (stringValue == null) {
			throw new IllegalArgumentException("stringValue cannot be null.");
		}
		StringLiteral newPropertyValue = Aadl2Factory.eINSTANCE.createStringLiteral();
		newPropertyValue.setValue(stringValue);
		return newPropertyValue;
	}

	/**
	 * Creates a PropertyValue for an aadlboolean.
	 */
	public static BooleanLiteral createTrueFalseValue(boolean boolValue) {
		BooleanLiteral newPropertyValue = Aadl2Factory.eINSTANCE.createBooleanLiteral();
		newPropertyValue.setValue(boolValue);
		return newPropertyValue;
	}

	/**
	 * Create a enumeration value from an enumeration literal.
	 *
	 * @param literal The enumeration literal
	 * @return An enumeration value for the given literal
	 * @throws IllegalArgumentException Thrown if literal is null
	 */
	public static NamedValue createEnumValue(EnumerationLiteral literal) throws IllegalArgumentException {
		if (literal == null) {
			throw new IllegalArgumentException("Enumeration literal is null.");
		}
		NamedValue newPropertyValue = Aadl2Factory.eINSTANCE.createNamedValue();
		newPropertyValue.setNamedValue(literal);
		return newPropertyValue;
	}

	/**
	 * Check that ph is not null and returns the property value by calling
	 * ph.getSimplePropertyValue(pd)
	 *
	 * @param ph The property holder from which to retrieve the property value.
	 * @param pd The property to retrieve.
	 * @return The retrieved property value.
	 * @throws InvalidModelException Thrown if the property value cannot be
	 *             retrieved because the model is incomplete or otherwise
	 *             invalid.
	 * @throws PropertyNotPresentException Thrown if the property is undefined
	 *             for ph.
	 * @throws PropertyIsModalException Thrown if ph is modal and declarative.
	 * @throws IllegalStateException Thrown if the lookup encounters a cycle of
	 *             property reference dependencies.
	 * @throws IllegalArgumentException Thrown if ph or pd is null.
	 * @throws PropertyDoesNotApplyToHolderException Thrown if pd does not apply
	 *             to ph.
	 * @throws PropertyIsListException Thrown if the property is not scalar.
	 */
	public static PropertyExpression getSimplePropertyValue(final NamedElement ph, final Property pd)
			throws InvalidModelException, PropertyNotPresentException, PropertyIsModalException, IllegalStateException,
			IllegalArgumentException, PropertyDoesNotApplyToHolderException, PropertyIsListException {
		if (ph == null) {
			throw new IllegalArgumentException("NamedElement ph cannot be null.");
		}
		if (pd == null) {
			throw new PropertyNotPresentException(ph, pd, "Property not defined for " + ph.getQualifiedName());
		}
		PropertyExpression res = ph.getSimplePropertyValue(pd);
		if (res instanceof NamedValue) {
			AbstractNamedValue nv = ((NamedValue) res).getNamedValue();
			if (nv instanceof Property) {
				res = ph.getSimplePropertyValue((Property) nv);
			} else if (nv instanceof PropertyConstant) {
				res = ((PropertyConstant) nv).getConstantValue();
			}
		}
		return res;
	}

	/**
	 * Return whether the given model element has a value for the given property.
	 * @since 1.1
	 */
	public static boolean hasPropertyValue(final NamedElement ph, final Property pd) {
		try {
			final PropertyAcc acc = ph.getPropertyValue(pd);
			return acc.first() != null;
		} catch (IllegalStateException | InvalidModelException | PropertyDoesNotApplyToHolderException
				| IllegalArgumentException e) {
			// Lookup blows up, so no, there is not a property association for this property
			return false;
		}
	}

	/**
	 * get non-model proeprty list value
	 */
	public static PropertyExpression getSimplePropertyListValue(final NamedElement ph, final Property pd)
			throws InvalidModelException, PropertyNotPresentException, PropertyIsModalException, IllegalStateException,
			IllegalArgumentException, PropertyDoesNotApplyToHolderException, PropertyIsListException {

		PropertyExpression res;
		if (ph == null) {
			throw new IllegalArgumentException("NamedElement ph cannot be null.");
		}

		res = ph.getSimplePropertyValue(pd);

		if (res instanceof NamedValue) {
			AbstractNamedValue nv = ((NamedValue) res).getNamedValue();
			if (nv instanceof Property) {
				res = ph.getSimplePropertyValue((Property) nv);
			} else if (nv instanceof PropertyConstant) {
				res = ((PropertyConstant) nv).getConstantValue();
			}
		}
		return res;
	}

	/**
	 * Check that UnitLiteral unit is part of Property pd's UnitsType and
	 * returns the property value by calling ph.getSimplePropertyValue(pd)
	 *
	 * @param ph The property holder from which to retrieve the property value.
	 * @param pd The property to retrieve.
	 * @param unit The literal to test against pd's units type.
	 * @return The retrieved property value.
	 * @throws InvalidModelException Thrown if the property value cannot be
	 *             retrieved because the model is incomplete or otherwise
	 *             invalid.
	 * @throws PropertyNotPresentException Thrown if the property is undefined
	 *             for ph.
	 * @throws PropertyIsModalException Thrown if ph is modal and declarative.
	 * @throws IllegalStateException Thrown if the lookup encounters a cycle of
	 *             property reference dependencies.
	 * @throws IllegalArgumentException Thrown if the given unit literal is not
	 *             from the property's unit type or if ph, pd, or unit is null.
	 * @throws PropertyDoesNotApplyToHolderException Thrown if pd does not apply
	 *             to ph.
	 * @throws PropertyIsListException Thrown if the property is not scalar.
	 * @throws ClassCastException Thrown if the property's type is not a
	 *             RangeType or a NumberType.
	 */
	private static PropertyExpression checkUnitsAndGetSimplePropertyValue(final NamedElement ph, final Property pd,
			final UnitLiteral unit) throws InvalidModelException, PropertyNotPresentException, PropertyIsModalException,
			IllegalStateException, IllegalArgumentException, PropertyDoesNotApplyToHolderException,
			PropertyIsListException, ClassCastException {
		if (unit == null) {
			throw new IllegalArgumentException("UnitLiteral unit cannot be null.");
		}
		final PropertyExpression pv = getSimplePropertyValue(ph, pd);
		PropertyType pt = (PropertyType) pd.getType();
		if (pt instanceof RangeType) {
			pt = ((RangeType) pt).getNumberType();
		}
		final UnitsType theUnitsType = ((NumberType) pt).getUnitsType();
		if (unit.eContainer() != theUnitsType) {
			throw new IllegalArgumentException(
					"Unit literal " + unit.getName() + " is not from the property's type " + theUnitsType.getName());
		}
		return pv;
	}

	/**
	 * get a property association from the properties section of the containing classifier if the context.
	 * This method has been designed to work with end points of connections, i.e., consisting of a target and a context.
	 * The context must be a NamedElement in its containing classifier, i.e., a feature, feature group, subcomponent.
	 * The property holder is assumed to be contained in the context object, e.g., a feature in afeature group or a data subcomponent in a port, or feature in a subcomponent.
	 * The association must match the property definition.
	 * if the context is null then the containing classifier of the target is used and the path must be one or no path.
	 * The applies to clause of the property association must be of size 2 if the context is set and point to the context and then the property holder.
	 * The property value of the property association is assumed not to be modal.
	 * @param context NamedElement whose containing classifier's properties section is searched for the desired property
	 * @param target NamedElement the model element to which the property is applied to via the applies to clause
	 * @param pd Property the property definition
	 * @return
	 */
	public static PropertyExpression getContainedSimplePropertyValue(final NamedElement context,
			final NamedElement target, final Property pd) {
		if (context == null) {
			return target.getNonModalPropertyValue(pd);
		}
		Classifier cl = AadlUtil.getContainingClassifier(context);
		EList<PropertyAssociation> props = cl.getAllPropertyAssociations();
		for (PropertyAssociation propertyAssociation : props) {
			if (propertyAssociation.getProperty().equals(pd)) {
				// we found a property with the corect type
				// now we need to check whether the applies to points to the holder
				EList<ContainedNamedElement> appliestos = propertyAssociation.getAppliesTos();
				for (ContainedNamedElement containedNamedElement : appliestos) {
					EList<ContainmentPathElement> cpes = containedNamedElement.getContainmentPathElements();
					if (cpes.size() == 2) {
						NamedElement pathcxt = cpes.get(0).getNamedElement();
						NamedElement pathelement = cpes.get(1).getNamedElement();
						if (context.equals(pathcxt) && target.equals(pathelement)) {
							EList<ModalPropertyValue> vallist = propertyAssociation.getOwnedValues();
							if (!vallist.isEmpty()) {
								ModalPropertyValue elem = vallist.get(0);
								PropertyExpression res = elem.getOwnedValue();
								if (res instanceof NamedValue) {
									AbstractNamedValue nv = ((NamedValue) res).getNamedValue();
									if (nv instanceof Property) {
										res = target.getNonModalPropertyValue((Property) nv);
									} else if (nv instanceof PropertyConstant) {
										res = ((PropertyConstant) nv).getConstantValue();
									}
								}

								return res;
							}
						}
					}
				}
			}
		}
		return null;
	}

}