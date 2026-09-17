/**
 * AADL-BA-FrontEnd
 * 
 * Copyright (c) 2011-2021 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 2.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * https://www.eclipse.org/legal/epl-2.0/
 */

package org.osate.ba.analyzers;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.ba.aadlba.ActualPortHolder;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorBooleanLiteral;
import org.osate.ba.aadlba.BehaviorCondition;
import org.osate.ba.aadlba.BehaviorElement;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ba.aadlba.DispatchCondition;
import org.osate.ba.aadlba.DispatchTrigger;
import org.osate.ba.aadlba.DispatchTriggerLogicalExpression;
import org.osate.ba.aadlba.Factor;
import org.osate.ba.aadlba.ModeSwitchConjunction;
import org.osate.ba.aadlba.ModeSwitchTrigger;
import org.osate.ba.aadlba.ModeSwitchTriggerCondition;
import org.osate.ba.aadlba.ModeSwitchTriggerLogicalExpression;
import org.osate.ba.aadlba.Otherwise;
import org.osate.ba.aadlba.Relation;
import org.osate.ba.aadlba.SimpleExpression;
import org.osate.ba.aadlba.Term;
import org.osate.ba.aadlba.UnaryBooleanOperator;
import org.osate.ba.aadlba.Value;
import org.osate.ba.aadlba.ValueExpression;
import org.osate.ba.utils.AadlBaUtils;
import org.osate.ba.utils.AadlBaVisitors;
import org.osate.utils.internal.Aadl2Utils;
import org.osate.utils.internal.Aadl2Visitors;

public class AadlBaConsistencyRulesChecker {
	private BehaviorAnnex _ba;
	private ComponentClassifier _baParentContainer;
	PackageSection[] _contextsTab;
	private AnalysisErrorReporterManager _errManager;

	public AadlBaConsistencyRulesChecker(BehaviorAnnex ba, AnalysisErrorReporterManager errManager) {
		this(ba, AadlBaVisitors.getParentComponent(ba), errManager);
	}

	public AadlBaConsistencyRulesChecker(BehaviorAnnex ba, ComponentClassifier parentContainer,
			AnalysisErrorReporterManager errManager) {
		_ba = ba;
		_errManager = errManager;
		_baParentContainer = AadlBaVisitors.getParentComponent(ba, parentContainer);
		_contextsTab = AadlBaVisitors.getBaPackageSections(_ba, _baParentContainer);
	}

	/**
	 * Document: AS5506/3 Rev A
	 * Type    : Consistency rule
	 * Section : D.3 Behavior Specification
	 * Object  : The disjunction of the execute conditions on transitions out of an execution state must be true.
	 * Report only a definite violation: an empty disjunction or one whose conditions reduce to false using Boolean
	 * literals and operators. A runtime-dependent expression or any non-value condition makes the result unknown and
	 * is accepted conservatively.
	 * Keys    : execution state execute condition nonblocking
	 */
	public boolean D_3_C3_Check(BehaviorAnnex ba) {
		var result = true;
		for (var state : ba.getStates()) {
			if (state.isInitial() || state.isComplete() || state.isFinal()) {
				continue;
			}
			var disjunction = StaticTruth.FALSE;
			for (var transition : state.getOutgoingTransitions()) {
				var condition = transition.getCondition();
				if (condition == null || condition instanceof Otherwise) {
					disjunction = StaticTruth.TRUE;
					break;
				}
				if (condition instanceof ValueExpression expression) {
					disjunction = disjunction.or(staticTruth(expression));
				} else {
					disjunction = disjunction.or(StaticTruth.UNKNOWN);
				}
			}
			if (disjunction == StaticTruth.FALSE) {
				result = false;
				reportConsistencyError(state, "Execution state '" + state.getName()
						+ "' has no possibly true outgoing execute condition and can remain blocked: "
						+ "Behavior Annex D.3 consistency rule failed");
			}
		}
		return result;
	}

