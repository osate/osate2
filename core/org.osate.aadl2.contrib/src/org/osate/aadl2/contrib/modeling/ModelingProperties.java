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

public final class ModelingProperties {
	public static final String MODELING_PROPERTIES__NAME = "Modeling_Properties";
	
	public static final String ACCEPTABLE_ARRAY_SIZE__NAME = "Acceptable_Array_Size";
	public static final String CLASSIFIER_MATCHING_RULE__NAME = "Classifier_Matching_Rule";
	public static final String CLASSIFIER_SUBSTITUTION_RULE__NAME = "Classifier_Substitution_Rule";
	public static final String IMPLEMENTED_AS__NAME = "Implemented_As";
	public static final String PROTOTYPE_SUBSTITUTION_RULE__NAME = "Prototype_Substitution_Rule";
	
	private ModelingProperties() {}
	
	// Lookup methods for Modeling_Properties::Acceptable_Array_Size
	
	public static boolean acceptsAcceptableArraySize(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getAcceptableArraySize_Property(lookupContext));
	}
	
	public static Optional<List<IntegerRange>> getAcceptableArraySize(NamedElement lookupContext) {
		return getAcceptableArraySize(lookupContext, Optional.empty());
	}
	
	public static Optional<List<IntegerRange>> getAcceptableArraySize(NamedElement lookupContext, Mode mode) {
		return getAcceptableArraySize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<IntegerRange>> getAcceptableArraySize(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getAcceptableArraySize_Property(lookupContext);
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
	
	public static Property getAcceptableArraySize_Property(NamedElement lookupContext) {
		String name = MODELING_PROPERTIES__NAME + "::" + ACCEPTABLE_ARRAY_SIZE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getAcceptableArraySize_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getAcceptableArraySize_Property(lookupContext));
	}
	
	// Lookup methods for Modeling_Properties::Classifier_Matching_Rule
	
	public static boolean acceptsClassifierMatchingRule(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getClassifierMatchingRule_Property(lookupContext));
	}
	
	public static Optional<ClassifierMatchingRule> getClassifierMatchingRule(NamedElement lookupContext) {
		return getClassifierMatchingRule(lookupContext, Optional.empty());
	}
	
	public static Optional<ClassifierMatchingRule> getClassifierMatchingRule(NamedElement lookupContext, Mode mode) {
		return getClassifierMatchingRule(lookupContext, Optional.of(mode));
	}
	
	public static Optional<ClassifierMatchingRule> getClassifierMatchingRule(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getClassifierMatchingRule_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(ClassifierMatchingRule.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getClassifierMatchingRule_Property(NamedElement lookupContext) {
		String name = MODELING_PROPERTIES__NAME + "::" + CLASSIFIER_MATCHING_RULE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getClassifierMatchingRule_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getClassifierMatchingRule_Property(lookupContext));
	}
	
	// Lookup methods for Modeling_Properties::Classifier_Substitution_Rule
	
	public static boolean acceptsClassifierSubstitutionRule(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getClassifierSubstitutionRule_Property(lookupContext));
	}
	
	public static Optional<ClassifierSubstitutionRule> getClassifierSubstitutionRule(NamedElement lookupContext) {
		return getClassifierSubstitutionRule(lookupContext, Optional.empty());
	}
	
	public static Optional<ClassifierSubstitutionRule> getClassifierSubstitutionRule(NamedElement lookupContext, Mode mode) {
		return getClassifierSubstitutionRule(lookupContext, Optional.of(mode));
	}
	
	public static Optional<ClassifierSubstitutionRule> getClassifierSubstitutionRule(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getClassifierSubstitutionRule_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(ClassifierSubstitutionRule.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getClassifierSubstitutionRule_Property(NamedElement lookupContext) {
		String name = MODELING_PROPERTIES__NAME + "::" + CLASSIFIER_SUBSTITUTION_RULE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getClassifierSubstitutionRule_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getClassifierSubstitutionRule_Property(lookupContext));
	}
	
	// Lookup methods for Modeling_Properties::Implemented_As
	
	public static boolean acceptsImplementedAs(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getImplementedAs_Property(lookupContext));
	}
	
	public static Optional<Classifier> getImplementedAs(NamedElement lookupContext) {
		return getImplementedAs(lookupContext, Optional.empty());
	}
	
	public static Optional<Classifier> getImplementedAs(NamedElement lookupContext, Mode mode) {
		return getImplementedAs(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Classifier> getImplementedAs(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getImplementedAs_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ClassifierValue) resolved).getClassifier());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getImplementedAs_Property(NamedElement lookupContext) {
		String name = MODELING_PROPERTIES__NAME + "::" + IMPLEMENTED_AS__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getImplementedAs_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getImplementedAs_Property(lookupContext));
	}
	
	// Lookup methods for Modeling_Properties::Prototype_Substitution_Rule
	
	public static boolean acceptsPrototypeSubstitutionRule(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getPrototypeSubstitutionRule_Property(lookupContext));
	}
	
	public static Optional<PrototypeSubstitutionRule> getPrototypeSubstitutionRule(NamedElement lookupContext) {
		return getPrototypeSubstitutionRule(lookupContext, Optional.empty());
	}
	
	public static Optional<PrototypeSubstitutionRule> getPrototypeSubstitutionRule(NamedElement lookupContext, Mode mode) {
		return getPrototypeSubstitutionRule(lookupContext, Optional.of(mode));
	}
	
	public static Optional<PrototypeSubstitutionRule> getPrototypeSubstitutionRule(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getPrototypeSubstitutionRule_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(PrototypeSubstitutionRule.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getPrototypeSubstitutionRule_Property(NamedElement lookupContext) {
		String name = MODELING_PROPERTIES__NAME + "::" + PROTOTYPE_SUBSTITUTION_RULE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getPrototypeSubstitutionRule_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getPrototypeSubstitutionRule_Property(lookupContext));
	}
}
