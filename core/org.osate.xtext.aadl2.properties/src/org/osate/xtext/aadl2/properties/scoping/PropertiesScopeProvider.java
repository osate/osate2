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
package org.osate.xtext.aadl2.properties.scoping;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupPrototype;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeatureType;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NumberType;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RangeType;
import org.osate.aadl2.RecordType;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.modelsupport.ResolvePrototypeUtil;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.parsesupport.AObject;

/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 *
 */
public class PropertiesScopeProvider extends AbstractDeclarativeScopeProvider {
	// Adds scope with renames for all references to Classifiers.
	public IScope scope_Classifier(Element context, EReference reference) {
		var scope = delegateGetScope(context, reference);
		var packageSection = EcoreUtil2.getContainerOfType(context, PackageSection.class);
		if (packageSection == null) {
			return scope;
		}
		List<IEObjectDescription> renameScopeElements = new ArrayList<>();
		for (var rename : packageSection.getOwnedComponentTypeRenames()) {
			var renamedComponentType = rename.getRenamedComponentType();
			if (renamedComponentType == null || renamedComponentType.eIsProxy()) {
				continue;
			}
			if (reference.getEReferenceType().isSuperTypeOf(renamedComponentType.eClass())) {
				var name = rename.getName() == null ? renamedComponentType.getName() : rename.getName();
				renameScopeElements
						.add(new EObjectDescription(QualifiedName.create(name), renamedComponentType, null));
			}
		}
		if (reference.getEReferenceType().isSuperTypeOf(Aadl2Package.eINSTANCE.getFeatureGroupType())) {
			for (var rename : packageSection.getOwnedFeatureGroupTypeRenames()) {
				var renamedFeatureGroupType = rename.getRenamedFeatureGroupType();
				if (renamedFeatureGroupType == null || renamedFeatureGroupType.eIsProxy()) {
					continue;
				}
				var name = rename.getName() == null ? renamedFeatureGroupType.getName() : rename.getName();
				renameScopeElements
						.add(new EObjectDescription(QualifiedName.create(name), renamedFeatureGroupType, null));
			}
		}
		for (var packageRename : packageSection.getOwnedPackageRenames()) {
			var renamedPackage = packageRename.getRenamedPackage();
			if (renamedPackage == null || renamedPackage.eIsProxy() || renamedPackage.getPublicSection() == null) {
				continue;
			}
			for (var classifier : renamedPackage.getPublicSection().getOwnedClassifiers()) {
				if (reference.getEReferenceType().isSuperTypeOf(classifier.eClass())) {
					var name = packageRename.isRenameAll() ? QualifiedName.create(classifier.getName())
							: QualifiedName.create(packageRename.getName(), classifier.getName());
					renameScopeElements.add(new EObjectDescription(name, classifier, null));
				}
			}
		}
		return new SimpleScope(scope, renameScopeElements, true);
	}

	/*
	 * Reference is from ModalPropertyValue and OptionalModalPropertyValue in Properties.xtext
	 * and SubprogramCallSequence, InternalFeature, ProcessorFeature, and DefaultAnnexSubclause in Aadl2.xtext
	 */
	public IScope scope_ModalElement_inMode(Element context, EReference reference) {
		IScope scope = IScope.NULLSCOPE;
		var containingPropertyAssociation = EcoreUtil2.getContainerOfType(context, PropertyAssociation.class);
		if (containingPropertyAssociation != null) {
			if (!containingPropertyAssociation.getAppliesTos().isEmpty()) {
				var subcomponent = (Subcomponent) lastSubcomponentPathElement(
						containingPropertyAssociation.getAppliesTos().get(0).getContainmentPathElements())
								.getNamedElement();
				var classifier = subcomponent.getClassifier();
				if (classifier != null) {
					scope = scopeFor(classifier.getAllModes());
				}
			} else if (containingPropertyAssociation.getOwner() instanceof Subcomponent subcomponent) {
				var classifier = subcomponent.getAllClassifier();
				if (classifier != null) {
					scope = scopeFor(classifier.getAllModes());
				}
			}
		}
		return scope == IScope.NULLSCOPE
				? scopeFor(EcoreUtil2.getContainerOfType(context, ComponentClassifier.class).getAllModes())
				: scope;
	}

