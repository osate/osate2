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
package org.osate.xtext.aadl2.ba.translation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AccessCategory;
import org.osate.aadl2.AccessSpecification;
import org.osate.aadl2.ArrayDimension;
import org.osate.aadl2.ArraySize;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.EventPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeaturePrototype;
import org.osate.aadl2.FeaturePrototypeBinding;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.Port;
import org.osate.aadl2.PortSpecification;
import org.osate.aadl2.ProcessorClassifier;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.RecordType;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.aadl2.SubprogramPrototype;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.SubprogramType;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.ba.aadlba.AadlBaFactory;
import org.osate.ba.aadlba.ActualPortHolder;
import org.osate.ba.aadlba.BehaviorAction;
import org.osate.ba.aadlba.BehaviorActions;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorElement;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ba.aadlba.BehaviorVariable;
import org.osate.ba.aadlba.BinaryAddingOperator;
import org.osate.ba.aadlba.BinaryNumericOperator;
import org.osate.ba.aadlba.CalledSubprogramHolder;
import org.osate.ba.aadlba.DataComponentReference;
import org.osate.ba.aadlba.DataHolder;
import org.osate.ba.aadlba.DataRepresentation;
import org.osate.ba.aadlba.DispatchConjunction;
import org.osate.ba.aadlba.DispatchTrigger;
import org.osate.ba.aadlba.ElementHolder;
import org.osate.ba.aadlba.ElementValues;
import org.osate.ba.aadlba.ElseStatement;
import org.osate.ba.aadlba.Factor;
import org.osate.ba.aadlba.GroupHolder;
import org.osate.ba.aadlba.GroupableElement;
import org.osate.ba.aadlba.IndexableElement;
import org.osate.ba.aadlba.LogicalOperator;
import org.osate.ba.aadlba.MultiplyingOperator;
import org.osate.ba.aadlba.ParameterLabel;
import org.osate.ba.aadlba.PropertyElementHolder;
import org.osate.ba.aadlba.PropertyNameHolder;
import org.osate.ba.aadlba.Relation;
import org.osate.ba.aadlba.RelationalOperator;
import org.osate.ba.aadlba.SimpleExpression;
import org.osate.ba.aadlba.Target;
import org.osate.ba.aadlba.Term;
import org.osate.ba.aadlba.UnaryAddingOperator;
import org.osate.ba.aadlba.UnaryBooleanOperator;
import org.osate.ba.aadlba.UnaryNumericOperator;
import org.osate.ba.aadlba.Value;
import org.osate.ba.aadlba.ValueConstant;
import org.osate.ba.aadlba.ValueExpression;
import org.osate.ba.utils.AadlBaUtils;
import org.osate.utils.internal.Aadl2Visitors;
import org.osate.utils.internal.Aadl2Utils;
import org.osate.utils.internal.PropertyUtils;
import org.osate.utils.internal.names.DataModelProperties;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ArrayIndex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.AssignmentAction;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionBlock;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionSequence;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionSet;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorBooleanLiteral;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorCondition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorIntegerLiteral;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorPropertyAssociation;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorRealLiteral;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStateGroup;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStringLiteral;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTime;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariableGroup;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BinaryExpression;
import org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction;
import org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchCondition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.DoUntilStatement;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ExecuteCondition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement;
import org.osate.xtext.aadl2.ba.behaviorAnnex.HashPropertyReference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement;
import org.osate.xtext.aadl2.ba.behaviorAnnex.IntegerValue;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ModeSwitchCondition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.NamedPropertyField;
import org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyArrayIndex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyIndexPropertyReference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyIndexValue;
import org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyReferenceTail;
import org.osate.xtext.aadl2.ba.behaviorAnnex.Reference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceSegment;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceTail;
import org.osate.xtext.aadl2.ba.behaviorAnnex.TimedAction;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnaryExpression;
import org.osate.xtext.aadl2.ba.behaviorAnnex.WhileStatement;

/**
 * Builds the public strict BA model from the stable Xtext parse model. Translation is additive: it never reparents or
 * mutates a declarative object. Each strict object is traced to the declarative object that supplied its syntax, while
 * each declarative object identifies its primary strict counterpart.
 */
public final class DeclarativeToStrictTranslator {
	private static final AadlBaFactory FACTORY = AadlBaFactory.eINSTANCE;
	private static final String LEGACY_ANNEX_NAME = "behavior_specification";

	/**
	 * Translates and caches one declarative subclause. Any notification below the declarative root invalidates the cached
	 * result; unloading the resource releases the root and its attached cache together.
	 *
	 * @param source linked Xtext Behavior Annex
	 * @param owner component classifier containing the annex
	 * @return strict model and identity-based traces
	 */
	public TranslationResult translate(
			final org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex source,
			final ComponentClassifier owner) {
		Objects.requireNonNull(source, "source");
		Objects.requireNonNull(owner, "owner");
		TranslationCache cache = (TranslationCache) EcoreUtil.getExistingAdapter(source, TranslationCache.class);
		if (cache == null) {
			cache = new TranslationCache();
			source.eAdapters().add(cache);
		}
		if (cache.result != null && cache.owner == owner) {
			return cache.result;
		}

		final Builder builder = new Builder(source, owner);
		cache.owner = owner;
		cache.result = builder.translate();
		return cache.result;
	}

	/** Translation output and immutable identity maps in both directions. */
	public static final class TranslationResult {
		private final BehaviorAnnex strictAnnex;
		private final Map<EObject, EObject> declarativeToStrict;
		private final Map<EObject, EObject> strictToDeclarative;

		private TranslationResult(final BehaviorAnnex strictAnnex, final Map<EObject, EObject> declarativeToStrict,
				final Map<EObject, EObject> strictToDeclarative) {
			this.strictAnnex = strictAnnex;
			this.declarativeToStrict = Collections.unmodifiableMap(new IdentityHashMap<>(declarativeToStrict));
			this.strictToDeclarative = Collections.unmodifiableMap(new IdentityHashMap<>(strictToDeclarative));
		}

		public BehaviorAnnex getStrictAnnex() {
			return strictAnnex;
		}

		public EObject getStrict(final EObject declarative) {
			return declarativeToStrict.get(declarative);
		}

		public EObject getDeclarative(final EObject strict) {
			return strictToDeclarative.get(strict);
		}

		public Map<EObject, EObject> getDeclarativeToStrictTrace() {
			return declarativeToStrict;
		}

		public Map<EObject, EObject> getStrictToDeclarativeTrace() {
			return strictToDeclarative;
		}
	}

	private static final class TranslationCache extends EContentAdapter {
		private ComponentClassifier owner;
		private TranslationResult result;

		@Override
		public void notifyChanged(final Notification notification) {
			super.notifyChanged(notification);
			result = null;
		}

		@Override
		public boolean isAdapterForType(final Object type) {
			return type == TranslationCache.class;
		}
	}

	private static final class Builder {
		private final org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex source;
		private final ComponentClassifier owner;
		private final IdentityHashMap<EObject, EObject> declarativeToStrict = new IdentityHashMap<>();
		private final IdentityHashMap<EObject, EObject> strictToDeclarative = new IdentityHashMap<>();
		private final IdentityHashMap<org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorState, BehaviorState> states =
				new IdentityHashMap<>();
		private final Map<String, BehaviorVariable> variables = new java.util.TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		private final List<Map<String, org.osate.ba.aadlba.IterativeVariable>> iterativeScopes = new ArrayList<>();
		private final java.util.Set<EObject> consumedParentheses = Collections.newSetFromMap(new IdentityHashMap<>());
		private final IdentityHashMap<EObject, List<ElementHolder>> resolvedPaths = new IdentityHashMap<>();
		private final IdentityHashMap<EObject, NamedElement> resolvedReferences = new IdentityHashMap<>();

