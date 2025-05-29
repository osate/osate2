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
package org.osate.aadl2.contrib.communication;

import java.util.List;
import java.util.Optional;
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
import org.osate.aadl2.contrib.aadlproject.DataRateUnits;
import org.osate.aadl2.contrib.aadlproject.SupportedConnectionPatterns;
import org.osate.aadl2.contrib.aadlproject.SupportedQueueProcessingProtocols;
import org.osate.aadl2.contrib.aadlproject.TimeUnits;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.IntegerRangeWithUnits;
import org.osate.pluginsupport.properties.IntegerWithUnits;

public final class CommunicationProperties {
	public static final String COMMUNICATION_PROPERTIES__NAME = "Communication_Properties";
	
	private CommunicationProperties() {}
	
	// Lookup methods for Communication_Properties::Fan_Out_Policy
	
	public static final String FAN_OUT_POLICY__NAME = "Fan_Out_Policy";
	
	public static boolean acceptsFanOutPolicy(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getFanOutPolicy_Property(lookupContext));
	}
	
	public static Optional<FanOutPolicy> getFanOutPolicy(NamedElement lookupContext) {
		return getFanOutPolicy(lookupContext, Optional.empty());
	}
	
	public static Optional<FanOutPolicy> getFanOutPolicy(NamedElement lookupContext, Mode mode) {
		return getFanOutPolicy(lookupContext, Optional.of(mode));
	}
	
	public static Optional<FanOutPolicy> getFanOutPolicy(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getFanOutPolicy_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(FanOutPolicy.valueOf(resolved));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getFanOutPolicy_Property(EObject lookupContext) {
		String name = COMMUNICATION_PROPERTIES__NAME + "::" + FAN_OUT_POLICY__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getFanOutPolicy_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getFanOutPolicy_Property(lookupContext));
	}
	
	// Lookup methods for Communication_Properties::Connection_Pattern
	
	public static final String CONNECTION_PATTERN__NAME = "Connection_Pattern";
	
	public static boolean acceptsConnectionPattern(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getConnectionPattern_Property(lookupContext));
	}
	
	public static Optional<List<List<SupportedConnectionPatterns>>> getConnectionPattern(NamedElement lookupContext) {
		return getConnectionPattern(lookupContext, Optional.empty());
	}
	
	public static Optional<List<List<SupportedConnectionPatterns>>> getConnectionPattern(NamedElement lookupContext, Mode mode) {
		return getConnectionPattern(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<List<SupportedConnectionPatterns>>> getConnectionPattern(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getConnectionPattern_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
					PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
					return SupportedConnectionPatterns.valueOf(resolved2);
				}).collect(Collectors.toList());
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getConnectionPattern_Property(EObject lookupContext) {
		String name = COMMUNICATION_PROPERTIES__NAME + "::" + CONNECTION_PATTERN__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getConnectionPattern_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getConnectionPattern_Property(lookupContext));
	}
	
	// Lookup methods for Communication_Properties::Connection_Set
	
	public static final String CONNECTION_SET__NAME = "Connection_Set";
	
	public static boolean acceptsConnectionSet(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getConnectionSet_Property(lookupContext));
	}
	
	public static Optional<List<ConnectionPair>> getConnectionSet(NamedElement lookupContext) {
		return getConnectionSet(lookupContext, Optional.empty());
	}
	
	public static Optional<List<ConnectionPair>> getConnectionSet(NamedElement lookupContext, Mode mode) {
		return getConnectionSet(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<ConnectionPair>> getConnectionSet(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getConnectionSet_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return new ConnectionPair(resolved1, lookupContext, mode);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getConnectionSet_Property(EObject lookupContext) {
		String name = COMMUNICATION_PROPERTIES__NAME + "::" + CONNECTION_SET__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getConnectionSet_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getConnectionSet_Property(lookupContext));
	}
	
	// Lookup methods for Communication_Properties::Overflow_Handling_Protocol
	
	public static final String OVERFLOW_HANDLING_PROTOCOL__NAME = "Overflow_Handling_Protocol";
	
	public static boolean acceptsOverflowHandlingProtocol(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getOverflowHandlingProtocol_Property(lookupContext));
	}
	
	public static Optional<OverflowHandlingProtocol> getOverflowHandlingProtocol(NamedElement lookupContext) {
		return getOverflowHandlingProtocol(lookupContext, Optional.empty());
	}
	
	public static Optional<OverflowHandlingProtocol> getOverflowHandlingProtocol(NamedElement lookupContext, Mode mode) {
		return getOverflowHandlingProtocol(lookupContext, Optional.of(mode));
	}
	
	public static Optional<OverflowHandlingProtocol> getOverflowHandlingProtocol(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getOverflowHandlingProtocol_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(OverflowHandlingProtocol.valueOf(resolved));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getOverflowHandlingProtocol_Property(EObject lookupContext) {
		String name = COMMUNICATION_PROPERTIES__NAME + "::" + OVERFLOW_HANDLING_PROTOCOL__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getOverflowHandlingProtocol_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getOverflowHandlingProtocol_Property(lookupContext));
	}
	
	// Lookup methods for Communication_Properties::Queue_Processing_Protocol
	
	public static final String QUEUE_PROCESSING_PROTOCOL__NAME = "Queue_Processing_Protocol";
	
	public static boolean acceptsQueueProcessingProtocol(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getQueueProcessingProtocol_Property(lookupContext));
	}
	
	public static Optional<SupportedQueueProcessingProtocols> getQueueProcessingProtocol(NamedElement lookupContext) {
		return getQueueProcessingProtocol(lookupContext, Optional.empty());
	}
	
	public static Optional<SupportedQueueProcessingProtocols> getQueueProcessingProtocol(NamedElement lookupContext, Mode mode) {
		return getQueueProcessingProtocol(lookupContext, Optional.of(mode));
	}
	
	public static Optional<SupportedQueueProcessingProtocols> getQueueProcessingProtocol(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getQueueProcessingProtocol_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(SupportedQueueProcessingProtocols.valueOf(resolved));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getQueueProcessingProtocol_Property(EObject lookupContext) {
		String name = COMMUNICATION_PROPERTIES__NAME + "::" + QUEUE_PROCESSING_PROTOCOL__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getQueueProcessingProtocol_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getQueueProcessingProtocol_Property(lookupContext));
	}
	
	// Lookup methods for Communication_Properties::Queue_Size
	
	public static final String QUEUE_SIZE__NAME = "Queue_Size";
	
	public static boolean acceptsQueueSize(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getQueueSize_Property(lookupContext));
	}
	
	public static OptionalLong getQueueSize(NamedElement lookupContext) {
		return getQueueSize(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getQueueSize(NamedElement lookupContext, Mode mode) {
		return getQueueSize(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getQueueSize(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getQueueSize_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return OptionalLong.empty();
		}
	}
	
	public static Property getQueueSize_Property(EObject lookupContext) {
		String name = COMMUNICATION_PROPERTIES__NAME + "::" + QUEUE_SIZE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getQueueSize_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getQueueSize_Property(lookupContext));
	}
	
	// Lookup methods for Communication_Properties::Required_Connection
	
	public static final String REQUIRED_CONNECTION__NAME = "Required_Connection";
	
	public static boolean acceptsRequiredConnection(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getRequiredConnection_Property(lookupContext));
	}
	
	public static Optional<Boolean> getRequiredConnection(NamedElement lookupContext) {
		return getRequiredConnection(lookupContext, Optional.empty());
	}
	
	public static Optional<Boolean> getRequiredConnection(NamedElement lookupContext, Mode mode) {
		return getRequiredConnection(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Boolean> getRequiredConnection(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getRequiredConnection_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getRequiredConnection_Property(EObject lookupContext) {
		String name = COMMUNICATION_PROPERTIES__NAME + "::" + REQUIRED_CONNECTION__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getRequiredConnection_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getRequiredConnection_Property(lookupContext));
	}
	
	// Lookup methods for Communication_Properties::Timing
	
	public static final String TIMING__NAME = "Timing";
	
	public static boolean acceptsTiming(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getTiming_Property(lookupContext));
	}
	
	public static Optional<Timing> getTiming(NamedElement lookupContext) {
		return getTiming(lookupContext, Optional.empty());
	}
	
	public static Optional<Timing> getTiming(NamedElement lookupContext, Mode mode) {
		return getTiming(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Timing> getTiming(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getTiming_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(Timing.valueOf(resolved));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getTiming_Property(EObject lookupContext) {
		String name = COMMUNICATION_PROPERTIES__NAME + "::" + TIMING__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getTiming_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getTiming_Property(lookupContext));
	}
	
	// Lookup methods for Communication_Properties::Transmission_Type
	
	public static final String TRANSMISSION_TYPE__NAME = "Transmission_Type";
	
	public static boolean acceptsTransmissionType(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getTransmissionType_Property(lookupContext));
	}
	
	public static Optional<TransmissionType> getTransmissionType(NamedElement lookupContext) {
		return getTransmissionType(lookupContext, Optional.empty());
	}
	
	public static Optional<TransmissionType> getTransmissionType(NamedElement lookupContext, Mode mode) {
		return getTransmissionType(lookupContext, Optional.of(mode));
	}
	
	public static Optional<TransmissionType> getTransmissionType(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getTransmissionType_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(TransmissionType.valueOf(resolved));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getTransmissionType_Property(EObject lookupContext) {
		String name = COMMUNICATION_PROPERTIES__NAME + "::" + TRANSMISSION_TYPE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getTransmissionType_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getTransmissionType_Property(lookupContext));
	}
	
	// Lookup methods for Communication_Properties::Input_Rate
	
	public static final String INPUT_RATE__NAME = "Input_Rate";
	
	public static boolean acceptsInputRate(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getInputRate_Property(lookupContext));
	}
	
	public static Optional<RateSpec> getInputRate(NamedElement lookupContext) {
		return getInputRate(lookupContext, Optional.empty());
	}
	
	public static Optional<RateSpec> getInputRate(NamedElement lookupContext, Mode mode) {
		return getInputRate(lookupContext, Optional.of(mode));
	}
	
	public static Optional<RateSpec> getInputRate(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getInputRate_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RateSpec(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getInputRate_Property(EObject lookupContext) {
		String name = COMMUNICATION_PROPERTIES__NAME + "::" + INPUT_RATE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getInputRate_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getInputRate_Property(lookupContext));
	}
	
	// Lookup methods for Communication_Properties::Input_Time
	
	public static final String INPUT_TIME__NAME = "Input_Time";
	
	public static boolean acceptsInputTime(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getInputTime_Property(lookupContext));
	}
	
	public static Optional<List<IoTimeSpec>> getInputTime(NamedElement lookupContext) {
		return getInputTime(lookupContext, Optional.empty());
	}
	
	public static Optional<List<IoTimeSpec>> getInputTime(NamedElement lookupContext, Mode mode) {
		return getInputTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<IoTimeSpec>> getInputTime(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getInputTime_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return new IoTimeSpec(resolved1, lookupContext, mode);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getInputTime_Property(EObject lookupContext) {
		String name = COMMUNICATION_PROPERTIES__NAME + "::" + INPUT_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getInputTime_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getInputTime_Property(lookupContext));
	}
	
	// Lookup methods for Communication_Properties::Output_Rate
	
	public static final String OUTPUT_RATE__NAME = "Output_Rate";
	
	public static boolean acceptsOutputRate(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getOutputRate_Property(lookupContext));
	}
	
	public static Optional<RateSpec> getOutputRate(NamedElement lookupContext) {
		return getOutputRate(lookupContext, Optional.empty());
	}
	
	public static Optional<RateSpec> getOutputRate(NamedElement lookupContext, Mode mode) {
		return getOutputRate(lookupContext, Optional.of(mode));
	}
	
	public static Optional<RateSpec> getOutputRate(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getOutputRate_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RateSpec(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getOutputRate_Property(EObject lookupContext) {
		String name = COMMUNICATION_PROPERTIES__NAME + "::" + OUTPUT_RATE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getOutputRate_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getOutputRate_Property(lookupContext));
	}
	
	// Lookup methods for Communication_Properties::Output_Time
	
	public static final String OUTPUT_TIME__NAME = "Output_Time";
	
	public static boolean acceptsOutputTime(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getOutputTime_Property(lookupContext));
	}
	
	public static Optional<List<IoTimeSpec>> getOutputTime(NamedElement lookupContext) {
		return getOutputTime(lookupContext, Optional.empty());
	}
	
	public static Optional<List<IoTimeSpec>> getOutputTime(NamedElement lookupContext, Mode mode) {
		return getOutputTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<IoTimeSpec>> getOutputTime(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getOutputTime_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return new IoTimeSpec(resolved1, lookupContext, mode);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getOutputTime_Property(EObject lookupContext) {
		String name = COMMUNICATION_PROPERTIES__NAME + "::" + OUTPUT_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getOutputTime_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getOutputTime_Property(lookupContext));
	}
	
	// Lookup methods for Communication_Properties::Subprogram_Call_Rate
	
	public static final String SUBPROGRAM_CALL_RATE__NAME = "Subprogram_Call_Rate";
	
	public static boolean acceptsSubprogramCallRate(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getSubprogramCallRate_Property(lookupContext));
	}
	
	public static Optional<RateSpec> getSubprogramCallRate(NamedElement lookupContext) {
		return getSubprogramCallRate(lookupContext, Optional.empty());
	}
	
	public static Optional<RateSpec> getSubprogramCallRate(NamedElement lookupContext, Mode mode) {
		return getSubprogramCallRate(lookupContext, Optional.of(mode));
	}
	
	public static Optional<RateSpec> getSubprogramCallRate(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getSubprogramCallRate_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RateSpec(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getSubprogramCallRate_Property(EObject lookupContext) {
		String name = COMMUNICATION_PROPERTIES__NAME + "::" + SUBPROGRAM_CALL_RATE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getSubprogramCallRate_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getSubprogramCallRate_Property(lookupContext));
	}
	
	// Lookup methods for Communication_Properties::Transmission_Time
	
	public static final String TRANSMISSION_TIME__NAME = "Transmission_Time";
	
	public static boolean acceptsTransmissionTime(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getTransmissionTime_Property(lookupContext));
	}
	
	public static Optional<TransmissionTime> getTransmissionTime(NamedElement lookupContext) {
		return getTransmissionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<TransmissionTime> getTransmissionTime(NamedElement lookupContext, Mode mode) {
		return getTransmissionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<TransmissionTime> getTransmissionTime(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getTransmissionTime_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new TransmissionTime(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getTransmissionTime_Property(EObject lookupContext) {
		String name = COMMUNICATION_PROPERTIES__NAME + "::" + TRANSMISSION_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getTransmissionTime_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getTransmissionTime_Property(lookupContext));
	}
	
	// Lookup methods for Communication_Properties::Actual_Latency
	
	public static final String ACTUAL_LATENCY__NAME = "Actual_Latency";
	
	public static boolean acceptsActualLatency(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getActualLatency_Property(lookupContext));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getActualLatency(NamedElement lookupContext) {
		return getActualLatency(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getActualLatency(NamedElement lookupContext, Mode mode) {
		return getActualLatency(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getActualLatency(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getActualLatency_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getActualLatency_Property(EObject lookupContext) {
		String name = COMMUNICATION_PROPERTIES__NAME + "::" + ACTUAL_LATENCY__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getActualLatency_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getActualLatency_Property(lookupContext));
	}
	
	// Lookup methods for Communication_Properties::Latency
	
	public static final String LATENCY__NAME = "Latency";
	
	public static boolean acceptsLatency(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getLatency_Property(lookupContext));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getLatency(NamedElement lookupContext) {
		return getLatency(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getLatency(NamedElement lookupContext, Mode mode) {
		return getLatency(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getLatency(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getLatency_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getLatency_Property(EObject lookupContext) {
		String name = COMMUNICATION_PROPERTIES__NAME + "::" + LATENCY__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getLatency_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getLatency_Property(lookupContext));
	}
	
	// Lookup methods for Communication_Properties::Data_Rate
	
	public static final String DATA_RATE__NAME = "Data_Rate";
	
	public static boolean acceptsDataRate(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDataRate_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<DataRateUnits>> getDataRate(NamedElement lookupContext) {
		return getDataRate(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<DataRateUnits>> getDataRate(NamedElement lookupContext, Mode mode) {
		return getDataRate(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<DataRateUnits>> getDataRate(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDataRate_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, DataRateUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getDataRate_Property(EObject lookupContext) {
		String name = COMMUNICATION_PROPERTIES__NAME + "::" + DATA_RATE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDataRate_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDataRate_Property(lookupContext));
	}
}
