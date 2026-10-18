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
package org.osate.xtext.aadl2.ba.scoping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.ListType;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RecordType;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.utils.internal.PropertyUtils;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorPropertyAssociation;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTime;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariable;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariableGroup;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement;
import org.osate.xtext.aadl2.ba.behaviorAnnex.HashPropertyReference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.NamedPropertyField;
import org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyIndexPropertyReference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyReferenceTail;
import org.osate.xtext.aadl2.ba.behaviorAnnex.Reference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceSegment;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceTail;
import org.osate.xtext.aadl2.ba.behaviorAnnex.TimedAction;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceSegment;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceTail;

/**
 * Supplies local BA-state scopes and delegates AADL, property, and time-unit references to OSATE-aware global scoping.
 * Declaration uses are scoped from the declarative model, without constructing or consulting a strict annex.
 */
public class BehaviorAnnexScopeProvider extends AbstractBehaviorAnnexScopeProvider {
	public IScope scope_BehaviorTransition_sourceStates(BehaviorTransition context, EReference reference) {
		return scopeForBehaviorStates(context);
	}

	public IScope scope_BehaviorTransition_destinationState(BehaviorTransition context, EReference reference) {
		return scopeForBehaviorStates(context);
	}

	public IScope scope_BehaviorVariableGroup_dataClassifier(BehaviorVariableGroup context, EReference reference) {
		return delegateGetScope(context, reference);
	}

	public IScope scope_ForStatement_dataClassifier(ForStatement context, EReference reference) {
		return delegateGetScope(context, reference);
	}

	public IScope scope_TimedAction_processors(TimedAction context, EReference reference) {
		return delegateGetScope(context, reference);
	}

	public IScope scope_BehaviorPropertyAssociation_property(BehaviorPropertyAssociation context,
			EReference reference) {
		return delegateGetScope(context, reference);
	}

	public IScope scope_BehaviorTime_unit(BehaviorTime context, EReference reference) {
		UnitsType timeUnits = Aadl2GlobalScopeUtil.get(context, Aadl2Package.eINSTANCE.getUnitsType(),
				"AADL_Project::Time_Units");
		return timeUnits == null ? IScope.NULLSCOPE : scopeFor(timeUnits.getOwnedLiterals());
	}

	private static IScope scopeForBehaviorStates(BehaviorTransition context) {
		BehaviorAnnex annex = EcoreUtil2.getContainerOfType(context, BehaviorAnnex.class);
		if (annex == null) {
			return IScope.NULLSCOPE;
		}
		return scopeFor(annex.getStateGroups()
				.stream()
				.flatMap(group -> group.getStates().stream())
				.toList());
	}

	public IScope scope_HashPropertyReference_property(HashPropertyReference context, EReference reference) {
		return propertyScope(context, reference, true);
	}

	public IScope scope_PropertyIndexPropertyReference_property(PropertyIndexPropertyReference context,
			EReference reference) {
		return propertyScope(context, reference, true);
	}

	public IScope scope_PropertyReferenceTail_property(PropertyReferenceTail context, EReference reference) {
		var global = propertyScope(context, reference, false);
		if (!(context.eContainer() instanceof ReferenceExpression expression)) {
			return global;
		}
		var target = BehaviorAnnexReferences.lastTarget(expression.getReference());
		var fallback = new ArrayList<IEObjectDescription>();
		var prefixClassifier = BehaviorAnnexReferences.referenceClassifier(expression.getReference());
		if (target instanceof NamedElement owner) {
			// Associations supply the declaration only. Their values remain instance-specific (#3222).
			var candidates = new ArrayList<Property>();
			for (EObject current = owner; current != null; current = current.eContainer()) {
				if (current instanceof NamedElement named) {
					var associations = named instanceof Classifier classifier ? classifier.getAllPropertyAssociations()
							: named.getOwnedPropertyAssociations();
					for (var association : associations) {
						var property = association.getProperty();
						if (property != null && !property.eIsProxy() && !candidates.contains(property)) {
							candidates.add(property);
						}
					}
				}
			}
			for (var property : candidates) {
				var association = PropertyUtils.findPropertyAssociation(property.getName(), owner);
				if (association != null) {
					add(fallback, property.getName(), association.getProperty());
				}
			}
		} else if (target instanceof BehaviorVariable variable) {
			for (var association : ((BehaviorVariableGroup) variable.eContainer()).getPropertyAssociations()) {
				var property = association.getProperty();
				if (property != null && !property.eIsProxy()) {
					add(fallback, property.getName(), property);
				}
			}
		}
		if (prefixClassifier != null) {
			// Element-local associations take precedence over the element's declared classifier.
			addAssociationProperties(fallback, prefixClassifier);
		}
		return new SimpleScope(new SimpleScope(IScope.NULLSCOPE, fallback, true), global.getAllElements(), true);
	}

