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
package org.osate.ge.ba.util;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Abstract;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.Device;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.Subprogram;
import org.osate.aadl2.Thread;
import org.osate.aadl2.VirtualProcessor;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ge.aadl2.ui.AadlModelAccessUtil;
import org.osate.ge.ba.ui.dialogs.DataClassifierDescriptionModel;
import org.osate.ge.swt.selectors.FilteringSelectorDialog;
import org.osate.ge.swt.selectors.LabelFilteringListSelectorModel;

public class BehaviorAnnexUtil {
	private BehaviorAnnexUtil() {
	}

	/**
	 * Determine if the classifier requires owned BehaviorAnnexes to have a complete BehaviorState
	 */
	public static boolean requiresCompleteState(final Classifier classifier) {
		return classifier instanceof VirtualProcessor || classifier instanceof Thread || classifier instanceof Device;
	}

	/**
	 * Determine if the classifier allows BehaviorTransistions to have on dispatch conditions
	 */
	public static boolean allowsOnDispatchConditions(final Classifier classifier) {
		return classifier instanceof Abstract || classifier instanceof Device || classifier instanceof Thread;
	}

	/**
	 * Determines if the classifier only allows a single initial BehaviorState
	 */
	public static boolean requireSingleInitialState(final Classifier classifier) {
		return classifier instanceof Device || classifier instanceof Thread || classifier instanceof Subprogram
				|| classifier instanceof VirtualProcessor;
	}

	/**
	 * Get all BehaviorTransitions that have the specified BehaviorState as the source state.
	 * @param behaviorState the state to match to a source
	 * @return behavior transitions that have the behavior state as a source
	 */
	public static Stream<BehaviorTransition> getTransitionsForSourceState(final BehaviorState behaviorState) {
		final BehaviorAnnex behaviorAnnex = (BehaviorAnnex) behaviorState.getOwner();
		return behaviorAnnex.getTransitions().stream()
				.filter(behaviorTransition -> behaviorTransition.getSourceState() == behaviorState);
	}

	/**
	 * Prompts the user for to select a data classifier
	 */
	public static Optional<DataClassifier> getDataClassifier(final Resource resource) {
		final DataClassifierDescriptionModel model = new DataClassifierDescriptionModel(
				AadlModelAccessUtil.getAllEObjectsByType(resource, Aadl2Package.eINSTANCE.getDataClassifier()));
		if (!FilteringSelectorDialog.open(Display.getCurrent().getActiveShell(), "Set the Variable's Data Classifier",
				new LabelFilteringListSelectorModel<>(model))) {
			return Optional.empty();
		}

		return Optional
				.of((DataClassifier) EcoreUtil.resolve(model.getSelectedElement().getEObjectOrProxy(), resource));
	}

	/**
	 * Adds an import for package to section if it is not already imported.
	 * @param section the section to add the package to
	 * @param pkg the package to import
	 */
	public static void addImportIfNeeded(final PackageSection section, final AadlPackage pkg) {
		final String pkgQualifiedName = pkg.getQualifiedName();
		if (pkgQualifiedName == null) {
			return;
		}

		// Don't do anything if the package is the owner of the section
		if (section.getOwner() instanceof AadlPackage
				&& pkgQualifiedName.equalsIgnoreCase(((AadlPackage) section.getOwner()).getQualifiedName())) {
			return;
		}

		// Check if package is already imported
		boolean isImported = false;
		for (final ModelUnit mu : section.getImportedUnits()) {
			final String qn = mu.getQualifiedName();
			if (pkgQualifiedName.equalsIgnoreCase(qn)) {
				isImported = true;
				break;
			}
		}

		// Import the package if needed
		if (!isImported) {
			section.getImportedUnits().add(pkg);
		}
	}

	/**
	 * Operation for creating behavior variables
	 */
	public static class VariableOperation {
		private final PublicPackageSection section;
		private final BehaviorAnnex behaviorAnnex;
		private final DataClassifier dataClassifier;
		private final AadlPackage dataClassifierPkg;

		public VariableOperation(final PublicPackageSection section, final BehaviorAnnex behaviorAnnex,
				final DataClassifier dataClassifier, final AadlPackage dataClassifierPkg) {
			this.section = Objects.requireNonNull(section, "section cannot be null");
			this.behaviorAnnex = Objects.requireNonNull(behaviorAnnex, "behavior annex cannot be null");
			this.dataClassifier = Objects.requireNonNull(dataClassifier, "data classifier cannot be null");
			this.dataClassifierPkg = Objects.requireNonNull(dataClassifierPkg,
					"data classifier package cannot be null");
		}

		public BehaviorAnnex getBehaviorAnnex() {
			return behaviorAnnex;
		}

		public PublicPackageSection getPublicSection() {
			return section;
		}

		public DataClassifier getDataClassifier() {
			return dataClassifier;
		}

		public AadlPackage getDataClassifierPackage() {
			return dataClassifierPkg;
		}
	}

	/**
	 * Show dialog to select a data classifier for behavior variables
	 */
	static class VariableDialog {
		public static Optional<VariableOperation> show(final Shell shell, final PublicPackageSection section,
				final BehaviorAnnex behaviorAnnex) {
			final Resource resource = behaviorAnnex.eResource();
			return BehaviorAnnexUtil.getDataClassifier(resource).map(dataClassifier -> getPackage(dataClassifier)
					.map(pkg -> new VariableOperation(section, behaviorAnnex, dataClassifier, pkg)).orElse(null));
		}
	}

	/**
	 * Prompt user for data classifier and get information needed for creating new behavior variable
	 * @return the operation that contains the information for creating behavior variables
	 */
	public static Optional<VariableOperation> getVariableBuildOperation(final PublicPackageSection section,
			final BehaviorAnnex behaviorAnnex) {
		return VariableDialog.show(Display.getCurrent().getActiveShell(), section, behaviorAnnex);
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
