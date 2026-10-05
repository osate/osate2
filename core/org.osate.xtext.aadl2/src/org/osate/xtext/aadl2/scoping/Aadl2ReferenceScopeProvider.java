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
package org.osate.xtext.aadl2.scoping;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.AliasedEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.CalledSubprogram;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Context;
import org.osate.aadl2.Element;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.modelsupport.util.AadlUtil;

import com.google.inject.Inject;

/**
 * Scopes for existing references used by linking and serialization. Content assist continues to use
 * {@link Aadl2ScopeProvider}, where a completed path element can request candidates for the next path segment.
 *
 * @since 9.1
 */
public class Aadl2ReferenceScopeProvider extends Aadl2ScopeProvider {
	private static final Function<Classifier, Iterable<? extends EObject>> CONNECTION_END_COLLECTOR = //
			classifier -> filterRefined(allConnectionEnds(classifier));

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Override
	public IScope getScope(EObject context, EReference reference) {
		IScope scope = super.getScope(context, reference);
		if (isPropertyReference(reference.getEReferenceType())) {
			scope = new PropertyScope(scope, context, reference);
		}
		boolean global = isGlobalReference(reference.getEReferenceType());
		if (reference == Aadl2Package.eINSTANCE.getSubprogramCall_CalledSubprogram()
				&& context instanceof SubprogramCall call && call.getContext() != null
				&& !(call.getContext() instanceof ComponentType)) {
			global = false;
		}
		return global ? new Aadl2GlobalScope(scope, context, reference) : scope;
	}