	private static StaticTruth staticTruth(ValueExpression expression) {
		if (expression.getRelations().isEmpty()
				|| expression.getLogicalOperators().size() != expression.getRelations().size() - 1) {
			return StaticTruth.UNKNOWN;
		}
		var result = staticTruth(expression.getRelations().getFirst());
		for (var i = 1; i < expression.getRelations().size(); i++) {
			var right = staticTruth(expression.getRelations().get(i));
			result = switch (expression.getLogicalOperators().get(i - 1)) {
			case AND, AND_THEN -> result.and(right);
			case OR, OR_ELSE -> result.or(right);
			case XOR -> result.xor(right);
			default -> StaticTruth.UNKNOWN;
			};
		}
		return result;
	}

	private static StaticTruth staticTruth(Relation relation) {
		return relation.getSecondExpression() == null && !relation.isSetRelationalOperator()
				? staticTruth(relation.getFirstExpression())
				: StaticTruth.UNKNOWN;
	}

	private static StaticTruth staticTruth(SimpleExpression expression) {
		return !expression.isSetUnaryAddingOperator() && expression.getTerms().size() == 1
				&& expression.getBinaryAddingOperators().isEmpty() ? staticTruth(expression.getTerms().getFirst())
						: StaticTruth.UNKNOWN;
	}

	private static StaticTruth staticTruth(Term term) {
		return term.getFactors().size() == 1 && term.getMultiplyingOperators().isEmpty()
				? staticTruth(term.getFactors().getFirst())
				: StaticTruth.UNKNOWN;
	}

	private static StaticTruth staticTruth(Factor factor) {
		if (factor.getSecondValue() != null || factor.isSetBinaryNumericOperator()
				|| factor.isSetUnaryNumericOperator()) {
			return StaticTruth.UNKNOWN;
		}
		var result = staticTruth(factor.getFirstValue());
		if (factor.isSetUnaryBooleanOperator()) {
			result = factor.getUnaryBooleanOperator() == UnaryBooleanOperator.NOT ? result.not() : StaticTruth.UNKNOWN;
		}
		return result;
	}

	private static StaticTruth staticTruth(Value value) {
		if (value instanceof BehaviorBooleanLiteral literal) {
			return literal.isValue() ? StaticTruth.TRUE : StaticTruth.FALSE;
		}
		return value instanceof ValueExpression expression ? staticTruth(expression) : StaticTruth.UNKNOWN;
	}

	private enum StaticTruth {
		FALSE, TRUE, UNKNOWN;

		private StaticTruth and(StaticTruth other) {
			if (this == FALSE || other == FALSE) {
				return FALSE;
			}
			return this == TRUE && other == TRUE ? TRUE : UNKNOWN;
		}

		private StaticTruth or(StaticTruth other) {
			if (this == TRUE || other == TRUE) {
				return TRUE;
			}
			return this == FALSE && other == FALSE ? FALSE : UNKNOWN;
		}

		private StaticTruth xor(StaticTruth other) {
			if (this == UNKNOWN || other == UNKNOWN) {
				return UNKNOWN;
			}
			return this == other ? FALSE : TRUE;
		}

		private StaticTruth not() {
			return this == TRUE ? FALSE : this == FALSE ? TRUE : UNKNOWN;
		}
	}

