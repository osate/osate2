/*******************************************************************************
 * Copyright (c) 2004-2022 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 *******************************************************************************/
package org.osate.aadl2.contrib.programming;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
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

public final class ProgrammingProperties {
	public static final String PROGRAMMING_PROPERTIES__NAME = "Programming_Properties";
	
	private ProgrammingProperties() {}
	
	// Lookup methods for Programming_Properties::Activate_Entrypoint
	
	public static final String ACTIVATE_ENTRYPOINT__NAME = "Activate_Entrypoint";
	
	public static boolean acceptsActivateEntrypoint(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getActivateEntrypoint_Property(lookupContext));
	}
	
	public static Optional<Classifier> getActivateEntrypoint(NamedElement lookupContext) {
		return getActivateEntrypoint(lookupContext, Optional.empty());
	}
	
	public static Optional<Classifier> getActivateEntrypoint(NamedElement lookupContext, Mode mode) {
		return getActivateEntrypoint(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Classifier> getActivateEntrypoint(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getActivateEntrypoint_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ClassifierValue) resolved).getClassifier());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getActivateEntrypoint_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + ACTIVATE_ENTRYPOINT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getActivateEntrypoint_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getActivateEntrypoint_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Activate_Entrypoint_Call_Sequence
	
	public static final String ACTIVATE_ENTRYPOINT_CALL_SEQUENCE__NAME = "Activate_Entrypoint_Call_Sequence";
	
	public static boolean acceptsActivateEntrypointCallSequence(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getActivateEntrypointCallSequence_Property(lookupContext));
	}
	
	public static Optional<InstanceObject> getActivateEntrypointCallSequence(NamedElement lookupContext) {
		return getActivateEntrypointCallSequence(lookupContext, Optional.empty());
	}
	
	public static Optional<InstanceObject> getActivateEntrypointCallSequence(NamedElement lookupContext, Mode mode) {
		return getActivateEntrypointCallSequence(lookupContext, Optional.of(mode));
	}
	
	public static Optional<InstanceObject> getActivateEntrypointCallSequence(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getActivateEntrypointCallSequence_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getActivateEntrypointCallSequence_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + ACTIVATE_ENTRYPOINT_CALL_SEQUENCE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getActivateEntrypointCallSequence_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getActivateEntrypointCallSequence_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Activate_Entrypoint_Source_Text
	
	public static final String ACTIVATE_ENTRYPOINT_SOURCE_TEXT__NAME = "Activate_Entrypoint_Source_Text";
	
	public static boolean acceptsActivateEntrypointSourceText(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getActivateEntrypointSourceText_Property(lookupContext));
	}
	
	public static Optional<String> getActivateEntrypointSourceText(NamedElement lookupContext) {
		return getActivateEntrypointSourceText(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getActivateEntrypointSourceText(NamedElement lookupContext, Mode mode) {
		return getActivateEntrypointSourceText(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getActivateEntrypointSourceText(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getActivateEntrypointSourceText_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getActivateEntrypointSourceText_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + ACTIVATE_ENTRYPOINT_SOURCE_TEXT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getActivateEntrypointSourceText_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getActivateEntrypointSourceText_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Compute_Entrypoint
	
	public static final String COMPUTE_ENTRYPOINT__NAME = "Compute_Entrypoint";
	
	public static boolean acceptsComputeEntrypoint(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getComputeEntrypoint_Property(lookupContext));
	}
	
	public static Optional<Classifier> getComputeEntrypoint(NamedElement lookupContext) {
		return getComputeEntrypoint(lookupContext, Optional.empty());
	}
	
	public static Optional<Classifier> getComputeEntrypoint(NamedElement lookupContext, Mode mode) {
		return getComputeEntrypoint(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Classifier> getComputeEntrypoint(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getComputeEntrypoint_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ClassifierValue) resolved).getClassifier());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getComputeEntrypoint_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + COMPUTE_ENTRYPOINT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getComputeEntrypoint_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getComputeEntrypoint_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Compute_Entrypoint_Call_Sequence
	
	public static final String COMPUTE_ENTRYPOINT_CALL_SEQUENCE__NAME = "Compute_Entrypoint_Call_Sequence";
	
	public static boolean acceptsComputeEntrypointCallSequence(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getComputeEntrypointCallSequence_Property(lookupContext));
	}
	
	public static Optional<InstanceObject> getComputeEntrypointCallSequence(NamedElement lookupContext) {
		return getComputeEntrypointCallSequence(lookupContext, Optional.empty());
	}
	
	public static Optional<InstanceObject> getComputeEntrypointCallSequence(NamedElement lookupContext, Mode mode) {
		return getComputeEntrypointCallSequence(lookupContext, Optional.of(mode));
	}
	
	public static Optional<InstanceObject> getComputeEntrypointCallSequence(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getComputeEntrypointCallSequence_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getComputeEntrypointCallSequence_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + COMPUTE_ENTRYPOINT_CALL_SEQUENCE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getComputeEntrypointCallSequence_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getComputeEntrypointCallSequence_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Compute_Entrypoint_Source_Text
	
	public static final String COMPUTE_ENTRYPOINT_SOURCE_TEXT__NAME = "Compute_Entrypoint_Source_Text";
	
	public static boolean acceptsComputeEntrypointSourceText(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getComputeEntrypointSourceText_Property(lookupContext));
	}
	
	public static Optional<String> getComputeEntrypointSourceText(NamedElement lookupContext) {
		return getComputeEntrypointSourceText(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getComputeEntrypointSourceText(NamedElement lookupContext, Mode mode) {
		return getComputeEntrypointSourceText(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getComputeEntrypointSourceText(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getComputeEntrypointSourceText_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getComputeEntrypointSourceText_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + COMPUTE_ENTRYPOINT_SOURCE_TEXT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getComputeEntrypointSourceText_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getComputeEntrypointSourceText_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Deactivate_Entrypoint
	
	public static final String DEACTIVATE_ENTRYPOINT__NAME = "Deactivate_Entrypoint";
	
	public static boolean acceptsDeactivateEntrypoint(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDeactivateEntrypoint_Property(lookupContext));
	}
	
	public static Optional<Classifier> getDeactivateEntrypoint(NamedElement lookupContext) {
		return getDeactivateEntrypoint(lookupContext, Optional.empty());
	}
	
	public static Optional<Classifier> getDeactivateEntrypoint(NamedElement lookupContext, Mode mode) {
		return getDeactivateEntrypoint(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Classifier> getDeactivateEntrypoint(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDeactivateEntrypoint_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ClassifierValue) resolved).getClassifier());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getDeactivateEntrypoint_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + DEACTIVATE_ENTRYPOINT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDeactivateEntrypoint_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDeactivateEntrypoint_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Deactivate_Entrypoint_Call_Sequence
	
	public static final String DEACTIVATE_ENTRYPOINT_CALL_SEQUENCE__NAME = "Deactivate_Entrypoint_Call_Sequence";
	
	public static boolean acceptsDeactivateEntrypointCallSequence(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDeactivateEntrypointCallSequence_Property(lookupContext));
	}
	
	public static Optional<InstanceObject> getDeactivateEntrypointCallSequence(NamedElement lookupContext) {
		return getDeactivateEntrypointCallSequence(lookupContext, Optional.empty());
	}
	
	public static Optional<InstanceObject> getDeactivateEntrypointCallSequence(NamedElement lookupContext, Mode mode) {
		return getDeactivateEntrypointCallSequence(lookupContext, Optional.of(mode));
	}
	
	public static Optional<InstanceObject> getDeactivateEntrypointCallSequence(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDeactivateEntrypointCallSequence_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getDeactivateEntrypointCallSequence_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + DEACTIVATE_ENTRYPOINT_CALL_SEQUENCE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDeactivateEntrypointCallSequence_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDeactivateEntrypointCallSequence_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Deactivate_Entrypoint_Source_Text
	
	public static final String DEACTIVATE_ENTRYPOINT_SOURCE_TEXT__NAME = "Deactivate_Entrypoint_Source_Text";
	
	public static boolean acceptsDeactivateEntrypointSourceText(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDeactivateEntrypointSourceText_Property(lookupContext));
	}
	
	public static Optional<String> getDeactivateEntrypointSourceText(NamedElement lookupContext) {
		return getDeactivateEntrypointSourceText(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getDeactivateEntrypointSourceText(NamedElement lookupContext, Mode mode) {
		return getDeactivateEntrypointSourceText(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getDeactivateEntrypointSourceText(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDeactivateEntrypointSourceText_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getDeactivateEntrypointSourceText_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + DEACTIVATE_ENTRYPOINT_SOURCE_TEXT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDeactivateEntrypointSourceText_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDeactivateEntrypointSourceText_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Finalize_Entrypoint
	
	public static final String FINALIZE_ENTRYPOINT__NAME = "Finalize_Entrypoint";
	
	public static boolean acceptsFinalizeEntrypoint(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getFinalizeEntrypoint_Property(lookupContext));
	}
	
	public static Optional<Classifier> getFinalizeEntrypoint(NamedElement lookupContext) {
		return getFinalizeEntrypoint(lookupContext, Optional.empty());
	}
	
	public static Optional<Classifier> getFinalizeEntrypoint(NamedElement lookupContext, Mode mode) {
		return getFinalizeEntrypoint(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Classifier> getFinalizeEntrypoint(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getFinalizeEntrypoint_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ClassifierValue) resolved).getClassifier());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getFinalizeEntrypoint_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + FINALIZE_ENTRYPOINT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getFinalizeEntrypoint_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getFinalizeEntrypoint_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Finalize_Entrypoint_Call_Sequence
	
	public static final String FINALIZE_ENTRYPOINT_CALL_SEQUENCE__NAME = "Finalize_Entrypoint_Call_Sequence";
	
	public static boolean acceptsFinalizeEntrypointCallSequence(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getFinalizeEntrypointCallSequence_Property(lookupContext));
	}
	
	public static Optional<InstanceObject> getFinalizeEntrypointCallSequence(NamedElement lookupContext) {
		return getFinalizeEntrypointCallSequence(lookupContext, Optional.empty());
	}
	
	public static Optional<InstanceObject> getFinalizeEntrypointCallSequence(NamedElement lookupContext, Mode mode) {
		return getFinalizeEntrypointCallSequence(lookupContext, Optional.of(mode));
	}
	
	public static Optional<InstanceObject> getFinalizeEntrypointCallSequence(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getFinalizeEntrypointCallSequence_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getFinalizeEntrypointCallSequence_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + FINALIZE_ENTRYPOINT_CALL_SEQUENCE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getFinalizeEntrypointCallSequence_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getFinalizeEntrypointCallSequence_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Finalize_Entrypoint_Source_Text
	
	public static final String FINALIZE_ENTRYPOINT_SOURCE_TEXT__NAME = "Finalize_Entrypoint_Source_Text";
	
	public static boolean acceptsFinalizeEntrypointSourceText(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getFinalizeEntrypointSourceText_Property(lookupContext));
	}
	
	public static Optional<String> getFinalizeEntrypointSourceText(NamedElement lookupContext) {
		return getFinalizeEntrypointSourceText(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getFinalizeEntrypointSourceText(NamedElement lookupContext, Mode mode) {
		return getFinalizeEntrypointSourceText(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getFinalizeEntrypointSourceText(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getFinalizeEntrypointSourceText_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getFinalizeEntrypointSourceText_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + FINALIZE_ENTRYPOINT_SOURCE_TEXT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getFinalizeEntrypointSourceText_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getFinalizeEntrypointSourceText_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Initialize_Entrypoint
	
	public static final String INITIALIZE_ENTRYPOINT__NAME = "Initialize_Entrypoint";
	
	public static boolean acceptsInitializeEntrypoint(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getInitializeEntrypoint_Property(lookupContext));
	}
	
	public static Optional<Classifier> getInitializeEntrypoint(NamedElement lookupContext) {
		return getInitializeEntrypoint(lookupContext, Optional.empty());
	}
	
	public static Optional<Classifier> getInitializeEntrypoint(NamedElement lookupContext, Mode mode) {
		return getInitializeEntrypoint(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Classifier> getInitializeEntrypoint(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getInitializeEntrypoint_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ClassifierValue) resolved).getClassifier());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getInitializeEntrypoint_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + INITIALIZE_ENTRYPOINT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getInitializeEntrypoint_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getInitializeEntrypoint_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Initialize_Entrypoint_Call_Sequence
	
	public static final String INITIALIZE_ENTRYPOINT_CALL_SEQUENCE__NAME = "Initialize_Entrypoint_Call_Sequence";
	
	public static boolean acceptsInitializeEntrypointCallSequence(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getInitializeEntrypointCallSequence_Property(lookupContext));
	}
	
	public static Optional<InstanceObject> getInitializeEntrypointCallSequence(NamedElement lookupContext) {
		return getInitializeEntrypointCallSequence(lookupContext, Optional.empty());
	}
	
	public static Optional<InstanceObject> getInitializeEntrypointCallSequence(NamedElement lookupContext, Mode mode) {
		return getInitializeEntrypointCallSequence(lookupContext, Optional.of(mode));
	}
	
	public static Optional<InstanceObject> getInitializeEntrypointCallSequence(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getInitializeEntrypointCallSequence_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getInitializeEntrypointCallSequence_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + INITIALIZE_ENTRYPOINT_CALL_SEQUENCE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getInitializeEntrypointCallSequence_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getInitializeEntrypointCallSequence_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Initialize_Entrypoint_Source_Text
	
	public static final String INITIALIZE_ENTRYPOINT_SOURCE_TEXT__NAME = "Initialize_Entrypoint_Source_Text";
	
	public static boolean acceptsInitializeEntrypointSourceText(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getInitializeEntrypointSourceText_Property(lookupContext));
	}
	
	public static Optional<String> getInitializeEntrypointSourceText(NamedElement lookupContext) {
		return getInitializeEntrypointSourceText(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getInitializeEntrypointSourceText(NamedElement lookupContext, Mode mode) {
		return getInitializeEntrypointSourceText(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getInitializeEntrypointSourceText(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getInitializeEntrypointSourceText_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getInitializeEntrypointSourceText_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + INITIALIZE_ENTRYPOINT_SOURCE_TEXT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getInitializeEntrypointSourceText_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getInitializeEntrypointSourceText_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Recover_Entrypoint
	
	public static final String RECOVER_ENTRYPOINT__NAME = "Recover_Entrypoint";
	
	public static boolean acceptsRecoverEntrypoint(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getRecoverEntrypoint_Property(lookupContext));
	}
	
	public static Optional<Classifier> getRecoverEntrypoint(NamedElement lookupContext) {
		return getRecoverEntrypoint(lookupContext, Optional.empty());
	}
	
	public static Optional<Classifier> getRecoverEntrypoint(NamedElement lookupContext, Mode mode) {
		return getRecoverEntrypoint(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Classifier> getRecoverEntrypoint(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getRecoverEntrypoint_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ClassifierValue) resolved).getClassifier());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getRecoverEntrypoint_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + RECOVER_ENTRYPOINT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getRecoverEntrypoint_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getRecoverEntrypoint_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Recover_Entrypoint_Call_Sequence
	
	public static final String RECOVER_ENTRYPOINT_CALL_SEQUENCE__NAME = "Recover_Entrypoint_Call_Sequence";
	
	public static boolean acceptsRecoverEntrypointCallSequence(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getRecoverEntrypointCallSequence_Property(lookupContext));
	}
	
	public static Optional<InstanceObject> getRecoverEntrypointCallSequence(NamedElement lookupContext) {
		return getRecoverEntrypointCallSequence(lookupContext, Optional.empty());
	}
	
	public static Optional<InstanceObject> getRecoverEntrypointCallSequence(NamedElement lookupContext, Mode mode) {
		return getRecoverEntrypointCallSequence(lookupContext, Optional.of(mode));
	}
	
	public static Optional<InstanceObject> getRecoverEntrypointCallSequence(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getRecoverEntrypointCallSequence_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getRecoverEntrypointCallSequence_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + RECOVER_ENTRYPOINT_CALL_SEQUENCE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getRecoverEntrypointCallSequence_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getRecoverEntrypointCallSequence_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Recover_Entrypoint_Source_Text
	
	public static final String RECOVER_ENTRYPOINT_SOURCE_TEXT__NAME = "Recover_Entrypoint_Source_Text";
	
	public static boolean acceptsRecoverEntrypointSourceText(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getRecoverEntrypointSourceText_Property(lookupContext));
	}
	
	public static Optional<String> getRecoverEntrypointSourceText(NamedElement lookupContext) {
		return getRecoverEntrypointSourceText(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getRecoverEntrypointSourceText(NamedElement lookupContext, Mode mode) {
		return getRecoverEntrypointSourceText(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getRecoverEntrypointSourceText(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getRecoverEntrypointSourceText_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getRecoverEntrypointSourceText_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + RECOVER_ENTRYPOINT_SOURCE_TEXT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getRecoverEntrypointSourceText_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getRecoverEntrypointSourceText_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Source_Language
	
	public static final String SOURCE_LANGUAGE__NAME = "Source_Language";
	
	public static boolean acceptsSourceLanguage(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getSourceLanguage_Property(lookupContext));
	}
	
	public static Optional<List<SupportedSourceLanguages>> getSourceLanguage(NamedElement lookupContext) {
		return getSourceLanguage(lookupContext, Optional.empty());
	}
	
	public static Optional<List<SupportedSourceLanguages>> getSourceLanguage(NamedElement lookupContext, Mode mode) {
		return getSourceLanguage(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<SupportedSourceLanguages>> getSourceLanguage(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getSourceLanguage_Property(lookupContext);
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
	
	public static Property getSourceLanguage_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + SOURCE_LANGUAGE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getSourceLanguage_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getSourceLanguage_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Source_Name
	
	public static final String SOURCE_NAME__NAME = "Source_Name";
	
	public static boolean acceptsSourceName(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getSourceName_Property(lookupContext));
	}
	
	public static Optional<String> getSourceName(NamedElement lookupContext) {
		return getSourceName(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getSourceName(NamedElement lookupContext, Mode mode) {
		return getSourceName(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getSourceName(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getSourceName_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getSourceName_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + SOURCE_NAME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getSourceName_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getSourceName_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Source_Text
	
	public static final String SOURCE_TEXT__NAME = "Source_Text";
	
	public static boolean acceptsSourceText(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getSourceText_Property(lookupContext));
	}
	
	public static Optional<List<String>> getSourceText(NamedElement lookupContext) {
		return getSourceText(lookupContext, Optional.empty());
	}
	
	public static Optional<List<String>> getSourceText(NamedElement lookupContext, Mode mode) {
		return getSourceText(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<String>> getSourceText(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getSourceText_Property(lookupContext);
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
	
	public static Property getSourceText_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + SOURCE_TEXT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getSourceText_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getSourceText_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Supported_Source_Language
	
	public static final String SUPPORTED_SOURCE_LANGUAGE__NAME = "Supported_Source_Language";
	
	public static boolean acceptsSupportedSourceLanguage(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getSupportedSourceLanguage_Property(lookupContext));
	}
	
	public static Optional<List<SupportedSourceLanguages>> getSupportedSourceLanguage(NamedElement lookupContext) {
		return getSupportedSourceLanguage(lookupContext, Optional.empty());
	}
	
	public static Optional<List<SupportedSourceLanguages>> getSupportedSourceLanguage(NamedElement lookupContext, Mode mode) {
		return getSupportedSourceLanguage(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<SupportedSourceLanguages>> getSupportedSourceLanguage(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getSupportedSourceLanguage_Property(lookupContext);
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
	
	public static Property getSupportedSourceLanguage_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + SUPPORTED_SOURCE_LANGUAGE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getSupportedSourceLanguage_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getSupportedSourceLanguage_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Type_Source_Name
	
	public static final String TYPE_SOURCE_NAME__NAME = "Type_Source_Name";
	
	public static boolean acceptsTypeSourceName(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getTypeSourceName_Property(lookupContext));
	}
	
	public static Optional<String> getTypeSourceName(NamedElement lookupContext) {
		return getTypeSourceName(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getTypeSourceName(NamedElement lookupContext, Mode mode) {
		return getTypeSourceName(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getTypeSourceName(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getTypeSourceName_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getTypeSourceName_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + TYPE_SOURCE_NAME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getTypeSourceName_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getTypeSourceName_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Hardware_Description_Source_Text
	
	public static final String HARDWARE_DESCRIPTION_SOURCE_TEXT__NAME = "Hardware_Description_Source_Text";
	
	public static boolean acceptsHardwareDescriptionSourceText(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getHardwareDescriptionSourceText_Property(lookupContext));
	}
	
	public static Optional<List<String>> getHardwareDescriptionSourceText(NamedElement lookupContext) {
		return getHardwareDescriptionSourceText(lookupContext, Optional.empty());
	}
	
	public static Optional<List<String>> getHardwareDescriptionSourceText(NamedElement lookupContext, Mode mode) {
		return getHardwareDescriptionSourceText(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<String>> getHardwareDescriptionSourceText(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getHardwareDescriptionSourceText_Property(lookupContext);
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
	
	public static Property getHardwareDescriptionSourceText_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + HARDWARE_DESCRIPTION_SOURCE_TEXT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getHardwareDescriptionSourceText_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getHardwareDescriptionSourceText_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Hardware_Source_Language
	
	public static final String HARDWARE_SOURCE_LANGUAGE__NAME = "Hardware_Source_Language";
	
	public static boolean acceptsHardwareSourceLanguage(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getHardwareSourceLanguage_Property(lookupContext));
	}
	
	public static Optional<SupportedHardwareSourceLanguages> getHardwareSourceLanguage(NamedElement lookupContext) {
		return getHardwareSourceLanguage(lookupContext, Optional.empty());
	}
	
	public static Optional<SupportedHardwareSourceLanguages> getHardwareSourceLanguage(NamedElement lookupContext, Mode mode) {
		return getHardwareSourceLanguage(lookupContext, Optional.of(mode));
	}
	
	public static Optional<SupportedHardwareSourceLanguages> getHardwareSourceLanguage(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getHardwareSourceLanguage_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(SupportedHardwareSourceLanguages.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getHardwareSourceLanguage_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + HARDWARE_SOURCE_LANGUAGE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getHardwareSourceLanguage_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getHardwareSourceLanguage_Property(lookupContext));
	}
	
	// Lookup methods for Programming_Properties::Device_Driver
	
	public static final String DEVICE_DRIVER__NAME = "Device_Driver";
	
	public static boolean acceptsDeviceDriver(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDeviceDriver_Property(lookupContext));
	}
	
	public static Optional<Classifier> getDeviceDriver(NamedElement lookupContext) {
		return getDeviceDriver(lookupContext, Optional.empty());
	}
	
	public static Optional<Classifier> getDeviceDriver(NamedElement lookupContext, Mode mode) {
		return getDeviceDriver(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Classifier> getDeviceDriver(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDeviceDriver_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ClassifierValue) resolved).getClassifier());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getDeviceDriver_Property(EObject lookupContext) {
		String name = PROGRAMMING_PROPERTIES__NAME + "::" + DEVICE_DRIVER__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDeviceDriver_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDeviceDriver_Property(lookupContext));
	}
}