		private Builder(final org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex source,
				final ComponentClassifier owner) {
			this.source = source;
			this.owner = owner;
		}

		private TranslationResult translate() {
			final BehaviorAnnex strict = trace(FACTORY.createBehaviorAnnex(), source);
			strict.setName(LEGACY_ANNEX_NAME);
			translateVariables(strict);
			translateStates(strict);
			translateTransitions(strict);
			return new TranslationResult(strict, declarativeToStrict, strictToDeclarative);
		}

		private void translateVariables(final BehaviorAnnex strict) {
			for (final BehaviorVariableGroup group : source.getVariableGroups()) {
				for (final org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariable variable : group.getVariables()) {
					final BehaviorVariable result = trace(FACTORY.createBehaviorVariable(), variable);
					result.setName(variable.getName());
					if (group.getDataClassifier() instanceof DataClassifier) {
						result.setDataClassifier((DataClassifier) group.getDataClassifier());
					}
					for (final org.osate.xtext.aadl2.ba.behaviorAnnex.ArrayDimension dimension : variable
							.getArrayDimensions()) {
						final ArrayDimension arrayDimension = trace(Aadl2Factory.eINSTANCE.createArrayDimension(), dimension);
						final ArraySize size = Aadl2Factory.eINSTANCE.createArraySize();
						trace(size, dimension);
						size.setSize(0);
						arrayDimension.setSize(size);
						result.getArrayDimensions().add(arrayDimension);
					}
					if (group.getInitialValue() != null) {
						result.setOwnedValueConstant(toValueConstant(group.getInitialValue()));
					}
					for (final BehaviorPropertyAssociation association : group.getPropertyAssociations()) {
						result.getOwnedPropertyAssociations().add(toPropertyAssociation(association));
					}
					strict.getVariables().add(result);
					variables.put(result.getName(), result);
				}
			}
		}

		private PropertyAssociation toPropertyAssociation(final BehaviorPropertyAssociation sourceAssociation) {
			final PropertyAssociation result = trace(Aadl2Factory.eINSTANCE.createPropertyAssociation(), sourceAssociation);
			result.setProperty(sourceAssociation.getProperty());
			final ModalPropertyValue value = Aadl2Factory.eINSTANCE.createModalPropertyValue();
			trace(value, sourceAssociation);
			final PropertyExpression expression = EcoreUtil.copy(sourceAssociation.getOwnedValue());
			traceTree(expression, sourceAssociation);
			value.setOwnedValue(expression);
			result.getOwnedValues().add(value);
			return result;
		}

		private void translateStates(final BehaviorAnnex strict) {
			for (final BehaviorStateGroup group : source.getStateGroups()) {
				for (final org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorState state : group.getStates()) {
					final BehaviorState result = trace(FACTORY.createBehaviorState(), state);
					result.setName(state.getName());
					result.setInitial(group.isInitial());
					result.setComplete(group.isComplete());
					result.setFinal(group.isFinal());
					strict.getStates().add(result);
					states.put(state, result);
					if (group.isInitial() && strict.getInitialState() == null) {
						strict.setInitialState(result);
					}
				}
			}
		}

		private void translateTransitions(final BehaviorAnnex strict) {
			for (final BehaviorTransition transition : source.getTransitions()) {
				for (int sourceIndex = 0; sourceIndex < transition.getSourceStates().size(); sourceIndex++) {
					final var sourceState = transition.getSourceStates().get(sourceIndex);
					final org.osate.ba.aadlba.BehaviorTransition result = trace(FACTORY.createBehaviorTransition(),
							transition);
					result.setName(transition.getName());
					result.setPriority(parseInteger(transition.getPriority(), -1));
					result.setSourceState(states.get(sourceState));
					result.setDestinationState(states.get(transition.getDestinationState()));
					if (sourceIndex == 0 && transition.getCondition() != null) {
						final org.osate.ba.aadlba.BehaviorCondition condition = toCondition(transition.getCondition());
						if (condition != null) {
							strict.getConditions().add(condition);
							result.setCondition(condition);
						}
					}
					if (sourceIndex == 0 && transition.getActionBlock() != null) {
						final org.osate.ba.aadlba.BehaviorActionBlock actionBlock = toActionBlock(
								transition.getActionBlock());
						strict.getActions().add(actionBlock);
						result.setActionBlock(actionBlock);
					}
					strict.getTransitions().add(result);
				}
			}
		}

		private org.osate.ba.aadlba.BehaviorCondition toCondition(final BehaviorCondition condition) {
			if (condition.getExecute() != null) {
				return toExecuteCondition(condition.getExecute(), condition);
			}
			if (condition.getDispatch() != null) {
				return toDispatchCondition(condition.getDispatch(), condition);
			}
			if (condition.getModeSwitch() != null) {
				return toModeSwitchCondition(condition.getModeSwitch(), condition);
			}
			final var node = NodeModelUtils.findActualNodeFor(condition);
			return node != null && node.getText().stripLeading().toLowerCase(java.util.Locale.ROOT).startsWith("on dispatch")
					? trace(FACTORY.createDispatchCondition(), condition)
					: null;
		}

		private org.osate.ba.aadlba.BehaviorCondition toExecuteCondition(final ExecuteCondition execute,
				final EObject traceSource) {
			if (execute.getValue() != null) {
				return trace(toValueExpression(execute.getValue()), traceSource);
			}
			if (execute.isOtherwise()) {
				return trace(FACTORY.createOtherwise(), traceSource);
			}
			return trace(FACTORY.createExecutionTimeoutCatch(), traceSource);
		}

		private org.osate.ba.aadlba.DispatchCondition toDispatchCondition(final DispatchCondition dispatch,
				final EObject traceSource) {
			final org.osate.ba.aadlba.DispatchCondition result = trace(FACTORY.createDispatchCondition(), traceSource);
			if (dispatch.getTrigger() != null) {
				final var trigger = dispatch.getTrigger();
				if (trigger.getExpression() != null) {
					final var sourceConjunctions = trigger.getExpression().getConjunctions();
					if (sourceConjunctions.size() == 1 && sourceConjunctions.getFirst().getTriggers().size() == 1) {
						final BehaviorElement resolved = toReferenceValue(
								sourceConjunctions.getFirst().getTriggers().getFirst());
						if (resolved instanceof org.osate.ba.aadlba.DispatchTriggerCondition condition
								&& !(resolved instanceof DispatchTrigger)) {
							result.setDispatchTriggerCondition(condition);
							return result;
						}
					}
					final org.osate.ba.aadlba.DispatchTriggerLogicalExpression expression = trace(
							FACTORY.createDispatchTriggerLogicalExpression(), trigger);
					for (final org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchConjunction sourceConjunction : trigger
							.getExpression().getConjunctions()) {
						final DispatchConjunction conjunction = trace(FACTORY.createDispatchConjunction(),
								sourceConjunction);
						for (final Reference reference : sourceConjunction.getTriggers()) {
							final var resolvedTrigger = toReferenceValue(reference);
							if (resolvedTrigger instanceof DispatchTrigger dispatchTrigger) {
								conjunction.getDispatchTriggers().add(dispatchTrigger);
							}
						}
						expression.getDispatchConjunctions().add(conjunction);
					}
					result.setDispatchTriggerCondition(expression);
				} else if (trigger.isStop()) {
					result.setDispatchTriggerCondition(trace(FACTORY.createDispatchTriggerConditionStop(), trigger));
				} else if (trigger.isTimeout() && trigger.getTime() != null) {
					final org.osate.ba.aadlba.CompletionRelativeTimeout timeout = trace(
							FACTORY.createCompletionRelativeTimeout(), trigger);
					copyTime(trigger.getTime(), timeout);
					result.setDispatchTriggerCondition(timeout);
				} else if (trigger.isTimeout()) {
					result.setDispatchTriggerCondition(trace(FACTORY.createDispatchRelativeTimeout(), trigger));
				}
			}
			for (final Reference frozen : dispatch.getFrozenPorts()) {
				result.getFrozenPorts().add((ActualPortHolder) toReferenceValue(frozen));
			}
			return result;
		}

