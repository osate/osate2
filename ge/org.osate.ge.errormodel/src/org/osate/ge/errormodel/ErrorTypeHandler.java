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
package org.osate.ge.errormodel;

import java.util.Optional;

import org.osate.aadl2.AadlPackage;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.CanCopyContext;
import org.osate.ge.businessobjecthandling.CanDeleteContext;
import org.osate.ge.businessobjecthandling.CanRenameContext;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.businessobjecthandling.RenameContext;
import org.osate.ge.errormodel.util.ErrorModelGeUtil;
import org.osate.ge.errormodel.util.ErrorModelNamingUtil;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

/**
 * Business object handler for {@link ErrorType} objects.
 */
public class ErrorTypeHandler implements BusinessObjectHandler {
	private static final Graphic graphic = RectangleBuilder.create().build();

	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(ErrorType.class).filter(bo -> bo.getElementRoot() instanceof AadlPackage)
				.isPresent();
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		final ErrorType bo = ctx.getBusinessObject(ErrorType.class).get();
		return new CanonicalBusinessObjectReference(
				ErrorModelReferenceUtil.TYPE_ERROR_TYPE,
				ctx.getReferenceBuilder().getCanonicalReference(bo.getElementRoot()).encode(),
				bo.getName());
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		return ErrorModelReferenceUtil
				.getRelativeReferenceForErrorType(ctx.getBusinessObject(ErrorType.class).get().getName());
	}

	@Override
	public boolean canDelete(final CanDeleteContext ctx) {
		return true;
	}

	@Override
	public boolean canCopy(final CanCopyContext ctx) {
		return false;
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		return Optional.of(GraphicalConfigurationBuilder.create().graphic(graphic)
				.annotation("<Error Type>")
				.style(ErrorModelGeUtil.TOP_CENTERED_LABEL_STYLE).build());
	}

	@Override
	public String getName(final GetNameContext ctx) {
		return ctx.getBusinessObject(ErrorType.class).map(bo -> bo.getName()).orElse("");
	}

	@Override
	public boolean canRename(final CanRenameContext ctx) {
		return true;
	}

	@Override
	public Optional<String> validateName(final RenameContext ctx) {
		return ctx.getBusinessObject(ErrorType.class).map(errorType -> {
			final ErrorModelLibrary errorModelLibrary = (ErrorModelLibrary) errorType.eContainer();
			return ErrorModelNamingUtil.validateName(errorModelLibrary, errorType.getName(), ctx.getNewName());
		});
	}
}
