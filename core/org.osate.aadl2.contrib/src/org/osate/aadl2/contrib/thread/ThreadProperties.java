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
package org.osate.aadl2.contrib.thread;

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
import org.osate.aadl2.contrib.aadlproject.SupportedActiveThreadHandlingProtocols;
import org.osate.aadl2.contrib.aadlproject.SupportedConcurrencyControlProtocols;
import org.osate.aadl2.contrib.aadlproject.SupportedDispatchProtocols;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;

public final class ThreadProperties {
	public static final String THREAD_PROPERTIES__NAME = "Thread_Properties";
	
	private ThreadProperties() {}
	
	// Lookup methods for Thread_Properties::Dispatch_Protocol
	
	public static final String DISPATCH_PROTOCOL__NAME = "Dispatch_Protocol";
	
	public static boolean acceptsDispatchProtocol(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDispatchProtocol_Property(lookupContext));
	}
	
	public static Optional<SupportedDispatchProtocols> getDispatchProtocol(NamedElement lookupContext) {
		return getDispatchProtocol(lookupContext, Optional.empty());
	}
	
	public static Optional<SupportedDispatchProtocols> getDispatchProtocol(NamedElement lookupContext, Mode mode) {
		return getDispatchProtocol(lookupContext, Optional.of(mode));
	}
	
	public static Optional<SupportedDispatchProtocols> getDispatchProtocol(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDispatchProtocol_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(SupportedDispatchProtocols.valueOf(resolved));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getDispatchProtocol_Property(EObject lookupContext) {
		String name = THREAD_PROPERTIES__NAME + "::" + DISPATCH_PROTOCOL__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDispatchProtocol_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDispatchProtocol_Property(lookupContext));
	}
	
	// Lookup methods for Thread_Properties::Dispatch_Trigger
	
	public static final String DISPATCH_TRIGGER__NAME = "Dispatch_Trigger";
	
	public static boolean acceptsDispatchTrigger(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDispatchTrigger_Property(lookupContext));
	}
	
	public static Optional<List<InstanceObject>> getDispatchTrigger(NamedElement lookupContext) {
		return getDispatchTrigger(lookupContext, Optional.empty());
	}
	
	public static Optional<List<InstanceObject>> getDispatchTrigger(NamedElement lookupContext, Mode mode) {
		return getDispatchTrigger(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<InstanceObject>> getDispatchTrigger(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDispatchTrigger_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((InstanceReferenceValue) resolved1).getReferencedInstanceObject();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getDispatchTrigger_Property(EObject lookupContext) {
		String name = THREAD_PROPERTIES__NAME + "::" + DISPATCH_TRIGGER__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDispatchTrigger_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDispatchTrigger_Property(lookupContext));
	}
	
	// Lookup methods for Thread_Properties::Dispatch_Able
	
	public static final String DISPATCH_ABLE__NAME = "Dispatch_Able";
	
	public static boolean acceptsDispatchAble(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDispatchAble_Property(lookupContext));
	}
	
	public static Optional<Boolean> getDispatchAble(NamedElement lookupContext) {
		return getDispatchAble(lookupContext, Optional.empty());
	}
	
	public static Optional<Boolean> getDispatchAble(NamedElement lookupContext, Mode mode) {
		return getDispatchAble(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Boolean> getDispatchAble(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDispatchAble_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getDispatchAble_Property(EObject lookupContext) {
		String name = THREAD_PROPERTIES__NAME + "::" + DISPATCH_ABLE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDispatchAble_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDispatchAble_Property(lookupContext));
	}
	
	// Lookup methods for Thread_Properties::POSIX_Scheduling_Policy
	
	public static final String POSIX_SCHEDULING_POLICY__NAME = "POSIX_Scheduling_Policy";
	
	public static boolean acceptsPosixSchedulingPolicy(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getPosixSchedulingPolicy_Property(lookupContext));
	}
	
	public static Optional<PosixSchedulingPolicy> getPosixSchedulingPolicy(NamedElement lookupContext) {
		return getPosixSchedulingPolicy(lookupContext, Optional.empty());
	}
	
	public static Optional<PosixSchedulingPolicy> getPosixSchedulingPolicy(NamedElement lookupContext, Mode mode) {
		return getPosixSchedulingPolicy(lookupContext, Optional.of(mode));
	}
	
	public static Optional<PosixSchedulingPolicy> getPosixSchedulingPolicy(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getPosixSchedulingPolicy_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(PosixSchedulingPolicy.valueOf(resolved));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getPosixSchedulingPolicy_Property(EObject lookupContext) {
		String name = THREAD_PROPERTIES__NAME + "::" + POSIX_SCHEDULING_POLICY__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getPosixSchedulingPolicy_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getPosixSchedulingPolicy_Property(lookupContext));
	}
	
	// Lookup methods for Thread_Properties::Priority
	
	public static final String PRIORITY__NAME = "Priority";
	
	public static boolean acceptsPriority(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getPriority_Property(lookupContext));
	}
	
	public static OptionalLong getPriority(NamedElement lookupContext) {
		return getPriority(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getPriority(NamedElement lookupContext, Mode mode) {
		return getPriority(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getPriority(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getPriority_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return OptionalLong.empty();
		}
	}
	
	public static Property getPriority_Property(EObject lookupContext) {
		String name = THREAD_PROPERTIES__NAME + "::" + PRIORITY__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getPriority_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getPriority_Property(lookupContext));
	}
	
	// Lookup methods for Thread_Properties::Criticality
	
	public static final String CRITICALITY__NAME = "Criticality";
	
	public static boolean acceptsCriticality(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getCriticality_Property(lookupContext));
	}
	
	public static OptionalLong getCriticality(NamedElement lookupContext) {
		return getCriticality(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getCriticality(NamedElement lookupContext, Mode mode) {
		return getCriticality(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getCriticality(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getCriticality_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return OptionalLong.empty();
		}
	}
	
	public static Property getCriticality_Property(EObject lookupContext) {
		String name = THREAD_PROPERTIES__NAME + "::" + CRITICALITY__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getCriticality_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getCriticality_Property(lookupContext));
	}
	
	// Lookup methods for Thread_Properties::Time_Slot
	
	public static final String TIME_SLOT__NAME = "Time_Slot";
	
	public static boolean acceptsTimeSlot(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getTimeSlot_Property(lookupContext));
	}
	
	public static Optional<List<Long>> getTimeSlot(NamedElement lookupContext) {
		return getTimeSlot(lookupContext, Optional.empty());
	}
	
	public static Optional<List<Long>> getTimeSlot(NamedElement lookupContext, Mode mode) {
		return getTimeSlot(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<Long>> getTimeSlot(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getTimeSlot_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((IntegerLiteral) resolved1).getValue();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getTimeSlot_Property(EObject lookupContext) {
		String name = THREAD_PROPERTIES__NAME + "::" + TIME_SLOT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getTimeSlot_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getTimeSlot_Property(lookupContext));
	}
	
	// Lookup methods for Thread_Properties::Concurrency_Control_Protocol
	
	public static final String CONCURRENCY_CONTROL_PROTOCOL__NAME = "Concurrency_Control_Protocol";
	
	public static boolean acceptsConcurrencyControlProtocol(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getConcurrencyControlProtocol_Property(lookupContext));
	}
	
	public static Optional<SupportedConcurrencyControlProtocols> getConcurrencyControlProtocol(NamedElement lookupContext) {
		return getConcurrencyControlProtocol(lookupContext, Optional.empty());
	}
	
	public static Optional<SupportedConcurrencyControlProtocols> getConcurrencyControlProtocol(NamedElement lookupContext, Mode mode) {
		return getConcurrencyControlProtocol(lookupContext, Optional.of(mode));
	}
	
	public static Optional<SupportedConcurrencyControlProtocols> getConcurrencyControlProtocol(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getConcurrencyControlProtocol_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(SupportedConcurrencyControlProtocols.valueOf(resolved));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getConcurrencyControlProtocol_Property(EObject lookupContext) {
		String name = THREAD_PROPERTIES__NAME + "::" + CONCURRENCY_CONTROL_PROTOCOL__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getConcurrencyControlProtocol_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getConcurrencyControlProtocol_Property(lookupContext));
	}
	
	// Lookup methods for Thread_Properties::Urgency
	
	public static final String URGENCY__NAME = "Urgency";
	
	public static boolean acceptsUrgency(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getUrgency_Property(lookupContext));
	}
	
	public static OptionalLong getUrgency(NamedElement lookupContext) {
		return getUrgency(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getUrgency(NamedElement lookupContext, Mode mode) {
		return getUrgency(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getUrgency(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getUrgency_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return OptionalLong.empty();
		}
	}
	
	public static Property getUrgency_Property(EObject lookupContext) {
		String name = THREAD_PROPERTIES__NAME + "::" + URGENCY__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getUrgency_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getUrgency_Property(lookupContext));
	}
	
	// Lookup methods for Thread_Properties::Dequeue_Protocol
	
	public static final String DEQUEUE_PROTOCOL__NAME = "Dequeue_Protocol";
	
	public static boolean acceptsDequeueProtocol(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDequeueProtocol_Property(lookupContext));
	}
	
	public static Optional<DequeueProtocol> getDequeueProtocol(NamedElement lookupContext) {
		return getDequeueProtocol(lookupContext, Optional.empty());
	}
	
	public static Optional<DequeueProtocol> getDequeueProtocol(NamedElement lookupContext, Mode mode) {
		return getDequeueProtocol(lookupContext, Optional.of(mode));
	}
	
	public static Optional<DequeueProtocol> getDequeueProtocol(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDequeueProtocol_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(DequeueProtocol.valueOf(resolved));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getDequeueProtocol_Property(EObject lookupContext) {
		String name = THREAD_PROPERTIES__NAME + "::" + DEQUEUE_PROTOCOL__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDequeueProtocol_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDequeueProtocol_Property(lookupContext));
	}
	
	// Lookup methods for Thread_Properties::Dequeued_Items
	
	public static final String DEQUEUED_ITEMS__NAME = "Dequeued_Items";
	
	public static boolean acceptsDequeuedItems(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDequeuedItems_Property(lookupContext));
	}
	
	public static OptionalLong getDequeuedItems(NamedElement lookupContext) {
		return getDequeuedItems(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getDequeuedItems(NamedElement lookupContext, Mode mode) {
		return getDequeuedItems(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getDequeuedItems(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDequeuedItems_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return OptionalLong.empty();
		}
	}
	
	public static Property getDequeuedItems_Property(EObject lookupContext) {
		String name = THREAD_PROPERTIES__NAME + "::" + DEQUEUED_ITEMS__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDequeuedItems_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDequeuedItems_Property(lookupContext));
	}
	
	// Lookup methods for Thread_Properties::Mode_Transition_Response
	
	public static final String MODE_TRANSITION_RESPONSE__NAME = "Mode_Transition_Response";
	
	public static boolean acceptsModeTransitionResponse(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getModeTransitionResponse_Property(lookupContext));
	}
	
	public static Optional<ModeTransitionResponse> getModeTransitionResponse(NamedElement lookupContext) {
		return getModeTransitionResponse(lookupContext, Optional.empty());
	}
	
	public static Optional<ModeTransitionResponse> getModeTransitionResponse(NamedElement lookupContext, Mode mode) {
		return getModeTransitionResponse(lookupContext, Optional.of(mode));
	}
	
	public static Optional<ModeTransitionResponse> getModeTransitionResponse(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getModeTransitionResponse_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(ModeTransitionResponse.valueOf(resolved));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getModeTransitionResponse_Property(EObject lookupContext) {
		String name = THREAD_PROPERTIES__NAME + "::" + MODE_TRANSITION_RESPONSE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getModeTransitionResponse_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getModeTransitionResponse_Property(lookupContext));
	}
	
	// Lookup methods for Thread_Properties::Resumption_Policy
	
	public static final String RESUMPTION_POLICY__NAME = "Resumption_Policy";
	
	public static boolean acceptsResumptionPolicy(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getResumptionPolicy_Property(lookupContext));
	}
	
	public static Optional<ResumptionPolicy> getResumptionPolicy(NamedElement lookupContext) {
		return getResumptionPolicy(lookupContext, Optional.empty());
	}
	
	public static Optional<ResumptionPolicy> getResumptionPolicy(NamedElement lookupContext, Mode mode) {
		return getResumptionPolicy(lookupContext, Optional.of(mode));
	}
	
	public static Optional<ResumptionPolicy> getResumptionPolicy(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getResumptionPolicy_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(ResumptionPolicy.valueOf(resolved));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getResumptionPolicy_Property(EObject lookupContext) {
		String name = THREAD_PROPERTIES__NAME + "::" + RESUMPTION_POLICY__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getResumptionPolicy_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getResumptionPolicy_Property(lookupContext));
	}
	
	// Lookup methods for Thread_Properties::Active_Thread_Handling_Protocol
	
	public static final String ACTIVE_THREAD_HANDLING_PROTOCOL__NAME = "Active_Thread_Handling_Protocol";
	
	public static boolean acceptsActiveThreadHandlingProtocol(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getActiveThreadHandlingProtocol_Property(lookupContext));
	}
	
	public static Optional<SupportedActiveThreadHandlingProtocols> getActiveThreadHandlingProtocol(NamedElement lookupContext) {
		return getActiveThreadHandlingProtocol(lookupContext, Optional.empty());
	}
	
	public static Optional<SupportedActiveThreadHandlingProtocols> getActiveThreadHandlingProtocol(NamedElement lookupContext, Mode mode) {
		return getActiveThreadHandlingProtocol(lookupContext, Optional.of(mode));
	}
	
	public static Optional<SupportedActiveThreadHandlingProtocols> getActiveThreadHandlingProtocol(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getActiveThreadHandlingProtocol_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(SupportedActiveThreadHandlingProtocols.valueOf(resolved));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getActiveThreadHandlingProtocol_Property(EObject lookupContext) {
		String name = THREAD_PROPERTIES__NAME + "::" + ACTIVE_THREAD_HANDLING_PROTOCOL__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getActiveThreadHandlingProtocol_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getActiveThreadHandlingProtocol_Property(lookupContext));
	}
	
	// Lookup methods for Thread_Properties::Active_Thread_Queue_Handling_Protocol
	
	public static final String ACTIVE_THREAD_QUEUE_HANDLING_PROTOCOL__NAME = "Active_Thread_Queue_Handling_Protocol";
	
	public static boolean acceptsActiveThreadQueueHandlingProtocol(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getActiveThreadQueueHandlingProtocol_Property(lookupContext));
	}
	
	public static Optional<ActiveThreadQueueHandlingProtocol> getActiveThreadQueueHandlingProtocol(NamedElement lookupContext) {
		return getActiveThreadQueueHandlingProtocol(lookupContext, Optional.empty());
	}
	
	public static Optional<ActiveThreadQueueHandlingProtocol> getActiveThreadQueueHandlingProtocol(NamedElement lookupContext, Mode mode) {
		return getActiveThreadQueueHandlingProtocol(lookupContext, Optional.of(mode));
	}
	
	public static Optional<ActiveThreadQueueHandlingProtocol> getActiveThreadQueueHandlingProtocol(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getActiveThreadQueueHandlingProtocol_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(ActiveThreadQueueHandlingProtocol.valueOf(resolved));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getActiveThreadQueueHandlingProtocol_Property(EObject lookupContext) {
		String name = THREAD_PROPERTIES__NAME + "::" + ACTIVE_THREAD_QUEUE_HANDLING_PROTOCOL__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getActiveThreadQueueHandlingProtocol_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getActiveThreadQueueHandlingProtocol_Property(lookupContext));
	}
	
	// Lookup methods for Thread_Properties::Deactivation_Policy
	
	public static final String DEACTIVATION_POLICY__NAME = "Deactivation_Policy";
	
	public static boolean acceptsDeactivationPolicy(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDeactivationPolicy_Property(lookupContext));
	}
	
	public static Optional<DeactivationPolicy> getDeactivationPolicy(NamedElement lookupContext) {
		return getDeactivationPolicy(lookupContext, Optional.empty());
	}
	
	public static Optional<DeactivationPolicy> getDeactivationPolicy(NamedElement lookupContext, Mode mode) {
		return getDeactivationPolicy(lookupContext, Optional.of(mode));
	}
	
	public static Optional<DeactivationPolicy> getDeactivationPolicy(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDeactivationPolicy_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(DeactivationPolicy.valueOf(resolved));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getDeactivationPolicy_Property(EObject lookupContext) {
		String name = THREAD_PROPERTIES__NAME + "::" + DEACTIVATION_POLICY__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDeactivationPolicy_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDeactivationPolicy_Property(lookupContext));
	}
	
	// Lookup methods for Thread_Properties::Runtime_Protection
	
	public static final String RUNTIME_PROTECTION__NAME = "Runtime_Protection";
	
	public static boolean acceptsRuntimeProtection(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getRuntimeProtection_Property(lookupContext));
	}
	
	public static Optional<Boolean> getRuntimeProtection(NamedElement lookupContext) {
		return getRuntimeProtection(lookupContext, Optional.empty());
	}
	
	public static Optional<Boolean> getRuntimeProtection(NamedElement lookupContext, Mode mode) {
		return getRuntimeProtection(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Boolean> getRuntimeProtection(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getRuntimeProtection_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getRuntimeProtection_Property(EObject lookupContext) {
		String name = THREAD_PROPERTIES__NAME + "::" + RUNTIME_PROTECTION__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getRuntimeProtection_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getRuntimeProtection_Property(lookupContext));
	}
	
	// Lookup methods for Thread_Properties::Subprogram_Call_Type
	
	public static final String SUBPROGRAM_CALL_TYPE__NAME = "Subprogram_Call_Type";
	
	public static boolean acceptsSubprogramCallType(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getSubprogramCallType_Property(lookupContext));
	}
	
	public static Optional<SubprogramCallType> getSubprogramCallType(NamedElement lookupContext) {
		return getSubprogramCallType(lookupContext, Optional.empty());
	}
	
	public static Optional<SubprogramCallType> getSubprogramCallType(NamedElement lookupContext, Mode mode) {
		return getSubprogramCallType(lookupContext, Optional.of(mode));
	}
	
	public static Optional<SubprogramCallType> getSubprogramCallType(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getSubprogramCallType_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(SubprogramCallType.valueOf(resolved));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getSubprogramCallType_Property(EObject lookupContext) {
		String name = THREAD_PROPERTIES__NAME + "::" + SUBPROGRAM_CALL_TYPE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getSubprogramCallType_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getSubprogramCallType_Property(lookupContext));
	}
	
	// Lookup methods for Thread_Properties::Synchronized_Component
	
	public static final String SYNCHRONIZED_COMPONENT__NAME = "Synchronized_Component";
	
	public static boolean acceptsSynchronizedComponent(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getSynchronizedComponent_Property(lookupContext));
	}
	
	public static Optional<Boolean> getSynchronizedComponent(NamedElement lookupContext) {
		return getSynchronizedComponent(lookupContext, Optional.empty());
	}
	
	public static Optional<Boolean> getSynchronizedComponent(NamedElement lookupContext, Mode mode) {
		return getSynchronizedComponent(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Boolean> getSynchronizedComponent(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getSynchronizedComponent_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getSynchronizedComponent_Property(EObject lookupContext) {
		String name = THREAD_PROPERTIES__NAME + "::" + SYNCHRONIZED_COMPONENT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getSynchronizedComponent_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getSynchronizedComponent_Property(lookupContext));
	}
}
