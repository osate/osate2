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
package org.osate.expr.scoping;

import java.util.Collections;
import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.AbstractFeatureClassifier;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureClassifier;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupPrototype;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeatureType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.aadl2.Type;
import org.osate.expr.ExprTypeSystem;
import org.osate.expr.expr.Block;
import org.osate.expr.expr.EDeclaration;
import org.osate.expr.expr.ExprLibrary;
import org.osate.expr.expr.ExprPackage;
import org.osate.expr.expr.ExprSubclause;
import org.osate.expr.expr.Expression;
import org.osate.expr.expr.FunDecl;
import org.osate.expr.expr.NamedElementRef;
import org.osate.expr.expr.Selection;
import org.osate.expr.expr.TypeDecl;
import org.osate.expr.expr.TypeRef;
import org.osate.xtext.aadl2.properties.scoping.PropertiesScopeProvider;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * This class contains custom scoping description.
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
public class ExprScopeProvider extends AbstractExprScopeProvider {

	@Inject
	private ExprTypeSystem typeSystem;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Override
	public IScope getScope(final EObject context, final EReference reference) {
		IScope scope = null;
		if (Objects.equals(reference, ExprPackage.Literals.SELECTION__REF)) {
			final Selection selection = ((Selection) context);
			scope = getSelectionScope(selection.getReceiver(), selection, reference);
		} else if (Objects.equals(reference, ExprPackage.Literals.NAMED_ELEMENT_REF__REF)) {
			scope = getNamedElementScope((NamedElementRef) context, reference);
		} else if (Objects.equals(reference, ExprPackage.Literals.TYPE_REF__REF)) {
			scope = getAnnexScope(context, reference);
		} else {
			scope = getAnnexScope(context, reference);
		}
		return scope;
	}

	protected IScope getAnnexScope(final EObject context, final EReference reference) {
		IScope scope = null;
		if (context instanceof FunDecl) {
			final IScope existingScope = Scopes.scopeFor(((FunDecl) context).getArgs(),
					getAnnexScope(((FunDecl) context).eContainer(), reference));
			final EDeclaration thisDecl = EcoreUtil2.getContainerOfType(context, EDeclaration.class);
			scope = thisDecl == null ? existingScope
					: new FilteringScope(existingScope,
							description -> !Objects.equals(description.getEObjectOrProxy(), thisDecl));
		} else {
			final Block block = EcoreUtil2.getContainerOfType(context, Block.class);
			if (block != null) {
				final Iterable<NamedElement> annexCandidates = Iterables.filter(block.eContents(), NamedElement.class);
				final IScope existingScope = Scopes.scopeFor(annexCandidates,
						getAnnexScope(block.eContainer(), reference));
				final EDeclaration thisDecl = EcoreUtil2.getContainerOfType(context, EDeclaration.class);
				scope = thisDecl == null ? existingScope
						: new FilteringScope(existingScope,
								description -> !Objects.equals(description.getEObjectOrProxy(), thisDecl));
			} else {
				final Iterable<NamedElement> annexCandidates = Iterables
						.filter(this.getExprAnnexRoot(context).eContents(), NamedElement.class);
				final IScope existingScope = Scopes.scopeFor(annexCandidates, getClassifierScope(context, reference));
				final EDeclaration thisDecl = EcoreUtil2.getContainerOfType(context, EDeclaration.class);
				scope = thisDecl == null ? existingScope
						: new FilteringScope(existingScope,
								description -> !Objects.equals(description.getEObjectOrProxy(), thisDecl));
			}
		}
		return scope;
	}

//	private <T extends Object> Iterable<T> iterable(final Iterator<T> iter) {
//		return new Iterable<T>() {
//			@Override
//			public Iterator<T> iterator() {
//				return this.iterator();
//			}
//		};
//	}

	protected IScope getClassifierScope(final EObject context, final EReference reference) {
		final Classifier classifier = EcoreUtil2.getContainerOfType(context, Classifier.class);
		final IScope delegateScope = this.delegateGetScope(context, reference);
		final Function1<IEObjectDescription, IEObjectDescription> _function = (IEObjectDescription it) -> {
			IEObjectDescription _xblockexpression_1 = null;
			{
				final String name = this.qualifiedNameConverter.toString(it.getName());
				QualifiedName _xifexpression = null;
				boolean _startsWith = name.startsWith("expr$");
				if (_startsWith) {
					_xifexpression = this.qualifiedNameConverter.toQualifiedName(name.substring(5));
				} else {
					_xifexpression = it.getName();
				}
				final QualifiedName qname = _xifexpression;
				_xblockexpression_1 = EObjectDescription.create(qname, it.getEObjectOrProxy());
			}
			return _xblockexpression_1;
		};
		Iterable<IEObjectDescription> _map = IterableExtensions
				.<IEObjectDescription, IEObjectDescription> map(delegateScope.getAllElements(), _function);
		final SimpleScope newDelegateScope = new SimpleScope(_map, true);
		return classifier == null ? newDelegateScope : Scopes.scopeFor(classifier.getMembers(), newDelegateScope);
	}

