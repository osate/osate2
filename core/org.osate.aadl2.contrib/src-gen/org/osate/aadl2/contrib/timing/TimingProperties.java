package org.osate.aadl2.contrib.timing;

import java.util.Optional;

import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.contrib.aadlproject.ProcessorSpeedUnits;
import org.osate.aadl2.contrib.aadlproject.TimeUnits;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.IntegerRangeWithUnits;
import org.osate.pluginsupport.properties.IntegerWithUnits;
import org.osate.pluginsupport.properties.RealWithUnits;

public class TimingProperties {
	public static final String TIMING_PROPERTIES__NAME = "Timing_Properties";
	
	public static final String ACTIVATE_DEADLINE__NAME = "Activate_Deadline";
	public static final String ACTIVATE_EXECUTION_TIME__NAME = "Activate_Execution_Time";
	public static final String COMPUTE_DEADLINE__NAME = "Compute_Deadline";
	public static final String COMPUTE_EXECUTION_TIME__NAME = "Compute_Execution_Time";
	public static final String CLIENT_SUBPROGRAM_EXECUTION_TIME__NAME = "Client_Subprogram_Execution_Time";
	public static final String DEACTIVATE_DEADLINE__NAME = "Deactivate_Deadline";
	public static final String DEACTIVATE_EXECUTION_TIME__NAME = "Deactivate_Execution_Time";
	public static final String DEADLINE__NAME = "Deadline";
	public static final String FIRST_DISPATCH_TIME__NAME = "First_Dispatch_Time";
	public static final String DISPATCH_JITTER__NAME = "Dispatch_Jitter";
	public static final String DISPATCH_OFFSET__NAME = "Dispatch_Offset";
	public static final String EXECUTION_TIME__NAME = "Execution_Time";
	public static final String FINALIZE_DEADLINE__NAME = "Finalize_Deadline";
	public static final String FINALIZE_EXECUTION_TIME__NAME = "Finalize_Execution_Time";
	public static final String INITIALIZE_DEADLINE__NAME = "Initialize_Deadline";
	public static final String INITIALIZE_EXECUTION_TIME__NAME = "Initialize_Execution_Time";
	public static final String LOAD_DEADLINE__NAME = "Load_Deadline";
	public static final String LOAD_TIME__NAME = "Load_Time";
	public static final String PROCESSOR_CAPACITY__NAME = "Processor_Capacity";
	public static final String PERIOD__NAME = "Period";
	public static final String RECOVER_DEADLINE__NAME = "Recover_Deadline";
	public static final String RECOVER_EXECUTION_TIME__NAME = "Recover_Execution_Time";
	public static final String REFERENCE_TIME__NAME = "Reference_Time";
	public static final String STARTUP_DEADLINE__NAME = "Startup_Deadline";
	public static final String STARTUP_EXECUTION_TIME__NAME = "Startup_Execution_Time";
	public static final String CLOCK_JITTER__NAME = "Clock_Jitter";
	public static final String CLOCK_PERIOD__NAME = "Clock_Period";
	public static final String CLOCK_PERIOD_RANGE__NAME = "Clock_Period_Range";
	public static final String PROCESS_SWAP_EXECUTION_TIME__NAME = "Process_Swap_Execution_Time";
	public static final String REFERENCE_PROCESSOR__NAME = "Reference_Processor";
	public static final String SCHEDULER_QUANTUM__NAME = "Scheduler_Quantum";
	public static final String THREAD_SWAP_EXECUTION_TIME__NAME = "Thread_Swap_Execution_Time";
	public static final String FRAME_PERIOD__NAME = "Frame_Period";
	public static final String SLOT_TIME__NAME = "Slot_Time";
	
