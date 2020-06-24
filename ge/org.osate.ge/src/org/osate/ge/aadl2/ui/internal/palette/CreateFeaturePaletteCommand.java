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
package org.osate.ge.aadl2.ui.internal.palette;

import java.util.Optional;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Access;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.NamedElement;
import org.osate.ge.DockingPosition;
import org.osate.ge.StringUtil;
import org.osate.ge.aadl2.internal.AadlImages;
import org.osate.ge.aadl2.internal.AadlNamingUtil;
import org.osate.ge.aadl2.internal.util.AadlFeatureUtil;
import org.osate.ge.aadl2.ui.AadlOperationBuilder;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.TargetedPaletteCommand;
import org.osate.ge.palette.GetTargetedOperationContext;

public class CreateFeaturePaletteCommand extends BasePaletteCommand implements TargetedPaletteCommand {
	private final EClass featureType;

	public CreateFeaturePaletteCommand(final EClass featureType) {
		super(StringUtil.camelCaseToUser(featureType.getName()),
				AadlPaletteCategories.FEATURES,
				AadlImages.getImage(featureType));
		this.featureType = featureType;
	}

	@Override
	public Optional<Operation> getOperation(final GetTargetedOperationContext ctx) {
		return ctx.getTarget().getBusinessObject(EObject.class).map(targetBo -> {
			final AadlOperationBuilder<Classifier> opBuilder = AadlOperationBuilder.classifiers()
					.filter(c -> AadlFeatureUtil.canOwnFeatureType(c, featureType));
			if (!opBuilder.canBuildOperation(targetBo)) {
				return null;
			}

			return Operation.createWithBuilder(createOp -> {
				// Create the feature
				opBuilder.buildOperation(createOp, targetBo).modifyPreviousResult(owner -> {
					final String newFeatureName = AadlNamingUtil.buildUniqueIdentifier(owner, "new_feature");

					final NamedElement newFeature = AadlFeatureUtil.createFeature(owner, featureType);
					newFeature.setName(newFeatureName);

					// Set in or out based on target docking position
					final boolean isRight = ctx.getDockingPosition() == DockingPosition.RIGHT;
					if (newFeature instanceof DirectedFeature) {
						if (!(newFeature instanceof FeatureGroup)) {
							final DirectedFeature newDirectedFeature = (DirectedFeature) newFeature;
							newDirectedFeature.setIn(!isRight);
							newDirectedFeature.setOut(isRight);
						}
					} else if (newFeature instanceof Access) {
						final Access access = (Access) newFeature;
						access.setKind(isRight ? AccessType.PROVIDES : AccessType.REQUIRES);
					}

					if (owner instanceof ComponentType) {
						((ComponentType) owner).setNoFeatures(false);
					}

					return StepResultBuilder.create().showNewBusinessObject(ctx.getTarget(), newFeature).build();
				});
			});
		});
	}
}