		private org.osate.ba.aadlba.BehaviorCondition toModeSwitchCondition(final ModeSwitchCondition condition,
				final EObject traceSource) {
			final org.osate.ba.aadlba.ModeSwitchTriggerLogicalExpression result = trace(
					FACTORY.createModeSwitchTriggerLogicalExpression(), traceSource);
			for (final org.osate.xtext.aadl2.ba.behaviorAnnex.ModeSwitchConjunction sourceConjunction : condition
					.getConjunctions()) {
				final org.osate.ba.aadlba.ModeSwitchConjunction conjunction = trace(
						FACTORY.createModeSwitchConjunction(), sourceConjunction);
				for (final Reference reference : sourceConjunction.getTriggers()) {
					final var resolvedTrigger = toReferenceValue(reference);
					if (resolvedTrigger instanceof org.osate.ba.aadlba.ModeSwitchTrigger modeSwitchTrigger) {
						conjunction.getModeSwitchTriggers().add(modeSwitchTrigger);
					}
				}
				result.getModeSwitchConjunctions().add(conjunction);
			}
			return result;
		}

		private org.osate.ba.aadlba.BehaviorActionBlock toActionBlock(final BehaviorActionBlock actionBlock) {
			if (actionBlock == null) {
				return FACTORY.createBehaviorActionBlock();
			}
			final org.osate.ba.aadlba.BehaviorActionBlock result = trace(FACTORY.createBehaviorActionBlock(), actionBlock);
			result.setContent(toActions(actionBlock.getContent()));
			if (actionBlock.getTimeout() != null) {
				result.setTimeout(toTime(actionBlock.getTimeout()));
			}
			return result;
		}

		private BehaviorActions toActions(
				final org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActions actions) {
			if (actions instanceof BehaviorActionSequence) {
				final org.osate.ba.aadlba.BehaviorActionSequence result = trace(
						FACTORY.createBehaviorActionSequence(), actions);
				for (final org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAction action : ((BehaviorActionSequence) actions)
						.getActions()) {
					result.getActions().add(toAction(action));
				}
				return result;
			}
			if (actions instanceof BehaviorActionSet) {
				final org.osate.ba.aadlba.BehaviorActionSet result = trace(FACTORY.createBehaviorActionSet(), actions);
				for (final org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAction action : ((BehaviorActionSet) actions)
						.getActions()) {
					result.getActions().add(toAction(action));
				}
				return result;
			}
			return toAction((org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAction) actions);
		}

		private BehaviorAction toAction(final org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAction action) {
			if (action instanceof AssignmentAction) {
				final AssignmentAction assignment = (AssignmentAction) action;
				final org.osate.ba.aadlba.AssignmentAction result = trace(FACTORY.createAssignmentAction(), action);
				final BehaviorElement target = toReferenceValue(assignment.getTarget());
				if (target instanceof Target validTarget) {
					result.setTarget(validTarget);
				}
				result.setValueExpression(assignment.isAny() ? trace(FACTORY.createAny(), assignment)
						: toValueExpression(assignment.getValue()));
				return result;
			}
			if (action instanceof CommunicationAction) {
				return toCommunicationAction((CommunicationAction) action);
			}
			if (action instanceof TimedAction) {
				final TimedAction timed = (TimedAction) action;
				final org.osate.ba.aadlba.TimedAction result = trace(FACTORY.createTimedAction(), action);
				result.setLowerTime(toTime(timed.getLowerTime()));
				if (timed.getUpperTime() != null) {
					result.setUpperTime(toTime(timed.getUpperTime()));
				}
				for (final ComponentClassifier processor : timed.getProcessors()) {
					if (processor instanceof ProcessorClassifier) {
						result.getProcessorClassifier().add((ProcessorClassifier) processor);
					}
				}
				return result;
			}
			if (action instanceof IfStatement) {
				return toIfStatement((IfStatement) action, false);
			}
			if (action instanceof ForStatement) {
				return toForStatement((ForStatement) action);
			}
			if (action instanceof WhileStatement) {
				final WhileStatement whileStatement = (WhileStatement) action;
				final org.osate.ba.aadlba.WhileOrDoUntilStatement result = trace(
						FACTORY.createWhileOrDoUntilStatement(), action);
				result.setDoUntil(false);
				result.setLogicalValueExpression(toValueExpression(whileStatement.getCondition()));
				result.setBehaviorActions(toActions(whileStatement.getActions()));
				return result;
			}
			if (action instanceof DoUntilStatement) {
				final DoUntilStatement doUntil = (DoUntilStatement) action;
				final org.osate.ba.aadlba.WhileOrDoUntilStatement result = trace(
						FACTORY.createWhileOrDoUntilStatement(), action);
				result.setDoUntil(true);
				result.setLogicalValueExpression(toValueExpression(doUntil.getCondition()));
				result.setBehaviorActions(toActions(doUntil.getActions()));
				return result;
			}
			return toActionBlock((BehaviorActionBlock) action);
		}

		private org.osate.ba.aadlba.IfStatement toIfStatement(final IfStatement statement, final boolean elif) {
			final org.osate.ba.aadlba.IfStatement result = trace(FACTORY.createIfStatement(), statement);
			result.setElif(elif);
			result.setLogicalValueExpression(toValueExpression(statement.getCondition()));
			result.setBehaviorActions(toActions(statement.getThenActions()));
			ElseStatement tail = null;
			for (int i = statement.getElseIfs().size() - 1; i >= 0; i--) {
				final var clause = statement.getElseIfs().get(i);
				final org.osate.ba.aadlba.IfStatement nested = trace(FACTORY.createIfStatement(), clause);
				nested.setElif(true);
				nested.setLogicalValueExpression(toValueExpression(clause.getCondition()));
				nested.setBehaviorActions(toActions(clause.getActions()));
				nested.setElseStatement(tail);
				tail = nested;
			}
			if (statement.getElseActions() != null) {
				final ElseStatement elseStatement = trace(FACTORY.createElseStatement(), statement.getElseActions());
				elseStatement.setBehaviorActions(toActions(statement.getElseActions()));
				if (tail == null) {
					tail = elseStatement;
				} else {
					ElseStatement current = tail;
					while (current instanceof org.osate.ba.aadlba.IfStatement
							&& ((org.osate.ba.aadlba.IfStatement) current).getElseStatement() != null) {
						current = ((org.osate.ba.aadlba.IfStatement) current).getElseStatement();
					}
					((org.osate.ba.aadlba.IfStatement) current).setElseStatement(elseStatement);
				}
			}
			result.setElseStatement(tail);
			return result;
		}

		private org.osate.ba.aadlba.ForOrForAllStatement toForStatement(final ForStatement statement) {
			final org.osate.ba.aadlba.ForOrForAllStatement result = trace(FACTORY.createForOrForAllStatement(), statement);
			result.setForAll(statement.isForall());
			final org.osate.ba.aadlba.IterativeVariable variable = trace(FACTORY.createIterativeVariable(), statement);
			variable.setName(statement.getVariable());
			if (statement.getDataClassifier() instanceof DataClassifier) {
				variable.setDataClassifier((DataClassifier) statement.getDataClassifier());
			}
			result.setIterativeVariable(variable);
			final Map<String, org.osate.ba.aadlba.IterativeVariable> scope = new java.util.TreeMap<>(
					String.CASE_INSENSITIVE_ORDER);
			scope.put(variable.getName(), variable);
			iterativeScopes.add(scope);
			try {
				if (statement.getValues() != null) {
					result.setIteratedValues(toElementValues(statement.getValues()));
				}
				result.setBehaviorActions(toActions(statement.getActions()));
			} finally {
				iterativeScopes.remove(iterativeScopes.size() - 1);
			}
			return result;
		}