	// Reference is from LiteralorReferenceTerm in Properties.xtext
	public IScope scope_NamedValue_namedValue(Element context, EReference reference) {
		var scope = delegateGetScope(context, reference);
		var propertySet = EcoreUtil2.getContainerOfType(context, PropertySet.class);
		if (propertySet != null) {
			scope = new FilteringScope(scope, description -> description.getName().getSegmentCount() > 1
					|| description.getEObjectOrProxy().eContainer() != propertySet);
		}
		var propertyType = AadlUtil.getBasePropertyType(propertyTypeForNamedValue(context));
		return propertyType instanceof EnumerationType enumeration ? scopeFor(enumeration.getOwnedLiterals(), scope)
				: scope;
	}

	// Reference is from FieldPropertyAssociation in Properties.xtext
	public IScope scope_BasicPropertyAssociation_property(Element context, EReference reference) {
		var parent = context instanceof BasicPropertyAssociation field ? field.getOwner() : context;
		while (parent != null && !(parent instanceof BasicPropertyAssociation || parent instanceof PropertyAssociation
				|| parent instanceof Property || parent instanceof PropertyConstant)) {
			parent = parent.getOwner();
		}
		PropertyType propertyType = switch (parent) {
			case BasicPropertyAssociation field -> propertyTypeOf(field);
			case PropertyAssociation association -> propertyTypeOf(association);
			case Property property -> property.getPropertyType();
			case PropertyConstant constant -> constant.getPropertyType();
			case null, default -> null;
		};
		var baseType = AadlUtil.getBasePropertyType(propertyType);
		return baseType instanceof RecordType record ? scopeFor(record.getOwnedFields()) : IScope.NULLSCOPE;
	}

	// Reference is from ContainmentPathElement in Properties.xtext
	public IScope scope_ContainmentPathElement_namedElement(Element context, EReference reference) {
		var namespace = switch (context) {
			// Scoping for first element of a reference value when providing the scope for content assist
			case ReferenceValue value -> namespaceForContainingPropertyAssociation(value);
			// Scoping for first element of the applies to when providing the scope for content assist
			case PropertyAssociation association -> namespaceForPropertyAssociation(association);
			case ContainmentPathElement pathElement -> namespaceForContainmentPathElement(pathElement);
			case null, default -> null;
		};
		return namespace == null ? IScope.NULLSCOPE : scopeFor(filterRefined(allMembers(namespace)));
	}

	// Reference is from IntegerTerm and RealTerm in Properties.xtext
	public IScope scope_NumberValue_unit(NumberType context, EReference reference) {
		// Lower bound or upper bound values of a number property type.
		return scopeForUnitLiterals(context.getUnitsType());
	}

	// Reference is from IntegerTerm and RealTerm in Properties.xtext
	public IScope scope_NumberValue_unit(PropertyConstant context, EReference reference) {
		// Value of the property constant.
		return createUnitLiteralsScopeFromPropertyType(context.getPropertyType());
	}

	// Reference is from IntegerTerm and RealTerm in Properties.xtext
	public IScope scope_NumberValue_unit(Property context, EReference reference) {
		// Default value of a property definition.
		return createUnitLiteralsScopeFromPropertyType(context.getPropertyType());
	}

	// Reference is from IntegerTerm and RealTerm in Properties.xtext
	public IScope scope_NumberValue_unit(PropertyAssociation context, EReference reference) {
		// Value of an association.
		return createUnitLiteralsScopeFromPropertyType(context.getProperty().getPropertyType());
	}

	// Reference is from IntegerTerm and RealTerm in Properties.xtext
	public IScope scope_NumberValue_unit(BasicPropertyAssociation context, EReference reference) {
		// Inner value of a record value.
		return createUnitLiteralsScopeFromPropertyType(context.getProperty().getPropertyType());
	}

	protected static SimpleScope scopeFor(Iterable<? extends EObject> elements) {
		return scopeFor(elements, IScope.NULLSCOPE);
	}

	protected static SimpleScope scopeFor(Iterable<? extends EObject> elements, IScope outer) {
		return new SimpleScope(outer,
				Scopes.scopedElementsFor(elements, QualifiedName.wrapper(SimpleAttributeResolver.NAME_RESOLVER)), true);
	}

	/**
	 * @since 4.0
	 */
	protected static <T extends EObject> SimpleScope scopeFor(Iterable<? extends T> elements,
			Function<? super T, ? extends QualifiedName> nameComputation, IScope outer) {
		return new SimpleScope(outer, Scopes.scopedElementsFor(elements, nameComputation::apply), true);
	}

