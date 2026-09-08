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
package org.osate.xtext.aadl2.errormodel.scoping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.RecordType;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PathElement;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorEventOrPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.ReportingPortReference;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;
import org.osate.xtext.aadl2.errormodel.serializer.ErrorModelCrossReferenceSerializer;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;
import org.osate.xtext.aadl2.errormodel.util.ErrorModelUtil;
import org.osate.xtext.aadl2.properties.scoping.PropertiesScopeProvider;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 */
public class ErrorModelScopeProvider extends PropertiesScopeProvider {
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Override
	public IScope scope_NamedValue_namedValue(final Element context, final EReference reference) {
		var scope = delegateGetScope(context, reference);
		var property = propertyFor(context);
		var propertyType = property == null ? null : AadlUtil.getBasePropertyType(property.getPropertyType());
		return propertyType instanceof EnumerationType enumeration ? scopeFor(enumeration.getOwnedLiterals(), scope)
				: scope;
	}

	@Override
	public IScope scope_BasicPropertyAssociation_property(final Element context, final EReference reference) {
		var parentAssociation = EcoreUtil2.getContainerOfType(context.eContainer(), BasicPropertyAssociation.class);
		var property = parentAssociation == null
				? EcoreUtil2.getContainerOfType(context, EMV2PropertyAssociation.class).getProperty()
				: parentAssociation.getProperty();
		var baseType = AadlUtil.getBasePropertyType(property.getPropertyType());
		return baseType instanceof RecordType record ? scopeFor(record.getOwnedFields()) : IScope.NULLSCOPE;
	}

	@Override
	public IScope scope_ModalElement_inMode(final Element context, final EReference reference) {
		return IScope.NULLSCOPE;
	}

	public IScope scope_NumberValue_unit(final EObject context, final EReference reference) {
		return createUnitLiteralsScopeFromPropertyType(propertyFor(context).getPropertyType());
	}

	public IScope scope_ContainmentPathElement_namedElement(final ContainmentPathElement context,
			final EReference reference) {
		var parent = context.eContainer();
		if (parent instanceof EMV2Path) {
			var implementation = EcoreUtil2.getContainerOfType(parent, ComponentImplementation.class);
			return implementation == null ? IScope.NULLSCOPE
					: scopeFor(filterRefined(implementation.getAllSubcomponents()));
		}
		if (parent instanceof ContainmentPathElement previousPath
				&& previousPath.getNamedElement() instanceof Subcomponent previous && !previous.eIsProxy()
				&& previous.getAllClassifier() instanceof ComponentImplementation implementation) {
			return scopeFor(filterRefined(implementation.getAllSubcomponents()));
		}
		if (parent instanceof ReferenceValue) {
			var implementation2 = EcoreUtil2.getContainerOfType(parent, ComponentImplementation.class);
			Iterable<Subcomponent> subcomponents = implementation2 == null ? List.of()
					: filterRefined(implementation2.getAllSubcomponents());
			var subclause = EcoreUtil2.getContainerOfType(parent, ErrorModelSubclause.class);
			Iterable<ErrorType> types = subclause == null ? List.of()
					: subclause.getUseTypes().stream().flatMap(library -> library.getTypes().stream()).toList();
			return scopeFor(Iterables.concat(subcomponents, types));
		}
		return IScope.NULLSCOPE;
	}

	public SimpleScope scope_ErrorModelLibrary(final EObject context, final EReference reference) {
		return this.scopeWithoutEMV2Prefix(context, reference);
	}

	public SimpleScope scope_TypeMappingSet(final EObject context, final EReference reference) {
		return this.scopeWithoutEMV2Prefix(context, reference);
	}

	public SimpleScope scope_ErrorModelSubclause_useBehavior(final EObject context, final EReference reference) {
		return this.scopeWithoutEMV2Prefix(context, reference);
	}

	public SimpleScope scope_TypeTransformationSet(final EObject context, final EReference reference) {
		return this.scopeWithoutEMV2Prefix(context, reference);
	}

