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
package org.osate.xtext.aadl2.ba.ui.outline;

import java.util.List;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.BackgroundOutlineTreeProvider;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorState;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariable;

/**
 * Customization of the default outline structure.
 *
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#outline
 */
public class BehaviorAnnexOutlineTreeProvider extends BackgroundOutlineTreeProvider {
	@Override
	protected void internalCreateChildren(final IOutlineNode parentNode, final EObject modelElement) {
		if (modelElement instanceof DefaultAnnexSubclause defaultAnnex
				&& defaultAnnex.getParsedAnnexSubclause() instanceof BehaviorAnnex annex) {
			createBehaviorChildren(parentNode, annex);
		} else if (modelElement instanceof BehaviorAnnex annex) {
			createBehaviorChildren(parentNode, annex);
		} else {
			super.internalCreateChildren(parentNode, modelElement);
		}
	}

	private void createBehaviorChildren(final IOutlineNode parentNode, final BehaviorAnnex annex) {
		getTopLevelElements(annex).forEach(element -> createNode(parentNode, element));
	}

	@Override
	protected boolean isLeaf(final EObject modelElement) {
		return modelElement instanceof BehaviorVariable || modelElement instanceof BehaviorState
				|| modelElement instanceof BehaviorTransition || super.isLeaf(modelElement);
	}

	public static List<EObject> getTopLevelElements(final BehaviorAnnex annex) {
		var variables = annex.getVariableGroups()
				.stream()
				.flatMap(group -> group.getVariables().stream())
				.map(EObject.class::cast);
		var states = annex.getStateGroups()
				.stream()
				.flatMap(group -> group.getStates().stream())
				.map(EObject.class::cast);
		var transitions = annex.getTransitions().stream().map(EObject.class::cast);
		return Stream.of(variables, states, transitions).flatMap(stream -> stream).toList();
	}

	public static String getElementName(final EObject element) {
		return switch (element) {
		case BehaviorVariable variable -> variable.getName();
		case BehaviorState state -> state.getName();
		case BehaviorTransition transition -> transition.getName();
		default -> "";
		};
	}
}
