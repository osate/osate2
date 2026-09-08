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
package org.osate.alisa.common.scoping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupPrototype;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.alisa.common.common.AModelReference;
import org.osate.xtext.aadl2.properties.scoping.PropertiesScopeProvider;

public class CommonScopeProvider extends AbstractDeclarativeScopeProvider {
	private static final EClass UNITS_TYPE = Aadl2Package.eINSTANCE.getUnitsType();

	public SimpleScope scopeFor(Iterable<? extends EObject> elements) {
		return new SimpleScope(IScope.NULLSCOPE,
				Scopes.scopedElementsFor(elements, QualifiedName.wrapper(SimpleAttributeResolver.NAME_RESOLVER)),
				false);
	}

	public IScope scope_UnitLiteral(EObject context, EReference reference) {
		var units = getUnitLiterals(context);
		return units.isEmpty() ? IScope.NULLSCOPE : scopeFor(units);
	}

	private Collection<UnitLiteral> getUnitLiterals(EObject context) {
		// TODO: Scope literals by type, but how do we know the type of an expression?
		var result = new ArrayList<UnitLiteral>();
		for (var description : Aadl2GlobalScopeUtil.getAllEObjectDescriptions(context, UNITS_TYPE)) {
			var unitsType = (UnitsType) EcoreUtil.resolve(description.getEObjectOrProxy(), context);
			for (var literal : unitsType.getOwnedLiterals()) {
				result.add((UnitLiteral) literal);
			}
		}
		return result;
	}

	public IScope scope_NumberType_referencedUnitsType(EObject context, EReference reference) {
		return propertySetMemberScope(context, reference);
	}

	public IScope scope_TypeRef_ref(EObject context, EReference reference) {
		return propertySetMemberScope(context, reference);
	}

	public IScope scope_Property(EObject context, EReference reference) {
		return propertySetMemberScope(context, reference);
	}

	public IScope scope_APropertyReference_property(EObject context, EReference reference) {
		return propertySetMemberScope(context, reference);
	}

	public IScope scope_ComponentImplementation(EObject context, EReference reference) {
		var elements = delegateGetScope(context, reference).getAllElements();
		Iterable<IEObjectDescription> descriptions = () -> StreamSupport.stream(elements.spliterator(), false)
				.map(this::convertImplName)
				.iterator();
		return new SimpleScope(descriptions, false);
	}

	public IScope scope_ComponentClassifier(EObject context, EReference reference) {
		var elements = delegateGetScope(context, reference).getAllElements();
		Iterable<IEObjectDescription> descriptions = () -> StreamSupport.stream(elements.spliterator(), false)
				.map(description -> Aadl2Package.eINSTANCE.getComponentImplementation()
						.isSuperTypeOf(description.getEObjectOrProxy().eClass())
								? convertImplName(description)
								: EObjectDescription.create(description.getName().toString("::"),
										description.getEObjectOrProxy()))
				.iterator();
		return new SimpleScope(descriptions, false);
	}

	private SimpleScope propertySetMemberScope(EObject context, EReference reference) {
		var elements = delegateGetScope(context, reference).getAllElements();
		Iterable<IEObjectDescription> descriptions = () -> StreamSupport.stream(elements.spliterator(), false)
				.flatMap(description -> {
					var qualified = EObjectDescription.create(description.getName().toString("::"),
							description.getEObjectOrProxy());
					if (AadlUtil.isPredeclaredPropertySet(description.getName().getFirstSegment())) {
						var unqualified = EObjectDescription.create(description.getName().getLastSegment(),
								description.getEObjectOrProxy());
						return List.of(qualified, unqualified).stream();
					}
					return List.of(qualified).stream();
				})
				.iterator();
		return new SimpleScope(descriptions, false);
	}

	private IEObjectDescription convertImplName(IEObjectDescription description) {
		var implementationName = description.getName().getLastSegment().split("\\.");
		var typeName = description.getName().skipLast(1).toString("::") + "::" + implementationName[0];
		var newName = implementationName.length > 1 ? QualifiedName.create(typeName, implementationName[1])
				: QualifiedName.create(typeName);
		return EObjectDescription.create(newName, description.getEObjectOrProxy());
	}

	public IScope scope_AModelReference_modelElement(EObject context, EReference reference) {
		return new SimpleScope(List.of(EObjectDescription.create("this", context)));
	}

	public EObject getAModelReferenceContext(AModelReference reference) {
		var context = reference.eContainer();
		while (context instanceof AModelReference) {
			context = context.eContainer();
		}
		return context;
	}

	public IScope scope_AModelReference_modelElement(AModelReference context, EReference reference) {
		if (context.getPrev() == null) {
			return scope_AModelReference_modelElement(getAModelReferenceContext(context), reference);
		}
		var classifier = referencedClassifier(context.getPrev().getModelElement());
		return classifier == null ? null : scopeFor(PropertiesScopeProvider.allMembers(classifier));
	}

	private static Classifier referencedClassifier(NamedElement element) {
		return switch (element) {
		case Classifier classifier -> classifier;
		case AbstractFeature feature -> switch (feature.getAbstractFeatureClassifier()) {
		case ComponentClassifier classifier -> classifier;
		case ComponentPrototype prototype -> prototype.getConstrainingClassifier();
		case null, default -> feature.getFeaturePrototype().getConstrainingClassifier();
		};
		case FeatureGroup featureGroup -> switch (featureGroup.getFeatureType()) {
		case FeatureGroupType type -> type;
		case FeatureGroupPrototype prototype -> prototype.getConstrainingFeatureGroupType();
		case null, default -> null;
		};
		case Feature feature -> switch (feature.getFeatureClassifier()) {
		case ComponentClassifier classifier -> classifier;
		case ComponentPrototype prototype -> prototype.getConstrainingClassifier();
		case null, default -> null;
		};
		case Subcomponent subcomponent -> switch (subcomponent.getSubcomponentType()) {
		case ComponentClassifier classifier -> classifier;
		case ComponentPrototype prototype -> prototype.getConstrainingClassifier();
		case null, default -> null;
		};
		case null, default -> null;
		};
	}
}
