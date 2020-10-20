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
package org.osate.ge.errormodel;

import java.util.Optional;

import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.DockingPosition;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.aadl2.GraphicalExtensionUtil;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.CanCopyContext;
import org.osate.ge.businessobjecthandling.CanDeleteContext;
import org.osate.ge.businessobjecthandling.CanRenameContext;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.businessobjecthandling.RenameContext;
import org.osate.ge.errormodel.util.ErrorModelNamingUtil;
import org.osate.ge.graphics.Dimension;
import org.osate.ge.graphics.EllipseBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;

public class PropagationPointHandler implements BusinessObjectHandler {
	private static final Graphic graphic = EllipseBuilder.create().fixedSize(new Dimension(16, 16)).build();

	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(PropagationPoint.class).filter(bo -> bo.getContainingClassifier() != null)
				.isPresent();
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		final PropagationPoint bo = ctx.getBusinessObject(PropagationPoint.class).get();
		return new CanonicalBusinessObjectReference(ErrorModelReferenceUtil.TYPE_PROPAGATION_POINT,
				ctx.getReferenceBuilder().getCanonicalReference(bo.getContainingClassifier()).encode(), bo.getName());
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		return ErrorModelReferenceUtil
				.getRelativeReferenceForPropagationPoint(ctx.getBusinessObject(PropagationPoint.class).get().getName());
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
		// Determine style
		final StyleBuilder sb = StyleBuilder.create(GraphicalExtensionUtil.isInherited(ctx.getBusinessObjectContext())
				? GraphicalExtensionUtil.STYLE_INHERITED_ELEMENT
				: Style.EMPTY).labelsAboveTop().labelsLeft();

		return Optional
				.of(GraphicalConfigurationBuilder.create().graphic(graphic).style(sb.build())
						.defaultDockingPosition(DockingPosition.ANY).build());
	}

	@Override
	public String getName(final GetNameContext ctx) {
		return ctx.getBusinessObject(PropagationPoint.class).map(bo -> bo.getName()).orElse("");
	}

	@Override
	public boolean canRename(final CanRenameContext ctx) {
		return true;
	}

	@Override
	public Optional<String> validateName(final RenameContext ctx) {
		return ErrorModelNamingUtil.validateSubclauseChildName(ctx);
	}
}
