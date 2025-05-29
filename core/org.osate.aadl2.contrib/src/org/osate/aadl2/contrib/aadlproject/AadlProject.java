/*******************************************************************************
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.aadl2.contrib.aadlproject;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.IntegerWithUnits;

public final class AadlProject {
	public static final String AADL_PROJECT__NAME = "AADL_Project";
	
	private AadlProject() {}
	
	// Lookup methods for AADL_Project::Supported_Classifier_Equivalence_Matches
	
	public static final String SUPPORTED_CLASSIFIER_EQUIVALENCE_MATCHES__NAME = "Supported_Classifier_Equivalence_Matches";
	
	public static List<List<Classifier>> getSupportedClassifierEquivalenceMatches(EObject lookupContext) {
		PropertyConstant constant = getSupportedClassifierEquivalenceMatches_PropertyConstant(lookupContext);
		PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
		return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
			PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
			return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2);
				return ((ClassifierValue) resolved2).getClassifier();
			}).collect(Collectors.toList());
		}).collect(Collectors.toList());
	}
	
	public static PropertyConstant getSupportedClassifierEquivalenceMatches_PropertyConstant(EObject lookupContext) {
		String name = AADL_PROJECT__NAME + "::" + SUPPORTED_CLASSIFIER_EQUIVALENCE_MATCHES__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
	}
	
	// Lookup methods for AADL_Project::Supported_Classifier_Subset_Matches
	
	public static final String SUPPORTED_CLASSIFIER_SUBSET_MATCHES__NAME = "Supported_Classifier_Subset_Matches";
	
	public static List<List<Classifier>> getSupportedClassifierSubsetMatches(EObject lookupContext) {
		PropertyConstant constant = getSupportedClassifierSubsetMatches_PropertyConstant(lookupContext);
		PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
		return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
			PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
			return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2);
				return ((ClassifierValue) resolved2).getClassifier();
			}).collect(Collectors.toList());
		}).collect(Collectors.toList());
	}
	
	public static PropertyConstant getSupportedClassifierSubsetMatches_PropertyConstant(EObject lookupContext) {
		String name = AADL_PROJECT__NAME + "::" + SUPPORTED_CLASSIFIER_SUBSET_MATCHES__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
	}
	
	// Lookup methods for AADL_Project::Supported_Type_Conversions
	
	public static final String SUPPORTED_TYPE_CONVERSIONS__NAME = "Supported_Type_Conversions";
	
	public static List<List<Classifier>> getSupportedTypeConversions(EObject lookupContext) {
		PropertyConstant constant = getSupportedTypeConversions_PropertyConstant(lookupContext);
		PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
		return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
			PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
			return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2);
				return ((ClassifierValue) resolved2).getClassifier();
			}).collect(Collectors.toList());
		}).collect(Collectors.toList());
	}
	
	public static PropertyConstant getSupportedTypeConversions_PropertyConstant(EObject lookupContext) {
		String name = AADL_PROJECT__NAME + "::" + SUPPORTED_TYPE_CONVERSIONS__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
	}
	
	// Lookup methods for AADL_Project::Supported_Classifier_Complement_Matches
	
	public static final String SUPPORTED_CLASSIFIER_COMPLEMENT_MATCHES__NAME = "Supported_Classifier_Complement_Matches";
	
	public static List<List<Classifier>> getSupportedClassifierComplementMatches(EObject lookupContext) {
		PropertyConstant constant = getSupportedClassifierComplementMatches_PropertyConstant(lookupContext);
		PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
		return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
			PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
			return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2);
				return ((ClassifierValue) resolved2).getClassifier();
			}).collect(Collectors.toList());
		}).collect(Collectors.toList());
	}
	
	public static PropertyConstant getSupportedClassifierComplementMatches_PropertyConstant(EObject lookupContext) {
		String name = AADL_PROJECT__NAME + "::" + SUPPORTED_CLASSIFIER_COMPLEMENT_MATCHES__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
	}
	
	// Lookup methods for AADL_Project::Max_Aadlinteger
	
	public static final String MAX_AADLINTEGER__NAME = "Max_Aadlinteger";
	
	public static long getMaxAadlinteger(EObject lookupContext) {
		PropertyConstant constant = getMaxAadlinteger_PropertyConstant(lookupContext);
		PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
		return ((IntegerLiteral) resolved).getValue();
	}
	
	public static PropertyConstant getMaxAadlinteger_PropertyConstant(EObject lookupContext) {
		String name = AADL_PROJECT__NAME + "::" + MAX_AADLINTEGER__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
	}
	
	// Lookup methods for AADL_Project::Max_Target_Integer
	
	public static final String MAX_TARGET_INTEGER__NAME = "Max_Target_Integer";
	
	public static long getMaxTargetInteger(EObject lookupContext) {
		PropertyConstant constant = getMaxTargetInteger_PropertyConstant(lookupContext);
		PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
		return ((IntegerLiteral) resolved).getValue();
	}
	
	public static PropertyConstant getMaxTargetInteger_PropertyConstant(EObject lookupContext) {
		String name = AADL_PROJECT__NAME + "::" + MAX_TARGET_INTEGER__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
	}
	
	// Lookup methods for AADL_Project::Max_Base_Address
	
	public static final String MAX_BASE_ADDRESS__NAME = "Max_Base_Address";
	
	public static long getMaxBaseAddress(EObject lookupContext) {
		PropertyConstant constant = getMaxBaseAddress_PropertyConstant(lookupContext);
		PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
		return ((IntegerLiteral) resolved).getValue();
	}
	
	public static PropertyConstant getMaxBaseAddress_PropertyConstant(EObject lookupContext) {
		String name = AADL_PROJECT__NAME + "::" + MAX_BASE_ADDRESS__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
	}
	
	// Lookup methods for AADL_Project::Max_Memory_Size
	
	public static final String MAX_MEMORY_SIZE__NAME = "Max_Memory_Size";
	
	public static IntegerWithUnits<SizeUnits> getMaxMemorySize(EObject lookupContext) {
		PropertyConstant constant = getMaxMemorySize_PropertyConstant(lookupContext);
		PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
		return new IntegerWithUnits<>(resolved, SizeUnits.class);
	}
	
	public static PropertyConstant getMaxMemorySize_PropertyConstant(EObject lookupContext) {
		String name = AADL_PROJECT__NAME + "::" + MAX_MEMORY_SIZE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
	}
	
	// Lookup methods for AADL_Project::Max_Queue_Size
	
	public static final String MAX_QUEUE_SIZE__NAME = "Max_Queue_Size";
	
	public static long getMaxQueueSize(EObject lookupContext) {
		PropertyConstant constant = getMaxQueueSize_PropertyConstant(lookupContext);
		PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
		return ((IntegerLiteral) resolved).getValue();
	}
	
	public static PropertyConstant getMaxQueueSize_PropertyConstant(EObject lookupContext) {
		String name = AADL_PROJECT__NAME + "::" + MAX_QUEUE_SIZE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
	}
	
	// Lookup methods for AADL_Project::Max_Thread_Limit
	
	public static final String MAX_THREAD_LIMIT__NAME = "Max_Thread_Limit";
	
	public static long getMaxThreadLimit(EObject lookupContext) {
		PropertyConstant constant = getMaxThreadLimit_PropertyConstant(lookupContext);
		PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
		return ((IntegerLiteral) resolved).getValue();
	}
	
	public static PropertyConstant getMaxThreadLimit_PropertyConstant(EObject lookupContext) {
		String name = AADL_PROJECT__NAME + "::" + MAX_THREAD_LIMIT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
	}
	
	// Lookup methods for AADL_Project::Max_Time
	
	public static final String MAX_TIME__NAME = "Max_Time";
	
	public static IntegerWithUnits<TimeUnits> getMaxTime(EObject lookupContext) {
		PropertyConstant constant = getMaxTime_PropertyConstant(lookupContext);
		PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
		return new IntegerWithUnits<>(resolved, TimeUnits.class);
	}
	
	public static PropertyConstant getMaxTime_PropertyConstant(EObject lookupContext) {
		String name = AADL_PROJECT__NAME + "::" + MAX_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
	}
	
	// Lookup methods for AADL_Project::Max_Urgency
	
	public static final String MAX_URGENCY__NAME = "Max_Urgency";
	
	public static long getMaxUrgency(EObject lookupContext) {
		PropertyConstant constant = getMaxUrgency_PropertyConstant(lookupContext);
		PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
		return ((IntegerLiteral) resolved).getValue();
	}
	
	public static PropertyConstant getMaxUrgency_PropertyConstant(EObject lookupContext) {
		String name = AADL_PROJECT__NAME + "::" + MAX_URGENCY__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
	}
	
	// Lookup methods for AADL_Project::Max_Word_Space
	
	public static final String MAX_WORD_SPACE__NAME = "Max_Word_Space";
	
	public static long getMaxWordSpace(EObject lookupContext) {
		PropertyConstant constant = getMaxWordSpace_PropertyConstant(lookupContext);
		PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
		return ((IntegerLiteral) resolved).getValue();
	}
	
	public static PropertyConstant getMaxWordSpace_PropertyConstant(EObject lookupContext) {
		String name = AADL_PROJECT__NAME + "::" + MAX_WORD_SPACE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
	}
	
	// Lookup methods for AADL_Project::Max_Byte_Count
	
	public static final String MAX_BYTE_COUNT__NAME = "Max_Byte_Count";
	
	public static long getMaxByteCount(EObject lookupContext) {
		PropertyConstant constant = getMaxByteCount_PropertyConstant(lookupContext);
		PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
		return ((IntegerLiteral) resolved).getValue();
	}
	
	public static PropertyConstant getMaxByteCount_PropertyConstant(EObject lookupContext) {
		String name = AADL_PROJECT__NAME + "::" + MAX_BYTE_COUNT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
	}
	
	// Lookup methods for AADL_Project::Max_Volume
	
	public static final String MAX_VOLUME__NAME = "Max_Volume";
	
	public static IntegerWithUnits<DataVolumeUnits> getMaxVolume(EObject lookupContext) {
		PropertyConstant constant = getMaxVolume_PropertyConstant(lookupContext);
		PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
		return new IntegerWithUnits<>(resolved, DataVolumeUnits.class);
	}
	
	public static PropertyConstant getMaxVolume_PropertyConstant(EObject lookupContext) {
		String name = AADL_PROJECT__NAME + "::" + MAX_VOLUME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
	}
}
