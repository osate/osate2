/*******************************************************************************
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party
 * beneficiaries to this license with respect to the terms applicable to their Third Party Software. Third Party
 * Software licenses only apply to the Third Party Software and not any other portion of this program or this program
 * as a whole.
 *******************************************************************************/
package org.osate.contribution.sei.arinc653;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.Collectors;

import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.contrib.aadlproject.TimeUnits;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.IntegerWithUnits;

/**
 * @since 1.2
 */
public class Arinc653 {
	public static final String ARINC653__NAME = "ARINC653";

	public static final String MODULE_MAJOR_FRAME__NAME = "Module_Major_Frame";
	public static final String SAMPLING_REFRESH_PERIOD__NAME = "Sampling_Refresh_Period";
	public static final String MEMORY_KIND__NAME = "Memory_Kind";
	public static final String TIMEOUT__NAME = "Timeout";
	public static final String DAL__NAME = "DAL";
	public static final String MODULE_VERSION__NAME = "Module_Version";
	public static final String MODULE_IDENTIFIER__NAME = "Module_Identifier";
	public static final String PARTITION_IDENTIFIER__NAME = "Partition_Identifier";
	public static final String PARTITION_NAME__NAME = "Partition_Name";
	public static final String SYSTEM_PARTITION__NAME = "System_Partition";
	public static final String ERROR_HANDLING__NAME = "Error_Handling";
	public static final String HM_ERROR_ID_LEVELS__NAME = "HM_Error_ID_Levels";
	public static final String HM_ERROR_ID_ACTIONS__NAME = "HM_Error_ID_Actions";
	public static final String STATE_INFORMATION__NAME = "State_Information";
	public static final String QUEUEING_DISCIPLINE__NAME = "Queueing_Discipline";
	public static final String MODULE_SCHEDULE__NAME = "Module_Schedule";
	public static final String TIME_CAPACITY__NAME = "Time_Capacity";
	public static final String DEADLINE_TYPE__NAME = "Deadline_Type";

	public static Optional<IntegerWithUnits<TimeUnits>> getModuleMajorFrame(NamedElement lookupContext) {
		return getModuleMajorFrame(lookupContext, Optional.empty());
	}

	public static Optional<IntegerWithUnits<TimeUnits>> getModuleMajorFrame(NamedElement lookupContext, Mode mode) {
		return getModuleMajorFrame(lookupContext, Optional.of(mode));
	}

