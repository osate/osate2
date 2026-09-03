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
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ComputedValue;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.Subcomponent;
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
	 * Extract integer value from a specified property. Convert it
	 * to a given unit.
	 * May return null
	 *
	 * @param i
	 *            component instance.
	 * @param propertyName
	 *            property name.
	 * @param unit
	 * 			target unit for conversion
	 * @return property value.
	 */
	public static Long getIntValue(NamedElement i, String propertyName, String targetUnit) {
		var pa = findPropertyAssociation(propertyName, i);

		if (pa != null) {
			var p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				var values = pa.getOwnedValues();

				if (values.size() == 1) {
					var expr = values.getFirst().getOwnedValue();

					if (expr instanceof IntegerLiteral literal) {
						var unit = literal.getUnit();
						if (unit != null) {
							// Warning: the cast from double to long is licit
							// only if the result of the conversion is an
							// integer
							return (long) literal.getScaledValue(targetUnit);
						}

						return literal.getValue();
					}
				}
			}
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
	 *    * TODO: DOC ME !
	 *
	 * May return null
	 *
	 * @param i
	 * @param propertyName
	 * @return
	 */
	public static RecordValue getRecordValue(NamedElement i, String propertyName) {
		var pa = findPropertyAssociation(propertyName, i);

		if (pa != null) {
			var p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				var values = pa.getOwnedValues();

				if (values.size() == 1) {
					if (values.getFirst().getOwnedValue() instanceof RecordValue record) {
						return record;
					}
				}
			}
		}

		return null;
	}

	public static List<RecordValue> getListRecordValue(NamedElement ne, String propertyName) {
		List<RecordValue> result = null;

		var lv = getListValue(ne, propertyName);

		if (lv != null) {
			var pes = lv.getOwnedListElements();

			if (!pes.isEmpty() && pes.getFirst() instanceof RecordValue) {
				result = new ArrayList<>(pes.size());

				for (var pe : pes) {
					result.add((RecordValue) pe);
				}
			}
		}

		return result;
	}

	public static ListValue getListValue(NamedElement ne, String propertyName) {
		var pa = findPropertyAssociation(propertyName, ne);

		if (pa != null) {
			var p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				var values = pa.getOwnedValues();

				if (values.size() == 1) {
					if (values.getFirst().getOwnedValue() instanceof ListValue list) {
						return list;
					}
				}
			}
		}

		return null;
	}

	/**
	 * Extract float value from a specified property. May return null.
	 *
	 * @param i
	 *            component instance.
	 * @param propertyName
	 *            property name.
	 * @return property value.
	 */
	public static Float getFloatValue(NamedElement i, String propertyName, String unit) {
		var pa = findPropertyAssociation(propertyName, i);

		if (pa != null) {
			var p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				var values = pa.getOwnedValues();

				if (values.size() == 1) {
					if (values.getFirst().getOwnedValue() instanceof NumberValue number) {
						float fVal = 0f;

						if (number instanceof IntegerLiteral integer) {
							fVal = integer.getValue();
						} else if (number instanceof RealLiteral real) {
							fVal = (float) real.getValue();
						}

						return UnitConversion.convertInMs(fVal, number.getUnit().getName());
					}
				}
			}
		}
		// try on a refined NamedElement
		if (i instanceof RefinableElement refinable && refinable.getRefinedElement() != null) {
			return getFloatValue(refinable.getRefinedElement(), propertyName, unit);
			}

		return null;
	}

	/**
	 * Extract float value from a specified property. May return null.
	 *
	 * @param i
	 *            component instance.
	 * @param propertyName
	 *            property name.
	 * @return property value.
	 */
	public static Float getFloatValue(NamedElement i, String propertyName) {
		var pa = findPropertyAssociation(propertyName, i);

		if (pa != null) {
			var p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				var values = pa.getOwnedValues();

				if (values.size() == 1) {
					var expr = values.getFirst().getOwnedValue();

					if (expr instanceof IntegerLiteral integer) {
						return (float) integer.getValue();
					} else if (expr instanceof RealLiteral real) {
						return (float) real.getValue();
					}
				}
			}
		}
		// try on a refined NamedElement
		if (i instanceof RefinableElement refinable && refinable.getRefinedElement() != null) {
			return getFloatValue(refinable.getRefinedElement(), propertyName);
		}

		return null;
	}

	/**
	 * Extract boolean value from a specified property. May return null.
	 *
	 * @param i
	 *            component instance.
	 * @param propertyName
	 *            property name.
	 * @return property value.
	 */
	public static Boolean getBooleanValue(NamedElement i, String propertyName) {
		var pa = findPropertyAssociation(propertyName, i);

		if (pa != null) {
			var p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				var values = pa.getOwnedValues();

				if (values.size() == 1) {
					if (values.getFirst().getOwnedValue() instanceof BooleanLiteral literal) {
						return literal.getValue();
					}
				}
			}
		}

		return null;
	}

	/**
	 * Extract String value from a specified property. May return null.
	 *
	 * @param i
	 *            component instance.
	 * @param propertyName
	 *            property name.
	 * @return property value.
	 */
	public static String getStringValue(NamedElement i, String propertyName) {
		var pa = findPropertyAssociation(propertyName, i);

		if (pa != null) {
			var p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				var values = pa.getOwnedValues();

				if (values.size() == 1) {
					if (values.getFirst().getOwnedValue() instanceof StringLiteral literal) {
						return literal.getValue();
					}
				}
			}
		}

		return null;
	}

	/**
	 * Extract String list value from a specified property. May return null.
	 *
	 * @param i
	 *            component instance.
	 * @param propertyName
	 *            property name.
	 * @return property value.
	 */
	public static List<String> getStringListValue(NamedElement i, String propertyName) {
		var result = new ArrayList<String>();
		var pa = findPropertyAssociation(propertyName, i);

		if (pa != null) {
			var p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				var values = pa.getOwnedValues();

				if (values.size() == 1) {
					if (values.getFirst().getOwnedValue() instanceof ListValue list) {
						for (var element : list.getOwnedListElements()) {
							if (element instanceof StringLiteral literal) {
								result.add(literal.getValue());
							} else if (element instanceof NamedValue named
									&& named.getNamedValue() instanceof EnumerationLiteral literal) {
								result.add(literal.getName());
								}
						}

						if (!result.isEmpty()) {
							return result;
						}
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

	/**
	 * Extract range value from a specified property. May return null.
	 *
	 * @param i
	 *            component instance.
	 * @param propertyName
	 *            property name.
	 * @return property value.
	 */
	public static RangeValue getRangeValue(NamedElement i, String propertyName) {
		var pa = findPropertyAssociation(propertyName, i);

		if (pa != null) {
			var p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				var values = pa.getOwnedValues();

				if (values.size() == 1) {
					if (values.getFirst().getOwnedValue() instanceof RangeValue range) {
						return range;
					}
				}
			}
		}

		return null;
	}

	/**
	 * Extract minimum range value from a specified property. May return null.
	 *
	 * @param i
	 *            component instance.
	 * @param propertyName
	 *            property name.
	 * @return property value.
	 */
	public static NumberValue getMinRangeValue(NamedElement i, String propertyName) {
		var pa = findPropertyAssociation(propertyName, i);

		if (pa != null) {
			var p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				var values = pa.getOwnedValues();

				if (values.size() == 1) {
					var expr = values.getFirst().getOwnedValue();

					if (expr instanceof RangeValue range) {
						return range.getMinimumValue();
					} else if (expr instanceof NumberValue number) {
						return number;
					}
				}
			}
		}

		return null;
	}

	/**
	 * Extract maximum range value from a specified property. May return null.
	 *
	 * @param i
	 *            component instance.
	 * @param propertyName
	 *            property name.
	 * @return property value.
	 */
	public static NumberValue getMaxRangeValue(NamedElement i, String propertyName) {
		var pa = findPropertyAssociation(propertyName, i);

		if (pa != null) {
			var p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				var values = pa.getOwnedValues();

				if (values.size() == 1) {
					var expr = values.getFirst().getOwnedValue();

					if (expr instanceof RangeValue range) {
						return range.getMaximumValue();
					} else if (expr instanceof NumberValue number) {
						return number;
					}
				}
			}
		}

		return null;
	}

	/**
	 * Extract maximum range value from a specified property.
	 *
	 * @param i
	 *            component instance.
	 * @param propertyName
	 *            property name.
	 * @return property value.
	 */
	public static double getMaxRangeValue(NamedElement i, String propertyName, float defaultValue) {
		var rl = (RealLiteral) getMaxRangeValue(i, propertyName);
		if (rl != null) {
			return rl.getValue();
		} else {
			return defaultValue;
		}
	}

	/**
	 * TODO: DOC ME !
	 *
	 * May return null.
	 *
	 * @param propertyName
	 * @param owner
	 * @return
	 */
	public static ComponentInstance getPropertyComponentRef(String propertyName, NamedElement owner) {
		var val = getPropertyValue(propertyName, owner);
		if (val != null) {
			return (ComponentInstance) ((InstanceReferenceValue) val).getReferencedInstanceObject();
		} else {
			return null;
		}
	}

	/**
	 * TODO: DOC ME !
	 *
	 * May return null.
	 *
	 * @param propertyName
	 * @param owner
	 * @return
	 */
	public static PropertyExpression getPropertyValue(String propertyName, NamedElement owner) {
		var assign = findPropertyAssociation(propertyName, owner);

		if (assign != null) {
			return assign.getOwnedValues().get(0).getOwnedValue();
		}

		return null;
	}

	/**
	 * TODO: DOC ME !
	 *
	 * May return null.
	 *
	 * @param owner
	 * @param propertyName
	 * @return
	 */
	public static Classifier getClassifierValue(NamedElement owner, String propertyName) {
		var pa = findPropertyAssociation(propertyName, owner);

		if (pa != null) {
			var p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				var values = pa.getOwnedValues();

				if (values.size() == 1) {
					if (values.getFirst().getOwnedValue() instanceof ClassifierValue classifier) {
						return classifier.getClassifier();
					}
				}
			}
		}

		return null;
	}

	public static PropertyAssociation createIntegerAssignment(String propertyName, long value) {
		var property = Aadl2Factory.eINSTANCE.createProperty();
		var assignment = Aadl2Factory.eINSTANCE.createPropertyAssociation();
		var modalPropertyValue = Aadl2Factory.eINSTANCE.createModalPropertyValue();
		var propertyValue = Aadl2Factory.eINSTANCE.createIntegerLiteral();
		property.setName(propertyName);
		propertyValue.setValue(value);
		modalPropertyValue.setOwnedValue(propertyValue);
		assignment.setProperty(property);
		assignment.getOwnedValues().add(modalPropertyValue);
		return assignment;
	}

	public static boolean setFloatValue(NamedElement e, String propertyName, float value) {
		var pa = findPropertyAssociation(propertyName, e);

		if (pa != null) {
			var r = Aadl2Factory.eINSTANCE.createRealLiteral();
			r.setValue(value);
			r.setUnit(getUnit(pa));
			pa.getOwnedValues().get(0).setOwnedValue(r);
			return true;
		}

		return false;
	}

	// May return null.
	private static UnitLiteral getUnit(PropertyAssociation pa) {
		var value = pa.getOwnedValues().getFirst().getOwnedValue();
		if (value instanceof NumberValue number) {
			return number.getUnit();
		} else if (value instanceof RangeValue range) {
			return range.getMaximumValue().getUnit();
		} else {
			return null;
		}
	}

	/**
	 * TODO: DOC ME !
	 *
	 * May return null.
	 *
	 *
	 * @param object
	 * @param propertyName
	 * @return
	 */
	public static List<ComponentInstance> getComponentInstanceList(NamedElement object, String propertyName) {
		List<ComponentInstance> res = null;
		var pa = findPropertyAssociation(propertyName, object);

		if (pa != null) {
			res = new ArrayList<>();
			var p = pa.getProperty();

			if (p.getName().equals(propertyName)) {
				var values = pa.getOwnedValues();

				if (values.size() == 1) {
					if (values.getFirst().getOwnedValue() instanceof ListValue list) {
						for (var element : list.getOwnedListElements()) {
							if (element instanceof InstanceReferenceValue reference) {
								res.add((ComponentInstance) reference.getReferencedInstanceObject());
							}
						}
					}
				}
			}
		}

		return res;
	}

	/**
	 * May return an empty list.
	 *
	 *
	 * @param object
	 * @param propertyName
	 * @return
	 */
	public static List<Subcomponent> getSubcomponentList(NamedElement object, String propertyName) {
		var result = new ArrayList<Subcomponent>();
		var pa = findPropertyAssociation(propertyName, object);
		if (pa == null) {
			return null;
		} else {
			var p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				var values = pa.getOwnedValues();

				if (values.size() == 1) {
					if (values.getFirst().getOwnedValue() instanceof ListValue list) {
						for (var element : list.getOwnedListElements()) {
							if (element instanceof ReferenceValue reference) {
								for (var pathElement : reference.getContainmentPathElements()) {
									result.add((Subcomponent) pathElement.getNamedElement());
								}
							}
						}
					}
				}
			}
			return result;
		}
	}

	/**
	 *
	 * TODO: DOC ME !
	 *
	 * May return null.
	 *
	 *
	 * @param object
	 * @param propertyName
	 * @return
	 */
	public static List<Long> getIntListValue(NamedElement object, String propertyName) {
		var result = new ArrayList<Long>();
		var pa = findPropertyAssociation(propertyName, object);

		if (pa == null) {
			return null;
		} else {
			var p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				var values = pa.getOwnedValues();

				if (values.size() == 1) {
					if (values.getFirst().getOwnedValue() instanceof ListValue list) {
						for (var element : list.getOwnedListElements()) {
							if (element instanceof IntegerLiteral integer) {
								result.add(integer.getValue());
							}
						}
					}
				}
			}
		}
		// try on a refined NamedElement
		if (object instanceof RefinableElement refinable && refinable.getRefinedElement() != null) {
			var inherited = getIntListValue(refinable.getRefinedElement(), propertyName);
				if (inherited != null) {
					result.addAll(inherited);
				}
		}
		return result;
	}

	/**
	 * May return an empty list.
	 *
	 *
	 * @param object
	 * @param propertyName
	 * @return
	 */
	public static List<Subcomponent> getSubcomponentList(ProcessorSubcomponent object, String propertyName) {
		var result = new ArrayList<Subcomponent>();
		var pa = findPropertyAssociation(propertyName, object);

		if (pa != null) {
			var p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				var values = pa.getOwnedValues();

				if (values.size() == 1) {
					if (values.getFirst().getOwnedValue() instanceof ListValue list) {
						for (var element : list.getOwnedListElements()) {
							if (element instanceof ReferenceValue reference) {
								var pathElement = reference.getContainmentPathElements().getLast();
								result.add((Subcomponent) pathElement.getNamedElement());
							}
						}
					}
				}
			}
		}
		// try on a refined NamedElement
		if (object.getRefinedElement() != null) {
				var inherited = getSubcomponentList((ProcessorSubcomponent) object.getRefinedElement(),
						propertyName);
				if (!inherited.isEmpty()) {
					result.addAll(inherited);
				}
		}
		return result;
	}

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
