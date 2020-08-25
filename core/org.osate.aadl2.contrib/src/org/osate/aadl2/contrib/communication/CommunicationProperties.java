package org.osate.aadl2.contrib.communication;

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
import org.osate.aadl2.contrib.aadlproject.DataRateUnits;
import org.osate.aadl2.contrib.aadlproject.SupportedConnectionPatterns;
import org.osate.aadl2.contrib.aadlproject.SupportedQueueProcessingProtocols;
import org.osate.aadl2.contrib.aadlproject.TimeUnits;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.IntegerRangeWithUnits;
import org.osate.pluginsupport.properties.IntegerWithUnits;

public class CommunicationProperties {
	public static final String COMMUNICATION_PROPERTIES__NAME = "Communication_Properties";
	
	public static final String FAN_OUT_POLICY__NAME = "Fan_Out_Policy";
	public static final String CONNECTION_PATTERN__NAME = "Connection_Pattern";
	public static final String CONNECTION_SET__NAME = "Connection_Set";
	public static final String OVERFLOW_HANDLING_PROTOCOL__NAME = "Overflow_Handling_Protocol";
	public static final String QUEUE_PROCESSING_PROTOCOL__NAME = "Queue_Processing_Protocol";
	public static final String QUEUE_SIZE__NAME = "Queue_Size";
	public static final String REQUIRED_CONNECTION__NAME = "Required_Connection";
	public static final String TIMING__NAME = "Timing";
	public static final String TRANSMISSION_TYPE__NAME = "Transmission_Type";
	public static final String INPUT_RATE__NAME = "Input_Rate";
	public static final String INPUT_TIME__NAME = "Input_Time";
	public static final String OUTPUT_RATE__NAME = "Output_Rate";
	public static final String OUTPUT_TIME__NAME = "Output_Time";
	public static final String SUBPROGRAM_CALL_RATE__NAME = "Subprogram_Call_Rate";
	public static final String TRANSMISSION_TIME__NAME = "Transmission_Time";
	public static final String ACTUAL_LATENCY__NAME = "Actual_Latency";
	public static final String LATENCY__NAME = "Latency";
	public static final String DATA_RATE__NAME = "Data_Rate";
	
	public static Optional<FanOutPolicy> getFanOutPolicy(NamedElement lookupContext) {
		return getFanOutPolicy(lookupContext, Optional.empty());
	}
	
	public static Optional<FanOutPolicy> getFanOutPolicy(NamedElement lookupContext, Mode mode) {
		return getFanOutPolicy(lookupContext, Optional.of(mode));
	}
	