	/**
	 * This is a very complicated scoping rule. First of all, EMV2PathElement can be chained (e.g. "name1.name2.name3")
	 * and the contents of the scope are different for the first element than for subsequent elements. More importantly,
	 * the contents of the scope depend on which grammar rules were used to create the EMV2PathElement. In other words,
	 * the scope for an EMV2PathElement in the condition of an ErrorDetection is different from the scope for an
	 * EMV2PathElement in the "applies to" of an EMV2PropertyAssociation in an ErrorBehaviorStateMachine. To better
	 * understand this scoping rule, please use Graphviz on the following diagram:
	 *
	 * 	digraph EMV2PathElement {
	 * 		ErrorModelLibrary [fontcolor=blue, fontsize=20]
	 * 		ErrorModelSubclause [fontcolor=blue, fontsize=20]
	 * 		EMV2PathElementOrKind [fontcolor=red, fontsize=20]
	 * 		EMV2PathElement [fontcolor=red, fontsize=20]
	 * 		EMV2ErrorPropagationPath [fontcolor=red, fontsize=20]
	 * 		BasicEMV2Path -> EMV2PathElementOrKind
	 * 		EMV2Path -> EMV2PathElementOrKind
	 * 		EMV2PathElementOrKind -> EMV2PathElement
	 * 		EMV2PathElement -> EMV2PathElement
	 * 		EMV2ErrorPropagationPath -> EMV2ErrorPropagationPath
	 * 		QualifiedErrorEventOrPropagation -> EMV2ErrorPropagationPath
	 * 		QualifiedErrorPropagation -> EMV2ErrorPropagationPath
	 * 		BasicEMV2PropertyAssociation -> BasicEMV2Path
	 * 		EMV2PropertyAssociation -> EMV2Path
	 * 		ErrorModelSubclause -> EMV2PropertyAssociation
	 * 		ErrorBehaviorStateMachine -> BasicEMV2PropertyAssociation
	 * 		ErrorModelLibrary -> BasicEMV2PropertyAssociation
	 * 		ErrorModelLibrary -> ErrorBehaviorStateMachine
	 * 		ConditionElement -> QualifiedErrorEventOrPropagation
	 * 		AllExpression -> ConditionElement
	 * 		ConditionTerm -> ConditionElement
	 * 		OrlessExpression -> ConditionElement
	 * 		ConditionTerm -> AllExpression
	 * 		ConditionTerm -> OrlessExpression
	 * 		AndExpression -> ConditionTerm
	 * 		ConditionExpression -> AndExpression
	 * 		ConditionTerm -> ConditionExpression
	 * 		ErrorBehaviorTransition -> ConditionExpression
	 * 		ErrorDetection -> ConditionExpression
	 * 		OrmoreExpression -> ConditionExpression
	 * 		OutgoingPropagationCondition -> ConditionExpression
	 * 		ErrorBehaviorStateMachine -> ErrorBehaviorTransition
	 * 		ErrorModelSubclause -> ErrorBehaviorTransition
	 * 		ErrorModelSubclause -> ErrorDetection
	 * 		ConditionTerm -> OrmoreExpression
	 * 		ErrorModelSubclause -> OutgoingPropagationCondition
	 * 		SConditionElement -> QualifiedErrorPropagation
	 * 		SAllExpression -> SConditionElement
	 * 		SConditionTerm -> SConditionElement
	 * 		SOrlessExpression -> SConditionElement
	 * 		SOrmoreExpression -> SConditionElement
	 * 		SConditionTerm -> SAllExpression
	 * 		SConditionTerm -> SOrlessExpression
	 * 		SConditionTerm -> SOrmoreExpression
	 * 		SAndExpression -> SConditionTerm
	 * 		SConditionExpression -> SAndExpression
	 * 		CompositeState -> SConditionExpression
	 * 		SConditionTerm -> SConditionExpression
	 * 		ErrorModelSubclause -> CompositeState
	 * 	}
	 *
	 * EMV2PathElement objects are created in the grammar rules EMV2PathElementOrKind, EMV2PathElement, and
	 * EMV2ErrorPropagationPath. The graph shows all of the possible ways to get to one of these grammar rules from
	 * the rules ErrorModelLibrary and ErrorModelSubclause. Throughout this method, there are comments which state which
	 * grammar path in the graph is being tested for.
	 *
	 * Scope elements for grammar path: ErrorModelLibrary -> ErrorBehaviorStateMachine -> ErrorBehaviorTransition ->
	 * 			ConditionExpression -> ... -> QualifiedErrorEventOrPropagation -> EMV2ErrorPropagationPath
	 * 		ErrorBehaviorEvent
	 *
	 * Scope elements for grammar path: ErrorModelSubclause -> ErrorBehaviorTransition -> ConditionExpression -> ... ->
	 * 			QualifiedErrorEventOrPropagation -> EMV2ErrorPropagationPath
	 * 		ErrorBehaviorEvent |
	 * 		(Subcomponent '.')* (FeatureGroup '.')* ErrorPropagation
	 *
	 * Scope elements for grammar path: ErrorModelSubclause -> OutgoingPropagationCondition -> ConditionExpression ->
	 * 			... -> QualifiedErrorEventOrPropagation -> EMV2ErrorPropagationPath
	 * 		ErrorBehaviorEvent |
	 * 		(Subcomponent '.')* (FeatureGroup '.')* ErrorPropagation
	 *
	 * Scope elements for grammar path: ErrorModelSubclause -> ErrorDetection -> ConditionExpression -> ... ->
	 * 			QualifiedErrorEventOrPropagation -> EMV2ErrorPropagationPath
	 * 		ErrorBehaviorEvent |
	 * 		(Subcomponent '.')* (FeatureGroup '.')* ErrorPropagation
	 *
	 * Scope elements for grammar path: ErrorModelSubclause -> CompositeState -> SConditionExpression -> ... ->
	 * 			QualifiedErrorPropagation -> EMV2ErrorPropagationPath
	 * 		(FeatureGroup '.')* ErrorPropagation
	 *
	 * Scope elements for grammar path: ErrorModelLibrary -> BasicEMV2PropertyAssociation -> BasicEMV2Path ->
	 * 			EMV2PathElementOrKind
	 * 		ErrorTypes
	 *
	 * Scope elements for grammar path: ErrorModelLibrary -> ErrorBehaviorStateMachine ->
	 * 			BasicEMV2PropartyAssociation -> BasicEMV2Path -> EMV2PathElementOrKind
	 * 		ErrorBehaviorEvent |
	 * 		ErrorBehaviorState |
	 * 		ErrorBehaviorTransition
	 *
	 * Scope elements for grammar path: ErrorModelSubclause -> EMV2PropertyAssociation -> EMV2Path ->
	 * 			EMV2PathElementOrKind
	 * 		(FeatureGroup '.')* ErrorPropagation ('.' ErrorType)? |
	 * 		ErrorBehaviorEvent ('.' ErrorType)? |
	 * 		ErrorBehaviorTransition |
	 * 		OutgoingPropagationConditoin |
	 * 		ErrorDetection |
	 * 		CompositeState |
	 * 		ConnectionErrorSource ('.' ErrorType)? |
	 * 		PropagationPath |
	 * 		ErrorSource ('.' ErrorType)? |
	 * 		ErrorSink ('.' ErrorType)? |
	 * 		ErrorPath |
	 * 		ErrorBehaviorState ('.' ErrorType)?
	 */
	public IScope scope_EMV2PathElement_namedElement(final EMV2PathElement context, final EReference reference) {
		var parent = context.eContainer();
		if (parent instanceof QualifiedErrorEventOrPropagation qualified) {
			var condition = stream(getAllContainers(qualified)).filter(ConditionExpression.class::isInstance)
					.map(ConditionExpression.class::cast).reduce((first, second) -> second).orElse(null);
			if (condition == null) {
				return IScope.NULLSCOPE;
			}
			var conditionOwner = condition.eContainer();
			if (conditionOwner instanceof ErrorBehaviorTransition transition) {
				var transitionOwner = transition.eContainer();
				if (transitionOwner instanceof ErrorBehaviorStateMachine machine) {
					return scopeFor(machine.getEvents());
				}
				if (transitionOwner instanceof ErrorModelSubclause) {
					return eventAndPropagationScope(transition);
				}
			}
			if (conditionOwner instanceof OutgoingPropagationCondition || conditionOwner instanceof ErrorDetection) {
				return eventAndPropagationScope((Element) conditionOwner);
			}
			return IScope.NULLSCOPE;
		}
		if (parent instanceof QualifiedErrorPropagation qualified) {
			return featureGroupAndPropagationScope(qualified);
		}
		if (parent instanceof EMV2Path path) {
			var associationOwner = path.eContainer().eContainer();
			if (associationOwner instanceof ErrorModelLibrary library) {
				return scopeFor(Iterables.concat(ErrorModelUtil.getAllErrorTypes(library),
						ErrorModelUtil.getAllTypesets(library)));
			}
			if (associationOwner instanceof ErrorBehaviorStateMachine machine) {
				return scopeFor(Iterables.concat(machine.getEvents(), machine.getStates(), machine.getTransitions()));
			}
			if (associationOwner instanceof ErrorModelSubclause subclause) {
				if (path.getContainmentPath() == null) {
					return propertyAssociationScope(subclause.getContainingClassifier());
				}
				var last = path.getContainmentPath();
				while (last.getPath() != null) {
					last = last.getPath();
				}
				return last.getNamedElement() instanceof Subcomponent subcomponent
						&& subcomponent.getAllClassifier() != null
								? propertyAssociationScope(subcomponent.getAllClassifier())
								: IScope.NULLSCOPE;
			}
			return IScope.NULLSCOPE;
		}
		if (parent instanceof EMV2PathElement previousPath && !previousPath.getNamedElement().eIsProxy()) {
			var previous = previousPath.getNamedElement();
			if (previous instanceof ErrorSource || previous instanceof ErrorSink
					|| previous instanceof ErrorBehaviorState
					|| previous instanceof ErrorEvent && previousPath.eContainer() instanceof EMV2Path
							&& EcoreUtil2.getContainerOfType(previousPath, ErrorModelSubclause.class) != null
					|| previous instanceof ErrorPropagation
							&& EcoreUtil2.getContainerOfType(previousPath, EMV2Path.class) != null
							&& EcoreUtil2.getContainerOfType(previousPath, ErrorModelSubclause.class) != null) {
				return scopeForErrorTypes(context, EMV2Util.getUseTypes(previous), Optional.empty(),
						ErrorModelUtil::getAllErrorTypes);
			}
			if (previous instanceof Subcomponent subcomponent) {
				return subcomponentContinuationScope(subcomponent);
			}
			if (previous instanceof FeatureGroup featureGroup) {
				return featureGroupContinuationScope(previousPath, featureGroup);
			}
		}
		return IScope.NULLSCOPE;
	}

