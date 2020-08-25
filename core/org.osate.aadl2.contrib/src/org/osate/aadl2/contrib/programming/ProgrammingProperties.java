package org.osate.aadl2.contrib.programming;

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
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.contrib.aadlproject.SupportedHardwareSourceLanguages;
import org.osate.aadl2.contrib.aadlproject.SupportedSourceLanguages;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;

public class ProgrammingProperties {
	public static final String PROGRAMMING_PROPERTIES__NAME = "Programming_Properties";
	
	public static final String ACTIVATE_ENTRYPOINT__NAME = "Activate_Entrypoint";
	public static final String ACTIVATE_ENTRYPOINT_CALL_SEQUENCE__NAME = "Activate_Entrypoint_Call_Sequence";
	public static final String ACTIVATE_ENTRYPOINT_SOURCE_TEXT__NAME = "Activate_Entrypoint_Source_Text";
	public static final String COMPUTE_ENTRYPOINT__NAME = "Compute_Entrypoint";
	public static final String COMPUTE_ENTRYPOINT_CALL_SEQUENCE__NAME = "Compute_Entrypoint_Call_Sequence";
	public static final String COMPUTE_ENTRYPOINT_SOURCE_TEXT__NAME = "Compute_Entrypoint_Source_Text";
	public static final String DEACTIVATE_ENTRYPOINT__NAME = "Deactivate_Entrypoint";
	public static final String DEACTIVATE_ENTRYPOINT_CALL_SEQUENCE__NAME = "Deactivate_Entrypoint_Call_Sequence";
	public static final String DEACTIVATE_ENTRYPOINT_SOURCE_TEXT__NAME = "Deactivate_Entrypoint_Source_Text";
	public static final String FINALIZE_ENTRYPOINT__NAME = "Finalize_Entrypoint";
	public static final String FINALIZE_ENTRYPOINT_CALL_SEQUENCE__NAME = "Finalize_Entrypoint_Call_Sequence";
	public static final String FINALIZE_ENTRYPOINT_SOURCE_TEXT__NAME = "Finalize_Entrypoint_Source_Text";
	public static final String INITIALIZE_ENTRYPOINT__NAME = "Initialize_Entrypoint";
	public static final String INITIALIZE_ENTRYPOINT_CALL_SEQUENCE__NAME = "Initialize_Entrypoint_Call_Sequence";
	public static final String INITIALIZE_ENTRYPOINT_SOURCE_TEXT__NAME = "Initialize_Entrypoint_Source_Text";
	public static final String RECOVER_ENTRYPOINT__NAME = "Recover_Entrypoint";
	public static final String RECOVER_ENTRYPOINT_CALL_SEQUENCE__NAME = "Recover_Entrypoint_Call_Sequence";
	public static final String RECOVER_ENTRYPOINT_SOURCE_TEXT__NAME = "Recover_Entrypoint_Source_Text";
	public static final String SOURCE_LANGUAGE__NAME = "Source_Language";
	public static final String SOURCE_NAME__NAME = "Source_Name";
	public static final String SOURCE_TEXT__NAME = "Source_Text";
	public static final String SUPPORTED_SOURCE_LANGUAGE__NAME = "Supported_Source_Language";
	public static final String TYPE_SOURCE_NAME__NAME = "Type_Source_Name";
	public static final String HARDWARE_DESCRIPTION_SOURCE_TEXT__NAME = "Hardware_Description_Source_Text";
	public static final String HARDWARE_SOURCE_LANGUAGE__NAME = "Hardware_Source_Language";
	public static final String DEVICE_DRIVER__NAME = "Device_Driver";
	
	public static Optional<Classifier> getActivateEntrypoint(NamedElement lookupContext) {
		return getActivateEntrypoint(lookupContext, Optional.empty());
	}
	
