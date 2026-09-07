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
package org.osate.alisa.workbench.scoping;

import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.osate.aadl2.ComponentImplementation;
import org.osate.alisa.common.scoping.CommonScopeProvider;
import org.osate.alisa.workbench.alisa.AssurancePlan;

/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation.html#scoping
 * on how and when to use it
 */
public class AlisaScopeProvider extends CommonScopeProvider {
	public IScope scope_Subcomponent(final AssurancePlan context, final EReference reference) {
		var targetClassifier = context.getTarget();
		if (targetClassifier == null) {
			return IScope.NULLSCOPE;
		}
		var descriptions = Scopes.<EObject> scopedElementsFor(targetClassifier.getAllSubcomponents(),
				QualifiedName.<EObject> wrapper(SimpleAttributeResolver.NAME_RESOLVER));
		return new SimpleScope(IScope.NULLSCOPE, descriptions, false);
	}

	public IScope scope_AssuranceCase_system(final EObject context, final EReference reference) {
		var elements = delegateGetScope(context, reference).getAllElements();
		Iterable<IEObjectDescription> descriptions = () -> StreamSupport.stream(elements.spliterator(), false)
				.map(description -> EObjectDescription.create(description.getName().toString("::"),
						description.getEObjectOrProxy()))
				.iterator();
		return new SimpleScope(descriptions, false);
	}
}
