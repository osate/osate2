package org.osate.pluginsupport.properties;

import java.util.Objects;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.UnitLiteral;

/**
 * @since 5.0
 */
public interface GeneratedUnits<U> {
	double getFactorToBase();
	double getFactorTo(U target);
	URI getURI();
	
	default UnitLiteral toUnitLiteral(ResourceSet resourceSet) {
		String expectedName = toString();
		UnitLiteral literal = (UnitLiteral) resourceSet.getEObject(getURI(), true);
		if (literal == null) {
			throw new RuntimeException("Could not resolve UnitLiteral '" + expectedName + "'.");
		}
		String foundName = literal.getName();
		if (!Objects.equals(foundName, expectedName)) {
			throw new RuntimeException("Expected UnitLiteral '" + expectedName + "', but found '" + foundName + "'.");
		}
		return literal;
	}
	
	default NamedValue toPropertyExpression(ResourceSet resourceSet) {
		NamedValue value = Aadl2Factory.eINSTANCE.createNamedValue();
		value.setNamedValue(toUnitLiteral(resourceSet));
		return value;
	}
}