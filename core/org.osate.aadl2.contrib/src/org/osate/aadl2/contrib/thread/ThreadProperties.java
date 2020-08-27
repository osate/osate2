package org.osate.aadl2.contrib.thread;

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
import org.osate.aadl2.contrib.aadlproject.SupportedActiveThreadHandlingProtocols;
import org.osate.aadl2.contrib.aadlproject.SupportedConcurrencyControlProtocols;
import org.osate.aadl2.contrib.aadlproject.SupportedDispatchProtocols;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;

public class ThreadProperties {
	public static final String THREAD_PROPERTIES__NAME = "Thread_Properties";
	
	public static final String DISPATCH_PROTOCOL__NAME = "Dispatch_Protocol";
	public static final String DISPATCH_TRIGGER__NAME = "Dispatch_Trigger";
	public static final String DISPATCH_ABLE__NAME = "Dispatch_Able";
	public static final String POSIX_SCHEDULING_POLICY__NAME = "POSIX_Scheduling_Policy";
	public static final String PRIORITY__NAME = "Priority";
	public static final String CRITICALITY__NAME = "Criticality";
	public static final String TIME_SLOT__NAME = "Time_Slot";
	public static final String CONCURRENCY_CONTROL_PROTOCOL__NAME = "Concurrency_Control_Protocol";
	public static final String URGENCY__NAME = "Urgency";
	public static final String DEQUEUE_PROTOCOL__NAME = "Dequeue_Protocol";
	public static final String DEQUEUED_ITEMS__NAME = "Dequeued_Items";
	public static final String MODE_TRANSITION_RESPONSE__NAME = "Mode_Transition_Response";
	public static final String RESUMPTION_POLICY__NAME = "Resumption_Policy";
	public static final String ACTIVE_THREAD_HANDLING_PROTOCOL__NAME = "Active_Thread_Handling_Protocol";
	public static final String ACTIVE_THREAD_QUEUE_HANDLING_PROTOCOL__NAME = "Active_Thread_Queue_Handling_Protocol";
	public static final String DEACTIVATION_POLICY__NAME = "Deactivation_Policy";
	public static final String RUNTIME_PROTECTION__NAME = "Runtime_Protection";
	public static final String SUBPROGRAM_CALL_TYPE__NAME = "Subprogram_Call_Type";
	public static final String SYNCHRONIZED_COMPONENT__NAME = "Synchronized_Component";
	
	public static Optional<SupportedDispatchProtocols> getDispatchProtocol(NamedElement lookupContext) {
		return getDispatchProtocol(lookupContext, Optional.empty());
	}
	
	public static Optional<SupportedDispatchProtocols> getDispatchProtocol(NamedElement lookupContext, Mode mode) {
		return getDispatchProtocol(lookupContext, Optional.of(mode));
	}
	
