package org.osate.contribution.sei.sei;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
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
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.contrib.aadlproject.DataRateUnits;
import org.osate.aadl2.contrib.aadlproject.SizeUnits;
import org.osate.aadl2.contrib.aadlproject.TimeUnits;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.IntegerRangeWithUnits;
import org.osate.pluginsupport.properties.IntegerWithUnits;
import org.osate.pluginsupport.properties.RealRangeWithUnits;
import org.osate.pluginsupport.properties.RealWithUnits;

/**
 * @since 1.2
 */
public class Sei {
	public static final String SEI__NAME = "SEI";

	public static final String SECURITYLEVEL__NAME = "SecurityLevel";
	public static final String SAFETYCRITICALITY__NAME = "SafetyCriticality";
	public static final String STREAMMISSRATE__NAME = "StreamMissRate";
	public static final String NETWEIGHT__NAME = "NetWeight";
	public static final String GROSSWEIGHT__NAME = "GrossWeight";
	public static final String WEIGHTLIMIT__NAME = "WeightLimit";
	public static final String STATEREPRESENTATION__NAME = "StateRepresentation";
	public static final String PROTOCOLQOS__NAME = "ProtocolQoS";
	public static final String PARTITION_LATENCY__NAME = "Partition_Latency";
	public static final String IS_PARTITION__NAME = "Is_Partition";
	public static final String INSTRUCTIONSPERDISPATCH__NAME = "InstructionsPerDispatch";
	public static final String MIPSCAPACITY__NAME = "MIPSCapacity";
	public static final String MIPSBUDGET__NAME = "MIPSBudget";
	public static final String RAMCAPACITY__NAME = "RAMCapacity";
	public static final String RAMBUDGET__NAME = "RAMBudget";
	public static final String ROMCAPACITY__NAME = "ROMCapacity";
	public static final String ROMBUDGET__NAME = "ROMBudget";
	public static final String POWERCAPACITY__NAME = "PowerCapacity";
	public static final String POWERBUDGET__NAME = "PowerBudget";
	public static final String POWERSUPPLY__NAME = "PowerSupply";
	public static final String BANDWIDTHCAPACITY__NAME = "BandWidthCapacity";
	public static final String BANDWIDTHBUDGET__NAME = "BandWidthBudget";
	public static final String RAMACTUAL__NAME = "RAMActual";
	public static final String ROMACTUAL__NAME = "ROMActual";
	public static final String DATA_RATE__NAME = "Data_Rate";
	public static final String MESSAGE_RATE__NAME = "Message_Rate";
	public static final String NSLOC__NAME = "nsloc";
	public static final String VDID_INSPECT__NAME = "vdid_inspect";
	public static final String BROADCAST_PROTOCOL__NAME = "Broadcast_Protocol";
	public static final String PLATFORM__NAME = "Platform";
	public static final String PRICE__NAME = "Price";
	public static final String MODEL_REFERENCES__NAME = "Model_References";
	public static final String RESPONSE_TIME__NAME = "Response_Time";

	public static OptionalLong getSecuritylevel(NamedElement lookupContext) {
		return getSecuritylevel(lookupContext, Optional.empty());
	}

	public static OptionalLong getSecuritylevel(NamedElement lookupContext, Mode mode) {
		return getSecuritylevel(lookupContext, Optional.of(mode));
	}

