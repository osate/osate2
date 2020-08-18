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
package org.osate.ge.ba.ui.palette;

import java.util.Objects;
import java.util.Optional;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.PublicPackageSection;
import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorVariable;
import org.osate.ge.aadl2.ui.AadlModelAccessUtil;
import org.osate.ge.ba.ui.dialogs.DataClassifierDescriptionCollectionSingleSelectorModel;
import org.osate.ge.ba.util.BaNamingUtil;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.OperationBuilder;
import org.osate.ge.operations.StepResult;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.GetTargetedOperationContext;
import org.osate.ge.palette.TargetedPaletteCommand;
import org.osate.ge.swt.selectors.FilteringSelectorDialog;
import org.osate.ge.swt.selectors.LabelFilteringListSelectorModel;

public class CreateVariablePaletteCommand extends BasePaletteCommand implements TargetedPaletteCommand {
	public CreateVariablePaletteCommand() {
		super("Variable", BaPaletteContributor.BEHAVIOR_ANNEX, null);
	}

	static class VariableOperation {
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

	static class VariableDialog {
		public static Optional<VariableOperation> show(final Shell shell, final PublicPackageSection section,
				final BehaviorAnnex behaviorAnnex) {
			final Resource resource = behaviorAnnex.eResource();

			final DataClassifierDescriptionCollectionSingleSelectorModel model = new DataClassifierDescriptionCollectionSingleSelectorModel(
					AadlModelAccessUtil.getAllEObjectsByType(resource, Aadl2Package.eINSTANCE.getDataClassifier()));
			if (!FilteringSelectorDialog.open(Display.getCurrent().getActiveShell(),
					"Set the Variable's Data Classifier",
					new LabelFilteringListSelectorModel<>(model))) {
				return Optional.empty();
			}

			final DataClassifier dataClassifier = (DataClassifier) EcoreUtil
					.resolve(model.getSelectedElement().getEObjectOrProxy(), resource);

			return getPackage(dataClassifier)
					.map(pkg -> new VariableOperation(section, behaviorAnnex, dataClassifier, pkg));

//			final ElementSelectionDialog dlg = new ElementSelectionDialog(Display.getDefault().getActiveShell(),
//					"Set Variable Data Classifier", "Select a Data Classifier",
//					AadlModelAccessUtil.getAllEObjectsByType(resource, Aadl2Package.eINSTANCE.getDataClassifier()));
//			if (dlg.open() != Window.OK) {
//				return null;
//			}
//
//			final DataClassifier dataClassifier = (DataClassifier) EcoreUtil
//					.resolve((EObject) dlg.getFirstSelectedElement(), resource);
		}
	}

	@Override
	public Optional<Operation> getOperation(final GetTargetedOperationContext ctx) {
		return ctx.getTarget().getBusinessObject(BehaviorAnnex.class)
				.map(behaviorAnnex -> {
					final PublicPackageSection section = getPackage(behaviorAnnex).map(AadlPackage::getPublicSection)
							.orElse(null);
					if (section == null) {
						return null;
					}

					return Operation.createWithBuilder(builder -> {
						builder.supply(() -> {
							final Optional<VariableOperation> variableOperation = buildCreateOperations(section,
									behaviorAnnex);
							return !variableOperation.isPresent() ? StepResult.abort()
									: StepResult.forValue(variableOperation.get());
						}).executeOperation(variableOp -> Operation.createWithBuilder(innerBuilder -> {
							final OperationBuilder<VariableOperation> opBuilder = innerBuilder.modifyModel(
									variableOp.getPublicSection(), (tag, prevResult) -> tag,
									(tag, sectionToModify, prevResult) -> {
										addImportIfNeeded(sectionToModify, variableOp.getDataClassifierPackage());
										return StepResult.forValue(variableOp);
									});
							opBuilder.modifyModel(variableOp.getBehaviorAnnex(), (tag, prevResult) -> tag,
									(tag, behaviorAnnexToModify, prevResult) -> {
								final BehaviorVariable newVariable = (BehaviorVariable) EcoreUtil
										.create(AadlBaPackage.eINSTANCE.getBehaviorVariable());
								final String newName = BaNamingUtil.buildUniqueIdentifier(behaviorAnnexToModify, "new_variable");
								newVariable.setName(newName);
										newVariable.setDataClassifier(prevResult.getDataClassifier());

								behaviorAnnexToModify.getVariables().add(newVariable);
								return StepResultBuilder.create().showNewBusinessObject(ctx.getTarget(), newVariable)
										.build();
							});
						}));
					});
				});

	}

	private Optional<VariableOperation> buildCreateOperations(final PublicPackageSection section,
			final BehaviorAnnex behaviorAnnex) {
		return VariableDialog.show(Display.getCurrent().getActiveShell(), section, behaviorAnnex);
	}

	public static Optional<AadlPackage> getPackage(final NamedElement element) {
		if (element == null || element.eIsProxy()) {
			return Optional.empty();
		}

		final NamedElement root = element.getElementRoot();
		final AadlPackage pkg = root instanceof AadlPackage ? (AadlPackage) root : null;
		return Optional.ofNullable(pkg);
	}

	/**
	 * Adds an import for pkg to section if it is not already imported.
	 * @param section
	 * @param pkg
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

		//
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
}