	private static IScope eventAndPropagationScope(final Element context) {
		var events = new ArrayList<ErrorBehaviorEvent>();
		for (var subclause : allSubclauses(context)) {
			events.addAll(subclause.getEvents());
			if (subclause.getUseBehavior() != null) {
				events.addAll(subclause.getUseBehavior().getEvents());
			}
		}
		var classifier = EcoreUtil2.getContainerOfType(context, Classifier.class);
		var featureGroups = featureGroups(classifier);
		List<Subcomponent> subcomponents = classifier instanceof ComponentImplementation implementation
				? implementation.getAllSubcomponents()
				: List.of();
		var propagations = simpleNamedPropagations(context, false);
		var propagationScope = new SimpleScope(propagationDescriptions(propagations), true);
		return scopeFor(Iterables.concat(events, featureGroups, subcomponents), propagationScope);
	}

	private static IScope featureGroupAndPropagationScope(final Element context) {
		var classifier = EcoreUtil2.getContainerOfType(context, Classifier.class);
		var propagationScope = new SimpleScope(propagationDescriptions(simpleNamedPropagations(context, false)), true);
		return scopeFor(featureGroups(classifier), propagationScope);
	}

	private static IScope propertyAssociationScope(final Classifier classifier) {
		var elements = new ArrayList<NamedElement>();
		elements.addAll(featureGroups(classifier));
		for (var subclause : allSubclauses(classifier)) {
			if (subclause.getUseBehavior() != null) {
				elements.addAll(subclause.getUseBehavior().getEvents());
				elements.addAll(subclause.getUseBehavior().getStates());
				elements.addAll(subclause.getUseBehavior().getTransitions());
			}
			elements.addAll(subclause.getFlows());
			elements.addAll(subclause.getEvents());
			elements.addAll(subclause.getTransitions());
			elements.addAll(subclause.getOutgoingPropagationConditions());
			elements.addAll(subclause.getErrorDetections());
			elements.addAll(subclause.getStates());
			elements.addAll(subclause.getConnectionErrorSources());
			elements.addAll(subclause.getPaths());
		}
		var propagations = simpleNamedPropagations(classifier, false).stream()
				.filter(ErrorModelScopeProvider::hasNoNestedFeatureGroupMembers).toList();
		return new SimpleScope(scopeFor(elements), propagationDescriptions(propagations), true);
	}