		private ElementValues toElementValues(final org.osate.xtext.aadl2.ba.behaviorAnnex.ElementValues values) {
			if (values.getUpper() == null) {
				return (ElementValues) toIntegerValue(values.getLower());
			}
			final org.osate.ba.aadlba.IntegerRange result = trace(FACTORY.createIntegerRange(), values);
			result.setLowerIntegerValue(toIntegerValue(values.getLower()));
			result.setUpperIntegerValue(toIntegerValue(values.getUpper()));
			return result;
		}

		private BehaviorAction toCommunicationAction(final CommunicationAction action) {
			if (action.isAllLock() || action.isAllUnlock()) {
				return action.isAllLock() ? trace(FACTORY.createLockAction(), action)
						: trace(FACTORY.createUnlockAction(), action);
			}
			final BehaviorElement referenced = toReferenceValue(action.getReference());
			if (action.isLock() || action.isUnlock()) {
				final org.osate.ba.aadlba.SharedDataAction result = action.isLock()
						? trace(FACTORY.createLockAction(), action)
						: trace(FACTORY.createUnlockAction(), action);
				if (referenced instanceof org.osate.ba.aadlba.DataAccessHolder dataAccess) {
					result.setDataAccess(dataAccess);
				}
				return result;
			}
			if (action.isFreeze()) {
				final org.osate.ba.aadlba.PortFreezeAction result = trace(FACTORY.createPortFreezeAction(), action);
				if (referenced instanceof ElementHolder holder) {
					copyHolder(holder, result);
				}
				return result;
			}
			if (action.isDequeue()) {
				final org.osate.ba.aadlba.PortDequeueAction result = trace(FACTORY.createPortDequeueAction(), action);
				if (referenced instanceof ActualPortHolder port) {
					result.setPort(port);
				}
				if (action.getTarget() != null) {
					final BehaviorElement target = toReferenceValue(action.getTarget());
					if (target instanceof Target validTarget) {
						result.setTarget(validTarget);
					}
				}
				return result;
			}
			if (referenced instanceof ActualPortHolder port) {
				final org.osate.ba.aadlba.PortSendAction result = trace(FACTORY.createPortSendAction(), action);
				result.setPort(port);
				if (!action.getParameters().isEmpty()) {
					result.setValueExpression(toValueExpression(action.getParameters().get(0)));
				}
				return result;
			}
			final org.osate.ba.aadlba.SubprogramCallAction result = trace(FACTORY.createSubprogramCallAction(), action);
			if (referenced instanceof CalledSubprogramHolder subprogram) {
				result.setSubprogram(subprogram);
			} else if (referenced instanceof org.osate.ba.aadlba.SubprogramHolderProxy proxy) {
				result.setProxy(proxy);
			}
			final List<ElementHolder> path = resolvedPaths.get(action.getReference());
			if (path != null && !path.isEmpty()
					&& path.getFirst() instanceof org.osate.ba.aadlba.SubprogramHolderProxy proxy) {
				result.setProxy(proxy);
			}
			final var formalParameters = getFormalParameters(result.getSubprogram());
			for (var i = 0; i < action.getParameters().size(); i++) {
				final var formal = i < formalParameters.size() ? formalParameters.get(i) : null;
				result.getParameterLabels().add(toParameterLabel(action.getParameters().get(i), formal));
			}
			return result;
		}

		private ParameterLabel toParameterLabel(
				final org.osate.xtext.aadl2.ba.behaviorAnnex.ValueExpression parameter, final Feature formal) {
			final var writable = formal instanceof Parameter formalParameter
					? formalParameter.getDirection() != DirectionType.IN
					: formal instanceof DataAccess dataAccess
							&& Aadl2Utils.getDataAccessRight(dataAccess) != Aadl2Utils.DataAccessRight.read_only;
			if (writable && parameter instanceof ReferenceExpression expression) {
				if (expression.getProperty() == null && !expression.isCount() && !expression.isFresh()
						&& !expression.isDequeue() && expression.getReference().getSegments().size()
								+ expression.getReference().getTails().size() == 1) {
					final var reference = toReferenceValue(expression.getReference());
					if (reference instanceof Target target) {
						return target;
					}
				}
			}
			return toValueExpression(parameter);
		}

		private List<Feature> getFormalParameters(final CalledSubprogramHolder holder) {
			final var classifier = getSubprogramType(holder);
			if (classifier == null) {
				return List.of();
			}
			return Aadl2Utils.orderFeatures(classifier)
					.stream()
					.filter(feature -> feature instanceof Parameter || feature instanceof DataAccess)
					.toList();
		}

		private Classifier getSubprogramType(final CalledSubprogramHolder holder) {
			if (holder == null) {
				return null;
			}
			final var element = holder.getElement();
			return switch (element) {
			case SubprogramImplementation implementation -> implementation.getType();
			case SubprogramType type -> type;
			case SubprogramAccess access -> access.getClassifier();
			case SubprogramSubcomponent subcomponent -> subcomponent.getClassifier();
			case SubprogramPrototype prototype -> {
				var prototypeContext = (Classifier) owner;
				if (holder instanceof GroupableElement groupable && !groupable.getGroupHolders().isEmpty()) {
					final var group = groupable.getGroupHolders().getLast().getElement();
					final var groupClassifier = AadlBaUtils.getClassifier(group, owner);
					if (groupClassifier != null) {
						prototypeContext = groupClassifier;
					}
				}
				final var boundClassifier = AadlBaUtils.getClassifier(prototype, prototypeContext);
				if (boundClassifier instanceof SubprogramImplementation implementation) {
					yield implementation.getType();
				}
				yield boundClassifier != null ? boundClassifier : prototype.getConstrainingClassifier();
			}
			default -> null;
			};
		}

		private org.osate.ba.aadlba.BehaviorTime toTime(final BehaviorTime time) {
			final org.osate.ba.aadlba.BehaviorTime result = trace(FACTORY.createBehaviorTime(), time);
			copyTime(time, result);
			return result;
		}

		private void copyTime(final BehaviorTime sourceTime, final org.osate.ba.aadlba.BehaviorTime result) {
			result.setIntegerValue(toIntegerValue(sourceTime.getValue()));
			result.setUnit(sourceTime.getUnit());
		}

		private org.osate.ba.aadlba.IntegerValue toIntegerValue(final IntegerValue value) {
			if (value instanceof BehaviorIntegerLiteral) {
				return toIntegerLiteral((BehaviorIntegerLiteral) value);
			}
			if (value instanceof HashPropertyReference) {
				return (org.osate.ba.aadlba.IntegerValue) toPropertyReference((HashPropertyReference) value);
			}
			return (org.osate.ba.aadlba.IntegerValue) toReferenceExpression((ReferenceExpression) value);
		}

		private ValueExpression toValueExpression(
				final org.osate.xtext.aadl2.ba.behaviorAnnex.ValueExpression expression) {
			final ValueExpression result = trace(FACTORY.createValueExpression(), expression);
			appendLogical(result, expression);
			return result;
		}

		private void appendLogical(final ValueExpression result,
				final org.osate.xtext.aadl2.ba.behaviorAnnex.ValueExpression expression) {
			if (expression instanceof BinaryExpression && isLogical(((BinaryExpression) expression).getOperator())) {
				final BinaryExpression binary = (BinaryExpression) expression;
				appendLogical(result, binary.getLeft());
				result.getLogicalOperators().add(logicalOperator(binary.getOperator()));
				appendLogical(result, binary.getRight());
			} else {
				result.getRelations().add(toRelation(expression));
			}
		}

