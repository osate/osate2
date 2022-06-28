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
package org.osate.aadl2.errormodel.instance.instantiator;

import static org.eclipse.xtext.EcoreUtil2.getContainerOfType;
import static org.osate.xtext.aadl2.errormodel.util.EMV2TypeSetUtil.isNoError;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.Feature;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.TriggerPort;
import org.osate.aadl2.contrib.deployment.DeploymentProperties;
import org.osate.aadl2.errormodel.instance.AccessPropagation;
import org.osate.aadl2.errormodel.instance.AllSources;
import org.osate.aadl2.errormodel.instance.AnonymousTypeSet;
import org.osate.aadl2.errormodel.instance.BindingPropagation;
import org.osate.aadl2.errormodel.instance.BindingType;
import org.osate.aadl2.errormodel.instance.CompositeStateInstance;
import org.osate.aadl2.errormodel.instance.ConditionExpressionInstance;
import org.osate.aadl2.errormodel.instance.ConnectionEndPropagation;
import org.osate.aadl2.errormodel.instance.ConstrainedInstanceObject;
import org.osate.aadl2.errormodel.instance.ConstraintElement;
import org.osate.aadl2.errormodel.instance.ConstraintExpression;
import org.osate.aadl2.errormodel.instance.CountExpression;
import org.osate.aadl2.errormodel.instance.CountExpressionOperation;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.EMV2InstanceFactory;
import org.osate.aadl2.errormodel.instance.EOperation;
import org.osate.aadl2.errormodel.instance.ErrorDetectionInstance;
import org.osate.aadl2.errormodel.instance.ErrorEventInstance;
import org.osate.aadl2.errormodel.instance.ErrorPropagationConditionInstance;
import org.osate.aadl2.errormodel.instance.ErrorPropagationInstance;
import org.osate.aadl2.errormodel.instance.EventInstance;
import org.osate.aadl2.errormodel.instance.EventReference;
import org.osate.aadl2.errormodel.instance.FeaturePropagation;
import org.osate.aadl2.errormodel.instance.NoErrorPropagationReference;
import org.osate.aadl2.errormodel.instance.PointPropagation;
import org.osate.aadl2.errormodel.instance.PropagationPointInstance;
import org.osate.aadl2.errormodel.instance.PropagationReference;
import org.osate.aadl2.errormodel.instance.RecoverEventInstance;
import org.osate.aadl2.errormodel.instance.RepairEventInstance;
import org.osate.aadl2.errormodel.instance.SourceStateReference;
import org.osate.aadl2.errormodel.instance.StateInstance;
import org.osate.aadl2.errormodel.instance.StateMachineInstance;
import org.osate.aadl2.errormodel.instance.TransitionSource;
import org.osate.aadl2.errormodel.instance.TypeInstance;
import org.osate.aadl2.errormodel.instance.TypeProductInstance;
import org.osate.aadl2.errormodel.instance.TypeSetElement;
import org.osate.aadl2.errormodel.instance.TypeSetInstance;
import org.osate.aadl2.instance.AnnexInstance;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.PropertyAssociationInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.annexsupport.AnnexInstantiator;
import org.osate.xtext.aadl2.errormodel.errorModel.AllExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.AndExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PathElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorCodeValue;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;
import org.osate.xtext.aadl2.errormodel.errorModel.OrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrlessExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.RecoverEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.RepairEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

public class EMV2AnnexInstantiator implements AnnexInstantiator {
	public static final String PROPERTY_NAME = "org.osate.emv2.instance";

	@Override
	public void instantiateAnnex(ComponentInstance instance, String annexName,
			AnalysisErrorReporterManager errorManager) {
		if (!"true".equalsIgnoreCase(System.getProperty(PROPERTY_NAME))) {
			// Don't instantiate EMV2 elements unless explicitly enabled.
			return;
		}
		EMV2AnnexInstance emv2AI = EMV2InstanceFactory.eINSTANCE.createEMV2AnnexInstance();
		emv2AI.setName("EMV2");
		instance.getAnnexInstances().add(emv2AI);

		Collection<PropagationPoint> pps = EMV2Util.getAllPropagationPoints(instance.getComponentClassifier());
		for (PropagationPoint pp : pps) {
			instantiatePropagationPoint(pp, emv2AI);
		}

		var eps = EMV2Util.getAllErrorPropagations(instance.getComponentClassifier());
		instantiateErrorPropagations(eps, emv2AI);

		Collection<ErrorBehaviorEvent> events = EMV2Util.getAllErrorBehaviorEvents(instance);
		for (ErrorBehaviorEvent ev : events) {
			instantiateEvent(ev, emv2AI);
		}

		for (var source : EMV2Util.getAllErrorSources(instance)) {
			instantiateErrorSource(source, emv2AI);
		}

		for (var sink : EMV2Util.getAllErrorSinks(instance)) {
			instantiateErrorSink(sink, emv2AI);
		}

		for (var path : EMV2Util.getAllErrorPaths(instance)) {
			instantiateErrorPath(path, emv2AI);
		}

		ErrorBehaviorStateMachine ebsm = EMV2Util.getAllErrorBehaviorStateMachine(instance);
		if (ebsm != null) {
			for (var state : ebsm.getStates()) {
				instantiateState(state, emv2AI);
			}
		}

		Collection<ErrorBehaviorTransition> transitions = EMV2Util.getAllErrorBehaviorTransitions(instance);
		for (ErrorBehaviorTransition tr : transitions) {
			instantiateTransition(tr, instance, emv2AI);
		}

		Collection<CompositeState> compstates = EMV2Util.getAllCompositeStates(instance);
		for (CompositeState cs : compstates) {
			instantiateCompositeState(cs, emv2AI);
		}

		Collection<OutgoingPropagationCondition> OPCs = EMV2Util.getAllOutgoingPropagationConditions(instance);
		for (OutgoingPropagationCondition opc : OPCs) {
			instantiateOutgoingPropagationCondition(opc, emv2AI);
		}

		Collection<ErrorDetection> eds = EMV2Util.getAllErrorDetections(instance.getComponentClassifier());
		for (ErrorDetection ed : eds) {
			instantiateErrorDetection(ed, emv2AI);
		}

		Collection<PropagationPath> ppaths = EMV2Util.getAllPropagationPaths(instance.getComponentClassifier());
		for (PropagationPath ppath : ppaths) {
			instantiateUserDefinedPath(ppath, emv2AI, instance);
		}
	}