	private static void addAssociationProperties(List<IEObjectDescription> descriptions, Classifier classifier) {
		for (var association : classifier.getAllPropertyAssociations()) {
			var property = association.getProperty();
			if (property != null && !property.eIsProxy()) {
				add(descriptions, property.getName(), property);
			}
		}
		if (classifier instanceof ComponentImplementation implementation && implementation.getType() != null) {
			addAssociationProperties(descriptions, implementation.getType());
		}
	}

	private IScope propertyScope(EObject context, EReference reference, boolean constants) {
		return new FilteringScope(delegateGetScope(context, reference), description -> Aadl2Package.eINSTANCE
				.getProperty().isSuperTypeOf(description.getEClass())
				|| constants && (Aadl2Package.eINSTANCE.getPropertyConstant().isSuperTypeOf(description.getEClass())
						|| Aadl2Package.eINSTANCE.getPropertyType().isSuperTypeOf(description.getEClass())));
	}

	public IScope scope_ReferenceSegment_name(EObject context, EReference reference) {
		return segmentScope(context, reference);
	}

	public IScope scope_UnindexedReferenceSegment_name(EObject context, EReference reference) {
		return segmentScope(context, reference);
	}

	private IScope segmentScope(EObject context, EReference reference) {
		var container = context instanceof ReferenceSegment || context instanceof UnindexedReferenceSegment
				? context.eContainer()
				: context;
		if (container instanceof ReferenceTail tail && tail.eContainer() instanceof Reference path) {
			var index = path.getTails().indexOf(tail);
			var previous = index == 0 ? path.getSegments().stream().findFirst().orElse(null)
					: path.getTails().get(index - 1).getSegment();
			return memberScope(context, reference, previous);
		}
		if (container instanceof UnindexedReferenceTail tail && tail.eContainer() instanceof UnindexedReference path) {
			var index = path.getTails().indexOf(tail);
			var previous = index == 0 ? path.getSegments().stream().findFirst().orElse(null)
					: path.getTails().get(index - 1).getSegment();
			return memberScope(context, reference, previous);
		}
		return rootScope(context, reference);
	}

	private static Iterable<NamedElement> referenceMembers(Classifier classifier) {
		return () -> java.util.stream.StreamSupport.stream(filterRefined(allMembers(classifier)).spliterator(), false)
				.filter(member -> !(member instanceof AnnexSubclause)).iterator();
	}