		private Relation toRelation(final org.osate.xtext.aadl2.ba.behaviorAnnex.ValueExpression expression) {
			final Relation result = trace(FACTORY.createRelation(), expression);
			if (expression instanceof BinaryExpression && isRelational(((BinaryExpression) expression).getOperator())) {
				final BinaryExpression binary = (BinaryExpression) expression;
				result.setFirstExpression(toSimpleExpression(binary.getLeft()));
				result.setRelationalOperator(relationalOperator(binary.getOperator()));
				result.setSecondExpression(toSimpleExpression(binary.getRight()));
			} else {
				result.setFirstExpression(toSimpleExpression(expression));
			}
			return result;
		}

		private SimpleExpression toSimpleExpression(
				final org.osate.xtext.aadl2.ba.behaviorAnnex.ValueExpression expression) {
			final SimpleExpression result = trace(FACTORY.createSimpleExpression(), expression);
			if (isParenthesized(expression) && consumedParentheses.add(expression)) {
				try {
					final var term = trace(FACTORY.createTerm(), expression);
					final var factor = trace(FACTORY.createFactor(), expression);
					factor.setFirstValue(toValueExpression(expression));
					term.getFactors().add(factor);
					result.getTerms().add(term);
				} finally {
					consumedParentheses.remove(expression);
				}
			} else {
				appendAdding(result, expression);
			}
			return result;
		}

		private void appendAdding(final SimpleExpression result,
				final org.osate.xtext.aadl2.ba.behaviorAnnex.ValueExpression expression) {
			if (expression instanceof BinaryExpression && isAdding(((BinaryExpression) expression).getOperator())) {
				final BinaryExpression binary = (BinaryExpression) expression;
				appendAdding(result, binary.getLeft());
				result.getBinaryAddingOperators().add(binaryAddingOperator(binary.getOperator()));
				result.getTerms().add(toTerm(binary.getRight()));
			} else if (expression instanceof UnaryExpression && isAdding(((UnaryExpression) expression).getOperator())) {
				final UnaryExpression unary = (UnaryExpression) expression;
				result.setUnaryAddingOperator("+".equals(unary.getOperator()) ? UnaryAddingOperator.PLUS
						: UnaryAddingOperator.MINUS);
				result.getTerms().add(toTerm(unary.getOperand()));
			} else {
				result.getTerms().add(toTerm(expression));
			}
		}

		private Term toTerm(final org.osate.xtext.aadl2.ba.behaviorAnnex.ValueExpression expression) {
			final Term result = trace(FACTORY.createTerm(), expression);
			appendMultiplying(result, expression);
			return result;
		}

		private void appendMultiplying(final Term result,
				final org.osate.xtext.aadl2.ba.behaviorAnnex.ValueExpression expression) {
			if (expression instanceof BinaryExpression && isMultiplying(((BinaryExpression) expression).getOperator())) {
				final BinaryExpression binary = (BinaryExpression) expression;
				appendMultiplying(result, binary.getLeft());
				result.getMultiplyingOperators().add(multiplyingOperator(binary.getOperator()));
				result.getFactors().add(toFactor(binary.getRight()));
			} else {
				result.getFactors().add(toFactor(expression));
			}
		}

		private Factor toFactor(final org.osate.xtext.aadl2.ba.behaviorAnnex.ValueExpression expression) {
			final Factor result = trace(FACTORY.createFactor(), expression);
			if (isParenthesized(expression) && consumedParentheses.add(expression)) {
				try {
					result.setFirstValue(toValueExpression(expression));
				} finally {
					consumedParentheses.remove(expression);
				}
			} else if (expression instanceof BinaryExpression
					&& "**".equals(((BinaryExpression) expression).getOperator())) {
				final BinaryExpression binary = (BinaryExpression) expression;
				result.setFirstValue(toValue(binary.getLeft()));
				result.setBinaryNumericOperator(BinaryNumericOperator.MULTIPLY_MULTIPLY);
				result.setSecondValue(toValue(binary.getRight()));
			} else if (expression instanceof UnaryExpression) {
				final UnaryExpression unary = (UnaryExpression) expression;
				if ("abs".equals(unary.getOperator())) {
					result.setUnaryNumericOperator(UnaryNumericOperator.ABS);
				} else if ("not".equals(unary.getOperator())) {
					result.setUnaryBooleanOperator(UnaryBooleanOperator.NOT);
				}
				result.setFirstValue(toValue(unary.getOperand()));
			} else {
				result.setFirstValue(toValue(expression));
			}
			return result;
		}

		private Value toValue(final org.osate.xtext.aadl2.ba.behaviorAnnex.ValueExpression expression) {
			if (isParenthesized(expression) && consumedParentheses.add(expression)) {
				try {
					return toValueExpression(expression);
				} finally {
					consumedParentheses.remove(expression);
				}
			}
			if (expression instanceof org.osate.xtext.aadl2.ba.behaviorAnnex.ValueConstant constant) {
				return toValueConstant(constant);
			}
			if (expression instanceof ReferenceExpression reference) {
				return toReferenceExpression(reference);
			}
			return toValueExpression(expression);
		}

		private ValueConstant toValueConstant(
				final org.osate.xtext.aadl2.ba.behaviorAnnex.ValueConstant constant) {
			if (constant instanceof BehaviorIntegerLiteral) {
				return toIntegerLiteral((BehaviorIntegerLiteral) constant);
			}
			if (constant instanceof BehaviorRealLiteral) {
				final org.osate.ba.aadlba.BehaviorRealLiteral result = trace(FACTORY.createBehaviorRealLiteral(), constant);
				result.setValue(0.0);
				return result;
			}
			if (constant instanceof BehaviorStringLiteral) {
				final org.osate.ba.aadlba.BehaviorStringLiteral result = trace(FACTORY.createBehaviorStringLiteral(), constant);
				result.setValue(((BehaviorStringLiteral) constant).getValue());
				return result;
			}
			if (constant instanceof BehaviorBooleanLiteral) {
				final org.osate.ba.aadlba.BehaviorBooleanLiteral result = trace(FACTORY.createBehaviorBooleanLiteral(),
						constant);
				result.setValue(((BehaviorBooleanLiteral) constant).isValue());
				return result;
			}
			return (ValueConstant) toPropertyReference((HashPropertyReference) constant);
		}

		private org.osate.ba.aadlba.BehaviorIntegerLiteral toIntegerLiteral(final BehaviorIntegerLiteral literal) {
			final org.osate.ba.aadlba.BehaviorIntegerLiteral result = trace(FACTORY.createBehaviorIntegerLiteral(), literal);
			result.setValue(parseInteger(literal.getValue(), 0));
			return result;
		}

		private Value toReferenceExpression(final ReferenceExpression expression) {
			if (expression.getProperty() != null) {
				return toPropertyReference(expression.getReference(), expression.getProperty());
			}
			final var referenced = toReferenceValue(expression.getReference());
			if (expression.isCount() || expression.isFresh() || expression.isDequeue()) {
				final String holderType = expression.isCount() ? "PortCountValue"
						: expression.isFresh() ? "PortFreshValue" : "PortDequeueValue";
				final ElementHolder portValue = (ElementHolder) create(holderType, expression);
				if (referenced instanceof ElementHolder holder) {
					copyHolder(holder, portValue);
				}
				return (Value) portValue;
			}
			return (Value) referenced;
		}

		private ValueConstant toPropertyReference(final HashPropertyReference reference) {
			return toPropertyReference(null, reference.getProperty(), reference.getIndexes(), reference.getFields(),
					reference);
		}

		private Value toPropertyReference(final Reference prefix, final PropertyReferenceTail reference) {
			return toPropertyReference(prefix, reference.getProperty(), reference.getIndexes(), reference.getFields(),
					reference);
		}

