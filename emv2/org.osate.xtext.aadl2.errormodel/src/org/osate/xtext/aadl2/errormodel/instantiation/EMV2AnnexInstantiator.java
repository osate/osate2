/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.xtext.aadl2.errormodel.instantiation;

import java.util.Collection;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.annexsupport.AnnexInstantiator;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.Constraint;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstanceFactory;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstanceObject;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EventInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateMachineInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateSynchronizationInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

public class EMV2AnnexInstantiator implements AnnexInstantiator {
	@Override
	public void instantiateAnnex(ComponentInstance instance, String annexName) {
		EMV2AnnexInstance emv2AI = EMV2InstanceFactory.eINSTANCE.createEMV2AnnexInstance();
		instance.getAnnexInstances().add(emv2AI);
		Collection<ErrorBehaviorEvent> events = EMV2Util.getAllErrorBehaviorEvents(instance);
		for (ErrorBehaviorEvent ev : events) {
			instantiateEvent(ev, emv2AI);
		}
	}


	public void instantiateEvent(ErrorBehaviorEvent g, EMV2AnnexInstance context) {
		EventInstance gi = createEventInstance(g);
		context.getElements().add(gi);
		if (g instanceof ErrorEvent) {
			 TypeSet ts = ((ErrorEvent)g).getTypeSet();
			if (ts != null) {
				for (TypeToken tt : ts.getTypeTokens()) {
					gi.getGeneratedTypedEvents().add(createConstrainedInstanceObject(gi, tt));
				}
			}
		}
	}

	public EventInstance createEventInstance(ErrorBehaviorEvent g) {
		EventInstance gi = EMV2InstanceFactory.eINSTANCE.createEventInstance();
		gi.setName(g.getName());
		gi.setEvent(g);
		return gi;
	}

	public ConstrainedInstanceObject createConstrainedInstanceObject(EventInstance context, TypeToken token) {
		ConstrainedInstanceObject cio = EMV2InstanceFactory.eINSTANCE.createConstrainedInstanceObject();
		cio.setInstanceObject(context);
		if (!token.getType().isEmpty()) {
			cio.setName(context.getName() + ":" + token.toString());
			cio.getConstraint().add(EcoreUtil.copy(token));
		} else {
			cio.setName(context.getName());
		}
		return cio;
	}

	public ConstrainedInstanceObject createConstrainedInstanceObject(InstanceObject io, ComponentInstance context,
			boolean outgoing) {
		ConstrainedInstanceObject cio = EMV2InstanceFactory.eINSTANCE.createConstrainedInstanceObject();
		cio.setInstanceObject(io);
		cio.setName(cio.getInstanceObject().toString());
		cio.setOutgoing(outgoing);
		return cio;
	}

	public StateSynchronizationInstance createStateSynchronizationInstance(CompositeState st) {
		StateSynchronizationInstance sti = EMV2InstanceFactory.eINSTANCE.createStateSynchronizationInstance();
		sti.setName(st.getName());
		sti.setStateSynchronization(st);
		return sti;
	}

	public void instantiateStateMachine(ErrorBehaviorStateMachine ebsm, EMV2AnnexInstance context){
		StateMachineInstance svi = EMV2InstanceFactory.eINSTANCE.createStateMachineInstance();
		context.getElements().add(svi);
		StateInstance initState = null;
		for (ErrorBehaviorState st : ebsm.getStates()) {
			StateInstance istate = createStateInstance(st);
			if (st.isIntial()) {
				initState = istate;
			}
			svi.getStates().add(istate);
		}
		svi.setCurrentState(initState);
	}

	public StateInstance createStateInstance(ErrorBehaviorState ss) {
		StateInstance si = EMV2InstanceFactory.eINSTANCE.createStateInstance();
		si.setName(ss.getName());
		return si;
	}

	public void instantiateStateTransition(ErrorBehaviorTransition st, EMV2AnnexInstance context) {
		StateTransitionInstance sti = EMV2InstanceFactory.eINSTANCE.createStateTransitionInstance();
		sti.setName(st.getName());
		sti.setStateTransition(st);
		ConditionExpression behaviorCondition = st.getCondition();
		Constraint cio = null;
		// now replace ConditionElements by respective instances
//		val cos = EcoreUtil2.eAllOfType(behaviorCondition, BinaryOperation);
//		for (co : cos) {
//			if ((co.left as NamedElementReference).element instanceof ModelElement) {
//				// resolve only model element references
//				val cio = co.createConstrainedInstanceObject(context, false)
//				val container = co.eContainer
//				if (container instanceof ECollection) {
//					container.elements.remove(co)
//					container.elements.add(cio)
//				} else if (container === null) {
//					// single condition element as condition
//					behaviorCondition = cio
//				}
//			}
//		}
//		// do the same for condition elements without types
//		val ners = EcoreUtil2.eAllOfType(behaviorCondition, NamedElementReference);
//		for (ner : ners) {
//			if (ner.element instanceof ModelElement) {
//				// resolve only model element references
//				val tio = context.getInstanceElement(ner);
//				val cio = tio.createConstrainedInstanceObject(context, false)
//				val container = ner.eContainer
//				if (container instanceof ECollection) {
//					container.elements.remove(ner)
//					container.elements.add(cio)
//				} else if (container === null) {
//					// single condition element as condition
//					behaviorCondition = cio
//				}
//			}
//		}
		sti.setCondition(cio);
		sti.setTargetState(findStateInstance(context, st.getTarget()));
		context.getElements().add(sti);
//		val instates = st.inStates
//		if (instates instanceof BinaryOperation) {
//			sti.inStates += context.findStateInstances(instates)
//		}
	}

	private StateInstance findStateInstance(EMV2AnnexInstance context, ErrorBehaviorState state) {
		StateMachineInstance svi = findStateMachineInstance(context);
		if (svi != null) {
			return findStateInstance(svi,state);
		}
		return null;
	}

	private StateMachineInstance findStateMachineInstance(EMV2AnnexInstance context) {
		for (EMV2InstanceObject el : context.getElements()) {
			if (el instanceof StateMachineInstance) {
				return (StateMachineInstance) el;
			}
		}
		return null;
	}

	private StateInstance findStateInstance(StateMachineInstance svi, ErrorBehaviorState state) {
		for (StateInstance si : svi.getStates()) {
			if (si.getName().equals(state.getName())) {
				return si;
			}
		}
		return null;
	}


}
