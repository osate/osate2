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

import static org.osate.xtext.aadl2.errormodel.util.EMV2TypeSetUtil.isNoError;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.TriggerPort;
import org.osate.aadl2.instance.AnnexInstance;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceFactory;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.PropertyAssociationInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.annexsupport.AnnexInstantiator;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.CompositeStateInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstraintElement;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstraintExpression;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstanceFactory;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstanceObject;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EOperation;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorDetectionInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorFlowInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorPropagationConditionInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorPropagationInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EventInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.PropagationPathInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.PropagationPointInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateMachineInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.AllExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.AndExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorCodeValue;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;
import org.osate.xtext.aadl2.errormodel.errorModel.OrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.EMV2Properties;
import org.osate.xtext.aadl2.errormodel.util.EMV2TypeSetUtil;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

public class EMV2AnnexInstantiator implements AnnexInstantiator {
	@Override
	public void instantiateAnnex(ComponentInstance instance, String annexName) {
		EMV2AnnexInstance emv2AI = EMV2InstanceFactory.eINSTANCE.createEMV2AnnexInstance();
		instance.getAnnexInstances().add(emv2AI);

		Collection<PropagationPoint> pps = EMV2Util.getAllPropagationPoints(instance.getClassifier());
		for (PropagationPoint pp : pps) {
			instantiatePropagationPoint(pp, emv2AI);
		}

		Collection<ErrorPropagation> eps = EMV2Util.getAllErrorPropagations(instance.getClassifier());
		for (ErrorPropagation ep : eps) {
			instantiateErrorPropagation(ep, emv2AI);
		}

		Collection<ErrorBehaviorEvent> events = EMV2Util.getAllErrorBehaviorEvents(instance);
		for (ErrorBehaviorEvent ev : events) {
			instantiateEvent(ev, emv2AI);
		}

		Collection<ErrorFlow> fls = EMV2Util.getAllErrorFlows(instance);
		for (ErrorFlow fl : fls) {
			instantiateErrorFlow(fl, emv2AI);
		}

		ErrorBehaviorStateMachine ebsm = EMV2Util.getAllErrorBehaviorStateMachine(instance);
		if (ebsm != null) {
			instantiateStateMachine(ebsm, emv2AI);
		}

		Collection<ErrorBehaviorTransition> transitions = EMV2Util.getAllErrorBehaviorTransitions(instance);
		for (ErrorBehaviorTransition tr : transitions) {
			instantiateStateTransition(tr, emv2AI);
		}

		Collection<CompositeState> compstates = EMV2Util.getAllCompositeStates(instance);
		for (CompositeState cs : compstates) {
			instantiateCompositeState(cs, emv2AI);
		}

		Collection<OutgoingPropagationCondition> OPCs = EMV2Util.getAllOutgoingPropagationConditions(instance);
		for (OutgoingPropagationCondition opc : OPCs) {
			instantiateOutgoingPropagationCondition(opc, emv2AI);
		}

		Collection<ErrorDetection> eds = EMV2Util.getAllErrorDetections(instance.getClassifier());
		for (ErrorDetection ed : eds) {
			instantiateErrorDetection(ed, emv2AI);
		}

		Collection<ConnectionInstance> connis = instance.getConnectionInstances();
		for (ConnectionInstance conni : connis) {
			instantiateConnectionPropagationPaths(conni, emv2AI);
		}

		Collection<PropagationPath> ppaths = EMV2Util.getAllPropagationPaths(instance.getClassifier());
		for (PropagationPath ppath : ppaths) {
			instantiatePropagationPath(ppath, emv2AI);
		}

		// for bindings we need to first process all components EMV2 instantiations since the binding property instance
		// is attached to the component being bound and points to the resource.
		// During the depth first traversal the resource component may not have its EMV2 instantiated yet, thus, we cannot create the binding propagation path
		// instance.

		if (instance instanceof SystemInstance) {
			for (ComponentInstance ci : EcoreUtil2.eAllOfType(instance, ComponentInstance.class)) {
				instantiateBindingPaths(ci, emv2AI);
			}
		}
	}


	public void instantiatePropagationPoint(PropagationPoint g, EMV2AnnexInstance annex) {
		PropagationPointInstance gi = EMV2InstanceFactory.eINSTANCE.createPropagationPointInstance();
		gi.setName(g.getName());
		gi.setPropagationPoint(g);
		annex.getPropagationPoints().add(gi);
	}