		private ValueConstant toPropertyReference(final Reference prefix, final String propertyName,
				final List<PropertyArrayIndex> indexes, final List<NamedPropertyField> fields, final EObject traceSource) {
			final NamedElement propertyElement = resolveQualified(propertyName, true);
			final BehaviorElement prefixValue = prefix == null ? null : toReferenceValue(prefix);
			final var prefixElement = prefix == null ? null : resolvedReferences.get(prefix);
			if (propertyElement instanceof PropertyConstant) {
				final org.osate.ba.aadlba.BehaviorPropertyConstant result = trace(
						FACTORY.createBehaviorPropertyConstant(), traceSource);
				result.setProperty((PropertyConstant) propertyElement);
				if (((PropertyConstant) propertyElement).getOwner() instanceof PropertySet) {
					result.setPropertySet((PropertySet) ((PropertyConstant) propertyElement).getOwner());
				}
				return result;
			}
			final org.osate.ba.aadlba.PropertyReference result;
			if (prefix == null) {
				final org.osate.ba.aadlba.PropertySetPropertyReference propertyReference = trace(
						FACTORY.createPropertySetPropertyReference(), traceSource);
				if (propertyElement != null && propertyElement.getOwner() instanceof PropertySet) {
					propertyReference.setPropertySet((PropertySet) propertyElement.getOwner());
				}
				result = propertyReference;
			} else if (prefixElement instanceof Classifier classifier) {
				final var propertyReference = trace(FACTORY.createClassifierPropertyReference(), traceSource);
				propertyReference.setClassifier(classifier);
				result = propertyReference;
			} else {
				final org.osate.ba.aadlba.ClassifierFeaturePropertyReference propertyReference = trace(
						FACTORY.createClassifierFeaturePropertyReference(), traceSource);
				if (prefixValue instanceof org.osate.ba.aadlba.ClassifierFeatureHolder component) {
					propertyReference.setComponent(component);
				}
				result = propertyReference;
			}
			Element primaryElement = propertyElement;
			if (prefix == null) {
				if (propertyElement instanceof Property property) {
					if (property.getDefaultValue() != null) {
						primaryElement = property.getDefaultValue();
					}
				}
			} else {
				final NamedElement valueOwner;
				if (prefixElement instanceof Classifier classifier) {
					valueOwner = classifier;
				} else if (prefixValue instanceof ElementHolder holder) {
					valueOwner = holder.getElement();
				} else if (prefixValue instanceof DataComponentReference reference
						&& !reference.getData().isEmpty()) {
					valueOwner = reference.getData().getLast().getElement();
				} else {
					valueOwner = null;
				}
				final var separator = propertyName.lastIndexOf("::");
				final var localPropertyName = separator < 0 ? propertyName : propertyName.substring(separator + 2);
				final var association = valueOwner == null
						? null
						: PropertyUtils.findPropertyAssociation(localPropertyName, valueOwner);
				if (association != null) {
					primaryElement = association;
				}
			}
			result.getProperties().add(toPropertyNameHolder(primaryElement, indexes, traceSource));
			Element previous = primaryElement;
			for (final NamedPropertyField field : fields) {
				previous = resolvePropertyField(previous, field.getName());
				result.getProperties().add(toPropertyNameHolder(previous, field.getIndexes(), field));
			}
			return result;
		}

		private PropertyNameHolder toPropertyNameHolder(final Element element,
				final List<PropertyArrayIndex> indexes, final EObject traceSource) {
			final PropertyNameHolder result = trace(FACTORY.createPropertyNameHolder(), traceSource);
			result.setProperty(toPropertyElementHolder(element, traceSource));
			for (final PropertyArrayIndex index : indexes) {
				if (result.getProperty() instanceof IndexableElement) {
					((IndexableElement) result.getProperty()).getArrayIndexes().add(toPropertyIndex(index.getValue()));
				}
			}
			return result;
		}

		private PropertyElementHolder toPropertyElementHolder(final Element element, final EObject traceSource) {
			final String type;
			if (element instanceof Property) {
				type = "BasicPropertyHolder";
			} else if (element instanceof EnumerationLiteral) {
				type = "EnumLiteralHolder";
			} else if (element instanceof org.osate.aadl2.PropertyType) {
				type = "PropertyTypeHolder";
			} else if (element instanceof PropertyAssociation) {
				type = "PropertyAssociationHolder";
			} else if (element instanceof PropertyExpression) {
				type = "PropertyExpressionHolder";
			} else {
				type = "BasicPropertyHolder";
			}
			final PropertyElementHolder result = (PropertyElementHolder) create(type, traceSource);
			result.setElement(element);
			return result;
		}

		private org.osate.ba.aadlba.IntegerValue toPropertyIndex(final PropertyIndexValue value) {
			if (value instanceof BehaviorIntegerLiteral) {
				return toIntegerLiteral((BehaviorIntegerLiteral) value);
			}
			if (value instanceof PropertyIndexPropertyReference) {
				final PropertyIndexPropertyReference reference = (PropertyIndexPropertyReference) value;
				return (org.osate.ba.aadlba.IntegerValue) toPropertyReference(null, reference.getProperty(), List.of(),
						List.of(), reference);
			}
			final org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceExpression reference =
					(org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceExpression) value;
			return (org.osate.ba.aadlba.IntegerValue) toReferenceValue(reference.getReference());
		}

		private BehaviorElement toReferenceValue(final Reference reference) {
			return toReferenceValue(reference.getSegments(), reference.getTails(), reference);
		}

		private BehaviorElement toReferenceValue(
				final org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReference reference) {
			final List<ReferenceSegment> segments = new ArrayList<>();
			for (final var segment : reference.getSegments()) {
				final ReferenceSegment copy = org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexFactory.eINSTANCE
						.createReferenceSegment();
				copy.setName(segment.getName());
				segments.add(copy);
			}
			final List<ReferenceTail> tails = new ArrayList<>();
			for (final var tail : reference.getTails()) {
				final ReferenceTail copy = org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexFactory.eINSTANCE
						.createReferenceTail();
				copy.setSeparator(tail.getSeparator());
				final ReferenceSegment segment = org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexFactory.eINSTANCE
						.createReferenceSegment();
				segment.setName(tail.getSegment().getName());
				copy.setSegment(segment);
				tails.add(copy);
			}
			return toReferenceValue(segments, tails, reference);
		}

		private BehaviorElement toReferenceValue(final List<ReferenceSegment> firstSegments,
				final List<ReferenceTail> tails, final EObject traceSource) {
			final List<Segment> segments = new ArrayList<>();
			for (final ReferenceSegment segment : firstSegments) {
				segments.add(new Segment(segment.getName(), segment.getIndexes(), segment, null));
			}
			for (final ReferenceTail tail : tails) {
				segments.add(new Segment(tail.getSegment().getName(), tail.getSegment().getIndexes(), tail.getSegment(),
						tail.getSeparator()));
			}
			final List<ElementHolder> holders = new ArrayList<>();
			final List<GroupHolder> groups = new ArrayList<>();
			NamedElement current = null;
			int firstElement = 0;
			int qualifiedEnd = 0;
			while (qualifiedEnd + 1 < segments.size() && "::".equals(segments.get(qualifiedEnd + 1).separator)) {
				qualifiedEnd++;
			}
			if (qualifiedEnd > 0) {
				final String qualifiedName = segments.subList(0, qualifiedEnd + 1)
						.stream()
						.map(Segment::name)
						.collect(java.util.stream.Collectors.joining("::"));
				final Segment segment = segments.get(qualifiedEnd);
				current = resolveQualified(qualifiedName, false);
				addResolvedSegment(current, segment, holders, groups);
				firstElement = qualifiedEnd + 1;
			}
			for (int i = firstElement; i < segments.size(); i++) {
				final Segment segment = segments.get(i);
				current = i == 0 ? resolveFirst(segment.name) : resolveNested(current, segment.name);
				addResolvedSegment(current, segment, holders, groups);
			}
			if (holders.isEmpty()) {
				return trace(FACTORY.createBehaviorVariableHolder(), traceSource);
			}
			resolvedReferences.put(traceSource, current);
			resolvedPaths.put(traceSource, List.copyOf(holders));
			if (holders.size() == 1) {
				return trace((BehaviorElement) holders.get(0), traceSource);
			}
			if (!(holders.getLast() instanceof DataHolder)) {
				return trace((BehaviorElement) holders.getLast(), traceSource);
			}
			final DataComponentReference result = trace(FACTORY.createDataComponentReference(), traceSource);
			for (final ElementHolder holder : holders) {
				if (holder instanceof DataHolder) {
					result.getData().add((DataHolder) holder);
				}
			}
			return result;
		}