	private static IScope subcomponentContinuationScope(final Subcomponent subcomponent) {
		var classifier = subcomponent.getAllClassifier();
		if (classifier == null) {
			return IScope.NULLSCOPE;
		}
		List<Subcomponent> subcomponents = classifier instanceof ComponentImplementation implementation
				? implementation.getAllSubcomponents()
				: List.of();
		var propagationScope = new SimpleScope(propagationDescriptions(simpleNamedPropagations(classifier, true)),
				true);
		return scopeFor(Iterables.concat(subcomponents, featureGroups(classifier)), propagationScope);
	}

	private static IScope featureGroupContinuationScope(final EMV2PathElement path, final FeatureGroup featureGroup) {
		var featureGroups = featureGroup.getAllFeatureGroupType() == null ? List.<FeatureGroup>of()
				: featureGroup.getAllFeatureGroupType().getAllFeatures().stream().filter(FeatureGroup.class::isInstance)
						.map(FeatureGroup.class::cast).toList();
		var previousGroups = new ArrayList<FeatureGroup>();
		previousGroups.add(featureGroup);
		EObject current = path.eContainer();
		while (current instanceof EMV2PathElement element
				&& element.getNamedElement() instanceof FeatureGroup previousGroup) {
			previousGroups.addFirst(previousGroup);
			current = current.eContainer();
		}
		var prefix = previousGroups.stream().map(FeatureGroup::getName).collect(Collectors.joining(".", "", "."));
		var subcomponent = previousSubcomponent(current);
		var subclauses = subcomponent == null ? allSubclauses(path)
				: subcomponent.getAllClassifier() == null ? List.<ErrorModelSubclause>of()
						: allSubclauses(subcomponent.getAllClassifier());
		var propagations = subclauses.stream().flatMap(subclause -> subclause.getPropagations().stream())
				.filter(propagation -> isDirectChildPropagation(propagation, prefix))
				.filter(ErrorModelScopeProvider::hasNoNestedFeatureGroupMembers).toList();
		var descriptions = propagations.stream().map(propagation -> {
			var segments = EMV2Util.getPropagationName(propagation).split("\\.");
			return EObjectDescription.create(segments[segments.length - 1], propagation);
		}).toList();
		return new SimpleScope(scopeFor(featureGroups), descriptions, true);
	}

