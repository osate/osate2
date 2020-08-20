package org.osate.aadl2.contrib.modeling;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.IntegerRange;

public class ModelingProperties {
	public static Optional<List<IntegerRange>> getAcceptableArraySize(NamedElement lookupContext) {
		return getAcceptableArraySize(lookupContext, Optional.empty());
	}
	
	public static Optional<List<IntegerRange>> getAcceptableArraySize(NamedElement lookupContext, Mode mode) {
		return getAcceptableArraySize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<IntegerRange>> getAcceptableArraySize(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Modeling_Properties::Acceptable_Array_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return new IntegerRange(resolved1, lookupContext, mode);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getAcceptableArraySize_EObject(NamedElement lookupContext) {
		String name = "Modeling_Properties::Acceptable_Array_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<ClassifierMatchingRule> getClassifierMatchingRule(NamedElement lookupContext) {
		return getClassifierMatchingRule(lookupContext, Optional.empty());
	}
	
	public static Optional<ClassifierMatchingRule> getClassifierMatchingRule(NamedElement lookupContext, Mode mode) {
		return getClassifierMatchingRule(lookupContext, Optional.of(mode));
	}
	
	public static Optional<ClassifierMatchingRule> getClassifierMatchingRule(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Modeling_Properties::Classifier_Matching_Rule";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(ClassifierMatchingRule.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getClassifierMatchingRule_EObject(NamedElement lookupContext) {
		String name = "Modeling_Properties::Classifier_Matching_Rule";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<ClassifierSubstitutionRule> getClassifierSubstitutionRule(NamedElement lookupContext) {
		return getClassifierSubstitutionRule(lookupContext, Optional.empty());
	}
	
	public static Optional<ClassifierSubstitutionRule> getClassifierSubstitutionRule(NamedElement lookupContext, Mode mode) {
		return getClassifierSubstitutionRule(lookupContext, Optional.of(mode));
	}
	
	public static Optional<ClassifierSubstitutionRule> getClassifierSubstitutionRule(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Modeling_Properties::Classifier_Substitution_Rule";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(ClassifierSubstitutionRule.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getClassifierSubstitutionRule_EObject(NamedElement lookupContext) {
		String name = "Modeling_Properties::Classifier_Substitution_Rule";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Classifier> getImplementedAs(NamedElement lookupContext) {
		return getImplementedAs(lookupContext, Optional.empty());
	}
	
	public static Optional<Classifier> getImplementedAs(NamedElement lookupContext, Mode mode) {
		return getImplementedAs(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Classifier> getImplementedAs(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Modeling_Properties::Implemented_As";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ClassifierValue) resolved).getClassifier());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getImplementedAs_EObject(NamedElement lookupContext) {
		String name = "Modeling_Properties::Implemented_As";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<PrototypeSubstitutionRule> getPrototypeSubstitutionRule(NamedElement lookupContext) {
		return getPrototypeSubstitutionRule(lookupContext, Optional.empty());
	}
	
	public static Optional<PrototypeSubstitutionRule> getPrototypeSubstitutionRule(NamedElement lookupContext, Mode mode) {
		return getPrototypeSubstitutionRule(lookupContext, Optional.of(mode));
	}
	
	public static Optional<PrototypeSubstitutionRule> getPrototypeSubstitutionRule(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Modeling_Properties::Prototype_Substitution_Rule";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(PrototypeSubstitutionRule.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getPrototypeSubstitutionRule_EObject(NamedElement lookupContext) {
		String name = "Modeling_Properties::Prototype_Substitution_Rule";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
}