	private IScope rootScope(EObject context, EReference reference) {
		var scope = new FilteringScope(delegateGetScope(context, reference),
				description -> Aadl2Package.eINSTANCE.getClassifier().isSuperTypeOf(description.getEClass()));
		IScope result = scope;
		var owner = BehaviorAnnexReferences.owner(context);
		if (owner != null) {
			result = scopeFor(referenceMembers(owner), result);
			if (owner instanceof ComponentImplementation implementation) {
				result = scopeFor(implementation.getAllInternalFeatures(), result);
			}
		}
		var annex = EcoreUtil2.getContainerOfType(context, BehaviorAnnex.class);
		if (annex == null) {
			return result;
		}
		var variables = new ArrayList<IEObjectDescription>();
		annex.getVariableGroups().forEach(group -> group.getVariables()
				.forEach(variable -> add(variables, variable.getName(), variable)));
		result = new UnambiguousScope(result, variables);
		var loops = new ArrayList<ForStatement>();
		for (var current = context; current != null && current != annex; current = current.eContainer()) {
			if (current instanceof ForStatement loop && loop.getActions() != null
					&& EcoreUtil2.isAncestor(loop.getActions(), context)) {
				loops.add(loop);
			}
		}
		for (var loop : loops.reversed()) {
			var local = new ArrayList<IEObjectDescription>();
			add(local, loop.getVariable(), loop);
			result = new SimpleScope(result, local, true);
		}
		return owner == null ? result
				: new SimpleScope(result, List.of(EObjectDescription.create("self", owner)), true);
	}

	private IScope memberScope(EObject context, EReference reference, EObject segment) {
		var target = BehaviorAnnexReferences.target(segment);
		var classifier = BehaviorAnnexReferences.segmentClassifier(segment);
		if (classifier == null || classifier.eIsProxy()) {
			return IScope.NULLSCOPE;
		}
		var members = new ArrayList<IEObjectDescription>();
		for (var member : BehaviorAnnexReferences.structMembers(classifier)) {
			add(members, member.getValue(), member);
		}
		IScope result = new SimpleScope(IScope.NULLSCOPE, members, true);
		result = scopeFor(referenceMembers(classifier), result);
		if (classifier instanceof ComponentImplementation implementation) {
			result = scopeFor(implementation.getAllInternalFeatures(), result);
		}
		var aliases = new ArrayList<IEObjectDescription>();
		add(aliases, classifier.getName(), classifier);
		if (classifier.getName() != null && classifier.getName().contains(".")) {
			add(aliases, classifier.getName().substring(classifier.getName().lastIndexOf('.') + 1), classifier);
		}
		if (target instanceof Classifier) {
			// The dot following a component type can name its implementation, rather than one of its members.
			var qualifiedPrefix = classifier.getQualifiedName() + ".";
			var localPrefix = classifier.getName() + ".";
			for (var description : delegateGetScope(context, reference).getAllElements()) {
				if (Aadl2Package.eINSTANCE.getComponentImplementation().isSuperTypeOf(description.getEClass())) {
					var name = description.getName().toString("::");
					var prefix = name.regionMatches(true, 0, qualifiedPrefix, 0, qualifiedPrefix.length())
							? qualifiedPrefix
							: localPrefix;
					if (name.regionMatches(true, 0, prefix, 0, prefix.length())) {
						add(aliases, name.substring(prefix.length()), description.getEObjectOrProxy());
					}
				}
			}
		}
		return new SimpleScope(result, aliases, true);
	}