	@Override
	public void instantiateAnnex(SystemInstance instance, String annexName, AnalysisErrorReporterManager errorManager) {
		if (!"true".equalsIgnoreCase(System.getProperty(PROPERTY_NAME))) {
			// Don't instantiate EMV2 elements unless explicitly enabled.
			return;
		}
		EcoreUtil2.eAllOfType(instance, ComponentInstance.class).forEach(component -> {
			component.getConnectionInstances().forEach(connection -> instantiateConnectionPath(connection, component));
		});
		instantiateBindingPaths(instance);
	}

	private void instantiateConnectionPath(ConnectionInstance connection, ComponentInstance component) {
		if (connection.isComplete()) {
			var sourcePropagations = new ArrayList<ConnectionEndPropagation>();
			var destinationPropagations = new ArrayDeque<ConnectionEndPropagation>();
			var encounteredAcross = false;
			for (var ref : connection.getConnectionReferences()) {
				if (!encounteredAcross) {
					ConnectionEndPropagation propagation;
					if (ref.getSource() instanceof FeatureInstance source) {
						propagation = findFeaturePropagation(source);
					} else if (ref.getSource() instanceof ComponentInstance source) {
						propagation = findAccessPropagation(source);
					} else {
						throw new RuntimeException("Unexpected connection end: " + ref.getSource());
					}
					if (propagation != null && propagation.getDirection().outgoing()) {
						sourcePropagations.add(propagation);
					}
				}
				if (ref.getConnection().isAcross()) {
					encounteredAcross = true;
				}
				if (encounteredAcross) {
					ConnectionEndPropagation propagation;
					if (ref.getDestination() instanceof FeatureInstance destination) {
						propagation = findFeaturePropagation(destination);
					} else if (ref.getDestination() instanceof ComponentInstance destination) {
						propagation = findAccessPropagation(destination);
					} else {
						throw new RuntimeException("Unexpected connection end: " + ref.getDestination());
					}
					if (propagation != null && propagation.getDirection().incoming()) {
						destinationPropagations.addFirst(propagation);
					}
				}
			}
			if (!sourcePropagations.isEmpty() && !destinationPropagations.isEmpty()) {
				var connectionPath = EMV2InstanceFactory.eINSTANCE.createConnectionPath();
				connectionPath.setName(connection.getName());
				connectionPath.setConnection(connection);
				connectionPath.getSourcePropagations().addAll(sourcePropagations);
				connectionPath.getDestinationPropagations().addAll(destinationPropagations);
				getOrCreateEMV2AnnexInstance(component).getPropagationPaths().add(connectionPath);
			}
		}
	}

	/*
	 * The instantiation of BindingPath objects is a bit complicated. The idea is that there should be one BindingPath
	 * object per declarative PropertyAssociation for that binding. However, a single declarative PropertyAssociation
	 * can be instantiated into multiple PropertyAssociationInstance objects if the property is inherit and it is
	 * applied to a container. This method collects all of the values from every PropertyAssociationInstance and groups
	 * them by their singular declarative PropertyAssociation.
	 *
	 * For example, suppose that an Actual_Processor_Binding is applied to a process and that process contains multiple
	 * threads. Now also suppose that the process and all of the threads have in processor propagations and the
	 * processor that is the target of the binding has an out bindings propagation. This will result in one
	 * BindingPath object being created in which the source is the bindings propagation on the processor and the
	 * destination propagations are all of the processor propagations on the process and threads.
	 *
	 * The collection of all bindings for a given type must not only be grouped by a common singular declarative
	 * PropertyAssociation, but also by their instance property values. There are some situations in which a single
	 * declarative binding PropertyAssociation should result in multiple BindingPath objects. If a declarative binding
	 * PropertyAssociation is not at the top system, but is instead in a child component, and the classifier of that
	 * child component is used in multiple subcomponents, then the InstanceReferenceValue objects would be different for
	 * the different subtrees of the instance model and we would want to create multiple BindingPath objects. The record
	 * UniqueBindingKey fulfills this requirement by allowing a grouping by declarative PropertyAssociation and the
	 * instance value objects.
	 *
	 * In addition to grouping by inherited properties, a BindingPath can also have a list of sources or list of
	 * destinations if the binding property lists multiple targets. For example, if a thread is bound to three
	 * processors, then a BindingPath will be created which lists the propagations for all three processors. Memory
	 * binding works the same way, but connection binding is different. For connection binding, the list represents a
	 * sequence of components that data flows through. Therefore, a BindingPath is created from the out connection
	 * propagation on the binding source to the in bindings propagation on the first binding target and another
	 * BindingPath is created from the out bindings propagation on the last binding target to the in connection
	 * propagation on the binding source.
	 */
	private void instantiateBindingPaths(SystemInstance instance) {
		// Key has the binding targets and the values are the binding sources.
		var commonProcessorBindings = new LinkedHashMap<UniqueBindingKey, List<ComponentInstance>>();
		var commonMemoryBindings = new LinkedHashMap<UniqueBindingKey, List<ComponentInstance>>();
		var commonConnectionBindings = new LinkedHashMap<UniqueBindingKey, List<ComponentInstance>>();
		EcoreUtil2.eAllOfType(instance, ComponentInstance.class).forEach(source -> {
			collectCommonBindings(source, commonProcessorBindings, DeploymentProperties::getActualProcessorBinding,
					DeploymentProperties::getActualProcessorBinding_EObject);
			collectCommonBindings(source, commonMemoryBindings, DeploymentProperties::getActualMemoryBinding,
					DeploymentProperties::getActualMemoryBinding_EObject);
			collectCommonBindings(source, commonConnectionBindings, DeploymentProperties::getActualConnectionBinding,
					DeploymentProperties::getActualConnectionBinding_EObject);
		});
		commonProcessorBindings.forEach((key, sources) -> {
			var sourcePropagations = sources.stream()
					.map(source -> findBindingPropagation(source, BindingType.PROCESSOR))
					.filter(Objects::nonNull)
					.toList();
			var targetPropagations = key.bindingTargets()
					.stream()
					.map(target -> findBindingPropagation(target, BindingType.BINDINGS))
					.filter(Objects::nonNull)
					.toList();
			instantiateBindingPath(sourcePropagations, targetPropagations, BindingType.PROCESSOR);
			instantiateBindingPath(targetPropagations, sourcePropagations, BindingType.PROCESSOR);
		});
		commonMemoryBindings.forEach((key, sources) -> {
			var sourcePropagations = sources.stream()
					.map(source -> findBindingPropagation(source, BindingType.MEMORY))
					.filter(Objects::nonNull)
					.toList();
			var targetPropagations = key.bindingTargets()
					.stream()
					.map(target -> findBindingPropagation(target, BindingType.BINDINGS))
					.filter(Objects::nonNull)
					.toList();
			instantiateBindingPath(sourcePropagations, targetPropagations, BindingType.MEMORY);
			instantiateBindingPath(targetPropagations, sourcePropagations, BindingType.MEMORY);
		});
		commonConnectionBindings.forEach((key, sources) -> {
			var sourcePropagations = sources.stream()
					.map(source -> findBindingPropagation(source, BindingType.CONNECTION))
					.filter(Objects::nonNull)
					.toList();
			var targets = key.bindingTargets();
			var firstTargetPropagation = findBindingPropagation(targets.get(0), BindingType.BINDINGS);
			BindingPropagation lastTargetPropagation;
			if (targets.size() == 1) {
				lastTargetPropagation = firstTargetPropagation;
			} else {
				lastTargetPropagation = findBindingPropagation(targets.get(targets.size() - 1), BindingType.BINDINGS);
			}
			if (firstTargetPropagation != null) {
				instantiateBindingPath(sourcePropagations, List.of(firstTargetPropagation), BindingType.CONNECTION);
			}
			if (lastTargetPropagation != null) {
				instantiateBindingPath(List.of(lastTargetPropagation), sourcePropagations, BindingType.CONNECTION);
			}
		});
	}

