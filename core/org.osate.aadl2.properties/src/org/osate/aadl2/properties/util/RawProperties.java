package org.osate.aadl2.properties.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Element;
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
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyIsListException;
import org.osate.aadl2.properties.PropertyIsModalException;
import org.osate.aadl2.properties.PropertyNotPresentException;

/**
 * Methods that provide access to raw property structures.  Generally
 * the property methods that are generated from AADL property sets should
 * be used.  These methods exist to support legacy code.  No new uses of these
 * methods should be made, and ideally, the uses of these methods should be
 * removed over time.  Methods at are in here come from the old
 * <code>org.osate.xtext.aadl2.properties.util.GetProperties</code> and.
 * <code>org.osate.xtext.aadl2.properties.util.PropertyUtils</code> classes.
 */
public final class RawProperties {
	private RawProperties() {
		// super
	}

	public static BasicPropertyAssociation getRecordField(EList<BasicPropertyAssociation> props, String fieldName) {
		for (BasicPropertyAssociation propertyAssociation : props) {
			BasicProperty prop = propertyAssociation.getProperty();
			String name = prop.getName();
			if (fieldName.equalsIgnoreCase(name)) {
				return propertyAssociation;
			}
		}
		return null;
	}

	/**
	 * returns true if property is explicitly assigned
	 *
	 * @param element
	 *            NamedELement
	 * @param pn
	 *            Property definition
	 * @return
	 */
	public static boolean hasAssignedPropertyValue(NamedElement element, String pname) {
		Property pn = Aadl2GlobalScopeUtil.get((EObject) element, Aadl2Package.eINSTANCE.getProperty(), pname);
		return isAssignedPropertyValue(element, pn);
	}

	/**
	 * find property definition for given name. The property may be qualified by
	 * the property set name via the ps parameter For predeclared properties
	 * this is not required
	 *
	 * @param context
	 *            EObject the model object that references the property
	 *            definition
	 * @param ps
	 *            String property set name, which may be null
	 * @param name
	 *            String Property Definition name
	 * @return Property or null
	 */
	public static Property lookupPropertyDefinition(EObject context, String ps, String name) {
		return Aadl2GlobalScopeUtil.get(context, Aadl2Package.eINSTANCE.getProperty(),
				((ps != null && !ps.isEmpty()) ? (ps + "::" + name) : name));
	}

	/**
	 * returns true if property is explicitly assigned
	 *
	 * @param element  NamedELement
	 * @param pn Property definition
	 * @return
	 */
	private static boolean isAssignedPropertyValue(NamedElement element, Property pn) {
		try {
			final PropertyAcc propertyAccumulator = element.getPropertyValue(pn);
			PropertyAssociation firstAssociation = propertyAccumulator.first();
			return firstAssociation != null;
		} catch (org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException exception) {
			return false;
		}
	}

	// XXX: Taken from PropertiesLinkingService because I don't want a dependency on org.osate.xtext.aadl2.properties
	public static UnitLiteral findUnitLiteral(Property property, String name) {
		PropertyType propertyType = property.getPropertyType();
		UnitsType unitsType = null;
		if (propertyType instanceof NumberType) {
			unitsType = ((NumberType) propertyType).getUnitsType();
		} else if (propertyType instanceof RangeType) {
			unitsType = ((RangeType) propertyType).getNumberType().getUnitsType();
		}
		if (unitsType != null) {
			return unitsType.findLiteral(name);
		}
		return null;
	}

	public static UnitLiteral findUnitLiteral(Element context, String unitsType, String literal) {
		PropertyType pt = Aadl2GlobalScopeUtil.get((EObject) context, Aadl2Package.eINSTANCE.getPropertyType(), unitsType);
		if (pt == null || !(pt instanceof UnitsType)) {
			return null;
		}
		return (UnitLiteral) ((UnitsType) pt).findNamedElement(literal);
	}

	//

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
	private static PropertyExpression getSimplePropertyValue(final NamedElement ph, final Property pd)
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
}