	public static Optional<IntegerWithUnits<TimeUnits>> getActivateDeadline(NamedElement lookupContext) {
		return getActivateDeadline(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getActivateDeadline(NamedElement lookupContext, Mode mode) {
		return getActivateDeadline(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getActivateDeadline(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Activate_Deadline";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getActivateDeadline_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Activate_Deadline";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getActivateExecutionTime(NamedElement lookupContext) {
		return getActivateExecutionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getActivateExecutionTime(NamedElement lookupContext, Mode mode) {
		return getActivateExecutionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getActivateExecutionTime(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Activate_Execution_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getActivateExecutionTime_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Activate_Execution_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getComputeDeadline(NamedElement lookupContext) {
		return getComputeDeadline(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getComputeDeadline(NamedElement lookupContext, Mode mode) {
		return getComputeDeadline(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getComputeDeadline(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Compute_Deadline";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getComputeDeadline_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Compute_Deadline";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getComputeExecutionTime(NamedElement lookupContext) {
		return getComputeExecutionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getComputeExecutionTime(NamedElement lookupContext, Mode mode) {
		return getComputeExecutionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getComputeExecutionTime(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Compute_Execution_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getComputeExecutionTime_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Compute_Execution_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getClientSubprogramExecutionTime(NamedElement lookupContext) {
		return getClientSubprogramExecutionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getClientSubprogramExecutionTime(NamedElement lookupContext, Mode mode) {
		return getClientSubprogramExecutionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getClientSubprogramExecutionTime(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Client_Subprogram_Execution_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getClientSubprogramExecutionTime_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Client_Subprogram_Execution_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDeactivateDeadline(NamedElement lookupContext) {
		return getDeactivateDeadline(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDeactivateDeadline(NamedElement lookupContext, Mode mode) {
		return getDeactivateDeadline(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDeactivateDeadline(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Deactivate_Deadline";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDeactivateDeadline_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Deactivate_Deadline";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getDeactivateExecutionTime(NamedElement lookupContext) {
		return getDeactivateExecutionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getDeactivateExecutionTime(NamedElement lookupContext, Mode mode) {
		return getDeactivateExecutionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getDeactivateExecutionTime(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Deactivate_Execution_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDeactivateExecutionTime_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Deactivate_Execution_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDeadline(NamedElement lookupContext) {
		return getDeadline(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDeadline(NamedElement lookupContext, Mode mode) {
		return getDeadline(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDeadline(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Deadline";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDeadline_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Deadline";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getFirstDispatchTime(NamedElement lookupContext) {
		return getFirstDispatchTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getFirstDispatchTime(NamedElement lookupContext, Mode mode) {
		return getFirstDispatchTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getFirstDispatchTime(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::First_Dispatch_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getFirstDispatchTime_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::First_Dispatch_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDispatchJitter(NamedElement lookupContext) {
		return getDispatchJitter(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDispatchJitter(NamedElement lookupContext, Mode mode) {
		return getDispatchJitter(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDispatchJitter(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Dispatch_Jitter";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDispatchJitter_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Dispatch_Jitter";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDispatchOffset(NamedElement lookupContext) {
		return getDispatchOffset(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDispatchOffset(NamedElement lookupContext, Mode mode) {
		return getDispatchOffset(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDispatchOffset(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Dispatch_Offset";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDispatchOffset_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Dispatch_Offset";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getExecutionTime(NamedElement lookupContext) {
		return getExecutionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getExecutionTime(NamedElement lookupContext, Mode mode) {
		return getExecutionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getExecutionTime(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Execution_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getExecutionTime_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Execution_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getFinalizeDeadline(NamedElement lookupContext) {
		return getFinalizeDeadline(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getFinalizeDeadline(NamedElement lookupContext, Mode mode) {
		return getFinalizeDeadline(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getFinalizeDeadline(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Finalize_Deadline";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getFinalizeDeadline_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Finalize_Deadline";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getFinalizeExecutionTime(NamedElement lookupContext) {
		return getFinalizeExecutionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getFinalizeExecutionTime(NamedElement lookupContext, Mode mode) {
		return getFinalizeExecutionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getFinalizeExecutionTime(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Finalize_Execution_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getFinalizeExecutionTime_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Finalize_Execution_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getInitializeDeadline(NamedElement lookupContext) {
		return getInitializeDeadline(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getInitializeDeadline(NamedElement lookupContext, Mode mode) {
		return getInitializeDeadline(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getInitializeDeadline(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Initialize_Deadline";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getInitializeDeadline_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Initialize_Deadline";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getInitializeExecutionTime(NamedElement lookupContext) {
		return getInitializeExecutionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getInitializeExecutionTime(NamedElement lookupContext, Mode mode) {
		return getInitializeExecutionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getInitializeExecutionTime(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Initialize_Execution_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getInitializeExecutionTime_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Initialize_Execution_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getLoadDeadline(NamedElement lookupContext) {
		return getLoadDeadline(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getLoadDeadline(NamedElement lookupContext, Mode mode) {
		return getLoadDeadline(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getLoadDeadline(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Load_Deadline";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getLoadDeadline_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Load_Deadline";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getLoadTime(NamedElement lookupContext) {
		return getLoadTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getLoadTime(NamedElement lookupContext, Mode mode) {
		return getLoadTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getLoadTime(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Load_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getLoadTime_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Load_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<RealWithUnits<ProcessorSpeedUnits>> getProcessorCapacity(NamedElement lookupContext) {
		return getProcessorCapacity(lookupContext, Optional.empty());
	}
	
	public static Optional<RealWithUnits<ProcessorSpeedUnits>> getProcessorCapacity(NamedElement lookupContext, Mode mode) {
		return getProcessorCapacity(lookupContext, Optional.of(mode));
	}
	
	public static Optional<RealWithUnits<ProcessorSpeedUnits>> getProcessorCapacity(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Processor_Capacity";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, ProcessorSpeedUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getProcessorCapacity_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Processor_Capacity";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getPeriod(NamedElement lookupContext) {
		return getPeriod(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getPeriod(NamedElement lookupContext, Mode mode) {
		return getPeriod(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getPeriod(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Period";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getPeriod_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Period";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getRecoverDeadline(NamedElement lookupContext) {
		return getRecoverDeadline(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getRecoverDeadline(NamedElement lookupContext, Mode mode) {
		return getRecoverDeadline(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getRecoverDeadline(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Recover_Deadline";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getRecoverDeadline_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Recover_Deadline";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getRecoverExecutionTime(NamedElement lookupContext) {
		return getRecoverExecutionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getRecoverExecutionTime(NamedElement lookupContext, Mode mode) {
		return getRecoverExecutionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getRecoverExecutionTime(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Recover_Execution_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getRecoverExecutionTime_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Recover_Execution_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<InstanceObject> getReferenceTime(NamedElement lookupContext) {
		return getReferenceTime(lookupContext, Optional.empty());
	}
	
	public static Optional<InstanceObject> getReferenceTime(NamedElement lookupContext, Mode mode) {
		return getReferenceTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<InstanceObject> getReferenceTime(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Reference_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getReferenceTime_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Reference_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getStartupDeadline(NamedElement lookupContext) {
		return getStartupDeadline(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getStartupDeadline(NamedElement lookupContext, Mode mode) {
		return getStartupDeadline(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getStartupDeadline(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Startup_Deadline";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getStartupDeadline_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Startup_Deadline";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getStartupExecutionTime(NamedElement lookupContext) {
		return getStartupExecutionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getStartupExecutionTime(NamedElement lookupContext, Mode mode) {
		return getStartupExecutionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getStartupExecutionTime(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Startup_Execution_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getStartupExecutionTime_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Startup_Execution_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getClockJitter(NamedElement lookupContext) {
		return getClockJitter(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getClockJitter(NamedElement lookupContext, Mode mode) {
		return getClockJitter(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getClockJitter(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Clock_Jitter";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getClockJitter_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Clock_Jitter";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getClockPeriod(NamedElement lookupContext) {
		return getClockPeriod(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getClockPeriod(NamedElement lookupContext, Mode mode) {
		return getClockPeriod(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getClockPeriod(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Clock_Period";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getClockPeriod_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Clock_Period";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getClockPeriodRange(NamedElement lookupContext) {
		return getClockPeriodRange(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getClockPeriodRange(NamedElement lookupContext, Mode mode) {
		return getClockPeriodRange(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getClockPeriodRange(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Clock_Period_Range";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getClockPeriodRange_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Clock_Period_Range";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getProcessSwapExecutionTime(NamedElement lookupContext) {
		return getProcessSwapExecutionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getProcessSwapExecutionTime(NamedElement lookupContext, Mode mode) {
		return getProcessSwapExecutionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getProcessSwapExecutionTime(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Process_Swap_Execution_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getProcessSwapExecutionTime_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Process_Swap_Execution_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Classifier> getReferenceProcessor(NamedElement lookupContext) {
		return getReferenceProcessor(lookupContext, Optional.empty());
	}
	
	public static Optional<Classifier> getReferenceProcessor(NamedElement lookupContext, Mode mode) {
		return getReferenceProcessor(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Classifier> getReferenceProcessor(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Reference_Processor";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ClassifierValue) resolved).getClassifier());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getReferenceProcessor_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Reference_Processor";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getSchedulerQuantum(NamedElement lookupContext) {
		return getSchedulerQuantum(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getSchedulerQuantum(NamedElement lookupContext, Mode mode) {
		return getSchedulerQuantum(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getSchedulerQuantum(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Scheduler_Quantum";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSchedulerQuantum_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Scheduler_Quantum";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getThreadSwapExecutionTime(NamedElement lookupContext) {
		return getThreadSwapExecutionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getThreadSwapExecutionTime(NamedElement lookupContext, Mode mode) {
		return getThreadSwapExecutionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getThreadSwapExecutionTime(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Thread_Swap_Execution_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getThreadSwapExecutionTime_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Thread_Swap_Execution_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getFramePeriod(NamedElement lookupContext) {
		return getFramePeriod(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getFramePeriod(NamedElement lookupContext, Mode mode) {
		return getFramePeriod(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getFramePeriod(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Frame_Period";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getFramePeriod_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Frame_Period";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getSlotTime(NamedElement lookupContext) {
		return getSlotTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getSlotTime(NamedElement lookupContext, Mode mode) {
		return getSlotTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getSlotTime(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Timing_Properties::Slot_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSlotTime_EObject(NamedElement lookupContext) {
		String name = "Timing_Properties::Slot_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
}
