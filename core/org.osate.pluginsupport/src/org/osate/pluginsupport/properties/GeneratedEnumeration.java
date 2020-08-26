package org.osate.pluginsupport.properties;

import java.util.Objects;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;

/**
 * @since 5.0
 */
public interface GeneratedEnumeration {
	URI getURI();
	
	default EnumerationLiteral toEnumerationLiteral(ResourceSet resourceSet) {
		String expectedName = toString();
		EnumerationLiteral literal = (EnumerationLiteral) resourceSet.getEObject(getURI(), true);
		if (literal == null) {
			throw new RuntimeException("Could not resolve EnumerationLiteral '" + expectedName + "'.");
		}
		String foundName = literal.getName();
		if (!Objects.equals(foundName, expectedName)) {
			String message = "Expected EnumerationLiteral '" + expectedName + "', but found '" + foundName + "'.";
			throw new RuntimeException(message);
		}
		return literal;
	}
	
	default NamedValue toPropertyExpression(ResourceSet resourceSet) {
		NamedValue value = Aadl2Factory.eINSTANCE.createNamedValue();
		value.setNamedValue(toEnumerationLiteral(resourceSet));
		return value;
	}
}