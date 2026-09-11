/**
 * AADL-Utils
 *
 * Copyright © 2012 TELECOM ParisTech and CNRS
 *
 * TELECOM ParisTech/LTCI
 *
 * Authors: see AUTHORS
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 2.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see
 * https://www.eclipse.org/legal/epl-2.0/
 */

package org.osate.utils.internal;

import java.util.ArrayList;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ComputedValue;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceReferenceValue;

/**
 * Toolbox to extract property values from AADL components instances.
 * @since 2.0
 */
public class PropertyUtils {

	/**
	 * Returns the latest definition of the property association that matches to
	 * the given propertyName for the given named element. Otherwise it returns
	 * {@code null}.
	 * <br><br>
	 * Property association evaluation order is as follow:
	 * <br><br>
	 * 1. Find the property association within the given named element itself.
	 * <br>
	 * 2. Find the property association that applies to the given named element
	 *    within the named element's parent containers.
	 * <br>
	 * 3. If the named element is a component instance, find the property
	 *    association within the component instance's component implementation.
	 * <br>
	 * 4. If the named element is a component implementation, first look within
	 *    it and its ancestors then its component type (and the component type
	 *    's ancestors).
	 * <br>
	 * 5. If the named element is a component type, find the property association
	 *    within it and its ancestors.
	 *
	 * @param propertyName a given property name
	 * @param owner a given named element
	 * @return the latest definition of the property association that matches
	 * the given propertyName or {@code null}.
	 */
	public static PropertyAssociation findPropertyAssociation(String propertyName, NamedElement owner) {
		// 1. Look within the owner.
		for (PropertyAssociation pa : owner.getOwnedPropertyAssociations()) {
			// Sometime property doesn't have name.
			if (pa.getProperty().getName() == null) {
				continue;
			}

			if (pa.getProperty().getName().equalsIgnoreCase(propertyName)) {
				return pa;
			}
		}

		// 2. Look within parent containers if they defined an property that applies
		// the given property.

		var result = isInAppliesTo(owner, propertyName);

		if (result == null) {
			var pas = new ArrayList<PropertyAssociation>();

			// 3. If the named element is a component instance, look within
			// its associated component implementation.

			if (owner instanceof ComponentInstance instance) {
				var ci = instance.getContainingComponentImpl();
				if (ci != null) {
					owner = ci;
				}
			}

			// 4. If the named element is a component implementation, look within it.
			// and its interface.

			if (owner instanceof ComponentImplementation implementation) {
				pas.addAll(implementation.getAllPropertyAssociations());
				owner = implementation.getType();
			}

			// 5. If the named element is a component type, look within it.

			if (owner instanceof ComponentType type) {
				pas.addAll(type.getAllPropertyAssociations());
			}

			if (!pas.isEmpty()) {
				// The first property association found represents the latest definition
				// of the given property.
				for (PropertyAssociation pa : pas) {
					var p = pa.getProperty();
					// Sometime, properties don't have name.
					if (p.getName() != null && p.getName().equalsIgnoreCase(propertyName)) {
						result = pa;
						break;
					}
				}
			}
		}

		return result;
	}

	private static PropertyAssociation isInAppliesTo(NamedElement owner, String propertyName) {
		var parent = owner.eContainer();
		var ownerName = owner.getName();

		while (parent != null) {
			if (parent instanceof NamedElement namedParent) {
				var pas = namedParent.getOwnedPropertyAssociations();

				for (var pa : pas) {
					var propName = pa.getProperty().getName();

					if (propName != null && propName.equalsIgnoreCase(propertyName)) {
						for (var cne : pa.getAppliesTos()) {
							var paths = cne.getContainmentPathElements();
							var lastEl = paths.getLast();
							var lastElName = lastEl.getNamedElement().getName();
							if (lastElName.equalsIgnoreCase(ownerName)) {
								return pa;
							}
						}
					}
				}
			}

			parent = parent.eContainer();
		}

		return null;
	}

	/**
	 * Extract integer value from a specified property. May return null
	 *
	 * @param i
	 *            component instance.
	 * @param propertyName
	 *            property name.
	 * @return property value.
	 */
	public static Long getIntValue(NamedElement i, String propertyName) {
		var pa = findPropertyAssociation(propertyName, i);

		if (pa != null) {
			var p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				var values = pa.getOwnedValues();

				if (values.size() == 1) {
					if (values.getFirst().getOwnedValue() instanceof IntegerLiteral literal) {
						return literal.getValue();
					}
				}
			}
		}

