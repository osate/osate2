package org.osate.xtext.aadl2.errormodel.util;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.AndExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.EventOrPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.OrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement;

public class EMV2Probabilities {

	/**
	 * compute probability from composite substates
	 * @param conditionElement
	 * @param root
	 * @return
	 */
	public static double computeProbability(final ComponentInstance root, final SConditionElement conditionElement) {
		double result = 0;

		ErrorBehaviorState behaviorState = EMV2Util.getState(conditionElement);

		ComponentInstance relatedInstance = EMV2Util.getLastComponentInstance(conditionElement.getQualifiedState(),
				root);

		if (behaviorState != null) {
			return computeCompositeStateProbability(relatedInstance, behaviorState, conditionElement.getConstraint());
		}
		return result;
	}

	public static double computeErrorEventProbability(final ComponentInstance root,
			final ConditionElement conditionElement) {
		double result = 0;
		EMV2Path epath = conditionElement.getQualifiedErrorPropagationReference();
		ComponentInstance relatedInstance = EMV2Util.getLastComponentInstance(epath, root);
		EventOrPropagation eeorp = EMV2Util.getErrorEventOrPropagation(epath);
		if (eeorp != null && eeorp instanceof ErrorBehaviorEvent) {
			return EMV2Properties.getProbability(relatedInstance, eeorp, conditionElement.getConstraint());
		}
		return result;
	}

	private static double computeProbability(final ConditionExpression cond, final ComponentInstance root) {
		double result = 0;
		double tmp;

		if (cond instanceof SConditionElement) {
			return computeProbability((SConditionElement) cond, root);
		} else if (cond instanceof ConditionElement) {
			return computeErrorEventProbability(root, (ConditionElement) cond);
		}

		if (cond instanceof OrExpression) {
			OrExpression sor = (OrExpression) cond;
			for (ConditionExpression conditionExpression : sor.getOperands()) {
				// OsateDebug.osateDebug(" operand=" + conditionExpression);
				result += computeProbability(conditionExpression, root);
			}
		}

		if (cond instanceof AndExpression) {
			AndExpression sae = (AndExpression) cond;
			for (ConditionExpression conditionExpression : sae.getOperands()) {
				tmp = computeProbability(conditionExpression, root);
				if (result == 0) {
					result = tmp;
				} else {
					result = result * tmp;
				}
			}
		}
		return result;
	}

	public static double getProbability(ComponentInstance component, ErrorBehaviorState es, ErrorTypes type) {
		double result = computeCompositeStateProbability(component, es, type);
		if (result == 0) {
			result = computeOwnStateProbability(component, es, type);
		}
		if (result == 0) {
			result = EMV2Probabilities.getProbability(component, es, type);
		}
		return 0;
	}

	/**
	 * compute probability of being in the specified state.
	 * This is determined by error events triggering incoming transitions, and recursively
	 * error events from predecessor state transitions (as product)
	 * reduce by probability of error events triggering outgoing transitions: incoming * (1 - outgoing)
	 * @param component
	 * @param es
	 * @param type
	 * @return
	 */
	public static double computeOwnStateProbability(ComponentInstance component, ErrorBehaviorState es,
			ErrorTypes type) {
		double incomingProbability = 0;
		// process transitions
		Collection<ErrorBehaviorTransition> transitions = EMV2Util.getAllErrorBehaviorTransitions(component);
		for (ErrorBehaviorTransition transition : transitions) {
			if (transition.getTarget().getName().equalsIgnoreCase(es.getName())) {
				// XXX match type
				double eventTriggerProbability = computeProbability(transition.getCondition(), component);
				// deal with multiple state transitions from a state without probabilities
				double previousStateProbability = computeOwnStateProbability(component, transition.getSource(), type);
				incomingProbability = incomingProbability + eventTriggerProbability * previousStateProbability;
			}
		}
		double outgoingProbability = computeOutgoingTransitionsProbability(component, es, type, transitions);
		return incomingProbability * (1 - outgoingProbability);
	}

	/**
	 * compute the probability of any outgoing transition to occur
	 * @param component
	 * @param es
	 * @param type
	 * @return
	 */
	public static double computeOutgoingTransitionsProbability(ComponentInstance component, ErrorBehaviorState es,
			ErrorTypes type) {
		Collection<ErrorBehaviorTransition> transitions = EMV2Util.getAllErrorBehaviorTransitions(component);
		return computeOutgoingTransitionsProbability(component, es, type, transitions);
	}

	public static double computeOutgoingTransitionsProbability(ComponentInstance component, ErrorBehaviorState es,
			ErrorTypes type, Collection<ErrorBehaviorTransition> transitions) {
		double outgoingProbability = 0;
		for (ErrorBehaviorTransition transition : transitions) {
			if (transition.getSource().getName().equalsIgnoreCase(es.getName())) {
				// XXX match type
				double probabilityTemp = computeProbability(transition.getCondition(), component);
				outgoingProbability += probabilityTemp;
			}
		}
		return outgoingProbability;
	}

	/**
	 * calculate cumulative error event probabilities
	 * They are separate for each transition (+) and cumulative chaining backwards to previosu states (*)
	 * @param component
	 * @param es
	 * @param type
	 * @return double
	 */
	public static double computeCumulativeTriggerProbability(ComponentInstance component, ErrorBehaviorState es,
			ErrorTypes type) {
		double triggerProbability = 0;
		// process transitions
		Collection<ErrorBehaviorTransition> transitions = EMV2Util.getAllErrorBehaviorTransitions(component);
		for (ErrorBehaviorTransition transition : transitions) {
			if (transition.getTarget().getName().equalsIgnoreCase(es.getName())) {
				// XXX match type
				double eventTriggerProbability = computeProbability(transition.getCondition(), component);
				// deal with multiple state transitions from a state without probabilities
				double previousTriggerProbabilities = computeCumulativeTriggerProbability(component,
						transition.getSource(), type);
				triggerProbability = triggerProbability + eventTriggerProbability
						* (previousTriggerProbabilities > 0 ? previousTriggerProbabilities : 1);
			}
		}
		return triggerProbability;
	}

	public static double computeCompositeStateProbability(ComponentInstance component, ErrorBehaviorState es,
			ErrorTypes type) {
		double probabilityTemp;
		double result;
		double inverseProb = 1;

		EList<CompositeState> states = EMV2Util.getAllCompositeStates(component);
		result = 0;
		probabilityTemp = 0;
		for (CompositeState state : states) {
			if (state.getState().getName().equalsIgnoreCase(es.getName())) {
				probabilityTemp = computeProbability(state.getCondition(), component);
				inverseProb *= (1 - probabilityTemp);
			}
		}
		result = 1 - inverseProb;
		return result;
	}

}
