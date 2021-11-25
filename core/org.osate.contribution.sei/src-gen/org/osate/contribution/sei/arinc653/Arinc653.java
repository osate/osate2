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

public final class Arinc653 {
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
	
	private Arinc653() {}
	
	// Lookup methods for ARINC653::Module_Major_Frame
	
	public static boolean acceptsModuleMajorFrame(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getModuleMajorFrame_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getModuleMajorFrame(NamedElement lookupContext) {
		return getModuleMajorFrame(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getModuleMajorFrame(NamedElement lookupContext, Mode mode) {
		return getModuleMajorFrame(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getModuleMajorFrame(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getModuleMajorFrame_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getModuleMajorFrame_Property(NamedElement lookupContext) {
		String name = ARINC653__NAME + "::" + MODULE_MAJOR_FRAME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getModuleMajorFrame_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getModuleMajorFrame_Property(lookupContext));
	}
	
	// Lookup methods for ARINC653::Sampling_Refresh_Period
	
	public static boolean acceptsSamplingRefreshPeriod(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getSamplingRefreshPeriod_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getSamplingRefreshPeriod(NamedElement lookupContext) {
		return getSamplingRefreshPeriod(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getSamplingRefreshPeriod(NamedElement lookupContext, Mode mode) {
		return getSamplingRefreshPeriod(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getSamplingRefreshPeriod(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getSamplingRefreshPeriod_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getSamplingRefreshPeriod_Property(NamedElement lookupContext) {
		String name = ARINC653__NAME + "::" + SAMPLING_REFRESH_PERIOD__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getSamplingRefreshPeriod_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getSamplingRefreshPeriod_Property(lookupContext));
	}
	
	// Lookup methods for ARINC653::Memory_Kind
	
	public static boolean acceptsMemoryKind(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getMemoryKind_Property(lookupContext));
	}
	
	public static Optional<List<SupportedMemoryKind>> getMemoryKind(NamedElement lookupContext) {
		return getMemoryKind(lookupContext, Optional.empty());
	}
	
	public static Optional<List<SupportedMemoryKind>> getMemoryKind(NamedElement lookupContext, Mode mode) {
		return getMemoryKind(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<SupportedMemoryKind>> getMemoryKind(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getMemoryKind_Property(lookupContext);
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
	
	public static Property getMemoryKind_Property(NamedElement lookupContext) {
		String name = ARINC653__NAME + "::" + MEMORY_KIND__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getMemoryKind_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getMemoryKind_Property(lookupContext));
	}
	
	// Lookup methods for ARINC653::Timeout
	
	public static boolean acceptsTimeout(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getTimeout_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getTimeout(NamedElement lookupContext) {
		return getTimeout(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getTimeout(NamedElement lookupContext, Mode mode) {
		return getTimeout(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getTimeout(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getTimeout_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getTimeout_Property(NamedElement lookupContext) {
		String name = ARINC653__NAME + "::" + TIMEOUT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getTimeout_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getTimeout_Property(lookupContext));
	}
	
	// Lookup methods for ARINC653::DAL
	
	public static boolean acceptsDal(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDal_Property(lookupContext));
	}
	
	public static Optional<SupportedDalType> getDal(NamedElement lookupContext) {
		return getDal(lookupContext, Optional.empty());
	}
	
	public static Optional<SupportedDalType> getDal(NamedElement lookupContext, Mode mode) {
		return getDal(lookupContext, Optional.of(mode));
	}
	
	public static Optional<SupportedDalType> getDal(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDal_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(SupportedDalType.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getDal_Property(NamedElement lookupContext) {
		String name = ARINC653__NAME + "::" + DAL__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDal_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDal_Property(lookupContext));
	}
	
	// Lookup methods for ARINC653::Module_Version
	
	public static boolean acceptsModuleVersion(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getModuleVersion_Property(lookupContext));
	}
	
	public static Optional<String> getModuleVersion(NamedElement lookupContext) {
		return getModuleVersion(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getModuleVersion(NamedElement lookupContext, Mode mode) {
		return getModuleVersion(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getModuleVersion(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getModuleVersion_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getModuleVersion_Property(NamedElement lookupContext) {
		String name = ARINC653__NAME + "::" + MODULE_VERSION__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getModuleVersion_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getModuleVersion_Property(lookupContext));
	}
	
	// Lookup methods for ARINC653::Module_Identifier
	
	public static boolean acceptsModuleIdentifier(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getModuleIdentifier_Property(lookupContext));
	}
	
	public static Optional<String> getModuleIdentifier(NamedElement lookupContext) {
		return getModuleIdentifier(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getModuleIdentifier(NamedElement lookupContext, Mode mode) {
		return getModuleIdentifier(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getModuleIdentifier(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getModuleIdentifier_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getModuleIdentifier_Property(NamedElement lookupContext) {
		String name = ARINC653__NAME + "::" + MODULE_IDENTIFIER__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getModuleIdentifier_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getModuleIdentifier_Property(lookupContext));
	}
	
	// Lookup methods for ARINC653::Partition_Identifier
	
	public static boolean acceptsPartitionIdentifier(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getPartitionIdentifier_Property(lookupContext));
	}
	
	public static OptionalLong getPartitionIdentifier(NamedElement lookupContext) {
		return getPartitionIdentifier(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getPartitionIdentifier(NamedElement lookupContext, Mode mode) {
		return getPartitionIdentifier(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getPartitionIdentifier(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getPartitionIdentifier_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}
	
	public static Property getPartitionIdentifier_Property(NamedElement lookupContext) {
		String name = ARINC653__NAME + "::" + PARTITION_IDENTIFIER__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getPartitionIdentifier_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getPartitionIdentifier_Property(lookupContext));
	}
	
	// Lookup methods for ARINC653::Partition_Name
	
	public static boolean acceptsPartitionName(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getPartitionName_Property(lookupContext));
	}
	
	public static Optional<String> getPartitionName(NamedElement lookupContext) {
		return getPartitionName(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getPartitionName(NamedElement lookupContext, Mode mode) {
		return getPartitionName(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getPartitionName(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getPartitionName_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getPartitionName_Property(NamedElement lookupContext) {
		String name = ARINC653__NAME + "::" + PARTITION_NAME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getPartitionName_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getPartitionName_Property(lookupContext));
	}
	
	// Lookup methods for ARINC653::System_Partition
	
	public static boolean acceptsSystemPartition(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getSystemPartition_Property(lookupContext));
	}
	
	public static Optional<Boolean> getSystemPartition(NamedElement lookupContext) {
		return getSystemPartition(lookupContext, Optional.empty());
	}
	
	public static Optional<Boolean> getSystemPartition(NamedElement lookupContext, Mode mode) {
		return getSystemPartition(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Boolean> getSystemPartition(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getSystemPartition_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getSystemPartition_Property(NamedElement lookupContext) {
		String name = ARINC653__NAME + "::" + SYSTEM_PARTITION__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getSystemPartition_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getSystemPartition_Property(lookupContext));
	}
	
	// Lookup methods for ARINC653::Error_Handling
	
	public static boolean acceptsErrorHandling(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getErrorHandling_Property(lookupContext));
	}
	
	public static Optional<InstanceObject> getErrorHandling(NamedElement lookupContext) {
		return getErrorHandling(lookupContext, Optional.empty());
	}
	
	public static Optional<InstanceObject> getErrorHandling(NamedElement lookupContext, Mode mode) {
		return getErrorHandling(lookupContext, Optional.of(mode));
	}
	
	public static Optional<InstanceObject> getErrorHandling(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getErrorHandling_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getErrorHandling_Property(NamedElement lookupContext) {
		String name = ARINC653__NAME + "::" + ERROR_HANDLING__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getErrorHandling_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getErrorHandling_Property(lookupContext));
	}
	
	// Lookup methods for ARINC653::HM_Error_ID_Levels
	
	public static boolean acceptsHmErrorIdLevels(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getHmErrorIdLevels_Property(lookupContext));
	}
	
	public static Optional<List<HmErrorIdLevelType>> getHmErrorIdLevels(NamedElement lookupContext) {
		return getHmErrorIdLevels(lookupContext, Optional.empty());
	}
	
	public static Optional<List<HmErrorIdLevelType>> getHmErrorIdLevels(NamedElement lookupContext, Mode mode) {
		return getHmErrorIdLevels(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<HmErrorIdLevelType>> getHmErrorIdLevels(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getHmErrorIdLevels_Property(lookupContext);
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
	
	public static Property getHmErrorIdLevels_Property(NamedElement lookupContext) {
		String name = ARINC653__NAME + "::" + HM_ERROR_ID_LEVELS__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getHmErrorIdLevels_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getHmErrorIdLevels_Property(lookupContext));
	}
	
	// Lookup methods for ARINC653::HM_Error_ID_Actions
	
	public static boolean acceptsHmErrorIdActions(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getHmErrorIdActions_Property(lookupContext));
	}
	
	public static Optional<List<HmErrorIdActionType>> getHmErrorIdActions(NamedElement lookupContext) {
		return getHmErrorIdActions(lookupContext, Optional.empty());
	}
	
	public static Optional<List<HmErrorIdActionType>> getHmErrorIdActions(NamedElement lookupContext, Mode mode) {
		return getHmErrorIdActions(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<HmErrorIdActionType>> getHmErrorIdActions(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getHmErrorIdActions_Property(lookupContext);
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
	
	public static Property getHmErrorIdActions_Property(NamedElement lookupContext) {
		String name = ARINC653__NAME + "::" + HM_ERROR_ID_ACTIONS__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getHmErrorIdActions_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getHmErrorIdActions_Property(lookupContext));
	}
	
	// Lookup methods for ARINC653::State_Information
	
	public static boolean acceptsStateInformation(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getStateInformation_Property(lookupContext));
	}
	
	public static Optional<StateInformationType> getStateInformation(NamedElement lookupContext) {
		return getStateInformation(lookupContext, Optional.empty());
	}
	
	public static Optional<StateInformationType> getStateInformation(NamedElement lookupContext, Mode mode) {
		return getStateInformation(lookupContext, Optional.of(mode));
	}
	
	public static Optional<StateInformationType> getStateInformation(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getStateInformation_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new StateInformationType(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getStateInformation_Property(NamedElement lookupContext) {
		String name = ARINC653__NAME + "::" + STATE_INFORMATION__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getStateInformation_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getStateInformation_Property(lookupContext));
	}
	
	// Lookup methods for ARINC653::Queueing_Discipline
	
	public static boolean acceptsQueueingDiscipline(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getQueueingDiscipline_Property(lookupContext));
	}
	
	public static Optional<QueueingDisciplineType> getQueueingDiscipline(NamedElement lookupContext) {
		return getQueueingDiscipline(lookupContext, Optional.empty());
	}
	
	public static Optional<QueueingDisciplineType> getQueueingDiscipline(NamedElement lookupContext, Mode mode) {
		return getQueueingDiscipline(lookupContext, Optional.of(mode));
	}
	
	public static Optional<QueueingDisciplineType> getQueueingDiscipline(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getQueueingDiscipline_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(QueueingDisciplineType.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getQueueingDiscipline_Property(NamedElement lookupContext) {
		String name = ARINC653__NAME + "::" + QUEUEING_DISCIPLINE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getQueueingDiscipline_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getQueueingDiscipline_Property(lookupContext));
	}
	
	// Lookup methods for ARINC653::Module_Schedule
	
	public static boolean acceptsModuleSchedule(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getModuleSchedule_Property(lookupContext));
	}
	
	public static Optional<List<ScheduleWindow>> getModuleSchedule(NamedElement lookupContext) {
		return getModuleSchedule(lookupContext, Optional.empty());
	}
	
	public static Optional<List<ScheduleWindow>> getModuleSchedule(NamedElement lookupContext, Mode mode) {
		return getModuleSchedule(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<ScheduleWindow>> getModuleSchedule(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getModuleSchedule_Property(lookupContext);
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
	
	public static Property getModuleSchedule_Property(NamedElement lookupContext) {
		String name = ARINC653__NAME + "::" + MODULE_SCHEDULE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getModuleSchedule_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getModuleSchedule_Property(lookupContext));
	}
	
	// Lookup methods for ARINC653::Time_Capacity
	
	public static boolean acceptsTimeCapacity(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getTimeCapacity_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getTimeCapacity(NamedElement lookupContext) {
		return getTimeCapacity(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getTimeCapacity(NamedElement lookupContext, Mode mode) {
		return getTimeCapacity(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getTimeCapacity(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getTimeCapacity_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getTimeCapacity_Property(NamedElement lookupContext) {
		String name = ARINC653__NAME + "::" + TIME_CAPACITY__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getTimeCapacity_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getTimeCapacity_Property(lookupContext));
	}
	
	// Lookup methods for ARINC653::Deadline_Type
	
	public static boolean acceptsDeadlineType(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDeadlineType_Property(lookupContext));
	}
	
	public static Optional<DeadlineType> getDeadlineType(NamedElement lookupContext) {
		return getDeadlineType(lookupContext, Optional.empty());
	}
	
	public static Optional<DeadlineType> getDeadlineType(NamedElement lookupContext, Mode mode) {
		return getDeadlineType(lookupContext, Optional.of(mode));
	}
	
	public static Optional<DeadlineType> getDeadlineType(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDeadlineType_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(DeadlineType.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getDeadlineType_Property(NamedElement lookupContext) {
		String name = ARINC653__NAME + "::" + DEADLINE_TYPE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDeadlineType_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDeadlineType_Property(lookupContext));
	}
}
