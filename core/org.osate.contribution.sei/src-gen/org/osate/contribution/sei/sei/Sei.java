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
package org.osate.contribution.sei.sei;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
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
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.IntegerRangeWithUnits;
import org.osate.pluginsupport.properties.IntegerWithUnits;
import org.osate.pluginsupport.properties.RealRangeWithUnits;
import org.osate.pluginsupport.properties.RealWithUnits;

public final class Sei {
	public static final String SEI__NAME = "SEI";

	private Sei() {}

	// Lookup methods for SEI::SecurityLevel

	public static final String SECURITYLEVEL__NAME = "SecurityLevel";

	public static boolean acceptsSecuritylevel(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getSecuritylevel_Property(lookupContext));
	}

	public static OptionalLong getSecuritylevel(NamedElement lookupContext) {
		return getSecuritylevel(lookupContext, Optional.empty());
	}

	public static OptionalLong getSecuritylevel(NamedElement lookupContext, Mode mode) {
		return getSecuritylevel(lookupContext, Optional.of(mode));
	}

	public static OptionalLong getSecuritylevel(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getSecuritylevel_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return OptionalLong.empty();
		}
	}

	public static Property getSecuritylevel_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + SECURITYLEVEL__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getSecuritylevel_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getSecuritylevel_Property(lookupContext));
	}

	// Lookup methods for SEI::SafetyCriticality

	public static final String SAFETYCRITICALITY__NAME = "SafetyCriticality";

	public static boolean acceptsSafetycriticality(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getSafetycriticality_Property(lookupContext));
	}

	public static OptionalLong getSafetycriticality(NamedElement lookupContext) {
		return getSafetycriticality(lookupContext, Optional.empty());
	}

	public static OptionalLong getSafetycriticality(NamedElement lookupContext, Mode mode) {
		return getSafetycriticality(lookupContext, Optional.of(mode));
	}

	public static OptionalLong getSafetycriticality(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getSafetycriticality_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return OptionalLong.empty();
		}
	}

	public static Property getSafetycriticality_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + SAFETYCRITICALITY__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getSafetycriticality_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getSafetycriticality_Property(lookupContext));
	}

	// Lookup methods for SEI::StreamMissRate

	public static final String STREAMMISSRATE__NAME = "StreamMissRate";

	public static boolean acceptsStreammissrate(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getStreammissrate_Property(lookupContext));
	}

	public static OptionalDouble getStreammissrate(NamedElement lookupContext) {
		return getStreammissrate(lookupContext, Optional.empty());
	}

	public static OptionalDouble getStreammissrate(NamedElement lookupContext, Mode mode) {
		return getStreammissrate(lookupContext, Optional.of(mode));
	}

	public static OptionalDouble getStreammissrate(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getStreammissrate_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalDouble.of(((RealLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return OptionalDouble.empty();
		}
	}

	public static Property getStreammissrate_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + STREAMMISSRATE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getStreammissrate_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getStreammissrate_Property(lookupContext));
	}

	// Lookup methods for SEI::NetWeight

	public static final String NETWEIGHT__NAME = "NetWeight";

	public static boolean acceptsNetweight(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getNetweight_Property(lookupContext));
	}

	public static Optional<RealWithUnits<Weightunits>> getNetweight(NamedElement lookupContext) {
		return getNetweight(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<Weightunits>> getNetweight(NamedElement lookupContext, Mode mode) {
		return getNetweight(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<Weightunits>> getNetweight(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getNetweight_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, Weightunits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getNetweight_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + NETWEIGHT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getNetweight_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getNetweight_Property(lookupContext));
	}

	// Lookup methods for SEI::GrossWeight

	public static final String GROSSWEIGHT__NAME = "GrossWeight";

	public static boolean acceptsGrossweight(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getGrossweight_Property(lookupContext));
	}

	public static Optional<RealWithUnits<Weightunits>> getGrossweight(NamedElement lookupContext) {
		return getGrossweight(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<Weightunits>> getGrossweight(NamedElement lookupContext, Mode mode) {
		return getGrossweight(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<Weightunits>> getGrossweight(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getGrossweight_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, Weightunits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getGrossweight_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + GROSSWEIGHT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getGrossweight_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getGrossweight_Property(lookupContext));
	}

	// Lookup methods for SEI::WeightLimit

	public static final String WEIGHTLIMIT__NAME = "WeightLimit";

	public static boolean acceptsWeightlimit(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getWeightlimit_Property(lookupContext));
	}

	public static Optional<RealWithUnits<Weightunits>> getWeightlimit(NamedElement lookupContext) {
		return getWeightlimit(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<Weightunits>> getWeightlimit(NamedElement lookupContext, Mode mode) {
		return getWeightlimit(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<Weightunits>> getWeightlimit(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getWeightlimit_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, Weightunits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getWeightlimit_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + WEIGHTLIMIT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getWeightlimit_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getWeightlimit_Property(lookupContext));
	}

	// Lookup methods for SEI::StateRepresentation

	public static final String STATEREPRESENTATION__NAME = "StateRepresentation";

	public static boolean acceptsStaterepresentation(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getStaterepresentation_Property(lookupContext));
	}

	public static Optional<Staterepresentationtype> getStaterepresentation(NamedElement lookupContext) {
		return getStaterepresentation(lookupContext, Optional.empty());
	}

	public static Optional<Staterepresentationtype> getStaterepresentation(NamedElement lookupContext, Mode mode) {
		return getStaterepresentation(lookupContext, Optional.of(mode));
	}

	public static Optional<Staterepresentationtype> getStaterepresentation(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getStaterepresentation_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(Staterepresentationtype.valueOf(resolved));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getStaterepresentation_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + STATEREPRESENTATION__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getStaterepresentation_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getStaterepresentation_Property(lookupContext));
	}

	// Lookup methods for SEI::ProtocolQoS

	public static final String PROTOCOLQOS__NAME = "ProtocolQoS";

	public static boolean acceptsProtocolqos(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getProtocolqos_Property(lookupContext));
	}

	public static Optional<List<Protocolqostype>> getProtocolqos(NamedElement lookupContext) {
		return getProtocolqos(lookupContext, Optional.empty());
	}

	public static Optional<List<Protocolqostype>> getProtocolqos(NamedElement lookupContext, Mode mode) {
		return getProtocolqos(lookupContext, Optional.of(mode));
	}

	public static Optional<List<Protocolqostype>> getProtocolqos(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getProtocolqos_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return Protocolqostype.valueOf(resolved1);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getProtocolqos_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + PROTOCOLQOS__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getProtocolqos_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getProtocolqos_Property(lookupContext));
	}

	// Lookup methods for SEI::Partition_Latency

	public static final String PARTITION_LATENCY__NAME = "Partition_Latency";

	public static boolean acceptsPartitionLatency(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getPartitionLatency_Property(lookupContext));
	}

	public static Optional<IntegerWithUnits<TimeUnits>> getPartitionLatency(NamedElement lookupContext) {
		return getPartitionLatency(lookupContext, Optional.empty());
	}

	public static Optional<IntegerWithUnits<TimeUnits>> getPartitionLatency(NamedElement lookupContext, Mode mode) {
		return getPartitionLatency(lookupContext, Optional.of(mode));
	}

	public static Optional<IntegerWithUnits<TimeUnits>> getPartitionLatency(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getPartitionLatency_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getPartitionLatency_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + PARTITION_LATENCY__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getPartitionLatency_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getPartitionLatency_Property(lookupContext));
	}

	// Lookup methods for SEI::Is_Partition

	public static final String IS_PARTITION__NAME = "Is_Partition";

	public static boolean acceptsIsPartition(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getIsPartition_Property(lookupContext));
	}

	public static Optional<Boolean> getIsPartition(NamedElement lookupContext) {
		return getIsPartition(lookupContext, Optional.empty());
	}

	public static Optional<Boolean> getIsPartition(NamedElement lookupContext, Mode mode) {
		return getIsPartition(lookupContext, Optional.of(mode));
	}

	public static Optional<Boolean> getIsPartition(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getIsPartition_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getIsPartition_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + IS_PARTITION__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getIsPartition_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getIsPartition_Property(lookupContext));
	}

	// Lookup methods for SEI::InstructionsPerDispatch

	public static final String INSTRUCTIONSPERDISPATCH__NAME = "InstructionsPerDispatch";

	public static boolean acceptsInstructionsperdispatch(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getInstructionsperdispatch_Property(lookupContext));
	}

	public static Optional<RealRangeWithUnits<Instructionvolumeunits>> getInstructionsperdispatch(NamedElement lookupContext) {
		return getInstructionsperdispatch(lookupContext, Optional.empty());
	}

	public static Optional<RealRangeWithUnits<Instructionvolumeunits>> getInstructionsperdispatch(NamedElement lookupContext, Mode mode) {
		return getInstructionsperdispatch(lookupContext, Optional.of(mode));
	}

	public static Optional<RealRangeWithUnits<Instructionvolumeunits>> getInstructionsperdispatch(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getInstructionsperdispatch_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealRangeWithUnits<>(resolved, Instructionvolumeunits.class, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getInstructionsperdispatch_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + INSTRUCTIONSPERDISPATCH__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getInstructionsperdispatch_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getInstructionsperdispatch_Property(lookupContext));
	}

	// Lookup methods for SEI::MIPSCapacity

	public static final String MIPSCAPACITY__NAME = "MIPSCapacity";

	public static boolean acceptsMipscapacity(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getMipscapacity_Property(lookupContext));
	}

	public static Optional<RealWithUnits<ProcessorSpeedUnits>> getMipscapacity(NamedElement lookupContext) {
		return getMipscapacity(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<ProcessorSpeedUnits>> getMipscapacity(NamedElement lookupContext, Mode mode) {
		return getMipscapacity(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<ProcessorSpeedUnits>> getMipscapacity(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getMipscapacity_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, ProcessorSpeedUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getMipscapacity_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + MIPSCAPACITY__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getMipscapacity_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getMipscapacity_Property(lookupContext));
	}

	// Lookup methods for SEI::MIPSBudget

	public static final String MIPSBUDGET__NAME = "MIPSBudget";

	public static boolean acceptsMipsbudget(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getMipsbudget_Property(lookupContext));
	}

	public static Optional<RealWithUnits<ProcessorSpeedUnits>> getMipsbudget(NamedElement lookupContext) {
		return getMipsbudget(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<ProcessorSpeedUnits>> getMipsbudget(NamedElement lookupContext, Mode mode) {
		return getMipsbudget(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<ProcessorSpeedUnits>> getMipsbudget(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getMipsbudget_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, ProcessorSpeedUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getMipsbudget_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + MIPSBUDGET__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getMipsbudget_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getMipsbudget_Property(lookupContext));
	}

	// Lookup methods for SEI::RAMCapacity

	public static final String RAMCAPACITY__NAME = "RAMCapacity";

	public static boolean acceptsRamcapacity(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getRamcapacity_Property(lookupContext));
	}

	public static Optional<RealWithUnits<SizeUnits>> getRamcapacity(NamedElement lookupContext) {
		return getRamcapacity(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<SizeUnits>> getRamcapacity(NamedElement lookupContext, Mode mode) {
		return getRamcapacity(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<SizeUnits>> getRamcapacity(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getRamcapacity_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getRamcapacity_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + RAMCAPACITY__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getRamcapacity_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getRamcapacity_Property(lookupContext));
	}

	// Lookup methods for SEI::RAMBudget

	public static final String RAMBUDGET__NAME = "RAMBudget";

	public static boolean acceptsRambudget(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getRambudget_Property(lookupContext));
	}

	public static Optional<RealWithUnits<SizeUnits>> getRambudget(NamedElement lookupContext) {
		return getRambudget(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<SizeUnits>> getRambudget(NamedElement lookupContext, Mode mode) {
		return getRambudget(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<SizeUnits>> getRambudget(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getRambudget_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getRambudget_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + RAMBUDGET__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getRambudget_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getRambudget_Property(lookupContext));
	}

	// Lookup methods for SEI::ROMCapacity

	public static final String ROMCAPACITY__NAME = "ROMCapacity";

	public static boolean acceptsRomcapacity(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getRomcapacity_Property(lookupContext));
	}

	public static Optional<RealWithUnits<SizeUnits>> getRomcapacity(NamedElement lookupContext) {
		return getRomcapacity(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<SizeUnits>> getRomcapacity(NamedElement lookupContext, Mode mode) {
		return getRomcapacity(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<SizeUnits>> getRomcapacity(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getRomcapacity_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getRomcapacity_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + ROMCAPACITY__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getRomcapacity_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getRomcapacity_Property(lookupContext));
	}

	// Lookup methods for SEI::ROMBudget

	public static final String ROMBUDGET__NAME = "ROMBudget";

	public static boolean acceptsRombudget(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getRombudget_Property(lookupContext));
	}

	public static Optional<RealWithUnits<SizeUnits>> getRombudget(NamedElement lookupContext) {
		return getRombudget(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<SizeUnits>> getRombudget(NamedElement lookupContext, Mode mode) {
		return getRombudget(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<SizeUnits>> getRombudget(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getRombudget_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getRombudget_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + ROMBUDGET__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getRombudget_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getRombudget_Property(lookupContext));
	}

	// Lookup methods for SEI::PowerCapacity

	public static final String POWERCAPACITY__NAME = "PowerCapacity";

	public static boolean acceptsPowercapacity(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getPowercapacity_Property(lookupContext));
	}

	public static Optional<RealWithUnits<PowerUnits>> getPowercapacity(NamedElement lookupContext) {
		return getPowercapacity(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<PowerUnits>> getPowercapacity(NamedElement lookupContext, Mode mode) {
		return getPowercapacity(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<PowerUnits>> getPowercapacity(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getPowercapacity_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, PowerUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getPowercapacity_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + POWERCAPACITY__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getPowercapacity_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getPowercapacity_Property(lookupContext));
	}

	// Lookup methods for SEI::PowerBudget

	public static final String POWERBUDGET__NAME = "PowerBudget";

	public static boolean acceptsPowerbudget(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getPowerbudget_Property(lookupContext));
	}

	public static Optional<RealWithUnits<PowerUnits>> getPowerbudget(NamedElement lookupContext) {
		return getPowerbudget(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<PowerUnits>> getPowerbudget(NamedElement lookupContext, Mode mode) {
		return getPowerbudget(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<PowerUnits>> getPowerbudget(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getPowerbudget_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, PowerUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getPowerbudget_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + POWERBUDGET__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getPowerbudget_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getPowerbudget_Property(lookupContext));
	}

	// Lookup methods for SEI::PowerSupply

	public static final String POWERSUPPLY__NAME = "PowerSupply";

	public static boolean acceptsPowersupply(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getPowersupply_Property(lookupContext));
	}

	public static Optional<RealWithUnits<PowerUnits>> getPowersupply(NamedElement lookupContext) {
		return getPowersupply(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<PowerUnits>> getPowersupply(NamedElement lookupContext, Mode mode) {
		return getPowersupply(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<PowerUnits>> getPowersupply(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getPowersupply_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, PowerUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getPowersupply_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + POWERSUPPLY__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getPowersupply_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getPowersupply_Property(lookupContext));
	}

	// Lookup methods for SEI::BandWidthCapacity

	public static final String BANDWIDTHCAPACITY__NAME = "BandWidthCapacity";

	public static boolean acceptsBandwidthcapacity(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getBandwidthcapacity_Property(lookupContext));
	}

	public static Optional<RealWithUnits<DataRateUnits>> getBandwidthcapacity(NamedElement lookupContext) {
		return getBandwidthcapacity(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<DataRateUnits>> getBandwidthcapacity(NamedElement lookupContext, Mode mode) {
		return getBandwidthcapacity(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<DataRateUnits>> getBandwidthcapacity(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getBandwidthcapacity_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, DataRateUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getBandwidthcapacity_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + BANDWIDTHCAPACITY__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getBandwidthcapacity_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getBandwidthcapacity_Property(lookupContext));
	}

	// Lookup methods for SEI::BandWidthBudget

	public static final String BANDWIDTHBUDGET__NAME = "BandWidthBudget";

	public static boolean acceptsBandwidthbudget(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getBandwidthbudget_Property(lookupContext));
	}

	public static Optional<RealWithUnits<DataRateUnits>> getBandwidthbudget(NamedElement lookupContext) {
		return getBandwidthbudget(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<DataRateUnits>> getBandwidthbudget(NamedElement lookupContext, Mode mode) {
		return getBandwidthbudget(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<DataRateUnits>> getBandwidthbudget(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getBandwidthbudget_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, DataRateUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getBandwidthbudget_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + BANDWIDTHBUDGET__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getBandwidthbudget_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getBandwidthbudget_Property(lookupContext));
	}

	// Lookup methods for SEI::RAMActual

	public static final String RAMACTUAL__NAME = "RAMActual";

	public static boolean acceptsRamactual(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getRamactual_Property(lookupContext));
	}

	public static Optional<RealWithUnits<SizeUnits>> getRamactual(NamedElement lookupContext) {
		return getRamactual(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<SizeUnits>> getRamactual(NamedElement lookupContext, Mode mode) {
		return getRamactual(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<SizeUnits>> getRamactual(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getRamactual_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getRamactual_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + RAMACTUAL__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getRamactual_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getRamactual_Property(lookupContext));
	}

	// Lookup methods for SEI::ROMActual

	public static final String ROMACTUAL__NAME = "ROMActual";

	public static boolean acceptsRomactual(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getRomactual_Property(lookupContext));
	}

	public static Optional<RealWithUnits<SizeUnits>> getRomactual(NamedElement lookupContext) {
		return getRomactual(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<SizeUnits>> getRomactual(NamedElement lookupContext, Mode mode) {
		return getRomactual(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<SizeUnits>> getRomactual(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getRomactual_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getRomactual_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + ROMACTUAL__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getRomactual_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getRomactual_Property(lookupContext));
	}

	// Lookup methods for SEI::Data_Rate

	public static final String DATA_RATE__NAME = "Data_Rate";

	public static boolean acceptsDataRate(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDataRate_Property(lookupContext));
	}

	public static Optional<RealWithUnits<DataRate>> getDataRate(NamedElement lookupContext) {
		return getDataRate(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<DataRate>> getDataRate(NamedElement lookupContext, Mode mode) {
		return getDataRate(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<DataRate>> getDataRate(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDataRate_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, DataRate.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getDataRate_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + DATA_RATE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getDataRate_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDataRate_Property(lookupContext));
	}

	// Lookup methods for SEI::Message_Rate

	public static final String MESSAGE_RATE__NAME = "Message_Rate";

	public static boolean acceptsMessageRate(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getMessageRate_Property(lookupContext));
	}

	public static Optional<RealWithUnits<MessageRate>> getMessageRate(NamedElement lookupContext) {
		return getMessageRate(lookupContext, Optional.empty());
	}

	public static Optional<RealWithUnits<MessageRate>> getMessageRate(NamedElement lookupContext, Mode mode) {
		return getMessageRate(lookupContext, Optional.of(mode));
	}

	public static Optional<RealWithUnits<MessageRate>> getMessageRate(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getMessageRate_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, MessageRate.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getMessageRate_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + MESSAGE_RATE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getMessageRate_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getMessageRate_Property(lookupContext));
	}

	// Lookup methods for SEI::nsloc

	public static final String NSLOC__NAME = "nsloc";

	public static boolean acceptsNsloc(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getNsloc_Property(lookupContext));
	}

	public static OptionalLong getNsloc(NamedElement lookupContext) {
		return getNsloc(lookupContext, Optional.empty());
	}

	public static OptionalLong getNsloc(NamedElement lookupContext, Mode mode) {
		return getNsloc(lookupContext, Optional.of(mode));
	}

	public static OptionalLong getNsloc(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getNsloc_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return OptionalLong.empty();
		}
	}

	public static Property getNsloc_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + NSLOC__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getNsloc_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getNsloc_Property(lookupContext));
	}

	// Lookup methods for SEI::vdid_inspect

	public static final String VDID_INSPECT__NAME = "vdid_inspect";

	public static boolean acceptsVdidInspect(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getVdidInspect_Property(lookupContext));
	}

	public static Optional<Boolean> getVdidInspect(NamedElement lookupContext) {
		return getVdidInspect(lookupContext, Optional.empty());
	}

	public static Optional<Boolean> getVdidInspect(NamedElement lookupContext, Mode mode) {
		return getVdidInspect(lookupContext, Optional.of(mode));
	}

	public static Optional<Boolean> getVdidInspect(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getVdidInspect_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getVdidInspect_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + VDID_INSPECT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getVdidInspect_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getVdidInspect_Property(lookupContext));
	}

	// Lookup methods for SEI::Broadcast_Protocol

	public static final String BROADCAST_PROTOCOL__NAME = "Broadcast_Protocol";

	public static boolean acceptsBroadcastProtocol(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getBroadcastProtocol_Property(lookupContext));
	}

	public static Optional<Boolean> getBroadcastProtocol(NamedElement lookupContext) {
		return getBroadcastProtocol(lookupContext, Optional.empty());
	}

	public static Optional<Boolean> getBroadcastProtocol(NamedElement lookupContext, Mode mode) {
		return getBroadcastProtocol(lookupContext, Optional.of(mode));
	}

	public static Optional<Boolean> getBroadcastProtocol(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getBroadcastProtocol_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getBroadcastProtocol_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + BROADCAST_PROTOCOL__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getBroadcastProtocol_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getBroadcastProtocol_Property(lookupContext));
	}

	// Lookup methods for SEI::Platform

	public static final String PLATFORM__NAME = "Platform";

	public static boolean acceptsPlatform(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getPlatform_Property(lookupContext));
	}

	public static Optional<String> getPlatform(NamedElement lookupContext) {
		return getPlatform(lookupContext, Optional.empty());
	}

	public static Optional<String> getPlatform(NamedElement lookupContext, Mode mode) {
		return getPlatform(lookupContext, Optional.of(mode));
	}

	public static Optional<String> getPlatform(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getPlatform_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getPlatform_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + PLATFORM__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getPlatform_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getPlatform_Property(lookupContext));
	}

	// Lookup methods for SEI::Price

	public static final String PRICE__NAME = "Price";

	public static boolean acceptsPrice(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getPrice_Property(lookupContext));
	}

	public static OptionalDouble getPrice(NamedElement lookupContext) {
		return getPrice(lookupContext, Optional.empty());
	}

	public static OptionalDouble getPrice(NamedElement lookupContext, Mode mode) {
		return getPrice(lookupContext, Optional.of(mode));
	}

	public static OptionalDouble getPrice(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getPrice_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalDouble.of(((RealLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return OptionalDouble.empty();
		}
	}

	public static Property getPrice_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + PRICE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getPrice_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getPrice_Property(lookupContext));
	}

	// Lookup methods for SEI::Model_References

	public static final String MODEL_REFERENCES__NAME = "Model_References";

	public static boolean acceptsModelReferences(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getModelReferences_Property(lookupContext));
	}

	public static Optional<List<ModelReference>> getModelReferences(NamedElement lookupContext) {
		return getModelReferences(lookupContext, Optional.empty());
	}

	public static Optional<List<ModelReference>> getModelReferences(NamedElement lookupContext, Mode mode) {
		return getModelReferences(lookupContext, Optional.of(mode));
	}

	public static Optional<List<ModelReference>> getModelReferences(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getModelReferences_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return new ModelReference(resolved1, lookupContext, mode);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getModelReferences_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + MODEL_REFERENCES__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getModelReferences_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getModelReferences_Property(lookupContext));
	}

	// Lookup methods for SEI::Response_Time

	public static final String RESPONSE_TIME__NAME = "Response_Time";

	public static boolean acceptsResponseTime(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getResponseTime_Property(lookupContext));
	}

	public static Optional<IntegerRangeWithUnits<TimeUnits>> getResponseTime(NamedElement lookupContext) {
		return getResponseTime(lookupContext, Optional.empty());
	}

	public static Optional<IntegerRangeWithUnits<TimeUnits>> getResponseTime(NamedElement lookupContext, Mode mode) {
		return getResponseTime(lookupContext, Optional.of(mode));
	}

	public static Optional<IntegerRangeWithUnits<TimeUnits>> getResponseTime(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getResponseTime_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getResponseTime_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + RESPONSE_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getResponseTime_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getResponseTime_Property(lookupContext));
	}

	// Lookup methods for SEI::Mode_Domain

	/**
	 * @since 2.2
	 */
	public static final String MODE_DOMAIN__NAME = "Mode_Domain";

	/**
	 * @since 2.2
	 */
	public static boolean acceptsModeDomain(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getModeDomain_Property(lookupContext));
	}

	/**
	 * @since 2.2
	 */
	public static Optional<Boolean> getModeDomain(NamedElement lookupContext) {
		return getModeDomain(lookupContext, Optional.empty());
	}

	/**
	 * @since 2.2
	 */
	public static Optional<Boolean> getModeDomain(NamedElement lookupContext, Mode mode) {
		return getModeDomain(lookupContext, Optional.of(mode));
	}

	/**
	 * @since 2.2
	 */
	public static Optional<Boolean> getModeDomain(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getModeDomain_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	/**
	 * @since 2.2
	 */
	public static Property getModeDomain_Property(EObject lookupContext) {
		String name = SEI__NAME + "::" + MODE_DOMAIN__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	/**
	 * @since 2.2
	 */
	public static PropertyExpression getModeDomain_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getModeDomain_Property(lookupContext));
	}
}