	public static Optional<FanOutPolicy> getFanOutPolicy(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Communication_Properties::Fan_Out_Policy";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(FanOutPolicy.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getFanOutPolicy_EObject(NamedElement lookupContext) {
		String name = "Communication_Properties::Fan_Out_Policy";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<List<SupportedConnectionPatterns>>> getConnectionPattern(NamedElement lookupContext) {
		return getConnectionPattern(lookupContext, Optional.empty());
	}
	
	public static Optional<List<List<SupportedConnectionPatterns>>> getConnectionPattern(NamedElement lookupContext, Mode mode) {
		return getConnectionPattern(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<List<SupportedConnectionPatterns>>> getConnectionPattern(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Communication_Properties::Connection_Pattern";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
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
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getConnectionPattern_EObject(NamedElement lookupContext) {
		String name = "Communication_Properties::Connection_Pattern";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<ConnectionPair>> getConnectionSet(NamedElement lookupContext) {
		return getConnectionSet(lookupContext, Optional.empty());
	}
	
	public static Optional<List<ConnectionPair>> getConnectionSet(NamedElement lookupContext, Mode mode) {
		return getConnectionSet(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<ConnectionPair>> getConnectionSet(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Communication_Properties::Connection_Set";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return new ConnectionPair(resolved1, lookupContext, mode);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getConnectionSet_EObject(NamedElement lookupContext) {
		String name = "Communication_Properties::Connection_Set";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<OverflowHandlingProtocol> getOverflowHandlingProtocol(NamedElement lookupContext) {
		return getOverflowHandlingProtocol(lookupContext, Optional.empty());
	}
	
	public static Optional<OverflowHandlingProtocol> getOverflowHandlingProtocol(NamedElement lookupContext, Mode mode) {
		return getOverflowHandlingProtocol(lookupContext, Optional.of(mode));
	}
	
	public static Optional<OverflowHandlingProtocol> getOverflowHandlingProtocol(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Communication_Properties::Overflow_Handling_Protocol";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(OverflowHandlingProtocol.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getOverflowHandlingProtocol_EObject(NamedElement lookupContext) {
		String name = "Communication_Properties::Overflow_Handling_Protocol";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<SupportedQueueProcessingProtocols> getQueueProcessingProtocol(NamedElement lookupContext) {
		return getQueueProcessingProtocol(lookupContext, Optional.empty());
	}
	
	public static Optional<SupportedQueueProcessingProtocols> getQueueProcessingProtocol(NamedElement lookupContext, Mode mode) {
		return getQueueProcessingProtocol(lookupContext, Optional.of(mode));
	}
	
	public static Optional<SupportedQueueProcessingProtocols> getQueueProcessingProtocol(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Communication_Properties::Queue_Processing_Protocol";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(SupportedQueueProcessingProtocols.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getQueueProcessingProtocol_EObject(NamedElement lookupContext) {
		String name = "Communication_Properties::Queue_Processing_Protocol";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static OptionalLong getQueueSize(NamedElement lookupContext) {
		return getQueueSize(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getQueueSize(NamedElement lookupContext, Mode mode) {
		return getQueueSize(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getQueueSize(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Communication_Properties::Queue_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}
	
	public static PropertyExpression getQueueSize_EObject(NamedElement lookupContext) {
		String name = "Communication_Properties::Queue_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Boolean> getRequiredConnection(NamedElement lookupContext) {
		return getRequiredConnection(lookupContext, Optional.empty());
	}
	
	public static Optional<Boolean> getRequiredConnection(NamedElement lookupContext, Mode mode) {
		return getRequiredConnection(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Boolean> getRequiredConnection(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Communication_Properties::Required_Connection";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getRequiredConnection_EObject(NamedElement lookupContext) {
		String name = "Communication_Properties::Required_Connection";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Timing> getTiming(NamedElement lookupContext) {
		return getTiming(lookupContext, Optional.empty());
	}
	
	public static Optional<Timing> getTiming(NamedElement lookupContext, Mode mode) {
		return getTiming(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Timing> getTiming(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Communication_Properties::Timing";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(Timing.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getTiming_EObject(NamedElement lookupContext) {
		String name = "Communication_Properties::Timing";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<TransmissionType> getTransmissionType(NamedElement lookupContext) {
		return getTransmissionType(lookupContext, Optional.empty());
	}
	
	public static Optional<TransmissionType> getTransmissionType(NamedElement lookupContext, Mode mode) {
		return getTransmissionType(lookupContext, Optional.of(mode));
	}
	
	public static Optional<TransmissionType> getTransmissionType(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Communication_Properties::Transmission_Type";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(TransmissionType.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getTransmissionType_EObject(NamedElement lookupContext) {
		String name = "Communication_Properties::Transmission_Type";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<RateSpec> getInputRate(NamedElement lookupContext) {
		return getInputRate(lookupContext, Optional.empty());
	}
	
	public static Optional<RateSpec> getInputRate(NamedElement lookupContext, Mode mode) {
		return getInputRate(lookupContext, Optional.of(mode));
	}
	
	public static Optional<RateSpec> getInputRate(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Communication_Properties::Input_Rate";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RateSpec(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getInputRate_EObject(NamedElement lookupContext) {
		String name = "Communication_Properties::Input_Rate";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<IoTimeSpec>> getInputTime(NamedElement lookupContext) {
		return getInputTime(lookupContext, Optional.empty());
	}
	
	public static Optional<List<IoTimeSpec>> getInputTime(NamedElement lookupContext, Mode mode) {
		return getInputTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<IoTimeSpec>> getInputTime(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Communication_Properties::Input_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return new IoTimeSpec(resolved1, lookupContext, mode);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getInputTime_EObject(NamedElement lookupContext) {
		String name = "Communication_Properties::Input_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<RateSpec> getOutputRate(NamedElement lookupContext) {
		return getOutputRate(lookupContext, Optional.empty());
	}
	
	public static Optional<RateSpec> getOutputRate(NamedElement lookupContext, Mode mode) {
		return getOutputRate(lookupContext, Optional.of(mode));
	}
	
	public static Optional<RateSpec> getOutputRate(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Communication_Properties::Output_Rate";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RateSpec(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getOutputRate_EObject(NamedElement lookupContext) {
		String name = "Communication_Properties::Output_Rate";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<IoTimeSpec>> getOutputTime(NamedElement lookupContext) {
		return getOutputTime(lookupContext, Optional.empty());
	}
	
	public static Optional<List<IoTimeSpec>> getOutputTime(NamedElement lookupContext, Mode mode) {
		return getOutputTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<IoTimeSpec>> getOutputTime(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Communication_Properties::Output_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return new IoTimeSpec(resolved1, lookupContext, mode);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getOutputTime_EObject(NamedElement lookupContext) {
		String name = "Communication_Properties::Output_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<RateSpec> getSubprogramCallRate(NamedElement lookupContext) {
		return getSubprogramCallRate(lookupContext, Optional.empty());
	}
	
	public static Optional<RateSpec> getSubprogramCallRate(NamedElement lookupContext, Mode mode) {
		return getSubprogramCallRate(lookupContext, Optional.of(mode));
	}
	
	public static Optional<RateSpec> getSubprogramCallRate(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Communication_Properties::Subprogram_Call_Rate";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RateSpec(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSubprogramCallRate_EObject(NamedElement lookupContext) {
		String name = "Communication_Properties::Subprogram_Call_Rate";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<TransmissionTime> getTransmissionTime(NamedElement lookupContext) {
		return getTransmissionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<TransmissionTime> getTransmissionTime(NamedElement lookupContext, Mode mode) {
		return getTransmissionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<TransmissionTime> getTransmissionTime(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Communication_Properties::Transmission_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new TransmissionTime(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getTransmissionTime_EObject(NamedElement lookupContext) {
		String name = "Communication_Properties::Transmission_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getActualLatency(NamedElement lookupContext) {
		return getActualLatency(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getActualLatency(NamedElement lookupContext, Mode mode) {
		return getActualLatency(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getActualLatency(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Communication_Properties::Actual_Latency";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getActualLatency_EObject(NamedElement lookupContext) {
		String name = "Communication_Properties::Actual_Latency";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getLatency(NamedElement lookupContext) {
		return getLatency(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getLatency(NamedElement lookupContext, Mode mode) {
		return getLatency(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getLatency(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Communication_Properties::Latency";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getLatency_EObject(NamedElement lookupContext) {
		String name = "Communication_Properties::Latency";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<DataRateUnits>> getDataRate(NamedElement lookupContext) {
		return getDataRate(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<DataRateUnits>> getDataRate(NamedElement lookupContext, Mode mode) {
		return getDataRate(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<DataRateUnits>> getDataRate(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Communication_Properties::Data_Rate";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, DataRateUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDataRate_EObject(NamedElement lookupContext) {
		String name = "Communication_Properties::Data_Rate";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
}
