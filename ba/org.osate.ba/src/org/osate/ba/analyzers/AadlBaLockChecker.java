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

import static org.osate.ba.analyzers.AadlBaConsistencyRulesChecker.staticTruth;
import static org.osate.ba.analyzers.AadlBaConsistencyRulesChecker.StaticTruth.FALSE;
import static org.osate.ba.analyzers.AadlBaConsistencyRulesChecker.StaticTruth.TRUE;
import static org.osate.ba.analyzers.AadlBaConsistencyRulesChecker.StaticTruth.UNKNOWN;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.osate.aadl2.AccessType;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.ba.aadlba.BehaviorActionBlock;
import org.osate.ba.aadlba.BehaviorActionSequence;
import org.osate.ba.aadlba.BehaviorActionSet;
import org.osate.ba.aadlba.BehaviorActions;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorIntegerLiteral;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ba.aadlba.DataAccessHolder;
import org.osate.ba.aadlba.ElseStatement;
import org.osate.ba.aadlba.ForOrForAllStatement;
import org.osate.ba.aadlba.IfStatement;
import org.osate.ba.aadlba.IntegerRange;
import org.osate.ba.aadlba.LockAction;
import org.osate.ba.aadlba.Otherwise;
import org.osate.ba.aadlba.SharedDataAction;
import org.osate.ba.aadlba.ValueExpression;
import org.osate.ba.aadlba.WhileOrDoUntilStatement;
import org.osate.ba.utils.AadlBaVisitors;

/**
 * Checks AS5506/3 Rev. A D.6 resource release at complete states. Each required data access is tracked independently:
 * joins retain any possibly held lock, and unlocks kill that fact. Action summaries preserve the distinction between
 * leaving an incoming lock untouched and acquiring a new lock, which is necessary for unordered action sets.
 * Runtime-dependent guards and iteration bounds are conservative; this is not a symbolic execution of data values.
 * A second traversal excludes those assumptions to distinguish established violations from informational findings.
 * @since 9.0
 */
public final class AadlBaLockChecker {
	private final BehaviorAnnex annex;
	private final List<Resource> resources;
	private final AnalysisErrorReporterManager errorManager;

	public AadlBaLockChecker(BehaviorAnnex annex, ComponentClassifier owner,
			AnalysisErrorReporterManager errorManager) {
		this.annex = annex;
		var collected = new ArrayList<Resource>();
		collectResources(AadlBaVisitors.getParentComponent(annex, owner).getAllFeatures(), List.of(), false,
				new HashSet<>(), collected);
		resources = List.copyOf(collected);
		this.errorManager = errorManager;
	}

	private static void collectResources(List<Feature> features, List<FeatureGroup> groups, boolean inverse,
			Set<FeatureGroupType> activeTypes, List<Resource> result) {
		for (var feature : features) {
			if (feature instanceof DataAccess access && (access.getKind() == AccessType.REQUIRES) != inverse) {
				result.add(new Resource(access, groups));
			} else if (feature instanceof FeatureGroup group) {
				var type = group.getAllFeatureGroupType();
				if (type != null && activeTypes.add(type)) {
					var nestedGroups = new ArrayList<>(groups);
					nestedGroups.add(group);
					var nestedInverse = inverse ^ group.isInverse();
					// Match the feature inference used when instantiating an inverse feature group type.
					if (type.getOwnedFeatures().isEmpty() && type.getInverse() != null && type.getExtended() == null) {
						nestedInverse = !nestedInverse;
					}
					collectResources(type.getAllFeatures(), List.copyOf(nestedGroups), nestedInverse, activeTypes,
							result);
					activeTypes.remove(type);
				}
			}
		}
	}

	/** The group path distinguishes two features whose common group type declares the same data access. */
	private record Resource(DataAccess access, List<FeatureGroup> groups) {
		private String name() {
			return Stream.concat(groups.stream(), Stream.of(access))
					.map(NamedElement::getName)
					.collect(Collectors.joining("."));
		}

		private boolean matches(DataAccessHolder holder) {
			return holder.getDataAccess() == access
					&& holder.getGroupHolders().stream().map(group -> group.getElement()).toList().equals(groups);
		}
	}

