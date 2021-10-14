package org.osate.aadl2.errormodel.contrib.milstd882;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;

public class Milstd882 {
	public static final String MILSTD882__NAME = "MILSTD882";
	
	public static final String HAZARDS__NAME = "Hazards";
	
	public static Optional<List<Hazards>> getHazards(NamedElement lookupContext) {
		return getHazards(lookupContext, Optional.empty());
	}
	
	public static Optional<List<Hazards>> getHazards(NamedElement lookupContext, Mode mode) {
		return getHazards(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<Hazards>> getHazards(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "MILSTD882::Hazards";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return new Hazards(resolved1, lookupContext, mode);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getHazards_EObject(NamedElement lookupContext) {
		String name = "MILSTD882::Hazards";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
}