	private static Subcomponent previousSubcomponent(final EObject current) {
		if (EcoreUtil2.getContainerOfType(current, ErrorBehaviorTransition.class) != null
				|| EcoreUtil2.getContainerOfType(current, OutgoingPropagationCondition.class) != null
				|| EcoreUtil2.getContainerOfType(current, ErrorDetection.class) != null) {
			return current instanceof EMV2PathElement element
					&& element.getNamedElement() instanceof Subcomponent subcomponent ? subcomponent : null;
		}
		var path = EcoreUtil2.getContainerOfType(current, EMV2Path.class);
		var containment = path == null ? null : path.getContainmentPath();
		while (containment != null && containment.getPath() != null) {
			containment = containment.getPath();
		}
		return containment != null && containment.getNamedElement() instanceof Subcomponent subcomponent ? subcomponent
				: null;
	}

	private static List<FeatureGroup> featureGroups(final Classifier classifier) {
		return classifier.getAllFeatures().stream().filter(FeatureGroup.class::isInstance).map(FeatureGroup.class::cast)
				.toList();
	}

	private static List<ErrorPropagation> simpleNamedPropagations(final Element context, final boolean excludeNegated) {
		return allSubclauses(context).stream().flatMap(subclause -> subclause.getPropagations().stream())
				.filter(propagation -> !excludeNegated || !propagation.isNot())
				.filter(propagation -> propagation.getFeatureorPPRef() != null
						&& propagation.getFeatureorPPRef().getNext() == null
						&& propagation.getFeatureorPPRef().getFeatureorPP().getName() != null)
				.toList();
	}

	private static List<IEObjectDescription> propagationDescriptions(final Iterable<ErrorPropagation> propagations) {
		return stream(propagations).map(propagation -> EObjectDescription
				.create(propagation.getFeatureorPPRef().getFeatureorPP().getName(), propagation)).toList();
	}

	private static boolean hasNoNestedFeatureGroupMembers(final ErrorPropagation propagation) {
		var feature = EMV2Util.getFeature(propagation);
		return !(feature instanceof FeatureGroup group) || group.getAllFeatureGroupType() == null
				|| group.getAllFeatureGroupType().getAllFeatures().isEmpty();
	}

	private static boolean isDirectChildPropagation(final ErrorPropagation propagation, final String prefix) {
		var name = EMV2Util.getPropagationName(propagation);
		if (name == null || !name.startsWith(prefix)) {
			return false;
		}
		var remaining = name.substring(prefix.length());
		return !remaining.isEmpty() && !remaining.contains(".");
	}

	private static ArrayList<EObject> getAllContainers(final EObject object) {
		var containers = new ArrayList<EObject>();
		for (var current = object.eContainer(); current != null; current = current.eContainer()) {
			containers.add(current);
		}
		return containers;
	}

	public SimpleScope scope_EMV2PathElement_errorType(final EMV2PathElement context, final EReference reference) {
		var kind = context.getEmv2PropagationKind();
		var errorTypes = allSubclauses(context).stream().flatMap(subclause -> subclause.getPropagations().stream())
				.filter(propagation -> Objects.equals(propagation.getKind(), kind))
				.flatMap(propagation -> propagation.getTypeSet().getTypeTokens().stream())
				.filter(token -> token.getType().size() == 1).map(token -> token.getType().getFirst())
				.filter(ErrorType.class::isInstance).map(ErrorType.class::cast).toList();
		return scopeFor(errorTypes);
	}

	public SimpleScope scope_ErrorType(final ErrorModelLibrary context, final EReference reference) {
		return scopeForErrorTypes(context, context.getUseTypes(), Optional.of(context),
				ErrorModelUtil::getAllErrorTypes);
	}

	public SimpleScope scope_TypeSet_aliasedType(final ErrorModelLibrary context, final EReference reference) {
		return scopeForErrorTypes(context, context.getUseTypes(), Optional.of(context), ErrorModelUtil::getAllTypesets);
	}

