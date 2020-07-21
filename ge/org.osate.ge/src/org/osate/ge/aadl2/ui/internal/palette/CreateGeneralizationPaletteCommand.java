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

import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.TypeExtension;
import org.osate.ge.aadl2.internal.AadlImages;
import org.osate.ge.aadl2.internal.util.AadlImportsUtil;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResult;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.CanStartConnectionContext;
import org.osate.ge.palette.CreateConnectionPaletteCommand;
import org.osate.ge.palette.GetCreateConnectionOperationContext;

public class CreateGeneralizationPaletteCommand extends BasePaletteCommand implements CreateConnectionPaletteCommand {

	public CreateGeneralizationPaletteCommand() {
		super("Extension", AadlPaletteCategories.CLASSIFIERS,
				AadlImages.getImage(Aadl2Package.eINSTANCE.getGeneralization()));

	}

	@Override
	public boolean canStartConnection(final CanStartConnectionContext ctx) {
		return ctx.getSource().getBusinessObject(Classifier.class).map(subtype -> {
			// Determine whether it is a valid starting object
			if (subtype instanceof ComponentType) {
				final ComponentType ct = (ComponentType) subtype;
				return ct.getOwnedExtension() == null;
			} else if (subtype instanceof ComponentImplementation) {
				final ComponentImplementation ci = (ComponentImplementation) subtype;
				return ci.getOwnedExtension() == null;
			} else if (subtype instanceof FeatureGroupType) {
				final FeatureGroupType fgt = (FeatureGroupType) subtype;
				return fgt.getOwnedExtension() == null;
			}

			return false;
		}).orElse(false);
	}

	@Override
	public Optional<Operation> getOperation(final GetCreateConnectionOperationContext ctx) {
		final Object readonlySubtype = ctx.getSource().getBusinessObject();
		final Classifier supertype = ctx.getDestination().getBusinessObject(Classifier.class).orElse(null);

		// Ensure they are valid and are not the same
		if (readonlySubtype == null || supertype == null || readonlySubtype == supertype) {
			return Optional.empty();
		}

		// Rules:
		// Abstract types can be extended by any type.
		// Types can be extended by other types in their category
		// Implementations can extend other implementations with same category and abstract implementation in some cases.
		// Feature Group Types can extend other feature group types
		final boolean canCreate = (readonlySubtype instanceof ComponentType
				&& (supertype instanceof AbstractType || supertype.getClass() == readonlySubtype
				.getClass()))
				|| (readonlySubtype instanceof ComponentImplementation && (supertype instanceof AbstractImplementation
						|| supertype.getClass() == readonlySubtype.getClass()))
				|| (readonlySubtype instanceof FeatureGroupType && supertype instanceof FeatureGroupType);

		if (!canCreate) {
			return Optional.empty();
		}

		return Operation.createSimple(ctx.getSource(), Classifier.class, subtype -> {
			// Import the package if necessary
			if (subtype.getNamespace() instanceof PackageSection
					&& subtype.getNamespace().getOwner() instanceof AadlPackage
					&& supertype.getNamespace() instanceof PackageSection
					&& supertype.getNamespace().getOwner() instanceof AadlPackage) {
				final PackageSection subtypeSection = (PackageSection) subtype.getNamespace();
				final AadlPackage supertypePackage = (AadlPackage) supertype.getNamespace().getOwner();
				AadlImportsUtil.addImportIfNeeded(subtypeSection, supertypePackage);
			}

			// Create the generalization
			final Object newBo;
			if (subtype instanceof ComponentType) {
				final ComponentType ct = (ComponentType) subtype;
				final TypeExtension te = ct.createOwnedExtension();
				te.setExtended((ComponentType) supertype);
				newBo = te;
			} else if (subtype instanceof ComponentImplementation) {
				final ComponentImplementation ci = (ComponentImplementation) subtype;
				final ImplementationExtension ie = ci.createOwnedExtension();
				ie.setExtended((ComponentImplementation) supertype);
				newBo = ie;
			} else if (subtype instanceof FeatureGroupType) {
				final FeatureGroupType fgt = (FeatureGroupType) subtype;
				final GroupExtension ge = fgt.createOwnedExtension();
				ge.setExtended((FeatureGroupType) supertype);
				newBo = ge;
			} else {
				return StepResult.abort();
			}

			return StepResultBuilder.create().showNewBusinessObject(ctx.getSource(), newBo).build();
		});
	}
}