		private void addResolvedSegment(final NamedElement element, final Segment segment,
				final List<ElementHolder> holders, final List<GroupHolder> groups) {
			if (element == null) {
				return;
			}
			final ElementHolder holder = createHolder(element, segment.source, !groups.isEmpty());
			for (final ArrayIndex index : segment.indexes) {
				if (holder instanceof IndexableElement indexable) {
					indexable.getArrayIndexes().add(toIntegerValue(index.getValue()));
				}
			}
			if (holder instanceof GroupHolder group) {
				groups.add(group);
			} else {
				if (!groups.isEmpty() && holder instanceof GroupableElement groupable) {
					groupable.getGroupHolders().addAll(groups);
					groups.clear();
				}
				holders.add(holder);
			}
		}

		private NamedElement resolveFirst(final String name) {
			for (int i = iterativeScopes.size() - 1; i >= 0; i--) {
				final org.osate.ba.aadlba.IterativeVariable variable = iterativeScopes.get(i).get(name);
				if (variable != null) {
					return variable;
				}
			}
			final BehaviorVariable variable = variables.get(name);
			if (variable != null) {
				return variable;
			}
			final var prototypeBinding = Aadl2Visitors.findPrototypeBindingInComponent(owner, name);
			if (prototypeBinding != null) {
				return (NamedElement) prototypeBinding.getFormal();
			}
			final NamedElement ownedElement = owner.findNamedElement(name);
			return ownedElement == null ? resolveQualified(name, false) : ownedElement;
		}

		private NamedElement resolveNested(final NamedElement current, final String name) {
			if (current == null) {
				return null;
			}
			if (current instanceof Classifier classifier) {
				final var qualifiedClassifier = resolveQualified(classifier.getQualifiedName() + "." + name, false);
				if (qualifiedClassifier != null) {
					return qualifiedClassifier;
				}
			}
			try {
				final Classifier classifier = AadlBaUtils.getClassifier(current, owner);
				if (classifier == null) {
					return null;
				}
				if (name.equalsIgnoreCase(classifier.getName())
						|| classifier.getName().regionMatches(true,
								Math.max(0, classifier.getName().length() - name.length()), name, 0, name.length())) {
					return classifier;
				}
				final var prototypeBinding = Aadl2Visitors.findPrototypeBindingInComponent(classifier, name);
				if (prototypeBinding != null) {
					return (NamedElement) prototypeBinding.getFormal();
				}
				final var nested = classifier.findNamedElement(name);
				return nested == null && classifier instanceof DataClassifier dataClassifier
						? resolveDataElement(dataClassifier, name)
						: nested;
			} catch (final UnsupportedOperationException exception) {
				return current instanceof Classifier ? ((Classifier) current).findNamedElement(name) : null;
			}
		}

		private NamedElement resolveDataElement(final DataClassifier classifier, final String name) {
			final var representation = AadlBaUtils.getDataRepresentation(classifier);
			if (representation == DataRepresentation.ARRAY) {
				final var baseType = AadlBaUtils.getBaseType(classifier);
				return baseType != null && baseType.getClassifier() instanceof DataClassifier dataClassifier
						? resolveDataElement(dataClassifier, name)
						: null;
			}
			if (representation != DataRepresentation.STRUCT && representation != DataRepresentation.UNION) {
				return null;
			}

			final var elementNames = PropertyUtils.findPropertyExpression(classifier,
					DataModelProperties.ELEMENT_NAMES);
			final var baseTypes = PropertyUtils.findPropertyExpression(classifier, DataModelProperties.BASE_TYPE);
			for (var listIndex = 0; listIndex < elementNames.size() && listIndex < baseTypes.size(); listIndex++) {
				if (!(elementNames.get(listIndex) instanceof ListValue names)
						|| !(baseTypes.get(listIndex) instanceof ListValue types)) {
					continue;
				}
				for (var elementIndex = 0; elementIndex < names.getOwnedListElements().size()
						&& elementIndex < types.getOwnedListElements().size(); elementIndex++) {
					if (names.getOwnedListElements().get(elementIndex) instanceof StringLiteral elementName
							&& name.equalsIgnoreCase(elementName.getValue())
							&& types.getOwnedListElements().get(elementIndex) instanceof ClassifierValue classifierValue
							&& classifierValue.getClassifier() instanceof DataClassifier dataClassifier) {
						final var result = FACTORY.createStructUnionElement();
						result.setName(name);
						result.setDataClassifier(dataClassifier);
						return result;
					}
				}
			}
			return null;
		}

		private ElementHolder createHolder(final NamedElement element, final EObject traceSource,
				final boolean grouped) {
			final String type;
			if (element instanceof BehaviorVariable) {
				type = "BehaviorVariableHolder";
			} else if (element instanceof org.osate.ba.aadlba.IterativeVariable) {
				type = "IterativeVariableHolder";
			} else if (element instanceof DataPort) {
				type = "DataPortHolder";
			} else if (element instanceof EventDataPort) {
				type = "EventDataPortHolder";
			} else if (element instanceof EventPort) {
				type = "EventPortHolder";
			} else if (element instanceof DataAccess) {
				type = "DataAccessHolder";
			} else if (element instanceof DataSubcomponent) {
				type = "DataSubcomponentHolder";
			} else if (element instanceof Parameter) {
				type = "ParameterHolder";
			} else if (element instanceof SubprogramAccess) {
				type = "SubprogramAccessHolder";
			} else if (element instanceof SubprogramSubcomponent) {
				type = grouped ? "SubprogramHolder" : "SubprogramSubcomponentHolder";
			} else if (element instanceof org.osate.aadl2.SubprogramClassifier) {
				type = "SubprogramHolder";
			} else if (element instanceof FeatureGroup || element instanceof org.osate.aadl2.SubprogramGroupSubcomponent
					|| element instanceof org.osate.aadl2.SubprogramGroupAccess
					|| element instanceof org.osate.aadl2.ThreadGroupSubcomponent) {
				type = "GroupHolder";
			} else if (element instanceof org.osate.aadl2.SubprogramPrototype) {
				type = "SubprogramPrototypeHolder";
			} else if (element instanceof org.osate.aadl2.FeatureGroupPrototype
					|| element instanceof org.osate.aadl2.SubprogramGroupPrototype
					|| element instanceof org.osate.aadl2.ThreadGroupPrototype) {
				type = "GroupPrototypeHolder";
			} else if (element instanceof FeaturePrototype prototype) {
				type = featurePrototypeHolderType(prototype);
			} else if (element instanceof org.osate.ba.aadlba.StructUnionElement) {
				type = "StructUnionElementHolder";
			} else {
				type = "DataSubcomponentHolder";
			}
			final ElementHolder result = (ElementHolder) create(type, traceSource);
			if (element instanceof org.osate.ba.aadlba.StructUnionElement structUnionElement) {
				trace(structUnionElement, traceSource);
			}
			if (result.eClass().getEStructuralFeature("element") != null) {
				result.setElement(element);
			}
			if (result instanceof org.osate.ba.aadlba.PrototypeHolder) {
				if (element instanceof PrototypeBinding) {
					((org.osate.ba.aadlba.PrototypeHolder) result).setPrototypeBinding((PrototypeBinding) element);
					((org.osate.ba.aadlba.PrototypeHolder) result).setPrototype(((PrototypeBinding) element).getFormal());
				} else if (element instanceof Prototype) {
					final var prototypeHolder = (org.osate.ba.aadlba.PrototypeHolder) result;
					prototypeHolder.setPrototype((Prototype) element);
					final var binding = Aadl2Visitors.findPrototypeBindingInComponent(owner, element.getName());
					if (binding != null) {
						prototypeHolder.setPrototypeBinding(binding);
					}
				}
			}
			return result;
		}