	public static Optional<IntegerWithUnits<TimeUnits>> getModuleMajorFrame(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "ARINC653::Module_Major_Frame";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getModuleMajorFrame_EObject(NamedElement lookupContext) {
		String name = "ARINC653::Module_Major_Frame";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<IntegerWithUnits<TimeUnits>> getSamplingRefreshPeriod(NamedElement lookupContext) {
		return getSamplingRefreshPeriod(lookupContext, Optional.empty());
	}

	public static Optional<IntegerWithUnits<TimeUnits>> getSamplingRefreshPeriod(NamedElement lookupContext, Mode mode) {
		return getSamplingRefreshPeriod(lookupContext, Optional.of(mode));
	}

	public static Optional<IntegerWithUnits<TimeUnits>> getSamplingRefreshPeriod(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "ARINC653::Sampling_Refresh_Period";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getSamplingRefreshPeriod_EObject(NamedElement lookupContext) {
		String name = "ARINC653::Sampling_Refresh_Period";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<List<SupportedMemoryKind>> getMemoryKind(NamedElement lookupContext) {
		return getMemoryKind(lookupContext, Optional.empty());
	}

	public static Optional<List<SupportedMemoryKind>> getMemoryKind(NamedElement lookupContext, Mode mode) {
		return getMemoryKind(lookupContext, Optional.of(mode));
	}

	public static Optional<List<SupportedMemoryKind>> getMemoryKind(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "ARINC653::Memory_Kind";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return SupportedMemoryKind.valueOf(resolved1);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getMemoryKind_EObject(NamedElement lookupContext) {
		String name = "ARINC653::Memory_Kind";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<IntegerWithUnits<TimeUnits>> getTimeout(NamedElement lookupContext) {
		return getTimeout(lookupContext, Optional.empty());
	}

	public static Optional<IntegerWithUnits<TimeUnits>> getTimeout(NamedElement lookupContext, Mode mode) {
		return getTimeout(lookupContext, Optional.of(mode));
	}

	public static Optional<IntegerWithUnits<TimeUnits>> getTimeout(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "ARINC653::Timeout";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getTimeout_EObject(NamedElement lookupContext) {
		String name = "ARINC653::Timeout";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<SupportedDalType> getDal(NamedElement lookupContext) {
		return getDal(lookupContext, Optional.empty());
	}

	public static Optional<SupportedDalType> getDal(NamedElement lookupContext, Mode mode) {
		return getDal(lookupContext, Optional.of(mode));
	}

	public static Optional<SupportedDalType> getDal(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "ARINC653::DAL";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(SupportedDalType.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getDal_EObject(NamedElement lookupContext) {
		String name = "ARINC653::DAL";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<String> getModuleVersion(NamedElement lookupContext) {
		return getModuleVersion(lookupContext, Optional.empty());
	}

	public static Optional<String> getModuleVersion(NamedElement lookupContext, Mode mode) {
		return getModuleVersion(lookupContext, Optional.of(mode));
	}

	public static Optional<String> getModuleVersion(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "ARINC653::Module_Version";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getModuleVersion_EObject(NamedElement lookupContext) {
		String name = "ARINC653::Module_Version";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<String> getModuleIdentifier(NamedElement lookupContext) {
		return getModuleIdentifier(lookupContext, Optional.empty());
	}

	public static Optional<String> getModuleIdentifier(NamedElement lookupContext, Mode mode) {
		return getModuleIdentifier(lookupContext, Optional.of(mode));
	}

	public static Optional<String> getModuleIdentifier(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "ARINC653::Module_Identifier";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getModuleIdentifier_EObject(NamedElement lookupContext) {
		String name = "ARINC653::Module_Identifier";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static OptionalLong getPartitionIdentifier(NamedElement lookupContext) {
		return getPartitionIdentifier(lookupContext, Optional.empty());
	}

	public static OptionalLong getPartitionIdentifier(NamedElement lookupContext, Mode mode) {
		return getPartitionIdentifier(lookupContext, Optional.of(mode));
	}

	public static OptionalLong getPartitionIdentifier(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "ARINC653::Partition_Identifier";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}

	public static PropertyExpression getPartitionIdentifier_EObject(NamedElement lookupContext) {
		String name = "ARINC653::Partition_Identifier";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<String> getPartitionName(NamedElement lookupContext) {
		return getPartitionName(lookupContext, Optional.empty());
	}

	public static Optional<String> getPartitionName(NamedElement lookupContext, Mode mode) {
		return getPartitionName(lookupContext, Optional.of(mode));
	}

	public static Optional<String> getPartitionName(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "ARINC653::Partition_Name";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getPartitionName_EObject(NamedElement lookupContext) {
		String name = "ARINC653::Partition_Name";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<Boolean> getSystemPartition(NamedElement lookupContext) {
		return getSystemPartition(lookupContext, Optional.empty());
	}

	public static Optional<Boolean> getSystemPartition(NamedElement lookupContext, Mode mode) {
		return getSystemPartition(lookupContext, Optional.of(mode));
	}

	public static Optional<Boolean> getSystemPartition(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "ARINC653::System_Partition";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getSystemPartition_EObject(NamedElement lookupContext) {
		String name = "ARINC653::System_Partition";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<InstanceObject> getErrorHandling(NamedElement lookupContext) {
		return getErrorHandling(lookupContext, Optional.empty());
	}

	public static Optional<InstanceObject> getErrorHandling(NamedElement lookupContext, Mode mode) {
		return getErrorHandling(lookupContext, Optional.of(mode));
	}

	public static Optional<InstanceObject> getErrorHandling(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "ARINC653::Error_Handling";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getErrorHandling_EObject(NamedElement lookupContext) {
		String name = "ARINC653::Error_Handling";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<List<HmErrorIdLevelType>> getHmErrorIdLevels(NamedElement lookupContext) {
		return getHmErrorIdLevels(lookupContext, Optional.empty());
	}

	public static Optional<List<HmErrorIdLevelType>> getHmErrorIdLevels(NamedElement lookupContext, Mode mode) {
		return getHmErrorIdLevels(lookupContext, Optional.of(mode));
	}

	public static Optional<List<HmErrorIdLevelType>> getHmErrorIdLevels(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "ARINC653::HM_Error_ID_Levels";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return new HmErrorIdLevelType(resolved1, lookupContext, mode);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getHmErrorIdLevels_EObject(NamedElement lookupContext) {
		String name = "ARINC653::HM_Error_ID_Levels";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<List<HmErrorIdActionType>> getHmErrorIdActions(NamedElement lookupContext) {
		return getHmErrorIdActions(lookupContext, Optional.empty());
	}

	public static Optional<List<HmErrorIdActionType>> getHmErrorIdActions(NamedElement lookupContext, Mode mode) {
		return getHmErrorIdActions(lookupContext, Optional.of(mode));
	}

	public static Optional<List<HmErrorIdActionType>> getHmErrorIdActions(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "ARINC653::HM_Error_ID_Actions";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return new HmErrorIdActionType(resolved1, lookupContext, mode);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getHmErrorIdActions_EObject(NamedElement lookupContext) {
		String name = "ARINC653::HM_Error_ID_Actions";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<StateInformationType> getStateInformation(NamedElement lookupContext) {
		return getStateInformation(lookupContext, Optional.empty());
	}

	public static Optional<StateInformationType> getStateInformation(NamedElement lookupContext, Mode mode) {
		return getStateInformation(lookupContext, Optional.of(mode));
	}

	public static Optional<StateInformationType> getStateInformation(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "ARINC653::State_Information";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new StateInformationType(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getStateInformation_EObject(NamedElement lookupContext) {
		String name = "ARINC653::State_Information";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<QueueingDisciplineType> getQueueingDiscipline(NamedElement lookupContext) {
		return getQueueingDiscipline(lookupContext, Optional.empty());
	}

	public static Optional<QueueingDisciplineType> getQueueingDiscipline(NamedElement lookupContext, Mode mode) {
		return getQueueingDiscipline(lookupContext, Optional.of(mode));
	}

	public static Optional<QueueingDisciplineType> getQueueingDiscipline(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "ARINC653::Queueing_Discipline";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(QueueingDisciplineType.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getQueueingDiscipline_EObject(NamedElement lookupContext) {
		String name = "ARINC653::Queueing_Discipline";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<List<ScheduleWindow>> getModuleSchedule(NamedElement lookupContext) {
		return getModuleSchedule(lookupContext, Optional.empty());
	}

	public static Optional<List<ScheduleWindow>> getModuleSchedule(NamedElement lookupContext, Mode mode) {
		return getModuleSchedule(lookupContext, Optional.of(mode));
	}

	public static Optional<List<ScheduleWindow>> getModuleSchedule(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "ARINC653::Module_Schedule";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return new ScheduleWindow(resolved1, lookupContext, mode);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getModuleSchedule_EObject(NamedElement lookupContext) {
		String name = "ARINC653::Module_Schedule";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<IntegerWithUnits<TimeUnits>> getTimeCapacity(NamedElement lookupContext) {
		return getTimeCapacity(lookupContext, Optional.empty());
	}

	public static Optional<IntegerWithUnits<TimeUnits>> getTimeCapacity(NamedElement lookupContext, Mode mode) {
		return getTimeCapacity(lookupContext, Optional.of(mode));
	}

	public static Optional<IntegerWithUnits<TimeUnits>> getTimeCapacity(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "ARINC653::Time_Capacity";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getTimeCapacity_EObject(NamedElement lookupContext) {
		String name = "ARINC653::Time_Capacity";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<DeadlineType> getDeadlineType(NamedElement lookupContext) {
		return getDeadlineType(lookupContext, Optional.empty());
	}

	public static Optional<DeadlineType> getDeadlineType(NamedElement lookupContext, Mode mode) {
		return getDeadlineType(lookupContext, Optional.of(mode));
	}

	public static Optional<DeadlineType> getDeadlineType(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "ARINC653::Deadline_Type";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(DeadlineType.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getDeadlineType_EObject(NamedElement lookupContext) {
		String name = "ARINC653::Deadline_Type";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
}