		return null;
	}

	/**
	 * Extract enumeration value from a specified property. May return null.
	 *
	 * @param i
	 *            component instance.
	 * @param propertyName
	 *            property name.
	 * @return property value.
	 *             enumeration.
	 */
	public static String getEnumValue(NamedElement i, String propertyName) {
		var pa = findPropertyAssociation(propertyName, i);

		if (pa != null) {
			var p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				var values = pa.getOwnedValues();

				if (values.size() == 1) {
					var expr = values.getFirst().getOwnedValue();

					if (expr instanceof EnumerationLiteral literal) {
						return literal.getName();
					} else if (expr instanceof NamedValue named
							&& named.getNamedValue() instanceof EnumerationLiteral literal) {
						return literal.getName();
					}
				}
			}
		}
		// try on a refined NamedElement
		if (i instanceof RefinableElement refinable && refinable.getRefinedElement() != null) {
			return getEnumValue(refinable.getRefinedElement(), propertyName);
		}
		return null;
	}

	// May return null.

	/**
	* Returns the list of property expressions (PropertyExpression) associated
	* to a given property name {@link #findPropertyAssociation(String, NamedElement)}.
	* The list may be empty.
	*
	* @see #findPropertyAssociation(String, NamedElement)
	* @param ne the given named element
	* @param propertyName the given property
	* @return the list of property expressions. The list may be empty.
	*/
	public static EList<PropertyExpression> findPropertyExpression(NamedElement ne, String propertyName) {
		var pa = findPropertyAssociation(propertyName, ne);

		if (pa != null) {
			return getPropertyExpression(pa);
		} else {
			return new BasicEList<>(0);
		}
	}

	/**
	 * Returns the list of PropertyExpression objects binded to the
	 * given PropertyAssociation. The list may be empty.
	 *
	 * @param pa the given property association
	 * @return the list of property expressions. The list may be empty
	 */

	public static EList<PropertyExpression> getPropertyExpression(PropertyAssociation pa) {
		var result = new BasicEList<PropertyExpression>();

		for (var mpv : pa.getOwnedValues()) {
			result.add(mpv.getOwnedValue());
		}
		return result;
	}

	/**
	 * Returns the first property expression or abstract named element (
	 * EnumerationLiteral, Property, PropertyConstant, UnitLiteral) that matches
	 * to the given String object within the given ProperyExpression object.
	 * If the property expression doesn't exist, it returns {@code null}.
	 *
	 * @param pe the given ProperyExpression object
	 * @param toBeMatched the given String object
	 * @return the first matching property expression or abstract named element.
	 * otherwise return {@code null}
	 *
	 * @throws UnsupportedOperationException for other property values than:
	 *   _ StringLiteral
	 *   _ ListValue (recursion supported)
	 *   _ ClassifierValue
	 *   _ InstanceReferenceValue
	 *   _ ComputedValue
	 *   _ RecordValue (based on field matching)
	 *   _ NamedValue (returns abstract named element)
	 */
	public static Element getValue(PropertyExpression pe, String toBeMatched) {
		return switch (pe.eClass().getClassifierID()) {
		case Aadl2Package.STRING_LITERAL -> {
			var literal = (StringLiteral) pe;
			yield literal.getValue().equalsIgnoreCase(toBeMatched) ? literal : null;
		}
		case Aadl2Package.LIST_VALUE -> {
			Element match = null;
			for (var element : ((ListValue) pe).getOwnedListElements()) {
				match = getValue(element, toBeMatched);
				if (match != null) {
					break;
				}
			}
			yield match;
		}
		case Aadl2Package.RECORD_VALUE -> {
			Element match = null;
			for (var association : ((RecordValue) pe).getOwnedFieldValues()) {
				if (association.getProperty().getName().equalsIgnoreCase(toBeMatched)) {
					match = association.getValue();
					break;
				}
			}
			yield match;
		}
		case Aadl2Package.CLASSIFIER_VALUE -> {
			var value = (ClassifierValue) pe;
			yield value.getClassifier().getName().equalsIgnoreCase(toBeMatched) ? value : null;
		}
		case Aadl2Package.REFERENCE_VALUE -> {
			var value = (InstanceReferenceValue) pe;
			yield value.getReferencedInstanceObject().getName().equalsIgnoreCase(toBeMatched) ? value : null;
		}
		case Aadl2Package.COMPUTED_VALUE -> {
			var value = (ComputedValue) pe;
			yield value.getFunction().equalsIgnoreCase(toBeMatched) ? value : null;
		}
		case Aadl2Package.NAMED_VALUE -> {
			var value = ((NamedValue) pe).getNamedValue();
			if (!(value instanceof NamedElement namedElement)) {
				var message = value.getClass().getSimpleName() + " is not supported";
				System.err.println(message);
				throw new UnsupportedOperationException(message);
			}

			if (namedElement.getName().equalsIgnoreCase(toBeMatched)) {
				yield namedElement;
			}
			if (namedElement instanceof Property property && property.getDefaultValue() != null) {
				yield getValue(property.getDefaultValue(), toBeMatched);
			}
			yield null;
		}
		default -> {
			var message = pe.getClass().getSimpleName() + " is not supported";
			System.err.println(message);
			throw new UnsupportedOperationException(message);
		}
		};
	}

	/**
	 * Returns the BasicProperty (Property or RecordField) object that the given
	 * PropertyExpression object belongs.
	 *
	 * @param pe the given PropertyExpression object
	 * @return the BasicProperty object that contains the given PropertyExpression object
	 */
	public static BasicProperty getContainingProperty(PropertyExpression pe) {
		var tmp = pe.eContainer();
		var classId = tmp.eClass().getClassifierID();

		while (false == (Aadl2Package.BASIC_PROPERTY_ASSOCIATION == classId
				|| Aadl2Package.PROPERTY_ASSOCIATION == classId || Aadl2Package.PROPERTY == classId)) {
			tmp = tmp.eContainer();
			classId = tmp.eClass().getClassifierID();
		}

		if (Aadl2Package.PROPERTY_ASSOCIATION == classId) {
			return ((PropertyAssociation) tmp).getProperty();
		} else if (Aadl2Package.BASIC_PROPERTY_ASSOCIATION == classId) {
			return ((BasicPropertyAssociation) tmp).getProperty();
		} else {
			return ((Property) tmp);
		}
	}
}