	/**
	 * Document: AADL Behavior Annex draft
	 * Version : 0.94
	 * Type    : Consistency rule
	 * Section : D.3 Behavior Specification 
	 * Object  : Check consistency rule D.3.(C4)
	 * Keys    : complete state mode behavior condition mode transition triggers
	 */
	public boolean D_3_C4_Check(BehaviorTransition btOwner, BehaviorState srcState) {
		// [OPTIM] -------------------------------------------------------------
		// these checking can be moved to the rules driver in order to optimize.

		var declaredState = srcState;

		// If the srcState doesn't represent a mode: nothing to check for, exit
		// with true.
		if (declaredState.getBindedMode() == null) {
			return true;
		}

		// ---------------------------------------------------------------------

		// At this point, one of the current behavior transtion's src states
		// represent a mode.

		var mode = declaredState.getBindedMode();

		// The element the triggers were read from, which carries any mismatch diagnostic.
		final BehaviorElement triggerOwner;
		// Fetches trigger names in the given behavior transition.
		final var lCondTriggs = new ArrayList<String>();

		// As D.3.(C4), a behavior state that represents a mode is a complete state, so D.3.(L6) and D.3.(L7) leave a
		// dispatch condition as the only condition a thread can use here. AS5506/3 Rev A D.3 also lets a component of
		// any other category than thread and subprogram describe a mode transition with an external condition, whose
		// event triggers are read the same way.
		if (btOwner.getCondition() instanceof DispatchCondition dispatchCondition) {
			if (!(dispatchCondition
					.getDispatchTriggerCondition() instanceof DispatchTriggerLogicalExpression expression)) {
				// At least, there is one mode transition trigger in a mode
				// transition. So this transition is not consistency.
				// The state declaration is legal; the transition's dispatch condition is what is inconsistent.
				reportConsistencyError(dispatchCondition,
						"The behavior transition tries " + "to refine a transition mode but it hasn't got any dispatch "
								+ "trigger logical expression: Behavior Annex D.3.(C4) " + "consistency rule failed");
				return false;
			}
			triggerOwner = expression;
			for (var trigg : AadlBaVisitors.getDispatchTriggers(expression)) {
				lCondTriggs.add(triggerName((ActualPortHolder) trigg));
			}
		} else if (btOwner.getCondition() instanceof ModeSwitchTriggerLogicalExpression expression) {
			triggerOwner = expression;
			for (var trigg : getExternalConditionTriggers(expression)) {
				lCondTriggs.add(triggerName(trigg));
			}
		} else {
			// D.3.(L6) and D.3(L7) error case. Do not report error but
			// exit with false result.
			return false;
		}

		var lModeTrans = Aadl2Visitors.getElementsInNamespace(_baParentContainer,
				ModeTransition.class);

		// Can't be out a state/mode if the parent container doesn't declare
		// any transition mode.
		if (lModeTrans.isEmpty()) {
			reportConsistencyError(btOwner.getCondition(),
					"The behavior transition tries to " + "refine a transition mode while "
							+ _baParentContainer.getQualifiedName() + " component hasn't got any transition mode: "
							+ "Behavior Annex D.3.(C4) consistency rule failed");
			return false;
		}

		// At this point preliminary checking has been passed.

		var lModeTriggs = new ArrayList<String>();

		// Checks if the behavior transition is consisting with one of
		// the mode transitions where the considered mode is contained.
		// Otherwise reports an error.
		for (var mTrans : lModeTrans) {
			// If the transition mode contains the considered mode:
			if (mTrans.getSource().getName().equalsIgnoreCase(mode.getName())) {
				// Fetches mode transition trigger names.
				for (var mtt : mTrans.getOwnedTriggers()) {
					lModeTriggs.add(mtt.getContext() == null ? mtt.getTriggerPort().getName()
							: mtt.getContext().getName() + "." + mtt.getTriggerPort().getName());
				}

				// Checks consistency between the two triggers lists without
				// considering their order.
				if (Aadl2Utils.compareStringList(lCondTriggs, lModeTriggs)) {
					return true;
				} else {
					lModeTriggs.clear();
					continue;
				}
			}
			// Else continue to the next transition mode.
		}

		// Error case : the given behavior transition which is out of a mode
		// is not consisting with any transition mode which involves the considered
		// mode.
		// The mismatch is between the condition's triggers and the mode transition triggers, so mark the trigger
		// expression rather than the legal source state declaration.
		reportConsistencyError(triggerOwner,
				"The behavior transition tries to " + "refine a transition mode but it is not consisting with any "
						+ "transition mode of " + _baParentContainer.getQualifiedName()
						+ " component: Behavior Annex D.3.(C4) consistency rule failed");
		return false;
	}

	/**
	 * Document: AS5506/3 Rev A
	 * Type    : Consistency rule
	 * Section : D.3 Behavior Specification
	 * Object  : Threads and subprograms must not use external conditions; they describe their transitions with
	 * execute, dispatch, and internal conditions instead. The rule is cited by section rather than by number because
	 * the numbered rule list this class follows comes from the 0.94 draft, which orders the D.3 rules differently.
	 * Keys    : external condition thread subprogram component category
	 */
	public boolean D_3_External_Condition_Category_Check(BehaviorTransition bt) {
		if (!(bt.getCondition() instanceof ModeSwitchTriggerCondition)) {
			return true;
		}
		var category = _baParentContainer.getCategory();
		final String admitted;
		if (category == ComponentCategory.THREAD) {
			admitted = "an execute, dispatch, or internal condition";
		} else if (category == ComponentCategory.SUBPROGRAM) {
			admitted = "an execute or internal condition";
		} else {
			return true;
		}
		// The source state declaration is legal; the external condition is what the rule forbids here.
		reportConsistencyError(bt.getCondition(), category.getName() + " components cannot use an external condition: "
				+ admitted + " must be used instead: Behavior Annex D.3 consistency rule failed");
		return false;
	}