	public static OptionalLong getSecuritylevel(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::SecurityLevel";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}

	public static PropertyExpression getSecuritylevel_EObject(NamedElement lookupContext) {
		String name = "SEI::SecurityLevel";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static OptionalLong getSafetycriticality(NamedElement lookupContext) {
		return getSafetycriticality(lookupContext, Optional.empty());
	}

	public static OptionalLong getSafetycriticality(NamedElement lookupContext, Mode mode) {
		return getSafetycriticality(lookupContext, Optional.of(mode));
	}

	public static OptionalLong getSafetycriticality(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::SafetyCriticality";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}

	public static PropertyExpression getSafetycriticality_EObject(NamedElement lookupContext) {
		String name = "SEI::SafetyCriticality";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static OptionalDouble getStreammissrate(NamedElement lookupContext) {
		return getStreammissrate(lookupContext, Optional.empty());
	}

	public static OptionalDouble getStreammissrate(NamedElement lookupContext, Mode mode) {
		return getStreammissrate(lookupContext, Optional.of(mode));
	}

	public static OptionalDouble getStreammissrate(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::StreamMissRate";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalDouble.of(((RealLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalDouble.empty();
		}
	}

	public static PropertyExpression getStreammissrate_EObject(NamedElement lookupContext) {
		String name = "SEI::StreamMissRate";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<RealWithUnits<Weightunits>> getNetweight(NamedElement lookupContext) {
		return getNetweight(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<Weightunits>> getNetweight(NamedElement lookupContext, Mode mode) {
		return getNetweight(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<Weightunits>> getNetweight(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::NetWeight";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, Weightunits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getNetweight_EObject(NamedElement lookupContext) {
		String name = "SEI::NetWeight";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<RealWithUnits<Weightunits>> getGrossweight(NamedElement lookupContext) {
		return getGrossweight(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<Weightunits>> getGrossweight(NamedElement lookupContext, Mode mode) {
		return getGrossweight(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<Weightunits>> getGrossweight(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::GrossWeight";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, Weightunits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getGrossweight_EObject(NamedElement lookupContext) {
		String name = "SEI::GrossWeight";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<RealWithUnits<Weightunits>> getWeightlimit(NamedElement lookupContext) {
		return getWeightlimit(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<Weightunits>> getWeightlimit(NamedElement lookupContext, Mode mode) {
		return getWeightlimit(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<Weightunits>> getWeightlimit(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::WeightLimit";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, Weightunits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getWeightlimit_EObject(NamedElement lookupContext) {
		String name = "SEI::WeightLimit";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<Staterepresentationtype> getStaterepresentation(NamedElement lookupContext) {
		return getStaterepresentation(lookupContext, Optional.empty());
	}

	public static Optional<Staterepresentationtype> getStaterepresentation(NamedElement lookupContext, Mode mode) {
		return getStaterepresentation(lookupContext, Optional.of(mode));
	}

	public static Optional<Staterepresentationtype> getStaterepresentation(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::StateRepresentation";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(Staterepresentationtype.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getStaterepresentation_EObject(NamedElement lookupContext) {
		String name = "SEI::StateRepresentation";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<List<Protocolqostype>> getProtocolqos(NamedElement lookupContext) {
		return getProtocolqos(lookupContext, Optional.empty());
	}

	public static Optional<List<Protocolqostype>> getProtocolqos(NamedElement lookupContext, Mode mode) {
		return getProtocolqos(lookupContext, Optional.of(mode));
	}

	public static Optional<List<Protocolqostype>> getProtocolqos(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::ProtocolQoS";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return Protocolqostype.valueOf(resolved1);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getProtocolqos_EObject(NamedElement lookupContext) {
		String name = "SEI::ProtocolQoS";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<IntegerWithUnits<TimeUnits>> getPartitionLatency(NamedElement lookupContext) {
		return getPartitionLatency(lookupContext, Optional.empty());
	}

	public static Optional<IntegerWithUnits<TimeUnits>> getPartitionLatency(NamedElement lookupContext, Mode mode) {
		return getPartitionLatency(lookupContext, Optional.of(mode));
	}

	public static Optional<IntegerWithUnits<TimeUnits>> getPartitionLatency(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::Partition_Latency";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getPartitionLatency_EObject(NamedElement lookupContext) {
		String name = "SEI::Partition_Latency";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<Boolean> getIsPartition(NamedElement lookupContext) {
		return getIsPartition(lookupContext, Optional.empty());
	}

	public static Optional<Boolean> getIsPartition(NamedElement lookupContext, Mode mode) {
		return getIsPartition(lookupContext, Optional.of(mode));
	}

	public static Optional<Boolean> getIsPartition(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::Is_Partition";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getIsPartition_EObject(NamedElement lookupContext) {
		String name = "SEI::Is_Partition";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<RealRangeWithUnits<Instructionvolumeunits>> getInstructionsperdispatch(NamedElement lookupContext) {
		return getInstructionsperdispatch(lookupContext, Optional.empty());
	}

	public static Optional<RealRangeWithUnits<Instructionvolumeunits>> getInstructionsperdispatch(NamedElement lookupContext, Mode mode) {
		return getInstructionsperdispatch(lookupContext, Optional.of(mode));
	}

	public static Optional<RealRangeWithUnits<Instructionvolumeunits>> getInstructionsperdispatch(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::InstructionsPerDispatch";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealRangeWithUnits<>(resolved, Instructionvolumeunits.class, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getInstructionsperdispatch_EObject(NamedElement lookupContext) {
		String name = "SEI::InstructionsPerDispatch";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<RealWithUnits<ProcessorSpeedUnits>> getMipscapacity(NamedElement lookupContext) {
		return getMipscapacity(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<ProcessorSpeedUnits>> getMipscapacity(NamedElement lookupContext, Mode mode) {
		return getMipscapacity(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<ProcessorSpeedUnits>> getMipscapacity(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::MIPSCapacity";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, ProcessorSpeedUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getMipscapacity_EObject(NamedElement lookupContext) {
		String name = "SEI::MIPSCapacity";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<RealWithUnits<ProcessorSpeedUnits>> getMipsbudget(NamedElement lookupContext) {
		return getMipsbudget(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<ProcessorSpeedUnits>> getMipsbudget(NamedElement lookupContext, Mode mode) {
		return getMipsbudget(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<ProcessorSpeedUnits>> getMipsbudget(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::MIPSBudget";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, ProcessorSpeedUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getMipsbudget_EObject(NamedElement lookupContext) {
		String name = "SEI::MIPSBudget";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<RealWithUnits<SizeUnits>> getRamcapacity(NamedElement lookupContext) {
		return getRamcapacity(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<SizeUnits>> getRamcapacity(NamedElement lookupContext, Mode mode) {
		return getRamcapacity(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<SizeUnits>> getRamcapacity(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::RAMCapacity";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getRamcapacity_EObject(NamedElement lookupContext) {
		String name = "SEI::RAMCapacity";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<RealWithUnits<SizeUnits>> getRambudget(NamedElement lookupContext) {
		return getRambudget(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<SizeUnits>> getRambudget(NamedElement lookupContext, Mode mode) {
		return getRambudget(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<SizeUnits>> getRambudget(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::RAMBudget";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getRambudget_EObject(NamedElement lookupContext) {
		String name = "SEI::RAMBudget";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<RealWithUnits<SizeUnits>> getRomcapacity(NamedElement lookupContext) {
		return getRomcapacity(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<SizeUnits>> getRomcapacity(NamedElement lookupContext, Mode mode) {
		return getRomcapacity(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<SizeUnits>> getRomcapacity(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::ROMCapacity";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getRomcapacity_EObject(NamedElement lookupContext) {
		String name = "SEI::ROMCapacity";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<RealWithUnits<SizeUnits>> getRombudget(NamedElement lookupContext) {
		return getRombudget(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<SizeUnits>> getRombudget(NamedElement lookupContext, Mode mode) {
		return getRombudget(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<SizeUnits>> getRombudget(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::ROMBudget";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getRombudget_EObject(NamedElement lookupContext) {
		String name = "SEI::ROMBudget";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<RealWithUnits<PowerUnits>> getPowercapacity(NamedElement lookupContext) {
		return getPowercapacity(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<PowerUnits>> getPowercapacity(NamedElement lookupContext, Mode mode) {
		return getPowercapacity(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<PowerUnits>> getPowercapacity(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::PowerCapacity";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, PowerUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getPowercapacity_EObject(NamedElement lookupContext) {
		String name = "SEI::PowerCapacity";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<RealWithUnits<PowerUnits>> getPowerbudget(NamedElement lookupContext) {
		return getPowerbudget(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<PowerUnits>> getPowerbudget(NamedElement lookupContext, Mode mode) {
		return getPowerbudget(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<PowerUnits>> getPowerbudget(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::PowerBudget";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, PowerUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getPowerbudget_EObject(NamedElement lookupContext) {
		String name = "SEI::PowerBudget";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<RealWithUnits<PowerUnits>> getPowersupply(NamedElement lookupContext) {
		return getPowersupply(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<PowerUnits>> getPowersupply(NamedElement lookupContext, Mode mode) {
		return getPowersupply(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<PowerUnits>> getPowersupply(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::PowerSupply";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, PowerUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getPowersupply_EObject(NamedElement lookupContext) {
		String name = "SEI::PowerSupply";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<RealWithUnits<DataRateUnits>> getBandwidthcapacity(NamedElement lookupContext) {
		return getBandwidthcapacity(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<DataRateUnits>> getBandwidthcapacity(NamedElement lookupContext, Mode mode) {
		return getBandwidthcapacity(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<DataRateUnits>> getBandwidthcapacity(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::BandWidthCapacity";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, DataRateUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getBandwidthcapacity_EObject(NamedElement lookupContext) {
		String name = "SEI::BandWidthCapacity";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<RealWithUnits<DataRateUnits>> getBandwidthbudget(NamedElement lookupContext) {
		return getBandwidthbudget(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<DataRateUnits>> getBandwidthbudget(NamedElement lookupContext, Mode mode) {
		return getBandwidthbudget(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<DataRateUnits>> getBandwidthbudget(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::BandWidthBudget";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, DataRateUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getBandwidthbudget_EObject(NamedElement lookupContext) {
		String name = "SEI::BandWidthBudget";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<RealWithUnits<SizeUnits>> getRamactual(NamedElement lookupContext) {
		return getRamactual(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<SizeUnits>> getRamactual(NamedElement lookupContext, Mode mode) {
		return getRamactual(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<SizeUnits>> getRamactual(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::RAMActual";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getRamactual_EObject(NamedElement lookupContext) {
		String name = "SEI::RAMActual";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<RealWithUnits<SizeUnits>> getRomactual(NamedElement lookupContext) {
		return getRomactual(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<SizeUnits>> getRomactual(NamedElement lookupContext, Mode mode) {
		return getRomactual(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<SizeUnits>> getRomactual(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::ROMActual";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getRomactual_EObject(NamedElement lookupContext) {
		String name = "SEI::ROMActual";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<RealWithUnits<DataRate>> getDataRate(NamedElement lookupContext) {
		return getDataRate(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<DataRate>> getDataRate(NamedElement lookupContext, Mode mode) {
		return getDataRate(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<DataRate>> getDataRate(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::Data_Rate";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, DataRate.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getDataRate_EObject(NamedElement lookupContext) {
		String name = "SEI::Data_Rate";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<RealWithUnits<MessageRate>> getMessageRate(NamedElement lookupContext) {
		return getMessageRate(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<MessageRate>> getMessageRate(NamedElement lookupContext, Mode mode) {
		return getMessageRate(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<MessageRate>> getMessageRate(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::Message_Rate";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, MessageRate.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getMessageRate_EObject(NamedElement lookupContext) {
		String name = "SEI::Message_Rate";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static OptionalLong getNsloc(NamedElement lookupContext) {
		return getNsloc(lookupContext, Optional.empty());
	}

	public static OptionalLong getNsloc(NamedElement lookupContext, Mode mode) {
		return getNsloc(lookupContext, Optional.of(mode));
	}

	public static OptionalLong getNsloc(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::nsloc";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}

	public static PropertyExpression getNsloc_EObject(NamedElement lookupContext) {
		String name = "SEI::nsloc";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<Boolean> getVdidInspect(NamedElement lookupContext) {
		return getVdidInspect(lookupContext, Optional.empty());
	}

	public static Optional<Boolean> getVdidInspect(NamedElement lookupContext, Mode mode) {
		return getVdidInspect(lookupContext, Optional.of(mode));
	}

	public static Optional<Boolean> getVdidInspect(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::vdid_inspect";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getVdidInspect_EObject(NamedElement lookupContext) {
		String name = "SEI::vdid_inspect";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<Boolean> getBroadcastProtocol(NamedElement lookupContext) {
		return getBroadcastProtocol(lookupContext, Optional.empty());
	}

	public static Optional<Boolean> getBroadcastProtocol(NamedElement lookupContext, Mode mode) {
		return getBroadcastProtocol(lookupContext, Optional.of(mode));
	}

	public static Optional<Boolean> getBroadcastProtocol(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::Broadcast_Protocol";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getBroadcastProtocol_EObject(NamedElement lookupContext) {
		String name = "SEI::Broadcast_Protocol";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<String> getPlatform(NamedElement lookupContext) {
		return getPlatform(lookupContext, Optional.empty());
	}

	public static Optional<String> getPlatform(NamedElement lookupContext, Mode mode) {
		return getPlatform(lookupContext, Optional.of(mode));
	}

	public static Optional<String> getPlatform(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::Platform";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getPlatform_EObject(NamedElement lookupContext) {
		String name = "SEI::Platform";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static OptionalDouble getPrice(NamedElement lookupContext) {
		return getPrice(lookupContext, Optional.empty());
	}

	public static OptionalDouble getPrice(NamedElement lookupContext, Mode mode) {
		return getPrice(lookupContext, Optional.of(mode));
	}

	public static OptionalDouble getPrice(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::Price";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalDouble.of(((RealLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalDouble.empty();
		}
	}

	public static PropertyExpression getPrice_EObject(NamedElement lookupContext) {
		String name = "SEI::Price";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<List<ModelReference>> getModelReferences(NamedElement lookupContext) {
		return getModelReferences(lookupContext, Optional.empty());
	}

	public static Optional<List<ModelReference>> getModelReferences(NamedElement lookupContext, Mode mode) {
		return getModelReferences(lookupContext, Optional.of(mode));
	}

	public static Optional<List<ModelReference>> getModelReferences(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::Model_References";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return new ModelReference(resolved1, lookupContext, mode);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getModelReferences_EObject(NamedElement lookupContext) {
		String name = "SEI::Model_References";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<IntegerRangeWithUnits<TimeUnits>> getResponseTime(NamedElement lookupContext) {
		return getResponseTime(lookupContext, Optional.empty());
	}

	public static Optional<IntegerRangeWithUnits<TimeUnits>> getResponseTime(NamedElement lookupContext, Mode mode) {
		return getResponseTime(lookupContext, Optional.of(mode));
	}

	public static Optional<IntegerRangeWithUnits<TimeUnits>> getResponseTime(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "SEI::Response_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getResponseTime_EObject(NamedElement lookupContext) {
		String name = "SEI::Response_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
}
