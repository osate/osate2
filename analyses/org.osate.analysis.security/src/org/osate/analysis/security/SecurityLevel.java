package org.osate.analysis.security;

import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;

public class SecurityLevel {
	private final Property securityLevel;

	public SecurityLevel(final Property sl) {
		securityLevel = sl;
	}

	public long getSecurityLevel(final NamedElement ph) {
		final PropertyExpression pv = ph.getSimplePropertyValue(securityLevel);
		if (pv instanceof IntegerLiteral) {
			return ((IntegerLiteral) pv).getValue();
		} else {
			return -1L;
		}
	}

	public void setSecurityLevel(final NamedElement ph, final long level) {
		// Create new property value: An Integer value
		final IntegerLiteral newpv = Aadl2Factory.eINSTANCE.createIntegerLiteral();
		// Set the integer value to the new value
		newpv.setValue(level);
		// Set the property association
		ph.setPropertyValue(securityLevel, newpv);
	}
}
