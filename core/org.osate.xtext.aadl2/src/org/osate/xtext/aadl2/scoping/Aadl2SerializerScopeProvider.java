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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Context;
import org.osate.aadl2.PropertyAssociation;

/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 * @since 2.0
 */
public class Aadl2SerializerScopeProvider extends Aadl2ScopeProvider {

	/*
	 * scopeForElementsOfContext is declared in the still-Xtend Aadl2ScopeProvider, so its collector argument has to
	 * stay an Xbase Function1 until that class is migrated.
	 */
	private static final Function1<Classifier, Iterable<? extends EObject>> CONNECTION_END_COLLECTOR = //
			classifier -> filterRefined(allConnectionEnds(classifier));

	// Reference is from ConnectedElement in Aadl2.xtext
	@Override
	public IScope scope_ConnectedElement_connectionEnd(ConnectedElement context, EReference reference) {
		var classifier = EcoreUtil2.getContainerOfType(context, Classifier.class);
		return switch (context.eContainer()) {
		case ConnectedElement previous -> previous.getConnectionEnd() instanceof Context previousContext
				? scopeForElementsOfContext(previousContext, classifier, CONNECTION_END_COLLECTOR)
				: IScope.NULLSCOPE;
		case null, default -> context.getContext() == null
				? scopeFor(filterRefined(allConnectionEnds(classifier)))
				: scopeForElementsOfContext(context.getContext(), classifier, CONNECTION_END_COLLECTOR);
		};
	}

	public IScope scope_ContainmentPathElement_namedElement(ContainmentPathElement context, EReference reference) {
		return switch (context.getOwner()) {
		case ContainmentPathElement previous -> {
			var namespace = getClassifierForPreviousContainmentPathElement(previous);
			yield namespace == null ? IScope.NULLSCOPE : scopeFor(filterRefined(allMembers(namespace)));
		}
		case null, default -> null;
		};
	}

	public IScope scope_ContainmentPathElement_namedElement(ContainedNamedElement context, EReference reference) {
		var propertyAssociation = EcoreUtil2.getContainerOfType(context, PropertyAssociation.class);
		var namespace = namespaceForPropertyAssociation(propertyAssociation);
		return namespace == null ? IScope.NULLSCOPE : scopeFor(filterRefined(allMembers(namespace)));
	}

}