	private record UniqueBindingKey(PropertyAssociation propertyAssociation, List<ComponentInstance> bindingTargets) {
	}

	private static void collectCommonBindings(ComponentInstance source,
			Map<UniqueBindingKey, List<ComponentInstance>> commonBindings,
			Function<ComponentInstance, Optional<List<InstanceObject>>> getProperty,
			Function<ComponentInstance, PropertyExpression> getExpression) {
		getProperty.apply(source).ifPresent(targets -> {
			var targetComponents = targets.stream()
					.filter(ComponentInstance.class::isInstance)
					.map(ComponentInstance.class::cast)
					.toList();
			if (!targetComponents.isEmpty()) {
				var expression = getExpression.apply(source);
				var instanceAssociation = getContainerOfType(expression, PropertyAssociationInstance.class);
				var key = new UniqueBindingKey(instanceAssociation.getPropertyAssociation(), targetComponents);
				commonBindings.computeIfAbsent(key, k -> new ArrayList<>()).add(source);
			}
		});
	}

	private void instantiateBindingPath(List<BindingPropagation> sourcePropagations,
			List<BindingPropagation> destinationPropagations, BindingType bindingType) {
		var outgoingSources = sourcePropagations.stream()
				.filter(propagation -> propagation.getDirection().outgoing())
				.toList();
		var incomingDestinations = destinationPropagations.stream()
				.filter(propagation -> propagation.getDirection().incoming())
				.toList();
		if (!outgoingSources.isEmpty() && !incomingDestinations.isEmpty()) {
			var commonContainer = Stream.concat(outgoingSources.stream(), incomingDestinations.stream())
					.map(propagation -> getContainerOfType(propagation, ComponentInstance.class))
					.reduce(EMV2AnnexInstantiator::getCommonContainer)
					.get();
			var substringIndex = commonContainer.getInstanceObjectPath().length() + 1;
			var sourcePaths = outgoingSources.stream()
					.map(propagation -> propagation.getInstanceObjectPath().substring(substringIndex))
					.collect(Collectors.joining(", "));
			if (outgoingSources.size() > 1) {
				sourcePaths = '(' + sourcePaths + ')';
			}
			var destinationPaths = incomingDestinations.stream()
					.map(propagation -> propagation.getInstanceObjectPath().substring(substringIndex))
					.collect(Collectors.joining(", "));
			if (incomingDestinations.size() > 1) {
				destinationPaths = '(' + destinationPaths + ')';
			}
			var bindingPath = EMV2InstanceFactory.eINSTANCE.createBindingPath();
			bindingPath.setName(sourcePaths + " -> " + destinationPaths);
			bindingPath.setType(bindingType);
			bindingPath.getSourcePropagations().addAll(sourcePropagations);
			bindingPath.getDestinationPropagations().addAll(destinationPropagations);
			getOrCreateEMV2AnnexInstance(commonContainer).getPropagationPaths().add(bindingPath);
		}
	}

	private static ComponentInstance getCommonContainer(ComponentInstance a, ComponentInstance b) {
		if (EcoreUtil.isAncestor(a, b)) {
			return a;
		} else {
			for (var container : EcoreUtil2.getAllContainers(a)) {
				if (container instanceof ComponentInstance containerComponent
						&& EcoreUtil.isAncestor(containerComponent, b)) {
					return containerComponent;
				}
			}
			return null;
		}
	}