	public SimpleScope scope_TypeToken_type(final ErrorModelLibrary context, final EReference reference) {
		return scopeForErrorTypes(context, context.getUseTypes(), Optional.of(context),
				ErrorModelScopeProvider::allErrorTypes);
	}

	public SimpleScope scope_TypeToken_type(final ErrorBehaviorStateMachine context, final EReference reference) {
		return scopeForErrorTypes(context, context.getUseTypes(), Optional.empty(),
				ErrorModelScopeProvider::allErrorTypes);
	}

	public SimpleScope scope_TypeToken_type(final TypeMappingSet context, final EReference reference) {
		return scopeForErrorTypes(context, context.getUseTypes(), Optional.empty(),
				ErrorModelScopeProvider::allErrorTypes);
	}

	public SimpleScope scope_TypeToken_type(final TypeTransformationSet context, final EReference reference) {
		return scopeForErrorTypes(context, context.getUseTypes(), Optional.empty(),
				ErrorModelScopeProvider::allErrorTypes);
	}

	public SimpleScope scope_TypeToken_type(final ErrorModelSubclause context, final EReference reference) {
		return scopeForErrorTypes(context, EMV2Util.getUseTypes(context), Optional.empty(),
				ErrorModelScopeProvider::allErrorTypes);
	}

	public IScope scope_FeatureorPPReference_featureorPP(final FeatureorPPReference context,
			final EReference reference) {
		var parent = context.eContainer();
		if (parent instanceof ErrorPropagation propagation) {
			var classifier = EcoreUtil2.getContainerOfType(propagation, Classifier.class);
			Iterable<? extends NamedElement> internalFeatures = classifier instanceof ComponentImplementation implementation
					? implementation.getAllInternalFeatures()
					: List.of();
			return scopeFor(Iterables.concat(classifier.getAllFeatures(), EMV2Util.getAllPropagationPoints(classifier),
					internalFeatures));
		}
		if (parent instanceof FeatureorPPReference previous
				&& previous.getFeatureorPP() instanceof FeatureGroup featureGroup) {
			return scopeFor(featureGroup.getFeatureGroupType().getAllFeatures());
		}
		return IScope.NULLSCOPE;
	}

	public SimpleScope scope_ErrorSource_sourceModelElement(final ErrorSource context, final EReference reference) {
		var subclause = (ErrorModelSubclause) context.eContainer();
		return subclause.getConnectionErrorSources().contains(context)
				? scopeFor(subclause.getContainingComponentImpl().getAllConnections())
				: scopeForErrorPropagation(subclause.getContainingClassifier(), DirectionType.OUT);
	}

	public SimpleScope scope_ErrorSource_failureModeReference(final ErrorModelSubclause context,
			final EReference reference) {
		var typeSets = context.getUseTypes().stream().flatMap(library -> stream(ErrorModelUtil.getAllTypesets(library)))
				.toList();
		var states = context.getUseBehavior() == null ? List.<ErrorBehaviorState>of()
				: context.getUseBehavior().getStates();
		return scopeFor(Iterables.concat(typeSets, states));
	}

	public SimpleScope scope_ErrorSink_incoming(final Classifier context, final EReference reference) {
		return scopeForErrorPropagation(context, DirectionType.IN);
	}

	public SimpleScope scope_ErrorPath_incoming(final Classifier context, final EReference reference) {
		return scopeForErrorPropagation(context, DirectionType.IN);
	}

	public SimpleScope scope_ErrorPath_outgoing(final Classifier context, final EReference reference) {
		return scopeForErrorPropagation(context, DirectionType.OUT);
	}

	public IScope scope_QualifiedPropagationPoint_propagationPoint(final QualifiedPropagationPoint context,
			final EReference reference) {
		Classifier classifier;
		if (context.eContainer() instanceof QualifiedPropagationPoint parent) {
			classifier = parent.getSubcomponent().getSubcomponent().getAllClassifier();
		} else {
			classifier = context.getContainingClassifier();
		}
		if (classifier == null) {
			return IScope.NULLSCOPE;
		}
		var points = allSubclauses(classifier).stream().flatMap(subclause -> subclause.getPoints().stream()).toList();
		return scopeFor(Iterables.concat(points, classifier.getAllFeatures()));
	}

	public SimpleScope scope_RepairEvent_eventInitiator(final Classifier context, final EReference reference) {
		return eventInitiatorScope(context);
	}

	public IScope scope_RepairEvent_eventInitiator(final ErrorBehaviorStateMachine context,
			final EReference reference) {
		return IScope.NULLSCOPE;
	}

	public SimpleScope scope_RecoverEvent_eventInitiator(final Classifier context, final EReference reference) {
		return eventInitiatorScope(context);
	}