	protected IScope getNamedElementScope(final NamedElementRef context, final EReference reference) {
		return context.isCore() ? getClassifierScope(context, reference) : getAnnexScope(context, reference);
	}

	protected IScope getSelectionScope(final Expression receiver, final Selection context, final EReference reference) {
		final Type prevType = this.getExpressionType(receiver);
		NamedElement namespace = null;
		if (prevType instanceof AbstractFeature) {
			final AbstractFeatureClassifier featureClassifier = ((AbstractFeature) prevType)
					.getAbstractFeatureClassifier();
			if (featureClassifier instanceof ComponentClassifier) {
				namespace = (ComponentClassifier) featureClassifier;
			} else if (featureClassifier instanceof ComponentPrototype) {
				namespace = ((ComponentPrototype) featureClassifier).getConstrainingClassifier();
			} else {
				namespace = ((AbstractFeature) prevType).getFeaturePrototype().getConstrainingClassifier();
			}
		} else if (prevType instanceof FeatureGroup) {
			final FeatureType featureType = ((FeatureGroup) prevType).getFeatureType();
			if (featureType instanceof FeatureGroupType) {
				namespace = (FeatureGroupType) featureType;
			} else if (featureType instanceof FeatureGroupPrototype) {
				namespace = ((FeatureGroupPrototype) featureType).getConstrainingFeatureGroupType();
			}
		} else if (prevType instanceof Feature) {
			final FeatureClassifier featureClassifier = ((Feature) prevType).getFeatureClassifier();
			if (featureClassifier instanceof ComponentClassifier) {
				namespace = (ComponentClassifier) featureClassifier;
			} else if (featureClassifier instanceof ComponentPrototype) {
				namespace = ((ComponentPrototype) featureClassifier).getConstrainingClassifier();
			}
		} else if (prevType instanceof Subcomponent) {
			final SubcomponentType subcomponentType = ((Subcomponent) prevType).getSubcomponentType();
			if (subcomponentType instanceof ComponentClassifier) {
				namespace = subcomponentType;
			} else if (subcomponentType instanceof ComponentPrototype) {
				namespace = ((ComponentPrototype) subcomponentType).getConstrainingClassifier();
			}
		} else if (prevType instanceof TypeRef) {
			final NamedElement ref = ((TypeRef) prevType).getRef();
			if (ref instanceof TypeDecl) {
				namespace = ((TypeDecl) ref).getType();
			} else {
				namespace = ref;
			}
		} else {
			namespace = prevType;
		}
		return namespace == null ? IScope.NULLSCOPE
				: PropertiesScopeProvider
						.scopeFor(EcoreUtil2.<NamedElement> getAllContentsOfType(namespace, NamedElement.class));
	}

	protected Type getExpressionType(final Expression receiver) {
		return typeSystem.type(environmentForExpression(receiver), receiver).getValue();
	}

	protected RuleEnvironment environmentForExpression(final Expression expression) {
		return new RuleEnvironment();
	}

	protected IScope getThisScope(final EObject context) {
		IScope scope = IScope.NULLSCOPE;
		final Classifier classifier = EcoreUtil2.<Classifier> getContainerOfType(context, Classifier.class);
		if (classifier != null) {
			IEObjectDescription _create = EObjectDescription.create(qualifiedNameConverter.toQualifiedName("this"),
					classifier);
			scope = new SimpleScope(Collections.unmodifiableList(CollectionLiterals.newArrayList(_create)));
		}
		return scope;
	}

	protected EObject getExprAnnexRoot(final EObject ele) {
		return this.getContainerOfTypes(ele, ExprLibrary.class, ExprSubclause.class);
	}

	protected EObject getContainerOfTypes(final EObject ele, final Class<? extends EObject> type1,
			final Class<? extends EObject> type2) {
		for (EObject e = ele; e != null; e = e.eContainer()) {
			if (type1.isInstance(e)) {
				return type1.cast(e);
			} else if (type2.isInstance(e)) {
				return type2.cast(e);
			}
		}
		return null;
	}

}