	/**
	 * Document: AS5506/3 Rev A
	 * Type    : Consistency rule
	 * Section : D.3 Behavior Specification
	 * Object  : For devices, the transitions out of a given complete state use either only external conditions or only
	 * dispatch conditions. Each condition of the state is equally part of the mixture, so each one is reported, the
	 * way every conflicting otherwise transition of a state is. Cited by section for the reason given on
	 * {@link #D_3_External_Condition_Category_Check(BehaviorTransition)}.
	 * Keys    : external condition dispatch condition device complete state
	 */
	public boolean D_3_Device_Condition_Check(BehaviorAnnex ba) {
		if (_baParentContainer.getCategory() != ComponentCategory.DEVICE) {
			return true;
		}
		Map<BehaviorState, List<BehaviorCondition>> external = new IdentityHashMap<>();
		Map<BehaviorState, List<BehaviorCondition>> dispatch = new IdentityHashMap<>();
		for (var transition : ba.getTransitions()) {
			var condition = transition.getCondition();
			final Map<BehaviorState, List<BehaviorCondition>> kind;
			if (condition instanceof ModeSwitchTriggerCondition) {
				kind = external;
			} else if (condition instanceof DispatchCondition) {
				kind = dispatch;
			} else {
				continue;
			}
			for (var source : BehaviorTransitionContext.getSourceStates(transition)) {
				if (source.isComplete()) {
					kind.computeIfAbsent(source, key -> new ArrayList<>()).add(condition);
				}
			}
		}

		var result = true;
		for (var state : ba.getStates()) {
			var externalConditions = external.get(state);
			var dispatchConditions = dispatch.get(state);
			if (externalConditions == null || dispatchConditions == null) {
				continue;
			}
			result = false;
			var conflicting = new ArrayList<>(externalConditions);
			conflicting.addAll(dispatchConditions);
			for (var condition : conflicting) {
				// Include the source name so distinct conflicts on a multi-source declaration remain visible.
				reportConsistencyError(condition, "The transitions out of complete state '" + state.getName()
						+ "' of a device must use either only external conditions or only dispatch conditions: "
						+ "Behavior Annex D.3 consistency rule failed");
			}
		}
		return result;
	}

	/**
	 * Returns the event triggers of an external condition, including those of its parenthesized groups. Like the
	 * dispatch trigger comparison this feeds, it reads the triggers without their logical operators, so the comparison
	 * with the mode transition triggers is about which events take part, not how they are combined.
	 */
	private static List<ActualPortHolder> getExternalConditionTriggers(
			ModeSwitchTriggerLogicalExpression expression) {
		var result = new ArrayList<ActualPortHolder>();
		collectExternalConditionTriggers(expression, result);
		return result;
	}

	private static String triggerName(ActualPortHolder port) {
		var name = new StringJoiner(".");
		if (port.getContext() != null) {
			name.add(port.getContext().getName());
		}
		for (var group : port.getGroupHolders()) {
			name.add(group.getElement().getName());
		}
		return name.add(port.getPort().getName()).toString();
	}

	private static void collectExternalConditionTriggers(ModeSwitchTriggerLogicalExpression expression,
			List<ActualPortHolder> result) {
		for (ModeSwitchConjunction conjunction : expression.getModeSwitchConjunctions()) {
			for (ModeSwitchTrigger trigger : conjunction.getModeSwitchTriggers()) {
				if (trigger instanceof ModeSwitchTriggerLogicalExpression group) {
					collectExternalConditionTriggers(group, result);
				} else if (trigger instanceof ActualPortHolder port) {
					result.add(port);
				}
			}
		}
	}

	// TODO Provide column number.
	private void reportConsistencyError(BehaviorElement obj, String msg) {
		_errManager.error(obj, msg + ".");
	}
}
