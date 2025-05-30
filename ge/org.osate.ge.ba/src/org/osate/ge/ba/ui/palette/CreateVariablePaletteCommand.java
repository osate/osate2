/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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

import static org.osate.ge.ba.util.BehaviorAnnexUtil.getPackage;

import java.util.Optional;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.PublicPackageSection;
import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorVariable;
import org.osate.ge.aadl2.AadlImportsUtil;
import org.osate.ge.ba.util.BehaviorAnnexNamingUtil;
import org.osate.ge.ba.util.BehaviorAnnexUtil;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.OperationBuilder;
import org.osate.ge.operations.StepResult;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.GetTargetedOperationContext;
import org.osate.ge.palette.TargetedPaletteCommand;

/**
 * Palette command for creating {@link BehaviorVariable} elements.
 */
public class CreateVariablePaletteCommand extends BasePaletteCommand implements TargetedPaletteCommand {
	/**
	 * Creates a new instance
	 */
	public CreateVariablePaletteCommand() {
		super("Behavior Variable", BehaviorAnnexPaletteContributor.BEHAVIOR_ANNEX_CATEGORY_ID, null);
	}

	@Override
	public Optional<Operation> getOperation(final GetTargetedOperationContext ctx) {
		return ctx.getTarget().getBusinessObject(BehaviorAnnex.class).map(behaviorAnnex -> {
			final PublicPackageSection section = getPackage(behaviorAnnex).map(AadlPackage::getPublicSection)
					.orElse(null);
			if (section == null) {
				return null;
			}

			return Operation.createWithBuilder(builder -> {
				final OperationBuilder<DataClassifier> prompt = builder
						.supply(() -> BehaviorAnnexUtil.promptForDataClassifier(behaviorAnnex.eResource())
							.filter(c -> BehaviorAnnexUtil.getPackage(c).isPresent())
							.map(StepResult::forValue)
								.orElseGet(StepResult::abort));

				final OperationBuilder<DataClassifier> addImportIfNeeded = prompt.modifyModel(null,
						(tag, prevResult) -> section, (tag, sectionToModify, dataClassifier) -> {
							BehaviorAnnexUtil.getPackage(dataClassifier)
									.ifPresent(classifierPkg -> AadlImportsUtil.addImportIfNeeded(sectionToModify,
											classifierPkg));
							return StepResult.forValue(dataClassifier);
						});

				addImportIfNeeded.modifyModel(null, (tag, dataClassifier) -> behaviorAnnex,
						(tag, behaviorAnnexToModify, prevResult) -> {
							final BehaviorVariable newVariable = (BehaviorVariable) EcoreUtil
									.create(AadlBaPackage.eINSTANCE.getBehaviorVariable());
							final String newName = BehaviorAnnexNamingUtil.buildUniqueIdentifier(behaviorAnnexToModify,
									"new_behavior_variable");
							newVariable.setName(newName);

							newVariable.setDataClassifier(prevResult);

							behaviorAnnexToModify.getVariables().add(newVariable);
							return StepResultBuilder.create()
									.showNewBusinessObject(ctx.getTarget(), newVariable)
									.build();
						});
			});
		});
	}
}
