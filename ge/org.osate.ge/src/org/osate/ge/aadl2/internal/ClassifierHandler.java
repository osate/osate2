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
package org.osate.ge.aadl2.internal;

import java.util.Optional;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.businessobjecthandling.CanDeleteContext;
import org.osate.ge.businessobjecthandling.CanRenameContext;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.businessobjecthandling.RenameContext;
import org.osate.ge.internal.services.impl.DeclarativeReferenceType;

public class ClassifierHandler extends AadlBusinessObjectHandler {
	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(Classifier.class).isPresent();
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		return new CanonicalBusinessObjectReference(DeclarativeReferenceType.CLASSIFIER.getId(),
				ctx.getBusinessObject(Classifier.class).get().getQualifiedName());
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		return AadlReferenceUtil
				.getClassifierRelativeReference(ctx.getBusinessObject(Classifier.class).get().getName());
	}

	@Override
	public boolean canDelete(final CanDeleteContext ctx) {
		return true;
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		final Classifier bo = ctx.getBusinessObjectContext().getBusinessObject(Classifier.class).get();
		return Optional.of(GraphicalConfigurationBuilder.create().graphic(AadlGraphics.getGraphic(bo))
				.style(AadlGraphics.getStyle(bo)).build());
	}

	@Override
	public String getName(final GetNameContext ctx) {
		return ctx.getBusinessObject(Classifier.class)
				.map(classifier -> classifier.getName()).orElse("");
	}

	@Override
	public String getNameForRenaming(final GetNameContext ctx) {
		return ctx.getBusinessObject(
				ComponentImplementation.class)
				.map(ci -> ci.getImplementationName()).orElseGet(() -> getName(ctx));
	}

	@Override
	public boolean canRename(final CanRenameContext ctx) {
		return true;
	}

	@Override
	public Optional<String> validateName(final RenameContext ctx) {
		return ctx.getBusinessObject(Classifier.class).map(classifier -> {
			final String newName = ctx.getNewName();
			final String newFullName;
			final String oldName;

			// Transform value so that is is the full name
			if (classifier instanceof ComponentImplementation) {
				final ComponentImplementation ci = (ComponentImplementation) classifier;
				newFullName = ci.getTypeName() + "." + newName;
				oldName = ci.getImplementationName();
			} else {
				newFullName = newName;
				oldName = classifier.getName();
			}

			// If the name hasn't changed or has only changed case
			if (newName.equalsIgnoreCase(oldName)) {
				return null;
			}

			// Check if the value matches the format for AADL identifiers
			if (!AadlNamingUtil.isValidIdentifier(newName)) {
				return "The specified name is not a valid AADL identifier";
			}

			// Check for conflicts in the namespace
			if (AadlNamingUtil.isNameInUse(classifier.getNamespace(), newFullName)) {
				return "The specified name conflicts with an existing member of the namespace.";
			}

			// The value is valid
			return null;
		});
	}
}
