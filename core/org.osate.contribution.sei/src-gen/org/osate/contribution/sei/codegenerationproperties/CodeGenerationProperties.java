package org.osate.contribution.sei.codegenerationproperties;

import java.util.Optional;

import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;

public final class CodeGenerationProperties {
	public static final String CODE_GENERATION_PROPERTIES__NAME = "Code_Generation_Properties";
	
	public static final String CONVENTION__NAME = "Convention";
	public static final String PARAMETER_USAGE__NAME = "Parameter_Usage";
	public static final String RETURN_PARAMETER__NAME = "Return_Parameter";
	
	private CodeGenerationProperties() {}
	
	// Lookup methods for Code_Generation_Properties::Convention
	
	public static boolean acceptsConvention(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getConvention_Property(lookupContext));
	}
	
	public static Optional<Convention> getConvention(NamedElement lookupContext) {
		return getConvention(lookupContext, Optional.empty());
	}
	
	public static Optional<Convention> getConvention(NamedElement lookupContext, Mode mode) {
		return getConvention(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Convention> getConvention(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getConvention_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(Convention.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getConvention_Property(NamedElement lookupContext) {
		String name = CODE_GENERATION_PROPERTIES__NAME + "::" + CONVENTION__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getConvention_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getConvention_Property(lookupContext));
	}
	
	// Lookup methods for Code_Generation_Properties::Parameter_Usage
	
	public static boolean acceptsParameterUsage(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getParameterUsage_Property(lookupContext));
	}
	
	public static Optional<ParameterUsage> getParameterUsage(NamedElement lookupContext) {
		return getParameterUsage(lookupContext, Optional.empty());
	}
	
	public static Optional<ParameterUsage> getParameterUsage(NamedElement lookupContext, Mode mode) {
		return getParameterUsage(lookupContext, Optional.of(mode));
	}
	
	public static Optional<ParameterUsage> getParameterUsage(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getParameterUsage_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(ParameterUsage.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getParameterUsage_Property(NamedElement lookupContext) {
		String name = CODE_GENERATION_PROPERTIES__NAME + "::" + PARAMETER_USAGE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getParameterUsage_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getParameterUsage_Property(lookupContext));
	}
	
	// Lookup methods for Code_Generation_Properties::Return_Parameter
	
	public static boolean acceptsReturnParameter(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getReturnParameter_Property(lookupContext));
	}
	
	public static Optional<Boolean> getReturnParameter(NamedElement lookupContext) {
		return getReturnParameter(lookupContext, Optional.empty());
	}
	
	public static Optional<Boolean> getReturnParameter(NamedElement lookupContext, Mode mode) {
		return getReturnParameter(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Boolean> getReturnParameter(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getReturnParameter_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getReturnParameter_Property(NamedElement lookupContext) {
		String name = CODE_GENERATION_PROPERTIES__NAME + "::" + RETURN_PARAMETER__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getReturnParameter_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getReturnParameter_Property(lookupContext));
	}
}