	private EMV2AnnexInstance getOrCreateEMV2AnnexInstance(ComponentInstance component) {
		var annex = findEMV2AnnexInstance(component);
		if (annex == null) {
			annex = EMV2InstanceFactory.eINSTANCE.createEMV2AnnexInstance();
			annex.setName("EMV2");
			component.getAnnexInstances().add(annex);
		}
		return annex;
	}

	private void instantiatePropagationPoint(PropagationPoint g, EMV2AnnexInstance annex) {
		PropagationPointInstance gi = EMV2InstanceFactory.eINSTANCE.createPropagationPointInstance();
		gi.setName(g.getName());
		gi.setPropagationPoint(g);
		annex.getPropagationPoints().add(gi);
	}

	private void instantiateEvent(ErrorBehaviorEvent event, EMV2AnnexInstance annex) {
		if (event instanceof ErrorEvent errorEvent) {
			annex.getEvents().add(createErrorEventInstance(errorEvent));
		} else if (event instanceof RecoverEvent recoverEvent) {
			annex.getEvents().add(createRecoverEventInstance(recoverEvent, annex));
		} else if (event instanceof RepairEvent repairEvent) {
			annex.getEvents().add(createRepairEventInstance(repairEvent, annex));
		} else {
			throw new RuntimeException("Unexpected event: " + event);
		}
	}

	private ErrorEventInstance createErrorEventInstance(ErrorEvent event) {
		var eventInstance = EMV2InstanceFactory.eINSTANCE.createErrorEventInstance();
		eventInstance.setName(event.getName());
		eventInstance.setErrorEvent(event);
		if (event.getTypeSet() != null) {
			eventInstance.setTypeSet(createAnonymousTypeSet(event.getTypeSet()));
		}
		return eventInstance;
	}

	private RecoverEventInstance createRecoverEventInstance(RecoverEvent event, EMV2AnnexInstance annex) {
		var eventInstance = EMV2InstanceFactory.eINSTANCE.createRecoverEventInstance();
		eventInstance.setName(event.getName());
		eventInstance.setRecoverEvent(event);
		var component = getContainerOfType(annex, ComponentInstance.class);
		for (var initiator : event.getEventInitiator()) {
			if (initiator instanceof Feature feature) {
				eventInstance.getEventInitiators().add(findFeatureInstance(component, feature));
			} else if (initiator instanceof ModeTransition transition) {
				eventInstance.getEventInitiators().add(findModeTransitionInstance(component, transition));
			}
		}
		return eventInstance;
	}

	private RepairEventInstance createRepairEventInstance(RepairEvent event, EMV2AnnexInstance annex) {
		var eventInstance = EMV2InstanceFactory.eINSTANCE.createRepairEventInstance();
		eventInstance.setName(event.getName());
		eventInstance.setRepairEvent(event);
		var component = getContainerOfType(annex, ComponentInstance.class);
		for (var initiator : event.getEventInitiator()) {
			if (initiator instanceof Feature feature) {
				eventInstance.getEventInitiators().add(findFeatureInstance(component, feature));
			} else if (initiator instanceof ModeTransition transition) {
				eventInstance.getEventInitiators().add(findModeTransitionInstance(component, transition));
			}
		}
		return eventInstance;
	}

	private void instantiateState(ErrorBehaviorState state, EMV2AnnexInstance annex) {
		var stateInstance = EMV2InstanceFactory.eINSTANCE.createStateInstance();
		stateInstance.setName(state.getName());
		stateInstance.setState(state);
		if (state.getTypeSet() != null) {
			stateInstance.setTypeSet(createAnonymousTypeSet(state.getTypeSet()));
		}
		annex.getStates().add(stateInstance);
		if (state.isIntial()) {
			annex.setInitialState(stateInstance);
		}
	}

	private void instantiateTransition(ErrorBehaviorTransition transition, ComponentInstance component,
			EMV2AnnexInstance annex) {
		var transitionInstance = EMV2InstanceFactory.eINSTANCE.createTransitionInstance();
		if (transition.getName() != null) {
			transitionInstance.setName(transition.getName());
		}
		transitionInstance.setTransition(transition);
		transitionInstance.setSource(createTransitionSource(transition, annex));
		transitionInstance.setCondition(createConditionExpressionInstance(transition.getCondition(), component, annex));
		annex.getTransitions().add(transitionInstance);
	}

	private TransitionSource createTransitionSource(ErrorBehaviorTransition transition, EMV2AnnexInstance annex) {
		if (transition.isAllStates()) {
			return createAllSources();
		} else {
			return createStateReference(transition, annex);
		}
	}

	private AllSources createAllSources() {
		var allSources = EMV2InstanceFactory.eINSTANCE.createAllSources();
		allSources.setName("all");
		return allSources;
	}

	private SourceStateReference createStateReference(ErrorBehaviorTransition transition, EMV2AnnexInstance annex) {
		var stateReference = EMV2InstanceFactory.eINSTANCE.createSourceStateReference();
		stateReference.setState(findStateInstance(annex, transition.getSource()));
		if (transition.getTypeTokenConstraint() != null) {
			stateReference.setTypeSet(createAnonymousTypeSet(transition.getTypeTokenConstraint()));
		} else if (transition.getSource().getTypeSet() != null) {
			stateReference.setTypeSet(createAnonymousTypeSet(transition.getSource().getTypeSet()));
		}
		var name = stateReference.getState().getName();
		if (stateReference.getTypeSet() != null) {
			name = name + ' ' + stateReference.getTypeSet().getName();
		}
		stateReference.setName(name);
		return stateReference;
	}