	/*
	 * Lazily removes the elements that another element of the same collection refines. The result is repeatable, so it
	 * can be handed to the equally lazy scope pipeline.
	 */
	protected static <T extends AObject> Iterable<T> filterRefined(Iterable<T> unfiltered) {
		return () -> StreamSupport.stream(unfiltered.spliterator(), false)
				.filter(member -> !isRefinedBy(unfiltered, member))
				.iterator();
	}

	/**
	 * @since 4.0
	 */
	protected static List<SubprogramCall> allSubprogramCalls(BehavioredImplementation implementation) {
		var allSubprogramCalls = new ArrayList<SubprogramCall>();
		for (ComponentImplementation current = implementation; current != null; current = current.getExtended()) {
			// Should always be a BehavioredImplementation unless we have a malformed model.
			if (current instanceof BehavioredImplementation behavioredImplementation) {
				allSubprogramCalls.addAll(behavioredImplementation.subprogramCalls());
			}
		}
		return allSubprogramCalls;
	}

	protected static FeatureType allFeatureType(FeatureGroup featureGroup) {
		var refinedFeatureGroup = featureGroup;
		while (refinedFeatureGroup.getFeatureType() == null
				&& refinedFeatureGroup.getRefined() instanceof FeatureGroup refined) {
			refinedFeatureGroup = refined;
		}
		return refinedFeatureGroup.getFeatureType();
	}

	protected static SubcomponentType allSubcomponentType(Subcomponent subcomponent) {
		var refinedSubcomponent = subcomponent;
		while (refinedSubcomponent.getSubcomponentType() == null && refinedSubcomponent.getRefined() != null) {
			refinedSubcomponent = refinedSubcomponent.getRefined();
		}
		return refinedSubcomponent.getSubcomponentType();
	}

	/**
	 * @since 4.0
	 */
	protected static List<InternalFeature> allInternalFeatures(ComponentImplementation implementation) {
		var allInternalFeatures = new ArrayList<InternalFeature>();
		for (ComponentImplementation current = implementation; current != null; current = current.getExtended()) {
			allInternalFeatures.addAll(current.getOwnedInternalFeatures());
		}
		return allInternalFeatures;
	}

	/**
	 * @since 4.0
	 */
	public static List<NamedElement> allMembers(Classifier classifier) {
		var allMembers = new ArrayList<NamedElement>(classifier.getMembers());
		if (classifier instanceof BehavioredImplementation implementation) {
			allMembers.addAll(allSubprogramCalls(implementation));
		}
		return allMembers;
	}

	protected static IScope createUnitLiteralsScopeFromPropertyType(PropertyType type) {
		UnitsType unitsType = switch (AadlUtil.getBasePropertyType(type)) {
			case NumberType numberType -> numberType.getUnitsType();
			case RangeType rangeType -> rangeType.getNumberType().getUnitsType();
			case null, default -> null;
		};
		return scopeForUnitLiterals(unitsType);
	}

	/**
	 * @since 1.1
	 */
	protected static Classifier namespaceForPropertyAssociation(PropertyAssociation propertyAssociation) {
		var container = propertyAssociation.getOwner();
		return switch (container) {
			case FeatureGroup featureGroup -> namespaceForFeatureGroup(featureGroup,
					EcoreUtil2.getContainerOfType(propertyAssociation, Classifier.class));
			case Subcomponent subcomponent -> namespaceForSubcomponent(subcomponent,
					EcoreUtil2.getContainerOfType(propertyAssociation, Classifier.class));
			case null, default -> EcoreUtil2.getContainerOfType(container, Classifier.class);
		};
	}

	/**
	 * @since 1.1
	 */
	protected static Classifier getClassifierForPreviousContainmentPathElement(ContainmentPathElement previousCpe) {
		var previousElement = previousCpe.getNamedElement();
		if (previousElement == null || previousElement.eIsProxy()) {
			// Don't provide a scope if the previous element could not be resolved
			return null;
		}
		return switch (previousElement) {
			case Subcomponent subcomponent -> namespaceForSubcomponent(subcomponent, previousCpe);
			case FeatureGroup featureGroup -> namespaceForFeatureGroup(featureGroup, previousCpe);
			default -> null;
		};
	}