	public IScope scope_RecoverEvent_eventInitiator(final ErrorBehaviorStateMachine context,
			final EReference reference) {
		return IScope.NULLSCOPE;
	}

	public SimpleScope scope_ErrorBehaviorState(final ErrorBehaviorStateMachine context, final EReference reference) {
		return scopeFor(context.getStates());
	}

	public IScope scope_ErrorBehaviorState(final Classifier context, final EReference reference) {
		return allSubclauses(context).stream().map(ErrorModelSubclause::getUseBehavior).filter(Objects::nonNull)
				.findFirst().<IScope>map(machine -> scopeFor(machine.getStates())).orElse(IScope.NULLSCOPE);
	}

	public SimpleScope scope_OutgoingPropagationCondition_outgoing(final Classifier context,
			final EReference reference) {
		return scopeForErrorPropagation(context, DirectionType.OUT);
	}

	/**
	 * @since 3.0
	 */
	public IScope scope_ReportingPortReference_element(final ReportingPortReference context,
			final EReference reference) {
		var previous = context.getPrevious();
		if (previous == null) {
			var classifier = EcoreUtil2.getContainerOfType(context, Classifier.class);
			Iterable<? extends NamedElement> internalFeatures = classifier instanceof ComponentImplementation implementation
					? implementation.getAllInternalFeatures()
					: Set.of();
			return scopeFor(Iterables.concat(classifier.getAllFeatures(), internalFeatures));
		}
		if (previous.getElement() instanceof FeatureGroup featureGroup
				&& featureGroup.getAllFeatureGroupType() != null) {
			return scopeFor(featureGroup.getAllFeatureGroupType().getAllFeatures());
		}
		return IScope.NULLSCOPE;
	}

	public SimpleScope scope_ErrorStateToModeMapping_mappedModes(final ComponentClassifier context,
			final EReference reference) {
		return scopeFor(context.getAllModes());
	}

	public IScope scope_QualifiedErrorBehaviorState_state(final QualifiedErrorBehaviorState context,
			final EReference reference) {
		var classifier = context.getSubcomponent().getSubcomponent().getAllClassifier();
		if (classifier == null) {
			return IScope.NULLSCOPE;
		}
		return allSubclauses(classifier).stream().map(ErrorModelSubclause::getUseBehavior).filter(Objects::nonNull)
				.findFirst().<IScope>map(machine -> scopeFor(machine.getStates())).orElse(IScope.NULLSCOPE);
	}

	public IScope scope_SubcomponentElement_subcomponent(final QualifiedErrorBehaviorState context,
			final EReference reference) {
		return subcomponentScope(context);
	}

	public IScope scope_SubcomponentElement_subcomponent(final QualifiedPropagationPoint context,
			final EReference reference) {
		return subcomponentScope(context);
	}

	private SimpleScope scopeWithoutEMV2Prefix(final EObject context, final EReference reference) {
		var descriptions = stream(delegateGetScope(context, reference).getAllElements()).map(description -> {
			var name = description.getName().toString("::");
			if (!name.startsWith(ErrorModelCrossReferenceSerializer.PREFIX)) {
				return description;
			}
			var stripped = name.substring(ErrorModelCrossReferenceSerializer.PREFIX.length());
			return EObjectDescription.create(qualifiedNameConverter.toQualifiedName(stripped),
					description.getEObjectOrProxy());
		}).toList();
		return new SimpleScope(descriptions, true);
	}

	private SimpleScope scopeForErrorTypes(final EObject context, final Iterable<ErrorModelLibrary> useTypes,
			final Optional<ErrorModelLibrary> parentLibrary,
			final Function<ErrorModelLibrary, Iterable<? extends ErrorTypes>> elementGetter) {
		var fromUseTypes = stream(useTypes).flatMap(library -> stream(elementGetter.apply(library))).toList();
		var contextErrorTypes = parentLibrary
				.map(library -> stream(elementGetter.apply(library)).collect(Collectors.toSet()));
		var allTypes = new java.util.LinkedHashSet<ErrorTypes>(fromUseTypes);
		contextErrorTypes.ifPresent(allTypes::addAll);
		Map<String, List<ErrorTypes>> groupedTypes = allTypes.stream().collect(Collectors
				.groupingBy(type -> type.getName().toLowerCase(), java.util.LinkedHashMap::new, Collectors.toList()));
		Map<Boolean, List<List<ErrorTypes>>> partitioned = groupedTypes.values().stream()
				.collect(Collectors.partitioningBy(types -> types.size() == 1));
		List<IEObjectDescription> noConflicts = partitioned.get(true).stream().flatMap(Collection::stream)
				.map(type -> EObjectDescription.create(QualifiedName.create(type.getName()), type)).toList();
		List<IEObjectDescription> conflicts = partitioned.get(false).stream().flatMap(Collection::stream)
				.filter(type -> contextErrorTypes.isPresent() && contextErrorTypes.get().contains(type))
				.map(type -> EObjectDescription.create(QualifiedName.create(type.getName()), type)).toList();
		var libraryScope = scope_ErrorModelLibrary(context, ErrorModelPackage.Literals.ERROR_MODEL_LIBRARY__USE_TYPES);
		var qualified = stream(libraryScope.getAllElements())
				.map(description -> (ErrorModelLibrary) EcoreUtil.resolve(description.getEObjectOrProxy(), context))
				.flatMap(library -> stream(elementGetter.apply(library)).map(type -> EObjectDescription
						.create(QualifiedName.create(EMV2Util.getLibraryName(library), type.getName()), type)))
				.toList();
		return new SimpleScope(Iterables.concat(noConflicts, conflicts, qualified), true);
	}