	private ConditionExpressionInstance createConditionExpressionInstance(ConditionExpression condition,
			ComponentInstance component, EMV2AnnexInstance annex) {
		if (condition instanceof OrExpression orExpression) {
			return createCountExpression(orExpression.getOperands(), CountExpressionOperation.GREATER_EQUAL, 1,
					component, annex);
		} else if (condition instanceof AndExpression andExpression) {
			return createCountExpression(andExpression.getOperands(), CountExpressionOperation.EQUALS, 2, component,
					annex);
		} else if (condition instanceof AllExpression allExpression) {
			return createCountExpression(allExpression.getOperands(), CountExpressionOperation.EQUALS,
					allExpression.getOperands().size() - allExpression.getCount(), component, annex);
		} else if (condition instanceof OrmoreExpression orMoreExpression) {
			return createCountExpression(orMoreExpression.getOperands(), CountExpressionOperation.GREATER_EQUAL,
					orMoreExpression.getCount(), component, annex);
		} else if (condition instanceof OrlessExpression orLessExpression) {
			return createCountExpression(orLessExpression.getOperands(), CountExpressionOperation.LESS_EQUAL,
					orLessExpression.getCount(), component, annex);
		} else if (condition instanceof ConditionElement conditionElement) {
			var path = conditionElement.getQualifiedErrorPropagationReference().getEmv2Target();
			if (path.getNamedElement() instanceof ErrorBehaviorEvent event) {
				return createEventReference(event, conditionElement.getConstraint(), annex);
			} else {
				return createPropagationReference(component, path, conditionElement.getConstraint());
			}
		} else {
			return null;
		}
	}

	private EventReference createEventReference(ErrorBehaviorEvent event, TypeSet constraint, EMV2AnnexInstance annex) {
		var eventReference = EMV2InstanceFactory.eINSTANCE.createEventReference();
		eventReference.setEvent(findEventInstance(annex, event));
		/*
		 * In OSATE, it is possible to refer to an event and use the keyword 'noerror'. This is not permitted by the
		 * syntax in the standard and 'noerror' should only be used with propagations. An OSATE issue has been filed
		 * stating that the validator should complain in such cases: https://github.com/osate/osate2/issues/2817
		 *
		 * I consider it to be undefined behavior if an event is used with 'noerror', therefore, I have decided to treat
		 * such references as if the event was untyped.
		 */
		if (constraint != null && !constraint.getTypeTokens().isEmpty()
				&& !constraint.getTypeTokens().get(0).isNoError()) {
			eventReference.setTypeSet(createAnonymousTypeSet(constraint));
		} else if (constraint == null && event instanceof ErrorEvent errorEvent && errorEvent.getTypeSet() != null) {
			eventReference.setTypeSet(createAnonymousTypeSet(errorEvent.getTypeSet()));
		}
		var name = event.getName();
		if (eventReference.getTypeSet() != null) {
			name = name + ' ' + eventReference.getTypeSet().getName();
		}
		eventReference.setName(name);
		return eventReference;
	}

	private ConditionExpressionInstance createPropagationReference(ComponentInstance component, EMV2PathElement path,
			TypeSet constraint) {
		var currentComponent = component;
		var namePrefix = "";
		while (path.getNamedElement() instanceof Subcomponent subcomponent) {
			currentComponent = currentComponent.findSubcomponentInstance(subcomponent);
			namePrefix += currentComponent.getName() + '.';
			path = path.getPath();
		}
		while (path.getPath() != null) {
			path = path.getPath();
		}
		ErrorPropagationInstance propagationInstance;
		if (path.getNamedElement() instanceof ErrorPropagation propagation) {
			propagationInstance = findErrorPropagationInstance(findEMV2AnnexInstance(currentComponent), propagation);
		} else if (path.getEmv2PropagationKind().equalsIgnoreCase("access")) {
			propagationInstance = findAccessPropagation(currentComponent);
		} else {
			propagationInstance = findBindingPropagation(currentComponent,
					BindingType.get(path.getEmv2PropagationKind().toLowerCase()));
		}
		if (constraint != null && !constraint.getTypeTokens().isEmpty()
				&& constraint.getTypeTokens().get(0).isNoError()) {
			return createNoErrorPropagationReference(propagationInstance, namePrefix);
		} else {
			return createPropagationReference(propagationInstance, constraint, currentComponent == component,
					namePrefix);
		}
	}

	private PropagationReference createPropagationReference(ErrorPropagationInstance propagation, TypeSet constraint,
			boolean isInPropagation, String namePrefix) {
		var propagationReference = EMV2InstanceFactory.eINSTANCE.createPropagationReference();
		propagationReference.setPropagation(propagation);
		TypeSet typeSet;
		if (constraint != null) {
			typeSet = constraint;
		} else if (isInPropagation) {
			typeSet = propagation.getInErrorPropagation().getTypeSet();
		} else {
			typeSet = propagation.getOutErrorPropagation().getTypeSet();
		}
		var anonymousTypeSet = createAnonymousTypeSet(typeSet);
		propagationReference.setTypeSet(anonymousTypeSet);
		propagationReference.setName(namePrefix + propagation.getName() + ' ' + anonymousTypeSet.getName());
		return propagationReference;
	}

	private NoErrorPropagationReference createNoErrorPropagationReference(ErrorPropagationInstance propagation,
			String namePrefix) {
		var propagationReference = EMV2InstanceFactory.eINSTANCE.createNoErrorPropagationReference();
		propagationReference.setPropagation(propagation);
		propagationReference.setName(namePrefix + propagation.getName() + " {noerror}");
		return propagationReference;
	}

	private CountExpression createCountExpression(List<? extends ConditionExpression> operands,
			CountExpressionOperation operation, long count, ComponentInstance component, EMV2AnnexInstance annex) {
		var countExpression = EMV2InstanceFactory.eINSTANCE.createCountExpression();
		for (var operand : operands) {
			countExpression.getOperands().add(createConditionExpressionInstance(operand, component, annex));
		}
		countExpression.setOperation(operation);
		countExpression.setCount(count);
		var symbol = switch (operation) {
		case EQUALS -> "==";
		case GREATER_EQUAL -> ">=";
		case LESS_EQUAL -> "<=";
		};
		countExpression.setName(countExpression.getOperands()
				.stream()
				.map(NamedElement::getName)
				.collect(Collectors.joining(", ", "count(", ") " + symbol + " " + count)));
		return countExpression;
	}

