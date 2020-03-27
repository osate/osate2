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

import java.util.Collection;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Feature;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.TriggerPort;
import org.osate.aadl2.instance.AnnexInstance;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.annexsupport.AnnexInstantiator;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.CompositeStateInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.Constraint;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstraintElement;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstanceFactory;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EOperation;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorDetectionInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorFlowInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorPropagationConditionInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EventInstance;
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
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;
import org.osate.xtext.aadl2.errormodel.errorModel.OrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

public class EMV2AnnexInstantiator implements AnnexInstantiator {
	@Override
	public void instantiateAnnex(ComponentInstance instance, String annexName) {
		EMV2AnnexInstance emv2AI = EMV2InstanceFactory.eINSTANCE.createEMV2AnnexInstance();
		instance.getAnnexInstances().add(emv2AI);

		Collection<PropagationPoint> pps = EMV2Util.getAllPropagationPoints(instance.getClassifier());
		for (PropagationPoint pp : pps) {
			instantiatePropagationPoint(pp, emv2AI);
		}

		Collection<ErrorBehaviorEvent> events = EMV2Util.getAllErrorBehaviorEvents(instance);
		for (ErrorBehaviorEvent ev : events) {
			instantiateEvent(ev, emv2AI);
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

	}


	public void instantiatePropagationPoint(PropagationPoint g, EMV2AnnexInstance context) {
		PropagationPointInstance gi = EMV2InstanceFactory.eINSTANCE.createPropagationPointInstance();
		gi.setName(g.getName());
		gi.setPropagationPoint(g);
		context.getPropagationPoints().add(gi);
	}

	public void instantiateEvent(ErrorBehaviorEvent g, EMV2AnnexInstance context) {
		EventInstance gi = createEventInstance(g);
		context.getEvents().add(gi);
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

	public ConstrainedInstanceObject createConstrainedInstanceObject(InstanceObject io, boolean outgoing) {
		ConstrainedInstanceObject cio = EMV2InstanceFactory.eINSTANCE.createConstrainedInstanceObject();
		cio.setInstanceObject(io);
		cio.setName(cio.getInstanceObject().toString());
		cio.setOutgoing(outgoing);
		return cio;
	}

	public CompositeStateInstance createCompositeStateInstance(CompositeState st) {
		CompositeStateInstance sti = EMV2InstanceFactory.eINSTANCE.createCompositeStateInstance();
		sti.setName(st.getName());
		sti.setCompositeState(st);
		return sti;
	}

	public void instantiateStateMachine(ErrorBehaviorStateMachine ebsm, EMV2AnnexInstance context){
		StateMachineInstance svi = EMV2InstanceFactory.eINSTANCE.createStateMachineInstance();
		context.setStateMachine(svi);
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
		StateMachineInstance smi = context.getStateMachine();
		if (smi == null) {
			return ;
		}
		if (st.getDestinationBranches().isEmpty()) {
			instantiateStateTransition(st, null, context);
		} else {
			for (TransitionBranch br : st.getDestinationBranches()) {
				instantiateStateTransition(st, br, context);
			}
		}
	}

	private void instantiateStateTransition(ErrorBehaviorTransition st, TransitionBranch tb,
			EMV2AnnexInstance context) {
		StateMachineInstance smi = context.getStateMachine();
		StateTransitionInstance sti = EMV2InstanceFactory.eINSTANCE.createStateTransitionInstance();
		sti.setName(st.getName());
		if (tb != null) {
			sti.setStateTransition(tb);
		} else {
			sti.setStateTransition(st);
		}
		context.getTransitions().add(sti);
		ConditionExpression behaviorCondition = st.getCondition();
		ConstraintElement cio = instantiateCondition(context, behaviorCondition);
		sti.setCondition(cio);
		boolean isSteadyState = tb != null ? tb.isSteadyState() : st.isSteadyState();
		ErrorBehaviorState target = tb != null ? tb.getTarget() : st.getTarget();
		if (isSteadyState) {
			if (st.isAllStates()) {
				context.getTransitions().remove(sti);
				for (StateInstance si : smi.getStates()) {
					StateTransitionInstance nsti = EcoreUtil.copy(sti);
					nsti.getInStates().add(si);
					nsti.setTargetState(si);
				}
			} else {
				StateInstance ssti = findStateInstance(context, st.getSource());
				sti.getInStates().add(ssti);
				sti.setTargetState(ssti);
			}
		} else {
			// explicit target state
			sti.setTargetState(findStateInstance(context, target));
			if (st.isAllStates()) {
				for (StateInstance si : smi.getStates()) {
					sti.getInStates().add(si);
				}
			} else {
				sti.getInStates().add(findStateInstance(context, st.getSource()));
			}
		}
	}

	public void instantiateCompositeState(CompositeState st, EMV2AnnexInstance context) {
		CompositeStateInstance sti = EMV2InstanceFactory.eINSTANCE.createCompositeStateInstance();
		sti.setName(st.getName());
		sti.setCompositeState(st);
		context.getComposites().add(sti);
		ConditionExpression behaviorCondition = st.getCondition();
		ConstraintElement cio = instantiateCondition(context, behaviorCondition);
		sti.setCondition(cio);
		// explicit target state
		sti.setTargetState(findStateInstance(context, st.getState()));
	}

	public void instantiateErrorFlow(ErrorFlow ef, EMV2AnnexInstance context) {
		ComponentInstance relatedComponent = (ComponentInstance) context.eContainer();
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
			outToken = esink.getTypeTokenConstraint();
			allOutgoing = esink.isAllIncoming();
		}
		if (allIncoming && allOutgoing) {
			Collection<ErrorPropagation> ineps = EMV2Util.getAllIncomingErrorPropagations(relatedComponent);
			for (ErrorPropagation ainep : ineps) {
				Collection<ErrorPropagation> outeps = EMV2Util.getAllIncomingErrorPropagations(relatedComponent);
				for (ErrorPropagation aoutep : outeps) {
					instantiateErrorFlow(ef, context, ainep, constraint, aoutep, outToken);
				}
			}
		} else if (allIncoming) {
			Collection<ErrorPropagation> ineps = EMV2Util.getAllIncomingErrorPropagations(relatedComponent);
			for (ErrorPropagation ainep : ineps) {
				instantiateErrorFlow(ef, context, ainep, constraint, outep, outToken);
			}
		} else if (allOutgoing) {
			Collection<ErrorPropagation> outeps = EMV2Util
					.getAllOutgoingErrorPropagations(relatedComponent.getClassifier());
			for (ErrorPropagation aoutep : outeps) {
				instantiateErrorFlow(ef, context, inep, constraint, aoutep, outToken);
			}
		} else {
			instantiateErrorFlow(ef, context, inep, constraint, outep, outToken);
		}
	}

	private void instantiateErrorFlow(NamedElement ef, EMV2AnnexInstance context,
			ErrorPropagation inep, TypeSet constraint, ErrorPropagation outep, TypeSet outToken) {
		ErrorFlowInstance bi = EMV2InstanceFactory.eINSTANCE.createErrorFlowInstance();
		bi.setName(ef.getName());
		bi.setEmv2Element(ef);
		context.getErrorFlows().add(bi);
		if (inep != null) {
			ConstrainedInstanceObject cio = createCIO(inep, constraint, context);
			bi.setIncoming(cio);
		}
		if (outep != null) {
			ConstrainedInstanceObject cio = processAction(context, outep, outToken);
			bi.setOutgoing(cio);
		}
	}

	private ConstrainedInstanceObject createCIO(ErrorPropagation ep, TypeSet ts, EMV2AnnexInstance eai) {
		ConstrainedInstanceObject cio = EMV2InstanceFactory.eINSTANCE.createConstrainedInstanceObject();
		FeatureorPPReference fppref = ep.getFeatureorPPRef();
		if (fppref != null) {
			NamedElement fpp = fppref.getFeatureorPP();
			if (fpp instanceof Feature) {
				ComponentInstance ci = (ComponentInstance) eai.eContainer();
				FeatureInstance fi = ci.findFeatureInstance((Feature) fpp);
				cio.setInstanceObject(fi);
				cio.setName(fi.getName());
			} else if (fpp instanceof PropagationPoint) {
				PropagationPointInstance ppi = findPropagationPointInstance(eai, (PropagationPoint) fpp);
				cio.setInstanceObject(ppi);
				cio.setName(ppi.getName());
			}
		} else if (ep.getKind() != null) {
			cio.setBindingKind(ep.getKind());
		}
		if (ts != null){
			cio.getConstraint().addAll(ts.getTypeTokens());
		}
		return cio;
	}

	private ConstrainedInstanceObject processAction(EMV2AnnexInstance context, ErrorPropagation ep,
			TypeSet ts) {
		ConstrainedInstanceObject foundcio = findMatchingActionCIO(context, ep, ts.getTypeTokens().get(0));
		if (foundcio != null) {
			return foundcio;
		} else {
			ConstrainedInstanceObject tcio = createCIO(ep, ts, context);
			context.getActions().add(tcio);
			tcio.setOutgoing(true);
			return tcio;
		}

	}

	public void instantiateOutgoingPropagationCondition(OutgoingPropagationCondition opc, EMV2AnnexInstance context) {
		ErrorPropagationConditionInstance bi = EMV2InstanceFactory.eINSTANCE.createErrorPropagationConditionInstance();
		bi.setName(opc.getName());
		bi.setEmv2Element(opc);
		context.getErrorPropagationConditions().add(bi);
		ConditionExpression behaviorCondition = opc.getCondition();
		ConstraintElement cio = instantiateCondition(context, behaviorCondition);
		bi.setCondition(cio);
		// explicit target state
		if (opc.isAllStates()) {
			StateMachineInstance smi = context.getStateMachine();
			if (smi != null) {
				for (StateInstance si : smi.getStates()) {
					bi.getInStates().add(si);
				}
			}
		} else {
			bi.getInStates().add(findStateInstance(context, opc.getState()));
		}
		// action. We keep shared action instances such that there is only one per type
		if (opc.isAllPropagations()) {
			// TODO
		} else {
			ErrorPropagation outep = opc.getOutgoing();
			ConstrainedInstanceObject outcio = processAction(context, outep, opc.getTypeToken());
			bi.setAction(outcio);
		}
	}

	public void instantiateErrorDetection(ErrorDetection ed, EMV2AnnexInstance context) {
		ErrorDetectionInstance bi = EMV2InstanceFactory.eINSTANCE.createErrorDetectionInstance();
		bi.setName(ed.getName());
		bi.setEmv2Element(ed);
		context.getErrorDetections().add(bi);
		ConditionExpression behaviorCondition = ed.getCondition();
		ConstraintElement cio = instantiateCondition(context, behaviorCondition);
		bi.setCondition(cio);
		// explicit target state
		if (ed.isAllStates()) {
			StateMachineInstance smi = context.getStateMachine();
			if (smi != null) {
				for (StateInstance si : smi.getStates()) {
					bi.getInStates().add(si);
				}
			}
		} else {
			bi.getInStates().add(findStateInstance(context, ed.getState()));
		}
		// action. We keep shared action instances such that there is only one per type
		TriggerPort tp = ed.getDetectionReportingPort();
		ComponentInstance component = (ComponentInstance) context.eContainer();
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

	private ConstrainedInstanceObject findMatchingActionCIO(EMV2AnnexInstance context, ErrorPropagation ep,
			TypeToken tt) {
		FeatureorPPReference fppref = ep.getFeatureorPPRef();
		InstanceObject io = null;
		if (fppref != null) {
			NamedElement fpp = fppref.getFeatureorPP();
			ComponentInstance component = (ComponentInstance) context.eContainer();
			if (fpp instanceof Feature) {
				io = component.findFeatureInstance((Feature) fpp);
			} else if (fpp instanceof PropagationPoint) {
				io = findPropagationPointInstance(context, (PropagationPoint) fpp);
			}
		}
		for (ConstrainedInstanceObject action : context.getActions()) {
			if ((ep.getKind() != null && action.getBindingKind().equals(ep.getKind()))
					|| (io != null && action.getInstanceObject() == io)) {
				if (action.getConstraint().contains(tt)) {
					return action;
				}
			}
		}
		return null;
	}

	private StateInstance findStateInstance(EMV2AnnexInstance context, ErrorBehaviorState state) {
		StateMachineInstance svi = context.getStateMachine();
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

	public ConstraintElement instantiateCondition(EMV2AnnexInstance annex, ConditionExpression condition) {

		// Mapping of AND expression
		if (condition instanceof AndExpression) {
			AndExpression expression = (AndExpression) condition;
			Constraint andExpr = EMV2InstanceFactory.eINSTANCE.createConstraint();
			andExpr.setOperator(EOperation.ALL);
			for (ConditionExpression ce : expression.getOperands()) {
				ConstraintElement res = instantiateCondition(annex, ce);
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
				Constraint allExpr = EMV2InstanceFactory.eINSTANCE.createConstraint();
				allExpr.setOperator(EOperation.ALL);
				for (ConditionExpression ce : allCondition.getOperands()) {
					ConstraintElement res = instantiateCondition(annex, ce);
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
			Constraint allExpr = EMV2InstanceFactory.eINSTANCE.createConstraint();
			allExpr.setOperator(EOperation.ONEOF);
			for (ConditionExpression ce : orExpression.getOperands()) {
				ConstraintElement res = instantiateCondition(annex, ce);
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
				Constraint allExpr = EMV2InstanceFactory.eINSTANCE.createConstraint();
				allExpr.setOperator(EOperation.ANY);
				for (ConditionExpression ce : omCondition.getOperands()) {
					ConstraintElement res = instantiateCondition(annex, ce);
					if (res != null) {
						allExpr.getConstraintElements().add(res);
					}
				}

			} else {
				/* x ormore with x > 1 is mapped to a ORMORE gate */
				Constraint omExpr = EMV2InstanceFactory.eINSTANCE.createConstraint();
				omExpr.setOperator(EOperation.KORMORE);
				omExpr.setK(omCondition.getCount());
				for (ConditionExpression ce : omCondition.getOperands()) {
					ConstraintElement res = instantiateCondition(annex, ce);
					if (res != null) {
						omExpr.getConstraintElements().add(res);
					}
				}
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
					cio.getConstraint().addAll(referencedErrorType.getTypeTokens());
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
					ConstrainedInstanceObject cio = createCIO(ep, referencedErrorType,
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
					cio = createCIO(errorPropagation, ts, referencedAnnex);
					return cio;
				}

			}
		}
		return null;
	}


	private PropagationPointInstance findPropagationPointInstance(EMV2AnnexInstance eai, PropagationPoint pp) {
		for (PropagationPointInstance ei : eai.getPropagationPoints()) {
			if (ei.getPropagationPoint() == pp) {
				return ei;
			}
		}
		return null;
	}

	private EventInstance findEventInstance(EMV2AnnexInstance eai, ErrorBehaviorEvent ev) {
		for (EventInstance ei : eai.getEvents()) {
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

//	public void instantiatePropertyAssociations(ComponentInstance ci) {
//		List<ErrorModelSubclause> emslist = EMV2Util.getAllContainingClassifierEMV2Subclauses(ci);
//		ErrorBehaviorStateMachine ebsm = null;
//
//		for (ErrorModelSubclause ems : emslist) {
//			List<EMV2PropertyAssociation> props = ems.getProperties();
//			// process each property
//			// in top down - only if not already existing
//			// for use types also consider property associations in library
//			// for use behavior also consider properties in EBSM
//		}
//
//
//	}

	// property associations
//
//	InstanceObject io = (InstanceObject) event.getRelatedInstanceObject();
//	NamedElement ne = (NamedElement) event.getRelatedEMV2Object();
//	TypeToken type = (TypeToken) event.getRelatedErrorType();
//	event.setAssignedProbability(
//			new BigDecimal(EMV2Properties.getProbability(io, ne, type), MathContext.UNLIMITED));

	// PropertyAssociationInstance newPA = InstanceFactory.eINSTANCE
//			.createPropertyAssociationInstance();
//
//	io.removePropertyAssociations(property);
//	newPA.setProperty(property);
//	newPA.setPropertyAssociation(getDeclarativePA(result.getPa()));
//	fillPropertyValue(io, newPA, evaluated);
//	if (!newPA.getOwnedValues().isEmpty()) {
//		io.getOwnedPropertyAssociations().add(newPA);
//	}

// USE if we explicitly record propagation paths in instance model
	// private void populateBindingPaths(EMV2AnnexInstance eai, InstanceObject obj) {
//		if (obj instanceof ComponentInstance) {
//			ComponentInstance ci = (ComponentInstance) obj;
//			List<ComponentInstance> cpus = InstanceModelUtil.getProcessorBinding(ci);
//			for (ComponentInstance cpu : cpus) {
//				populateBindingPropagationPaths(eai, ci, cpu, "processor");
//			}
//			if (!(ci instanceof VirtualProcessor)) {
//				// do memory bindings
//				List<ComponentInstance> mems = InstanceModelUtil.getMemoryBinding(ci);
//				for (ComponentInstance mem : mems) {
//					populateBindingPropagationPaths(eai, ci, mem, "memory");
//				}
//			}
//			if (ci instanceof VirtualBus) {
//				// do connection bindings
//				List<ComponentInstance> boundresources = InstanceModelUtil.getConnectionBinding(ci);
//				for (ComponentInstance bres : boundresources) {
//					populateBindingPropagationPaths(pg, ci, bres, "connection");
//				}
//			}
//			List<ComponentInstance> systems = InstanceModelUtil.getFunctionBinding(ci);
//			for (ComponentInstance system : systems) {
//				populateBindingPropagationPaths(pg, ci, system, "binding");
//			}
//		} else if (obj instanceof ConnectionInstance) {
//			// do connection bindings
//			List<ComponentInstance> boundresources = InstanceModelUtil.getConnectionBinding(obj);
//			if (boundresources.isEmpty()) {
//				boundresources = InstanceModelUtil.deriveBoundBuses((ConnectionInstance) obj);
//			}
//			for (ComponentInstance bres : boundresources) {
//				populateBindingPropagationPaths(pg, (ConnectionInstance) obj, bres, "connection");
//			}
//		}
//	}
//	/**
//	 * Add a binding as propagation path.
//	 * The first argument is the component bound to a resource (e.g. a process) and the
//	 * boundResource argument the associated resources (e.g. a processor).
//	 * We will add the propagation path in each direction if declared in the EMV2 annex.
//	 * @param comp
//	 * @param boundResource
//	 */
//	private void populateBindingPropagationPaths(EMV2AnnexInstance eai, ComponentInstance comp,
//			ComponentInstance boundResource, String resourcebindingKind) {
//		ErrorPropagation BRsrcprop = EMV2Util.findOutgoingErrorPropagation(boundResource.getComponentClassifier(),
//				"bindings");
//		ErrorPropagation BCdstprop = EMV2Util.findIncomingErrorPropagation(comp.getComponentClassifier(),
//				resourcebindingKind);
//		if (BRsrcprop != null && BCdstprop != null) {
//			addPropagationpathRecord(pg, boundResource, BRsrcprop, comp, BCdstprop);
//		}
//		ErrorPropagation BCsrcprop = EMV2Util.findOutgoingErrorPropagation(comp.getComponentClassifier(),
//				resourcebindingKind);
//		ErrorPropagation BRdstprop = EMV2Util.findIncomingErrorPropagation(boundResource.getComponentClassifier(),
//				"bindings");
//		if (BCsrcprop != null && BRdstprop != null) {
//			addPropagationpathRecord(pg, comp, BCsrcprop, boundResource, BRdstprop);
//		}
//		for (ComponentInstance subci : comp.getComponentInstances()) {
//			populateBindingPropagationPaths(pg, subci, boundResource, resourcebindingKind);
//		}
//	}
//
//	/**
//	 * This is made to support the binding between connection and components.
//	 * Here, the first argument is the connection bound to a resource and the
//	 * boundResource argument the associated resources (e.g. a bus).
//	 *
//	 * @param conn
//	 * @param boundResource
//	 */
//	private void populateBindingPropagationPaths(EMV2AnnexInstance eai, ConnectionInstance conn,
//			ComponentInstance boundResource, String bindingKind) {
//		boolean added = false;
//		// source prop kind determined by destination and vice versa (BR = bound
//		// resource, BC bound component
//		ErrorPropagation BRsrcprop = EMV2Util.findOutgoingErrorPropagation(boundResource.getComponentClassifier(),
//				"bindings");
//
//		if (BRsrcprop != null) {
//			addPropagationpathRecord(pg, boundResource, BRsrcprop, conn);
//			added = true;
//		}
//		ErrorPropagation BRdstprop = EMV2Util.findIncomingErrorPropagation(boundResource.getComponentClassifier(),
//				"bindings");
//		if (BRdstprop != null) {
//			addPropagationpathRecord(pg, conn, boundResource, BRdstprop);
//			added = true;
//		}
//		if (added) {
//			pg.getConnections().add(conn);
//			pg.getComponents().add(boundResource);
//		}
//	}

}
