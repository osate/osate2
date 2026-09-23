/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ba.analyzers;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.ba.aadlba.AssignmentAction;
import org.osate.ba.aadlba.BehaviorActionBlock;
import org.osate.ba.aadlba.BehaviorActionSequence;
import org.osate.ba.aadlba.BehaviorActionSet;
import org.osate.ba.aadlba.BehaviorActions;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ba.aadlba.BehaviorVariable;
import org.osate.ba.aadlba.BehaviorVariableHolder;
import org.osate.ba.aadlba.DataComponentReference;
import org.osate.ba.aadlba.ElseStatement;
import org.osate.ba.aadlba.ForOrForAllStatement;
import org.osate.ba.aadlba.IfStatement;
import org.osate.ba.aadlba.IndexableElement;
import org.osate.ba.aadlba.InternalPortSendAction;
import org.osate.ba.aadlba.ParameterLabel;
import org.osate.ba.aadlba.PortDequeueAction;
import org.osate.ba.aadlba.PortSendAction;
import org.osate.ba.aadlba.PropertyReference;
import org.osate.ba.aadlba.SubprogramCallAction;
import org.osate.ba.aadlba.Target;
import org.osate.ba.aadlba.ValueExpression;
import org.osate.ba.aadlba.WhileOrDoUntilStatement;

/**
 * Performs the declarative part of AS5506/3 Rev. A D.7 definite-initialization analysis. Local behavior variables are
 * tracked through action control flow and the behavior-state graph. Data-component initialization through a prefixed
 * {@code Data_Model::Initial_Value} is instance-dependent and deliberately remains outside this checker.
 * @since 9.0
 */
public final class AadlBaInitializationChecker {
	private static final String INITIAL_VALUE = "Data_Model::Initial_Value";

	private final BehaviorAnnex annex;
	private final AnalysisErrorReporterManager errorManager;

	public AadlBaInitializationChecker(BehaviorAnnex annex, AnalysisErrorReporterManager errorManager) {
		this.annex = annex;
		this.errorManager = errorManager;
	}

	/** Checks every reachable read and returns whether all tracked variables were definitely initialized. */
	public boolean check() {
		var initial = identitySet();
		annex.getVariables().stream().filter(AadlBaInitializationChecker::hasInitializer).forEach(initial::add);
		var stateEntries = findStateEntries(initial);
		var valid = new boolean[] { true };
		for (var transition : annex.getTransitions()) {
			var entry = stateEntries.get(transition.getSourceState());
			if (entry != null) {
				checkReads(transition.getCondition(), entry, valid);
				transfer(transition.getActionBlock(), entry, true, valid);
			}
		}
		return valid[0];
	}

	private Map<BehaviorState, Set<BehaviorVariable>> findStateEntries(Set<BehaviorVariable> initial) {
		Map<BehaviorState, Set<BehaviorVariable>> entries = new IdentityHashMap<>();
		var work = new ArrayDeque<BehaviorState>();
		for (var state : annex.getStates()) {
			if (state.isInitial()) {
				entries.put(state, copy(initial));
				work.add(state);
			}
		}
		while (!work.isEmpty()) {
			var state = work.removeFirst();
			var entry = entries.get(state);
			for (var transition : state.getOutgoingTransitions()) {
				var destination = transition.getDestinationState();
				if (destination == null) {
					continue;
				}
				var outgoing = transfer(transition.getActionBlock(), entry, false, new boolean[] { true });
				var previous = entries.get(destination);
				if (previous == null) {
					entries.put(destination, outgoing);
					work.add(destination);
				} else {
					var merged = copy(previous);
					merged.retainAll(outgoing);
					if (!merged.equals(previous)) {
						entries.put(destination, merged);
						work.add(destination);
					}
				}
			}
		}
		return entries;
	}

