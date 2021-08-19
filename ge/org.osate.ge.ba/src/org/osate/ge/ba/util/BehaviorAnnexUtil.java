/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.NamedElement;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ge.aadl2.ui.AadlModelAccessUtil;
import org.osate.ge.ba.ui.dialogs.EObjectDescriptionSingleSelectorModel;
import org.osate.ge.swt.selectors.FilteringSelectorDialog;
import org.osate.ge.swt.selectors.LabelFilteringListSelectorModel;

/**
 * Utility class for {@link BehaviorAnnex} support
 */
public class BehaviorAnnexUtil {
	private BehaviorAnnexUtil() {
	}

	/**
	 * Prompts the user for to select a data classifier
	 */
	public static Optional<DataClassifier> getDataClassifier(final Resource resource) {
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
	 * Show dialog to select a data classifier for behavior variables
	 */
	static class DataClassifierDialog {
		public static Optional<DataClassifier> show(final BehaviorAnnex behaviorAnnex) {
			final Resource resource = behaviorAnnex.eResource();
			return BehaviorAnnexUtil.getDataClassifier(resource).filter(dc -> getPackage(dc).isPresent());
		}
	}

	/**
	 * Prompt user for data classifier
	 * @return the selected data classifier
	 */
	public static Optional<DataClassifier> getVariableDataClassifier(final BehaviorAnnex behaviorAnnex) {
		return DataClassifierDialog.show(behaviorAnnex);
	}

	/**
	 * Return the package of the specified named element
	 */
	public static Optional<AadlPackage> getPackage(final NamedElement ne) {
		if (ne == null) {
			return Optional.empty();
		}

		final NamedElement root = ne.getElementRoot();
		final AadlPackage pkg = root instanceof AadlPackage ? (AadlPackage) root : null;
		return Optional.ofNullable(pkg);
	}
}
