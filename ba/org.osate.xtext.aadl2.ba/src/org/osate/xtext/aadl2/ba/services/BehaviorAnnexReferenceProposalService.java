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
package org.osate.xtext.aadl2.ba.services;

import java.util.List;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.NamedElement;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement;

/**
 * Computes case-insensitive first-segment proposals for the symbolic BA {@code Reference} rules. The same service is
 * used by Eclipse and generic IDE/LSP completion so both environments expose the same model-aware candidates.
 */
public final class BehaviorAnnexReferenceProposalService {
	public List<String> getRootProposals(final EObject context) {
		var names = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		names.add("self");

		var annex = context instanceof BehaviorAnnex behaviorAnnex ? behaviorAnnex
				: EcoreUtil2.getContainerOfType(context, BehaviorAnnex.class);
		if (annex == null) {
			return List.copyOf(names);
		}

		annex.getVariableGroups()
				.stream()
				.flatMap(group -> group.getVariables().stream())
				.map(variable -> variable.getName())
				.forEach(names::add);

		for (var current = context; current != null && current != annex; current = current.eContainer()) {
			if (current instanceof ForStatement statement && statement.getVariable() != null) {
				names.add(statement.getVariable());
			}
		}

		if (annex.getContainingClassifier() instanceof ComponentClassifier owner) {
			addNames(names, owner.getAllFeatures());
			addNames(names, owner.getAllModes());
			addNames(names, owner.getAllPrototypes());
			if (owner instanceof ComponentImplementation implementation) {
				addNames(names, implementation.getAllSubcomponents());
			}
		}
		return List.copyOf(names);
	}

	private static void addNames(final TreeSet<String> names, final Iterable<? extends NamedElement> elements) {
		for (var element : elements) {
			if (element.getName() != null) {
				names.add(element.getName());
			}
		}
	}
}
