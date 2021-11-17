package org.osate.aadl2.properties.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NumberType;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RangeType;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyAcc;

/**
 * Methods that provide access to raw property structures.  Generally
 * the property methods that are generated from AADL property sets should
 * be used.  These methods exist to support legacy code.  No new uses of these
 * methods should be made, and ideally, the uses of these methods should be
 * removed over time.  Methods at are in here come from the old
 * <code>org.osate.xtext.aadl2.properties.util.GetProperties</code> class.
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
}
