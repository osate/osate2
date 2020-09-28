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

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

import org.eclipse.core.resources.IProject;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.ProjectUtil;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.aadl2.ui.AadlModelAccessUtil;
import org.osate.ge.businessobjecthandling.CanDeleteContext;
import org.osate.ge.businessobjecthandling.CanRenameContext;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.RawDeleteContext;
import org.osate.ge.businessobjecthandling.RawDeleter;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.businessobjecthandling.RenameContext;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.internal.FolderGraphicBuilder;

public class PackageHandler extends AadlBusinessObjectHandler implements RawDeleter {
	private final Graphic graphic = FolderGraphicBuilder.create().build();

	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(AadlPackage.class).isPresent();
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		return AadlReferenceUtil
				.getCanonicalReferenceForPackage(((AadlPackage) ctx.getBusinessObject()).getQualifiedName());
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		return AadlReferenceUtil
				.getRelativeReferenceForPackage(((AadlPackage) ctx.getBusinessObject()).getQualifiedName());
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		return Optional.of(GraphicalConfigurationBuilder.create().
				graphic(graphic).
				build());
	}

	@Override
	public String getName(final GetNameContext ctx) {
		return ctx.getBusinessObject(AadlPackage.class).map(pkg -> pkg.getQualifiedName())
				.orElse("");
	}

	@Override
	public boolean canRename(final CanRenameContext ctx) {
		return true;
	}

	@Override
	public Optional<String> validateName(final RenameContext ctx) {
		return ctx.getBusinessObject(AadlPackage.class).map(pkg -> {
			final String newName = ctx.getNewName();

			// If the name hasn't changed or has only changed case
			final String qualifiedName = pkg.getQualifiedName();
			if (newName.equalsIgnoreCase(qualifiedName)) {
				return null;
			}

			final String[] segments = newName.split("::");
			for (String segment : segments) {
				if (segment.length() == 0) {
					return "One of the segments in the package name is empty.";
				}

				if (!AadlNamingUtil.isValidIdentifier(segment)) {
					return "The segment '" + segment + "' is not valid.";
				}
			}
			// Compare names with other packages
			final IProject project = ProjectUtil.getProjectForBoOrThrow(pkg);
			for (final IEObjectDescription desc : AadlModelAccessUtil.getAllEObjectsByType(project,
					Aadl2Package.eINSTANCE.getAadlPackage())) {
				if (newName.equalsIgnoreCase(desc.getQualifiedName().toString("::"))) {
					return "The specified name conflicts with an existing package.";
				}
			}

			// The value is valid
			return null;
		});
	}

	@Override
	public boolean canDelete(final CanDeleteContext ctx) {
		return ctx.getBusinessObject(AadlPackage.class)
				.map(pkg -> pkg.eResource() != null && !pkg.eResource().getURI().isPlatformPlugin()).orElse(false);
	}

	@Override
	public void delete(final RawDeleteContext ctx) {
		ctx.getBusinessObject(AadlPackage.class).ifPresent(pkg -> {
			try {
				((AadlPackage) pkg).eResource().delete(Collections.emptyMap());
			} catch (final IOException e) {
				throw new RuntimeException(e);
			}
		});
	}
}