	private Set<BehaviorVariable> transfer(BehaviorActions actions, Set<BehaviorVariable> incoming, boolean report,
			boolean[] valid) {
		if (actions == null) {
			return copy(incoming);
		}
		if (actions instanceof BehaviorActionBlock block) {
			return transfer(block.getContent(), incoming, report, valid);
		}
		if (actions instanceof BehaviorActionSequence sequence) {
			var result = copy(incoming);
			for (var action : sequence.getActions()) {
				result = transfer(action, result, report, valid);
			}
			return result;
		}
		if (actions instanceof BehaviorActionSet set) {
			var result = copy(incoming);
			for (var action : set.getActions()) {
				result.addAll(transfer(action, incoming, report, valid));
			}
			return result;
		}
		if (actions instanceof AssignmentAction assignment) {
			checkReads(assignment.getValueExpression(), incoming, report ? valid : null);
			checkTargetIndexes(assignment.getTarget(), incoming, report ? valid : null);
			var result = copy(incoming);
			var written = wholeVariable(assignment.getTarget());
			if (written != null) {
				result.add(written);
			}
			return result;
		}
		if (actions instanceof PortDequeueAction dequeue) {
			checkTargetIndexes(dequeue.getTarget(), incoming, report ? valid : null);
			var result = copy(incoming);
			var written = wholeVariable(dequeue.getTarget());
			if (written != null) {
				result.add(written);
			}
			return result;
		}
		if (actions instanceof PortSendAction send) {
			checkReads(send.getValueExpression(), incoming, report ? valid : null);
			return copy(incoming);
		}
		if (actions instanceof InternalPortSendAction send) {
			checkReads(send.getValueExpression(), incoming, report ? valid : null);
			return copy(incoming);
		}
		if (actions instanceof SubprogramCallAction call) {
			var result = copy(incoming);
			for (ParameterLabel parameter : call.getParameterLabels()) {
				if (parameter instanceof ValueExpression expression) {
					checkReads(expression, incoming, report ? valid : null);
				} else if (parameter instanceof Target target) {
					checkTargetIndexes(target, incoming, report ? valid : null);
					var written = wholeVariable(target);
					if (written != null) {
						result.add(written);
					}
				}
			}
			return result;
		}
		if (actions instanceof IfStatement conditional) {
			return transferConditional(conditional, incoming, report, valid);
		}
		if (actions instanceof WhileOrDoUntilStatement loop) {
			if (loop.isDoUntil()) {
				var afterBody = transfer(loop.getBehaviorActions(), incoming, report, valid);
				checkReads(loop.getLogicalValueExpression(), afterBody, report ? valid : null);
				return afterBody;
			}
			checkReads(loop.getLogicalValueExpression(), incoming, report ? valid : null);
			transfer(loop.getBehaviorActions(), incoming, report, valid);
			return copy(incoming);
		}
		if (actions instanceof ForOrForAllStatement loop) {
			checkReads(loop.getIteratedValues(), incoming, report ? valid : null);
			transfer(loop.getBehaviorActions(), incoming, report, valid);
			return copy(incoming);
		}
		return copy(incoming);
	}

	private Set<BehaviorVariable> transferConditional(IfStatement conditional, Set<BehaviorVariable> incoming,
			boolean report, boolean[] valid) {
		checkReads(conditional.getLogicalValueExpression(), incoming, report ? valid : null);
		var result = transfer(conditional.getBehaviorActions(), incoming, report, valid);
		var alternative = conditional.getElseStatement();
		Set<BehaviorVariable> alternativeResult;
		if (alternative instanceof IfStatement elseIf) {
			alternativeResult = transferConditional(elseIf, incoming, report, valid);
		} else if (alternative instanceof ElseStatement elseStatement) {
			alternativeResult = transfer(elseStatement.getBehaviorActions(), incoming, report, valid);
		} else {
			alternativeResult = incoming;
		}
		result.retainAll(alternativeResult);
		return result;
	}

	private void checkTargetIndexes(Target target, Set<BehaviorVariable> initialized, boolean[] valid) {
		if (target == null) {
			return;
		}
		if (target instanceof IndexableElement indexable) {
			indexable.getArrayIndexes().forEach(index -> checkReads(index, initialized, valid));
		}
		if (target instanceof DataComponentReference reference) {
			for (var holder : reference.getData()) {
				if (holder instanceof IndexableElement indexable) {
					indexable.getArrayIndexes().forEach(index -> checkReads(index, initialized, valid));
				}
			}
		}
	}

	private void checkReads(EObject object, Set<BehaviorVariable> initialized, boolean[] valid) {
		if (object == null || object instanceof PropertyReference) {
			return;
		}
		var variable = readVariable(object);
		if (variable != null && !initialized.contains(variable) && valid != null) {
			errorManager.error((org.osate.aadl2.Element) object,
					"Behavior variable '" + variable.getName() + "' may be read before it is initialized");
			valid[0] = false;
		}
		for (var child : object.eContents()) {
			checkReads(child, initialized, valid);
		}
	}

	private static BehaviorVariable readVariable(EObject object) {
		if (object instanceof DataComponentReference reference && !reference.getData().isEmpty()
				&& reference.getData().getFirst().getElement() instanceof BehaviorVariable variable) {
			return variable;
		}
		if (object instanceof BehaviorVariableHolder holder && !(holder.eContainer() instanceof DataComponentReference)) {
			return holder.getBehaviorVariable();
		}
		return null;
	}

	private static BehaviorVariable wholeVariable(Target target) {
		return target instanceof BehaviorVariableHolder holder && holder.getArrayIndexes().isEmpty()
				? holder.getBehaviorVariable()
				: null;
	}

	private static boolean hasInitializer(BehaviorVariable variable) {
		if (variable.getOwnedValueConstant() != null) {
			return true;
		}
		for (PropertyAssociation association : variable.getOwnedPropertyAssociations()) {
			if (association.getProperty() != null
					&& INITIAL_VALUE.equalsIgnoreCase(association.getProperty().getQualifiedName())) {
				return true;
			}
		}
		return false;
	}

	private static Set<BehaviorVariable> identitySet() {
		return Collections.newSetFromMap(new IdentityHashMap<>());
	}

	private static Set<BehaviorVariable> copy(Set<BehaviorVariable> source) {
		var result = identitySet();
		result.addAll(source);
		return result;
	}
}