	public static Iterable<IEObjectDescription> eDescriptionsForErrorPropagation(final Classifier context,
			final DirectionType requiredDirection) {
		return allSubclauses(context).stream().flatMap(subclause -> subclause.getPropagations().stream())
				.filter(propagation -> !propagation.isNot() && propagation.getDirection() == requiredDirection)
				.map(propagation -> EObjectDescription.create(EMV2Util.getPropagationName(propagation), propagation))
				.toList();
	}

	public static SimpleScope scopeForErrorPropagation(final Classifier context,
			final DirectionType requiredDirection) {
		return new SimpleScope(eDescriptionsForErrorPropagation(context, requiredDirection), true);
	}

	public static Iterable<IEObjectDescription> getEventandIncomingPropagationDescriptions(
			final Classifier classifier) {
		var descriptions = new ArrayList<IEObjectDescription>();
		if (classifier == null) {
			return descriptions;
		}
		allSubclauses(classifier).stream().map(ErrorModelSubclause::getUseBehavior).filter(Objects::nonNull).findFirst()
				.ifPresent(machine -> machine.getEvents().forEach(event -> descriptions
						.add(EObjectDescription.create(QualifiedName.create(event.getName()), event))));
		for (var subclause : allSubclauses(classifier)) {
			subclause.getEvents().forEach(
					event -> descriptions.add(EObjectDescription.create(QualifiedName.create(event.getName()), event)));
			subclause.getFlows().forEach(
					flow -> descriptions.add(EObjectDescription.create(QualifiedName.create(flow.getName()), flow)));
			subclause.getPropagations().stream()
					.filter(propagation -> !propagation.isNot() && propagation.getDirection() == DirectionType.IN)
					.forEach(propagation -> descriptions.add(EObjectDescription
							.create(QualifiedName.create(EMV2Util.getPropagationName(propagation)), propagation)));
		}
		return descriptions;
	}

	private static BasicProperty propertyFor(final EObject context) {
		var basicAssociation = EcoreUtil2.getContainerOfType(context, BasicPropertyAssociation.class);
		if (basicAssociation != null) {
			return basicAssociation.getProperty();
		}
		var emv2Association = EcoreUtil2.getContainerOfType(context, EMV2PropertyAssociation.class);
		return emv2Association == null ? null : emv2Association.getProperty();
	}

	private static List<ErrorModelSubclause> allSubclauses(final Element context) {
		return List.copyOf(EMV2Util.getAllContainingClassifierEMV2Subclauses(context));
	}

	private static Iterable<? extends ErrorTypes> allErrorTypes(final ErrorModelLibrary library) {
		return Iterables.concat(ErrorModelUtil.getAllErrorTypes(library), ErrorModelUtil.getAllTypesets(library));
	}

	private static <T> Stream<T> stream(final Iterable<T> values) {
		return StreamSupport.stream(values.spliterator(), false);
	}

	private static SimpleScope eventInitiatorScope(final Classifier classifier) {
		var members = IterableExtensions.filter(allMembers(classifier),
				member -> !(member instanceof DefaultAnnexSubclause));
		return scopeFor(filterRefined(members));
	}

	private static IScope subcomponentScope(final EObject context) {
		var parent = context.eContainer();
		ComponentClassifier classifier = switch (parent) {
		case QualifiedErrorBehaviorState state -> state.getSubcomponent().getSubcomponent().getAllClassifier();
		case QualifiedPropagationPoint point -> point.getSubcomponent().getSubcomponent().getAllClassifier();
		default -> EcoreUtil2.getContainerOfType(parent, ComponentImplementation.class);
		};
		return classifier instanceof ComponentImplementation implementation
				? scopeFor(implementation.getAllSubcomponents())
				: IScope.NULLSCOPE;
	}
}