	private void instantiateCompositeState(CompositeState st, EMV2AnnexInstance annex) {
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

	private void instantiateErrorPropagations(List<ErrorPropagation> eps, EMV2AnnexInstance annex) {
		var propagationInstances = new TreeMap<String, ErrorPropagationInstance>(String.CASE_INSENSITIVE_ORDER);
		for (var ep : eps) {
			var epi = propagationInstances.computeIfAbsent(EMV2Util.getPropagationName(ep),
					name -> createErrorPropagationInstance(annex, name, ep));
			if (epi == null) {
				// This can happen if the propagation points to an InternalFeature. In that case, simply skip this one.
				break;
			}
			switch (ep.getDirection()) {
			case IN:
				assert epi.getInErrorPropagation() == null && epi.getInTypeSet() == null : "In fields are already set.";
				epi.setInErrorPropagation(ep);
				epi.setInTypeSet(createAnonymousTypeSet(ep.getTypeSet()));
				break;
			case OUT:
				assert epi.getOutErrorPropagation() == null && epi.getOutTypeSet() == null
						: "Out fields are already set.";
				epi.setOutErrorPropagation(ep);
				epi.setOutTypeSet(createAnonymousTypeSet(ep.getTypeSet()));
				break;
			case IN_OUT:
				throw new RuntimeException(
						"Propagation has an in out direction which is not supported by the grammar: " + ep);
			}
		}
	}

	private ErrorPropagationInstance createErrorPropagationInstance(EMV2AnnexInstance annex, String name,
			ErrorPropagation ep) {
		ErrorPropagationInstance propagation;
		if ("access".equalsIgnoreCase(ep.getKind())) {
			propagation = createAccessPropagation(name);
		} else if (ep.getKind() != null) {
			propagation = createBindingPropagation(name, ep.getKind());
		} else if (ep.getFeatureorPPRef() != null) {
			var featureOrPPRef = ep.getFeatureorPPRef();
			var featureOrPP = featureOrPPRef.getFeatureorPP();
			if (featureOrPP instanceof Feature) {
				propagation = createFeaturePropagation(annex, name, featureOrPPRef);
			} else if (featureOrPP instanceof PropagationPoint point) {
				propagation = createPointPropagation(annex, name, point);
			} else if (featureOrPP instanceof InternalFeature) {
				// Propagation not instantiated since InternalFeatures are not instantiated.
				return null;
			} else {
				throw new RuntimeException(
						"featureorPPRef points to something other than a Feature, an InternalFeature, or a PropagationPoint: "
								+ featureOrPP);
			}
		} else {
			throw new RuntimeException("Both kind and featureOrPPRef are null: " + ep);
		}
		annex.getPropagations().add(propagation);
		return propagation;
	}

	private FeaturePropagation createFeaturePropagation(EMV2AnnexInstance annex, String name,
			FeatureorPPReference featureReference) {
		var propagation = EMV2InstanceFactory.eINSTANCE.createFeaturePropagation();
		propagation.setName(name);
		propagation
				.setFeature(findFeatureInstance(getContainerOfType(annex, ComponentInstance.class), featureReference));
		return propagation;
	}

	private PointPropagation createPointPropagation(EMV2AnnexInstance annex, String name,
			PropagationPoint propagationPoint) {
		var propagation = EMV2InstanceFactory.eINSTANCE.createPointPropagation();
		propagation.setName(name);
		propagation.setPoint(findPropagationPointInstance(annex, propagationPoint));
		return propagation;
	}

	private AccessPropagation createAccessPropagation(String name) {
		var propagation = EMV2InstanceFactory.eINSTANCE.createAccessPropagation();
		propagation.setName(name);
		return propagation;
	}

	private BindingPropagation createBindingPropagation(String name, String kind) {
		var propagation = EMV2InstanceFactory.eINSTANCE.createBindingPropagation();
		propagation.setName(name);
		propagation.setBinding(BindingType.get(kind.toLowerCase()));
		return propagation;
	}

	private AnonymousTypeSet createAnonymousTypeSet(TypeSet set) {
		var anonymousTypeSet = EMV2InstanceFactory.eINSTANCE.createAnonymousTypeSet();
		anonymousTypeSet.getElements().addAll(createTypeSetElements(set.getTypeTokens(), 0));
		anonymousTypeSet.setName(anonymousTypeSet.getElements()
				.stream()
				.map(NamedElement::getName)
				.collect(Collectors.joining(", ", "{", "}")));
		return anonymousTypeSet;
	}

	private List<TypeSetElement> createTypeSetElements(List<TypeToken> tokens, int depth) {
		var results = new ArrayList<TypeSetElement>();
		for (var token : tokens) {
			if (token.getType().size() == 1) {
				var element = token.getType().get(0);
				if (element instanceof ErrorType type) {
					results.add(createTypeInstance(type));
				} else if (element instanceof TypeSet set) {
					results.add(createTypeSetInstance(set, depth));
				} else {
					throw new RuntimeException("element is something other than an ErrorType or a TypeSet: " + element);
				}
			} else {
				results.add(createTypeProductInstance(token));
			}
		}
		return results;
	}

	private TypeInstance createTypeInstance(ErrorType type) {
		var typeInstance = EMV2InstanceFactory.eINSTANCE.createTypeInstance();
		typeInstance.setName(type.getName());
		typeInstance.setType(type);
		return typeInstance;
	}

	private TypeSetInstance createTypeSetInstance(TypeSet set, int depth) {
		var typeSetInstance = EMV2InstanceFactory.eINSTANCE.createTypeSetInstance();
		typeSetInstance.setName(set.getName());
		typeSetInstance.setTypeSet(set);
		if (depth > 50) {
			// TODO Add error marker stating that there is a cycle.
		} else {
			typeSetInstance.getElements()
					.addAll(createTypeSetElements(EMV2Util.resolveAlias(set).getTypeTokens(), depth + 1));
		}
		return typeSetInstance;
	}

	private TypeProductInstance createTypeProductInstance(TypeToken token) {
		var product = EMV2InstanceFactory.eINSTANCE.createTypeProductInstance();
		product.setName(token.getType().stream().map(NamedElement::getName).collect(Collectors.joining(" * ")));
		for (var element : token.getType()) {
			if (element instanceof ErrorType type) {
				product.getTypes().add(createTypeInstance(type));
			}
			// TODO Add error marker to instance model if element is a type set.
		}
		return product;
	}

	private void instantiateErrorSource(ErrorSource source, EMV2AnnexInstance annex) {
		if (source.isAll()) {
			// TODO Instantiate 'all' error sources after we figure out what 'all' means.
			return;
		}
		var propagation = (ErrorPropagation) source.getSourceModelElement();
		if (propagation.getFeatureorPPRef() != null
				&& propagation.getFeatureorPPRef().getFeatureorPP() instanceof InternalFeature) {
			// Error source not instantiated since propagations that refer to internal features are not instantiated.
			return;
		}
		var sourceInstance = EMV2InstanceFactory.eINSTANCE.createErrorSourceInstance();
		sourceInstance.setName(source.getName());
		sourceInstance.setErrorSource(source);
		sourceInstance.setPropagation(findErrorPropagationInstance(annex, propagation));
		var typeSet = source.getTypeTokenConstraint();
		if (typeSet == null) {
			typeSet = propagation.getTypeSet();
		}
		sourceInstance.setTypeSet(createAnonymousTypeSet(typeSet));
		annex.getErrorFlows().add(sourceInstance);
	}

	private void instantiateErrorSink(ErrorSink sink, EMV2AnnexInstance annex) {
		if (sink.isAllIncoming()) {
			// TODO Instantiate 'all' error sinks after we figure out what 'all' means.
			return;
		}
		var propagation = sink.getIncoming();
		if (propagation.getFeatureorPPRef() != null
				&& propagation.getFeatureorPPRef().getFeatureorPP() instanceof InternalFeature) {
			// Error sink not instantiated since propagations that refer to internal features are not instantiated.
			return;
		}
		var sinkInstance = EMV2InstanceFactory.eINSTANCE.createErrorSinkInstance();
		sinkInstance.setName(sink.getName());
		sinkInstance.setErrorSink(sink);
		sinkInstance.setPropagation(findErrorPropagationInstance(annex, propagation));
		var typeSet = sink.getTypeTokenConstraint();
		if (typeSet == null) {
			typeSet = propagation.getTypeSet();
		}
		sinkInstance.setTypeSet(createAnonymousTypeSet(typeSet));
		annex.getErrorFlows().add(sinkInstance);
	}

	private void instantiateErrorPath(ErrorPath path, EMV2AnnexInstance annex) {
		if (path.isAllIncoming() || path.isAllOutgoing()) {
			// TODO Instantiate 'all' error paths after we figure out what 'all' means.
			return;
		}
		if (path.getTargetToken() == null) {
			// TODO Instantiate after we figure out what it means when the target token is omitted.
			return;
		}
		var sourcePropagation = path.getIncoming();
		if (sourcePropagation.getFeatureorPPRef() != null
				&& sourcePropagation.getFeatureorPPRef().getFeatureorPP() instanceof InternalFeature) {
			// Error path not instantiated since propagations that refer to internal features are not instantiated.
			return;
		}
		var destinationPropagation = path.getOutgoing();
		if (destinationPropagation.getFeatureorPPRef() != null
				&& destinationPropagation.getFeatureorPPRef().getFeatureorPP() instanceof InternalFeature) {
			// Error path not instantiated since propagations that refer to internal features are not instantiated.
			return;
		}
		var pathInstance = EMV2InstanceFactory.eINSTANCE.createErrorPathInstance();
		pathInstance.setName(path.getName());
		pathInstance.setErrorPath(path);
		pathInstance.setSourcePropagation(findErrorPropagationInstance(annex, sourcePropagation));
		pathInstance.setDestinationPropagation(findErrorPropagationInstance(annex, destinationPropagation));
		var sourceTypeSet = path.getTypeTokenConstraint();
		if (sourceTypeSet == null) {
			sourceTypeSet = sourcePropagation.getTypeSet();
		}
		pathInstance.setSourceTypeSet(createAnonymousTypeSet(sourceTypeSet));
		pathInstance.setDestinationTypeSet(createAnonymousTypeSet(path.getTargetToken()));
		annex.getErrorFlows().add(pathInstance);
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
		ComponentInstance ci = (ComponentInstance) eai.eContainer();
		ConstrainedInstanceObject cio = EMV2InstanceFactory.eINSTANCE.createConstrainedInstanceObject();
		FeatureorPPReference fppref = ep.getFeatureorPPRef();
		if (fppref != null) {
			NamedElement fpp = fppref.getFeatureorPP();
			if (fpp instanceof Feature) {
				FeatureInstance fi = findFeatureInstance(ci, fppref);
				cio.setInstanceObject(fi);
				cio.setName(fi.getName());
			} else if (fpp instanceof PropagationPoint) {
				PropagationPointInstance ppi = findPropagationPointInstance(eai, (PropagationPoint) fpp);
				cio.setInstanceObject(ppi);
				cio.setName(ppi.getName());
			}
		} else if (ep.getKind() != null) {
			cio.setInstanceObject(ci);
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

	private void instantiateOutgoingPropagationCondition(OutgoingPropagationCondition opc, EMV2AnnexInstance annex) {
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
					.getAllOutgoingErrorPropagations(((ComponentInstance) annex.eContainer()).getComponentClassifier());
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

	private void instantiateErrorDetection(ErrorDetection ed, EMV2AnnexInstance annex) {
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
		TriggerPort tp = (TriggerPort) ed.getDetectionReportingPort().getElement();
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
		for (var stateInstance : annex.getStates()) {
			if (stateInstance.getState() == state) {
				return stateInstance;
			}
		}
		return null;
	}

	private ConstraintElement instantiateCondition(ConditionExpression condition, EMV2AnnexInstance annex) {

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
						cio.getConstraint().addAll(EcoreUtil.copyAll(referencedErrorType.getTypeTokens()));
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
					ConstrainedInstanceObject cio = createErrorPropagationCIO(ep, EcoreUtil.copy(referencedErrorType),
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
					if (evi != null) {
						cio.setInstanceObject(evi);
						cio.setName(evi.getName());
						TypeSet ts = conditionElement.getConstraint() != null ? conditionElement.getConstraint()
								: ((ErrorEvent) errorModelElement).getTypeSet();
						if (ts != null) {
							cio.getConstraint().addAll(EcoreUtil.copyAll(ts.getTypeTokens()));
						}
						return cio;
					}
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
			if (ei.getName().equalsIgnoreCase(ev.getName())) {
				return ei;
			}
		}
		return null;
	}

	private EMV2AnnexInstance findEMV2AnnexInstance(ComponentInstance ci) {
		for (AnnexInstance ai : ci.getAnnexInstances()) {
			if (ai instanceof EMV2AnnexInstance emv2AI) {
				return emv2AI;
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

	private FeatureInstance findFeatureInstance(ComponentInstance component, Feature feature) {
		for (var featureInstance : component.getFeatureInstances()) {
			if (featureInstance.getFeature() == feature) {
				return featureInstance;
			}
		}
		return null;
	}

	private ModeTransitionInstance findModeTransitionInstance(ComponentInstance component, ModeTransition transition) {
		for (var transitionInstance : component.getModeTransitionInstances()) {
			if (transitionInstance.getModeTransition() == transition) {
				return transitionInstance;
			}
		}
		return null;
	}

	private ErrorPropagationInstance findErrorPropagationInstance(EMV2AnnexInstance annex, ErrorPropagation ep) {
		var declarativeName = EMV2Util.getPropagationName(ep);
		for (ErrorPropagationInstance epi : annex.getPropagations()) {
			if (epi.getName().equalsIgnoreCase(declarativeName)) {
				return epi;
			}
		}
		return null;
	}

	private FeaturePropagation findFeaturePropagation(FeatureInstance feature) {
		var annex = findEMV2AnnexInstance(EcoreUtil2.getContainerOfType(feature, ComponentInstance.class));
		if (annex == null) {
			return null;
		}
		for (var propagation : annex.getPropagations()) {
			if (propagation instanceof FeaturePropagation featurePropagation
					&& featurePropagation.getFeature() == feature) {
				return featurePropagation;
			}
		}
		return null;
	}

	private PointPropagation findPointPropagation(PropagationPointInstance point) {
		var annex = findEMV2AnnexInstance(EcoreUtil2.getContainerOfType(point, ComponentInstance.class));
		if (annex == null) {
			return null;
		}
		for (var propagation : annex.getPropagations()) {
			if (propagation instanceof PointPropagation pointPropagation && pointPropagation.getPoint() == point) {
				return pointPropagation;
			}
		}
		return null;
	}

	private AccessPropagation findAccessPropagation(ComponentInstance component) {
		var annex = findEMV2AnnexInstance(component);
		if (annex == null) {
			return null;
		}
		for (var propagation : annex.getPropagations()) {
			if (propagation instanceof AccessPropagation accessPropagation) {
				return accessPropagation;
			}
		}
		return null;
	}

	private BindingPropagation findBindingPropagation(ComponentInstance component, BindingType binding) {
		var annex = findEMV2AnnexInstance(component);
		if (annex == null) {
			return null;
		}
		for (var propagation : annex.getPropagations()) {
			if (propagation instanceof BindingPropagation bindingPropagation
					&& bindingPropagation.getBinding() == binding) {
				return bindingPropagation;
			}
		}
		return null;
	}

	private void instantiateUserDefinedPath(PropagationPath path, EMV2AnnexInstance annex, ComponentInstance context) {
		// Paths that point to a feature are not instantiated.
		if (getQualifiedPointReference(path.getSource()) instanceof PropagationPoint source
				&& getQualifiedPointReference(path.getTarget()) instanceof PropagationPoint destination) {
			var pathInstance = EMV2InstanceFactory.eINSTANCE.createUserDefinedPath();
			pathInstance.setPath(path);
			var sourcePointInstance = findPropagationPointInstance(path.getSource(), context, source);
			pathInstance.setSourcePoint(sourcePointInstance);
			var destinationPointInstance = findPropagationPointInstance(path.getTarget(), context, destination);
			pathInstance.setDestinationPoint(destinationPointInstance);
			if (path.getName() == null) {
				var substringIndex = context.getInstanceObjectPath().length() + 1;
				var sourcePath = sourcePointInstance.getInstanceObjectPath().substring(substringIndex);
				var destinationPath = destinationPointInstance.getInstanceObjectPath().substring(substringIndex);
				pathInstance.setName(sourcePath + " -> " + destinationPath);
			} else {
				pathInstance.setName(path.getName());
			}
			var sourcePropagation = findPointPropagation(sourcePointInstance);
			if (sourcePropagation != null && sourcePropagation.getDirection().outgoing()) {
				pathInstance.setSourcePropagation(sourcePropagation);
			}
			var destinationPropagation = findPointPropagation(destinationPointInstance);
			if (destinationPropagation != null && destinationPropagation.getDirection().incoming()) {
				pathInstance.setDestinationPropagation(destinationPropagation);
			}
			annex.getPropagationPaths().add(pathInstance);
		}
	}

	private static NamedElement getQualifiedPointReference(QualifiedPropagationPoint path) {
		while (path.getNext() != null) {
			path = path.getNext();
		}
		return path.getPropagationPoint();
	}

	private PropagationPointInstance findPropagationPointInstance(QualifiedPropagationPoint path,
			ComponentInstance component, PropagationPoint point) {
		while (path.getSubcomponent() != null) {
			component = component.findSubcomponentInstance(path.getSubcomponent().getSubcomponent());
			path = path.getNext();
		}
		return findPropagationPointInstance(findEMV2AnnexInstance(component), point);
	}
}