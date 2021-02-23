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

/**
 * @since 1.2
 */
public class CodeGenerationProperties {
	public static final String CODE_GENERATION_PROPERTIES__NAME = "Code_Generation_Properties";

	public static final String CONVENTION__NAME = "Convention";
	public static final String PARAMETER_USAGE__NAME = "Parameter_Usage";
	public static final String RETURN_PARAMETER__NAME = "Return_Parameter";

	public static Optional<Convention> getConvention(NamedElement lookupContext) {
		return getConvention(lookupContext, Optional.empty());
	}

	public static Optional<Convention> getConvention(NamedElement lookupContext, Mode mode) {
		return getConvention(lookupContext, Optional.of(mode));
	}

	public static Optional<Convention> getConvention(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Code_Generation_Properties::Convention";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(Convention.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getConvention_EObject(NamedElement lookupContext) {
		String name = "Code_Generation_Properties::Convention";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<ParameterUsage> getParameterUsage(NamedElement lookupContext) {
		return getParameterUsage(lookupContext, Optional.empty());
	}

	public static Optional<ParameterUsage> getParameterUsage(NamedElement lookupContext, Mode mode) {
		return getParameterUsage(lookupContext, Optional.of(mode));
	}

	public static Optional<ParameterUsage> getParameterUsage(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Code_Generation_Properties::Parameter_Usage";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(ParameterUsage.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getParameterUsage_EObject(NamedElement lookupContext) {
		String name = "Code_Generation_Properties::Parameter_Usage";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<Boolean> getReturnParameter(NamedElement lookupContext) {
		return getReturnParameter(lookupContext, Optional.empty());
	}

	public static Optional<Boolean> getReturnParameter(NamedElement lookupContext, Mode mode) {
		return getReturnParameter(lookupContext, Optional.of(mode));
	}

	public static Optional<Boolean> getReturnParameter(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Code_Generation_Properties::Return_Parameter";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getReturnParameter_EObject(NamedElement lookupContext) {
		String name = "Code_Generation_Properties::Return_Parameter";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
}
