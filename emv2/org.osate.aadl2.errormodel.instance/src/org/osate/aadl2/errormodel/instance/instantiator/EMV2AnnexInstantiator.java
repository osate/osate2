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

import java.math.BigDecimal;
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
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.contrib.deployment.DeploymentProperties;
import org.osate.aadl2.errormodel.instance.AccessPropagation;
import org.osate.aadl2.errormodel.instance.AllPropagations;
import org.osate.aadl2.errormodel.instance.AllPropagationsNoError;
import org.osate.aadl2.errormodel.instance.AllSources;
import org.osate.aadl2.errormodel.instance.AnonymousTypeSet;
import org.osate.aadl2.errormodel.instance.BindingPropagation;
import org.osate.aadl2.errormodel.instance.BindingType;
import org.osate.aadl2.errormodel.instance.Branch;
import org.osate.aadl2.errormodel.instance.BranchSameState;
import org.osate.aadl2.errormodel.instance.BranchStateReference;
import org.osate.aadl2.errormodel.instance.Branches;
import org.osate.aadl2.errormodel.instance.CompositeConditionExpression;
import org.osate.aadl2.errormodel.instance.ConditionExpressionInstance;
import org.osate.aadl2.errormodel.instance.ConditionPropagationReference;
import org.osate.aadl2.errormodel.instance.ConnectionEndPropagation;
import org.osate.aadl2.errormodel.instance.ConstantCode;
import org.osate.aadl2.errormodel.instance.CountExpression;
import org.osate.aadl2.errormodel.instance.CountExpressionOperation;
import org.osate.aadl2.errormodel.instance.DestinationPropagationReference;
import org.osate.aadl2.errormodel.instance.DestinationStateReference;
import org.osate.aadl2.errormodel.instance.DetectionInstance;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.EMV2InstanceFactory;
import org.osate.aadl2.errormodel.instance.ErrorCodeInstance;
import org.osate.aadl2.errormodel.instance.ErrorEventInstance;
import org.osate.aadl2.errormodel.instance.ErrorPropagationInstance;
import org.osate.aadl2.errormodel.instance.EventInstance;
import org.osate.aadl2.errormodel.instance.EventReference;
import org.osate.aadl2.errormodel.instance.FeaturePropagation;
import org.osate.aadl2.errormodel.instance.IntegerCode;
import org.osate.aadl2.errormodel.instance.NoErrorPropagationReference;
import org.osate.aadl2.errormodel.instance.OthersExpression;
import org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionDestination;
import org.osate.aadl2.errormodel.instance.PointPropagation;
import org.osate.aadl2.errormodel.instance.PropagationPointInstance;
import org.osate.aadl2.errormodel.instance.RecoverEventInstance;
import org.osate.aadl2.errormodel.instance.RepairEventInstance;
import org.osate.aadl2.errormodel.instance.SameState;
import org.osate.aadl2.errormodel.instance.SourceStateReference;
import org.osate.aadl2.errormodel.instance.StateInstance;
import org.osate.aadl2.errormodel.instance.StateReference;
import org.osate.aadl2.errormodel.instance.StateSource;
import org.osate.aadl2.errormodel.instance.StringCode;
import org.osate.aadl2.errormodel.instance.TransitionDestination;
import org.osate.aadl2.errormodel.instance.TypeInstance;
import org.osate.aadl2.errormodel.instance.TypeProductInstance;
import org.osate.aadl2.errormodel.instance.TypeSetElement;
import org.osate.aadl2.errormodel.instance.TypeSetInstance;
import org.osate.aadl2.instance.AnnexInstance;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceFactory;
import org.osate.aadl2.instance.InstanceObject;
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
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation;
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
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping;
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
import org.osate.xtext.aadl2.errormodel.errorModel.ReportingPortReference;
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

