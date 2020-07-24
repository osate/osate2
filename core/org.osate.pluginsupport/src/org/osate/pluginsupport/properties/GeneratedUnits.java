package org.osate.pluginsupport.properties;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.UnitLiteral;

/**
 * @since 4.1
 */
public interface GeneratedUnits<U> {
	double getFactorToBase();
	double getFactorTo(U target);
	UnitLiteral toUnitLiteral(ResourceSet resourceSet);
	NamedValue toPropertyExpression(ResourceSet resourceSet);
}