	public static Optional<Classifier> getActivateEntrypoint(NamedElement lookupContext, Mode mode) {
		return getActivateEntrypoint(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Classifier> getActivateEntrypoint(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Activate_Entrypoint";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ClassifierValue) resolved).getClassifier());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getActivateEntrypoint_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Activate_Entrypoint";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<InstanceObject> getActivateEntrypointCallSequence(NamedElement lookupContext) {
		return getActivateEntrypointCallSequence(lookupContext, Optional.empty());
	}
	
	public static Optional<InstanceObject> getActivateEntrypointCallSequence(NamedElement lookupContext, Mode mode) {
		return getActivateEntrypointCallSequence(lookupContext, Optional.of(mode));
	}
	
	public static Optional<InstanceObject> getActivateEntrypointCallSequence(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Activate_Entrypoint_Call_Sequence";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getActivateEntrypointCallSequence_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Activate_Entrypoint_Call_Sequence";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<String> getActivateEntrypointSourceText(NamedElement lookupContext) {
		return getActivateEntrypointSourceText(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getActivateEntrypointSourceText(NamedElement lookupContext, Mode mode) {
		return getActivateEntrypointSourceText(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getActivateEntrypointSourceText(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Activate_Entrypoint_Source_Text";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getActivateEntrypointSourceText_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Activate_Entrypoint_Source_Text";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Classifier> getComputeEntrypoint(NamedElement lookupContext) {
		return getComputeEntrypoint(lookupContext, Optional.empty());
	}
	
	public static Optional<Classifier> getComputeEntrypoint(NamedElement lookupContext, Mode mode) {
		return getComputeEntrypoint(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Classifier> getComputeEntrypoint(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Compute_Entrypoint";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ClassifierValue) resolved).getClassifier());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getComputeEntrypoint_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Compute_Entrypoint";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<InstanceObject> getComputeEntrypointCallSequence(NamedElement lookupContext) {
		return getComputeEntrypointCallSequence(lookupContext, Optional.empty());
	}
	
	public static Optional<InstanceObject> getComputeEntrypointCallSequence(NamedElement lookupContext, Mode mode) {
		return getComputeEntrypointCallSequence(lookupContext, Optional.of(mode));
	}
	
	public static Optional<InstanceObject> getComputeEntrypointCallSequence(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Compute_Entrypoint_Call_Sequence";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getComputeEntrypointCallSequence_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Compute_Entrypoint_Call_Sequence";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<String> getComputeEntrypointSourceText(NamedElement lookupContext) {
		return getComputeEntrypointSourceText(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getComputeEntrypointSourceText(NamedElement lookupContext, Mode mode) {
		return getComputeEntrypointSourceText(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getComputeEntrypointSourceText(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Compute_Entrypoint_Source_Text";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getComputeEntrypointSourceText_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Compute_Entrypoint_Source_Text";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Classifier> getDeactivateEntrypoint(NamedElement lookupContext) {
		return getDeactivateEntrypoint(lookupContext, Optional.empty());
	}
	
	public static Optional<Classifier> getDeactivateEntrypoint(NamedElement lookupContext, Mode mode) {
		return getDeactivateEntrypoint(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Classifier> getDeactivateEntrypoint(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Deactivate_Entrypoint";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ClassifierValue) resolved).getClassifier());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDeactivateEntrypoint_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Deactivate_Entrypoint";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<InstanceObject> getDeactivateEntrypointCallSequence(NamedElement lookupContext) {
		return getDeactivateEntrypointCallSequence(lookupContext, Optional.empty());
	}
	
	public static Optional<InstanceObject> getDeactivateEntrypointCallSequence(NamedElement lookupContext, Mode mode) {
		return getDeactivateEntrypointCallSequence(lookupContext, Optional.of(mode));
	}
	
	public static Optional<InstanceObject> getDeactivateEntrypointCallSequence(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Deactivate_Entrypoint_Call_Sequence";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDeactivateEntrypointCallSequence_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Deactivate_Entrypoint_Call_Sequence";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<String> getDeactivateEntrypointSourceText(NamedElement lookupContext) {
		return getDeactivateEntrypointSourceText(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getDeactivateEntrypointSourceText(NamedElement lookupContext, Mode mode) {
		return getDeactivateEntrypointSourceText(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getDeactivateEntrypointSourceText(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Deactivate_Entrypoint_Source_Text";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDeactivateEntrypointSourceText_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Deactivate_Entrypoint_Source_Text";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Classifier> getFinalizeEntrypoint(NamedElement lookupContext) {
		return getFinalizeEntrypoint(lookupContext, Optional.empty());
	}
	
	public static Optional<Classifier> getFinalizeEntrypoint(NamedElement lookupContext, Mode mode) {
		return getFinalizeEntrypoint(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Classifier> getFinalizeEntrypoint(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Finalize_Entrypoint";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ClassifierValue) resolved).getClassifier());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getFinalizeEntrypoint_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Finalize_Entrypoint";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<InstanceObject> getFinalizeEntrypointCallSequence(NamedElement lookupContext) {
		return getFinalizeEntrypointCallSequence(lookupContext, Optional.empty());
	}
	
	public static Optional<InstanceObject> getFinalizeEntrypointCallSequence(NamedElement lookupContext, Mode mode) {
		return getFinalizeEntrypointCallSequence(lookupContext, Optional.of(mode));
	}
	
	public static Optional<InstanceObject> getFinalizeEntrypointCallSequence(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Finalize_Entrypoint_Call_Sequence";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getFinalizeEntrypointCallSequence_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Finalize_Entrypoint_Call_Sequence";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<String> getFinalizeEntrypointSourceText(NamedElement lookupContext) {
		return getFinalizeEntrypointSourceText(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getFinalizeEntrypointSourceText(NamedElement lookupContext, Mode mode) {
		return getFinalizeEntrypointSourceText(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getFinalizeEntrypointSourceText(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Finalize_Entrypoint_Source_Text";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getFinalizeEntrypointSourceText_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Finalize_Entrypoint_Source_Text";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Classifier> getInitializeEntrypoint(NamedElement lookupContext) {
		return getInitializeEntrypoint(lookupContext, Optional.empty());
	}
	
	public static Optional<Classifier> getInitializeEntrypoint(NamedElement lookupContext, Mode mode) {
		return getInitializeEntrypoint(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Classifier> getInitializeEntrypoint(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Initialize_Entrypoint";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ClassifierValue) resolved).getClassifier());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getInitializeEntrypoint_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Initialize_Entrypoint";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<InstanceObject> getInitializeEntrypointCallSequence(NamedElement lookupContext) {
		return getInitializeEntrypointCallSequence(lookupContext, Optional.empty());
	}
	
	public static Optional<InstanceObject> getInitializeEntrypointCallSequence(NamedElement lookupContext, Mode mode) {
		return getInitializeEntrypointCallSequence(lookupContext, Optional.of(mode));
	}
	
	public static Optional<InstanceObject> getInitializeEntrypointCallSequence(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Initialize_Entrypoint_Call_Sequence";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getInitializeEntrypointCallSequence_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Initialize_Entrypoint_Call_Sequence";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<String> getInitializeEntrypointSourceText(NamedElement lookupContext) {
		return getInitializeEntrypointSourceText(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getInitializeEntrypointSourceText(NamedElement lookupContext, Mode mode) {
		return getInitializeEntrypointSourceText(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getInitializeEntrypointSourceText(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Initialize_Entrypoint_Source_Text";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getInitializeEntrypointSourceText_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Initialize_Entrypoint_Source_Text";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Classifier> getRecoverEntrypoint(NamedElement lookupContext) {
		return getRecoverEntrypoint(lookupContext, Optional.empty());
	}
	
	public static Optional<Classifier> getRecoverEntrypoint(NamedElement lookupContext, Mode mode) {
		return getRecoverEntrypoint(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Classifier> getRecoverEntrypoint(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Recover_Entrypoint";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ClassifierValue) resolved).getClassifier());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getRecoverEntrypoint_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Recover_Entrypoint";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<InstanceObject> getRecoverEntrypointCallSequence(NamedElement lookupContext) {
		return getRecoverEntrypointCallSequence(lookupContext, Optional.empty());
	}
	
	public static Optional<InstanceObject> getRecoverEntrypointCallSequence(NamedElement lookupContext, Mode mode) {
		return getRecoverEntrypointCallSequence(lookupContext, Optional.of(mode));
	}
	
	public static Optional<InstanceObject> getRecoverEntrypointCallSequence(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Recover_Entrypoint_Call_Sequence";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getRecoverEntrypointCallSequence_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Recover_Entrypoint_Call_Sequence";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<String> getRecoverEntrypointSourceText(NamedElement lookupContext) {
		return getRecoverEntrypointSourceText(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getRecoverEntrypointSourceText(NamedElement lookupContext, Mode mode) {
		return getRecoverEntrypointSourceText(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getRecoverEntrypointSourceText(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Recover_Entrypoint_Source_Text";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getRecoverEntrypointSourceText_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Recover_Entrypoint_Source_Text";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<SupportedSourceLanguages>> getSourceLanguage(NamedElement lookupContext) {
		return getSourceLanguage(lookupContext, Optional.empty());
	}
	
	public static Optional<List<SupportedSourceLanguages>> getSourceLanguage(NamedElement lookupContext, Mode mode) {
		return getSourceLanguage(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<SupportedSourceLanguages>> getSourceLanguage(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Source_Language";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return SupportedSourceLanguages.valueOf(resolved1);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSourceLanguage_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Source_Language";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<String> getSourceName(NamedElement lookupContext) {
		return getSourceName(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getSourceName(NamedElement lookupContext, Mode mode) {
		return getSourceName(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getSourceName(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Source_Name";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSourceName_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Source_Name";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<String>> getSourceText(NamedElement lookupContext) {
		return getSourceText(lookupContext, Optional.empty());
	}
	
	public static Optional<List<String>> getSourceText(NamedElement lookupContext, Mode mode) {
		return getSourceText(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<String>> getSourceText(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Source_Text";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((StringLiteral) resolved1).getValue();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSourceText_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Source_Text";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<SupportedSourceLanguages>> getSupportedSourceLanguage(NamedElement lookupContext) {
		return getSupportedSourceLanguage(lookupContext, Optional.empty());
	}
	
	public static Optional<List<SupportedSourceLanguages>> getSupportedSourceLanguage(NamedElement lookupContext, Mode mode) {
		return getSupportedSourceLanguage(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<SupportedSourceLanguages>> getSupportedSourceLanguage(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Supported_Source_Language";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return SupportedSourceLanguages.valueOf(resolved1);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSupportedSourceLanguage_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Supported_Source_Language";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<String> getTypeSourceName(NamedElement lookupContext) {
		return getTypeSourceName(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getTypeSourceName(NamedElement lookupContext, Mode mode) {
		return getTypeSourceName(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getTypeSourceName(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Type_Source_Name";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getTypeSourceName_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Type_Source_Name";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<String>> getHardwareDescriptionSourceText(NamedElement lookupContext) {
		return getHardwareDescriptionSourceText(lookupContext, Optional.empty());
	}
	
	public static Optional<List<String>> getHardwareDescriptionSourceText(NamedElement lookupContext, Mode mode) {
		return getHardwareDescriptionSourceText(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<String>> getHardwareDescriptionSourceText(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Hardware_Description_Source_Text";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((StringLiteral) resolved1).getValue();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getHardwareDescriptionSourceText_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Hardware_Description_Source_Text";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<SupportedHardwareSourceLanguages> getHardwareSourceLanguage(NamedElement lookupContext) {
		return getHardwareSourceLanguage(lookupContext, Optional.empty());
	}
	
	public static Optional<SupportedHardwareSourceLanguages> getHardwareSourceLanguage(NamedElement lookupContext, Mode mode) {
		return getHardwareSourceLanguage(lookupContext, Optional.of(mode));
	}
	
	public static Optional<SupportedHardwareSourceLanguages> getHardwareSourceLanguage(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Hardware_Source_Language";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(SupportedHardwareSourceLanguages.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getHardwareSourceLanguage_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Hardware_Source_Language";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Classifier> getDeviceDriver(NamedElement lookupContext) {
		return getDeviceDriver(lookupContext, Optional.empty());
	}
	
	public static Optional<Classifier> getDeviceDriver(NamedElement lookupContext, Mode mode) {
		return getDeviceDriver(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Classifier> getDeviceDriver(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Programming_Properties::Device_Driver";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ClassifierValue) resolved).getClassifier());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDeviceDriver_EObject(NamedElement lookupContext) {
		String name = "Programming_Properties::Device_Driver";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
}
