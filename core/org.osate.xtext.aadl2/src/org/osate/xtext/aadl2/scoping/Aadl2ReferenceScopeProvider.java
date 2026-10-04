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

import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.IScope;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Context;
import org.osate.aadl2.Element;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.Subcomponent;

/**
 * Scopes for existing references used by linking and serialization. Content assist continues to use
 * {@link Aadl2ScopeProvider}, where a completed path element can request candidates for the next path segment.
 *
 * @since 9.1
 */
public class Aadl2ReferenceScopeProvider extends Aadl2ScopeProvider {
	private static final Function<Classifier, Iterable<? extends EObject>> CONNECTION_END_COLLECTOR = //
			classifier -> filterRefined(allConnectionEnds(classifier));

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