	public void instantiateEvent(ErrorBehaviorEvent g, EMV2AnnexInstance annex) {
		ComponentInstance ci = (ComponentInstance) annex.eContainer();
		EventInstance gi = createEventInstance(g);
		annex.getEvents().add(gi);
		if (g instanceof ErrorEvent) {
			 TypeSet ts = ((ErrorEvent)g).getTypeSet();
			if (ts != null) {
				for (TypeToken tt : ts.getTypeTokens()) {
					ConstrainedInstanceObject cio = createConstrainedInstanceObject(gi, tt);
					gi.getGeneratedTypedEvents().add(cio);
					instantiatePropertyAssociations(cio, ci, g, tt);
				}
			} else {
				instantiatePropertyAssociations(gi, ci, g, null);
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

	public ConstrainedInstanceObject createConstrainedInstanceObject(InstanceObject io) {
		ConstrainedInstanceObject cio = EMV2InstanceFactory.eINSTANCE.createConstrainedInstanceObject();
		cio.setInstanceObject(io);
		cio.setName(cio.getInstanceObject().toString());
		return cio;
	}

	public CompositeStateInstance createCompositeStateInstance(CompositeState st) {
		CompositeStateInstance sti = EMV2InstanceFactory.eINSTANCE.createCompositeStateInstance();
		sti.setName(st.getName());
		sti.setCompositeState(st);
		return sti;
	}

	public void instantiateStateMachine(ErrorBehaviorStateMachine ebsm, EMV2AnnexInstance annex) {
		ComponentInstance ci = (ComponentInstance) annex.eContainer();
		StateMachineInstance svi = EMV2InstanceFactory.eINSTANCE.createStateMachineInstance();
		annex.setStateMachine(svi);
		StateInstance initState = null;
		for (ErrorBehaviorState st : ebsm.getStates()) {
			StateInstance istate = createStateInstance(st);
			if (st.isIntial()) {
				initState = istate;
			}
			svi.getStates().add(istate);
			// add property associations
			instantiatePropertyAssociations(istate, ci, st, null);
		}
		svi.setCurrentState(initState);
	}

	public StateInstance createStateInstance(ErrorBehaviorState ss) {
		StateInstance si = EMV2InstanceFactory.eINSTANCE.createStateInstance();
		si.setName(ss.getName());
		si.setState(ss);
		return si;
	}

	public void instantiateStateTransition(ErrorBehaviorTransition st, EMV2AnnexInstance annex) {
		StateMachineInstance smi = annex.getStateMachine();
		if (smi == null) {
			return ;
		}
		if (st.getDestinationBranches().isEmpty()) {
			instantiateStateTransition(st, null, annex);
		} else {
			for (TransitionBranch br : st.getDestinationBranches()) {
				instantiateStateTransition(st, br, annex);
			}
		}
	}

	private void instantiateStateTransition(ErrorBehaviorTransition st, TransitionBranch tb,
			EMV2AnnexInstance annex) {
		StateMachineInstance smi = annex.getStateMachine();
		StateTransitionInstance sti = EMV2InstanceFactory.eINSTANCE.createStateTransitionInstance();
		sti.setName(st.getName());
		if (tb != null) {
			sti.setStateTransition(tb);
		} else {
			sti.setStateTransition(st);
		}
		annex.getTransitions().add(sti);
		ConditionExpression behaviorCondition = st.getCondition();
		ConstraintElement cio = instantiateCondition(behaviorCondition, annex);
		sti.setCondition(cio);
		boolean isSteadyState = tb != null ? tb.isSteadyState() : st.isSteadyState();
		ErrorBehaviorState target = tb != null ? tb.getTarget() : st.getTarget();
		if (isSteadyState) {
			if (st.isAllStates()) {
				annex.getTransitions().remove(sti);
				for (StateInstance si : smi.getStates()) {
					StateTransitionInstance nsti = EcoreUtil.copy(sti);
					nsti.getInStates().add(si);
					nsti.setTargetState(si);
				}
			} else {
				StateInstance ssti = findStateInstance(annex, st.getSource());
				if (ssti != null) {
					sti.getInStates().add(ssti);
					sti.setTargetState(ssti);
				}
			}
		} else {
			// explicit target state
			sti.setTargetState(findStateInstance(annex, target));
			if (st.isAllStates()) {
				for (StateInstance si : smi.getStates()) {
					sti.getInStates().add(si);
				}
			} else {
				StateInstance si = findStateInstance(annex, st.getSource());
				if (si != null) {
					sti.getInStates().add(si);
				}
			}
		}
	}

	public void instantiateCompositeState(CompositeState st, EMV2AnnexInstance annex) {
		CompositeStateInstance sti = EMV2InstanceFactory.eINSTANCE.createCompositeStateInstance();
		sti.setName(st.getName());
		sti.setCompositeState(st);
		annex.getComposites().add(sti);
		ConditionExpression behaviorCondition = st.getCondition();
		ConstraintElement cio = instantiateCondition(behaviorCondition, annex);
		sti.setCondition(cio);
		// explicit target state
		sti.setTargetState(findStateInstance(annex, st.getState()));
	}

	public void instantiateErrorPropagation(ErrorPropagation ep, EMV2AnnexInstance annex) {
		ErrorPropagationInstance epi = EMV2InstanceFactory.eINSTANCE.createErrorPropagationInstance();
		epi.setName(EMV2Util.getName(ep));
		epi.setErrorPropagation(ep);
		ComponentInstance ci = (ComponentInstance) annex.eContainer();
		InstanceObject io = findFeatureInstance(ci, ep.getFeatureorPPRef());
		if (io == null) {
			io = ci;
		}
		epi.setInstanceObject(io);
		for (TypeToken token : ep.getTypeSet().getTypeTokens()) {
			epi.getConstraint().add(EcoreUtil.copy(token));
		}
		if (ep.getDirection() == DirectionType.IN) {
			annex.getInPropagations().add(epi);
		} else if (ep.getDirection() == DirectionType.OUT) {
			annex.getOutPropagations().add(epi);
		} else if (ep.getDirection() == DirectionType.IN_OUT) {
			annex.getInPropagations().add(epi);
			ErrorPropagationInstance epicopy = EcoreUtil.copy(epi);
			annex.getOutPropagations().add(epicopy);
		}
	}

	public void instantiateErrorFlow(ErrorFlow ef, EMV2AnnexInstance annex) {
		ComponentInstance relatedComponent = (ComponentInstance) annex.eContainer();
		ErrorPropagation inep = null;
		ErrorPropagation outep = null;
		TypeSet constraint = null;
		TypeSet outToken = null;
		boolean allIncoming = false;
		boolean allOutgoing = false;
		if (ef instanceof ErrorPath) {
			ErrorPath epath = (ErrorPath) ef;
			inep = epath.getIncoming();
			outep = epath.getOutgoing();
			constraint = epath.getTypeTokenConstraint();
			outToken = epath.getTargetToken();
			allIncoming = epath.isAllIncoming();
			allOutgoing = epath.isAllOutgoing();
		} else if (ef instanceof ErrorSource) {
			ErrorSource esrc = (ErrorSource) ef;
			outep = (ErrorPropagation) esrc.getSourceModelElement();
			outToken = esrc.getTypeTokenConstraint();
			allOutgoing = esrc.isAll();
		} else if (ef instanceof ErrorSink) {
			ErrorSink esink = (ErrorSink) ef;
			inep = esink.getIncoming();
			constraint = esink.getTypeTokenConstraint();
			allIncoming = esink.isAllIncoming();
		}
		if (allIncoming && allOutgoing) {
			Collection<ErrorPropagation> ineps = EMV2Util.getAllIncomingErrorPropagations(relatedComponent);
			for (ErrorPropagation ainep : ineps) {
				Collection<ErrorPropagation> outeps = EMV2Util
						.getAllOutgoingErrorPropagations(relatedComponent.getClassifier());
				for (ErrorPropagation aoutep : outeps) {
					instantiateErrorFlow(ef, annex, ainep, constraint, aoutep, outToken);
				}
			}
		} else if (allIncoming) {
			Collection<ErrorPropagation> ineps = EMV2Util.getAllIncomingErrorPropagations(relatedComponent);
			for (ErrorPropagation ainep : ineps) {
				instantiateErrorFlow(ef, annex, ainep, constraint, outep, outToken);
			}
		} else if (allOutgoing) {
			Collection<ErrorPropagation> outeps = EMV2Util
					.getAllOutgoingErrorPropagations(relatedComponent.getClassifier());
			for (ErrorPropagation aoutep : outeps) {
				instantiateErrorFlow(ef, annex, inep, constraint, aoutep, outToken);
			}
		} else {
			instantiateErrorFlow(ef, annex, inep, constraint, outep, outToken);
		}
	}

	/**
	 *
	 * @param ef
	 * @param annex
	 * @param inep
	 * @param constraint incoming type constraint in flow. Can be null
	 * @param outep
	 * @param outToken outgoing type constraint in flow. Can be null
	 */
	private void instantiateErrorFlow(NamedElement ef, EMV2AnnexInstance annex,
			ErrorPropagation inep, TypeSet constraint, ErrorPropagation outep, TypeSet outToken) {
		ComponentInstance ci = (ComponentInstance) annex.eContainer();
		ErrorFlowInstance bi = EMV2InstanceFactory.eINSTANCE.createErrorFlowInstance();
		bi.setName(ef.getName());
		bi.setEmv2Element(ef);
		if (inep != null) {
			ConstrainedInstanceObject cio = createErrorPropagationCIO(inep, constraint, annex);
			bi.setIncoming(cio);
		}
		if (outep != null) {
			ConstrainedInstanceObject cio = createErrorPropagationCIO(outep, outToken, annex);
			if (ef instanceof ErrorSource) {
				// for error source create a separate CIO for each type token as each can have its own property value and act as a separate source
				// This is similar to error events.
				EList<TypeToken> tts = cio.getConstraint();
				if (tts.isEmpty()) {
					bi.setOutgoing(cio);
					instantiatePropertyAssociations(bi, ci, ef, null);
					annex.getErrorFlows().add(bi);
				} else if (tts.size() == 1) {
					bi.setOutgoing(cio);
					instantiatePropertyAssociations(bi, ci, ef, tts.get(0));
					annex.getErrorFlows().add(bi);
				} else {
					// replicate for each typed token
					for (TypeToken tt : tts) {
						ErrorFlowInstance bicopy = EcoreUtil.copy(bi);
						ConstrainedInstanceObject ciocopy = EcoreUtil.copy(cio);
						ciocopy.getConstraint().clear();
						ciocopy.getConstraint().add(EcoreUtil.copy(tt));
						instantiatePropertyAssociations(bi, ci, ef, tts.get(0));
						bicopy.setOutgoing(ciocopy);
						annex.getErrorFlows().add(bicopy);
					}
				}
			}
		} else {
			// sink
			annex.getErrorFlows().add(bi);
		}
	}

	/**
	 *
	 * @param ep
	 * @param ts type constraint from flow. Can be null. If null then use type set from error propagation
	 * @param eai
	 * @return
	 */
	private ConstrainedInstanceObject createErrorPropagationCIO(ErrorPropagation ep, TypeSet ts,
			EMV2AnnexInstance eai) {
		ConstrainedInstanceObject cio = EMV2InstanceFactory.eINSTANCE.createConstrainedInstanceObject();
		FeatureorPPReference fppref = ep.getFeatureorPPRef();
		if (fppref != null) {
			NamedElement fpp = fppref.getFeatureorPP();
			if (fpp instanceof Feature) {
				ComponentInstance ci = (ComponentInstance) eai.eContainer();
				FeatureInstance fi = findFeatureInstance(ci, fppref);
				cio.setInstanceObject(fi);
				cio.setName(fi.getName());
			} else if (fpp instanceof PropagationPoint) {
				PropagationPointInstance ppi = findPropagationPointInstance(eai, (PropagationPoint) fpp);
				cio.setInstanceObject(ppi);
				cio.setName(ppi.getName());
			}
		} else if (ep.getKind() != null) {
			cio.setPropagationKind(ep.getKind());
		}
		TypeSet outts = (ts == null) ? ep.getTypeSet() : ts;
		if (outts != null) {
			for (TypeToken tt : outts.getTypeTokens()) {
				cio.getConstraint().add(EcoreUtil.copy(tt));
			}
		}
		return cio;
	}

	public void instantiateOutgoingPropagationCondition(OutgoingPropagationCondition opc, EMV2AnnexInstance annex) {
		ErrorPropagationConditionInstance bi = EMV2InstanceFactory.eINSTANCE.createErrorPropagationConditionInstance();
		bi.setName(opc.getName());
		bi.setEmv2Element(opc);
		ConditionExpression behaviorCondition = opc.getCondition();
		ConstraintElement cio = instantiateCondition(behaviorCondition, annex);
		bi.setCondition(cio);
		// explicit target state
		if (opc.isAllStates()) {
			StateMachineInstance smi = annex.getStateMachine();
			if (smi != null) {
				for (StateInstance si : smi.getStates()) {
					bi.getInStates().add(si);
				}
			}
		} else {
			bi.getInStates().add(findStateInstance(annex, opc.getState()));
		}
		if (opc.isAllPropagations()) {
			Collection<ErrorPropagation> outeps = EMV2Util
					.getAllOutgoingErrorPropagations(((ComponentInstance) annex.eContainer()).getClassifier());
			for (ErrorPropagation outep : outeps) {
				ErrorPropagationConditionInstance bicopy = EcoreUtil.copy(bi);
				ConstrainedInstanceObject outcio = createErrorPropagationCIO(outep, opc.getTypeToken(), annex);
				bicopy.setOutgoingPropagation(outcio);
				annex.getErrorPropagationConditions().add(bicopy);
			}
		} else {
			ErrorPropagation outep = opc.getOutgoing();
			ConstrainedInstanceObject outcio = createErrorPropagationCIO(outep, opc.getTypeToken(), annex);
			bi.setOutgoingPropagation(outcio);
			annex.getErrorPropagationConditions().add(bi);
		}
	}

	public void instantiateErrorDetection(ErrorDetection ed, EMV2AnnexInstance annex) {
		ErrorDetectionInstance bi = EMV2InstanceFactory.eINSTANCE.createErrorDetectionInstance();
		bi.setName(ed.getName());
		bi.setEmv2Element(ed);
		annex.getErrorDetections().add(bi);
		ConditionExpression behaviorCondition = ed.getCondition();
		ConstraintElement cio = instantiateCondition(behaviorCondition, annex);
		bi.setCondition(cio);
		// explicit target state
		if (ed.isAllStates()) {
			StateMachineInstance smi = annex.getStateMachine();
			if (smi != null) {
				for (StateInstance si : smi.getStates()) {
					bi.getInStates().add(si);
				}
			}
		} else {
			bi.getInStates().add(findStateInstance(annex, ed.getState()));
		}
		// action. We keep shared action instances such that there is only one per type
		TriggerPort tp = ed.getDetectionReportingPort();
		ComponentInstance component = (ComponentInstance) annex.eContainer();
		if (tp instanceof Feature) {
			bi.setPort(component.findFeatureInstance((Feature) tp));
		} else {
			// internal feature not instantiated in core model
		}
		ErrorCodeValue ec = ed.getErrorCode();
		if (!ec.getIntValue().isEmpty()) {
			bi.setErrorCode(ec.getIntValue());
		} else if (!ec.getEnumLiteral().isEmpty()) {
			bi.setErrorCode(ec.getEnumLiteral());
		} else if (ec.getConstant() != null) {
			PropertyConstant pc = ec.getConstant();
			PropertyExpression val = pc.getConstantValue();
			if (val instanceof IntegerLiteral) {
				bi.setErrorCode(String.valueOf(((IntegerLiteral) val).getValue()));
			} else if (val instanceof StringLiteral) {
				bi.setErrorCode(((StringLiteral) val).getValue());
			}
		}
	}

	private StateInstance findStateInstance(EMV2AnnexInstance annex, ErrorBehaviorState state) {
		StateMachineInstance svi = annex.getStateMachine();
		if (svi != null) {
			return findStateInstance(svi,state);
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

	public ConstraintElement instantiateCondition(ConditionExpression condition, EMV2AnnexInstance annex) {

		// Mapping of AND expression
		if (condition instanceof AndExpression) {
			AndExpression expression = (AndExpression) condition;
			ConstraintExpression andExpr = EMV2InstanceFactory.eINSTANCE.createConstraintExpression();
			andExpr.setOperator(EOperation.ALL);
			for (ConditionExpression ce : expression.getOperands()) {
				ConstraintElement res = instantiateCondition(ce, annex);
				if (res != null) {
					andExpr.getConstraintElements().add(res);
				}
			}

			return andExpr;
		}

		// Mapping of All expression
		if (condition instanceof AllExpression) {
			AllExpression allCondition = (AllExpression) condition;
			if (allCondition.getCount() == 0) {
				ConstraintExpression allExpr = EMV2InstanceFactory.eINSTANCE.createConstraintExpression();
				allExpr.setOperator(EOperation.ALL);
				for (ConditionExpression ce : allCondition.getOperands()) {
					ConstraintElement res = instantiateCondition(ce, annex);
					if (res != null) {
						allExpr.getConstraintElements().add(res);
					}
				}
				return allExpr;
			}
			return null;
		}

		// Mapping of OR expression
		if (condition instanceof OrExpression) {
			OrExpression orExpression = (OrExpression) condition;
			ConstraintExpression allExpr = EMV2InstanceFactory.eINSTANCE.createConstraintExpression();
			allExpr.setOperator(EOperation.ONEOF);
			for (ConditionExpression ce : orExpression.getOperands()) {
				ConstraintElement res = instantiateCondition(ce, annex);
				if (res != null) {
					allExpr.getConstraintElements().add(res);
				}
			}
			return allExpr;
		}

		// Mapping of ORMORE expression
		if (condition instanceof OrmoreExpression) {
			OrmoreExpression omCondition = (OrmoreExpression) condition;

			if (omCondition.getCount() == 1) {
				/* 1 ormore is mapped to a OR gate */
				ConstraintExpression allExpr = EMV2InstanceFactory.eINSTANCE.createConstraintExpression();
				allExpr.setOperator(EOperation.ANY);
				for (ConditionExpression ce : omCondition.getOperands()) {
					ConstraintElement res = instantiateCondition(ce, annex);
					if (res != null) {
						allExpr.getConstraintElements().add(res);
					}
				}
				return allExpr;
			} else {
				/* x ormore with x > 1 is mapped to a ORMORE gate */
				ConstraintExpression omExpr = EMV2InstanceFactory.eINSTANCE.createConstraintExpression();
				omExpr.setOperator(EOperation.KORMORE);
				omExpr.setK(omCondition.getCount());
				for (ConditionExpression ce : omCondition.getOperands()) {
					ConstraintElement res = instantiateCondition(ce, annex);
					if (res != null) {
						omExpr.getConstraintElements().add(res);
					}
				}
				return omExpr;
			}
		}

		// Mapping of single condition element
		if (condition instanceof ConditionElement) {
			ConditionElement conditionElement = (ConditionElement) condition;

			if (condition instanceof SConditionElement) {
				SConditionElement sconditionElement = (SConditionElement) condition;
				if (sconditionElement.getQualifiedState() != null) {
					/**
					 * In the following, it seems that we reference another
					 * component. This is typically the case when the condition is
					 * within an composite error behavior.
					 *
					 * So, we find the referenced component in the component
					 * hierarchy and add all its contributors to the returned
					 * events.
					 */
					QualifiedErrorBehaviorState qs = sconditionElement.getQualifiedState();
					ComponentInstance component = (ComponentInstance) annex.eContainer();
					ComponentInstance referencedComponent = EMV2Util.getLastComponentInstance(qs, component);
					ErrorBehaviorState state = EMV2Util.getState(sconditionElement);
					// either original type or mapped to constraint in condition or type set on state declaration
					TypeSet referencedErrorType = (sconditionElement.getConstraint() != null)
							? sconditionElement.getConstraint()
							: state.getTypeSet();
					EMV2AnnexInstance eai = findEMV2AnnexInstance(referencedComponent);
					StateInstance si = findStateInstance(eai, state);
					// state only
					ConstrainedInstanceObject cio = EMV2InstanceFactory.eINSTANCE.createConstrainedInstanceObject();
					cio.setInstanceObject(si);
					cio.setName(si.getName());
					if (referencedErrorType != null) {
						cio.getConstraint().addAll(referencedErrorType.getTypeTokens());
					}
					return cio;
				} else if (sconditionElement.getQualifiedErrorPropagationReference() != null) {
					EMV2Path path = sconditionElement.getQualifiedErrorPropagationReference();
					ComponentInstance component = (ComponentInstance) annex.eContainer();
					ComponentInstance referencedComponent = EMV2Util.getLastComponentInstance(path, component);
					ErrorPropagation ep = EMV2Util.getErrorPropagation(path);
					// either original type or mapped to constraint in condition or type set on state declaration
					TypeSet referencedErrorType = (sconditionElement.getConstraint() != null)
							? sconditionElement.getConstraint()
							: ep.getTypeSet();
					ConstrainedInstanceObject cio = createErrorPropagationCIO(ep, referencedErrorType,
							findEMV2AnnexInstance(referencedComponent));
					return cio;
				}
			} // end SConditionElement

			if (conditionElement.getConstraint() != null) {
				if (isNoError(conditionElement.getConstraint())) {
					// this is a recovery transition since an incoming propagation constraint is NoError
					return null;
				}
			}
			if (conditionElement.getQualifiedErrorPropagationReference() != null) {
				ConstrainedInstanceObject cio = EMV2InstanceFactory.eINSTANCE.createConstrainedInstanceObject();
				EMV2Path path = conditionElement.getQualifiedErrorPropagationReference();

				NamedElement errorModelElement = EMV2Util.getErrorModelElement(path);
				ComponentInstance component = (ComponentInstance) annex.eContainer();
				ComponentInstance referencedComponent = EMV2Util.getLastComponentInstance(path, component);
				EMV2AnnexInstance referencedAnnex = findEMV2AnnexInstance(referencedComponent);
				/**
				 * Here, we have an error event. Likely, this is something we
				 * can get when we are analyzing error component behavior.
				 */
				if (errorModelElement instanceof ErrorEvent) {
					EventInstance evi = findEventInstance(referencedAnnex, (ErrorEvent) errorModelElement);
					cio.setInstanceObject(evi);
					cio.setName(evi.getName());
					TypeSet ts = conditionElement.getConstraint() != null ? conditionElement.getConstraint()
							: ((ErrorEvent) errorModelElement).getTypeSet();
					if (ts != null) {
						cio.getConstraint().addAll(ts.getTypeTokens());
					}
					return cio;
				}

				/**
				 * Here, we have an error propagation. This is notified with the
				 * in propagation within a composite error model.
				 */
				if (errorModelElement instanceof ErrorPropagation) {
					ErrorPropagation errorPropagation = (ErrorPropagation) errorModelElement;
					TypeSet ts = conditionElement.getConstraint() != null ? conditionElement.getConstraint()
							: errorPropagation.getTypeSet();
					cio = createErrorPropagationCIO(errorPropagation, ts, referencedAnnex);
					return cio;
				}

			}
		}
		return null;
	}


	private PropagationPointInstance findPropagationPointInstance(EMV2AnnexInstance annex, PropagationPoint pp) {
		for (PropagationPointInstance ei : annex.getPropagationPoints()) {
			if (ei.getPropagationPoint() == pp) {
				return ei;
			}
		}
		return null;
	}

	private EventInstance findEventInstance(EMV2AnnexInstance annex, ErrorBehaviorEvent ev) {
		for (EventInstance ei : annex.getEvents()) {
			if (ei.getEvent() == ev) {
				return ei;
			}
		}
		return null;
	}

	private EMV2AnnexInstance findEMV2AnnexInstance(ComponentInstance ci) {
		for (AnnexInstance ai : ci.getAnnexInstances()) {
			if (ai instanceof EMV2AnnexInstance) {
				return (EMV2AnnexInstance) ai;
			}
		}
		return null;
	}

	private FeatureInstance findFeatureInstance(ComponentInstance ci, FeatureorPPReference fppref) {
		if (fppref == null) {
			return null;
		}
		NamedElement fpp = fppref.getFeatureorPP();
		FeatureInstance fi = ci.findFeatureInstance((Feature) fpp);
		FeatureorPPReference curfppref = fppref.getNext();
		while (curfppref != null) {
			fi = fi.findFeatureInstance((Feature) curfppref.getFeatureorPP());
			if (curfppref.getNext() != null) {
				if (fi == null) {
					return null;
				}
				curfppref = curfppref.getNext();
			} else {
				return fi;
			}
		}
		return fi;
	}

	private ErrorPropagationInstance findErrorPropagationInstance(EMV2AnnexInstance annex, ConnectionInstanceEnd cie,
			boolean outgoing) {
		Collection<ErrorPropagationInstance> eps = outgoing ? annex.getOutPropagations() : annex.getInPropagations();
		for (ErrorPropagationInstance epi : eps) {
			if (epi.getInstanceObject() == cie) {
				return epi;
			}
		}
		return null;
	}

	private ErrorPropagationInstance findErrorPropagationInstance(EMV2AnnexInstance annex, ErrorPropagation ep,
			boolean outgoing) {
		Collection<ErrorPropagationInstance> eps = outgoing ? annex.getOutPropagations() : annex.getInPropagations();
		for (ErrorPropagationInstance epi : eps) {
			if (epi.getErrorPropagation() == ep) {
				return epi;
			}
		}
		return null;
	}

	public void instantiateConnectionPropagationPaths(ConnectionInstance conni, EMV2AnnexInstance annex) {
		ConnectionInstanceEnd src = conni.getSource();
		ConnectionInstanceEnd dst = conni.getDestination();
		EMV2AnnexInstance srcAnnex = findEMV2AnnexInstance(src.getComponentInstance());
		EMV2AnnexInstance dstAnnex = findEMV2AnnexInstance(dst.getComponentInstance());
		for (ConstrainedInstanceObject assignment : allOutgoingCIOs(src, srcAnnex)) {
			if (assignment.getInstanceObject() == src) {
				EList<TypeToken> outTypeTokens = assignment.getConstraint();
				for (TypeToken tt : outTypeTokens) {
					Collection<ConstrainedInstanceObject> dstCIOs = allOutPropagationConditionCIOs(dst, tt, dstAnnex);
					for (ConstrainedInstanceObject dstCIO : dstCIOs) {
						PropagationPathInstance ppi = EMV2InstanceFactory.eINSTANCE.createPropagationPathInstance();
						ppi.setSource(assignment);
						ppi.setTarget(dstCIO);
						ppi.setName(conni.getName() + "-" + dstCIO.getName());
						annex.getPropagationPaths().add(ppi);
						addConnectionBindingCIOs(conni, annex, ppi);
					}
					if (dstCIOs.isEmpty()) {
						// use flow if no out propagation condition
						dstCIOs = allIncomingFlowCIOs(dst, tt, dstAnnex);
						for (ConstrainedInstanceObject dstCIO : dstCIOs) {
							PropagationPathInstance ppi = EMV2InstanceFactory.eINSTANCE.createPropagationPathInstance();
							ppi.setSource(assignment);
							ppi.setTarget(dstCIO);
							ppi.setName(conni.getName() + "-" + dstCIO.getName());
							annex.getPropagationPaths().add(ppi);
							addConnectionBindingCIOs(conni, annex, ppi);
						}
					}
					dstCIOs = allTransitionConditionCIOs(dst, tt, dstAnnex);
					for (ConstrainedInstanceObject dstCIO : dstCIOs) {
						PropagationPathInstance ppi = EMV2InstanceFactory.eINSTANCE.createPropagationPathInstance();
						ppi.setSource(assignment);
						ppi.setTarget(dstCIO);
						ppi.setName(conni.getName() + "-" + dstCIO.getName());
						annex.getPropagationPaths().add(ppi);
						addConnectionBindingCIOs(conni, annex, ppi);
					}
				}
			}
		}
		// now propagation paths from outgoing to incoming error propagations
		ErrorPropagationInstance outep = findErrorPropagationInstance(srcAnnex, src, true);
		ErrorPropagationInstance inep = findErrorPropagationInstance(dstAnnex, dst, false);
		if (outep != null && inep != null) {
			PropagationPathInstance ppi = EMV2InstanceFactory.eINSTANCE.createPropagationPathInstance();
			ppi.setSource(outep);
			ppi.setTarget(inep);
			ppi.setName(conni.getName() + "-" + inep.getName());
			annex.getPropagationPaths().add(ppi);
			addConnectionBindingCIOs(conni, annex, ppi);
		}
	}

	/**
	 * return all outgoing CIOs related to connections, i.e., propagation points, features, and access to components
	 * They are specified by outgoing propagation conditions and error flows
	 * binding related CIOs are retrieved separately.
	 * @param ppi ComponentInstance, FeatureInstance, PropagationPointInstance
	 * @param annex
	 * @return
	 */
	private Collection<ConstrainedInstanceObject> allOutgoingCIOs(InstanceObject ppi, EMV2AnnexInstance annex) {
		EList<ErrorPropagationConditionInstance> epcs = annex.getErrorPropagationConditions();
		Collection<ConstrainedInstanceObject> cios = new ArrayList<ConstrainedInstanceObject>();
		for (ErrorPropagationConditionInstance epc : epcs) {
			ConstrainedInstanceObject outGoing = epc.getOutgoingPropagation();
			// add if CIO for feature instance or propagation point instance
			// also add if component instance and propagation kind is access
			if (outGoing != null && outGoing.getInstanceObject() == ppi && (!(ppi instanceof ComponentInstance)
					|| (outGoing.getPropagationKind() != null && outGoing.getPropagationKind().equals("access")))) {
				cios.add(outGoing);
			}
		}
		for (ErrorFlowInstance epc : annex.getErrorFlows()) {
			ConstrainedInstanceObject outGoing = epc.getOutgoing();
			// add if CIO for feature instance or propagation point instance
			// also add if component instance and propagation kind is access
			if (outGoing != null && outGoing.getInstanceObject() == ppi && (!(ppi instanceof ComponentInstance)
					|| (outGoing.getPropagationKind() != null && outGoing.getPropagationKind().equals("access")))) {
				cios.add(outGoing);
			}
		}
		return cios;
	}

	private Collection<ConstrainedInstanceObject> allOutgoingBindingCIOs(ComponentInstance ppi, EMV2AnnexInstance annex,
			String bindingKind) {
		EList<ErrorPropagationConditionInstance> epcs = annex.getErrorPropagationConditions();
		Collection<ConstrainedInstanceObject> cios = new ArrayList<ConstrainedInstanceObject>();
		for (ErrorPropagationConditionInstance epc : epcs) {
			ConstrainedInstanceObject outGoing = epc.getOutgoingPropagation();
			if (outGoing != null && outGoing.getInstanceObject() == ppi
					&& outGoing.getPropagationKind() != null
					&& outGoing.getPropagationKind().contentEquals(bindingKind)) {
				cios.add(epc.getOutgoingPropagation());
			}
		}
		for (ErrorFlowInstance epc : annex.getErrorFlows()) {
			ConstrainedInstanceObject outGoing = epc.getOutgoing();
			if (outGoing != null && outGoing.getInstanceObject() == ppi && outGoing.getPropagationKind() != null
					&& outGoing.getPropagationKind().contentEquals(bindingKind)) {
				cios.add(outGoing);
			}
		}
		return cios;
	}

	/**
	 * all incoming CIO not related to bindings. This includes state transition conditions, outgoing propagation conditions, and error flows
	 * @param ppi
	 * @param tt
	 * @param annex
	 * @return
	 */
	private Collection<ConstrainedInstanceObject> allOutPropagationConditionCIOs(InstanceObject ppi,
			TypeToken tt,
			EMV2AnnexInstance annex) {
		Collection<ConstrainedInstanceObject> cios = new ArrayList<ConstrainedInstanceObject>();
		for (ErrorPropagationConditionInstance epc : annex.getErrorPropagationConditions()) {
			if (epc.getCondition() != null) {
				for (ConstrainedInstanceObject cio : EcoreUtil2.eAllOfType(epc.getCondition(),
						ConstrainedInstanceObject.class)) {
					if (cio.getInstanceObject() == ppi && (!(ppi instanceof ComponentInstance)
							|| (cio.getPropagationKind() != null && cio.getPropagationKind().equals("access")))) {
						if (tt == null || EMV2TypeSetUtil.contains(cio.getConstraint(), tt)) {
							cios.add(cio);
						}
					}
				}
			}
		}
		return cios;
	}

	private Collection<ConstrainedInstanceObject> allTransitionConditionCIOs(InstanceObject ppi, TypeToken tt,
			EMV2AnnexInstance annex) {
		Collection<ConstrainedInstanceObject> cios = new ArrayList<ConstrainedInstanceObject>();

		EList<StateTransitionInstance> sts = annex.getTransitions();
		for (StateTransitionInstance st : sts) {
			if (st.getCondition() != null) {
				for (ConstrainedInstanceObject cio : EcoreUtil2.eAllOfType(st.getCondition(),
						ConstrainedInstanceObject.class)) {
					if (cio.getInstanceObject() == ppi && (!(ppi instanceof ComponentInstance)
							|| (cio.getPropagationKind() != null && cio.getPropagationKind().equals("access")))) {
						if (tt == null || EMV2TypeSetUtil.contains(cio.getConstraint(), tt)) {
							cios.add(cio);
						}
					}
				}
				;
			}
		}
		return cios;
	}

	private Collection<ConstrainedInstanceObject> allIncomingFlowCIOs(InstanceObject ppi, TypeToken tt,
			EMV2AnnexInstance annex) {
		Collection<ConstrainedInstanceObject> cios = new ArrayList<ConstrainedInstanceObject>();
		for (ErrorFlowInstance epc : annex.getErrorFlows()) {
			ConstrainedInstanceObject inComing = epc.getIncoming();
			if (inComing != null && inComing.getInstanceObject() == ppi && (!(ppi instanceof ComponentInstance)
					|| (inComing.getPropagationKind() != null && inComing.getPropagationKind().equals("access")))) {
				if (tt == null || EMV2TypeSetUtil.contains(inComing.getConstraint(), tt)) {
					cios.add(inComing);
				}
			}
		}
		return cios;
	}

	private Collection<ConstrainedInstanceObject> allOutPropagationConditionBindingCIOs(InstanceObject ppi,
			TypeToken tt,
			EMV2AnnexInstance annex, String bindingKind) {
		Collection<ConstrainedInstanceObject> cios = new ArrayList<ConstrainedInstanceObject>();
		for (ErrorPropagationConditionInstance epc : annex.getErrorPropagationConditions()) {
			if (epc.getCondition() != null) {
				for (ConstrainedInstanceObject cio : EcoreUtil2.eAllOfType(epc.getCondition(),
						ConstrainedInstanceObject.class)) {
					if (cio.getInstanceObject() == ppi
							&& (cio.getPropagationKind() == null || cio.getPropagationKind().equals(bindingKind))) {
						if (tt == null || EMV2TypeSetUtil.contains(cio.getConstraint(), tt)) {
							cios.add(cio);
						}
					}
				}
			}
		}
		return cios;
	}

	private Collection<ConstrainedInstanceObject> allTransitionConditionBindingCIOs(InstanceObject ppi, TypeToken tt,
			EMV2AnnexInstance annex, String bindingKind) {
		Collection<ConstrainedInstanceObject> cios = new ArrayList<ConstrainedInstanceObject>();
		EList<StateTransitionInstance> sts = annex.getTransitions();
		for (StateTransitionInstance st : sts) {
			if (st.getCondition() != null) {
				for (ConstrainedInstanceObject cio : EcoreUtil2.eAllOfType(st.getCondition(),
						ConstrainedInstanceObject.class)) {
					if (cio.getInstanceObject() == ppi
							&& (cio.getPropagationKind() == null || cio.getPropagationKind().equals(bindingKind))) {
						if (tt == null || EMV2TypeSetUtil.contains(cio.getConstraint(), tt)) {
							cios.add(cio);
						}
					}
				}
				;
			}
		}
		return cios;
	}

	private Collection<ConstrainedInstanceObject> allIncomingFlowBindingCIOs(InstanceObject ppi, TypeToken tt,
			EMV2AnnexInstance annex, String bindingKind) {
		Collection<ConstrainedInstanceObject> cios = new ArrayList<ConstrainedInstanceObject>();
		for (ErrorFlowInstance epc : annex.getErrorFlows()) {
			ConstrainedInstanceObject inComing = epc.getIncoming();
			if (inComing != null && inComing.getInstanceObject() == ppi
					&& (inComing.getPropagationKind() == null || inComing.getPropagationKind().equals(bindingKind))) {
				if (tt == null || EMV2TypeSetUtil.contains(inComing.getConstraint(), tt)) {
					cios.add(inComing);
				}
			}
		}
		return cios;
	}

	public void instantiatePropagationPath(PropagationPath pp, EMV2AnnexInstance annex) {
		ComponentInstance contextCI = (ComponentInstance) annex.eContainer();
		InstanceObject srcIO = findQualifiedPropagationPoint(pp.getSource(), contextCI);
		InstanceObject dstIO = findQualifiedPropagationPoint(pp.getTarget(), contextCI);
		EMV2AnnexInstance srcAnnex = findEMV2AnnexInstance(srcIO.getComponentInstance());
		EMV2AnnexInstance dstAnnex = findEMV2AnnexInstance(dstIO.getComponentInstance());
		for (ConstrainedInstanceObject action : allOutgoingCIOs(srcIO, srcAnnex)) {
			if (action.getInstanceObject() == srcIO) {
				EList<TypeToken> outTypeTokens = action.getConstraint();
				for (TypeToken tt : outTypeTokens) {
					Collection<ConstrainedInstanceObject> dstCIOs = allOutPropagationConditionCIOs(dstIO, tt, dstAnnex);
					for (ConstrainedInstanceObject dstCIO : dstCIOs) {
						PropagationPathInstance ppi = EMV2InstanceFactory.eINSTANCE.createPropagationPathInstance();
						ppi.setSource(action);
						ppi.setTarget(dstCIO);
						ppi.setName(pp.getName() + "-" + dstCIO.getName());
						annex.getPropagationPaths().add(ppi);
					}
					if (dstCIOs.isEmpty()) {
						// use flow if no out propagation condition
						dstCIOs = allIncomingFlowCIOs(dstIO, tt, dstAnnex);
						for (ConstrainedInstanceObject dstCIO : dstCIOs) {
							PropagationPathInstance ppi = EMV2InstanceFactory.eINSTANCE.createPropagationPathInstance();
							ppi.setSource(action);
							ppi.setTarget(dstCIO);
							ppi.setName(pp.getName() + "-" + dstCIO.getName());
							annex.getPropagationPaths().add(ppi);
						}
					}
					dstCIOs = allTransitionConditionCIOs(dstIO, tt, dstAnnex);
					for (ConstrainedInstanceObject dstCIO : dstCIOs) {
						PropagationPathInstance ppi = EMV2InstanceFactory.eINSTANCE.createPropagationPathInstance();
						ppi.setSource(action);
						ppi.setTarget(dstCIO);
						ppi.setName(pp.getName() + "-" + dstCIO.getName());
						annex.getPropagationPaths().add(ppi);
					}
				}
			}
		}
	}

	private InstanceObject findQualifiedPropagationPoint(QualifiedPropagationPoint qpp, ComponentInstance context) {
		QualifiedPropagationPoint lqpp = qpp;
		ComponentInstance curci = context;
		while (lqpp.getSubcomponent() != null) {
			curci = curci.findSubcomponentInstance(lqpp.getSubcomponent().getSubcomponent());
			if (curci == null) {
				return null;
			}
			lqpp = lqpp.getNext();
		}
		if (lqpp.getPropagationPoint() != null) {
			NamedElement ne = lqpp.getPropagationPoint();
			if (ne instanceof Feature) {
				return curci.findFeatureInstance((Feature) ne);
			} else if (ne instanceof PropagationPoint) {
				EMV2AnnexInstance aei = findEMV2AnnexInstance(curci);
				return findPropagationPointInstance(aei, (PropagationPoint) ne);
			}
		}
		return null;
	}


	private void instantiateBindingPaths(ComponentInstance ci, EMV2AnnexInstance annex) {
		List<ComponentInstance> cpus = InstanceModelUtil.getProcessorBinding(ci);
		for (ComponentInstance cpu : cpus) {
			instantiateBindingPropagationPaths(annex, ci, cpu, "processor");
		}
		if (!(ci.getCategory() != ComponentCategory.VIRTUAL_PROCESSOR)) {
			// do memory bindings
			List<ComponentInstance> mems = InstanceModelUtil.getMemoryBinding(ci);
			for (ComponentInstance mem : mems) {
				instantiateBindingPropagationPaths(annex, ci, mem, "memory");
			}
		}
		if (ci.getCategory() == ComponentCategory.VIRTUAL_BUS) {
			// do connection bindings of virtual buses
			List<ComponentInstance> boundresources = InstanceModelUtil.getConnectionBinding(ci);
			for (ComponentInstance bres : boundresources) {
				instantiateBindingPropagationPaths(annex, ci, bres, "connection");
			}
		}
		List<ComponentInstance> systems = InstanceModelUtil.getFunctionBinding(ci);
		for (ComponentInstance system : systems) {
			instantiateBindingPropagationPaths(annex, ci, system, "binding");
		}
	}

	private Collection<ConstrainedInstanceObject> addConnectionBindingCIOs(ConnectionInstance conni,
			EMV2AnnexInstance annex,
			PropagationPathInstance ppi) {
		Collection<ConstrainedInstanceObject> cios = new ArrayList<ConstrainedInstanceObject>();
		List<ComponentInstance> boundresources = InstanceModelUtil.getConnectionBinding(conni);
		if (boundresources.isEmpty()) {
			boundresources = InstanceModelUtil.deriveBoundBuses(conni);
		}
		for (ComponentInstance boundResource : boundresources) {
			ErrorPropagation BRsrcprop = EMV2Util.findOutgoingErrorPropagation(boundResource.getComponentClassifier(),
					"bindings");
			if (BRsrcprop != null) {
				ErrorPropagationInstance srcEPI = findErrorPropagationInstance(annex, BRsrcprop, true);
				if (srcEPI != null) {
					PropagationPathInstance srcBindPPI = EcoreUtil.copy(ppi);
					srcBindPPI.setSource(srcEPI);
					srcBindPPI.setName(ppi.getName() + "-bindings-" + boundResource.getName());
					annex.getPropagationPaths().add(srcBindPPI);
				}
			}
			ErrorPropagation BRdstprop = EMV2Util.findIncomingErrorPropagation(boundResource.getComponentClassifier(),
					"bindings");
			if (BRdstprop != null) {
				ErrorPropagationInstance dstEPI = findErrorPropagationInstance(annex, BRdstprop, false);
				if (dstEPI != null) {
					PropagationPathInstance dstBindPPI = EcoreUtil.copy(ppi);
					dstBindPPI.setTarget(dstEPI);
					dstBindPPI.setName(ppi.getName() + "-bindings-" + boundResource.getName());
					annex.getPropagationPaths().add(dstBindPPI);
				}
			}
		}
		return cios;
	}

	/**
	 * Add a binding as propagation path.
	 * The first argument is the component bound to a resource (e.g. a process) and the
	 * boundResource argument the associated resources (e.g. a processor).
	 * We will add the propagation path in each direction if declared in the EMV2 annex.
	 * @param comp
	 * @param boundResource
	 */
	private void instantiateBindingPropagationPaths(EMV2AnnexInstance annex, ComponentInstance comp,
			ComponentInstance boundResource, String resourcebindingKind) {
		EMV2AnnexInstance resourceAnnex = findEMV2AnnexInstance(boundResource);
		if (resourceAnnex == null) {
			return;
		}
		for (ConstrainedInstanceObject outGoing : allOutgoingBindingCIOs(boundResource, resourceAnnex, "bindings")) {
			EList<TypeToken> outTypeTokens = outGoing.getConstraint();
			for (TypeToken tt : outTypeTokens) {
				Collection<ConstrainedInstanceObject> dstCIOs = allOutPropagationConditionBindingCIOs(comp, tt, annex,
						resourcebindingKind);
				for (ConstrainedInstanceObject dstCIO : dstCIOs) {
					PropagationPathInstance ppi = EMV2InstanceFactory.eINSTANCE.createPropagationPathInstance();
					ppi.setSource(outGoing);
					ppi.setTarget(dstCIO);
					ppi.setName(boundResource.getName() + "-bindings-" + EMV2Util.getName(tt));
					annex.getPropagationPaths().add(ppi);
				}
				if (dstCIOs.isEmpty()) {
					// use flow if no out propagation condition
					dstCIOs = allIncomingFlowBindingCIOs(comp, tt, annex, resourcebindingKind);
					for (ConstrainedInstanceObject dstCIO : dstCIOs) {
						PropagationPathInstance ppi = EMV2InstanceFactory.eINSTANCE.createPropagationPathInstance();
						ppi.setSource(outGoing);
						ppi.setTarget(dstCIO);
						ppi.setName(boundResource.getName() + "-bindings-" + "-" + dstCIO.getName());
						annex.getPropagationPaths().add(ppi);
					}
				}
				dstCIOs = allTransitionConditionBindingCIOs(comp, tt, annex, resourcebindingKind);
				for (ConstrainedInstanceObject dstCIO : dstCIOs) {
					PropagationPathInstance ppi = EMV2InstanceFactory.eINSTANCE.createPropagationPathInstance();
					ppi.setSource(outGoing);
					ppi.setTarget(dstCIO);
					ppi.setName(boundResource.getName() + "-bindings-" + "-" + dstCIO.getName());
					annex.getPropagationPaths().add(ppi);
				}
			}
		}
		for (ConstrainedInstanceObject outGoing : allOutgoingBindingCIOs(comp, annex, resourcebindingKind)) {
			EList<TypeToken> outTypeTokens = outGoing.getConstraint();
			for (TypeToken tt : outTypeTokens) {
				Collection<ConstrainedInstanceObject> dstCIOs = allOutPropagationConditionBindingCIOs(comp, tt, annex,
						"bindings");
				for (ConstrainedInstanceObject dstCIO : dstCIOs) {
					PropagationPathInstance ppi = EMV2InstanceFactory.eINSTANCE.createPropagationPathInstance();
					ppi.setSource(outGoing);
					ppi.setTarget(dstCIO);
					ppi.setName(boundResource.getName() + "-bindings-" + EMV2Util.getName(tt));
					annex.getPropagationPaths().add(ppi);
				}
				if (dstCIOs.isEmpty()) {
					// use flow if no out propagation condition
					dstCIOs = allIncomingFlowBindingCIOs(comp, tt, annex, "bindings");
					for (ConstrainedInstanceObject dstCIO : dstCIOs) {
						PropagationPathInstance ppi = EMV2InstanceFactory.eINSTANCE.createPropagationPathInstance();
						ppi.setSource(outGoing);
						ppi.setTarget(dstCIO);
						ppi.setName(boundResource.getName() + "-" + resourcebindingKind + "-" + dstCIO.getName());
						annex.getPropagationPaths().add(ppi);
					}
				}
				dstCIOs = allTransitionConditionBindingCIOs(comp, tt, annex, "bindings");
				for (ConstrainedInstanceObject dstCIO : dstCIOs) {
					PropagationPathInstance ppi = EMV2InstanceFactory.eINSTANCE.createPropagationPathInstance();
					ppi.setSource(outGoing);
					ppi.setTarget(dstCIO);
					ppi.setName(boundResource.getName() + "-" + resourcebindingKind + "-" + dstCIO.getName());
					annex.getPropagationPaths().add(ppi);
				}
			}
		}
		// subcomponents are bound too
		for (ComponentInstance subci : comp.getComponentInstances()) {
			instantiateBindingPropagationPaths(annex, subci, boundResource, resourcebindingKind);
		}
	}

	public void instantiatePropertyAssociations(EMV2InstanceObject emv2io, ComponentInstance ci,
			NamedElement emv2element, TypeToken tt) {
		ErrorTypes et = tt != null && tt.getType().size() == 1 ? tt.getType().get(0) : null;
		// token with a single type can have property values. Multiple types represents a product type
		List<EMV2PropertyAssociation> ODs = EMV2Properties.getOccurrenceDistributionProperty(ci, emv2element, et);
		instantiatePropertyAssociation(ODs, emv2io);
		List<EMV2PropertyAssociation> Hazards = EMV2Properties.getHazardsProperty(ci, emv2element, et);
		instantiatePropertyAssociation(Hazards, emv2io);
		List<EMV2PropertyAssociation> SEVs = EMV2Properties.getSeverityProperty(ci, emv2element, et);
		instantiatePropertyAssociation(SEVs, emv2io);
		List<EMV2PropertyAssociation> Likes = EMV2Properties.getLikelihoodProperty(ci, emv2element, et);
		instantiatePropertyAssociation(Likes, emv2io);
		// currently only the above properties are actually being used in analyses
		// for other EMV2 properties here is the generic method
//			List<EMV2PropertyAssociation> PAs = EMV2Properties.getProperty("EMV2::propertyname",ci, emv2element, et);
//			instantiatePropertyAssociation(PAs, emv2io);
	}

	private void instantiatePropertyAssociation(List<EMV2PropertyAssociation> PAs, EMV2InstanceObject emv2io) {
		if (!PAs.isEmpty()) {
			EMV2PropertyAssociation pa = PAs.get(0);
			PropertyAssociationInstance newPA = InstanceFactory.eINSTANCE.createPropertyAssociationInstance();
			newPA.setProperty(pa.getProperty());
			newPA.getOwnedValues().addAll(EcoreUtil.copyAll(pa.getOwnedValues()));
			// handle reference/symbolic labels? or do it when retrieving it from instance
			if (!newPA.getOwnedValues().isEmpty()) {
				emv2io.getOwnedPropertyAssociations().add(newPA);
			}
		}
	}


}