	@Override
	public IScope scope_NamedValue_namedValue(Element context, EReference reference) {
		Supplier<IScope> literals = () -> super.scope_NamedValue_namedValue(context, reference);
		return new AbstractScope(delegateGetScope(context, reference), true) {
			@Override
			protected Iterable<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
				// Qualified constants and properties do not need their containing value's property type resolved.
				return name.getSegmentCount() > 1 ? List.of()
						: () -> StreamSupport.stream(literals.get().getElements(name).spliterator(), false)
								.filter(PropertyScope::isLocalLiteral).iterator();
			}

			@Override
			protected Iterable<IEObjectDescription> getAllLocalElements() {
				return () -> StreamSupport.stream(literals.get().getAllElements().spliterator(), false)
						.filter(PropertyScope::isLocalLiteral).iterator();
			}
		};
	}

	@Override
	public IScope scope_Classifier(Element context, EReference reference) {
		var scope = super.scope_Classifier(context, reference);
		var section = EcoreUtil2.getContainerOfType(context, PackageSection.class);
		if (section instanceof PrivatePackageSection) {
			var publicSection = ((AadlPackage) section.getOwner()).getPublicSection();
			if (publicSection != null) {
				// Public aliases remain visible from the private section, after its own declarations and aliases.
				return new FallbackScope(scope, super.scope_Classifier(publicSection, reference));
			}
		}
		return scope;
	}

	// Abstract features may refer to a component prototype as their classifier, in addition to a global classifier.
	public IScope scope_AbstractFeature_abstractFeatureClassifier(Element context, EReference reference) {
		var classifier = EcoreUtil2.getContainerOfType(context, Classifier.class);
		List<Prototype> prototypes = switch (classifier) {
		case ComponentClassifier component -> component.getAllPrototypes();
		case FeatureGroupType group -> group.getAllPrototypes();
		case null, default -> List.of();
		};
		return scopeFor(filterRefined(prototypes.stream().filter(reference.getEReferenceType()::isInstance).toList()),
				scope_Classifier(context, reference));
	}

	@Override
	public IScope scope_SubprogramCall_calledSubprogram(Element context, EReference reference) {
		var call = EcoreUtil2.getContainerOfType(context, SubprogramCall.class);
		if (call != null && call.getContext() instanceof ComponentType type) {
			var members = type.getMembers().stream().filter(CalledSubprogram.class::isInstance).toList();
			return new ImplementationScope(delegateGetScope(context, reference),
					qualifiedNameConverter.toQualifiedName(type.getQualifiedName()), scopeFor(filterRefined(members)));
		}
		return super.scope_SubprogramCall_calledSubprogram(context, reference);
	}

	private static boolean isGlobalReference(EClass type) {
		var aadl = Aadl2Package.eINSTANCE;
		return isPropertyReference(type) || (type != null && (aadl.getClassifier().isSuperTypeOf(type)
				|| aadl.getSubcomponentType().isSuperTypeOf(type) || aadl.getFeatureClassifier().isSuperTypeOf(type)
				|| aadl.getFeatureType().isSuperTypeOf(type) || aadl.getModelUnit().isSuperTypeOf(type)
				|| type == aadl.getCallContext() || type == aadl.getCalledSubprogram()));
	}

	private static boolean isPropertyReference(EClass type) {
		var aadl = Aadl2Package.eINSTANCE;
		return type != null && (aadl.getPropertyType().isSuperTypeOf(type) || type == aadl.getProperty()
				|| type == aadl.getPropertyConstant() || type == aadl.getAbstractNamedValue()
				|| type == aadl.getArraySizeProperty());
	}

	private static class FallbackScope extends AbstractScope {
		private final IScope primary;

		FallbackScope(IScope primary, IScope fallback) {
			super(fallback, true);
			this.primary = primary;
		}

		@Override
		protected Iterable<IEObjectDescription> getAllLocalElements() {
			return primary.getAllElements();
		}

		@Override
		protected Iterable<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
			return primary.getElements(name);
		}
	}

	/** Exposes a type's implementation names from descriptions, without resolving implementation objects. */
	private static final class ImplementationScope extends AbstractScope {
		private final IScope classifiers;
		private final QualifiedName typeName;

		ImplementationScope(IScope classifiers, QualifiedName typeName, IScope members) {
			super(members, true);
			this.classifiers = classifiers;
			this.typeName = typeName;
		}

		@Override
		protected Iterable<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
			if (name.getSegmentCount() != 1) {
				return List.of();
			}
			var qualified = typeName.skipLast(1).append(typeName.getLastSegment() + "." + name.getLastSegment());
			return () -> StreamSupport.stream(classifiers.getElements(qualified).spliterator(), false)
					.filter(description -> Aadl2Package.eINSTANCE.getComponentImplementation().isSuperTypeOf(description.getEClass()))
					.<IEObjectDescription>map(description -> new AliasedEObjectDescription(name, description)).iterator();
		}

		@Override
		protected Iterable<IEObjectDescription> getAllLocalElements() {
			String prefix = typeName.getLastSegment() + ".";
			return () -> StreamSupport.stream(classifiers.getAllElements().spliterator(), false)
					.filter(description -> Aadl2Package.eINSTANCE.getComponentImplementation().isSuperTypeOf(description.getEClass()))
					.filter(description -> description.getName().equals(description.getQualifiedName()))
					.filter(description -> description.getName().getSegmentCount() == typeName.getSegmentCount()
							&& description.getName().skipLast(1).equalsIgnoreCase(typeName.skipLast(1))
							&& description.getName().getLastSegment().regionMatches(true, 0, prefix, 0, prefix.length()))
					.<IEObjectDescription>map(description -> new AliasedEObjectDescription(
							QualifiedName.create(description.getName().getLastSegment().substring(prefix.length())), description))
					.iterator();
		}
	}

	/** Unqualified property names search the predeclared sets in their established order. */
	private static final class PropertyScope extends AbstractScope {
		private final IScope descriptions;
		private final Aadl2GlobalScope visible;

		PropertyScope(IScope descriptions, EObject context, EReference reference) {
			super(IScope.NULLSCOPE, true);
			this.descriptions = descriptions;
			visible = new Aadl2GlobalScope(descriptions, context, reference);
		}

		@Override
		protected Iterable<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
			if (name.getSegmentCount() > 1) {
				return filterProperties(descriptions.getElements(name));
			}
			List<IEObjectDescription> literals = new ArrayList<>();
			for (var description : descriptions.getElements(name)) {
				if (isLocalLiteral(description)) {
					literals.add(description);
				}
			}
			if (!literals.isEmpty()) {
				return literals;
			}
			for (var propertySet : AadlUtil.getPredeclaredPropertySetNames()) {
				var description = visible.getSingleElement(QualifiedName.create(propertySet, name.getFirstSegment()));
				if (description != null && isProperty(description)) {
					return List.of(new AliasedEObjectDescription(name, description));
				}
			}
			return List.of();
		}

		@Override
		protected Iterable<IEObjectDescription> getAllLocalElements() {
			return () -> StreamSupport.stream(descriptions.getAllElements().spliterator(), false)
					.filter(description -> isLocalLiteral(description) || (isProperty(description)
							&& (description.getName().getSegmentCount() > 1
									|| AadlUtil.isPredeclaredPropertySet(description.getQualifiedName().getFirstSegment()))))
					.iterator();
		}

		private static Iterable<IEObjectDescription> filterProperties(Iterable<IEObjectDescription> descriptions) {
			return () -> StreamSupport.stream(descriptions.spliterator(), false).filter(PropertyScope::isProperty).iterator();
		}

		private static boolean isProperty(IEObjectDescription description) {
			var aadl = Aadl2Package.eINSTANCE;
			var type = description.getEClass();
			return aadl.getProperty().isSuperTypeOf(type) || aadl.getPropertyConstant().isSuperTypeOf(type)
					|| aadl.getPropertyType().isSuperTypeOf(type);
		}

		private static boolean isLocalLiteral(IEObjectDescription description) {
			return description.getQualifiedName().getSegmentCount() == 1
					&& Aadl2Package.eINSTANCE.getEnumerationLiteral().isSuperTypeOf(description.getEClass());
		}
	}

	// Reference is from ConnectedElement in Aadl2.xtext
	@Override
	public IScope scope_ConnectedElement_connectionEnd(ConnectedElement context, EReference reference) {
		var classifier = EcoreUtil2.getContainerOfType(context, Classifier.class);
		if (context.eContainer() instanceof ConnectedElement previous) {
			return previous.getConnectionEnd() instanceof Context previousContext
					? scopeForElementsOfContext(previousContext, classifier, CONNECTION_END_COLLECTOR)
					: IScope.NULLSCOPE;
		}
		return context.getContext() == null ? scopeFor(filterRefined(allConnectionEnds(classifier)))
				: scopeForElementsOfContext(context.getContext(), classifier, CONNECTION_END_COLLECTOR);
	}

	public IScope scope_ContainmentPathElement_namedElement(ContainmentPathElement context, EReference reference) {
		return switch (context.getOwner()) {
		case ContainmentPathElement previous -> {
			var namespace = getClassifierForPreviousContainmentPathElement(previous);
			yield namespace == null ? IScope.NULLSCOPE : scopeFor(filterRefined(allMembers(namespace)));
		}
		case ReferenceValue value -> super.scope_ContainmentPathElement_namedElement(value, reference);
		case ContainedNamedElement contained -> scope_ContainmentPathElement_namedElement(contained, reference);
		case null, default -> IScope.NULLSCOPE;
		};
	}

	public IScope scope_ContainmentPathElement_namedElement(ContainedNamedElement context, EReference reference) {
		var propertyAssociation = EcoreUtil2.getContainerOfType(context, PropertyAssociation.class);
		var namespace = namespaceForPropertyAssociation(propertyAssociation);
		return namespace == null ? IScope.NULLSCOPE : scopeFor(filterRefined(allMembers(namespace)));
	}

	@Override
	public IScope scope_FlowEnd_feature(FlowEnd end, EReference reference) {
		if (end.getContext() == null) {
			return super.scope_FlowEnd_feature(end, reference);
		}
		return end.getContext().getFeature() instanceof Context context
				? scopeForElementsOfContext(context, EcoreUtil2.getContainerOfType(end, Classifier.class),
						classifier -> filterRefined(classifier.getAllFeatures()))
				: IScope.NULLSCOPE;
	}

	@Override
	public IScope scope_ModalElement_inMode(Element context, EReference reference) {
		var association = EcoreUtil2.getContainerOfType(context, PropertyAssociation.class);
		if (association != null) {
			if (!association.getAppliesTos().isEmpty()) {
				// Modes belong to the last subcomponent before the first feature in an applies-to path.
				Subcomponent lastSubcomponent = null;
				for (var path : association.getAppliesTos().getFirst().getContainmentPathElements()) {
					if (path.getNamedElement() instanceof Subcomponent subcomponent) {
						lastSubcomponent = subcomponent;
					} else {
						break;
					}
				}
				if (lastSubcomponent != null) {
					// A selected but untyped subcomponent has no modes; do not fall back to the outer classifier.
					return scopeForModes(lastSubcomponent.getAllClassifier());
				}
			} else if (association.getOwner() instanceof Subcomponent subcomponent) {
				return scopeForModes(subcomponent.getAllClassifier());
			}
		}
		return scopeForModes(EcoreUtil2.getContainerOfType(context, ComponentClassifier.class));
	}

	private static IScope scopeForModes(ComponentClassifier classifier) {
		return classifier == null ? IScope.NULLSCOPE : scopeFor(classifier.getAllModes());
	}

	@Override
	public IScope scope_NumberValue_unit(PropertyAssociation context, EReference reference) {
		return context.getProperty() == null ? IScope.NULLSCOPE : super.scope_NumberValue_unit(context, reference);
	}

	@Override
	public IScope scope_NumberValue_unit(BasicPropertyAssociation context, EReference reference) {
		return context.getProperty() == null ? IScope.NULLSCOPE : super.scope_NumberValue_unit(context, reference);
	}
}