	/*
	 * The classifier that a subcomponent refers to, resolving a prototype in the given context.
	 */
	private static Classifier namespaceForSubcomponent(Subcomponent subcomponent, Element prototypeContext) {
		return switch (allSubcomponentType(subcomponent)) {
			case ComponentClassifier componentClassifier -> componentClassifier;
			case ComponentPrototype prototype -> ResolvePrototypeUtil.resolveComponentPrototype(prototype,
					prototypeContext);
			case null, default -> null;
		};
	}

	/*
	 * The feature group type that a feature group refers to, resolving a prototype in the given context.
	 */
	private static Classifier namespaceForFeatureGroup(FeatureGroup featureGroup, Element prototypeContext) {
		return switch (allFeatureType(featureGroup)) {
			case FeatureGroupType featureGroupType -> featureGroupType;
			case FeatureGroupPrototype prototype -> ResolvePrototypeUtil.resolveFeatureGroupPrototype(prototype,
					prototypeContext);
			case null, default -> null;
		};
	}

	private static Classifier namespaceForContainmentPathElement(ContainmentPathElement pathElement) {
		var namedElement = pathElement.getNamedElement();
		if (namedElement != null && !namedElement.eIsProxy()) {
			// Scoping for chained element after the first element when providing the scope for content assist
			return getClassifierForPreviousContainmentPathElement(pathElement);
		}
		// Scoping for first element of the chain when providing the scope for quick fix
		var owner = pathElement.getOwner();
		if (owner instanceof ReferenceValue) {
			// Scoping for first element of a reference value
			return namespaceForContainingPropertyAssociation(pathElement);
		}
		if (owner.getOwner() instanceof PropertyAssociation association) {
			// Scoping for first element of the applies to
			return namespaceForPropertyAssociation(association);
		}
		if (owner instanceof ContainmentPathElement previousCpe) {
			// Scoping for chained element after the first element when providing the scope for quick fix
			return getClassifierForPreviousContainmentPathElement(previousCpe);
		}
		return null;
	}

	private static Classifier namespaceForContainingPropertyAssociation(Element context) {
		var propertyAssociation = EcoreUtil2.getContainerOfType(context, PropertyAssociation.class);
		return propertyAssociation == null ? null : namespaceForPropertyAssociation(propertyAssociation);
	}

	/*
	 * The property type of the value that contains the named value: the inner value of a record value, the value of a
	 * property constant, the default value of a property definition, or the value of an association.
	 */
	private static PropertyType propertyTypeForNamedValue(Element context) {
		var recordField = EcoreUtil2.getContainerOfType(context, BasicPropertyAssociation.class);
		var recordFieldType = recordField == null ? null : propertyTypeOf(recordField);
		if (recordFieldType != null) {
			return recordFieldType;
		}
		var constant = EcoreUtil2.getContainerOfType(context, PropertyConstant.class);
		if (constant != null && constant.getPropertyType() != null) {
			return constant.getPropertyType();
		}
		var definition = EcoreUtil2.getContainerOfType(context, Property.class);
		if (definition != null && definition.getPropertyType() != null) {
			return definition.getPropertyType();
		}
		var association = EcoreUtil2.getContainerOfType(context, PropertyAssociation.class);
		return association == null ? null : propertyTypeOf(association);
	}

	private static PropertyType propertyTypeOf(BasicPropertyAssociation recordField) {
		return recordField.getProperty() == null ? null : recordField.getProperty().getPropertyType();
	}

	private static PropertyType propertyTypeOf(PropertyAssociation association) {
		return association.getProperty() == null ? null : association.getProperty().getPropertyType();
	}

	private static IScope scopeForUnitLiterals(UnitsType unitsType) {
		return unitsType == null ? IScope.NULLSCOPE : scopeFor(unitsType.getOwnedLiterals());
	}

	/*
	 * The last path element whose named element is a subcomponent, or null if the path holds no subcomponent.
	 */
	private static ContainmentPathElement lastSubcomponentPathElement(List<ContainmentPathElement> pathElements) {
		for (var index = pathElements.size() - 1; index >= 0; index--) {
			if (pathElements.get(index).getNamedElement() instanceof Subcomponent) {
				return pathElements.get(index);
			}
		}
		return null;
	}

	/*
	 * Whether an element of the collection refines the given refinable element.
	 */
	private static boolean isRefinedBy(Iterable<? extends AObject> elements, AObject member) {
		if (!(member instanceof RefinableElement)) {
			return false;
		}
		return StreamSupport.stream(elements.spliterator(), false)
				.anyMatch(element -> element instanceof RefinableElement refinable
						&& refinable.getRefinedElement() == member);
	}
}