	/** Reports held locks at complete states and returns false only for established violations. */
	public boolean check() {
		var valid = true;
		for (var resource : resources) {
			Map<BehaviorTransition, Effect> effects = new IdentityHashMap<>();
			for (var transition : annex.getTransitions()) {
				var effect = isDisabled(transition) ? Effect.NO_EXIT : summarize(transition.getActionBlock(), resource);
				effects.put(transition, effect);
			}
			var entries = findStateEntries(effects, false);
			var confirmedEntries = findStateEntries(effects, true);
			for (var transition : annex.getTransitions()) {
				var entry = entries.get(transition.getSourceState());
				var destination = transition.getDestinationState();
				var effect = effects.get(transition);
				if (entry != null && destination != null && destination.isComplete() && effect.canComplete()
						&& effect.apply(entry)) {
					var message = "Complete state '" + destination.getName() + "' may be reached while shared data '"
							+ resource.name() + "' remains locked: Behavior Annex D.6.";
					var confirmedEntry = confirmedEntries.get(transition.getSourceState());
					if (confirmedEntry != null && !isUncertain(transition, effect) && effect.apply(confirmedEntry)) {
						errorManager.error(transition, message);
						valid = false;
					} else {
						errorManager.info(transition, message);
					}
				}
			}
		}
		return valid;
	}

	private static boolean isDisabled(BehaviorTransition transition) {
		var condition = transition.getCondition();
		if (condition instanceof ValueExpression expression) {
			return staticTruth(expression) == FALSE;
		}
		if (condition instanceof Otherwise && transition.getSourceState() != null) {
			return transition.getSourceState()
					.getOutgoingTransitions()
					.stream()
					.anyMatch(other -> other != transition && (other.getCondition() == null
							|| other.getCondition() instanceof ValueExpression expression
									&& staticTruth(expression) == TRUE));
		}
		return false;
	}

	private static boolean isUncertain(BehaviorTransition transition, Effect effect) {
		if (effect.uncertain()) {
			return true;
		}
		var condition = transition.getCondition();
		if (condition instanceof ValueExpression expression) {
			return staticTruth(expression) == UNKNOWN;
		}
		if (condition instanceof Otherwise && transition.getSourceState() != null) {
			// An otherwise edge is known to be enabled only when every alternative is statically false.
			return transition.getSourceState()
					.getOutgoingTransitions()
					.stream()
					.anyMatch(
							other -> other != transition && !(other.getCondition() instanceof ValueExpression expression
									&& staticTruth(expression) == FALSE));
		}
		return false;
	}

	private Map<BehaviorState, Boolean> findStateEntries(Map<BehaviorTransition, Effect> effects,
			boolean confirmedOnly) {
		Map<BehaviorState, Boolean> entries = new IdentityHashMap<>();
		var work = new ArrayDeque<BehaviorState>();
		for (var state : annex.getStates()) {
			if (state.isInitial()) {
				entries.put(state, false);
				work.add(state);
			}
		}
		while (!work.isEmpty()) {
			var state = work.removeFirst();
			for (var transition : state.getOutgoingTransitions()) {
				var destination = transition.getDestinationState();
				var effect = effects.get(transition);
				if (destination == null || !effect.canComplete() || confirmedOnly && isUncertain(transition, effect)) {
					continue;
				}
				var outgoing = effect.apply(entries.get(state));
				var previous = entries.get(destination);
				if (previous == null || outgoing && !previous) {
					entries.put(destination, outgoing);
					work.add(destination);
				}
			}
		}
		return entries;
	}

