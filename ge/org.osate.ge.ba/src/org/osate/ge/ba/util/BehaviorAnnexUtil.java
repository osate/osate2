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
package org.osate.ge.ba.util;

import java.util.Optional;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.ge.aadl2.ui.AadlModelAccessUtil;
import org.osate.ge.swt.selectors.FilteringSelectorDialog;
import org.osate.ge.swt.selectors.LabelFilteringListSelectorModel;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexFactory;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorState;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStateGroup;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariable;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariableGroup;

/**
 * Utility class containing miscellaneous helper functions used by the OSATE graphical editor's behavior annex plugin.
 *
 */
public final class BehaviorAnnexUtil {
	/**
	 * Private constructor to prevent instantiation.
	 */
	private BehaviorAnnexUtil() {
	}

	/**
	 * Prompts the user for to select a data classifier
	 * @param resource the resource from which the classifier will be referenced. Used to determine which classifiers may be referenced.
	 * @return an optional containing the selected classifier. Returns an empty optional if a classifier was not selected.
	 */
	public static Optional<DataClassifier> promptForDataClassifier(final Resource resource) {
		final EObjectDescriptionSingleSelectorModel model = new EObjectDescriptionSingleSelectorModel(
				AadlModelAccessUtil.getAllEObjectsByType(resource, Aadl2Package.eINSTANCE.getDataClassifier()));
		if (!FilteringSelectorDialog.open(Display.getCurrent().getActiveShell(), "Set the Variable's Data Classifier",
				new LabelFilteringListSelectorModel<>(model))) {
			return Optional.empty();
		}

		return Optional
				.of((DataClassifier) EcoreUtil.resolve(model.getSelectedElement().getEObjectOrProxy(), resource));
	}

	/**
	 * Return the package containing the specified element
	 * @param e the element for which to get the package
	 * @return the package containing the element. An empty optional is returned if the package cannot be determined.
	 */
	public static Optional<AadlPackage> getPackage(final EObject object) {
		if (object == null) {
			return Optional.empty();
		}

		final NamedElement root = getElementRoot(object);
		final AadlPackage pkg = root instanceof AadlPackage ? (AadlPackage) root : null;
		return Optional.ofNullable(pkg);
	}

	public static NamedElement getElementRoot(final EObject object) {
		final var root = EcoreUtil.getRootContainer(object);
		return root instanceof NamedElement ? (NamedElement) root : null;
	}

	public static Stream<BehaviorState> getStates(final BehaviorAnnex behaviorAnnex) {
		return behaviorAnnex.getStateGroups().stream().flatMap(group -> group.getStates().stream());
	}

	public static Stream<BehaviorVariable> getVariables(final BehaviorAnnex behaviorAnnex) {
		return behaviorAnnex.getVariableGroups().stream().flatMap(group -> group.getVariables().stream());
	}

	public static BehaviorAnnex getBehaviorAnnex(final EObject object) {
		return EcoreUtil2.getContainerOfType(object, BehaviorAnnex.class);
	}

	public static ComponentClassifier getContainingClassifier(final EObject object) {
		final var defaultAnnex = EcoreUtil2.getContainerOfType(object, DefaultAnnexSubclause.class);
		return defaultAnnex != null && defaultAnnex.getContainingClassifier() instanceof ComponentClassifier
				? (ComponentClassifier) defaultAnnex.getContainingClassifier()
				: null;
	}

	public static int getOffset(final EObject object) {
		final var node = NodeModelUtils.findActualNodeFor(object);
		if (node == null) {
			throw new IllegalArgumentException("No node is associated with " + object.eClass().getName());
		}
		return node.getOffset();
	}

	public static BehaviorStateGroup isolateState(final BehaviorState state) {
		final var oldGroup = (BehaviorStateGroup) state.eContainer();
		if (oldGroup.getStates().size() == 1) {
			return oldGroup;
		}

		final var behaviorAnnex = (BehaviorAnnex) oldGroup.eContainer();
		final var newGroup = BehaviorAnnexFactory.eINSTANCE.createBehaviorStateGroup();
		newGroup.setInitial(oldGroup.isInitial());
		newGroup.setComplete(oldGroup.isComplete());
		newGroup.setFinal(oldGroup.isFinal());
		final int index = behaviorAnnex.getStateGroups().indexOf(oldGroup) + 1;
		behaviorAnnex.getStateGroups().add(index, newGroup);
		newGroup.getStates().add(state);
		return newGroup;
	}

	public static BehaviorVariableGroup isolateVariable(final BehaviorVariable variable) {
		final var oldGroup = (BehaviorVariableGroup) variable.eContainer();
		if (oldGroup.getVariables().size() == 1) {
			return oldGroup;
		}

		final var behaviorAnnex = (BehaviorAnnex) oldGroup.eContainer();
		final var newGroup = BehaviorAnnexFactory.eINSTANCE.createBehaviorVariableGroup();
		newGroup.setDataClassifier(oldGroup.getDataClassifier());
		if (oldGroup.getInitialValue() != null) {
			newGroup.setInitialValue(EcoreUtil.copy(oldGroup.getInitialValue()));
		}
		newGroup.getPropertyAssociations().addAll(EcoreUtil.copyAll(oldGroup.getPropertyAssociations()));
		final int index = behaviorAnnex.getVariableGroups().indexOf(oldGroup) + 1;
		behaviorAnnex.getVariableGroups().add(index, newGroup);
		newGroup.getVariables().add(variable);
		return newGroup;
	}
}