	public IScope scope_NamedPropertyField_name(EObject context, EReference reference) {
		var container = context instanceof NamedPropertyField ? context.eContainer() : context;
		List<NamedPropertyField> fields;
		EObject property;
		EObject prefix = null;
		Classifier prefixClassifier = null;
		if (container instanceof HashPropertyReference hash) {
			fields = hash.getFields();
			property = hash.getProperty();
		} else if (container instanceof PropertyReferenceTail tail) {
			fields = tail.getFields();
			property = tail.getProperty();
			if (tail.eContainer() instanceof ReferenceExpression expression) {
				prefix = BehaviorAnnexReferences.lastTarget(expression.getReference());
				prefixClassifier = BehaviorAnnexReferences.referenceClassifier(expression.getReference());
			}
		} else {
			return IScope.NULLSCOPE;
		}
		var index = context instanceof NamedPropertyField ? fields.indexOf(context) : fields.size();
		var previous = index <= 0 ? property : BehaviorAnnexReferences.target(fields.get(index - 1));
		PropertyType type = previous instanceof BasicProperty basic ? basic.getPropertyType()
				: previous instanceof PropertyConstant constant ? constant.getPropertyType()
						: previous instanceof PropertyType propertyType ? propertyType : null;
		var visited = Collections.newSetFromMap(new IdentityHashMap<PropertyType, Boolean>());
		while (type instanceof ListType list && visited.add(type)) {
			type = list.getElementType();
		}
		var declarations = type instanceof RecordType record ? scopeFor(record.getOwnedFields())
				: type instanceof EnumerationType enumeration ? scopeFor(enumeration.getOwnedLiterals())
						: IScope.NULLSCOPE;
		var values = new ArrayList<IEObjectDescription>();
		EObject selectedValue = property instanceof Property definition ? definition.getDefaultValue() : null;
		if (property instanceof Property definition && prefix != null) {
			var association = prefix instanceof NamedElement named
					? PropertyUtils.findPropertyAssociation(definition.getName(), named)
					: null;
			if (association == null && prefixClassifier != null) {
				association = PropertyUtils.findPropertyAssociation(definition.getName(), prefixClassifier);
			}
			if (association != null) {
				var expressions = PropertyUtils.getPropertyExpression(association);
				selectedValue = expressions.isEmpty() ? null : expressions.getLast();
			}
			if (prefix instanceof BehaviorVariable variable) {
				for (var local : ((BehaviorVariableGroup) variable.eContainer()).getPropertyAssociations()) {
					if (local.getProperty() == definition) {
						selectedValue = local.getOwnedValue();
						break;
					}
				}
			}
		}
		for (var i = 0; i < index && selectedValue != null; i++) {
			if (selectedValue instanceof Property definition) {
				selectedValue = definition.getDefaultValue();
			}
			if (selectedValue instanceof PropertyExpression expression) {
				try {
					selectedValue = PropertyUtils.getValue(expression,
							BehaviorAnnexReferences.writtenName(fields.get(i)));
				} catch (UnsupportedOperationException exception) {
					selectedValue = null;
				}
			} else {
				selectedValue = null;
			}
		}
		if (selectedValue instanceof Property definition) {
			selectedValue = definition.getDefaultValue();
		}
		if (selectedValue instanceof PropertyExpression expression) {
			addValueNames(values, expression);
		}
		return new SimpleScope(new SimpleScope(IScope.NULLSCOPE, values, true), declarations.getAllElements(), true);
	}

	private static void addValueNames(List<IEObjectDescription> descriptions, PropertyExpression value) {
		if (value instanceof StringLiteral literal) {
			add(descriptions, literal.getValue(), literal);
		} else if (value instanceof ListValue list) {
			list.getOwnedListElements().forEach(element -> addValueNames(descriptions, element));
		} else if (value instanceof NamedValue namedValue
				&& namedValue.getNamedValue() instanceof NamedElement named && !named.eIsProxy()) {
			add(descriptions, named.getName(), named);
		} else if (value instanceof RecordValue record) {
			for (var association : record.getOwnedFieldValues()) {
				var field = association.getProperty();
				if (field != null && !field.eIsProxy()) {
					add(descriptions, field.getName(), field);
				}
			}
		}
	}

	private static void add(List<IEObjectDescription> descriptions, String name, EObject target) {
		if (name != null && !name.isEmpty() && target != null) {
			descriptions.add(EObjectDescription.create(QualifiedName.create(name), target));
		}
	}

	/** Duplicate local declarations shadow outer names, but do not select an arbitrary local target. */
	private static final class UnambiguousScope extends SimpleScope {
		private UnambiguousScope(IScope parent, Iterable<IEObjectDescription> descriptions) {
			super(parent, descriptions, true);
		}

		@Override
		public IEObjectDescription getSingleElement(QualifiedName name) {
			var candidates = getElements(name).iterator();
			if (!candidates.hasNext()) {
				return null;
			}
			var first = candidates.next();
			return candidates.hasNext() ? null : first;
		}
	}
}
