package org.osate.contribution.sei.physical;

import java.util.Optional;

import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.RealWithUnits;

public class Physical {
	public static final String PHYSICAL__NAME = "Physical";
	
	public static final String VOLTAGE__NAME = "Voltage";
	
	// Lookup methods for Physical::Voltage
	
	public static boolean acceptsVoltage(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getVoltage_Property(lookupContext));
	}
	
	public static Optional<RealWithUnits<VoltageUnits>> getVoltage(NamedElement lookupContext) {
		return getVoltage(lookupContext, Optional.empty());
	}
	
	public static Optional<RealWithUnits<VoltageUnits>> getVoltage(NamedElement lookupContext, Mode mode) {
		return getVoltage(lookupContext, Optional.of(mode));
	}
	
	public static Optional<RealWithUnits<VoltageUnits>> getVoltage(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getVoltage_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, VoltageUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getVoltage_Property(NamedElement lookupContext) {
		String name = PHYSICAL__NAME + "::" + VOLTAGE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getVoltage_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getVoltage_Property(lookupContext));
	}
}