import com.google.common.collect.Lists;

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
			instantiatePropagationPoint(pp, instance, emv2AI);
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
			instantiateErrorSink(sink, instance, emv2AI);
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
			instantiateCompositeState(cs, instance, emv2AI);
		}

		Collection<OutgoingPropagationCondition> OPCs = EMV2Util.getAllOutgoingPropagationConditions(instance);
		for (OutgoingPropagationCondition opc : OPCs) {
			instantiateOutgoingPropagationCondition(opc, instance, emv2AI);
		}

		Collection<ErrorDetection> eds = EMV2Util.getAllErrorDetections(instance.getComponentClassifier());
		for (ErrorDetection ed : eds) {
			instantiateDetection(ed, instance, emv2AI);
		}

		for (var modeMapping : EMV2Util.getAllModeMappings(instance.getComponentClassifier())) {
			instantiateModeMapping(modeMapping, instance, emv2AI);
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

	private void instantiatePropagationPoint(PropagationPoint g, ComponentInstance component, EMV2AnnexInstance annex) {
		PropagationPointInstance gi = EMV2InstanceFactory.eINSTANCE.createPropagationPointInstance();
		gi.setName(g.getName());
		gi.setPropagationPoint(g);

		var associations = new LinkedHashMap<Property, EMV2PropertyAssociation>();
		var expectedContainmentPath = new ArrayDeque<ComponentInstance>();
		for (var currentComponent = component; currentComponent != null; currentComponent = currentComponent
				.getContainingComponentInstance()) {
			for (var subclause : Lists.reverse(EMV2Util.getAllContainingClassifierEMV2Subclauses(currentComponent))) {
				for (var association : subclause.getProperties()) {
					if (association.getOwnedValues().size() == 1
							&& association.getOwnedValues().get(0).getInModes().isEmpty()) {
						for (var path : association.getEmv2Path()) {
							var target = path.getEmv2Target();
							if (matchesContainmentPath(expectedContainmentPath, path) && target.getNamedElement() == g
									&& target.getPath() == null) {
								associations.put(association.getProperty(), association);
							}
						}
					}
				}
			}
			expectedContainmentPath.addFirst(currentComponent);
		}

		associations.forEach((property, association) -> {
			var propertyInstance = InstanceFactory.eINSTANCE.createPropertyAssociationInstance();
			propertyInstance.setPropertyAssociation(association);
			propertyInstance.setProperty(property);
			var declarativeValue = association.getOwnedValues().get(0).getOwnedValue();
			propertyInstance.createOwnedValue().setOwnedValue(EcoreUtil.copy(declarativeValue));
			gi.getOwnedPropertyAssociations().add(propertyInstance);
		});

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
				eventInstance.getEventInitiators().add(component.findFeatureInstance(feature));
			} else if (initiator instanceof ModeTransition transition) {
				eventInstance.getEventInitiators().add(component.findModeTransitionInstance(transition));
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
				eventInstance.getEventInitiators().add(component.findFeatureInstance(feature));
			} else if (initiator instanceof ModeTransition transition) {
				eventInstance.getEventInitiators().add(component.findModeTransitionInstance(transition));
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
		try {
			var transitionInstance = EMV2InstanceFactory.eINSTANCE.createTransitionInstance();
			transitionInstance.setTransition(transition);
			transitionInstance.setSource(createStateSource(transition, annex));
			transitionInstance
					.setCondition(createConditionExpressionInstance(transition.getCondition(), component, annex));
			transitionInstance.setDestination(createTransitionDestination(transition, transitionInstance.getSource(),
					transitionInstance.getCondition(), annex));
			if (transition.getName() == null) {
				var sourceName = transitionInstance.getSource().getName();
				var conditionName = transitionInstance.getCondition().getName();
				var destinationName = transitionInstance.getDestination().getName();
				transitionInstance.setName(sourceName + " -[" + conditionName + "]-> " + destinationName);
			} else {
				transitionInstance.setName(transition.getName());
			}
			annex.getTransitions().add(transitionInstance);
		} catch (InternalFeatureEncounteredException e) {
			// Abort instantiation of transition.
		}
	}

	private StateSource createStateSource(ErrorBehaviorTransition transition, EMV2AnnexInstance annex) {
		return createStateSource(transition.isAllStates(), transition.getSource(), transition.getTypeTokenConstraint(),
				annex);
	}

	private StateSource createStateSource(OutgoingPropagationCondition condition, EMV2AnnexInstance annex) {
		return createStateSource(condition.isAllStates(), condition.getState(), condition.getTypeTokenConstraint(),
				annex);
	}

	private StateSource createStateSource(ErrorDetection detection, EMV2AnnexInstance annex) {
		return createStateSource(detection.isAllStates(), detection.getState(), detection.getTypeTokenConstraint(),
				annex);
	}

	private StateSource createStateSource(boolean allStates, ErrorBehaviorState state, TypeSet typeSet,
			EMV2AnnexInstance annex) {
		if (allStates) {
			return createAllSources();
		} else {
			return createSourceStateReference(state, typeSet, annex);
		}
	}

	private AllSources createAllSources() {
		var allSources = EMV2InstanceFactory.eINSTANCE.createAllSources();
		allSources.setName("all");
		return allSources;
	}

	private SourceStateReference createSourceStateReference(ErrorBehaviorState state, TypeSet typeSet,
			EMV2AnnexInstance annex) {
		var stateReference = EMV2InstanceFactory.eINSTANCE.createSourceStateReference();
		stateReference.setState(findStateInstance(annex, state));
		if (typeSet != null) {
			stateReference.setTypeSet(createAnonymousTypeSet(typeSet));
		} else if (state.getTypeSet() != null) {
			stateReference.setTypeSet(createAnonymousTypeSet(state.getTypeSet()));
		}
		var name = stateReference.getState().getName();
		if (stateReference.getTypeSet() != null) {
			name += ' ' + stateReference.getTypeSet().getName();
		}
		stateReference.setName(name);
		return stateReference;
	}

	private ConditionExpressionInstance createConditionExpressionInstance(ConditionExpression condition,
			ComponentInstance component, EMV2AnnexInstance annex) throws InternalFeatureEncounteredException {
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
		} else if (condition instanceof SConditionElement conditionElement
				&& conditionElement.getQualifiedState() != null) {
			return createStateReference(component, conditionElement.getQualifiedState(),
					conditionElement.getConstraint());
		} else if (condition instanceof ConditionElement conditionElement) {
			var path = conditionElement.getQualifiedErrorPropagationReference().getEmv2Target();
			if (path.getNamedElement() instanceof ErrorBehaviorEvent event) {
				return createEventReference(event, conditionElement.getConstraint(), annex);
			} else {
				return createConditionPropagationReference(component, path, conditionElement.getConstraint());
			}
		} else {
			return null;
		}
	}

	private StateReference createStateReference(ComponentInstance component, QualifiedErrorBehaviorState path,
			TypeSet constraint) {
		var name = new StringBuilder();
		while (path.getNext() != null) {
			component = component.findSubcomponentInstance(path.getSubcomponent().getSubcomponent());
			name.append(component.getName());
			name.append('.');
			path = path.getNext();
		}
		component = component.findSubcomponentInstance(path.getSubcomponent().getSubcomponent());
		name.append(component.getName());
		name.append('.');
		name.append(path.getState().getName());

		var stateReference = EMV2InstanceFactory.eINSTANCE.createStateReference();
		var state = path.getState();
		var annex = findEMV2AnnexInstance(component);
		if (annex == null) {
			// Shouldn't happen if the declarative model is valid.
			return null;
		}
		stateReference.setState(findStateInstance(annex, state));
		if (constraint != null) {
			stateReference.setTypeSet(createAnonymousTypeSet(constraint));
		} else if (state.getTypeSet() != null) {
			stateReference.setTypeSet(createAnonymousTypeSet(state.getTypeSet()));
		}
		if (stateReference.getTypeSet() != null) {
			name.append(' ');
			name.append(stateReference.getTypeSet().getName());
		}
		stateReference.setName(name.toString());
		return stateReference;
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
			name += ' ' + eventReference.getTypeSet().getName();
		}
		eventReference.setName(name);
		return eventReference;
	}

	private ConditionExpressionInstance createConditionPropagationReference(ComponentInstance component,
			EMV2PathElement path, TypeSet constraint) throws InternalFeatureEncounteredException {
		var currentComponent = component;
		var namePrefix = new StringBuilder();
		while (path.getNamedElement() instanceof Subcomponent subcomponent) {
			currentComponent = currentComponent.findSubcomponentInstance(subcomponent);
			namePrefix.append(currentComponent.getName());
			namePrefix.append('.');
			path = path.getPath();
		}
		while (path.getPath() != null) {
			path = path.getPath();
		}
		ErrorPropagationInstance propagationInstance;
		if (path.getNamedElement() instanceof ErrorPropagation propagation) {
			if (propagation.getFeatureorPPRef() != null
					&& propagation.getFeatureorPPRef().getFeatureorPP() instanceof InternalFeature) {
				throw new InternalFeatureEncounteredException();
			}
			var annex = findEMV2AnnexInstance(currentComponent);
			if (annex == null) {
				// Shouldn't happen if the declarative model is valid.
				return null;
			}
			propagationInstance = findErrorPropagationInstance(annex, propagation);
		} else if (path.getEmv2PropagationKind().equalsIgnoreCase("access")) {
			propagationInstance = findAccessPropagation(currentComponent);
		} else {
			propagationInstance = findBindingPropagation(currentComponent,
					BindingType.get(path.getEmv2PropagationKind().toLowerCase()));
		}
		if (propagationInstance == null) {
			// Shouldn't happen if the declarative model is valid.
			return null;
		}
		if (constraint != null && !constraint.getTypeTokens().isEmpty()
				&& constraint.getTypeTokens().get(0).isNoError()) {
			return createNoErrorPropagationReference(propagationInstance, namePrefix.toString());
		} else {
			return createConditionPropagationReference(propagationInstance, constraint, currentComponent == component,
					namePrefix.toString());
		}
	}

	private ConditionPropagationReference createConditionPropagationReference(ErrorPropagationInstance propagation,
			TypeSet constraint, boolean isInPropagation, String namePrefix) {
		var propagationReference = EMV2InstanceFactory.eINSTANCE.createConditionPropagationReference();
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
			CountExpressionOperation operation, long count, ComponentInstance component, EMV2AnnexInstance annex)
			throws InternalFeatureEncounteredException {
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

	private TransitionDestination createTransitionDestination(ErrorBehaviorTransition transition, StateSource source,
			ConditionExpressionInstance condition, EMV2AnnexInstance annex) {
		if (transition.isSteadyState()) {
			return createSameState();
		} else if (!transition.getDestinationBranches().isEmpty()) {
			return createBranches(transition.getDestinationBranches(), source, condition, annex);
		} else {
			return createDestinationStateReference(transition, source, condition, annex);
		}
	}

	private DestinationStateReference createDestinationStateReference(ErrorBehaviorTransition transition,
			StateSource source, ConditionExpressionInstance condition, EMV2AnnexInstance annex) {
		var stateReference = EMV2InstanceFactory.eINSTANCE.createDestinationStateReference();
		stateReference.setState(findStateInstance(annex, transition.getTarget()));
		stateReference.setTypeSet(createDestinationTypeSet(transition.getTargetToken(),
				transition.getTarget().getTypeSet() != null, source, condition));
		var name = stateReference.getState().getName();
		if (stateReference.getTypeSet() != null) {
			name += ' ' + stateReference.getTypeSet().getName();
		}
		stateReference.setName(name);
		return stateReference;
	}

	private AnonymousTypeSet createDestinationTypeSet(TypeSet explicitTypeSet, boolean destinationIsTyped,
			StateSource source, ConditionExpressionInstance condition) {
		if (explicitTypeSet != null) {
			return createAnonymousTypeSet(explicitTypeSet);
		} else if (destinationIsTyped && source instanceof SourceStateReference stateReference
				&& !(condition instanceof CountExpression)) {
			var sourceTypeSet = stateReference.getTypeSet();
			AnonymousTypeSet conditionTypeSet = null;
			if (condition instanceof EventReference eventReference) {
				conditionTypeSet = eventReference.getTypeSet();
			} else if (condition instanceof ConditionPropagationReference propagationReference) {
				conditionTypeSet = propagationReference.getTypeSet();
			}
			if (sourceTypeSet != null && sourceTypeSet.flatten().size() == 1 && conditionTypeSet == null) {
				return EcoreUtil.copy(sourceTypeSet);
			} else if (sourceTypeSet == null && conditionTypeSet != null && conditionTypeSet.flatten().size() == 1) {
				return EcoreUtil.copy(conditionTypeSet);
			}
		}
		return null;
	}

	private SameState createSameState() {
		var sameState = EMV2InstanceFactory.eINSTANCE.createSameState();
		sameState.setName("same state");
		return sameState;
	}

	private Branches createBranches(List<TransitionBranch> branches, StateSource source,
			ConditionExpressionInstance condition, EMV2AnnexInstance annex) {
		var hasOthers = false;
		var hasProperty = false;
		for (var branch : branches) {
			if (branch.getValue().isOthers()) {
				hasOthers = true;
			}
			if (branch.getValue().getSymboliclabel() != null) {
				hasProperty = true;
			}
		}
		BigDecimal remaining = null;
		if (hasOthers && !hasProperty) {
			var sum = new BigDecimal(0);
			for (var branch : branches) {
				if (branch.getValue().getRealvalue() != null) {
					sum = sum.add(new BigDecimal(branch.getValue().getRealvalue().replace("_", "")));
				}
			}
			remaining = new BigDecimal(1).subtract(sum);
		}
		var branchesInstance = EMV2InstanceFactory.eINSTANCE.createBranches();
		for (var branch : branches) {
			branchesInstance.getBranches().add(createBranch(branch, source, condition, remaining, annex));
		}
		branchesInstance.setName(branchesInstance.getBranches()
				.stream()
				.map(NamedElement::getName)
				.collect(Collectors.joining(", ", "(", ")")));
		return branchesInstance;
	}

	private Branch createBranch(TransitionBranch branch, StateSource source, ConditionExpressionInstance condition,
			BigDecimal remaining, EMV2AnnexInstance annex) {
		BigDecimal probability;
		String nameSuffix;
		if (branch.getValue().getRealvalue() != null) {
			probability = new BigDecimal(branch.getValue().getRealvalue().replace("_", ""));
			nameSuffix = probability.toString();
		} else if (branch.getValue().getSymboliclabel() != null) {
			probability = null;
			nameSuffix = branch.getValue().getSymboliclabel().getQualifiedName();
		} else if (remaining != null) {
			probability = remaining;
			nameSuffix = remaining.toString();
		} else {
			probability = null;
			nameSuffix = "others";
		}
		if (branch.isSteadyState()) {
			return createBranchSameState(probability, nameSuffix);
		} else {
			return createBranchStateReference(branch, source, condition, probability, nameSuffix, annex);
		}
	}

	private BranchSameState createBranchSameState(BigDecimal probability, String nameSuffix) {
		var sameState = EMV2InstanceFactory.eINSTANCE.createBranchSameState();
		sameState.setName("same state with " + nameSuffix);
		sameState.setProbability(probability);
		return sameState;
	}

	private BranchStateReference createBranchStateReference(TransitionBranch branch, StateSource source,
			ConditionExpressionInstance condition, BigDecimal probability, String nameSuffix, EMV2AnnexInstance annex) {
		var stateReference = EMV2InstanceFactory.eINSTANCE.createBranchStateReference();
		stateReference.setState(findStateInstance(annex, branch.getTarget()));
		stateReference.setTypeSet(createDestinationTypeSet(branch.getTargetToken(),
				branch.getTarget().getTypeSet() != null, source, condition));
		stateReference.setProbability(probability);
		var name = stateReference.getState().getName();
		if (stateReference.getTypeSet() != null) {
			name += ' ' + stateReference.getTypeSet().getName();
		}
		name += " with " + nameSuffix;
		stateReference.setName(name);
		return stateReference;
	}

	private void instantiateCompositeState(CompositeState composite, ComponentInstance component,
			EMV2AnnexInstance annex) {
		try {
			var compositeInstance = EMV2InstanceFactory.eINSTANCE.createCompositeStateInstance();
			compositeInstance.setComposite(composite);
			compositeInstance.setCondition(createCompositeConditionExpression(composite, component, annex));
			compositeInstance.setDestination(findStateInstance(annex, composite.getState()));
			if (composite.getTypedToken() != null) {
				compositeInstance.setDestinationTypeSet(createAnonymousTypeSet(composite.getTypedToken()));
			}
			if (composite.getName() == null) {
				var conditionName = compositeInstance.getCondition().getName();
				var destinationName = compositeInstance.getDestination().getName();
				var destinationTypeSetName = "";
				if (compositeInstance.getDestinationTypeSet() != null) {
					destinationTypeSetName = ' ' + compositeInstance.getDestinationTypeSet().getName();
				}
				compositeInstance.setName('[' + conditionName + "]-> " + destinationName + destinationTypeSetName);
			} else {
				compositeInstance.setName(composite.getName());
			}
			annex.getComposites().add(compositeInstance);
		} catch (InternalFeatureEncounteredException e) {
			// Abort instantiation of composite state.
		}
	}

	private CompositeConditionExpression createCompositeConditionExpression(CompositeState composite,
			ComponentInstance component, EMV2AnnexInstance annex) throws InternalFeatureEncounteredException {
		if (composite.isOthers()) {
			return createOthersExpression();
		} else {
			return createConditionExpressionInstance(composite.getCondition(), component, annex);
		}
	}

	private OthersExpression createOthersExpression() {
		var othersExpression = EMV2InstanceFactory.eINSTANCE.createOthersExpression();
		othersExpression.setName("others");
		return othersExpression;
	}

	private void instantiateErrorPropagations(List<ErrorPropagation> eps, EMV2AnnexInstance annex) {
		var propagationInstances = new TreeMap<String, ErrorPropagationInstance>(String.CASE_INSENSITIVE_ORDER);
		for (var ep : eps) {
			var epi = propagationInstances.computeIfAbsent(EMV2Util.getPropagationName(ep), name -> {
				try {
					return createErrorPropagationInstance(annex, name, ep);
				} catch (InternalFeatureEncounteredException e) {
					return null;
				}
			});
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
			ErrorPropagation ep) throws InternalFeatureEncounteredException {
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
				throw new InternalFeatureEncounteredException();
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

	private void instantiateErrorSink(ErrorSink sink, ComponentInstance component, EMV2AnnexInstance annex) {
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

		var associations = new LinkedHashMap<Property, EMV2PropertyAssociation>();
		var expectedContainmentPath = new ArrayDeque<ComponentInstance>();
		for (var currentComponent = component; currentComponent != null; currentComponent = currentComponent
				.getContainingComponentInstance()) {
			for (var subclause : Lists.reverse(EMV2Util.getAllContainingClassifierEMV2Subclauses(currentComponent))) {
				for (var association : subclause.getProperties()) {
					if (association.getOwnedValues().size() == 1
							&& association.getOwnedValues().get(0).getInModes().isEmpty()) {
						for (var path : association.getEmv2Path()) {
							var target = path.getEmv2Target();
							if (matchesContainmentPath(expectedContainmentPath, path)
									&& target.getNamedElement() == sink && target.getPath() == null) {
								associations.put(association.getProperty(), association);
							}
						}
					}
				}
			}
			expectedContainmentPath.addFirst(currentComponent);
		}

		associations.forEach((property, association) -> {
			var propertyInstance = InstanceFactory.eINSTANCE.createPropertyAssociationInstance();
			propertyInstance.setPropertyAssociation(association);
			propertyInstance.setProperty(property);
			var declarativeValue = association.getOwnedValues().get(0).getOwnedValue();
			propertyInstance.createOwnedValue().setOwnedValue(EcoreUtil.copy(declarativeValue));
			sinkInstance.getOwnedPropertyAssociations().add(propertyInstance);
		});

		annex.getErrorFlows().add(sinkInstance);
	}

	private static boolean matchesContainmentPath(Iterable<ComponentInstance> expectedContainmentPath,
			EMV2Path path) {
		var expectedIter = expectedContainmentPath.iterator();
		var currentCPE = path.getContainmentPath();
		while (expectedIter.hasNext() && currentCPE != null) {
			var expectedComponent = expectedIter.next();
			if (expectedComponent.getSubcomponent() != currentCPE.getNamedElement()) {
				return false;
			}
			currentCPE = currentCPE.getPath();
		}
		return !expectedIter.hasNext() && currentCPE == null;
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

	private void instantiateOutgoingPropagationCondition(OutgoingPropagationCondition condition,
			ComponentInstance component, EMV2AnnexInstance annex) {
		try {
			var conditionInstance = EMV2InstanceFactory.eINSTANCE.createOutgoingPropagationConditionInstance();
			conditionInstance.setOutgoingPropagationCondition(condition);
			conditionInstance.setSource(createStateSource(condition, annex));
			if (condition.getCondition() != null) {
				conditionInstance
						.setCondition(createConditionExpressionInstance(condition.getCondition(), component, annex));
			}
			conditionInstance.setDestination(createOutgoingPropagationConditionDestination(condition,
					conditionInstance.getSource(), conditionInstance.getCondition(), annex));
			if (condition.getName() == null) {
				var sourceName = conditionInstance.getSource().getName();
				var conditionExpressionName = "";
				if (conditionInstance.getCondition() != null) {
					conditionExpressionName = conditionInstance.getCondition().getName();
				}
				var destinationName = conditionInstance.getDestination().getName();
				conditionInstance.setName(sourceName + " -[" + conditionExpressionName + "]-> " + destinationName);
			} else {
				conditionInstance.setName(condition.getName());
			}
			annex.getConditions().add(conditionInstance);
		} catch (InternalFeatureEncounteredException e) {
			// Abort instantiation of outgoing propagation condition.
		}
	}

	private OutgoingPropagationConditionDestination createOutgoingPropagationConditionDestination(
			OutgoingPropagationCondition condition, StateSource source, ConditionExpressionInstance conditionExpression,
			EMV2AnnexInstance annex) throws InternalFeatureEncounteredException {
		if (condition.getTypeToken() != null && !condition.getTypeToken().getTypeTokens().isEmpty()
				&& condition.getTypeToken().getTypeTokens().get(0).isNoError()) {
			if (condition.isAllPropagations()) {
				return createAllPropagationsNoError();
			} else {
				var propagation = condition.getOutgoing();
				if (propagation.getFeatureorPPRef() != null
						&& propagation.getFeatureorPPRef().getFeatureorPP() instanceof InternalFeature) {
					throw new InternalFeatureEncounteredException();
				}
				var propagationInstance = findErrorPropagationInstance(annex, propagation);
				if (propagationInstance == null) {
					// Shouldn't happen if the declarative model is valid.
					return null;
				}
				return createNoErrorPropagationReference(propagationInstance, "");
			}
		} else if (condition.isAllPropagations()) {
			return createAllPropagations(condition, source, conditionExpression);
		} else {
			return createDestinationPropagationReference(condition, source, conditionExpression, annex);
		}
	}

	private DestinationPropagationReference createDestinationPropagationReference(
			OutgoingPropagationCondition condition, StateSource source, ConditionExpressionInstance conditionExpression,
			EMV2AnnexInstance annex) throws InternalFeatureEncounteredException {
		var propagation = condition.getOutgoing();
		if (propagation.getFeatureorPPRef() != null
				&& propagation.getFeatureorPPRef().getFeatureorPP() instanceof InternalFeature) {
			throw new InternalFeatureEncounteredException();
		}
		var propagationReference = EMV2InstanceFactory.eINSTANCE.createDestinationPropagationReference();
		propagationReference.setPropagation(findErrorPropagationInstance(annex, propagation));
		propagationReference
				.setTypeSet(createDestinationTypeSet(condition.getTypeToken(), true, source, conditionExpression));
		var name = propagationReference.getPropagation().getName();
		if (propagationReference.getTypeSet() != null) {
			name += ' ' + propagationReference.getTypeSet().getName();
		}
		propagationReference.setName(name);
		return propagationReference;
	}

	private AllPropagations createAllPropagations(OutgoingPropagationCondition condition, StateSource source,
			ConditionExpressionInstance conditionExpression) {
		var allPropagations = EMV2InstanceFactory.eINSTANCE.createAllPropagations();
		allPropagations
				.setTypeSet(createDestinationTypeSet(condition.getTypeToken(), true, source, conditionExpression));
		var name = "all";
		if (allPropagations.getTypeSet() != null) {
			name += ' ' + allPropagations.getTypeSet().getName();
		}
		allPropagations.setName(name);
		return allPropagations;
	}

	private AllPropagationsNoError createAllPropagationsNoError() {
		var allPropagations = EMV2InstanceFactory.eINSTANCE.createAllPropagationsNoError();
		allPropagations.setName("all {noerror}");
		return allPropagations;
	}

	private void instantiateDetection(ErrorDetection detection, ComponentInstance component, EMV2AnnexInstance annex) {
		if (detection.getDetectionReportingPort().getElement() instanceof InternalFeature) {
			// Detection not instantiated since InternalFeatures are not instantiated.
			return;
		}
		try {
			DetectionInstance detectionInstance = EMV2InstanceFactory.eINSTANCE.createDetectionInstance();
			detectionInstance.setDetection(detection);
			detectionInstance.setSource(createStateSource(detection, annex));
			if (detection.getCondition() != null) {
				detectionInstance
						.setCondition(createConditionExpressionInstance(detection.getCondition(), component, annex));
			}
			detectionInstance.setDestination(findFeatureInstance(detection.getDetectionReportingPort(), component));
			if (detection.getErrorCode() != null) {
				detectionInstance.setErrorCode(createErrorCodeInstance(detection.getErrorCode()));
			}
			if (detection.getName() == null) {
				var sourceName = detectionInstance.getSource().getName();
				var conditionName = "";
				if (detectionInstance.getCondition() != null) {
					conditionName = detectionInstance.getCondition().getName();
				}
				var destinationName = detectionInstance.getDestination().getName();
				var codeName = "";
				if (detectionInstance.getErrorCode() != null) {
					codeName = " (" + detectionInstance.getErrorCode().getName() + ')';
				}
				detectionInstance
						.setName(sourceName + " -[" + conditionName + "]-> " + destinationName + " !" + codeName);
			} else {
				detectionInstance.setName(detection.getName());
			}
			annex.getDetections().add(detectionInstance);
		} catch (InternalFeatureEncounteredException e) {
			// Abort instantiation of detection.
		}
	}

	private ErrorCodeInstance createErrorCodeInstance(ErrorCodeValue code) {
		if (code.getIntValue() != null) {
			return createIntegerCode(Long.parseLong(code.getIntValue()));
		} else if (code.getEnumLiteral() != null) {
			return createStringCode(code.getEnumLiteral());
		} else {
			return createConstantCode(code.getConstant());
		}
	}

	private IntegerCode createIntegerCode(long code) {
		var integerCode = EMV2InstanceFactory.eINSTANCE.createIntegerCode();
		integerCode.setName(Long.toString(code));
		integerCode.setCode(code);
		return integerCode;
	}

	private StringCode createStringCode(String code) {
		var stringCode = EMV2InstanceFactory.eINSTANCE.createStringCode();
		stringCode.setName('"' + code + '"');
		stringCode.setCode(code);
		return stringCode;
	}

	private ConstantCode createConstantCode(PropertyConstant constant) {
		var constantCode = EMV2InstanceFactory.eINSTANCE.createConstantCode();
		constantCode.setName(constant.getQualifiedName());
		constantCode.setCode(constant);
		return constantCode;
	}

	private void instantiateModeMapping(ErrorStateToModeMapping modeMapping, ComponentInstance component,
			EMV2AnnexInstance annex) {
		var modeMappingInstance = EMV2InstanceFactory.eINSTANCE.createModeMappingInstance();
		modeMappingInstance.setModeMapping(modeMapping);
		modeMappingInstance.setState(findStateInstance(annex, modeMapping.getErrorState()));
		if (modeMapping.getTypeToken() != null) {
			modeMappingInstance.setTypeSet(createAnonymousTypeSet(modeMapping.getTypeToken()));
		} else if (modeMapping.getErrorState().getTypeSet() != null) {
			modeMappingInstance.setTypeSet(createAnonymousTypeSet(modeMapping.getErrorState().getTypeSet()));
		}
		for (var mode : modeMapping.getMappedModes()) {
			modeMappingInstance.getModes().add(component.findModeInstance(mode));
		}
		var name = modeMapping.getErrorState().getName();
		if (modeMappingInstance.getTypeSet() != null) {
			name += ' ' + modeMappingInstance.getTypeSet().getName();
		}
		name += " in modes ("
				+ modeMapping.getMappedModes().stream().map(NamedElement::getName).collect(Collectors.joining(", "))
				+ ')';
		modeMappingInstance.setName(name);
		annex.getModeMappings().add(modeMappingInstance);
	}

	private StateInstance findStateInstance(EMV2AnnexInstance annex, ErrorBehaviorState state) {
		for (var stateInstance : annex.getStates()) {
			if (stateInstance.getState() == state) {
				return stateInstance;
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

	private FeatureInstance findFeatureInstance(ReportingPortReference portReference, ComponentInstance component) {
		if (portReference.getPrevious() == null) {
			return component.findFeatureInstance((Feature) portReference.getElement());
		} else {
			var previousFeatureGroup = findFeatureInstance(portReference.getPrevious(), component);
			return previousFeatureGroup.findFeatureInstance((Feature) portReference.getElement());
		}
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

	/**
	 * This exception is thrown when attempting to instantiate an element, but a reference to an internal feature was
	 * encountered. This could be a direct reference to an internal feature or a reference to a propagation that refers
	 * to an internal feature. When this is thrown, the element (transition, detection, etc) should not be instantiated.
	 *
	 */
	@SuppressWarnings("serial")
	private static class InternalFeatureEncounteredException extends Exception {
	}
}