	public static Optional<SupportedDispatchProtocols> getDispatchProtocol(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Thread_Properties::Dispatch_Protocol";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(SupportedDispatchProtocols.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDispatchProtocol_EObject(NamedElement lookupContext) {
		String name = "Thread_Properties::Dispatch_Protocol";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<InstanceObject>> getDispatchTrigger(NamedElement lookupContext) {
		return getDispatchTrigger(lookupContext, Optional.empty());
	}
	
	public static Optional<List<InstanceObject>> getDispatchTrigger(NamedElement lookupContext, Mode mode) {
		return getDispatchTrigger(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<InstanceObject>> getDispatchTrigger(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Thread_Properties::Dispatch_Trigger";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((InstanceReferenceValue) resolved1).getReferencedInstanceObject();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDispatchTrigger_EObject(NamedElement lookupContext) {
		String name = "Thread_Properties::Dispatch_Trigger";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Boolean> getDispatchAble(NamedElement lookupContext) {
		return getDispatchAble(lookupContext, Optional.empty());
	}
	
	public static Optional<Boolean> getDispatchAble(NamedElement lookupContext, Mode mode) {
		return getDispatchAble(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Boolean> getDispatchAble(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Thread_Properties::Dispatch_Able";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDispatchAble_EObject(NamedElement lookupContext) {
		String name = "Thread_Properties::Dispatch_Able";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<PosixSchedulingPolicy> getPosixSchedulingPolicy(NamedElement lookupContext) {
		return getPosixSchedulingPolicy(lookupContext, Optional.empty());
	}
	
	public static Optional<PosixSchedulingPolicy> getPosixSchedulingPolicy(NamedElement lookupContext, Mode mode) {
		return getPosixSchedulingPolicy(lookupContext, Optional.of(mode));
	}
	
	public static Optional<PosixSchedulingPolicy> getPosixSchedulingPolicy(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Thread_Properties::POSIX_Scheduling_Policy";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(PosixSchedulingPolicy.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getPosixSchedulingPolicy_EObject(NamedElement lookupContext) {
		String name = "Thread_Properties::POSIX_Scheduling_Policy";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static OptionalLong getPriority(NamedElement lookupContext) {
		return getPriority(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getPriority(NamedElement lookupContext, Mode mode) {
		return getPriority(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getPriority(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Thread_Properties::Priority";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}
	
	public static PropertyExpression getPriority_EObject(NamedElement lookupContext) {
		String name = "Thread_Properties::Priority";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static OptionalLong getCriticality(NamedElement lookupContext) {
		return getCriticality(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getCriticality(NamedElement lookupContext, Mode mode) {
		return getCriticality(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getCriticality(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Thread_Properties::Criticality";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}
	
	public static PropertyExpression getCriticality_EObject(NamedElement lookupContext) {
		String name = "Thread_Properties::Criticality";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<Long>> getTimeSlot(NamedElement lookupContext) {
		return getTimeSlot(lookupContext, Optional.empty());
	}
	
	public static Optional<List<Long>> getTimeSlot(NamedElement lookupContext, Mode mode) {
		return getTimeSlot(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<Long>> getTimeSlot(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Thread_Properties::Time_Slot";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((IntegerLiteral) resolved1).getValue();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getTimeSlot_EObject(NamedElement lookupContext) {
		String name = "Thread_Properties::Time_Slot";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<SupportedConcurrencyControlProtocols> getConcurrencyControlProtocol(NamedElement lookupContext) {
		return getConcurrencyControlProtocol(lookupContext, Optional.empty());
	}
	
	public static Optional<SupportedConcurrencyControlProtocols> getConcurrencyControlProtocol(NamedElement lookupContext, Mode mode) {
		return getConcurrencyControlProtocol(lookupContext, Optional.of(mode));
	}
	
	public static Optional<SupportedConcurrencyControlProtocols> getConcurrencyControlProtocol(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Thread_Properties::Concurrency_Control_Protocol";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(SupportedConcurrencyControlProtocols.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getConcurrencyControlProtocol_EObject(NamedElement lookupContext) {
		String name = "Thread_Properties::Concurrency_Control_Protocol";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static OptionalLong getUrgency(NamedElement lookupContext) {
		return getUrgency(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getUrgency(NamedElement lookupContext, Mode mode) {
		return getUrgency(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getUrgency(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Thread_Properties::Urgency";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}
	
	public static PropertyExpression getUrgency_EObject(NamedElement lookupContext) {
		String name = "Thread_Properties::Urgency";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<DequeueProtocol> getDequeueProtocol(NamedElement lookupContext) {
		return getDequeueProtocol(lookupContext, Optional.empty());
	}
	
	public static Optional<DequeueProtocol> getDequeueProtocol(NamedElement lookupContext, Mode mode) {
		return getDequeueProtocol(lookupContext, Optional.of(mode));
	}
	
	public static Optional<DequeueProtocol> getDequeueProtocol(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Thread_Properties::Dequeue_Protocol";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(DequeueProtocol.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDequeueProtocol_EObject(NamedElement lookupContext) {
		String name = "Thread_Properties::Dequeue_Protocol";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static OptionalLong getDequeuedItems(NamedElement lookupContext) {
		return getDequeuedItems(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getDequeuedItems(NamedElement lookupContext, Mode mode) {
		return getDequeuedItems(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getDequeuedItems(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Thread_Properties::Dequeued_Items";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}
	
	public static PropertyExpression getDequeuedItems_EObject(NamedElement lookupContext) {
		String name = "Thread_Properties::Dequeued_Items";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<ModeTransitionResponse> getModeTransitionResponse(NamedElement lookupContext) {
		return getModeTransitionResponse(lookupContext, Optional.empty());
	}
	
	public static Optional<ModeTransitionResponse> getModeTransitionResponse(NamedElement lookupContext, Mode mode) {
		return getModeTransitionResponse(lookupContext, Optional.of(mode));
	}
	
	public static Optional<ModeTransitionResponse> getModeTransitionResponse(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Thread_Properties::Mode_Transition_Response";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(ModeTransitionResponse.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getModeTransitionResponse_EObject(NamedElement lookupContext) {
		String name = "Thread_Properties::Mode_Transition_Response";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<ResumptionPolicy> getResumptionPolicy(NamedElement lookupContext) {
		return getResumptionPolicy(lookupContext, Optional.empty());
	}
	
	public static Optional<ResumptionPolicy> getResumptionPolicy(NamedElement lookupContext, Mode mode) {
		return getResumptionPolicy(lookupContext, Optional.of(mode));
	}
	
	public static Optional<ResumptionPolicy> getResumptionPolicy(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Thread_Properties::Resumption_Policy";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(ResumptionPolicy.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getResumptionPolicy_EObject(NamedElement lookupContext) {
		String name = "Thread_Properties::Resumption_Policy";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<SupportedActiveThreadHandlingProtocols> getActiveThreadHandlingProtocol(NamedElement lookupContext) {
		return getActiveThreadHandlingProtocol(lookupContext, Optional.empty());
	}
	
	public static Optional<SupportedActiveThreadHandlingProtocols> getActiveThreadHandlingProtocol(NamedElement lookupContext, Mode mode) {
		return getActiveThreadHandlingProtocol(lookupContext, Optional.of(mode));
	}
	
	public static Optional<SupportedActiveThreadHandlingProtocols> getActiveThreadHandlingProtocol(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Thread_Properties::Active_Thread_Handling_Protocol";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(SupportedActiveThreadHandlingProtocols.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getActiveThreadHandlingProtocol_EObject(NamedElement lookupContext) {
		String name = "Thread_Properties::Active_Thread_Handling_Protocol";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<ActiveThreadQueueHandlingProtocol> getActiveThreadQueueHandlingProtocol(NamedElement lookupContext) {
		return getActiveThreadQueueHandlingProtocol(lookupContext, Optional.empty());
	}
	
	public static Optional<ActiveThreadQueueHandlingProtocol> getActiveThreadQueueHandlingProtocol(NamedElement lookupContext, Mode mode) {
		return getActiveThreadQueueHandlingProtocol(lookupContext, Optional.of(mode));
	}
	
	public static Optional<ActiveThreadQueueHandlingProtocol> getActiveThreadQueueHandlingProtocol(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Thread_Properties::Active_Thread_Queue_Handling_Protocol";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(ActiveThreadQueueHandlingProtocol.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getActiveThreadQueueHandlingProtocol_EObject(NamedElement lookupContext) {
		String name = "Thread_Properties::Active_Thread_Queue_Handling_Protocol";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<DeactivationPolicy> getDeactivationPolicy(NamedElement lookupContext) {
		return getDeactivationPolicy(lookupContext, Optional.empty());
	}
	
	public static Optional<DeactivationPolicy> getDeactivationPolicy(NamedElement lookupContext, Mode mode) {
		return getDeactivationPolicy(lookupContext, Optional.of(mode));
	}
	
	public static Optional<DeactivationPolicy> getDeactivationPolicy(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Thread_Properties::Deactivation_Policy";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(DeactivationPolicy.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDeactivationPolicy_EObject(NamedElement lookupContext) {
		String name = "Thread_Properties::Deactivation_Policy";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Boolean> getRuntimeProtection(NamedElement lookupContext) {
		return getRuntimeProtection(lookupContext, Optional.empty());
	}
	
	public static Optional<Boolean> getRuntimeProtection(NamedElement lookupContext, Mode mode) {
		return getRuntimeProtection(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Boolean> getRuntimeProtection(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Thread_Properties::Runtime_Protection";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getRuntimeProtection_EObject(NamedElement lookupContext) {
		String name = "Thread_Properties::Runtime_Protection";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<SubprogramCallType> getSubprogramCallType(NamedElement lookupContext) {
		return getSubprogramCallType(lookupContext, Optional.empty());
	}
	
	public static Optional<SubprogramCallType> getSubprogramCallType(NamedElement lookupContext, Mode mode) {
		return getSubprogramCallType(lookupContext, Optional.of(mode));
	}
	
	public static Optional<SubprogramCallType> getSubprogramCallType(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Thread_Properties::Subprogram_Call_Type";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(SubprogramCallType.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSubprogramCallType_EObject(NamedElement lookupContext) {
		String name = "Thread_Properties::Subprogram_Call_Type";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Boolean> getSynchronizedComponent(NamedElement lookupContext) {
		return getSynchronizedComponent(lookupContext, Optional.empty());
	}
	
	public static Optional<Boolean> getSynchronizedComponent(NamedElement lookupContext, Mode mode) {
		return getSynchronizedComponent(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Boolean> getSynchronizedComponent(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Thread_Properties::Synchronized_Component";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSynchronizedComponent_EObject(NamedElement lookupContext) {
		String name = "Thread_Properties::Synchronized_Component";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
}