	private Effect summarize(BehaviorActions actions, Resource resource) {
		if (actions instanceof BehaviorActionBlock block) {
			return summarize(block.getContent(), resource);
		}
		if (actions instanceof BehaviorActionSequence sequence) {
			var result = Effect.IDENTITY;
			for (var action : sequence.getActions()) {
				result = result.then(summarize(action, resource));
			}
			return result;
		}
		if (actions instanceof BehaviorActionSet set) {
			var result = Effect.IDENTITY;
			for (var action : set.getActions()) {
				result = result.parallel(summarize(action, resource));
			}
			return result;
		}
		if (actions instanceof SharedDataAction action) {
			if (action.getDataAccess() == null || resource.matches(action.getDataAccess())) {
				return action instanceof LockAction ? Effect.LOCK : Effect.UNLOCK;
			}
			return Effect.IDENTITY;
		}
		if (actions instanceof IfStatement conditional) {
			return summarizeConditional(conditional, resource);
		}
		if (actions instanceof WhileOrDoUntilStatement loop) {
			var condition = staticTruth(loop.getLogicalValueExpression());
			if (loop.isDoUntil()) {
				var body = summarize(loop.getBehaviorActions(), resource);
				return condition == FALSE ? Effect.NO_EXIT : condition == TRUE ? body : body.withUncertainty();
			}
			return switch (condition) {
			case FALSE -> Effect.IDENTITY;
			case TRUE -> Effect.NO_EXIT;
			case UNKNOWN -> Effect.IDENTITY.or(summarize(loop.getBehaviorActions(), resource)).withUncertainty();
			};
		}
		if (actions instanceof ForOrForAllStatement loop) {
			if (loop.getIteratedValues() instanceof IntegerRange range
					&& range.getLowerIntegerValue() instanceof BehaviorIntegerLiteral lower
					&& range.getUpperIntegerValue() instanceof BehaviorIntegerLiteral upper) {
				return lower.getValue() > upper.getValue() ? Effect.IDENTITY
						: summarize(loop.getBehaviorActions(), resource);
			}
			// An unknown range or collection can be empty. Repeating the body adds no new per-resource effects:
			// every terminating path either preserves the input, locks, or unlocks, and their union is idempotent.
			var body = summarize(loop.getBehaviorActions(), resource);
			return body.equals(Effect.IDENTITY) ? body : Effect.IDENTITY.or(body).withUncertainty();
		}
		return Effect.IDENTITY;
	}

	private Effect summarizeConditional(IfStatement conditional, Resource resource) {
		var condition = staticTruth(conditional.getLogicalValueExpression());
		var thenEffect = condition == FALSE ? Effect.NO_EXIT : summarize(conditional.getBehaviorActions(), resource);
		if (condition == TRUE) {
			return thenEffect;
		}
		var alternative = conditional.getElseStatement();
		var elseEffect = alternative instanceof IfStatement elseIf ? summarizeConditional(elseIf, resource)
				: alternative instanceof ElseStatement elseStatement
						? summarize(elseStatement.getBehaviorActions(), resource)
						: Effect.IDENTITY;
		if (condition == FALSE) {
			return elseEffect;
		}
		return thenEffect.equals(elseEffect) ? thenEffect : thenEffect.or(elseEffect).withUncertainty();
	}

	/**
	 * The may-lock transfer function is {@code locks || (preserves && incoming)}. A separate completion bit distinguishes
	 * an unlock from a path that never reaches its successor. Summaries describe only paths that complete. Uncertainty
	 * records a dependency on runtime choices; such paths contribute informational findings, not validation errors.
	 */
	private record Effect(boolean preserves, boolean locks, boolean canComplete, boolean uncertain) {
		private static final Effect IDENTITY = new Effect(true, false, true, false);
		private static final Effect LOCK = new Effect(false, true, true, false);
		private static final Effect UNLOCK = new Effect(false, false, true, false);
		private static final Effect NO_EXIT = new Effect(false, false, false, false);

		private Effect withUncertainty() {
			return new Effect(preserves, locks, canComplete, true);
		}

		private boolean apply(boolean incoming) {
			return locks || preserves && incoming;
		}

		private Effect then(Effect next) {
			return canComplete && next.canComplete
					? new Effect(preserves && next.preserves, next.apply(locks), true, uncertain || next.uncertain)
					: NO_EXIT;
		}

		private Effect or(Effect alternative) {
			return new Effect(preserves || alternative.preserves, locks || alternative.locks,
					canComplete || alternative.canComplete, uncertain || alternative.uncertain);
		}

		private Effect parallel(Effect other) {
			// The final operation on this resource can come from either member, including interleaved sequences.
			// An incoming lock survives untouched only if every member has a path that leaves it untouched.
			return canComplete && other.canComplete
					? new Effect(preserves && other.preserves, locks || other.locks, true, uncertain || other.uncertain)
					: NO_EXIT;
		}
	}
}