		private String featurePrototypeHolderType(final FeaturePrototype prototype) {
			final var binding = Aadl2Visitors.findPrototypeBindingInComponent(owner, prototype.getName());
			if (binding instanceof FeaturePrototypeBinding featureBinding) {
				return switch (featureBinding.getActual()) {
				case PortSpecification unused -> "PortPrototypeHolder";
				case AccessSpecification access when access.getCategory() == AccessCategory.DATA ->
					"DataAccessPrototypeHolder";
				default -> "FeaturePrototypeHolder";
				};
			}
			return "FeaturePrototypeHolder";
		}

		private NamedElement resolveQualified(final String qualifiedName, final boolean propertySet) {
			final int separator = qualifiedName.lastIndexOf("::");
			if (separator >= 0) {
				final String namespace = qualifiedName.substring(0, separator);
				final String name = qualifiedName.substring(separator + 2);
				return propertySet
						? Aadl2Visitors.findElementInPropertySet(name, namespace,
								AadlUtil.getContainingPackageSection(owner))
						: Aadl2Visitors.findElementInPackage(name, namespace, AadlUtil.getContainingPackageSection(owner));
			}
			final NamedElement local = owner.findNamedElement(qualifiedName);
			if (local != null) {
				return local;
			}
			return propertySet
					? Aadl2Visitors.findElementInPropertySet(qualifiedName, null,
							AadlUtil.getContainingPackageSection(owner))
					: Aadl2Visitors.findElementInPackage(qualifiedName, null, AadlUtil.getContainingPackageSection(owner));
		}

		private Element resolvePropertyField(final Element parent, final String name) {
			if (parent == null) {
				return null;
			}
			if (parent instanceof PropertyAssociation association) {
				final var values = PropertyUtils.getPropertyExpression(association);
				if (!values.isEmpty()) {
					final var resolved = resolvePropertyValue(values.getLast(), name);
					if (resolved != null) {
						return resolved;
					}
				}
				return resolvePropertyField(association.getProperty(), name);
			}
			if (parent instanceof PropertyExpression expression) {
				final var resolved = resolvePropertyValue(expression, name);
				if (resolved != null) {
					return resolved;
				}
				final var property = PropertyUtils.getContainingProperty(expression);
				return property == null ? null : resolvePropertyField(property, name);
			}
			if (parent instanceof BasicProperty property) {
				if (property instanceof Property declaration && declaration.getDefaultValue() != null) {
					final var resolved = resolvePropertyValue(declaration.getDefaultValue(), name);
					if (resolved != null) {
						return resolved;
					}
				}
				return resolvePropertyField(property.getPropertyType(), name);
			}
			return resolvePropertyField((EObject) parent, name);
		}

		private NamedElement resolvePropertyField(final EObject parent, final String name) {
			if (parent == null) {
				return null;
			}
			if (parent instanceof EnumerationType enumeration) {
				return enumeration.findLiteral(name);
			}
			if (parent instanceof RecordType record) {
				return record.getOwnedFields()
						.stream()
						.filter(field -> name.equalsIgnoreCase(field.getName()))
						.findFirst()
						.orElse(null);
			}
			for (final EObject child : parent.eContents()) {
				if (child instanceof NamedElement && name.equalsIgnoreCase(((NamedElement) child).getName())) {
					return (NamedElement) child;
				}
			}
			return null;
		}

		private Element resolvePropertyValue(final PropertyExpression expression, final String name) {
			try {
				return PropertyUtils.getValue(expression, name);
			} catch (final UnsupportedOperationException exception) {
				return null;
			}
		}

		private void copyHolder(final ElementHolder sourceHolder, final ElementHolder target) {
			target.setElement(sourceHolder.getElement());
			if (sourceHolder instanceof GroupableElement && target instanceof GroupableElement) {
				((GroupableElement) target).getGroupHolders().addAll(
						EcoreUtil.copyAll(((GroupableElement) sourceHolder).getGroupHolders()));
				traceTree(target, strictToDeclarative.get(sourceHolder));
			}
			if (sourceHolder instanceof IndexableElement && target instanceof IndexableElement) {
				((IndexableElement) target).getArrayIndexes()
						.addAll(EcoreUtil.copyAll(((IndexableElement) sourceHolder).getArrayIndexes()));
				traceTree(target, strictToDeclarative.get(sourceHolder));
			}
		}

		private EObject create(final String className, final EObject traceSource) {
			final var classifier = org.osate.ba.aadlba.AadlBaPackage.eINSTANCE.getEClassifier(className);
			return trace(FACTORY.create((org.eclipse.emf.ecore.EClass) classifier), traceSource);
		}

		private <T extends EObject> T trace(final T strict, final EObject declarative) {
			if (strict == null || declarative == null) {
				return strict;
			}
			strictToDeclarative.put(strict, declarative);
			declarativeToStrict.putIfAbsent(declarative, strict);
			return strict;
		}

		private void traceTree(final EObject strictRoot, final EObject declarative) {
			trace(strictRoot, declarative);
			strictRoot.eAllContents().forEachRemaining(object -> trace(object, declarative));
		}

		private static long parseInteger(final String value, final long fallback) {
			if (value == null) {
				return fallback;
			}
			try {
				return Long.parseLong(value.replace("_", ""));
			} catch (final NumberFormatException exception) {
				return fallback;
			}
		}

		private static boolean isParenthesized(final EObject expression) {
			final var node = NodeModelUtils.findActualNodeFor(expression);
			if (node == null) {
				return false;
			}
			final var text = node.getText().strip();
			return text.startsWith("(") && text.endsWith(")");
		}

		private static boolean isLogical(final String operator) {
			return "and".equals(operator) || "or".equals(operator) || "xor".equals(operator);
		}

		private static boolean isRelational(final String operator) {
			return List.of("=", "!=", "<", "<=", ">", ">=").contains(operator);
		}

		private static boolean isAdding(final String operator) {
			return "+".equals(operator) || "-".equals(operator);
		}

		private static boolean isMultiplying(final String operator) {
			return List.of("*", "/", "mod", "rem").contains(operator);
		}

		private static LogicalOperator logicalOperator(final String operator) {
			return switch (operator) {
			case "and" -> LogicalOperator.AND;
			case "or" -> LogicalOperator.OR;
			default -> LogicalOperator.XOR;
			};
		}

		private static RelationalOperator relationalOperator(final String operator) {
			return switch (operator) {
			case "=" -> RelationalOperator.EQUAL;
			case "!=" -> RelationalOperator.NOT_EQUAL;
			case "<" -> RelationalOperator.LESS_THAN;
			case "<=" -> RelationalOperator.LESS_OR_EQUAL_THAN;
			case ">" -> RelationalOperator.GREATER_THAN;
			default -> RelationalOperator.GREATER_OR_EQUAL_THAN;
			};
		}

		private static BinaryAddingOperator binaryAddingOperator(final String operator) {
			return "+".equals(operator) ? BinaryAddingOperator.PLUS : BinaryAddingOperator.MINUS;
		}

		private static MultiplyingOperator multiplyingOperator(final String operator) {
			return switch (operator) {
			case "*" -> MultiplyingOperator.MULTIPLY;
			case "/" -> MultiplyingOperator.DIVIDE;
			case "mod" -> MultiplyingOperator.MOD;
			default -> MultiplyingOperator.REM;
			};
		}

		private record Segment(String name, List<ArrayIndex> indexes, EObject source, String separator) {
		}
	}
}
